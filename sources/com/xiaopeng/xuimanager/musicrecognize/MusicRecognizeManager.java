package com.xiaopeng.xuimanager.musicrecognize;

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
import com.xiaopeng.xuimanager.musicrecognize.IMusicRecognize;
import com.xiaopeng.xuimanager.musicrecognize.IMusicRecognizeEventListener;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;

@SystemApi
/* loaded from: classes.dex */
public class MusicRecognizeManager implements XUIManagerBase {
    public static final boolean DBG = true;
    private static final int MODE_HUMMING = 2;
    private static final int MODE_ORIGINAL_SOUND = 1;
    private static final int MSG_MUSICRECOGNIZE_ERROR_EVENT = 0;
    private static final int MSG_MUSICRECOGNIZE_FINDCOVER_EVENT = 1;
    private static final int MSG_MUSICRECOGNIZE_RECOGNIZE_EVENT = 2;
    public static final String TAG = "MusicRecognizeManager";
    private static String mServiceName = null;
    private final Handler mHandler;
    private IMusicRecognize mService;
    private final ArraySet<MusicRecognizeEventListener> mListeners = new ArraySet<>();
    private MusicRecognizeEventListenerToService mListenerToService = null;

    /* loaded from: classes.dex */
    public interface MusicRecognizeEventListener {
        void onErrorEvent(int i, int i2);

        void onFindCoverEvent(String str);

        void onRecognizeEvent(MusicRecognizeEvent musicRecognizeEvent);
    }

    /* loaded from: classes.dex */
    private static final class EventCallbackHandler extends Handler {
        WeakReference<MusicRecognizeManager> mMgr;

        EventCallbackHandler(MusicRecognizeManager mgr, Looper looper) {
            super(looper);
            this.mMgr = new WeakReference<>(mgr);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            MusicRecognizeManager mgr = this.mMgr.get();
            int i = msg.what;
            if (i == 0) {
                if (mgr != null) {
                    mgr.dispatchErrorEventToClient(((Integer) msg.obj).intValue(), msg.arg1);
                }
            } else if (i == 1) {
                if (mgr != null) {
                    mgr.dispatchFindCoverEventToClient((String) msg.obj);
                }
            } else if (i == 2) {
                if (mgr != null) {
                    mgr.dispatchRecognizeEventToClient((MusicRecognizeEvent) msg.obj);
                }
            } else {
                Log.e(MusicRecognizeManager.TAG, "Event type not handled?" + msg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class MusicRecognizeEventListenerToService extends IMusicRecognizeEventListener.Stub {
        private final WeakReference<MusicRecognizeManager> mManager;

        public MusicRecognizeEventListenerToService(MusicRecognizeManager manager) {
            this.mManager = new WeakReference<>(manager);
        }

        @Override // com.xiaopeng.xuimanager.musicrecognize.IMusicRecognizeEventListener
        public void onFindCoverEvent(String coverUrl) {
            MusicRecognizeManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleFindCoverEvent(coverUrl);
            }
        }

        @Override // com.xiaopeng.xuimanager.musicrecognize.IMusicRecognizeEventListener
        public void onRecognizeEvent(MusicRecognizeEvent event) {
            MusicRecognizeManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleRecognizeEvent(event);
            }
        }

        @Override // com.xiaopeng.xuimanager.musicrecognize.IMusicRecognizeEventListener
        public void onError(int errorCode, int operation) {
            MusicRecognizeManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleErrorEvent(errorCode, operation);
            }
        }
    }

    public MusicRecognizeManager(IBinder service, Context context, Handler handler) {
        this.mService = IMusicRecognize.Stub.asInterface(service);
        this.mHandler = new EventCallbackHandler(this, handler.getLooper());
    }

    public synchronized void registerListener(MusicRecognizeEventListener listener) throws XUIServiceNotConnectedException {
        if (this.mListeners.isEmpty()) {
            try {
                this.mListenerToService = new MusicRecognizeEventListenerToService(this);
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

    public synchronized void unregisterListener(MusicRecognizeEventListener listener) throws XUIServiceNotConnectedException {
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
    public void dispatchFindCoverEventToClient(String coverUrl) {
        Collection<MusicRecognizeEventListener> listeners;
        synchronized (this) {
            listeners = this.mListeners;
        }
        if (!listeners.isEmpty()) {
            for (MusicRecognizeEventListener l : listeners) {
                l.onFindCoverEvent(coverUrl);
            }
            return;
        }
        Log.e(TAG, "Listener died, not dispatching event.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchRecognizeEventToClient(MusicRecognizeEvent event) {
        Collection<MusicRecognizeEventListener> listeners;
        synchronized (this) {
            listeners = this.mListeners;
        }
        if (!listeners.isEmpty()) {
            for (MusicRecognizeEventListener l : listeners) {
                l.onRecognizeEvent(event);
            }
            return;
        }
        Log.e(TAG, "Listener is null, not dispatching event.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchErrorEventToClient(int errorCode, int operation) {
        Collection<MusicRecognizeEventListener> listeners;
        synchronized (this) {
            listeners = this.mListeners;
        }
        if (!listeners.isEmpty()) {
            for (MusicRecognizeEventListener l : listeners) {
                l.onErrorEvent(errorCode, operation);
            }
            return;
        }
        Log.e(TAG, "Listener is null, not dispatching event.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFindCoverEvent(String coverUrl) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(1, coverUrl));
    }

    public void handleRecognizeEvent(MusicRecognizeEvent event) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(2, event));
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
        Iterator<MusicRecognizeEventListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            MusicRecognizeEventListener l = it.next();
            try {
                unregisterListener(l);
            } catch (XUIServiceNotConnectedException e) {
            }
        }
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIConnected(IBinder service) {
        this.mService = IMusicRecognize.Stub.asInterface(service);
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

    public void start() throws XUIServiceNotConnectedException {
        Log.d(TAG, "start()");
        try {
            this.mService.start();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not start: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void stop() throws XUIServiceNotConnectedException {
        Log.d(TAG, "stop()");
        try {
            this.mService.stop();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not stop: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void stopAndRecognize() throws XUIServiceNotConnectedException {
        Log.d(TAG, "stopAndRecognize()");
        try {
            this.mService.stopAndRecognize();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not stopAndRecognize: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setMode(int mode) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setMode()");
        try {
            this.mService.setMode(mode);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setMode: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int getMode() throws XUIServiceNotConnectedException {
        Log.d(TAG, "getMode()");
        try {
            return this.mService.getMode();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getMode: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setMinScore(float score) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setMinScore()");
        try {
            this.mService.setMinScore(score);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setMinScore: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public float getMinScore() throws XUIServiceNotConnectedException {
        Log.d(TAG, "getMinScore()");
        try {
            return this.mService.getMinScore();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getMinScore: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void findSongCover(String songName) throws XUIServiceNotConnectedException {
        Log.d(TAG, "getMinScore()");
        try {
            this.mService.findSongCover(songName);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getMinScore: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }
}
