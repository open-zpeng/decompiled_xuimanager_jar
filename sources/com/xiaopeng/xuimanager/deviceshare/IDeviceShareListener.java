package com.xiaopeng.xuimanager.deviceshare;

import com.xiaopeng.xuimanager.deviceshare.data.ShareAppInfo;
import com.xiaopeng.xuimanager.deviceshare.data.ShareDevice;

/* loaded from: classes.dex */
public interface IDeviceShareListener {
    void onCommonEvent(ShareDevice shareDevice, String str, String str2, String[] strArr);

    default void onAppInfoEvent(ShareDevice device, String eventType, ShareAppInfo[] appInfos) {
    }
}
