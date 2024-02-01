package com.xiaopeng.xuimanager.awareness;

import android.annotation.SystemApi;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.ArraySet;
import android.util.Log;
import com.xiaopeng.xuimanager.XUIManager;
import com.xiaopeng.xuimanager.XUIManagerBase;
import com.xiaopeng.xuimanager.XUIServiceNotConnectedException;
import com.xiaopeng.xuimanager.awareness.IAwareness;
import com.xiaopeng.xuimanager.awareness.IAwarenessEventListener;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;

@SystemApi
/* loaded from: classes.dex */
public class AwarenessManager implements XUIManagerBase {
    public static final boolean DBG = true;
    private static final int MSG_AWARENESS_ERROR_EVENT = 0;
    public static final String TAG = "AwarenessManager";
    private static String mServiceName = null;
    private final Handler mHandler;
    private IAwareness mService;
    private final ArraySet<AwarenessEventListener> mListeners = new ArraySet<>();
    private AwarenessEventListenerToService mListenerToService = null;

    /* loaded from: classes.dex */
    public interface AwarenessEventListener {
        void onErrorEvent(int i, int i2);
    }

    /* loaded from: classes.dex */
    private static final class EventCallbackHandler extends Handler {
        WeakReference<AwarenessManager> mMgr;

        EventCallbackHandler(AwarenessManager mgr, Looper looper) {
            super(looper);
            this.mMgr = new WeakReference<>(mgr);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                AwarenessManager mgr = this.mMgr.get();
                if (mgr != null) {
                    mgr.dispatchErrorEventToClient(((Integer) msg.obj).intValue(), msg.arg1);
                    return;
                }
                return;
            }
            Log.e(AwarenessManager.TAG, "Event type not handled?" + msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class AwarenessEventListenerToService extends IAwarenessEventListener.Stub {
        private final WeakReference<AwarenessManager> mManager;

        public AwarenessEventListenerToService(AwarenessManager manager) {
            this.mManager = new WeakReference<>(manager);
        }

        @Override // com.xiaopeng.xuimanager.awareness.IAwarenessEventListener
        public void onError(int errorCode, int operation) {
            AwarenessManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleErrorEvent(errorCode, operation);
            }
        }
    }

    public AwarenessManager(IBinder service, Context context, Handler handler) {
        this.mService = IAwareness.Stub.asInterface(service);
        this.mHandler = new EventCallbackHandler(this, handler.getLooper());
    }

    public synchronized void registerListener(AwarenessEventListener listener) throws XUIServiceNotConnectedException {
        if (this.mListeners.isEmpty()) {
            try {
                this.mListenerToService = new AwarenessEventListenerToService(this);
                this.mService.registerListener(this.mListenerToService);
            } catch (RemoteException ex) {
                Log.e(TAG, "Could not connect: " + ex.toString());
                throw new XUIServiceNotConnectedException(ex);
            } catch (IllegalStateException ex2) {
                XUIManager.checkXUIServiceNotConnectedExceptionFromXUIService(ex2);
            }
        }
        this.mListeners.add(listener);
    }

    public synchronized void unregisterListener(AwarenessEventListener listener) throws XUIServiceNotConnectedException {
        Log.d(TAG, "unregisterListener");
        this.mListeners.remove(listener);
        if (this.mListeners.isEmpty()) {
            try {
                this.mService.unregisterListener(this.mListenerToService);
                this.mListenerToService = null;
            } catch (RemoteException e) {
                Log.e(TAG, "Could not unregister: " + e.toString());
                throw new XUIServiceNotConnectedException(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchErrorEventToClient(int errorCode, int operation) {
        Collection<AwarenessEventListener> listeners;
        synchronized (this) {
            listeners = this.mListeners;
        }
        if (!listeners.isEmpty()) {
            for (AwarenessEventListener l : listeners) {
                l.onErrorEvent(errorCode, operation);
            }
            return;
        }
        Log.e(TAG, "Listener is null, not dispatching event.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleErrorEvent(int errorCode, int operation) {
        Message message = this.mHandler.obtainMessage();
        message.what = 0;
        message.obj = Integer.valueOf(errorCode);
        message.arg1 = operation;
        this.mHandler.sendMessage(message);
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIDisconnected() {
        Iterator<AwarenessEventListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            AwarenessEventListener l = it.next();
            try {
                unregisterListener(l);
            } catch (XUIServiceNotConnectedException e) {
            }
        }
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIConnected(IBinder service) {
        this.mService = IAwareness.Stub.asInterface(service);
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void setServiceName(String name) {
        mServiceName = name;
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public String getServiceName() {
        if (mServiceName == null) {
            mServiceName = getClass().getSimpleName();
        }
        return mServiceName;
    }
}
