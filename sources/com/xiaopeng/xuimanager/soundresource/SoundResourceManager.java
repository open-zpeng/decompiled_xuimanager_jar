package com.xiaopeng.xuimanager.soundresource;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.ArraySet;
import android.util.Log;
import com.xiaopeng.xuimanager.XUIManagerBase;
import com.xiaopeng.xuimanager.soundresource.ISoundResource;
import com.xiaopeng.xuimanager.soundresource.ISoundResourceListener;
import com.xiaopeng.xuimanager.soundresource.data.BootSoundResource;
import com.xiaopeng.xuimanager.soundresource.data.SoundEffectResource;
import com.xiaopeng.xuimanager.soundresource.data.SoundEffectTheme;
import java.util.Iterator;

/* loaded from: classes.dex */
public class SoundResourceManager implements XUIManagerBase {
    private static final int MSG_RESOURCE_EVENT = 1;
    public static final int SOUND_RESOURCE_AI_PUSH = 8;
    public static final int SOUND_RESOURCE_BREAK_PRESS_READY = 7;
    public static final int SOUND_RESOURCE_COMMON_HINT_1 = 4;
    public static final int SOUND_RESOURCE_COMMON_HINT_2 = 5;
    public static final int SOUND_RESOURCE_DRIVE_MODE = 6;
    public static final int SOUND_RESOURCE_EVENT_BOOT_SOUND_SWITCH = 100;
    public static final int SOUND_RESOURCE_EVENT_READY_ALL = 1000;
    public static final int SOUND_RESOURCE_EVENT_THEME_SWITCH = 1;
    public static final int SOUND_RESOURCE_NO_SEATBELT = 2;
    public static final int SOUND_RESOURCE_PREVIEW_SWITCH = 11;
    public static final int SOUND_RESOURCE_PREVIEW_TOUCH = 10;
    public static final int SOUND_RESOURCE_RADAR = 3;
    public static final int SOUND_RESOURCE_SYSTEM_EFFECT = 9;
    public static final int SOUND_RESOURCE_TURN_SIGNAL = 1;
    private static final String TAG = SoundResourceManager.class.getSimpleName();
    private static String mServiceName = null;
    private Handler mHandler;
    private final ArraySet<SoundResourceListener> mListeners;
    private ISoundResource mService;
    private boolean serverDisconnected;
    private SoundResourceListenerImpl soundResourceListenerImpl;

    /* loaded from: classes.dex */
    public interface SoundResourceListener {
        void onResourceEvent(int i, int i2);
    }

    /* loaded from: classes.dex */
    private static class SoundResourceListenerImpl extends ISoundResourceListener.Stub {
        private Handler mHandler;

        public SoundResourceListenerImpl(Handler handler) {
            this.mHandler = handler;
        }

        @Override // com.xiaopeng.xuimanager.soundresource.ISoundResourceListener
        public void onResourceEvent(int resId, int event) throws RemoteException {
            this.mHandler.obtainMessage(1, resId, event).sendToTarget();
        }
    }

    /* loaded from: classes.dex */
    private static class SoundResourceManagerHolder {
        private static final SoundResourceManager instance = new SoundResourceManager();

        private SoundResourceManagerHolder() {
        }
    }

    private SoundResourceManager() {
        this.serverDisconnected = false;
        this.mService = null;
        this.mListeners = new ArraySet<>();
        this.soundResourceListenerImpl = null;
    }

