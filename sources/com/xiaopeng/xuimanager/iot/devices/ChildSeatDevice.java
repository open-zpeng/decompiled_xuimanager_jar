package com.xiaopeng.xuimanager.iot.devices;

import com.xiaopeng.xuimanager.iot.BaseDevice;
/* loaded from: classes.dex */
public class ChildSeatDevice extends BaseDevice {
    public static final String DEVICE_TYPE = "Babyfirst";
    public static final String PROP_BATTERY_PWR = "battery_power";
    public static final String PROP_BELTALARM_ENABLE = "belt_alarm_enable";
    public static final String PROP_BELTALARM_STATUS = "belt_alarm_status";
    public static final String PROP_HEAT_ENABLE = "heat_enable";
    public static final String PROP_HEAT_STATUS = "heat_status";
    public static final String PROP_HEAT_UPPER = "heat_protect_upper";
    public static final String PROP_ISOFIXALARM_ENABLE = "isofix_alarm_enable";
    public static final String PROP_ISOFIXALARM_STATUS = "isofix_alarm_status";
    public static final String PROP_LOWBATTALARM_LOWER = "lowbattery_alarm_lower";
    public static final String PROP_LOWBATTALARM_STATUS = "lowbattery_alarm_status";
    public static final String PROP_PRESSALARM_STATUS = "pressure_alarm_status";
    public static final String PROP_SEAT_TEMP = "seat_temperature";
    public static final String PROP_SUPPLY_METHOD = "power_supply_method";
    public static final String PROP_TEMPALARM_ENABLE = "temp_alarm_enable";
    public static final String PROP_TEMPALARM_LOWER = "temp_alarm_lower";
    public static final String PROP_TEMPALARM_STATUS = "temp_alarm_status";
    public static final String PROP_TEMPALARM_UPPER = "temp_alarm_upper";
    public static final String PROP_VENT_ENABLE = "ventilation_enable";
    public static final String PROP_VENT_STATUS = "ventilation_status";
    public static final String VAL_BATTERY_SUPPLY = "0";
    public static final String VAL_CIGARETTE_SUPPLY = "1";
    public static final String VAL_OK = "0";
    public static final String VAL_WARN = "1";

    public ChildSeatDevice() {
    }

    public ChildSeatDevice(String name, String id, String type) {
        this.deviceName = name;
        this.deviceId = id;
        this.deviceType = type;
    }
}
