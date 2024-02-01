package com.xiaopeng.xuimanager.iot;

import java.util.Map;

/* loaded from: classes.dex */
public abstract class BaseDevice {
    public static final String CMD_ADD_DEVICE = "cmd_add_device";
    public static final String CMD_ONOFF = "cmd_base_onoff";
    public static final String CMD_REMOVE_DEVICE = "cmd_remove_device";
    public static final String CMD_SCAN_DEVICE_START = "cmd_scan_device_start";
    public static final String CMD_SCAN_DEVICE_STOP = "cmd_scan_device_stop";
    public static final String GET_BY_DEVICE_CLASS = "by_dev_class";
    public static final String GET_BY_DEVICE_TYPE = "by_dev_type";
    public static final String PROP_CONNECT_STATE = "connect_state";
    public static final String PROP_ERROR_CODE = "errorCode";
    public static final String PROP_POWER_STATE = "power_state";
    public static final String PROP_STOP_COMMAND = "XpStopCmd";
    public static final String PROP_SWITCH_STATE = "switch_state";
    public static final String SCAN_TYPE_BLE = "scan_type_ble";
    public static final String VAL_CONNECTED = "1";
    public static final String VAL_DISCONNECTED = "0";
    public static final int VAL_INVALID_INT = Integer.MIN_VALUE;
    public static final String VAL_INVALID_STR = "-2147483648";
    public static final String VAL_OFF = "0";
    public static final String VAL_ON = "1";
    public static final String VAL_SERVICE_AVAILABLE = "100";
    public static final String VAL_UNINIT = "-1";
    public static final int VAL_UNINIT_INT = -1;
    public static final String VAL_UNKNOWN_DEVICE_ID = "unknown_device_id";
    public static final String VAL_UNKNOWN_DEVICE_NAME = "unknown_device_name";
    protected final String deviceClass = getClass().getName();
    protected String deviceId;
    protected String deviceName;
    protected String deviceType;
    protected Map<String, String> propertyMap;
    private static final String TAG = BaseDevice.class.getSimpleName() + "##";
    private static int mMaxPropertyLogLength = 128;

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public String getDeviceClass() {
        return this.deviceClass;
    }

    public Map<String, String> getPropertyMap() {
        return this.propertyMap;
    }

    public BaseDevice setDeviceName(String name) {
        this.deviceName = name;
        return this;
    }

    public BaseDevice setDeviceId(String id) {
        this.deviceId = id;
        return this;
    }

    public BaseDevice setDeviceType(String type) {
        this.deviceType = type;
        return this;
    }

    public BaseDevice setDeviceClass(String clazz) {
        return this;
    }

    public BaseDevice setPropertyMap(Map<String, String> propMap) {
        this.propertyMap = propMap;
        return this;
    }

    public static void setMaxPropertyLogLength(int len) {
        if (len >= 16) {
            mMaxPropertyLogLength = len;
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("deviceClass[");
        sb.append(this.deviceClass);
        sb.append("],deviceName[");
        sb.append(this.deviceName);
        sb.append("],deviceId[");
        sb.append(this.deviceId);
        sb.append("],deviceType[");
        sb.append(this.deviceType);
        sb.append("]");
        if (this.propertyMap != null) {
            sb.append(",props:");
            for (Map.Entry<String, String> entry : this.propertyMap.entrySet()) {
                String value = entry.getValue();
                if (value != null) {
                    int length = value.length();
                    int i = mMaxPropertyLogLength;
                    if (length > i) {
                        str = value.substring(0, i);
                        String value2 = str;
                        sb.append(entry.getKey() + "=" + value2 + ",");
                    }
                }
                str = value;
                String value22 = str;
                sb.append(entry.getKey() + "=" + value22 + ",");
            }
        }
        sb.append("@");
        sb.append(hashCode());
        return sb.toString();
    }
}
