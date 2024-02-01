package com.xiaopeng.xuimanager.alsaplayer;

import android.annotation.SystemApi;
import android.content.Context;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.ArraySet;
import android.util.Log;
import com.xiaopeng.xuimanager.XUIManagerBase;
import com.xiaopeng.xuimanager.alsaplayer.IXuiAlsaPlayer;
import com.xiaopeng.xuimanager.alsaplayer.IXuiAlsaPlayerEventListener;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
@SystemApi
/* loaded from: classes.dex */
public class XuiAlsaPlayerManager implements XUIManagerBase {
    public static final String MEDIA_LOOPBACK = "MediaLoopback";
    private static final int MSG_CHANGE_EVENT = 1;
    private static final int MSG_ERROR_EVENT = 0;
    public static final String PATH_OFF = "=OFF";
    public static final String PATH_ON = "=ON";
    public static final int PERMISSION_EVENT = 1;
    public static final int PLAY_EVENT = 0;
    public static final String RELEASE_PERMISSION = "release";
    public static final String REQUEST_PERMISSION = "request";
    public static final String START_PLAY = "start";
    public static final String STOP_PLAY = "stop";
    public static final String SYSTEM_LOOPBACK = "SystemLoopback";
    public static final String TAG = "XuiAlsaPlayerManager";
    private String callingApp;
    private AlsaPlayerCallback mAlsaPlayerCallback;
    private final Handler mHandler;
    private IXuiAlsaPlayer mService;
    private final ArraySet<AlsaPlayerCallback> mListeners = new ArraySet<>();
    private IXuiAlsaPlayerEventListener mListenerToService = null;

    public XuiAlsaPlayerManager(IBinder service, Context context, Handler handler) {
        this.mService = IXuiAlsaPlayer.Stub.asInterface(service);
        this.mHandler = new EventCallbackHandler(this, handler.getLooper());
        this.callingApp = context.getPackageManager().getNameForUid(Binder.getCallingUid());
    }

    /* loaded from: classes.dex */
    public interface AlsaPlayerCallback {
        default void onAlsaPlayerChangeEvent(int event, String value) {
        }

        default void onError(int errorCode, int operation) {
        }
    }

    /* loaded from: classes.dex */
    private static class AlsaPlayerEventListenerToService extends IXuiAlsaPlayerEventListener.Stub {
        private final WeakReference<XuiAlsaPlayerManager> mManager;

        public AlsaPlayerEventListenerToService(XuiAlsaPlayerManager manager) {
            this.mManager = new WeakReference<>(manager);
        }

        @Override // com.xiaopeng.xuimanager.alsaplayer.IXuiAlsaPlayerEventListener
        public void onAlsaPlayerChangeEvent(int event, String value) {
            XuiAlsaPlayerManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleChangeEvent(event, value);
            }
        }

        @Override // com.xiaopeng.xuimanager.alsaplayer.IXuiAlsaPlayerEventListener
        public void onError(int errorCode, int operation) {
            XuiAlsaPlayerManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleErrorEvent(errorCode, operation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleChangeEvent(int event, String value) {
        Message message = this.mHandler.obtainMessage();
        message.what = 1;
        message.arg1 = event;
        message.obj = value;
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleErrorEvent(int errorCode, int operation) {
        Message message = this.mHandler.obtainMessage();
        message.what = 0;
        message.obj = Integer.valueOf(errorCode);
        message.arg1 = operation;
        this.mHandler.sendMessage(message);
    }

    /* loaded from: classes.dex */
    private static final class EventCallbackHandler extends Handler {
        WeakReference<XuiAlsaPlayerManager> mMgr;

        EventCallbackHandler(XuiAlsaPlayerManager mgr, Looper looper) {
            super(looper);
            this.mMgr = new WeakReference<>(mgr);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    XuiAlsaPlayerManager mgr = this.mMgr.get();
                    if (mgr != null) {
                        mgr.dispatchErrorEventToClient(((Integer) msg.obj).intValue(), msg.arg1);
                        return;
                    }
                    return;
                case 1:
                    XuiAlsaPlayerManager mgr2 = this.mMgr.get();
                    if (mgr2 != null) {
                        mgr2.dispatchEventToClient(msg.arg1, (String) msg.obj);
                        return;
                    }
                    return;
                default:
                    Log.e(XuiAlsaPlayerManager.TAG, "Event type not handled " + msg);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchEventToClient(int event, String value) {
        Log.d(TAG, "dispatchEventToClient event:" + event + " value:" + value);
        if (this.mAlsaPlayerCallback != null) {
            this.mAlsaPlayerCallback.onAlsaPlayerChangeEvent(event, value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchErrorEventToClient(int errorCode, int operation) {
        Collection<AlsaPlayerCallback> listeners;
        synchronized (this) {
            listeners = this.mListeners;
        }
        if (!listeners.isEmpty()) {
            for (AlsaPlayerCallback l : listeners) {
                l.onError(errorCode, operation);
            }
            return;
        }
        Log.e(TAG, "Listener died, not dispatching event.");
    }

    public int registerListener(AlsaPlayerCallback callBackFunc) throws RemoteException {
        this.mAlsaPlayerCallback = callBackFunc;
        try {
            if (this.mListenerToService == null) {
                this.mListenerToService = new AlsaPlayerEventListenerToService(this);
            }
            this.mService.registerListener(this.mListenerToService);
            this.mListeners.add(callBackFunc);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int unregisterListener(AlsaPlayerCallback listener) throws RemoteException {
        this.mAlsaPlayerCallback = null;
        try {
            this.mService.unregisterListener(this.mListenerToService);
            this.mListeners.remove(listener);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mListenerToService = null;
        return 0;
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIConnected(IBinder service) {
        this.mService = IXuiAlsaPlayer.Stub.asInterface(service);
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIDisconnected() {
        try {
            Iterator<AlsaPlayerCallback> it = this.mListeners.iterator();
            while (it.hasNext()) {
                AlsaPlayerCallback cb = it.next();
                unregisterListener(cb);
            }
        } catch (Exception e) {
            Log.e(TAG, "onXUIDisconnected " + e);
        }
    }

    public int startPlay() {
        if (this.mService == null) {
            return -1;
        }
        try {
            this.mService.startPlay(this.callingApp);
            return 0;
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int stopPlay() {
        if (this.mService == null) {
            return -1;
        }
        try {
            this.mService.stopPlay(this.callingApp);
            return 0;
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int writeData(byte[] data, int offset, int size) {
        if (this.mService == null) {
            return -1;
        }
        try {
            this.mService.writeData(this.callingApp, data, offset, size);
            return 0;
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int setCaptureParameter(int card, int device, int sampleRate, int channel, int periodSize, int periodCount) {
        if (this.mService == null) {
            return -1;
        }
        try {
            this.mService.setCaptureParameter(this.callingApp, card, device, sampleRate, channel, periodSize, periodCount);
            return 0;
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int setPlaybackParameter(int card, int device, int sampleRate, int channel, int periodSize, int periodCount) {
        if (this.mService == null) {
            return -1;
        }
        try {
            this.mService.setPlaybackParameter(this.callingApp, card, device, sampleRate, channel, periodSize, periodCount);
            return 0;
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int resetRouteAndUpdatePath(String pathType, String enable) {
        if (this.mService == null) {
            return -1;
        }
        try {
            this.mService.resetRouteAndUpdatePath(this.callingApp, pathType, enable);
            return 0;
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
