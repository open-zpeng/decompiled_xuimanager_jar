package com.xiaopeng.xuimanager.iot.devices;

import com.xiaopeng.xuimanager.iot.BaseDevice;
/* loaded from: classes.dex */
public class ScanDevice extends BaseDevice {
    public static final String DEVICE_TYPE = "ScanDevice";
    public static final String PROP_BLE_MANUFACTURER_DATA = "ble_manufacturer_data";
    public static final String PROP_BLE_MANUFACTURER_ID = "ble_manufacturer_id";
    public static final String PROP_BLUETOOTH_RSSI = "bt_rssi";
    public static final String PROP_REAL_TYPE = "real_type";
    private static final String TAG = ScanDevice.class.getSimpleName();
    public static final String VAL_TYPE_BLUETOOTH_BLE = "type_bluetooth_ble";

    public ScanDevice() {
        this.deviceName = BaseDevice.VAL_UNKNOWN_DEVICE_NAME;
        this.deviceId = BaseDevice.VAL_UNKNOWN_DEVICE_ID;
        this.deviceType = DEVICE_TYPE;
    }

    public ScanDevice(String name, String id, String type) {
        this.deviceName = name;
        this.deviceId = id;
        this.deviceType = type;
    }

    public static boolean isXPengBleDevice(BaseDevice device) {
        if (device == null || device.getPropertyMap() == null) {
            return false;
        }
        String manufacturerId = device.getPropertyMap().get(PROP_BLE_MANUFACTURER_ID);
        String manufacturerString = device.getPropertyMap().get(PROP_BLE_MANUFACTURER_DATA);
        if (manufacturerId == null || manufacturerString == null || 22608 != Integer.parseInt(manufacturerId) || !"XPengBle".equals(manufacturerString)) {
            return false;
        }
        return true;
    }
}
