package com.xiaopeng.xuimanager.smart;

import android.annotation.SystemApi;
import android.content.Context;
import android.os.Bundle;
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
import com.xiaopeng.xuimanager.smart.ISmart;
import com.xiaopeng.xuimanager.smart.ISmartCommonEventListener;
import com.xiaopeng.xuimanager.smart.ISmartEventListener;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.List;

@SystemApi
/* loaded from: classes.dex */
public class SmartManager implements XUIManagerBase {
    public static final int ALARM_VOLUME_HIGH = 2;
    public static final int ALARM_VOLUME_LOW = 0;
    public static final int ALARM_VOLUME_MIDDLE = 1;
    public static final int AVAS_SOUND_EFFECT_A = 1;
    public static final int AVAS_SOUND_EFFECT_B = 2;
    public static final int AVAS_SOUND_EFFECT_C = 3;
    public static final int BOOT_SOUND_EFFECT_A = 1;
    public static final int BOOT_SOUND_EFFECT_B = 2;
    public static final int BOOT_SOUND_EFFECT_C = 3;
    public static final int BOOT_SOUND_EFFECT_DISABLE = 0;
    public static final int COMMON_TYPE_AI_LLU = 4096;
    public static final boolean DBG = true;
    public static final String EFFECT_AC_CHARGE = "android_ac";
    public static final String EFFECT_AWAKE = "android_unlock_01";
    public static final String EFFECT_DC_CHARGE = "android_dc";
    public static final String EFFECT_FIND_CAR = "android_findcar";
    public static final String EFFECT_FULL_CHARGED = "fullcharged";
    public static final String EFFECT_LOCK = "android_lock";
    public static final String EFFECT_LOCK_01 = "android_lock_01";
    public static final String EFFECT_LOCK_02 = "android_lock_02";
    public static final String EFFECT_LOCK_03 = "android_lock_03";
    public static final String EFFECT_SAYHI = "android_sayhi";
    public static final String EFFECT_SAYHI_01 = "android_sayhi_01";
    public static final String EFFECT_SAYHI_02 = "android_sayhi_02";
    public static final String EFFECT_SAYHI_03 = "android_sayhi_03";
    public static final String EFFECT_SHOW_OFF = "android_sayhi_01";
    public static final String EFFECT_SLEEP = "android_lock_01";
    public static final String EFFECT_TAKE_PHOTO = "takephoto";
    public static final String EFFECT_UNLOCK = "android_unlock";
    public static final String EFFECT_UNLOCK_01 = "android_unlock_01";
    public static final String EFFECT_UNLOCK_02 = "android_unlock_02";
    public static final String EFFECT_UNLOCK_03 = "android_unlock_03";
    public static final int ErrorCode_Common = -4;
    public static final int ErrorCode_DanceError = -4096;
    public static final int ErrorCode_Forbidden = -1;
    public static final int ErrorCode_NoFocus = -2;
    public static final int LIGHT_EFFECT_ACCHARGE = 6;
    public static final int LIGHT_EFFECT_AWAKE = 2;
    public static final int LIGHT_EFFECT_DCCHARGE = 7;
    public static final int LIGHT_EFFECT_FINDCAR = 1;
    public static final int LIGHT_EFFECT_SHOWOFF = 10;
    public static final int LIGHT_EFFECT_SLEEP = 5;
    public static final int LIGHT_EFFECT_TAKEPHOTO = 9;
    public static final int LLU_EFFECT_CLOSE = 0;
    public static final int LLU_EFFECT_MODE_A = 1;
    public static final int LLU_EFFECT_MODE_B = 2;
    public static final int LLU_EFFECT_MODE_C = 3;
    public static final int LLU_MODE1 = 1;
    public static final int LLU_MODE2 = 2;
    public static final int LLU_MODE3 = 3;
    private static final int MSG_SMART_AI_LLU_EVENT = 6;
    private static final int MSG_SMART_ERROR_EVENT = 0;
    private static final int MSG_SMART_LIGHT_EFFECT_FINISH_EVENT = 1;
    private static final int MSG_SMART_LIGHT_EFFECT_SHOW_ERROR = 5;
    private static final int MSG_SMART_LIGHT_EFFECT_SHOW_FINISH_EVENT = 4;
    private static final int MSG_SMART_LIGHT_EFFECT_SHOW_START_EVENT = 2;
    private static final int MSG_SMART_LIGHT_EFFECT_SHOW_STOP_EVENT = 3;
    private static final int MSG_SMART_SPEECH_TTS_EVENT = 7;
    public static final int SPEED_VOLUME_SOFT = 3;
    public static final int SPEED_VOLUME_STANDARD = 1;
    public static final int SPEED_VOLUME_SURGE = 2;
    public static final String TAG = "SmartManager";
    public static final int TOUCH_ROTATION_DIRECTION_INWARD = 0;
    public static final int TOUCH_ROTATION_DIRECTION_OUTWARD = 1;
    public static final String Type_Dance = "dance";
    public static final String Type_LightDance = "lightanddance";
    public static final int XBOSS_MUTE_UNMUTE = 2;
    public static final int XBOSS_NONE = 0;
    public static final int XBOSS_SHOW_OFF = 4;
    public static final int XBOSS_SWITCH_MEDIA = 3;
    public static final int XBOSS_TAKE_PHOTO = 5;
    public static final int XBOSS_TEAM_COMMUNICATION = 6;
    public static final int XBOSS_VOICE_ACTIVE = 1;
    public static final int XKEY_AUTO_PARK = 4;
    public static final int XKEY_AUTO_PILOT = 5;
    public static final int XKEY_NAR_ASSIST = 10;
    public static final int XKEY_NONE = 0;
    public static final int XKEY_SHOW_OFF = 2;
    public static final int XKEY_SWITCH_MEDIA = 1;
    public static final int XKEY_TAKE_PHOTO = 3;
    public static final int XKEY_TEAM_COMMUNICATION = 7;
    public static final int XKEY_UNLOCK_TRUNK = 8;
    public static final int XKEY_VOICE_CHAT = 6;
    public static final int XKEY_XSPORT = 9;
    private static String mServiceName = null;
    private final Handler mHandler;
    private ISmart mService;
    private final String DEFAULT_LDANCE_NAME = "PianoConcerto";
    private final ArraySet<SmartEventListener> mListeners = new ArraySet<>();
    private SmartEventListenerToService mListenerToService = null;
    private final ArraySet<SmartCommonEventListener> mCommonListeners = new ArraySet<>();
    private SmartCommonEventListenerToService mCommonListenerToService = null;

