package com.xiaopeng.xuimanager.systemui.osd;

import android.os.RemoteException;
import com.xiaopeng.xuimanager.systemui.ISystemUIService;
import com.xiaopeng.xuimanager.systemui.SystemUIManager;
/* loaded from: classes.dex */
public class OsdManager extends SystemUIManager {
    @Override // com.xiaopeng.xuimanager.systemui.SystemUIManager
    protected String logTag() {
        return "Osd";
    }

    public boolean requestShow(IOsdListener listener, int osdType, String regionId) {
        ISystemUIService service = this.mService;
        if (service != null) {
            try {
                int code = service.showOsd(listener, osdType, regionId);
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

    public boolean notifyHide(IOsdListener listener, String regionId) {
        ISystemUIService service = this.mService;
        if (service != null) {
            try {
                int code = service.hideOsd(listener, regionId);
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
        private static final OsdManager sInstance = new OsdManager();

        private Holder() {
        }
    }

    private OsdManager() {
    }

    public static OsdManager get() {
        return Holder.sInstance;
    }
}
