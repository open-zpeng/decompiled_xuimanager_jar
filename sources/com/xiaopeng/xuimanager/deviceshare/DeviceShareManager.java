package com.xiaopeng.xuimanager.deviceshare;

import android.app.ActivityThread;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Log;
import com.xiaopeng.xuimanager.XUIManagerBase;
import com.xiaopeng.xuimanager.deviceshare.data.ShareAppInfo;
import com.xiaopeng.xuimanager.deviceshare.data.ShareDevice;
import com.xiaopeng.xuimanager.pipebus.ParcelableContainer;
import com.xiaopeng.xuimanager.pipebus.client.PipeBusClient;
import com.xiaopeng.xuimanager.pipebus.client.PipeBusClientManager;
import com.xiaopeng.xuimanager.utils.LogUtil;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/* loaded from: classes.dex */
public class DeviceShareManager implements XUIManagerBase {
    public static final int SHARE_PROTOCOL_CARLINK = 2;
    public static final int SHARE_PROTOCOL_HICAR = 1;
    public static final int SHARE_VERIFY_WITH_PIN_CODE = 1;
    public static final int SHARE_VERIFY_WITH_QR_CODE = 2;
    private static final String busServiceName = "deviceShare";
    private final Set<IDeviceShareListener> mDeviceShareListenerSet;
    private PipeBusClient pipeBusClient;
    private final PipeBusClient.IPipebusClientListener pipebusClientListener;
    private boolean serverDisconnected;
    public static final String MODULE_NAME = DeviceShareManager.class.getSimpleName();
    private static final String TAG = DeviceShareManager.class.getSimpleName();
    private static String mServiceName = MODULE_NAME;

    /* synthetic */ DeviceShareManager(AnonymousClass1 x0) {
        this();
    }

