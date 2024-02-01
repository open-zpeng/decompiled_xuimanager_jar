package com.xiaopeng.xuimanager.systemui;

import com.xiaopeng.xuimanager.systemui.SystemUIClient;
/* loaded from: classes.dex */
public abstract class SystemUIManager implements SystemUIClient.ServerListener {
    protected static final int CODE_SUCCESS = 1;
    protected ISystemUIService mService;

    protected abstract String logTag();

    /* JADX INFO: Access modifiers changed from: protected */
    public SystemUIManager() {
        SystemUIClient.get().addServerListener(this);
        this.mService = SystemUIClient.get().getSystemUIService();
    }

    @Override // com.xiaopeng.xuimanager.systemui.SystemUIClient.ServerListener
    public void onServerConnected(ISystemUIService service) {
        this.mService = service;
    }

    @Override // com.xiaopeng.xuimanager.systemui.SystemUIClient.ServerListener
    public void onServerDisconnected() {
        this.mService = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void log(String msg) {
        String logTag = logTag();
        SysLogUtils.i(logTag, msg + " --" + Thread.currentThread());
    }
}
