package com.xiaopeng.xuimanager.iot;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import com.xiaopeng.xuimanager.XUIManagerBase;
import com.xiaopeng.xuimanager.iot.devices.ScanDevice;
import com.xiaopeng.xuimanager.iot.internal.IoTCommunication;
import com.xiaopeng.xuimanager.iot.utils.DeviceBuilder;
import com.xiaopeng.xuimanager.pipebus.IPipeBus;
import com.xiaopeng.xuimanager.pipebus.IPipeBusListener;
import com.xiaopeng.xuimanager.pipebus.ParcelableContainer;
import com.xiaopeng.xuimanager.utils.LogUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class IoTManager implements XUIManagerBase {
    private static final int MAX_RETRY_CNT = 150;
    private static final int MSG_CONNECT_IOTSVC = 1;
    private static final String SERVICE_NAME = "IoTManagerService";
    private static final String TAG = IoTManager.class.getSimpleName() + "##";
    private static volatile IoTManager mIoTManager;
    private int connectRetryCount;
    private List<IDeviceListener> mAppListenerList;
    private IPipeBusListener mBusLisener;
    private WeakReference<Context> mContextRef;
    private IBinder.DeathRecipient mDeathRecipient;
    private IPipeBus mPipeBusClient;
    private List<Map<String, String>> mSubscriberList;
    private Handler mUiHandler;

    static /* synthetic */ int access$308(IoTManager x0) {
        int i = x0.connectRetryCount;
        x0.connectRetryCount = i + 1;
        return i;
    }

    private IoTManager(IBinder service, Context context, Handler handler) {
        LogUtil.setModuleLogLevel(TAG, 0);
        LogUtil.log(1, TAG, "IoTManager created");
    }

    private IoTManager() {
        LogUtil.setModuleLogLevel(TAG, 0);
        LogUtil.log(1, TAG, "IoTManager created");
        this.connectRetryCount = 0;
        this.mUiHandler = new Handler(Looper.getMainLooper()) { // from class: com.xiaopeng.xuimanager.iot.IoTManager.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                String str = IoTManager.TAG;
                LogUtil.log(1, str, "get msg=" + msg.what);
                if (msg.what == 1) {
                    IoTManager.this.selfGetService();
                    if (IoTManager.this.mPipeBusClient == null) {
                        if (IoTManager.this.connectRetryCount < IoTManager.MAX_RETRY_CNT) {
                            IoTManager.access$308(IoTManager.this);
                            IoTManager.this.mUiHandler.sendEmptyMessageDelayed(1, 200L);
                            return;
                        }
                        return;
                    }
                    IoTManager.this.connectRetryCount = 0;
                    IoTManager.this.selfSubscribeNotifications();
                }
            }
        };
        this.mDeathRecipient = new IBinder.DeathRecipient() { // from class: com.xiaopeng.xuimanager.iot.IoTManager.2
            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                LogUtil.log(3, IoTManager.TAG, "IoTManager Service died");
                IoTManager.this.mPipeBusClient = null;
                IoTManager.this.connectRetryCount = 0;
                IoTManager.this.mUiHandler.sendEmptyMessageDelayed(1, 200L);
            }
        };
        selfGetService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IPipeBus selfGetService() {
        IBinder binder;
        if (this.mPipeBusClient == null && (binder = ServiceManager.getService(SERVICE_NAME)) != null) {
            try {
                binder.linkToDeath(this.mDeathRecipient, 0);
            } catch (RemoteException e) {
                String str = TAG;
                LogUtil.log(4, str, "linkToDeath exception=" + e.getMessage());
            }
            this.mPipeBusClient = IPipeBus.Stub.asInterface(binder);
            if (this.mAppListenerList != null && !this.mAppListenerList.isEmpty() && this.mBusLisener != null) {
                try {
                    this.mPipeBusClient.registerListener(this.mBusLisener);
                } catch (RemoteException e2) {
                    String str2 = TAG;
                    LogUtil.log(4, str2, "auto registerListener exception=" + e2.getMessage());
                }
            }
        }
        return this.mPipeBusClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class IoTManagerHolder {
        private static final IoTManager sInstance = new IoTManager();

        private IoTManagerHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processEvent(String types, String[] events) {
        if (this.mAppListenerList == null) {
            LogUtil.log(3, TAG, "no AppListenerList");
        } else if (this.mAppListenerList != null && this.mAppListenerList.isEmpty()) {
            LogUtil.log(3, TAG, "no AppListener register");
        } else {
            char c = 65535;
            int hashCode = types.hashCode();
            if (hashCode != -333836685) {
                if (hashCode != 781495096) {
                    if (hashCode != 1438668277) {
                        if (hashCode == 1532124661 && types.equals(IoTCommunication.EVENT_OPERATION_RESULT)) {
                            c = 3;
                        }
                    } else if (types.equals(IoTCommunication.EVENT_PROPERTY_UPDATE_WITH_JSON)) {
                        c = 2;
                    }
                } else if (types.equals(IoTCommunication.EVENT_DEVICE_ADD)) {
                    c = 0;
                }
            } else if (types.equals(IoTCommunication.EVENT_PROPERTY_UPDATE)) {
                c = 1;
            }
            switch (c) {
                case 0:
                    List<BaseDevice> deviceList = DeviceBuilder.fromJsonArray(events[0]);
                    if (deviceList == null) {
                        LogUtil.log(3, TAG, "EVENT_DEVICE_ADD but get null");
                        return;
                    }
                    for (IDeviceListener listener : this.mAppListenerList) {
                        listener.onDeviceAdd(deviceList);
                    }
                    return;
                case 1:
                    if (events != null && events.length > 2) {
                        Map<String, String> propMap = new HashMap<>();
                        propMap.put(events[1], events[2]);
                        for (IDeviceListener listener2 : this.mAppListenerList) {
                            listener2.onPropertiesUpdated(events[0], propMap);
                        }
                        return;
                    }
                    return;
                case 2:
                    if (events != null && events.length > 1) {
                        Map<String, String> propMap2 = DeviceBuilder.jsonStrToPropMap(events[1]);
                        for (IDeviceListener listener3 : this.mAppListenerList) {
                            listener3.onPropertiesUpdated(events[0], propMap2);
                        }
                        return;
                    }
                    return;
                case 3:
                    if (events != null && events.length > 2) {
                        for (IDeviceListener listener4 : this.mAppListenerList) {
                            listener4.onOperationResult(events[0], events[1], events[2]);
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    private class BusListener extends IPipeBusListener.Stub {
        private final String TAG;

        private BusListener() {
            this.TAG = IoTManager.TAG + BusListener.class.getSimpleName();
        }

        @Override // com.xiaopeng.xuimanager.pipebus.IPipeBusListener
        public void onPipeBusEvent(String module, String types, String[] events) {
            String str = this.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onPipeBusEvent,module=");
            sb.append(module);
            sb.append(",types=");
            sb.append(types);
            sb.append(",events[0]=");
            sb.append(events != null ? Integer.valueOf(events[0].hashCode()) : "null");
            LogUtil.log(1, str, sb.toString());
            IoTManager.this.processEvent(types, events);
        }

        @Override // com.xiaopeng.xuimanager.pipebus.IPipeBusListener
        public void onPipeBusParcelEvent(String module, String types, ParcelableContainer data) {
            String str = this.TAG;
            LogUtil.w(str, "not implemented,onPipeBusBytesEvent,module:" + module + ",types" + types);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selfSubscribeNotifications() {
        if (this.mSubscriberList == null || this.mSubscriberList.isEmpty()) {
            return;
        }
        String str = TAG;
        LogUtil.log(1, str, "selfSubscribeNotifications,suber size=" + this.mSubscriberList.size());
        if (this.mPipeBusClient != null) {
            String[] args = new String[2];
            for (Map<String, String> suber : this.mSubscriberList) {
                args[0] = suber.get(DeviceBuilder.FIELD_DEVICE_TYPE);
                args[1] = suber.get(DeviceBuilder.FIELD_DEVICE_ID);
                try {
                    this.mPipeBusClient.ioControl(IoTCommunication.MODULE_IOT, IoTCommunication.IO_ADD_MONITOR_DEVICE, args);
                } catch (Exception e) {
                    String str2 = TAG;
                    LogUtil.log(4, str2, "subscribeNotifications fail,e=" + e.getMessage());
                }
            }
        }
    }

    public static IoTManager getInstance() {
        return IoTManagerHolder.sInstance;
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIDisconnected() {
        LogUtil.log(1, TAG, "onXUIDisconnected");
    }

    public void init(Context context) {
        this.mContextRef = new WeakReference<>(context);
    }

    public synchronized void reset() {
        LogUtil.log(1, TAG, "reset");
        this.mUiHandler.removeMessages(1);
        if (this.mContextRef != null) {
            this.mContextRef.clear();
        }
        if (this.mAppListenerList != null && !this.mAppListenerList.isEmpty()) {
            this.mAppListenerList.clear();
            selfGetService();
            if (this.mPipeBusClient != null) {
                try {
                    this.mPipeBusClient.unRegisterListener(this.mBusLisener);
                    this.mBusLisener = null;
                } catch (RemoteException e) {
                    String str = TAG;
                    LogUtil.log(4, str, "reset exception=" + e.getMessage());
                }
            }
            if (this.mAppListenerList != null) {
                this.mAppListenerList.clear();
                this.mAppListenerList = null;
            }
        }
        if (this.mSubscriberList != null && !this.mSubscriberList.isEmpty()) {
            this.mSubscriberList.clear();
            this.mSubscriberList = null;
        }
    }

    public List<BaseDevice> getDevice(String getType, String params) {
        String str = TAG;
        LogUtil.log(1, str, "getDevice,type=" + getType + ",params=" + params);
        selfGetService();
        if (this.mPipeBusClient != null) {
            try {
                String[] args = {getType, params};
                String[] results = new String[1];
                this.mPipeBusClient.ioControlWithPocket(IoTCommunication.MODULE_IOT, IoTCommunication.IO_GET_DEVICE, args, results);
                if (results.length > 0) {
                    String str2 = TAG;
                    LogUtil.log(1, str2, "getDevice0=" + results[0] + ",size=" + results.length);
                    if (results[0] != null) {
                        return DeviceBuilder.fromJsonArray(results[0]);
                    }
                    return null;
                }
                return null;
            } catch (Exception e) {
                String str3 = TAG;
                LogUtil.log(4, str3, "getDevice fail,e=" + e.getMessage());
                return null;
            }
        }
        return null;
    }

    public void requestDeviceList(String deviceFilter) {
        String str = TAG;
        LogUtil.log(1, str, "requestDeviceList,filter=" + deviceFilter);
        selfGetService();
        if (this.mPipeBusClient != null) {
            try {
                String[] params = {deviceFilter};
                this.mPipeBusClient.ioControl(IoTCommunication.MODULE_IOT, IoTCommunication.IO_REQUEST_DEVICE, params);
            } catch (Exception e) {
                String str2 = TAG;
                LogUtil.log(4, str2, "ioControl fail,e=" + e.getMessage());
            }
        }
    }

    public synchronized void registerListener(IDeviceListener listener) {
        if (this.mAppListenerList == null) {
            this.mAppListenerList = new ArrayList();
        }
        if (this.mAppListenerList.isEmpty()) {
            if (this.mBusLisener == null) {
                this.mBusLisener = new BusListener();
            }
            selfGetService();
            if (this.mPipeBusClient != null) {
                try {
                    this.mPipeBusClient.registerListener(this.mBusLisener);
                } catch (RemoteException e) {
                    String str = TAG;
                    LogUtil.log(4, str, "registerListener exception=" + e.getMessage());
                }
            } else {
                this.connectRetryCount = 0;
                this.mUiHandler.sendEmptyMessageDelayed(1, 200L);
            }
        }
        if (!this.mAppListenerList.contains(listener)) {
            this.mAppListenerList.add(listener);
        }
    }

    public synchronized void unRegisterListener(IDeviceListener listener) {
        if (this.mAppListenerList != null) {
            this.mAppListenerList.remove(listener);
            if (this.mAppListenerList.isEmpty()) {
                selfGetService();
                if (this.mPipeBusClient != null) {
                    try {
                        this.mPipeBusClient.unRegisterListener(this.mBusLisener);
                        this.mBusLisener = null;
                    } catch (RemoteException e) {
                        String str = TAG;
                        LogUtil.log(4, str, "unRegisterListener exception=" + e.getMessage());
                    }
                }
            }
        }
    }

    public Map<String, String> getDeviceProperties(BaseDevice device) {
        String str = TAG;
        LogUtil.log(1, str, "getDeviceProperties,type=" + device.getDeviceType() + ",device id=" + device.getDeviceId());
        selfGetService();
        if (this.mPipeBusClient != null) {
            try {
                String[] args = {BaseDevice.GET_BY_DEVICE_TYPE, device.getDeviceType(), device.getDeviceId()};
                String[] results = new String[1];
                this.mPipeBusClient.ioControlWithPocket(IoTCommunication.MODULE_IOT, IoTCommunication.IO_GET_PROPERTIES, args, results);
                if (results.length > 0) {
                    String str2 = TAG;
                    LogUtil.log(1, str2, "getDeviceProperties0=" + results[0] + ",size=" + results.length);
                    if (results[0] != null) {
                        return DeviceBuilder.jsonStrToPropMap(results[0]);
                    }
                    return null;
                }
                return null;
            } catch (Exception e) {
                String str3 = TAG;
                LogUtil.log(4, str3, "getDeviceProperties fail,e=" + e.getMessage());
                return null;
            }
        }
        return null;
    }

    public void setDeviceProperties(BaseDevice device, Map<String, String> propMap) {
        if (propMap == null || propMap.isEmpty()) {
            Log.w(TAG, "setDeviceProperties,invalid propMap");
            return;
        }
        String str = TAG;
        LogUtil.log(1, str, "setDeviceProperties,type=" + propMap + "type=" + device.getDeviceType() + ",device id=" + device.getDeviceId());
        selfGetService();
        if (this.mPipeBusClient != null) {
            try {
                String[] args = {device.getDeviceType(), device.getDeviceId(), DeviceBuilder.propToJson(propMap).toString()};
                this.mPipeBusClient.ioControl(IoTCommunication.MODULE_IOT, IoTCommunication.IO_SET_PROPERTIES, args);
            } catch (RemoteException e) {
                String str2 = TAG;
                LogUtil.log(4, str2, "setDeviceProperties fail,e=" + e.getMessage());
            }
        }
    }

    public synchronized void subscribeNotifications(BaseDevice device) {
        String str = TAG;
        LogUtil.log(1, str, "subscribeNotifications,type=" + device.getDeviceType() + ",name=" + device.getDeviceName());
        String[] args = {device.getDeviceType(), device.getDeviceId()};
        Map<String, String> subRecord = new HashMap<>();
        subRecord.put(DeviceBuilder.FIELD_DEVICE_TYPE, args[0]);
        subRecord.put(DeviceBuilder.FIELD_DEVICE_ID, args[1]);
        if (this.mSubscriberList == null) {
            this.mSubscriberList = new ArrayList();
        }
        if (!this.mSubscriberList.isEmpty()) {
            for (Map<String, String> item : this.mSubscriberList) {
                if (device.getDeviceId().equals(item.get(DeviceBuilder.FIELD_DEVICE_ID))) {
                    String str2 = TAG;
                    LogUtil.log(3, str2, "ignore repeat subscribe device,class=" + device.getDeviceClass() + ",id=" + device.getDeviceId());
                    return;
                }
            }
        }
        this.mSubscriberList.add(subRecord);
        selfGetService();
        if (this.mPipeBusClient != null) {
            try {
                this.mPipeBusClient.ioControl(IoTCommunication.MODULE_IOT, IoTCommunication.IO_ADD_MONITOR_DEVICE, args);
            } catch (RemoteException e) {
                String str3 = TAG;
                LogUtil.log(4, str3, "subscribeNotifications fail,e=" + e.getMessage());
            }
        } else {
            this.connectRetryCount = 0;
            this.mUiHandler.sendEmptyMessageDelayed(1, 200L);
        }
    }

    public synchronized void unSubscribeNotifications(BaseDevice device) {
        String str = TAG;
        LogUtil.log(1, str, "unSubscribeNotifications,type=" + device.getDeviceType() + ",name=" + device.getDeviceName());
        String[] args = {device.getDeviceType(), device.getDeviceId()};
        if (this.mSubscriberList != null && !this.mSubscriberList.isEmpty()) {
            Iterator<Map<String, String>> it = this.mSubscriberList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map<String, String> suber = it.next();
                if (args[1].equals(suber.get(DeviceBuilder.FIELD_DEVICE_ID))) {
                    this.mSubscriberList.remove(suber);
                    break;
                }
            }
            selfGetService();
            if (this.mPipeBusClient != null) {
                try {
                    this.mPipeBusClient.ioControl(IoTCommunication.MODULE_IOT, IoTCommunication.IO_REMOVE_MONITOR_DEVICE, args);
                } catch (RemoteException e) {
                    String str2 = TAG;
                    LogUtil.log(4, str2, "unSubscribeNotifications fail,e=" + e.getMessage());
                }
            }
            return;
        }
        String str3 = TAG;
        LogUtil.log(3, str3, "unSubscribeNotifications invalid,device class=" + device.getDeviceClass() + ",id=" + device.getDeviceId());
    }

    public void sendCommand(BaseDevice device, String cmd, String params) {
        if (device != null) {
            String str = TAG;
            LogUtil.log(1, str, "sendCommand,type=" + device.getDeviceType() + ",name=" + device.getDeviceName() + ",cmd=" + cmd + ",params=" + params);
        } else {
            String str2 = TAG;
            LogUtil.log(1, str2, "sendCommand,cmd=" + cmd + ",params=" + params);
        }
        selfGetService();
        if (this.mPipeBusClient != null) {
            try {
                String[] args = new String[4];
                if (device != null) {
                    args[0] = device.getDeviceType();
                    if (ScanDevice.DEVICE_TYPE.equals(args[0])) {
                        args[1] = DeviceBuilder.toJson(device).toString();
                    } else {
                        args[1] = device.getDeviceId();
                    }
                } else {
                    args[0] = null;
                    args[1] = null;
                }
                args[2] = cmd;
                args[3] = params;
                this.mPipeBusClient.ioControl(IoTCommunication.MODULE_IOT, IoTCommunication.IO_SEND_DEVICE_CMD, args);
            } catch (RemoteException e) {
                String str3 = TAG;
                LogUtil.log(4, str3, "sendCommand fail,e=" + e.getMessage());
            }
        }
    }
}
