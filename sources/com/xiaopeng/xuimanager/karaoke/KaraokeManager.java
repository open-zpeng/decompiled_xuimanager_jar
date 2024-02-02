package com.xiaopeng.xuimanager.karaoke;

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
import com.xiaopeng.xuimanager.XUIServiceNotConnectedException;
import com.xiaopeng.xuimanager.karaoke.IKaraoke;
import com.xiaopeng.xuimanager.karaoke.IKaraokeEventListener;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
@SystemApi
/* loaded from: classes.dex */
public class KaraokeManager implements XUIManagerBase {
    public static final boolean DBG = true;
    private static final int MSG_KARAOKE_ERROR_EVENT = 0;
    private static final int MSG_KARAOKE_EVENT = 1;
    public static final String TAG = "KaraokeManager";
    private static String mServiceName = null;
    private String callingApp;
    private final Context mContext;
    private final Handler mHandler;
    private MicCallBack mMicCallBack;
    private IKaraoke mService;
    private final IBinder mICallBack = new Binder();
    private final ArraySet<MicCallBack> mListeners = new ArraySet<>();
    private KaraokeEventListenerToService mListenerToService = null;

    /* loaded from: classes.dex */
    public interface MicCallBack {
        public static final int MIC_POWER_OFF = 6;
        public static final int MIC_POWER_ON = 5;
        public static final int UDB_DONGLE_OFF = 4;
        public static final int UDB_DONGLE_ON = 3;

        void micServiceCallBack(int i);

        void onErrorEvent(int i, int i2);
    }

    /* loaded from: classes.dex */
    private static final class EventCallbackHandler extends Handler {
        WeakReference<KaraokeManager> mMgr;

