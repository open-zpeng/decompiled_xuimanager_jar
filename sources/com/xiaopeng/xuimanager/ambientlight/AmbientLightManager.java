package com.xiaopeng.xuimanager.ambientlight;

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
import com.xiaopeng.xuimanager.ambientlight.IAmbientLight;
import com.xiaopeng.xuimanager.ambientlight.IAmbientLightEventListener;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.List;
@SystemApi
/* loaded from: classes.dex */
public class AmbientLightManager implements XUIManagerBase {
    public static final int BRIGHT_SET_EVENT = 5;
    public static final boolean DBG = false;
    public static final int DOUBLE_COLOR_ENABLE_EVENT = 2;
    public static final int DOUBLE_COLOR_SET_EVENT = 4;
    public static final String EFFECT_FOLLOW_SPEED = "follow_speed";
    public static final String EFFECT_GENTLE_BREATHING = "gentle_breathing";
    public static final String EFFECT_MUSIC = "music";
    public static final String EFFECT_STABLE_EFFECT = "stable_effect";
    public static final int EFFECT_TYPE_SET_EVENT = 1;
    public static final int LIGHT_COLOR_1 = 1;
    public static final int LIGHT_COLOR_10 = 10;
    public static final int LIGHT_COLOR_11 = 11;
    public static final int LIGHT_COLOR_12 = 12;
    public static final int LIGHT_COLOR_13 = 13;
    public static final int LIGHT_COLOR_14 = 14;
    public static final int LIGHT_COLOR_15 = 15;
    public static final int LIGHT_COLOR_16 = 16;
    public static final int LIGHT_COLOR_17 = 17;
    public static final int LIGHT_COLOR_18 = 18;
    public static final int LIGHT_COLOR_19 = 19;
    public static final int LIGHT_COLOR_2 = 2;
    public static final int LIGHT_COLOR_20 = 20;
    public static final int LIGHT_COLOR_3 = 3;
    public static final int LIGHT_COLOR_4 = 4;
    public static final int LIGHT_COLOR_5 = 5;
    public static final int LIGHT_COLOR_6 = 6;
    public static final int LIGHT_COLOR_7 = 7;
    public static final int LIGHT_COLOR_8 = 8;
    public static final int LIGHT_COLOR_9 = 9;
    public static final int MONO_COLOR_SET_EVENT = 3;
    private static final int MSG_AMBIENTLIGHT_BRIGHT_SET_EVENT = 5;
    private static final int MSG_AMBIENTLIGHT_DOUBLE_COLOR_ENABLE_EVENT = 2;
    private static final int MSG_AMBIENTLIGHT_DOUBLE_COLOR_SET_EVENT = 4;
    private static final int MSG_AMBIENTLIGHT_EFFECT_TYPE_SET_EVENT = 1;
    private static final int MSG_AMBIENTLIGHT_ERROR_EVENT = 0;
    private static final int MSG_AMBIENTLIGHT_MONO_COLOR_SET_EVENT = 3;
    private static final int MSG_AMBIENTLIGHT_SWITCH_SET_EVENT = 6;
    public static final int SWITCH_SET_EVENT = 6;
    public static final String TAG = "AmbientLightManager";
    private static String mServiceName = null;
    private final Handler mHandler;
    private IAmbientLight mService;
    private final ArraySet<AmbientLightEventListener> mListeners = new ArraySet<>();
    private AmbientLightEventListenerToService mListenerToService = null;

    public AmbientLightManager(IBinder service, Context context, Handler handler) {
        this.mService = IAmbientLight.Stub.asInterface(service);
        this.mHandler = new EventCallbackHandler(this, handler.getLooper());
    }

