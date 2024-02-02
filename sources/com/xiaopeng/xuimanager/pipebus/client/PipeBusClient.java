package com.xiaopeng.xuimanager.pipebus.client;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.xiaopeng.xuimanager.pipebus.IPipeBus;
import com.xiaopeng.xuimanager.pipebus.IPipeBusListener;
import com.xiaopeng.xuimanager.pipebus.ParcelableContainer;
import com.xiaopeng.xuimanager.utils.LogUtil;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class PipeBusClient {
    private static final int MAX_RETRY_CNT = 300;
    private static final int MSG_CONNECT_SERVICE = 1;
    private String TAG;
    private boolean clientInit;
    private int connectRetryCount;
    private IPipeBusListener mBusListener;
    private WeakReference<Context> mContextRef;
    private IBinder.DeathRecipient mDeathRecipient;
    private final Map<String, IPipebusClientListener> mModuleListenerMap;
    private IPipeBus mPipeBusClient;
    private String mServiceName;
    private Handler mUiHandler;
    private static final String[] stringArray = new String[1];
    private static final ParcelableContainer sParcelableData = new ParcelableContainer();

    /* loaded from: classes.dex */
    public interface IPipebusClientListener {
        void onPipeBusEvent(String str, String[] strArr);

        void onPipeBusParcelEvent(String str, ParcelableContainer parcelableContainer);
    }

    /* loaded from: classes.dex */
    private class BusListener extends IPipeBusListener.Stub {
        private final String TAGBUS;

        private BusListener() {
            this.TAGBUS = PipeBusClient.this.TAG + "-Bus";
        }

        @Override // com.xiaopeng.xuimanager.pipebus.IPipeBusListener
        public void onPipeBusEvent(String module, String types, String[] events) throws RemoteException {
            String str = this.TAGBUS;
            LogUtil.i(str, "onPipeBusEvent,module=" + module + ",types=" + types + ",event=" + Arrays.toString(events));
            IPipebusClientListener listener = (IPipebusClientListener) PipeBusClient.this.mModuleListenerMap.get(module);
            if (listener != null) {
                listener.onPipeBusEvent(types, events);
                return;
            }
            String str2 = this.TAGBUS;
            LogUtil.w(str2, "no listener for module:" + module);
        }

        @Override // com.xiaopeng.xuimanager.pipebus.IPipeBusListener
        public void onPipeBusParcelEvent(String module, String types, ParcelableContainer data) throws RemoteException {
            String str = this.TAGBUS;
            LogUtil.i(str, "onPipeBusParcelEvent,module=" + module + ",types=" + types + ",data=" + data);
            IPipebusClientListener listener = (IPipebusClientListener) PipeBusClient.this.mModuleListenerMap.get(module);
            if (listener != null) {
                listener.onPipeBusParcelEvent(types, data);
                return;
            }
            String str2 = this.TAGBUS;
            LogUtil.w(str2, "no listener for module:" + module);
        }
    }

    private PipeBusClient() {
        this.TAG = getClass().getSimpleName();
        this.clientInit = false;
        this.connectRetryCount = 0;
        this.mModuleListenerMap = new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PipeBusClient(String serviceName) {
        this.TAG = getClass().getSimpleName();
        this.clientInit = false;
        this.connectRetryCount = 0;
        this.mModuleListenerMap = new ConcurrentHashMap();
        this.mServiceName = serviceName;
        this.connectRetryCount = 0;
        this.mUiHandler = new Handler(Looper.getMainLooper()) { // from class: com.xiaopeng.xuimanager.pipebus.client.PipeBusClient.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                String str = PipeBusClient.this.TAG;
                LogUtil.i(str, "get msg=" + msg.what);
                if (msg.what == 1) {
                    PipeBusClient.this.handleGetService();
                }
            }
        };
        this.mDeathRecipient = new IBinder.DeathRecipient() { // from class: com.xiaopeng.xuimanager.pipebus.client.PipeBusClient.2
            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                LogUtil.w(PipeBusClient.this.TAG, "died~");
                PipeBusClient.this.mPipeBusClient = null;
                PipeBusClient.this.connectRetryCount = 0;
                if (PipeBusClient.this.mModuleListenerMap.size() > 0) {
                    LogUtil.i(PipeBusClient.this.TAG, "auto bind listeners");
                    Message msg = PipeBusClient.this.mUiHandler.obtainMessage(1);
                    msg.setAsynchronous(true);
                    PipeBusClient.this.mUiHandler.sendMessageDelayed(msg, 200L);
                }
            }
        };
        selfGetService();
    }

    public void addLogTagSuffix(String suffix) {
        this.TAG += "." + suffix;
    }

    public synchronized void init(Context context) {
        if (this.clientInit) {
            return;
        }
        this.clientInit = true;
        this.mContextRef = new WeakReference<>(context);
        selfGetService();
    }

    public synchronized void reset() {
        this.clientInit = false;
        this.mUiHandler.removeMessages(1);
        synchronized (this.mModuleListenerMap) {
            this.mModuleListenerMap.clear();
        }
        if (this.mPipeBusClient != null) {
            try {
                this.mPipeBusClient.unRegisterListener(null);
                this.mPipeBusClient = null;
            } catch (Exception e) {
                String str = this.TAG;
                LogUtil.w(str, "reset,unRegisterListener,exception=" + e.getMessage());
            }
        }
    }

    public synchronized void registerModuleListener(String moduleName, IPipebusClientListener listener) {
        String str = this.TAG;
        LogUtil.i(str, "registerListener, module=" + moduleName + ",listener=" + listener);
        if (this.mModuleListenerMap.isEmpty() && this.mBusListener == null) {
            this.mBusListener = new BusListener();
        }
        if (this.mModuleListenerMap.containsKey(moduleName)) {
            String str2 = this.TAG;
            LogUtil.w(str2, "registerModuleListener,repeated module:" + moduleName + ",l=" + listener);
            return;
        }
        this.mModuleListenerMap.put(moduleName, listener);
        selfGetService();
        IPipeBus bus = this.mPipeBusClient;
        if (this.mPipeBusClient != null) {
            try {
                bus.registerListenerEx(moduleName, this.mBusListener);
            } catch (Exception e) {
                String str3 = this.TAG;
                LogUtil.w(str3, "registerModuleListener e=" + e.getMessage());
            }
        } else {
            LogUtil.w(this.TAG, "registerModuleListener, bus is null");
        }
    }

    public synchronized void unRegisterModuleListener(String moduleName, IPipebusClientListener listener) {
        if (this.mModuleListenerMap.containsKey(moduleName)) {
            this.mModuleListenerMap.remove(moduleName, listener);
            selfGetService();
            String str = this.TAG;
            LogUtil.i(str, "unRegisterModuleListener,module=" + moduleName + ",listener=" + listener + ",mapSize=" + this.mModuleListenerMap.size() + ",bus=" + this.mPipeBusClient);
            if (this.mPipeBusClient != null) {
                try {
                    this.mPipeBusClient.unRegisterListenerEx(moduleName);
                } catch (Exception e) {
                    String str2 = this.TAG;
                    LogUtil.w(str2, "unRegisterModuleListener e=" + e);
                }
            }
            return;
        }
        String str3 = this.TAG;
        LogUtil.w(str3, "unRegisterModuleListener,no listener registered for:" + moduleName);
    }

    public int ioControl(String module, String cmd, String[] params) {
        int ret = -1;
        selfGetService();
        if (this.mPipeBusClient != null) {
            try {
                ret = this.mPipeBusClient.ioControl(module, cmd, params);
            } catch (Exception e) {
                String str = this.TAG;
                LogUtil.w(str, "ioControl err=" + e.toString());
            }
        } else {
            LogUtil.w(this.TAG, "ioControl, bus is null!");
        }
        String str2 = this.TAG;
        LogUtil.d(str2, "ioControl,module=" + module + ",cmd=" + cmd + ",ret=" + ret + ",params=" + Arrays.toString(params));
        return ret;
    }

    public int ioControlWithPocket(String module, String cmd, String[] params, String[] results) {
        int ret = -1;
        selfGetService();
        if (this.mPipeBusClient != null) {
            if (results == null) {
                results = stringArray;
            }
            try {
                ret = this.mPipeBusClient.ioControlWithPocket(module, cmd, params, results);
            } catch (Exception e) {
                String str = this.TAG;
                LogUtil.w(str, "ioControlWithPocket e=" + e.toString());
            }
        } else {
            LogUtil.w(this.TAG, "ioControlWithPocket,bus is null!");
        }
        String str2 = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("ioControlWithPocket,module=");
        sb.append(module);
        sb.append(",cmd=");
        sb.append(cmd);
        sb.append(",ret=");
        sb.append(ret);
        sb.append(",params=");
        sb.append(params != null ? Arrays.toString(params) : null);
        sb.append(",result=");
        sb.append(results != null ? Arrays.toString(results) : null);
        LogUtil.d(str2, sb.toString());
        return ret;
    }

    public int ioControlWithParcelable(String moduleName, String cmd, ParcelableContainer dataIn, ParcelableContainer dataOut) {
        ParcelableContainer dIn;
        ParcelableContainer dOut;
        int ret = -1;
        selfGetService();
        if (this.mPipeBusClient != null) {
            if (dataIn != null) {
                dIn = dataIn;
            } else {
                dIn = sParcelableData;
            }
            if (dataOut != null) {
                dOut = dataOut;
            } else {
                dOut = sParcelableData;
            }
            try {
                ret = this.mPipeBusClient.ioControlWithParcelable(moduleName, cmd, dIn, dOut);
            } catch (Exception e) {
                String str = this.TAG;
                LogUtil.w(str, "ioControlWithPocket e=" + e.toString());
            }
        } else {
            LogUtil.w(this.TAG, "ioControlWithPocket,bus is null!");
        }
        String str2 = this.TAG;
        LogUtil.d(str2, "ioControlWithPocket,module=" + moduleName + ",cmd=" + cmd + ",ret=" + ret + ",dataIn=" + dataIn + ",dataOut=" + dataOut);
        return ret;
    }

    private boolean selfGetService() {
        boolean updated = false;
        if (this.mPipeBusClient == null) {
            IBinder binder = ServiceManager.getService(this.mServiceName);
            if (binder != null) {
                updated = true;
                try {
                    binder.linkToDeath(this.mDeathRecipient, 0);
                } catch (Exception e) {
                    LogUtil.w(this.TAG, "linkToDeath exception=" + e.getMessage() + ",binder=" + binder + ",mDeathRecipient=" + this.mDeathRecipient);
                }
                this.mPipeBusClient = IPipeBus.Stub.asInterface(binder);
                this.connectRetryCount = 0;
            } else if (!this.mModuleListenerMap.isEmpty() && this.connectRetryCount < MAX_RETRY_CNT) {
                this.connectRetryCount++;
                this.mUiHandler.removeMessages(1);
                this.mUiHandler.sendEmptyMessageDelayed(1, 200L);
            }
        }
        return updated;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleGetService() {
        boolean updated = selfGetService();
        if (!this.mModuleListenerMap.isEmpty() && this.mPipeBusClient != null && updated) {
            for (String moduleName : this.mModuleListenerMap.keySet()) {
                try {
                    this.mPipeBusClient.registerListenerEx(moduleName, this.mBusListener);
                } catch (Exception e) {
                    String str = this.TAG;
                    LogUtil.w(str, "auto registerListener exception=" + e.getMessage());
                }
            }
        }
    }
}
