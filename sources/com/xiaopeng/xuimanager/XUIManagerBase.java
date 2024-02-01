package com.xiaopeng.xuimanager;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;

/* loaded from: classes.dex */
public interface XUIManagerBase {
    void onXUIDisconnected();

    default void onXUIConnected(IBinder service) {
    }

    default void setServiceName(String name) {
    }

    default String getServiceName() {
        return getClass().getSimpleName();
    }

    default void onServerDisconnected() {
    }

    default void init(IBinder service, Context context, Handler handler) {
    }
}
