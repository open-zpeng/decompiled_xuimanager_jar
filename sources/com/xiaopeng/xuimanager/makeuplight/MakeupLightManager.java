package com.xiaopeng.xuimanager.makeuplight;

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
import com.xiaopeng.xuimanager.makeuplight.IMakeupLight;
import com.xiaopeng.xuimanager.makeuplight.IMakeupLightEventListener;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@SystemApi
/* loaded from: classes.dex */
public class MakeupLightManager implements XUIManagerBase {
    public static final int ERROR = 2;
    public static final int MSG_AVAILABLE = 0;
    public static final int MSG_COLORTEMP = 1;
    public static final int MSG_EFFECT = 3;
    public static final int MSG_LUMINANCE = 2;
    public static final int START = 0;
    public static final int STOP = 1;
    public static final String TAG = "MakeupLightManager";
    private static String mServiceName = null;
    private final Handler mHandler;
    private IMakeupLight mService;
    private final ArraySet<EventListener> mListeners = new ArraySet<>();
    private MakeupLightListenerToService mListenerToService = null;

    /* loaded from: classes.dex */
    public static class ColorTemperature {
        public int rgb;
        public int white;

        public ColorTemperature(int rgb, int white) {
            this.rgb = rgb;
            this.white = white;
        }
    }

    /* loaded from: classes.dex */
    public interface EventListener {
        default void onAvailable(boolean status) {
        }

        default void onColorTemperature(ColorTemperature colorTemperature) {
        }

        default void onLuminance(int lux) {
        }

        default void onStartEffect(String effect) {
        }

        default void onStopEffect(String effect) {
        }

