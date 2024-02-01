package com.xiaopeng.xuimanager.sysconfig;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.ArraySet;
import android.util.Log;
import com.xiaopeng.sysconfig.SysConfigManager;
import com.xiaopeng.xuimanager.XUIManagerBase;
import com.xiaopeng.xuimanager.sysconfig.ISysConfig;
import com.xiaopeng.xuimanager.sysconfig.ISysConfigListener;
import com.xiaopeng.xuimanager.utils.LogUtil;
import java.lang.ref.WeakReference;
import java.util.function.Consumer;
/* loaded from: classes.dex */
public class SysConfigManagerImpl implements XUIManagerBase, SysConfigManager {
    private static final int EVENT_MSG_HANDLE_SYS_CONFIG_UPDATE = 1;
    private static final String TAG = SysConfigManagerImpl.class.getSimpleName();
    private Handler mHandler;
    private ISysConfig mService;
    private boolean serverDisconnected;
    private String serviceName;
    private SysConfigListenerToService sysConfigListenerToService;
    private final ArraySet<SysConfigManager.SysConfigListener> sysConfigListeners;

    /* loaded from: classes.dex */
    private static final class SingleInstanceHolder {
        private static final SysConfigManagerImpl INSTANCE = new SysConfigManagerImpl();

        private SingleInstanceHolder() {
        }
    }

    private SysConfigManagerImpl() {
        this.sysConfigListeners = new ArraySet<>();
        this.serverDisconnected = false;
    }

    public static SysConfigManagerImpl getInstance() {
        return SingleInstanceHolder.INSTANCE;
    }

    public void registerConfigUpdateListener(SysConfigManager.SysConfigListener listener) {
        if (this.sysConfigListeners.add(listener) && this.sysConfigListeners.size() == 1) {
            try {
                this.sysConfigListenerToService = new SysConfigListenerToService(this);
                this.mService.registerSysConfigListener(this.sysConfigListenerToService);
            } catch (Exception e) {
                String str = TAG;
                Log.e(str, "registerConfigUpdateListener error: " + e, e);
            }
        }
    }

    public void unregisterConfigUpdateListener(SysConfigManager.SysConfigListener listener) {
        if (this.sysConfigListeners.remove(listener) && this.sysConfigListeners.isEmpty() && this.sysConfigListenerToService != null) {
            try {
                this.mService.unregisterSysConfigListener(this.sysConfigListenerToService);
            } catch (Exception e) {
                String str = TAG;
                Log.e(str, "unregisterConfigUpdateListener error: " + e, e);
            }
            this.sysConfigListenerToService = null;
        }
    }

    /* loaded from: classes.dex */
    private static class SysConfigListenerToService extends ISysConfigListener.Stub {
        private final WeakReference<SysConfigManagerImpl> mManager;

        public SysConfigListenerToService(SysConfigManagerImpl manager) {
            this.mManager = new WeakReference<>(manager);
        }

        @Override // com.xiaopeng.xuimanager.sysconfig.ISysConfigListener
        public void onSysConfigChanged(String fileName) throws RemoteException {
            SysConfigManagerImpl manager = this.mManager.get();
            if (manager != null) {
                manager.handleSysConfigUpdated(fileName);
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class EventCallbackHandler extends Handler {
        WeakReference<SysConfigManagerImpl> mManager;

        EventCallbackHandler(SysConfigManagerImpl manager, Looper looper) {
            super(looper);
            this.mManager = new WeakReference<>(manager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            SysConfigManagerImpl manager = this.mManager.get();
            if (manager != null && msg.what == 1) {
                String fileName = (String) msg.obj;
                manager.dispatchSysConfigUpdated(fileName);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSysConfigUpdated(String fileName) {
        Message.obtain(this.mHandler, 1, fileName).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchSysConfigUpdated(final String fileName) {
        this.sysConfigListeners.forEach(new Consumer() { // from class: com.xiaopeng.xuimanager.sysconfig.-$$Lambda$SysConfigManagerImpl$WvlyxnTB79wSbXNqrnaJy97t5_4
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                SysConfigManagerImpl.lambda$dispatchSysConfigUpdated$0(fileName, (SysConfigManager.SysConfigListener) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$dispatchSysConfigUpdated$0(String fileName, SysConfigManager.SysConfigListener l) {
        try {
            l.onSysConfigUpdated(fileName);
        } catch (Exception e) {
            String str = TAG;
            LogUtil.e(str, "user onSysConfigUpdated crash, crash listener=" + l, e);
        }
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void init(IBinder service, Context context, Handler handler) {
        super.init(service, context, handler);
        this.mService = ISysConfig.Stub.asInterface(service);
        this.mHandler = new EventCallbackHandler(this, handler.getLooper());
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIDisconnected() {
        LogUtil.i(TAG, "onXUIDisconnected");
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void setServiceName(String name) {
        this.serviceName = name;
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public String getServiceName() {
        return this.serviceName;
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIConnected(IBinder service) {
        super.onXUIConnected(service);
        if (!this.serverDisconnected) {
            return;
        }
        this.serverDisconnected = false;
        this.mService = ISysConfig.Stub.asInterface(service);
        if (this.sysConfigListenerToService != null) {
            try {
                this.mService.registerSysConfigListener(this.sysConfigListenerToService);
            } catch (Exception e) {
                String str = TAG;
                Log.e(str, "onXUIConnected e=" + e);
            }
        }
        LogUtil.i(TAG, "onXUIConnected");
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onServerDisconnected() {
        super.onServerDisconnected();
        LogUtil.i(TAG, "onServerDisconnected");
        this.serverDisconnected = true;
    }
}
