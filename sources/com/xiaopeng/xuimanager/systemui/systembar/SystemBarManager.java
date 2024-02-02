package com.xiaopeng.xuimanager.systemui.systembar;

import android.content.Context;
import android.os.RemoteException;
import com.xiaopeng.xuimanager.systemui.ISystemUIService;
import com.xiaopeng.xuimanager.systemui.SystemUIManager;
import com.xiaopeng.xuimanager.systemui.systembar.ISystemBarListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes.dex */
public class SystemBarManager extends SystemUIManager {
    public static final String ID_PERSONAL = "personal";
    private ISystemBarListener mBarListener;
    private String mPkg;
    private CopyOnWriteArraySet<SystemBarListener> mSystemBarListeners;

    @Override // com.xiaopeng.xuimanager.systemui.SystemUIManager
    protected String logTag() {
        return "SystemBar";
    }

    public void init(Context context) {
        Context mContext = context.getApplicationContext();
        this.mPkg = mContext.getPackageName();
        log("init");
    }

    public boolean showSystemBar(String id, SystemBarItem item) {
        ISystemUIService service = this.mService;
        log(String.format("showSystemBar service:%s id:%s item:%s", service, id, item));
        if (service != null) {
            try {
                int code = service.showSystemBar(this.mPkg, id, item);
                return code == 1;
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            log("showSystemBar service is null ");
        }
        return false;
    }

    public boolean cancelSystemBar(String id) {
        ISystemUIService service = this.mService;
        log(String.format("cancelSystemBar service:%s id:%s", service, id));
        if (service != null) {
            try {
                int code = service.cancelSystemBar(this.mPkg, id);
                return code == 1;
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            log("cancelSystemBar service is null ");
        }
        return false;
    }

    public synchronized boolean registerListener(SystemBarListener listener) {
        log(String.format("registerListener listener:%s", listener));
        if (this.mSystemBarListeners == null) {
            this.mSystemBarListeners = new CopyOnWriteArraySet<>();
        }
        boolean isEmpty = this.mSystemBarListeners.isEmpty();
        this.mSystemBarListeners.add(listener);
        if (isEmpty) {
            if (this.mBarListener == null) {
                this.mBarListener = new BarListener();
            }
            ISystemUIService service = this.mService;
            if (service != null) {
                try {
                    int code = service.registerSystemBarListener(this.mPkg, this.mBarListener);
                    return code == 1;
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            } else {
                log("registerListener service is null ");
            }
            return false;
        }
        return true;
    }

    public synchronized boolean unRegisterListener(SystemBarListener listener) {
        log(String.format("unRegisterListener listener:%s", listener));
        if (this.mSystemBarListeners == null) {
            return true;
        }
        this.mSystemBarListeners.remove(listener);
        if (!this.mSystemBarListeners.isEmpty() || this.mBarListener == null) {
            return true;
        }
        ISystemUIService service = this.mService;
        if (service != null) {
            try {
                int code = service.unRegisterSystemBarListener(this.mPkg, this.mBarListener);
                this.mBarListener = null;
                return code == 1;
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            log("unRegisterListener service is null ");
        }
        return false;
    }

    /* loaded from: classes.dex */
    private class BarListener extends ISystemBarListener.Stub {
        private BarListener() {
        }

        @Override // com.xiaopeng.xuimanager.systemui.systembar.ISystemBarListener
        public int onContent(String id) throws RemoteException {
            SystemBarManager.this.log(String.format("onContent id:%s listener:%s", id, SystemBarManager.this.mSystemBarListeners));
            if (SystemBarManager.this.mSystemBarListeners != null) {
                Iterator it = SystemBarManager.this.mSystemBarListeners.iterator();
                while (it.hasNext()) {
                    SystemBarListener listener = (SystemBarListener) it.next();
                    listener.onSystemBarContent(id);
                }
            }
            return 0;
        }
    }

    /* loaded from: classes.dex */
    private static class Holder {
        private static final SystemBarManager sInstance = new SystemBarManager();

        private Holder() {
        }
    }

    public static SystemBarManager get() {
        return Holder.sInstance;
    }

    private SystemBarManager() {
    }
}