    public SmartManager(IBinder service, Context context, Handler handler) {
        this.mService = ISmart.Stub.asInterface(service);
        this.mHandler = new EventCallbackHandler(this, handler.getLooper());
    }

    public synchronized void registerListener(SmartEventListener listener) throws XUIServiceNotConnectedException {
        if (this.mListeners.isEmpty()) {
            try {
                this.mListenerToService = new SmartEventListenerToService(this);
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

    public synchronized void unregisterListener(SmartEventListener listener) throws XUIServiceNotConnectedException {
        Log.d(TAG, "unregisterListener");
        this.mListeners.remove(listener);
        if (this.mListeners.isEmpty() && this.mListenerToService != null) {
            try {
                this.mService.unregisterListener(this.mListenerToService);
                this.mListenerToService = null;
            } catch (RemoteException e) {
                Log.e(TAG, "Could not unregister: " + e.toString());
                throw new XUIServiceNotConnectedException(e);
            }
        }
    }

    public synchronized void registerCommonListener(SmartCommonEventListener listener) throws XUIServiceNotConnectedException {
        if (this.mCommonListeners.isEmpty()) {
            try {
                this.mCommonListenerToService = new SmartCommonEventListenerToService(this);
                this.mService.registerCommonListener(this.mCommonListenerToService);
            } catch (RemoteException ex) {
                Log.e(TAG, "Could not connect: " + ex.toString());
                throw new XUIServiceNotConnectedException(ex);
            } catch (IllegalStateException ex2) {
                XUIManager.checkXUIServiceNotConnectedExceptionFromXUIService(ex2);
            }
        }
        this.mCommonListeners.add(listener);
    }

    public synchronized void unregisterCommonListener(SmartCommonEventListener listener) throws XUIServiceNotConnectedException {
        Log.d(TAG, "unregisterListener");
        this.mCommonListeners.remove(listener);
        if (this.mCommonListeners.isEmpty() && this.mCommonListenerToService != null) {
            try {
                this.mService.unregisterCommonListener(this.mCommonListenerToService);
                this.mCommonListenerToService = null;
            } catch (RemoteException e) {
                Log.e(TAG, "Could not unregister: " + e.toString());
                throw new XUIServiceNotConnectedException(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchErrorEventToClient(int errorCode, int operation) {
        Collection<SmartEventListener> listeners;
        synchronized (this) {
            listeners = this.mListeners;
        }
        if (!listeners.isEmpty()) {
            for (SmartEventListener l : listeners) {
                l.onErrorEvent(errorCode, operation);
            }
            return;
        }
        Log.e(TAG, "Listener is null, not dispatching event.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchLightEffectFinishEventToClient(int effectName, int effectMode) {
        Collection<SmartEventListener> listeners;
        synchronized (this) {
            listeners = this.mListeners;
        }
        if (!listeners.isEmpty()) {
            for (SmartEventListener l : listeners) {
                l.onLightEffectFinishEvent(effectName, effectMode);
            }
            return;
        }
        Log.e(TAG, "Listener is null, not dispatching event.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchLightEffectShowStartEventToClient(String effectName, String effectType) {
        Collection<SmartEventListener> listeners;
        synchronized (this) {
            listeners = this.mListeners;
        }
        if (!listeners.isEmpty()) {
            for (SmartEventListener l : listeners) {
                l.onLightEffectShowStartEvent(effectName, effectType);
            }
            return;
        }
        Log.e(TAG, "Listener is null, not dispatching onLightEffectShowStartEvent event.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchLightEffectShowStopEventToClient(String effectName, String effectType) {
        Collection<SmartEventListener> listeners;
        synchronized (this) {
            listeners = this.mListeners;
        }
        if (!listeners.isEmpty()) {
            for (SmartEventListener l : listeners) {
                l.onLightEffectShowStopEvent(effectName, effectType);
            }
            return;
        }
        Log.e(TAG, "Listener is null, not dispatching onLightEffectShowStopEvent event.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchLightEffectShowFinishEventToClient(String effectName, String effectType) {
        Collection<SmartEventListener> listeners;
        synchronized (this) {
            listeners = this.mListeners;
        }
        if (!listeners.isEmpty()) {
            for (SmartEventListener l : listeners) {
                l.onLightEffectShowFinishEvent(effectName, effectType);
            }
            return;
        }
        Log.e(TAG, "Listener is null, not dispatching onLightEffectShowFinishEvent event.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchLightEffectErrorToClient(String effectName, int errorCode) {
        Collection<SmartEventListener> listeners;
        synchronized (this) {
            listeners = this.mListeners;
        }
        if (!listeners.isEmpty()) {
            for (SmartEventListener l : listeners) {
                l.onLightEffectShowError(effectName, errorCode);
            }
            return;
        }
        Log.e(TAG, "Listener is null, not dispatching onLightEffectShowError event.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchCommonEventToClient(int type, int value1, int value2) {
        Collection<SmartCommonEventListener> listeners;
        synchronized (this) {
            listeners = this.mCommonListeners;
        }
        if (!listeners.isEmpty()) {
            for (SmartCommonEventListener l : listeners) {
                l.onCommonEvent(type, value1, value2);
            }
            return;
        }
        Log.e(TAG, "Listener is null, not dispatching event.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchSpeechTtsEventToClient(int type, String ttsId) {
        Collection<SmartCommonEventListener> listeners;
        synchronized (this) {
            listeners = this.mCommonListeners;
        }
        if (!listeners.isEmpty()) {
            for (SmartCommonEventListener l : listeners) {
                l.onSpeechTtsEvent(type, ttsId);
            }
            return;
        }
        Log.e(TAG, "Listener is null, not dispatching event.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLightEffectFinishEvent(int effectName, int effectMode) {
        Message message = this.mHandler.obtainMessage();
        message.what = 1;
        message.obj = Integer.valueOf(effectName);
        message.arg1 = effectMode;
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLightEffectShowStartEvent(String effectName, String effectType) {
        Message message = this.mHandler.obtainMessage();
        message.what = 2;
        message.obj = effectName;
        Bundle bundle = new Bundle();
        bundle.putString("type", effectType);
        message.setData(bundle);
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLightEffectShowStopEvent(String effectName, String effectType) {
        Message message = this.mHandler.obtainMessage();
        message.what = 3;
        message.obj = effectName;
        Bundle bundle = new Bundle();
        bundle.putString("type", effectType);
        message.setData(bundle);
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLightEffectShowFinishEvent(String effectName, String effectType) {
        Message message = this.mHandler.obtainMessage();
        message.what = 4;
        message.obj = effectName;
        Bundle bundle = new Bundle();
        bundle.putString("type", effectType);
        message.setData(bundle);
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLightEffectShowError(String effectName, int errorCode) {
        Message message = this.mHandler.obtainMessage();
        message.what = 5;
        message.obj = effectName;
        message.arg1 = errorCode;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCommonEvent(int type, int value1, int value2) {
        Message message = this.mHandler.obtainMessage();
        message.what = 6;
        message.obj = Integer.valueOf(type);
        message.arg1 = value1;
        message.arg2 = value2;
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSpeechTtsEvent(int type, String ttsId) {
        Message message = this.mHandler.obtainMessage();
        message.what = 7;
        message.obj = Integer.valueOf(type);
        Bundle bundle = new Bundle();
        bundle.putString("ttsId", ttsId);
        message.setData(bundle);
        this.mHandler.sendMessage(message);
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIDisconnected() {
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIConnected(IBinder service) {
        this.mService = ISmart.Stub.asInterface(service);
        if (!this.mListeners.isEmpty()) {
            try {
                this.mListenerToService = new SmartEventListenerToService(this);
                this.mService.registerListener(this.mListenerToService);
            } catch (Exception ex) {
                Log.e(TAG, "Could not connect: " + ex.toString());
            }
        }
        if (!this.mCommonListeners.isEmpty()) {
            try {
                this.mCommonListenerToService = new SmartCommonEventListenerToService(this);
                this.mService.registerCommonListener(this.mCommonListenerToService);
            } catch (Exception ex2) {
                Log.e(TAG, "Could not connect: " + ex2.toString());
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

    public boolean getVolumeDownWithDoorOpen() throws XUIServiceNotConnectedException {
        Log.d(TAG, "getVolumeDownWithDoorOpen");
        try {
            return this.mService.getVolumeDownWithDoorOpen();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getVolumeDownWithDoorOpen: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setVolumeDownWithDoorOpen(boolean enable) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setVolumeDownWithDoorOpen " + enable);
        try {
            this.mService.setVolumeDownWithDoorOpen(enable);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setVolumeDownWithDoorOpen: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public boolean getVolumeDownInReverseMode() throws XUIServiceNotConnectedException {
        Log.d(TAG, "getVolumeDownInReverseMode");
        try {
            return this.mService.getVolumeDownInReverseMode();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getVolumeDownInReverseMode: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setVolumeDownInReverseMode(boolean enable) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setVolumeDownInReverseMode " + enable);
        try {
            this.mService.setVolumeDownInReverseMode(enable);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setVolumeDownInReverseMode: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public boolean getAlarmFromAzimuthOrIcm() throws XUIServiceNotConnectedException {
        Log.d(TAG, "getAlarmFromAzimuthOrIcm");
        try {
            return this.mService.getAlarmFromAzimuthOrIcm();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getAlarmFromAzimuthOrIcm: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setAlarmFromAzimuthOrIcm(boolean enable) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setAlarmFromAzimuthOrIcm " + enable);
        try {
            this.mService.setAlarmFromAzimuthOrIcm(enable);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setAlarmFromAzimuthOrIcm: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public boolean getKeyBoardTouchPrompt() throws XUIServiceNotConnectedException {
        Log.d(TAG, "getKeyBoardTouchPrompt");
        try {
            return this.mService.getKeyBoardTouchPrompt();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getVolumeDownWithDoorOpen: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setKeyBoardTouchPrompt(boolean enable) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setKeyBoardTouchPrompt " + enable);
        try {
            this.mService.setKeyBoardTouchPrompt(enable);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setKeyBoardTouchPrompt: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int getXKeyForCustomer() throws XUIServiceNotConnectedException {
        Log.d(TAG, "getXKeyForCustomer");
        try {
            return this.mService.getXKeyForCustomer();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getXKeyForCustomer: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setXKeyForCustomer(int keyFunc) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setXKeyForCustomer " + keyFunc);
        try {
            this.mService.setXKeyForCustomer(keyFunc);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setXKeyForCustomer: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int getBossKeyForCustomer() throws XUIServiceNotConnectedException {
        Log.d(TAG, "getBossKeyForCustomer");
        try {
            return this.mService.getBossKeyForCustomer();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getBossKeyForCustomer: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setBossKeyForCustomer(int keyFunc) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setBossKeyForCustomer " + keyFunc);
        try {
            this.mService.setBossKeyForCustomer(keyFunc);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setBossKeyForCustomer: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int getTouchRotationDirection() throws XUIServiceNotConnectedException {
        Log.d(TAG, "getTouchRotationDirection");
        try {
            return this.mService.getTouchRotationDirection();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getTouchRotationDirection: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setTouchRotationDirection(int rotationDirection) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setTouchRotationDirection");
        try {
            this.mService.setTouchRotationDirection(rotationDirection);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setTouchRotationDirection: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public List<String> getLangLightEffectNameList(int effectType) throws XUIServiceNotConnectedException {
        Log.d(TAG, "getLangLightEffectNameList(" + effectType + ")");
        try {
            return this.mService.getLangLightEffectNameList(effectType);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getLangLightEffectNameList: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setLangLightEffectMode(String effectName) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setLangLightEffectMode() " + effectName);
        setLangLightEffectMode(effectName, 1);
    }

    public void setLangLightEffectMode(String effectName, int loop) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setLangLightEffectMode() " + effectName + " " + loop);
        try {
            this.mService.setLangLightEffectMode(effectName, loop);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setLangLightEffectMode: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setLangLightEffectWithMode(String effectName, int mode, int loop) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setLangLightEffectWithMode() " + effectName + " " + mode + " " + loop);
        try {
            this.mService.setLangLightEffectWithMode(effectName, mode, loop);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setLangLightEffectWithMode: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public String getRunnningLluEffectName() throws XUIServiceNotConnectedException {
        try {
            return this.mService.getRunnningLluEffectName();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getRunnningLluEffectName ");
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int getLluWakeWaitMode() throws XUIServiceNotConnectedException {
        Log.d(TAG, "getLluWakeWaitMode");
        try {
            return this.mService.getLluWakeWaitMode();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getLluWakeWaitMode: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setLluWakeWaitMode(int type) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setLluWakeWaitMode() " + type);
        try {
            this.mService.setLluWakeWaitMode(type);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setLluWakeWaitMode: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int getLluSleepMode() throws XUIServiceNotConnectedException {
        Log.d(TAG, "getLluSleepMode");
        try {
            return this.mService.getLluSleepMode();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getLluSleepMode: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setLluSleepMode(int type) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setLluSleepMode() " + type);
        try {
            this.mService.setLluSleepMode(type);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setLluSleepMode: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setFftLLUEnable(boolean enable) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setFftLLUEnable " + enable);
        try {
            this.mService.setFftLLUEnable(enable);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setFftLLUEnable: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public boolean getFftLLUEnable() throws XUIServiceNotConnectedException {
        Log.d(TAG, "getFftLLUEnable");
        try {
            return this.mService.getFftLLUEnable();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getFftLLUEnable: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setPause(boolean pause) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setPause() :" + pause);
        try {
            this.mService.setPause(pause);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setPause: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void stopLightEffectShow() throws XUIServiceNotConnectedException {
        Log.d(TAG, "stopLightEffectShow()");
        try {
            this.mService.stopLightEffectShow();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not stopLightEffectShow: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void updateEffectFiles(int effectType) throws XUIServiceNotConnectedException {
        Log.d(TAG, "updateEffectFiles()" + effectType);
        try {
            this.mService.updateEffectFiles(effectType);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not updateEffectFiles: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public boolean getLangLightEffectEnable() throws XUIServiceNotConnectedException {
        Log.d(TAG, "getLangLightEffectEnable");
        try {
            return this.mService.getLangLightEffectEnable();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getLangLightEffectEnable: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setLangLightEffectEnable(boolean enable) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setLangLightEffectEnable() enable:" + enable);
        try {
            this.mService.setLangLightEffectEnable(enable);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setLangLightEffectEnable: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setMusicSpectrumToLangLight(int tickNum) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setMusicSpectrumToLangLight() " + tickNum);
        try {
            this.mService.setMusicSpectrumToLangLight(tickNum);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setMusicSpectrumToLangLight: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int isLightDanceAvailable() throws XUIServiceNotConnectedException {
        try {
            return this.mService.isLightDanceAvailable();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not get LightDanceAvailable: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int startLightDancing() {
        return startLightDancing(1);
    }

    public int startLightDancing(int loop) {
        try {
            return startLightDancing("PianoConcerto", loop);
        } catch (Exception e) {
            Log.e(TAG, "Could not startLightDancing: " + e.toString());
            return -1;
        }
    }

    public int startLightDancing(String file_name, int loop) throws XUIServiceNotConnectedException {
        Log.d(TAG, "startLightDancing() " + file_name);
        try {
            return this.mService.startLightDancing(file_name, loop);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not startLightDancing: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int stopLightDancing() throws XUIServiceNotConnectedException {
        Log.d(TAG, "stopLightDancing() ");
        try {
            return this.mService.stopLightDancing();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not stopLightDancing: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public boolean isLightDancing() throws XUIServiceNotConnectedException {
        Log.d(TAG, "isLightDancing() ");
        try {
            return this.mService.isLightDancing();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not isLightDancing: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int getAlarmVolume() throws XUIServiceNotConnectedException {
        Log.d(TAG, "getAlarmVolume()");
        try {
            return this.mService.getAlarmVolume();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getAlarmVolume: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setAlarmVolume(int type) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setAlarmVolume(int type):" + type);
        try {
            this.mService.setAlarmVolume(type);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setAlarmVolume: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setMusicTableForDebug(int musicTable) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setMusicTableForDebug(int musicTable):" + musicTable);
        try {
            this.mService.setMusicTableForDebug(musicTable);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setMusicTableForDebug: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setMusicStartTickNumForDebug(int tickNum) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setMusicStartTickNumForDebug(int tickNum):" + tickNum);
        try {
            this.mService.setMusicStartTickNumForDebug(tickNum);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setMusicStartTickNumForDebug: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setMusicStopTickNumForDebug(int tickNum) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setMusicStopTickNumForDebug(int tickNum):" + tickNum);
        try {
            this.mService.setMusicStopTickNumForDebug(tickNum);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setMusicStopTickNumForDebug: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setMusicDelayTimeForDebug(int delayTime) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setMusicDelayTimeForDebug(int delayTime):" + delayTime);
        try {
            this.mService.setMusicDelayTimeForDebug(delayTime);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setMusicDelayTimeForDebug: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setLangLightMusicEffect(String effectName) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setLangLightMusicEffect() " + effectName);
        try {
            this.mService.setLangLightMusicEffect(effectName);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setLangLightMusicEffect: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int getLightEffect(int effectName) throws XUIServiceNotConnectedException {
        Log.d(TAG, "getLightEffect(effectName): effectName:" + effectName);
        try {
            return this.mService.getLightEffect(effectName);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getLightEffect: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setLightEffect(int effectName, int effectMode) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setLightEffect(effectName,effectMode): effectName:" + effectName + " effectMode:" + effectMode);
        try {
            this.mService.setLightEffect(effectName, effectMode);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setLightEffect: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setLightEffectAndMusic(int messageID, int effectName, int effectMusic) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setLightEffectAndMusic(int messageID, int effectName, int music): messageID:" + messageID + " effectName:" + effectName + " effectMusic:" + effectMusic);
        try {
            this.mService.setLightEffectAndMusic(messageID, effectName, effectMusic);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setLightEffectAndMusic: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public boolean getSayHiEnable() throws XUIServiceNotConnectedException {
        Log.d(TAG, "getSayHiEnable");
        try {
            return this.mService.getSayHiEnable();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getSayHiEnable: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setSayHiEnable(boolean enable) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setSayHiEnable(boolean enable):" + enable);
        try {
            this.mService.setSayHiEnable(enable);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setSayHiEnable: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int getSayHiEffect() throws XUIServiceNotConnectedException {
        Log.d(TAG, "getSayHiEffect");
        try {
            return this.mService.getSayHiEffect();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getSayHiEffect: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setSayHiEffect(int type) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setSayHiEffect(int type):" + type);
        try {
            this.mService.setSayHiEffect(type);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setSayHiEffect: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int getBootSoundEffect() throws XUIServiceNotConnectedException {
        Log.d(TAG, "getBootSoundEffect");
        try {
            return this.mService.getBootSoundEffect();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getBootSoundEffect: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setBootSoundEffect(int type) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setBootSoundEffect(int type):" + type);
        try {
            this.mService.setBootSoundEffect(type);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setBootSoundEffect: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void enableCarSpeedVolume(boolean enable) throws XUIServiceNotConnectedException {
        Log.d(TAG, "enableCarSpeedVolume() :" + enable);
        try {
            this.mService.enableCarSpeedVolume(enable);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not enableCarSpeedVolume: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setSpeedVolumeMode(int type) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setSpeedVolumeMode() :" + type);
        try {
            this.mService.setSpeedVolumeMode(type);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setSpeedVolumeMode: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void startAiLluMode(int type) throws XUIServiceNotConnectedException {
        Log.d(TAG, "startAiLluMode() :" + type);
        try {
            this.mService.startAiLluMode(type);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not startAiLluMode: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void stopAiLluMode() throws XUIServiceNotConnectedException {
        Log.d(TAG, "stopAiLluMode()");
        try {
            this.mService.stopAiLluMode();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not stopAiLluMode: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public boolean getSpeechStatus() throws XUIServiceNotConnectedException {
        Log.d(TAG, "getSpeechStatus()");
        try {
            return this.mService.getSpeechStatus();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getSpeechStatus: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public String speakByNormal(String text) throws XUIServiceNotConnectedException {
        Log.d(TAG, "speakByNormal()");
        try {
            return this.mService.speakByNormal(text);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not speakByNormal: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public String speakByImportant(String text) throws XUIServiceNotConnectedException {
        Log.d(TAG, "speakByImportant()");
        try {
            return this.mService.speakByImportant(text);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not speakByImportant: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public String speakByUrgent(String text) throws XUIServiceNotConnectedException {
        Log.d(TAG, "speakByUrgent()");
        try {
            return this.mService.speakByUrgent(text);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not speakByUrgent: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public String speakByInstant(String text, boolean isShutUp) throws XUIServiceNotConnectedException {
        Log.d(TAG, "speakByInstant()");
        try {
            return this.mService.speakByInstant(text, isShutUp);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not speakByInstant: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void stopSpeech(String ttsId) throws XUIServiceNotConnectedException {
        Log.d(TAG, "stopSpeech()");
        try {
            this.mService.stopSpeech(ttsId);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not stopSpeech: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void stopAllSpeech() throws XUIServiceNotConnectedException {
        Log.d(TAG, "stopAllSpeech()");
        try {
            this.mService.stopAllSpeech();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not stopAllSpeech: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int startMicRecordMode(int status) throws XUIServiceNotConnectedException {
        Log.d(TAG, "startMicRecordMode(" + status + ")");
        try {
            return this.mService.startMicRecordMode(status);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not startMicRecordMode: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int stopMicRecordMode() throws XUIServiceNotConnectedException {
        Log.d(TAG, "stopMicRecordMode()");
        try {
            return this.mService.stopMicRecordMode();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not stopMicRecordMode: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    /* loaded from: classes.dex */
    public interface SmartEventListener {
        void onErrorEvent(int i, int i2);

        void onLightEffectFinishEvent(int i, int i2);

        default void onLightEffectShowStartEvent(String effectName, String effectType) {
        }

        default void onLightEffectShowStopEvent(String effectName, String effectType) {
        }

        default void onLightEffectShowFinishEvent(String effectName, String effectType) {
        }

        default void onLightEffectShowError(String effectName, int errorCode) {
        }
    }

    /* loaded from: classes.dex */
    public interface SmartCommonEventListener {
        default void onCommonEvent(int type, int value1, int value2) {
        }

        default void onSpeechTtsEvent(int type, String ttsId) {
        }
    }

    /* loaded from: classes.dex */
    private static final class EventCallbackHandler extends Handler {
        WeakReference<SmartManager> mMgr;

        EventCallbackHandler(SmartManager mgr, Looper looper) {
            super(looper);
            this.mMgr = new WeakReference<>(mgr);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            SmartManager mgr = this.mMgr.get();
            switch (msg.what) {
                case 0:
                    if (mgr != null) {
                        mgr.dispatchErrorEventToClient(((Integer) msg.obj).intValue(), msg.arg1);
                        return;
                    }
                    return;
                case 1:
                    if (mgr != null) {
                        mgr.dispatchLightEffectFinishEventToClient(((Integer) msg.obj).intValue(), msg.arg1);
                        return;
                    }
                    return;
                case 2:
                    if (mgr != null) {
                        Bundle bundle = msg.getData();
                        String effectType = bundle.getString("type");
                        mgr.dispatchLightEffectShowStartEventToClient((String) msg.obj, effectType);
                        return;
                    }
                    return;
                case 3:
                    if (mgr != null) {
                        Bundle bundle2 = msg.getData();
                        String effectType2 = bundle2.getString("type");
                        mgr.dispatchLightEffectShowStopEventToClient((String) msg.obj, effectType2);
                        return;
                    }
                    return;
                case 4:
                    if (mgr != null) {
                        Bundle bundle3 = msg.getData();
                        String effectType3 = bundle3.getString("type");
                        mgr.dispatchLightEffectShowFinishEventToClient((String) msg.obj, effectType3);
                        return;
                    }
                    return;
                case 5:
                    if (mgr != null) {
                        mgr.dispatchLightEffectErrorToClient((String) msg.obj, msg.arg1);
                        return;
                    }
                    return;
                case 6:
                    if (mgr != null) {
                        mgr.dispatchCommonEventToClient(((Integer) msg.obj).intValue(), msg.arg1, msg.arg2);
                        return;
                    }
                    return;
                case 7:
                    if (mgr != null) {
                        Bundle bundle4 = msg.getData();
                        String ttsId = bundle4.getString("ttsId");
                        mgr.dispatchSpeechTtsEventToClient(((Integer) msg.obj).intValue(), ttsId);
                        return;
                    }
                    return;
                default:
                    Log.e(SmartManager.TAG, "Event type not handled?" + msg);
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    private static class SmartEventListenerToService extends ISmartEventListener.Stub {
        private final WeakReference<SmartManager> mManager;

        public SmartEventListenerToService(SmartManager manager) {
            this.mManager = new WeakReference<>(manager);
        }

        @Override // com.xiaopeng.xuimanager.smart.ISmartEventListener
        public void onError(int errorCode, int operation) {
            SmartManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleErrorEvent(errorCode, operation);
            }
        }

        @Override // com.xiaopeng.xuimanager.smart.ISmartEventListener
        public void onLightEffectFinishEvent(int effectName, int effectMode) {
            SmartManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleLightEffectFinishEvent(effectName, effectMode);
            }
        }

        @Override // com.xiaopeng.xuimanager.smart.ISmartEventListener
        public void onLightEffectShowStartEvent(String effectName, String effectType) {
            SmartManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleLightEffectShowStartEvent(effectName, effectType);
            }
        }

        @Override // com.xiaopeng.xuimanager.smart.ISmartEventListener
        public void onLightEffectShowStopEvent(String effectName, String effectType) {
            SmartManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleLightEffectShowStopEvent(effectName, effectType);
            }
        }

        @Override // com.xiaopeng.xuimanager.smart.ISmartEventListener
        public void onLightEffectShowFinishEvent(String effectName, String effectType) {
            SmartManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleLightEffectShowFinishEvent(effectName, effectType);
            }
        }

        @Override // com.xiaopeng.xuimanager.smart.ISmartEventListener
        public void onLightEffectShowError(String effectName, int errorCode) {
            SmartManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleLightEffectShowError(effectName, errorCode);
            }
        }
    }

    /* loaded from: classes.dex */
    private static class SmartCommonEventListenerToService extends ISmartCommonEventListener.Stub {
        private final WeakReference<SmartManager> mManager;

        public SmartCommonEventListenerToService(SmartManager manager) {
            this.mManager = new WeakReference<>(manager);
        }

        @Override // com.xiaopeng.xuimanager.smart.ISmartCommonEventListener
        public void onSmartCommonEvent(int type, int value1, int value2) {
            SmartManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleCommonEvent(type, value1, value2);
            }
        }

        @Override // com.xiaopeng.xuimanager.smart.ISmartCommonEventListener
        public void onSmartSpeechTtsEvent(int type, String ttsId) {
            SmartManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleSpeechTtsEvent(type, ttsId);
            }
        }
    }
}
