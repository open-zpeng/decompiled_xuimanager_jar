package com.xiaopeng.xuimanager.pipebus.server;

import com.xiaopeng.xuimanager.pipebus.ParcelableContainer;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class PipeBusManager {
    protected volatile IPipeBusManagerCallback mCallback = null;

    public abstract void dump(PrintWriter printWriter, String[] strArr);

    public abstract String getModuleName();

    public abstract int init();

    public abstract int ioControl(String str, String[] strArr, int i, int i2);

    public abstract int ioControlWithParcelable(String str, ParcelableContainer parcelableContainer, ParcelableContainer parcelableContainer2, int i, int i2);

    public abstract int ioControlWithPocket(String str, String[] strArr, String[] strArr2, int i, int i2);

    public abstract void onClientDied(int i, int i2);

    public abstract void registerListener(int i, int i2);

    public abstract void unRegisterListener(int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void registerCallback(IPipeBusManagerCallback callback) {
        this.mCallback = callback;
    }
}