    public synchronized void registerListener(AmbientLightEventListener listener) throws XUIServiceNotConnectedException {
        if (this.mListeners.isEmpty()) {
            try {
                this.mListenerToService = new AmbientLightEventListenerToService(this);
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

    public synchronized void unregisterListener(AmbientLightEventListener listener) throws XUIServiceNotConnectedException {
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
        Collection<AmbientLightEventListener> listeners;
        synchronized (this) {
            listeners = this.mListeners;
        }
        if (!listeners.isEmpty()) {
            for (AmbientLightEventListener l : listeners) {
                l.onErrorEvent(errorCode, operation);
            }
            return;
        }
        Log.e(TAG, "Listener is null, not dispatching event.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchLightEffectTypeSetEventToClient(String effectType) {
        Collection<AmbientLightEventListener> listeners;
        synchronized (this) {
            listeners = this.mListeners;
        }
        if (!listeners.isEmpty()) {
            for (AmbientLightEventListener l : listeners) {
                l.onLightEffectTypeSetEvent(effectType);
            }
            return;
        }
        Log.e(TAG, "Listener is null, not dispatching event.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchLightDoubleColorEnableEventToClient(String effectType, boolean enable) {
        Collection<AmbientLightEventListener> listeners;
        synchronized (this) {
            listeners = this.mListeners;
        }
        if (!listeners.isEmpty()) {
            for (AmbientLightEventListener l : listeners) {
                l.onLightDoubleColorEnableEvent(effectType, enable);
            }
            return;
        }
        Log.e(TAG, "Listener is null, not dispatching event.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchLightMonoColorSetEventToClient(String effectType, int color) {
        Collection<AmbientLightEventListener> listeners;
        synchronized (this) {
            listeners = this.mListeners;
        }
        if (!listeners.isEmpty()) {
            for (AmbientLightEventListener l : listeners) {
                l.onLightMonoColorSetEvent(effectType, color);
            }
            return;
        }
        Log.e(TAG, "Listener is null, not dispatching event.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchLightBrightSetEventToClient(String effectType, int bright) {
        Collection<AmbientLightEventListener> listeners;
        synchronized (this) {
            listeners = this.mListeners;
        }
        if (!listeners.isEmpty()) {
            for (AmbientLightEventListener l : listeners) {
                l.onLightBrightSetEvent(effectType, bright);
            }
            return;
        }
        Log.e(TAG, "Listener is null, not dispatching event.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchLightDoubleColorSetEventToClient(String effectType, int first_color, int second_color) {
        Collection<AmbientLightEventListener> listeners;
        synchronized (this) {
            listeners = this.mListeners;
        }
        if (!listeners.isEmpty()) {
            for (AmbientLightEventListener l : listeners) {
                l.onLightDoubleColorSetEvent(effectType, first_color, second_color);
            }
            return;
        }
        Log.e(TAG, "Listener is null, not dispatching event.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchLightSwitchSetEventToClient(String effectType, boolean enable) {
        Collection<AmbientLightEventListener> listeners;
        synchronized (this) {
            listeners = this.mListeners;
        }
        if (!listeners.isEmpty()) {
            for (AmbientLightEventListener l : listeners) {
                l.onLightSwitchSetEvent(effectType, enable);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLightEffectTypeSetEvent(String effectType) {
        Message message = this.mHandler.obtainMessage();
        message.what = 1;
        message.obj = effectType;
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLightDoubleColorEnableEvent(String effectType, boolean enable) {
        Message message = this.mHandler.obtainMessage();
        message.what = 2;
        message.obj = effectType;
        Bundle bundle = new Bundle();
        bundle.putBoolean("enable", enable);
        message.setData(bundle);
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLightMonoColorSetEvent(String effectType, int color) {
        Message message = this.mHandler.obtainMessage();
        message.what = 3;
        message.obj = effectType;
        message.arg1 = color;
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLightDoubleColorSetEvent(String effectType, int first_color, int second_color) {
        Message message = this.mHandler.obtainMessage();
        message.what = 4;
        message.obj = effectType;
        message.arg1 = first_color;
        message.arg2 = second_color;
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLightBrightSetEvent(String effectType, int bright) {
        Message message = this.mHandler.obtainMessage();
        message.what = 5;
        message.obj = effectType;
        message.arg1 = bright;
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLightSwitchSetEvent(String effectType, boolean enable) {
        Message message = this.mHandler.obtainMessage();
        message.what = 6;
        message.obj = effectType;
        message.arg1 = enable ? 1 : 0;
        this.mHandler.sendMessage(message);
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIDisconnected() {
        Log.i(TAG, "onXUIDisconnected");
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIConnected(IBinder service) {
        Log.i(TAG, "onXUIConnected");
        this.mService = IAmbientLight.Stub.asInterface(service);
        if (!this.mListeners.isEmpty()) {
            try {
                if (this.mListenerToService == null) {
                    this.mListenerToService = new AmbientLightEventListenerToService(this);
                }
                this.mService.registerListener(this.mListenerToService);
            } catch (Exception e) {
                Log.e(TAG, "onXUIConnected failed, " + e);
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

    public boolean getMusicSpectrumEnable() throws XUIServiceNotConnectedException {
        try {
            return this.mService.getMusicSpectrumEnable();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getMusicSpectrumEnable: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setMusicSpectrumEnable(boolean enable) throws XUIServiceNotConnectedException {
        Log.i(TAG, "setMusicSpectrumEnable() " + enable);
        try {
            this.mService.setMusicSpectrumEnable(enable);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setMusicSpectrumEnable: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setMusicRhythmMode(boolean enable) throws XUIServiceNotConnectedException {
        Log.i(TAG, "setMusicRhythmMode()" + enable);
        try {
            this.mService.setMusicRhythmMode(enable);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setMusicRhythmMode: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int getAmbientLightMonoColor(String effectType) throws XUIServiceNotConnectedException {
        try {
            return this.mService.getAmbientLightMonoColor(effectType);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getAmbientLightMonoColor: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setAmbientLightMonoColor(String effectType, int color) throws XUIServiceNotConnectedException {
        Log.i(TAG, "setAmbientLightMonoColor(), effectType:" + effectType + " color:" + color);
        try {
            this.mService.setAmbientLightMonoColor(effectType, color);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setAmbientLightMonoColor: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int getAmbientLightDoubleFirstColor(String effectType) throws XUIServiceNotConnectedException {
        try {
            return this.mService.getAmbientLightDoubleFirstColor(effectType);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getAmbientLightDoubleFirstColor: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int getAmbientLightDoubleSecondColor(String effectType) throws XUIServiceNotConnectedException {
        try {
            return this.mService.getAmbientLightDoubleSecondColor(effectType);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getAmbientLightDoubleSecondColor: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int getAmbientLightBright() throws XUIServiceNotConnectedException {
        Log.i(TAG, "getAmbientLightBright() ");
        try {
            return this.mService.getAmbientLightBright();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getAmbientLightBright: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setAmbientLightDoubleColor(String effectType, int first_color, int second_color) throws XUIServiceNotConnectedException {
        Log.i(TAG, "setAmbientLightDoubleColor() " + effectType + " " + first_color + " " + second_color);
        try {
            this.mService.setAmbientLightDoubleColor(effectType, first_color, second_color);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setAmbientLightDoubleColor: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setAmbientLightBright(int bright) throws XUIServiceNotConnectedException {
        Log.i(TAG, "setAmbientLightBright() " + bright);
        try {
            this.mService.setAmbientLightBright(bright);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setAmbientLightBright: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setAmbientLightMemoryBright(int bright) throws XUIServiceNotConnectedException {
        Log.i(TAG, "setAmbientLightMemoryBright() " + bright);
        try {
            this.mService.setAmbientLightMemoryBright(bright);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setAmbientLightMemoryBright: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public boolean getDoubleThemeColorEnable(String effectType) throws XUIServiceNotConnectedException {
        try {
            return this.mService.getDoubleThemeColorEnable(effectType);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getDoubleThemeColorEnable: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setDoubleThemeColorEnable(String effectType, boolean enable) throws XUIServiceNotConnectedException {
        Log.i(TAG, "setDoubleThemeColorEnable() " + effectType + " " + enable);
        try {
            this.mService.setDoubleThemeColorEnable(effectType, enable);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setDoubleThemeColorEnable: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public String getAmbientLightEffectType() throws XUIServiceNotConnectedException {
        try {
            return this.mService.getAmbientLightEffectType();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getAmbientLightEffectType: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setAmbientLightEffectType(String effectType) throws XUIServiceNotConnectedException {
        Log.i(TAG, "setAmbientLightEffectType() " + effectType);
        try {
            this.mService.setAmbientLightEffectType(effectType);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setAmbientLightEffectType: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public boolean getAmbientLightOpen() throws XUIServiceNotConnectedException {
        try {
            return this.mService.getAmbientLightOpen();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getAmbientLightOpen: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setAmbientLightOpen(boolean enable) throws XUIServiceNotConnectedException {
        Log.i(TAG, "setAmbientLightOpen() " + enable);
        try {
            this.mService.setAmbientLightOpen(enable);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setAmbientLightOpen: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public List<String> getAmbientLightEffectTypeList() throws XUIServiceNotConnectedException {
        try {
            return this.mService.getAmbientLightEffectTypeList();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getAmbientLightEffectTypeList: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public boolean isSupportDoubleThemeColor(String effectType) throws XUIServiceNotConnectedException {
        try {
            return this.mService.isSupportDoubleThemeColor(effectType);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not isSupportDoubleThemeColor: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int requestPermission(boolean apply) throws XUIServiceNotConnectedException {
        try {
            return this.mService.requestPermission(apply);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not requestPermission: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int startPlay(String[] effectData) throws XUIServiceNotConnectedException {
        try {
            return this.mService.startPlay(effectData);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not startPlay: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int pausePlay() throws XUIServiceNotConnectedException {
        try {
            return this.mService.pausePlay();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not pausePlay: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int stopPlay() throws XUIServiceNotConnectedException {
        try {
            return this.mService.stopPlay();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not stopPlay: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    /* loaded from: classes.dex */
    public interface AmbientLightEventListener {
        void onErrorEvent(int i, int i2);

        default void onLightEffectTypeSetEvent(String effectType) {
        }

        default void onLightDoubleColorEnableEvent(String effectType, boolean enable) {
        }

        default void onLightMonoColorSetEvent(String effectType, int color) {
        }

        default void onLightDoubleColorSetEvent(String effectType, int first_color, int second_color) {
        }

        default void onLightBrightSetEvent(String effectType, int bright) {
        }

        default void onLightSwitchSetEvent(String effectType, boolean enable) {
        }
    }

    /* loaded from: classes.dex */
    private static final class EventCallbackHandler extends Handler {
        WeakReference<AmbientLightManager> mMgr;

        EventCallbackHandler(AmbientLightManager mgr, Looper looper) {
            super(looper);
            this.mMgr = new WeakReference<>(mgr);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            AmbientLightManager mgr = this.mMgr.get();
            switch (msg.what) {
                case 0:
                    if (mgr != null) {
                        mgr.dispatchErrorEventToClient(((Integer) msg.obj).intValue(), msg.arg1);
                        return;
                    }
                    return;
                case 1:
                    if (mgr != null) {
                        mgr.dispatchLightEffectTypeSetEventToClient((String) msg.obj);
                        return;
                    }
                    return;
                case 2:
                    if (mgr != null) {
                        Bundle bundle = msg.getData();
                        boolean enable = bundle.getBoolean("enable");
                        mgr.dispatchLightDoubleColorEnableEventToClient((String) msg.obj, enable);
                        return;
                    }
                    return;
                case 3:
                    if (mgr != null) {
                        mgr.dispatchLightMonoColorSetEventToClient((String) msg.obj, msg.arg1);
                        return;
                    }
                    return;
                case 4:
                    if (mgr != null) {
                        mgr.dispatchLightDoubleColorSetEventToClient((String) msg.obj, msg.arg1, msg.arg2);
                        return;
                    }
                    return;
                case 5:
                    if (mgr != null) {
                        mgr.dispatchLightBrightSetEventToClient((String) msg.obj, msg.arg1);
                        return;
                    }
                    return;
                case 6:
                    if (mgr != null) {
                        boolean enableLight = msg.arg1 == 1;
                        mgr.dispatchLightSwitchSetEventToClient((String) msg.obj, enableLight);
                        return;
                    }
                    return;
                default:
                    Log.e(AmbientLightManager.TAG, "Event type not handled");
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    private static class AmbientLightEventListenerToService extends IAmbientLightEventListener.Stub {
        private final WeakReference<AmbientLightManager> mManager;

        public AmbientLightEventListenerToService(AmbientLightManager manager) {
            this.mManager = new WeakReference<>(manager);
        }

        @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLightEventListener
        public void onError(int errorCode, int operation) {
            AmbientLightManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleErrorEvent(errorCode, operation);
            }
        }

        @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLightEventListener
        public void onAmbientLightSetEvent(int type, String effectType, int[] data) {
            boolean enableLight;
            AmbientLightManager manager = this.mManager.get();
            if (manager != null) {
                switch (type) {
                    case 1:
                        manager.handleLightEffectTypeSetEvent(effectType);
                        return;
                    case 2:
                        enableLight = data[0] != 0;
                        manager.handleLightDoubleColorEnableEvent(effectType, enableLight);
                        return;
                    case 3:
                        manager.handleLightMonoColorSetEvent(effectType, data[0]);
                        return;
                    case 4:
                        manager.handleLightDoubleColorSetEvent(effectType, data[0], data[1]);
                        return;
                    case 5:
                        manager.handleLightBrightSetEvent(effectType, data[0]);
                        return;
                    case 6:
                        enableLight = data[0] != 0;
                        manager.handleLightSwitchSetEvent(effectType, enableLight);
                        return;
                    default:
                        Log.e(AmbientLightManager.TAG, "Event type not handled ");
                        return;
                }
            }
        }
    }
}
