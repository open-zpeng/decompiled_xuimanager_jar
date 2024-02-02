package com.xiaopeng.xuimanager.systemui;

import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.xiaopeng.xuimanager.systemui.ISystemUIService;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SystemUIClient {
    private static final int MAX_RETRY_COUNT = 150;
    private static final int RETRY_DELAY_TIME = 200;
    private static final String TAG = "Client";
    private int connectRetryCount;
    private final IBinder.DeathRecipient mDeathRecipient;
    private final CopyOnWriteArraySet<ServerListener> mServerListeners;
    private ISystemUIService mSystemUIService;
    private final Handler mUiHandler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface ServerListener {
        void onServerConnected(ISystemUIService iSystemUIService);

        void onServerDisconnected();
    }

    private SystemUIClient() {
        SysLogUtils.i(TAG, "SystemUIClient created");
        this.mServerListeners = new CopyOnWriteArraySet<>();
        this.connectRetryCount = 0;
        this.mUiHandler = new Handler(Looper.getMainLooper()) { // from class: com.xiaopeng.xuimanager.systemui.SystemUIClient.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                SysLogUtils.d(SystemUIClient.TAG, "get msg=" + msg.what);
                if (msg.what == 1) {
                    SystemUIClient.this.selfGetService();
                }
            }
        };
        this.mDeathRecipient = new IBinder.DeathRecipient() { // from class: com.xiaopeng.xuimanager.systemui.-$$Lambda$SystemUIClient$B5I5JvBkmmX3LBBYGYMLy1jlyuY
            @Override // android.os.IBinder.DeathRecipient
            public final void binderDied() {
                SystemUIClient.lambda$new$0(SystemUIClient.this);
            }
        };
        selfGetService();
    }

    public static /* synthetic */ void lambda$new$0(SystemUIClient systemUIClient) {
        SysLogUtils.w(TAG, "SystemUI Service died");
        systemUIClient.mSystemUIService = null;
        systemUIClient.connectRetryCount = 0;
        systemUIClient.mUiHandler.sendEmptyMessageDelayed(1, 200L);
        systemUIClient.notifyServerDisConnect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selfGetService() {
        if (this.mSystemUIService == null) {
            IBinder binder = ServiceManager.getService("SystemUIService");
            SysLogUtils.i(TAG, "selfGetService get " + binder);
            if (binder != null) {
                try {
                    binder.linkToDeath(this.mDeathRecipient, 0);
                } catch (RemoteException e) {
                    SysLogUtils.e(TAG, "linkToDeath exception=" + e.getMessage());
                }
                this.mSystemUIService = ISystemUIService.Stub.asInterface(binder);
                this.connectRetryCount = 0;
                notifyServerConnect(this.mSystemUIService);
            } else if (this.connectRetryCount < MAX_RETRY_COUNT) {
                this.connectRetryCount++;
                this.mUiHandler.sendEmptyMessageDelayed(1, 200L);
            }
        }
    }

    private void notifyServerConnect(ISystemUIService service) {
        Iterator<ServerListener> it = this.mServerListeners.iterator();
        while (it.hasNext()) {
            ServerListener listener = it.next();
            listener.onServerConnected(service);
        }
    }

    private void notifyServerDisConnect() {
        Iterator<ServerListener> it = this.mServerListeners.iterator();
        while (it.hasNext()) {
            ServerListener listener = it.next();
            listener.onServerDisconnected();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ISystemUIService getSystemUIService() {
        selfGetService();
        return this.mSystemUIService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addServerListener(ServerListener listener) {
        this.mServerListeners.add(listener);
        SysLogUtils.i(TAG, "addServerListener=" + listener);
    }

    void removeServerListener(ServerListener listener) {
        this.mServerListeners.remove(listener);
        SysLogUtils.i(TAG, "removeServerListener=" + listener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SystemUIClient get() {
        return Holder.sInstance;
    }

    /* loaded from: classes.dex */
    private static class Holder {
        private static final SystemUIClient sInstance = new SystemUIClient();

        private Holder() {
        }
    }
}
