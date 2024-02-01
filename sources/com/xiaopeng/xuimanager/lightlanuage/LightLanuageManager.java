package com.xiaopeng.xuimanager.lightlanuage;

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
import com.xiaopeng.xuimanager.lightlanuage.ILightLanuage;
import com.xiaopeng.xuimanager.lightlanuage.ILightLanuageEventListener;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@SystemApi
/* loaded from: classes.dex */
public class LightLanuageManager implements XUIManagerBase {
    public static final boolean DBG = false;
    private static final int MSG_ERROR_EVENT = 4;
    private static final int MSG_FINISH_EVENT = 3;
    private static final int MSG_START_EVENT = 1;
    private static final int MSG_STOP_EVENT = 2;
    private static final int MSG_UPGRADE_EVENT = 5;
    public static final String TAG = "LightLanuageManager";
    private static String mServiceName = null;
    private final Handler mHandler;
    private ILightLanuage mService;
    private final ArraySet<EventListener> mListeners = new ArraySet<>();
    private LightLanuageListenerToService mListenerToService = null;

    /* loaded from: classes.dex */
    public interface EventListener {
        default void onStart(String name, String type) {
        }

        default void onStop(String name, String type) {
        }

        default void onFinish(String name, String type) {
        }

        default void onError(String name, int errCode) {
        }