    public static SoundResourceManager getInstance() {
        return SoundResourceManagerHolder.instance;
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIDisconnected() {
        Log.d(TAG, "onXUIDisconnected");
        synchronized (this.mListeners) {
            this.mListeners.clear();
        }
        SoundResourceListenerImpl soundResourceListenerImpl = this.soundResourceListenerImpl;
        if (soundResourceListenerImpl != null) {
            try {
                this.mService.unRegisterListener(soundResourceListenerImpl);
            } catch (RemoteException e) {
                String str = TAG;
                Log.e(str, "onXUIDisconnected,unregisterListener e=" + e);
            }
            this.soundResourceListenerImpl = null;
        }
        this.mHandler = null;
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIConnected(IBinder service) {
        if (!this.serverDisconnected) {
            return;
        }
        this.serverDisconnected = false;
        this.mService = ISoundResource.Stub.asInterface(service);
        SoundResourceListenerImpl soundResourceListenerImpl = this.soundResourceListenerImpl;
        if (soundResourceListenerImpl != null) {
            try {
                this.mService.registerListener(soundResourceListenerImpl);
            } catch (Exception e) {
                String str = TAG;
                Log.e(str, "onXUIConnected e=" + e);
            }
        }
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

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onServerDisconnected() {
        Log.i(TAG, "onServerDisconnected");
        this.serverDisconnected = true;
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void init(IBinder service, Context context, Handler handler) {
        String str = TAG;
        Log.d(str, "create UserScenarioManager,context=" + context + ",handler=" + handler);
        this.mService = ISoundResource.Stub.asInterface(service);
        this.mHandler = new Handler(handler.getLooper()) { // from class: com.xiaopeng.xuimanager.soundresource.SoundResourceManager.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                String str2 = SoundResourceManager.TAG;
                Log.d(str2, "handle msg:" + msg.what);
                if (msg.what == 1) {
                    SoundResourceManager.this.handleEventMessage(msg);
                }
            }
        };
    }

    public SoundEffectTheme[] getAvailableThemes() {
        SoundEffectTheme[] result = null;
        try {
            result = this.mService.getAvailableThemes();
        } catch (Exception e) {
            String str = TAG;
            Log.w(str, "getAvailableThemes e=" + e);
        }
        String str2 = TAG;
        Log.i(str2, "getAvailableThemes,r=" + result);
        return result;
    }

    public int getActiveSoundEffectTheme() {
        int id = -1;
        try {
            id = this.mService.getActiveSoundEffectTheme();
        } catch (Exception e) {
            String str = TAG;
            Log.w(str, "getActiveSoundEffectTheme e=" + e);
        }
        String str2 = TAG;
        Log.d(str2, "getActiveSoundEffectTheme,id=" + id);
        return id;
    }

    public int selectSoundEffectTheme(int themeId) {
        int ret = -1;
        try {
            ret = this.mService.selectSoundEffectTheme(themeId);
        } catch (Exception e) {
            String str = TAG;
            Log.w(str, "selectSoundEffectTheme e=" + e);
        }
        String str2 = TAG;
        Log.d(str2, "selectSoundEffectTheme,ret=" + ret);
        return ret;
    }

    public SoundEffectResource[] getSoundEffectPlayResource(int themeId) {
        SoundEffectResource[] result = null;
        try {
            result = this.mService.getSoundEffectPlayResource(themeId);
        } catch (Exception e) {
            String str = TAG;
            Log.w(str, "getSoundEffectPlayResource e=" + e);
        }
        String str2 = TAG;
        Log.i(str2, "getSoundEffectPlayResource,r=" + result);
        return result;
    }

    public SoundEffectResource[] getSoundEffectPreviewResource(int themeId) {
        SoundEffectResource[] result = null;
        try {
            result = this.mService.getSoundEffectPreviewResource(themeId);
        } catch (Exception e) {
            String str = TAG;
            Log.w(str, "getSoundEffectPreviewResource e=" + e);
        }
        String str2 = TAG;
        Log.i(str2, "getSoundEffectPreviewResource,r=" + result);
        return result;
    }

    public SoundEffectResource getActiveSoundEffectResource(int effectType) {
        SoundEffectResource res = null;
        try {
            res = this.mService.getActiveSoundEffectResource(effectType);
        } catch (Exception e) {
            String str = TAG;
            Log.w(str, "getActiveSoundEffectResource e=" + e);
        }
        String str2 = TAG;
        Log.i(str2, "getActiveSoundEffectResource, res=" + res);
        return res;
    }

    public int setBootSoundOnOff(boolean flag) {
        int ret = -1;
        try {
            ret = this.mService.setBootSoundOnOff(flag);
        } catch (Exception e) {
            String str = TAG;
            Log.w(str, "setBootSoundOnOff e=" + e);
        }
        String str2 = TAG;
        Log.i(str2, "setBootSoundOnOff,ret=" + ret);
        return ret;
    }

    public int getBootSoundOnOff() {
        int onOff = -1;
        try {
            onOff = this.mService.getBootSoundOnOff();
        } catch (Exception e) {
            String str = TAG;
            Log.w(str, "getBootSoundOnOff e=" + e);
        }
        String str2 = TAG;
        Log.i(str2, "getBootSoundOnOff,onOff=" + onOff);
        return onOff;
    }

    public BootSoundResource[] getBootSoundResource() {
        BootSoundResource[] result = null;
        try {
            result = this.mService.getBootSoundResource();
        } catch (Exception e) {
            String str = TAG;
            Log.w(str, "getBootSoundResource e=" + e);
        }
        String str2 = TAG;
        Log.i(str2, "getBootSoundResource,r=" + result);
        return result;
    }

    public int setBootSoundResource(int resourceId) {
        int ret = -1;
        try {
            ret = this.mService.setBootSoundResource(resourceId);
        } catch (Exception e) {
            String str = TAG;
            Log.w(str, "setBootSoundResource e=" + e);
        }
        String str2 = TAG;
        Log.i(str2, "setBootSoundResource,ret=" + ret);
        return ret;
    }

    public BootSoundResource getActiveBootSoundResource() {
        BootSoundResource res = null;
        try {
            res = this.mService.getActiveBootSoundResource();
        } catch (Exception e) {
            String str = TAG;
            Log.w(str, "getActiveBootSoundResource e=" + e);
        }
        String str2 = TAG;
        Log.i(str2, "getActiveBootSoundResource,r=" + res);
        return res;
    }

    public synchronized void registerListener(SoundResourceListener listener) {
        String str = TAG;
        Log.i(str, "registerListener:" + listener);
        if (listener == null) {
            Log.w(TAG, "registerListener null!");
            return;
        }
        if (this.soundResourceListenerImpl == null) {
            this.soundResourceListenerImpl = new SoundResourceListenerImpl(this.mHandler);
            try {
                this.mService.registerListener(this.soundResourceListenerImpl);
            } catch (Exception e) {
                String str2 = TAG;
                Log.w(str2, "registerListener e=" + e);
            }
        }
        synchronized (this.mListeners) {
            this.mListeners.add(listener);
        }
    }

    public synchronized void unRegisterListener(SoundResourceListener listener) {
        String str = TAG;
        Log.i(str, "unRegisterListener:" + listener);
        synchronized (this.mListeners) {
            this.mListeners.remove(listener);
        }
        if (this.mListeners.isEmpty()) {
            try {
                this.mService.unRegisterListener(this.soundResourceListenerImpl);
            } catch (RemoteException e) {
                String str2 = TAG;
                Log.e(str2, "unregisterListener e=" + e);
            }
            this.soundResourceListenerImpl = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleEventMessage(Message msg) {
        String str = TAG;
        Log.d(str, "handleEventMessage:" + msg.what);
        if (msg.what == 1) {
            dispatchResourceEvent(msg.arg1, msg.arg2);
        }
    }

    private void dispatchResourceEvent(int resId, int event) {
        synchronized (this.mListeners) {
            Iterator<SoundResourceListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                SoundResourceListener l = it.next();
                l.onResourceEvent(resId, event);
            }
        }
    }
}
