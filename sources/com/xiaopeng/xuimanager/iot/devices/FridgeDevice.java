package com.xiaopeng.xuimanager.iot.devices;

import android.util.Log;
import com.xiaopeng.xuimanager.iot.BaseDevice;
/* loaded from: classes.dex */
public class FridgeDevice extends BaseDevice {
    public static final String DEVICE_TYPE = "Fridge";
    public static final int ERROR_1 = 1;
    public static final int ERROR_2 = 2;
    public static final int ERROR_3 = 4;
    public static final int ERROR_4 = 8;
    public static final int ERROR_5 = 16;
    public static final int ERROR_6 = 32;
    public static final int ERROR_7 = 64;
    public static final int ERROR_NONE = 0;
    public static final String PROP_ERROR_CODE = "error_code";
    public static final String PROP_ERROR_CODE_TIME_STAMP = "error_code_timestamp";
    public static final String PROP_TARGET_TEMPERATURE = "target_temp";
    public static final String PROP_TEMPERATURE = "temperature";
    private static final String TAG = FridgeDevice.class.getSimpleName();
    public static final String VAL_ERROR_CODE_DOOR_OPEN = "door open";
    public static final String VAL_SWITCH_OFF = "0";
    public static final String VAL_SWITCH_ON = "1";
    public static final String VAL_TEMPERATURE_TARGET_HIGH = "+06";
    public static final String VAL_TEMPERATURE_TARGET_LOW = "-06";
    public static final String VAL_TEMPERATURE_TARGET_MIDDLE = "+00";

    public FridgeDevice() {
    }

    public FridgeDevice(String name, String id, String type) {
        this.deviceName = name;
        this.deviceId = id;
        this.deviceType = type;
    }

    public static long[] getErrorCodeTimeStamps(String rawData) {
        if (rawData == null) {
            Log.w(TAG, "getErrorCodeTimeStamps, data null");
            return null;
        }
        String[] elements = rawData.split(",");
        long[] result = new long[elements.length];
        for (int i = 0; i < elements.length; i++) {
            result[i] = Long.parseLong(elements[i]);
        }
        return result;
    }
}
