package com.xiaopeng.xuimanager.condition;

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
import com.xiaopeng.xuimanager.condition.ConditionManager;
import com.xiaopeng.xuimanager.condition.IBrightnessLevelListener;
import com.xiaopeng.xuimanager.condition.ICondition;
import com.xiaopeng.xuimanager.condition.ITwilightStateListener;
import com.xiaopeng.xuimanager.utils.LogUtil;
import java.lang.ref.WeakReference;
import java.util.function.Consumer;

/* loaded from: classes.dex */
public class ConditionManager implements XUIManagerBase {
    private static final int MSG_BRIGHTNESS_CHANGE_EVENT = 2;
    private static final int MSG_TWILIGHT_CHANGE_EVENT = 1;
    private static final String TAG = ConditionManager.class.getSimpleName();
    private final ArraySet<BrightnessLevelListener> mBrightnessLevelListeners;
    private BrightnessLevelToService mBrightnessLevelToService;
    private Handler mHandler;
    private ICondition mService;
    private String mServiceName;
    private TwilightListenerToService mTwilightListenerToService;
    private final ArraySet<TwilightStateListener> mTwilightStateListeners;

    /* loaded from: classes.dex */
    public interface BrightnessLevelListener {
        void onBrightnessLevelChanged(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface ConditionListener {
        void onConditionChanged(int i);
    }

    /* loaded from: classes.dex */
    public interface TwilightStateListener {
        void onTwilightStateChanged(TwilightState twilightState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ConditionManagerHolder {
        private static ConditionManager instance = new ConditionManager();

        private ConditionManagerHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class TwilightListenerToService extends ITwilightStateListener.Stub {
        private final WeakReference<ConditionManager> mManager;

        public TwilightListenerToService(ConditionManager manager) {
            this.mManager = new WeakReference<>(manager);
        }

        @Override // com.xiaopeng.xuimanager.condition.ITwilightStateListener
        public void onTwilightStateChanged(TwilightState twilightState) throws RemoteException {
            ConditionManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleTwilightChanged(twilightState);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class BrightnessLevelToService extends IBrightnessLevelListener.Stub {
        private final WeakReference<ConditionManager> mManager;

        public BrightnessLevelToService(ConditionManager manager) {
            this.mManager = new WeakReference<>(manager);
        }

        @Override // com.xiaopeng.xuimanager.condition.IBrightnessLevelListener
        public void onBrightnessLevelChanged(int prevLevel, int newLevel) throws RemoteException {
            ConditionManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleBrightnessLevelChanged(prevLevel, newLevel);
            }
        }
    }

    private ConditionManager() {
        this.mTwilightStateListeners = new ArraySet<>();
        this.mTwilightListenerToService = null;
        this.mBrightnessLevelListeners = new ArraySet<>();
        this.mBrightnessLevelToService = null;
    }

    public static ConditionManager getInstance() {
        return ConditionManagerHolder.instance;
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void init(IBinder service, Context context, Handler handler) {
        this.mService = ICondition.Stub.asInterface(service);
        this.mHandler = new EventCallbackHandler(this, handler.getLooper());
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void setServiceName(String name) {
        this.mServiceName = name;
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public String getServiceName() {
        if (this.mServiceName == null) {
            this.mServiceName = getClass().getSimpleName();
        }
        return this.mServiceName;
    }

    public int createCondition(String json) {
        return 0;
    }

    public void releaseCondition(int conditionId) {
    }

    public boolean isConditionMatch(int conditionId) {
        return false;
    }

    public void startWatchCondition(int conditionId) {
    }

    public void stopWatchCondition(int conditionId) {
    }

    public void addConditionListener(int conditionId, IConditionListener listener) {
    }

    public void removeConditionListener(int conditionId, IConditionListener listener) {
    }

    public TwilightState getTwilightState() throws XUIServiceNotConnectedException {
        try {
            return this.mService.getTwilightState();
        } catch (RemoteException e) {
            String str = TAG;
            LogUtil.i(str, "getTwilightState error, " + e.getMessage());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void registerTwilightStateListener(TwilightStateListener listener) throws XUIServiceNotConnectedException {
        initTwilightStateRegisterListener();
        this.mTwilightStateListeners.add(listener);
    }

    public void unregisterTwilightStateListener(TwilightStateListener listener) throws XUIServiceNotConnectedException {
        this.mTwilightStateListeners.remove(listener);
        initTwilightStateUnregisterListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTwilightChanged(TwilightState twilightState) {
        Message message = this.mHandler.obtainMessage();
        message.what = 1;
        message.obj = twilightState;
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchTwilightChangedToClient(final TwilightState twilightState) {
        this.mTwilightStateListeners.forEach(new Consumer() { // from class: com.xiaopeng.xuimanager.condition.-$$Lambda$ConditionManager$PV1qdizPdtLOjXXaafZ8cdOpw_c
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ConditionManager.lambda$dispatchTwilightChangedToClient$0(TwilightState.this, (ConditionManager.TwilightStateListener) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$dispatchTwilightChangedToClient$0(TwilightState twilightState, TwilightStateListener l) {
        try {
            l.onTwilightStateChanged(twilightState);
        } catch (Exception e) {
            String str = TAG;
            LogUtil.i(str, "client error in onTwilightStateChanged callback, " + e.getMessage());
        }
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIDisconnected() {
        this.mTwilightStateListeners.forEach(new Consumer() { // from class: com.xiaopeng.xuimanager.condition.-$$Lambda$ConditionManager$ndCyLJJqeEssyv057xLy_aZlWLM
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ConditionManager.this.lambda$onXUIDisconnected$1$ConditionManager((ConditionManager.TwilightStateListener) obj);
            }
        });
    }

    public /* synthetic */ void lambda$onXUIDisconnected$1$ConditionManager(TwilightStateListener l) {
        try {
            unregisterTwilightStateListener(l);
        } catch (Exception e) {
            String str = TAG;
            LogUtil.i(str, "unregisterTwilightStateListener, " + e.getMessage());
        }
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIConnected(IBinder binder) {
        super.onXUIConnected(binder);
        this.mService = ICondition.Stub.asInterface(binder);
    }

    /* loaded from: classes.dex */
    private static final class EventCallbackHandler extends Handler {
        WeakReference<ConditionManager> mManager;

        EventCallbackHandler(ConditionManager manager, Looper looper) {
            super(looper);
            this.mManager = new WeakReference<>(manager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            ConditionManager manager = this.mManager.get();
            if (manager == null) {
                return;
            }
            int i = msg.what;
            if (i == 1) {
                manager.dispatchTwilightChangedToClient((TwilightState) msg.obj);
            } else if (i != 2) {
                String str = ConditionManager.TAG;
                Log.e(str, "handleMessage unknown msg " + msg.what);
            } else {
                manager.dispatchBrightnessLevelChangedToClient(msg.arg1, msg.arg2);
            }
        }
    }

    private void initTwilightStateRegisterListener() throws XUIServiceNotConnectedException {
        if (this.mTwilightStateListeners.isEmpty()) {
            try {
                this.mTwilightListenerToService = new TwilightListenerToService(this);
                this.mService.registerTwilightStateListener(this.mTwilightListenerToService);
            } catch (RemoteException ex) {
                String str = TAG;
                Log.e(str, "Could not connect: " + ex.toString());
                throw new XUIServiceNotConnectedException(ex);
            } catch (IllegalStateException ex2) {
                XUIManager.checkXUIServiceNotConnectedExceptionFromXUIService(ex2);
            } catch (Exception e) {
                String str2 = TAG;
                Log.e(str2, ": " + e.toString());
            }
        }
    }

    private void initTwilightStateUnregisterListener() throws XUIServiceNotConnectedException {
        TwilightListenerToService twilightListenerToService;
        if (this.mTwilightStateListeners.isEmpty() && (twilightListenerToService = this.mTwilightListenerToService) != null) {
            try {
                this.mService.unregisterTwilightStateListener(twilightListenerToService);
                this.mTwilightListenerToService = null;
            } catch (RemoteException e) {
                String str = TAG;
                Log.e(str, "Could not unregister: " + e.toString());
                throw new XUIServiceNotConnectedException(e);
            }
        }
    }

    public void registerBrightnessLevelListener(BrightnessLevelListener listener) throws XUIServiceNotConnectedException {
        initBrightnessLevelRegisterListener();
        this.mBrightnessLevelListeners.add(listener);
    }

    public void unregisterBrightnessLevelListener(BrightnessLevelListener listener) throws XUIServiceNotConnectedException {
        this.mBrightnessLevelListeners.remove(listener);
        initBrightnessLevelUnregisterListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBrightnessLevelChanged(int prevLevel, int newLevel) {
        Message message = this.mHandler.obtainMessage();
        message.what = 2;
        message.arg1 = prevLevel;
        message.arg2 = newLevel;
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchBrightnessLevelChangedToClient(final int prevLevel, final int newLevel) {
        this.mBrightnessLevelListeners.forEach(new Consumer() { // from class: com.xiaopeng.xuimanager.condition.-$$Lambda$ConditionManager$GeoUdgp9TYyyM4CemMdiKrYTAQA
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ConditionManager.lambda$dispatchBrightnessLevelChangedToClient$2(prevLevel, newLevel, (ConditionManager.BrightnessLevelListener) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$dispatchBrightnessLevelChangedToClient$2(int prevLevel, int newLevel, BrightnessLevelListener l) {
        try {
            l.onBrightnessLevelChanged(prevLevel, newLevel);
        } catch (Exception e) {
            String str = TAG;
            LogUtil.i(str, "client error in onBrightnessLevelChanged callback, " + e.getMessage());
        }
    }

    public int getBrightnessLevel() throws XUIServiceNotConnectedException {
        try {
            return this.mService.getBrightnessLevel();
        } catch (RemoteException e) {
            String str = TAG;
            LogUtil.i(str, "getBrightnessLevel error, " + e.getMessage());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    private void initBrightnessLevelRegisterListener() throws XUIServiceNotConnectedException {
        if (this.mBrightnessLevelListeners.isEmpty()) {
            try {
                this.mBrightnessLevelToService = new BrightnessLevelToService(this);
                this.mService.registerBrightnessLevelListener(this.mBrightnessLevelToService);
            } catch (RemoteException ex) {
                String str = TAG;
                Log.e(str, "Could not connect: " + ex.toString());
                throw new XUIServiceNotConnectedException(ex);
            } catch (IllegalStateException ex2) {
                XUIManager.checkXUIServiceNotConnectedExceptionFromXUIService(ex2);
            } catch (Exception e) {
                String str2 = TAG;
                Log.e(str2, ": " + e.toString());
            }
        }
    }

    private void initBrightnessLevelUnregisterListener() throws XUIServiceNotConnectedException {
        BrightnessLevelToService brightnessLevelToService;
        if (this.mBrightnessLevelListeners.isEmpty() && (brightnessLevelToService = this.mBrightnessLevelToService) != null) {
            try {
                this.mService.unregisterBrightnessLevelListener(brightnessLevelToService);
                this.mBrightnessLevelToService = null;
            } catch (RemoteException e) {
                String str = TAG;
                Log.e(str, "Could not unregister: " + e.toString());
                throw new XUIServiceNotConnectedException(e);
            }
        }
    }
}
