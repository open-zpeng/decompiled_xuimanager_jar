package com.xiaopeng.xuimanager.pipebus.server;

import com.xiaopeng.xuimanager.pipebus.ParcelableContainer;
/* loaded from: classes.dex */
public interface IPipeBusManagerCallback {
    void onPipeBusEvent(String str, String str2, String[] strArr);

    void onPipeBusEvent(String str, String str2, String[] strArr, int i);

    void onPipeBusParcelEvent(String str, String str2, ParcelableContainer parcelableContainer);

    void onPipeBusParcelEvent(String str, String str2, ParcelableContainer parcelableContainer, int i);
}