        EventCallbackHandler(KaraokeManager mgr, Looper looper) {
            super(looper);
            this.mMgr = new WeakReference<>(mgr);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    KaraokeManager mgr = this.mMgr.get();
                    if (mgr != null) {
                        mgr.dispatchErrorEventToClient(((Integer) msg.obj).intValue(), msg.arg1);
                        return;
                    }
                    return;
                case 1:
                    KaraokeManager mgr2 = this.mMgr.get();
                    if (mgr2 != null) {
                        mgr2.dispatchEventToClient(msg.arg1);
                        return;
                    }
                    return;
                default:
                    Log.e(KaraokeManager.TAG, "Event type not handled?" + msg);
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    private static class KaraokeEventListenerToService extends IKaraokeEventListener.Stub {
        private final WeakReference<KaraokeManager> mManager;

        public KaraokeEventListenerToService(KaraokeManager manager) {
            this.mManager = new WeakReference<>(manager);
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraokeEventListener
        public void onError(int errorCode, int operation) {
            KaraokeManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleErrorEvent(errorCode, operation);
            }
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraokeEventListener
        public void MicDevChangeCallBack(int event) {
            KaraokeManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleEvent(event);
            }
        }
    }

    public KaraokeManager(IBinder service, Context context, Handler handler) {
        this.mService = IKaraoke.Stub.asInterface(service);
        this.mContext = context;
        this.mHandler = new EventCallbackHandler(this, handler.getLooper());
        this.callingApp = context.getPackageManager().getNameForUid(Binder.getCallingUid());
    }

    public synchronized void registerListener(MicCallBack listener) throws XUIServiceNotConnectedException {
        this.mListeners.add(listener);
    }

    public synchronized void unregisterListener(MicCallBack listener) throws XUIServiceNotConnectedException {
        Log.d(TAG, "unregisterListener");
        this.mListeners.remove(listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchErrorEventToClient(int errorCode, int operation) {
        Collection<MicCallBack> listeners;
        synchronized (this) {
            listeners = this.mListeners;
        }
        if (!listeners.isEmpty()) {
            for (MicCallBack l : listeners) {
                l.onErrorEvent(errorCode, operation);
            }
            return;
        }
        Log.e(TAG, "Listener died, not dispatching event.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchEventToClient(int event) {
        Log.d(TAG, "dispatchEventToClient  event:" + event + "  mMicCallBack:" + this.mMicCallBack);
        if (this.mMicCallBack != null) {
            this.mMicCallBack.micServiceCallBack(event);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleErrorEvent(int errorCode, int operation) {
        Message message = this.mHandler.obtainMessage();
        message.what = 0;
        message.obj = Integer.valueOf(errorCode);
        message.arg1 = operation;
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleEvent(int event) {
        Message message = this.mHandler.obtainMessage();
        message.what = 1;
        message.arg1 = event;
        this.mHandler.sendMessage(message);
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIDisconnected() {
        Iterator<MicCallBack> it = this.mListeners.iterator();
        while (it.hasNext()) {
            MicCallBack l = it.next();
            try {
                unregisterListener(l);
            } catch (XUIServiceNotConnectedException e) {
            }
        }
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIConnected(IBinder service) {
        this.mService = IKaraoke.Stub.asInterface(service);
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

    public int XMA_registerCallback(MicCallBack callBackFunc) throws RemoteException {
        this.mMicCallBack = callBackFunc;
        try {
            if (this.mListenerToService == null) {
                this.mListenerToService = new KaraokeEventListenerToService(this);
            }
            this.mService.XMS_RegisterCallback(this.callingApp, this.mListenerToService);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int XMA_unRegisterCallback() throws RemoteException {
        this.mMicCallBack = null;
        try {
            this.mService.XMS_UnRegisterCallback(this.callingApp, this.mListenerToService);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mListenerToService = null;
        return 0;
    }

    public int XMA_init(String pkgName) {
        if (this.mService == null) {
            return -1;
        }
        try {
            Log.d(TAG, "XMA_init  " + pkgName);
            this.mService.XMS_Create(this.callingApp, 0, "", this.mICallBack);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int XMA_deinit() {
        if (this.mService == null) {
            return -1;
        }
        try {
            this.mService.XMS_Distroy(this.callingApp);
            return 0;
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int XMA_getToken() {
        if (this.mContext != null) {
            this.callingApp = this.mContext.getPackageManager().getNameForUid(Binder.getCallingUid());
        }
        if (this.mService == null) {
            return -1;
        }
        try {
            int token = this.mService.XMS_GetToken(this.callingApp);
            return token;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_getSignedToken(String sToken) {
        if (this.mService == null) {
            return -1;
        }
        try {
            this.mService.XMS_SetSignedToken(this.callingApp, sToken);
            return 0;
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int XMA_getHandShakeStatus() {
        if (this.mService == null) {
            return -1;
        }
        try {
            int status = this.mService.XMS_GetHandShakeStatus(this.callingApp);
            return status;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_getMicStatus() {
        if (this.mService == null) {
            return -1;
        }
        try {
            int status = this.mService.XMS_GetMicStatus(this.callingApp);
            return status;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_getMicPowerStatus() {
        if (this.mService == null) {
            return -1;
        }
        try {
            int status = this.mService.XMS_GetMicPowerStatus(this.callingApp);
            return status;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_setVolume(int type, int vol) {
        if (this.mService == null) {
            return -1;
        }
        try {
            this.mService.XMS_SetVolume(this.callingApp, type, vol);
            return 0;
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int XMA_getVolume(int type) {
        if (this.mService == null) {
            return -1;
        }
        try {
            int vol = this.mService.XMS_GetVolume(this.callingApp, type);
            return vol;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_trackGetMinBuf(int sampleRate, int channel) {
        if (this.mService == null) {
            return -1;
        }
        try {
            int buf = this.mService.XMS_TrackGetMinBuf(this.callingApp, sampleRate, channel);
            return buf;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_trackCreate(int sampleRate, int channel, int bufSize) {
        if (this.mService == null) {
            return -1;
        }
        try {
            this.mService.XMS_TrackCreate(this.callingApp, sampleRate, channel, bufSize);
            return 0;
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int XMA_trackGetLatency() {
        if (this.mService == null) {
            return -1;
        }
        try {
            int buf = this.mService.XMS_TrackGetLatency(this.callingApp);
            return buf;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_write(byte[] data, int off, int size) {
        if (this.mService == null) {
            return -1;
        }
        try {
            int ret = this.mService.XMS_Write(this.callingApp, data, off, size);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_trackDestroy() {
        if (this.mService == null) {
            return -1;
        }
        try {
            int ret = this.mService.XMS_TrackDestroy(this.callingApp);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_pause() {
        if (this.mService == null) {
            return -1;
        }
        try {
            int ret = this.mService.XMS_Pause(this.callingApp);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_resume() {
        if (this.mService == null) {
            return -1;
        }
        try {
            int ret = this.mService.XMS_Resume(this.callingApp);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_pausePlay() {
        if (this.mService == null) {
            return -1;
        }
        try {
            int ret = this.mService.XMS_PausePlay(this.callingApp);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_resumePlay() {
        if (this.mService == null) {
            return -1;
        }
        try {
            int ret = this.mService.XMS_ResumePlay(this.callingApp);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_recGetMinBuf(int sampleRate, int channel) {
        if (this.mService == null) {
            return -1;
        }
        try {
            int ret = this.mService.XMS_RecGetMinBuf(this.callingApp, sampleRate, channel);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_recCreate(int sampleRate, int channel, int bufSize) {
        if (this.mService == null) {
            return -1;
        }
        try {
            int ret = this.mService.XMS_RecCreate(this.callingApp, sampleRate, channel, bufSize);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_recGetAvail() {
        if (this.mService == null) {
            return -1;
        }
        try {
            int ret = this.mService.XMS_RecGetAvail(this.callingApp);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_readRec(byte[] data) {
        if (this.mService == null) {
            return -1;
        }
        try {
            int ret = this.mService.XMS_Read(this.callingApp, data, -1);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_recDestroy() {
        if (this.mService == null) {
            return -1;
        }
        try {
            int ret = this.mService.XMS_RecDestroy(this.callingApp);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_micGetMinBuf(int sampleRate, int channel) {
        if (this.mService == null) {
            return -1;
        }
        try {
            int ret = this.mService.XMS_MicGetMinBuf(this.callingApp, sampleRate, channel);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_micCreate(int sampleRate, int channel, int bufSize) {
        if (this.mService == null) {
            return -1;
        }
        try {
            int ret = this.mService.XMS_MicCreate(this.callingApp, sampleRate, channel, bufSize);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_micGetAvail() {
        if (this.mService == null) {
            return -1;
        }
        try {
            int ret = this.mService.XMS_MicGetAvail(this.callingApp);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_readMic(byte[] data) {
        if (this.mService == null) {
            return -1;
        }
        try {
            int ret = this.mService.XMS_MicRead(this.callingApp, data, -1);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_micDestroy() {
        if (this.mService == null) {
            return -1;
        }
        try {
            int ret = this.mService.XMS_MicDestroy(this.callingApp);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_atlSwitch(boolean enable) {
        if (this.mService == null) {
            return -1;
        }
        try {
            int ret = this.mService.XMS_atlSwitch(enable);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_aiWakeUp() {
        if (this.mService == null) {
            return -1;
        }
        try {
            int ret = this.mService.XMS_aiWakeUp();
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public boolean XMA_hasAtl() {
        if (this.mService == null) {
            return false;
        }
        try {
            boolean ret = this.mService.XMS_hasAtl();
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void XMA_setAtlEnable(boolean enable) {
        if (this.mService != null) {
            try {
                this.mService.XMS_setAtlEnable(enable);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean XMA_isAtlEnabled() {
        if (this.mService == null) {
            return false;
        }
        try {
            boolean ret = this.mService.XMS_isAtlEnabled();
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String XMA_getMicName() {
        if (this.mService == null) {
            return "";
        }
        try {
            String ret = this.mService.XMS_getMicName();
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String XMA_getBuyMicUrl() {
        if (this.mService == null) {
            return "https://www.xiaopeng.com/";
        }
        try {
            String retvalue = this.mService.XMS_getBuyMicUrl();
            return retvalue;
        } catch (RemoteException e) {
            e.printStackTrace();
            return "https://www.xiaopeng.com/";
        }
    }

    public void XMA_connectMicFlow() {
        if (this.mService != null) {
            try {
                this.mService.XMS_connectMicFlow();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void XMA_ShowToast(String text) {
        if (this.mService != null) {
            try {
                this.mService.XMS_ShowToast(text);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int XMA_setMusicInfo(String[] musicInfo) {
        if (this.mService != null) {
            try {
                return this.mService.XMS_setMusicInfo(musicInfo);
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    public int XMA_setMusicLyric(String[] lyric) {
        if (this.mService != null) {
            try {
                return this.mService.XMS_setMusicLyric(lyric);
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }
}
