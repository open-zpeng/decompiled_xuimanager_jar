package com.xiaopeng.xuimanager.systemui.dock;

/* loaded from: classes.dex */
public interface DockEventListener {
    void onEnterEdit(boolean z);

    void onItemAdded(DockItem dockItem);

    void onItemRemoved(DockItem dockItem);
}
