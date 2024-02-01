package com.xiaopeng.xuimanager.operation;
/* loaded from: classes.dex */
public class OpenAction {
    public static final int OPEN_ACTION_SEND_BROADCAST = 2;
    public static final int OPEN_ACTION_START_ACTIVITY = 0;
    public static final int OPEN_ACTION_START_SERVICE = 1;
    public String openActionComponent;
    public int openActionType;

    public static OpenAction activity(String component) {
        return new OpenAction(0, component);
    }

    public static OpenAction service(String component) {
        return new OpenAction(1, component);
    }

    public static OpenAction broadcast(String component) {
        return new OpenAction(2, component);
    }

    private OpenAction(int openActionType, String openActionComponent) {
        this.openActionType = openActionType;
        this.openActionComponent = openActionComponent;
    }
}
