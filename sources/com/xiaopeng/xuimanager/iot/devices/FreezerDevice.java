package com.xiaopeng.xuimanager.iot.devices;

import com.xiaopeng.xuimanager.iot.BaseDevice;
/* loaded from: classes.dex */
public class FreezerDevice extends BaseDevice {
    public static final String DEVICE_TYPE = "Freezer";
    public static final String PROP_CHILD_LOCK = "child_lock";
    public static final String PROP_DOOR_CTRL = "door_ctrl";
    public static final String PROP_HEAT_PRESERVATION = "heat_preservation";
    public static final String PROP_HOLDING_TIME = "holding_time";
    public static final String PROP_HT_MEMORY_CTRL = "ht_memory_ctrl";
    public static final String PROP_POWER_CTRL = "power_ctrl";
    public static final String PROP_TEMPERATURE = "temperature";
    public static final String PROP_WORK_MODE = "work_mode";
    private static final String TAG = FreezerDevice.class.getSimpleName();
    public static final String VAL_COLD = "cold";
    public static final String VAL_DEC = "dec";
    public static final String VAL_ERR = "error";
    public static final String VAL_HEAT = "heat";
    public static final String VAL_INC = "inc";
    public static final String VAL_OFF = "off";
    public static final String VAL_ON = "on";

    public FreezerDevice() {
    }

    public FreezerDevice(String name, String id, String type) {
        this.deviceName = name;
        this.deviceId = id;
        this.deviceType = type;
    }
}
