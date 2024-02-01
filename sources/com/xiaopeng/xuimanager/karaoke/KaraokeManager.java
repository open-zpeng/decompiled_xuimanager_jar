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
import java.util.HashMap;
import java.util.Iterator;

@SystemApi
/* loaded from: classes.dex */
public class KaraokeManager implements XUIManagerBase {
    public static final boolean DBG = true;
    public static final int KARAOKE_ECHO = 2;
    public static final int KARAOKE_MIC_EFFECT = 4;
    public static final int KARAOKE_MIC_VOLUME = 1;
    public static final int KARAOKE_MUSIC_VOLUME = 0;
    public static final int KARAOKE_REVERBERATION = 3;
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

        default void volumeEffectCallBack(int type, int value) {
        }
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
            int i = msg.what;
            if (i == 0) {
                KaraokeManager mgr = this.mMgr.get();
                if (mgr != null) {
                    mgr.dispatchErrorEventToClient(((Integer) msg.obj).intValue(), msg.arg1);
                }
            } else if (i == 1) {
                KaraokeManager mgr2 = this.mMgr.get();
                if (mgr2 != null) {
                    mgr2.dispatchEventToClient(msg.arg1, msg.arg2);
                }
            } else {
                Log.e(KaraokeManager.TAG, "Event type not handled?" + msg);
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

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraokeEventListener
        public void volumeEffectCallBack(int type, int value) {
            KaraokeManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleVolumeEvent(type, value);
            }
        }
    }

    public KaraokeManager(IBinder service, Context context, Handler handler) {
        this.mService = IKaraoke.Stub.asInterface(service);
        this.mContext = context;
        this.mHandler = new EventCallbackHandler(this, handler.getLooper());
        this.callingApp = context.getPackageManager().getNameForUid(Binder.getCallingUid());
    }

    public void setCallingAppPkg(String pkg) {
        this.callingApp = pkg;
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
    public void dispatchEventToClient(int event, int value) {
        Log.d(TAG, "dispatchEventToClient  event:" + event + " value:" + value + "  mMicCallBack:" + this.mMicCallBack);
        MicCallBack micCallBack = this.mMicCallBack;
        if (micCallBack != null) {
            if (value < 0) {
                micCallBack.micServiceCallBack(event);
            } else {
                micCallBack.volumeEffectCallBack(event, value);
            }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void handleVolumeEvent(int event, int value) {
        Message message = this.mHandler.obtainMessage();
        message.what = 1;
        message.arg1 = event;
        message.arg2 = value;
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
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return -1;
        }
        try {
            iKaraoke.XMS_Distroy(this.callingApp);
            return 0;
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int XMA_getToken() {
        Context context = this.mContext;
        if (context != null) {
            this.callingApp = context.getPackageManager().getNameForUid(Binder.getCallingUid());
        }
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return -1;
        }
        try {
            int token = iKaraoke.XMS_GetToken(this.callingApp);
            return token;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_getSignedToken(String sToken) {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return -1;
        }
        try {
            iKaraoke.XMS_SetSignedToken(this.callingApp, sToken);
            return 0;
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int XMA_getHandShakeStatus() {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return -1;
        }
        try {
            int status = iKaraoke.XMS_GetHandShakeStatus(this.callingApp);
            return status;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_getMicStatus() {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return -1;
        }
        try {
            int status = iKaraoke.XMS_GetMicStatus(this.callingApp);
            return status;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_getMicPowerStatus() {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return -1;
        }
        try {
            int status = iKaraoke.XMS_GetMicPowerStatus(this.callingApp);
            return status;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_setVolume(int type, int vol) {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return -1;
        }
        try {
            iKaraoke.XMS_SetVolume(this.callingApp, type, vol);
            return 0;
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int XMA_setEcho(int echo) {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return -1;
        }
        try {
            iKaraoke.XMS_SetEcho(this.callingApp, echo);
            return 0;
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int XMA_getVolume(int type) {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return -1;
        }
        try {
            int vol = iKaraoke.XMS_GetVolume(this.callingApp, type);
            return vol;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_getEcho() {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return -1;
        }
        try {
            int echo = iKaraoke.XMS_GetEcho(this.callingApp);
            return echo;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_trackGetMinBuf(int sampleRate, int channel) {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return -1;
        }
        try {
            int buf = iKaraoke.XMS_TrackGetMinBuf(this.callingApp, sampleRate, channel);
            return buf;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_trackCreate(int sampleRate, int channel, int bufSize) {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return -1;
        }
        try {
            iKaraoke.XMS_TrackCreate(this.callingApp, sampleRate, channel, bufSize);
            return 0;
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int XMA_trackGetLatency() {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return -1;
        }
        try {
            int buf = iKaraoke.XMS_TrackGetLatency(this.callingApp);
            return buf;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_write(byte[] data, int off, int size) {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return -1;
        }
        try {
            int ret = iKaraoke.XMS_Write(this.callingApp, data, off, size);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_trackDestroy() {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return -1;
        }
        try {
            int ret = iKaraoke.XMS_TrackDestroy(this.callingApp);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_pause() {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return -1;
        }
        try {
            int ret = iKaraoke.XMS_Pause(this.callingApp);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_resume() {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return -1;
        }
        try {
            int ret = iKaraoke.XMS_Resume(this.callingApp);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_pausePlay() {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return -1;
        }
        try {
            int ret = iKaraoke.XMS_PausePlay(this.callingApp);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_resumePlay() {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return -1;
        }
        try {
            int ret = iKaraoke.XMS_ResumePlay(this.callingApp);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_recGetMinBuf(int sampleRate, int channel) {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return -1;
        }
        try {
            int ret = iKaraoke.XMS_RecGetMinBuf(this.callingApp, sampleRate, channel);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_recCreate(int sampleRate, int channel, int bufSize) {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return -1;
        }
        try {
            int ret = iKaraoke.XMS_RecCreate(this.callingApp, sampleRate, channel, bufSize);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_recGetAvail() {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return -1;
        }
        try {
            int ret = iKaraoke.XMS_RecGetAvail(this.callingApp);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_readRec(byte[] data) {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return -1;
        }
        try {
            int ret = iKaraoke.XMS_Read(this.callingApp, data, -1);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_recDestroy() {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return -1;
        }
        try {
            int ret = iKaraoke.XMS_RecDestroy(this.callingApp);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_micGetMinBuf(int sampleRate, int channel) {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return -1;
        }
        try {
            int ret = iKaraoke.XMS_MicGetMinBuf(this.callingApp, sampleRate, channel);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_micCreate(int sampleRate, int channel, int bufSize) {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return -1;
        }
        try {
            int ret = iKaraoke.XMS_MicCreate(this.callingApp, sampleRate, channel, bufSize);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_micGetAvail() {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return -1;
        }
        try {
            int ret = iKaraoke.XMS_MicGetAvail(this.callingApp);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_readMic(byte[] data) {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return -1;
        }
        try {
            int ret = iKaraoke.XMS_MicRead(this.callingApp, data, -1);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_micDestroy() {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return -1;
        }
        try {
            int ret = iKaraoke.XMS_MicDestroy(this.callingApp);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_atlSwitch(boolean enable) {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return -1;
        }
        try {
            int ret = iKaraoke.XMS_atlSwitch(enable);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int XMA_aiWakeUp() {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return -1;
        }
        try {
            int ret = iKaraoke.XMS_aiWakeUp();
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public boolean XMA_hasAtl() {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return false;
        }
        try {
            boolean ret = iKaraoke.XMS_hasAtl();
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void XMA_setAtlEnable(boolean enable) {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke != null) {
            try {
                iKaraoke.XMS_setAtlEnable(enable);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean XMA_isAtlEnabled() {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return false;
        }
        try {
            boolean ret = iKaraoke.XMS_isAtlEnabled();
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String XMA_getMicName() {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return "";
        }
        try {
            String ret = iKaraoke.XMS_getMicName();
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String XMA_getBuyMicUrl() {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return "https://www.xiaopeng.com/";
        }
        try {
            String retvalue = iKaraoke.XMS_getBuyMicUrl();
            return retvalue;
        } catch (RemoteException e) {
            e.printStackTrace();
            return "https://www.xiaopeng.com/";
        }
    }

    public void XMA_connectMicFlow() {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke != null) {
            try {
                iKaraoke.XMS_connectMicFlow();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void XMA_ShowToast(String text) {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke != null) {
            try {
                iKaraoke.XMS_ShowToast(text);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int XMA_setMusicInfo(String[] musicInfo) {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke != null) {
            try {
                return iKaraoke.XMS_setMusicInfo(musicInfo);
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    public int XMA_setMusicLyric(String[] lyric) {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke != null) {
            try {
                return iKaraoke.XMS_setMusicLyric(lyric);
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    public int XMA_clientDied() {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return 0;
        }
        try {
            int ret = iKaraoke.XMS_clientDied();
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public HashMap<String, Integer> XMA_getMicSoundEffectMap() {
        HashMap<String, Integer> ret = new HashMap<>();
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke != null) {
            try {
                return new HashMap<>(iKaraoke.XMS_getMicSoundEffectMap());
            } catch (RemoteException e) {
                e.printStackTrace();
                return ret;
            }
        }
        return ret;
    }

    public int XMA_requestKaraokeResource(String pkgName, int sampleRate, int channel, int bufferSize) {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return 0;
        }
        try {
            int ret = iKaraoke.XMS_requestKaraokeResource(pkgName, sampleRate, channel, bufferSize);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int XMA_requestKaraokeResource(String pkgName) {
        return XMA_requestKaraokeResource(pkgName, 48000, 2, XMA_micGetMinBuf(48000, 2));
    }

    public int XMA_releaseKaraokeResource(String pkgName) {
        IKaraoke iKaraoke = this.mService;
        if (iKaraoke == null) {
            return 0;
        }
        try {
            int ret = iKaraoke.XMS_releaseKaraokeResource(pkgName);
            return ret;
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
