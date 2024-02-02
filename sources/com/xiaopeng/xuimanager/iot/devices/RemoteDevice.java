package com.xiaopeng.xuimanager.iot.devices;

import com.xiaopeng.xuimanager.iot.BaseDevice;
/* loaded from: classes.dex */
public class RemoteDevice extends BaseDevice {
    public static final String DEVICE_TYPE = "XP_Remote";
    public static final String PROP_BATTERY_PWR = "battery";
    public static final String PROP_BOND_ST = "bond_status";
    public static final String PROP_HID_ST = "hid_status";
    public static final String PROP_LOW_BATTERY = "low_battery";
    public static final String PROP_SLEEP_TIME = "sleep_time";
    public static final String PROP_VERSION = "version";
    public static final String SCAN_TYPE_REMOTE = "scan_type_remote";
    public static final String VAL_BONDED = "bonded";
    public static final String VAL_BONDING = "bonding";
    public static final String VAL_OK = "0";
    public static final String VAL_UNBOND = "unbond";
    public static final String VAL_WARN = "1";

    public RemoteDevice() {
    }

    public RemoteDevice(String name, String id, String type) {
        this.deviceName = name;
        this.deviceId = id;
        this.deviceType = type;
    }
}
