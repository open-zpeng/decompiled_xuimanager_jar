package com.xiaopeng.xuimanager.iot.devices;

import com.xiaopeng.xuimanager.iot.BaseDevice;

/* loaded from: classes.dex */
public class XpAssistDevice extends BaseDevice {
    public static final String DEVICE_TYPE = "XpAssist";

    public XpAssistDevice() {
    }

    public XpAssistDevice(String name, String id, String type) {
        this.deviceName = name;
        this.deviceId = id;
        this.deviceType = type;
    }
}