    /* renamed from: com.xiaopeng.xuimanager.deviceshare.DeviceShareManager$1  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements PipeBusClient.IPipebusClientListener {
        AnonymousClass1() {
        }

        @Override // com.xiaopeng.xuimanager.pipebus.client.PipeBusClient.IPipebusClientListener
        public void onPipeBusEvent(String event, String[] events) {
            String str = DeviceShareManager.TAG;
            LogUtil.i(str, "onPipeBusEvent, type=" + event + ",listener size:" + DeviceShareManager.this.mDeviceShareListenerSet.size());
        }

        @Override // com.xiaopeng.xuimanager.pipebus.client.PipeBusClient.IPipebusClientListener
        public void onPipeBusParcelEvent(String event, ParcelableContainer data) {
            LogUtil.i(DeviceShareManager.TAG, "onPipeBusParcelEvent, event=" + event + ",listener size:" + DeviceShareManager.this.mDeviceShareListenerSet.size());
            if (DeviceShareManager.this.mDeviceShareListenerSet.isEmpty()) {
                return;
            }
            char c = 65535;
            int hashCode = event.hashCode();
            if (hashCode != -794273169) {
                if (hashCode == 1184175417 && event.equals(DeviceShareConst.EVENT_COMMON_INFO)) {
                    c = 0;
                }
            } else if (event.equals(DeviceShareConst.EVENT_APP_INFO)) {
                c = 1;
            }
            if (c == 0) {
                try {
                    final ShareDevice device = (ShareDevice) data.getParcelableArray()[0];
                    final String[] strings = data.getStringArray();
                    final String[] params = (String[]) Arrays.copyOfRange(strings, 2, strings.length);
                    DeviceShareManager.this.mDeviceShareListenerSet.forEach(new Consumer() { // from class: com.xiaopeng.xuimanager.deviceshare.-$$Lambda$DeviceShareManager$1$leoW2_kf7sj74D1WZN1TMlDbEks
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            IDeviceShareListener iDeviceShareListener = (IDeviceShareListener) obj;
                            iDeviceShareListener.onCommonEvent(ShareDevice.this, r1[0], strings[1], params);
                        }
                    });
                } catch (Exception e) {
                    LogUtil.w(DeviceShareManager.TAG, "onPipeBusParcelEvent e=" + e);
                }
            } else if (c != 1) {
                LogUtil.w(DeviceShareManager.TAG, "unknown event:" + event);
            } else {
                try {
                    final String updateEvent = data.getStringArray()[0];
                    Parcelable[] parcelables = data.getParcelableArray();
                    final ShareDevice device2 = (ShareDevice) parcelables[0];
                    final ShareAppInfo[] apps = new ShareAppInfo[parcelables.length - 1];
                    for (int i = 0; i < apps.length; i++) {
                        apps[i] = (ShareAppInfo) parcelables[i + 1];
                    }
                    DeviceShareManager.this.mDeviceShareListenerSet.forEach(new Consumer() { // from class: com.xiaopeng.xuimanager.deviceshare.-$$Lambda$DeviceShareManager$1$beE5jT2TYB6A6erA5ZCrHkyyFuM
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            ((IDeviceShareListener) obj).onAppInfoEvent(ShareDevice.this, updateEvent, apps);
                        }
                    });
                } catch (Exception e2) {
                    LogUtil.w(DeviceShareManager.TAG, "onPipeBusParcelEvent e=" + e2);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    private static class DeviceShareManagerHolder {
        private static final DeviceShareManager INSTANCE = new DeviceShareManager(null);

        private DeviceShareManagerHolder() {
        }
    }

    private DeviceShareManager() {
        this.serverDisconnected = false;
        this.mDeviceShareListenerSet = new CopyOnWriteArraySet();
        this.pipeBusClient = null;
        this.pipebusClientListener = new AnonymousClass1();
        this.pipeBusClient = PipeBusClientManager.createBusClient(busServiceName, ActivityThread.currentApplication().getApplicationContext());
        this.pipeBusClient.addLogTagSuffix(busServiceName);
    }

    public static DeviceShareManager getInstance() {
        return DeviceShareManagerHolder.INSTANCE;
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIDisconnected() {
        Log.d(TAG, "onXUIDisconnected");
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIConnected(IBinder service) {
        if (!this.serverDisconnected) {
            return;
        }
        this.serverDisconnected = false;
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
    }

    public synchronized int registerListener(IDeviceShareListener listener) {
        if (this.mDeviceShareListenerSet.isEmpty()) {
            this.pipeBusClient.registerModuleListener(MODULE_NAME, this.pipebusClientListener);
        }
        this.mDeviceShareListenerSet.add(listener);
        return 0;
    }

    public synchronized int unRegisterListener(IDeviceShareListener listener) {
        this.mDeviceShareListenerSet.remove(listener);
        if (this.mDeviceShareListenerSet.isEmpty()) {
            this.pipeBusClient.unRegisterModuleListener(MODULE_NAME, this.pipebusClientListener);
        }
        return 0;
    }

    public ShareDevice[] getTrustedDevices() {
        ParcelableContainer dataOut = new ParcelableContainer();
        int ret = this.pipeBusClient.ioControlWithParcelable(MODULE_NAME, DeviceShareConst.CMD_GET_TRUSTED_DEVICES, null, dataOut);
        if (ret == 0) {
            Parcelable[] parcelables = dataOut.getParcelableArray();
            if (parcelables == null) {
                LogUtil.d(TAG, "getTrustedDevices, no device");
                return null;
            }
            try {
                ShareDevice[] devices = (ShareDevice[]) Arrays.stream(parcelables).toArray(new IntFunction() { // from class: com.xiaopeng.xuimanager.deviceshare.-$$Lambda$DeviceShareManager$kpRfrYc55ltKG1rpz_o9oguv7d8
                    @Override // java.util.function.IntFunction
                    public final Object apply(int i) {
                        return DeviceShareManager.lambda$getTrustedDevices$0(i);
                    }
                });
                return devices;
            } catch (Exception e) {
                String str = TAG;
                LogUtil.w(str, "getTrustedDevices e=" + e);
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ShareDevice[] lambda$getTrustedDevices$0(int x$0) {
        return new ShareDevice[x$0];
    }

    public int deleteTrustedDevice(ShareDevice device) {
        ParcelableContainer dataIn = new ParcelableContainer();
        dataIn.setParcelableArray(new ShareDevice[]{device});
        int ret = this.pipeBusClient.ioControlWithParcelable(MODULE_NAME, DeviceShareConst.CMD_DELETE_TRUSTED_DEVICE, dataIn, null);
        return ret;
    }

    public int connectDevice(ShareDevice device) {
        ParcelableContainer dataIn = new ParcelableContainer();
        dataIn.setParcelableArray(new ShareDevice[]{device});
        int ret = this.pipeBusClient.ioControlWithParcelable(MODULE_NAME, DeviceShareConst.CMD_CONNECT_DEVICE, dataIn, null);
        return ret;
    }

    public int disConnectDevice(ShareDevice device) {
        ParcelableContainer dataIn = new ParcelableContainer();
        dataIn.setParcelableArray(new ShareDevice[]{device});
        int ret = this.pipeBusClient.ioControlWithParcelable(MODULE_NAME, DeviceShareConst.CMD_DISCONNECT_DEVICE, dataIn, null);
        return ret;
    }

    public ShareDevice[] getConnectedDevice(int protocol) {
        ParcelableContainer dataIn = new ParcelableContainer();
        ParcelableContainer dataOut = new ParcelableContainer();
        dataIn.setIntArray(new int[]{protocol});
        int ret = this.pipeBusClient.ioControlWithParcelable(MODULE_NAME, DeviceShareConst.CMD_GET_CONNECTED_DEVICE, dataIn, dataOut);
        if (ret == 0) {
            Parcelable[] parcelables = dataOut.getParcelableArray();
            if (parcelables == null) {
                LogUtil.d(TAG, "getConnected device null");
                return null;
            }
            try {
                ShareDevice[] devices = (ShareDevice[]) Arrays.stream(parcelables).toArray(new IntFunction() { // from class: com.xiaopeng.xuimanager.deviceshare.-$$Lambda$DeviceShareManager$7vWWgyhpg4lNkNTbr0B_BwtH7rA
                    @Override // java.util.function.IntFunction
                    public final Object apply(int i) {
                        return DeviceShareManager.lambda$getConnectedDevice$1(i);
                    }
                });
                return devices;
            } catch (Exception e) {
                String str = TAG;
                LogUtil.w(str, "getConnectedDevice e=" + e);
                return null;
            }
        }
        String str2 = TAG;
        LogUtil.w(str2, "getConnectedDevice,ret=" + ret);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ShareDevice[] lambda$getConnectedDevice$1(int x$0) {
        return new ShareDevice[x$0];
    }

    public ShareAppInfo[] getShareApps(ShareDevice device) {
        ParcelableContainer dataIn = new ParcelableContainer();
        ParcelableContainer dataOut = new ParcelableContainer();
        dataIn.setParcelableArray(new ShareDevice[]{device});
        int ret = this.pipeBusClient.ioControlWithParcelable(MODULE_NAME, DeviceShareConst.CMD_GET_SHARE_APPS, dataIn, dataOut);
        if (ret == 0) {
            Parcelable[] parcelables = dataOut.getParcelableArray();
            if (parcelables == null) {
                return null;
            }
            try {
                ShareAppInfo[] appInfos = (ShareAppInfo[]) Arrays.stream(parcelables).toArray(new IntFunction() { // from class: com.xiaopeng.xuimanager.deviceshare.-$$Lambda$DeviceShareManager$XIjybLHc2yv9cdVF5YPQZz0_qHI
                    @Override // java.util.function.IntFunction
                    public final Object apply(int i) {
                        return DeviceShareManager.lambda$getShareApps$2(i);
                    }
                });
                return appInfos;
            } catch (Exception e) {
                String str = TAG;
                LogUtil.w(str, "getShareApps e=" + e);
                return null;
            }
        }
        String str2 = TAG;
        LogUtil.w(str2, "getShareApps, ret=" + ret);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ShareAppInfo[] lambda$getShareApps$2(int x$0) {
        return new ShareAppInfo[x$0];
    }

    public int startApp(ShareAppInfo appInfo) {
        ParcelableContainer dataIn = new ParcelableContainer();
        dataIn.setParcelableArray(new ShareAppInfo[]{appInfo});
        int ret = this.pipeBusClient.ioControlWithParcelable(MODULE_NAME, DeviceShareConst.CMD_START_APP, dataIn, null);
        return ret;
    }
}