        default void onErrorEffect(String effect) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchAvailableToClient(boolean status) {
        Collection<EventListener> listeners;
        synchronized (this) {
            listeners = this.mListeners;
        }
        if (!listeners.isEmpty()) {
            for (EventListener l : listeners) {
                l.onAvailable(status);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchColorTempToClient(int rgb, int white) {
        Collection<EventListener> listeners;
        synchronized (this) {
            listeners = this.mListeners;
        }
        if (!listeners.isEmpty()) {
            for (EventListener l : listeners) {
                l.onColorTemperature(new ColorTemperature(rgb, white));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchLuminanceToClient(int lux) {
        Collection<EventListener> listeners;
        synchronized (this) {
            listeners = this.mListeners;
        }
        if (!listeners.isEmpty()) {
            for (EventListener l : listeners) {
                l.onLuminance(lux);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchEffectToClient(String effect, int type) {
        Collection<EventListener> listeners;
        synchronized (this) {
            listeners = this.mListeners;
        }
        if (!listeners.isEmpty()) {
            for (EventListener l : listeners) {
                if (type == 0) {
                    l.onStartEffect(effect);
                } else if (type == 1) {
                    l.onStopEffect(effect);
                } else if (type == 2) {
                    l.onErrorEffect(effect);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAvailableEvent(boolean status) {
        Message message = this.mHandler.obtainMessage();
        message.what = 0;
        message.obj = Boolean.valueOf(status);
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleColorTemperatureEvent(int rgb, int white) {
        Message message = this.mHandler.obtainMessage();
        message.what = 1;
        message.arg1 = rgb;
        message.arg2 = white;
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLuminanceEvent(int lux) {
        Message message = this.mHandler.obtainMessage();
        message.what = 2;
        message.arg1 = lux;
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleEffectEvent(String effect, int type) {
        Message message = this.mHandler.obtainMessage();
        message.what = 3;
        message.obj = effect;
        message.arg1 = type;
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class MakeupLightListenerToService extends IMakeupLightEventListener.Stub {
        private final WeakReference<MakeupLightManager> mManager;

        public MakeupLightListenerToService(MakeupLightManager manager) {
            this.mManager = new WeakReference<>(manager);
        }

        @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLightEventListener
        public void onAvailableEvent(boolean status) {
            MakeupLightManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleAvailableEvent(status);
            }
        }

        @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLightEventListener
        public void onColorTemperatureEvent(int rgb, int white) {
            MakeupLightManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleColorTemperatureEvent(rgb, white);
            }
        }

        @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLightEventListener
        public void onLuminanceEvent(int lux) {
            MakeupLightManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleLuminanceEvent(lux);
            }
        }

        @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLightEventListener
        public void onEffectEvent(String effect, int type) {
            MakeupLightManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleEffectEvent(effect, type);
            }
        }
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIDisconnected() {
        Iterator<EventListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            EventListener l = it.next();
            try {
                unregisterListener(l);
            } catch (XUIServiceNotConnectedException e) {
            }
        }
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIConnected(IBinder service) {
        this.mService = IMakeupLight.Stub.asInterface(service);
        if (!this.mListeners.isEmpty()) {
            try {
                this.mListenerToService = new MakeupLightListenerToService(this);
                this.mService.registerListener(this.mListenerToService);
            } catch (RemoteException ex) {
                Log.e(TAG, "Could not connect to XUI: " + ex.toString());
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

    public synchronized void registerListener(EventListener listener) throws XUIServiceNotConnectedException {
        Log.d(TAG, "registerListener");
        if (this.mListeners.isEmpty()) {
            try {
                this.mListenerToService = new MakeupLightListenerToService(this);
                this.mService.registerListener(this.mListenerToService);
            } catch (RemoteException e) {
                Log.e(TAG, "Could not connect: " + e.toString());
                throw new XUIServiceNotConnectedException(e);
            } catch (IllegalStateException e2) {
                XUIManager.checkXUIServiceNotConnectedExceptionFromXUIService(e2);
            }
        }
        this.mListeners.add(listener);
    }

    public synchronized void unregisterListener(EventListener listener) throws XUIServiceNotConnectedException {
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

    public void loadMakeupEffect() throws XUIServiceNotConnectedException {
        try {
            this.mService.loadMakeupEffect();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not loadMakeupEffect: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public Set<String> showMakeupEffect() throws XUIServiceNotConnectedException {
        try {
            return new HashSet(this.mService.showMakeupEffect());
        } catch (RemoteException e) {
            Log.e(TAG, "Could not showMakeupEffect: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public Set<String> showAliasColorTemperature() throws XUIServiceNotConnectedException {
        try {
            return new HashSet(this.mService.showAliasColorTemperature());
        } catch (RemoteException e) {
            Log.e(TAG, "Could not showAliasColorTemperature: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int getMakeupAvailable() throws XUIServiceNotConnectedException {
        try {
            return this.mService.getMakeupAvailable();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getMakeupAvailable: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int setColorTemperature(ColorTemperature colorTemperature) throws XUIServiceNotConnectedException {
        try {
            return this.mService.setColorTemperature(colorTemperature.rgb, colorTemperature.white);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setColorTemperature: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int setColorTemperature(String alias) throws XUIServiceNotConnectedException {
        try {
            return this.mService.setAliasColorTemperature(alias);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setAliasColorTemperature: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public ColorTemperature getColorTemperature() throws XUIServiceNotConnectedException {
        try {
            List<Integer> res = (List) this.mService.getColorTemperature().stream().map(new Function() { // from class: com.xiaopeng.xuimanager.makeuplight.-$$Lambda$JWLUSa4hQWAZf1TfuyVGazguidI
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Integer.valueOf(Integer.parseInt((String) obj));
                }
            }).collect(Collectors.toList());
            return res.size() == 2 ? new ColorTemperature(res.get(0).intValue(), res.get(1).intValue()) : new ColorTemperature(-1, -1);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getColorTemperature: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int setLuminance(int lux) throws XUIServiceNotConnectedException {
        try {
            return this.mService.setLuminance(lux);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setLuminance: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int getLuminance() throws XUIServiceNotConnectedException {
        try {
            return this.mService.getLuminance();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getLuminance: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int runEffect(String effect, int count) throws XUIServiceNotConnectedException {
        try {
            return this.mService.runEffect(effect, count);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not runEffect: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int stopEffect() throws XUIServiceNotConnectedException {
        try {
            return this.mService.stopEffect();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not stopEffect: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    /* loaded from: classes.dex */
    private static final class EventCallbackHandler extends Handler {
        WeakReference<MakeupLightManager> mManager;

        EventCallbackHandler(MakeupLightManager manager, Looper looper) {
            super(looper);
            this.mManager = new WeakReference<>(manager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            MakeupLightManager manager = this.mManager.get();
            if (manager == null) {
                return;
            }
            int i = msg.what;
            if (i == 0) {
                manager.dispatchAvailableToClient(((Boolean) msg.obj).booleanValue());
            } else if (i == 1) {
                manager.dispatchColorTempToClient(msg.arg1, msg.arg2);
            } else if (i == 2) {
                manager.dispatchLuminanceToClient(msg.arg1);
            } else if (i == 3) {
                manager.dispatchEffectToClient((String) msg.obj, msg.arg1);
            } else {
                Log.e(MakeupLightManager.TAG, "Event type not handled?" + msg);
            }
        }
    }

    public MakeupLightManager(IBinder service, Context context, Handler handler) {
        this.mService = IMakeupLight.Stub.asInterface(service);
        this.mHandler = new EventCallbackHandler(this, handler.getLooper());
    }
}
