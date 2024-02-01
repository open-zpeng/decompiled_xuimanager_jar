package com.xiaopeng.xuimanager.systemui.masklayer;

import android.os.RemoteException;
import com.xiaopeng.xuimanager.systemui.ISystemUIService;
import com.xiaopeng.xuimanager.systemui.SystemUIManager;

/* loaded from: classes.dex */
public class MaskLayerManager extends SystemUIManager {
    @Override // com.xiaopeng.xuimanager.systemui.SystemUIManager
    protected String logTag() {
        return "MaskLayer";
    }

    public boolean requestShow(IMaskLayerListener listener, boolean isStackWindow, int screenId) {
        ISystemUIService service = this.mService;
        if (service != null) {
            try {
                int code = service.showMaskLayer(listener, isStackWindow, screenId);
                if (code != 1) {
                    return false;
                }
                return true;
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean notifyDismiss(IMaskLayerListener listener, int screenId) {
        ISystemUIService service = this.mService;
        if (service != null) {
            try {
                int code = service.dismissMaskLayer(listener, screenId);
                if (code != 1) {
                    return false;
                }
                return true;
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* loaded from: classes.dex */
    private static class Holder {
        private static final MaskLayerManager sInstance = new MaskLayerManager();

        private Holder() {
        }
    }

    private MaskLayerManager() {
    }

    public static MaskLayerManager get() {
        return Holder.sInstance;
    }
}