        default void onUpgrade(int name, int mode) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class EventMessage {
        String name;
        String type;

        public EventMessage(String name, String type) {
            this.name = name;
            this.type = type;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchStartEventToClient(String name, String type) {
        Collection<EventListener> listeners;
        synchronized (this) {
            listeners = this.mListeners;
        }
        if (!listeners.isEmpty()) {
            Log.i(TAG, "onStart, name=" + name + ", type=" + type);
            for (EventListener l : listeners) {
                l.onStart(name, type);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchStopEventToClient(String name, String type) {
        Collection<EventListener> listeners;
        synchronized (this) {
            listeners = this.mListeners;
        }
        if (!listeners.isEmpty()) {
            Log.i(TAG, "onStop, name=" + name + ", type=" + type);
            for (EventListener l : listeners) {
                l.onStop(name, type);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchFinishEventToClient(String name, String type) {
        Collection<EventListener> listeners;
        synchronized (this) {
            listeners = this.mListeners;
        }
        if (!listeners.isEmpty()) {
            Log.i(TAG, "onFinish, name=" + name + ", type=" + type);
            for (EventListener l : listeners) {
                l.onFinish(name, type);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchErrorEventToClient(String name, int errCode) {
        Collection<EventListener> listeners;
        synchronized (this) {
            listeners = this.mListeners;
        }
        if (!listeners.isEmpty()) {
            Log.i(TAG, "onError, name=" + name + ", errCode=" + errCode);
            for (EventListener l : listeners) {
                l.onError(name, errCode);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchUpgradeEventToClient(int name, int mode) {
        Collection<EventListener> listeners;
        synchronized (this) {
            listeners = this.mListeners;
        }
        if (!listeners.isEmpty()) {
            Log.i(TAG, "onUpgrade, name=" + name + ", mode=" + mode);
            for (EventListener l : listeners) {
                l.onUpgrade(name, mode);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStartEvent(String name, String type) {
        Message message = this.mHandler.obtainMessage();
        message.what = 1;
        message.obj = new EventMessage(name, type);
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopEvent(String name, String type) {
        Message message = this.mHandler.obtainMessage();
        message.what = 2;
        message.obj = new EventMessage(name, type);
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFinishEvent(String name, String type) {
        Message message = this.mHandler.obtainMessage();
        message.what = 3;
        message.obj = new EventMessage(name, type);
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleErrorEvent(String name, int errCode) {
        Message message = this.mHandler.obtainMessage();
        message.what = 4;
        message.obj = name;
        message.arg1 = errCode;
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpgradeEvent(int name, int mode) {
        Message message = this.mHandler.obtainMessage();
        message.what = 5;
        message.obj = Integer.valueOf(name);
        message.arg1 = mode;
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class LightLanuageListenerToService extends ILightLanuageEventListener.Stub {
        private final WeakReference<LightLanuageManager> mManager;

        public LightLanuageListenerToService(LightLanuageManager manager) {
            this.mManager = new WeakReference<>(manager);
        }

        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuageEventListener
        public void onStartEvent(String name, String type) {
            LightLanuageManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleStartEvent(name, type);
            }
        }

        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuageEventListener
        public void onStopEvent(String name, String type) {
            LightLanuageManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleStopEvent(name, type);
            }
        }

        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuageEventListener
        public void onFinishEvent(String name, String type) {
            LightLanuageManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleFinishEvent(name, type);
            }
        }

        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuageEventListener
        public void onErrorEvent(String name, int errCode) {
            LightLanuageManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleErrorEvent(name, errCode);
            }
        }

        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuageEventListener
        public void onUpgradeEvent(int name, int mode) {
            LightLanuageManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleUpgradeEvent(name, mode);
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
        this.mService = ILightLanuage.Stub.asInterface(service);
        if (!this.mListeners.isEmpty()) {
            try {
                this.mListenerToService = new LightLanuageListenerToService(this);
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
                this.mListenerToService = new LightLanuageListenerToService(this);
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

    public void loadLightEffect() throws XUIServiceNotConnectedException {
        try {
            this.mService.loadLightEffect();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not loadLightEffect: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public List<String> getLightEffect() throws XUIServiceNotConnectedException {
        try {
            return this.mService.getLightEffect();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getLightEffect: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public String getUserEffectInfoList() throws XUIServiceNotConnectedException {
        try {
            return this.mService.getUserEffectInfoList();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getUserEffectInfoList: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public String getUserEffectInfo(String subdir) throws XUIServiceNotConnectedException {
        try {
            return this.mService.getUserEffectInfo(subdir);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getUserEffectInfo: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public String getLocalDanceEffectInfo() throws XUIServiceNotConnectedException {
        try {
            return this.mService.getLocalDanceEffectInfo();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getLocalDanceEffectInfo: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public boolean getSayhiEffectEnable() throws XUIServiceNotConnectedException {
        try {
            return this.mService.getSayhiEffectEnable();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getSayhiEffectEnable: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setSayhiEffectEnable(boolean enable) throws XUIServiceNotConnectedException {
        try {
            this.mService.setSayhiEffectEnable(enable);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setSayhiEffectEnable: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public boolean getRhythmEffectEnable() throws XUIServiceNotConnectedException {
        try {
            return this.mService.getRhythmEffectEnable();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getRhythmEffectEnable: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setRhythmEffectEnable(boolean enable) throws XUIServiceNotConnectedException {
        try {
            this.mService.setRhythmEffectEnable(enable);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setRhythmEffectEnable: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public boolean getLightEffectEnable() throws XUIServiceNotConnectedException {
        try {
            return this.mService.getLightEffectEnable();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getLightEffectEnable: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setLightEffectEnable(boolean enable) throws XUIServiceNotConnectedException {
        try {
            this.mService.setLightEffectEnable(enable);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setLightEffectEnable: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int getMcuEffect(int name) throws XUIServiceNotConnectedException {
        try {
            return this.mService.getMcuEffect(name);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getMcuEffect: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setMcuEffect(int name, int mode) throws XUIServiceNotConnectedException {
        try {
            this.mService.setMcuEffect(name, mode);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setMcuEffect: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public String getRhythmEffect() throws XUIServiceNotConnectedException {
        try {
            return this.mService.getRhythmEffect();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getRhythmEffect: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setRhythmEffect(String name) throws XUIServiceNotConnectedException {
        try {
            this.mService.setRhythmEffect(name);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setRhythmEffect: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public String getRunningEffect() throws XUIServiceNotConnectedException {
        try {
            return this.mService.getRunningEffect();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getRunningEffect: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public boolean isDanceEffectRunning() throws XUIServiceNotConnectedException {
        try {
            return this.mService.isDanceEffectRunning();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not isDanceEffectRunning: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int getDanceEffectRunnable() throws XUIServiceNotConnectedException {
        try {
            return this.mService.getDanceEffectRunnable();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getDanceEffectRunnable: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int playEffect(String name, int count) throws XUIServiceNotConnectedException {
        try {
            return this.mService.playEffect(name, count);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not playEffect: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void stopEffect() throws XUIServiceNotConnectedException {
        try {
            this.mService.stopEffect();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not stopEffect: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void playSmartEffect(int type) throws XUIServiceNotConnectedException {
        try {
            this.mService.playSmartEffect(type);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not playSmartEffect: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void stopSmartEffect() throws XUIServiceNotConnectedException {
        try {
            this.mService.stopSmartEffect();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not stopSmartEffect: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    /* loaded from: classes.dex */
    private static final class EventCallbackHandler extends Handler {
        WeakReference<LightLanuageManager> mManager;

        EventCallbackHandler(LightLanuageManager manager, Looper looper) {
            super(looper);
            this.mManager = new WeakReference<>(manager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            LightLanuageManager manager = this.mManager.get();
            if (manager == null) {
                return;
            }
            int i = msg.what;
            if (i == 1) {
                EventMessage message = (EventMessage) msg.obj;
                manager.dispatchStartEventToClient(message.name, message.type);
            } else if (i == 2) {
                EventMessage message2 = (EventMessage) msg.obj;
                manager.dispatchStopEventToClient(message2.name, message2.type);
            } else if (i == 3) {
                EventMessage message3 = (EventMessage) msg.obj;
                manager.dispatchFinishEventToClient(message3.name, message3.type);
            } else if (i == 4) {
                manager.dispatchErrorEventToClient((String) msg.obj, msg.arg1);
            } else if (i == 5) {
                manager.dispatchUpgradeEventToClient(((Integer) msg.obj).intValue(), msg.arg1);
            } else {
                Log.e(LightLanuageManager.TAG, "Event type not handled?" + msg);
            }
        }
    }

    public LightLanuageManager(IBinder service, Context context, Handler handler) {
        this.mService = ILightLanuage.Stub.asInterface(service);
        this.mHandler = new EventCallbackHandler(this, handler.getLooper());
    }
}
