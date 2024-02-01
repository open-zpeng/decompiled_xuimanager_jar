package com.xiaopeng.xuimanager.systemui.dock;

import android.content.Context;
import android.os.RemoteException;
import com.xiaopeng.xuimanager.systemui.ISystemUIService;
import com.xiaopeng.xuimanager.systemui.SystemUIManager;
import com.xiaopeng.xuimanager.systemui.dock.IDockEventListener;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
public class DockManager extends SystemUIManager {
    private static final String TAG = "DockManager";
    private CopyOnWriteArraySet<DockEventListener> mDockEventListeners;
    private IDockEventListener mDockListener;
    private String mPkg;

    public void init(Context context) {
        Context mContext = context.getApplicationContext();
        this.mPkg = mContext.getPackageName();
        log("init");
    }

    @Override // com.xiaopeng.xuimanager.systemui.SystemUIManager, com.xiaopeng.xuimanager.systemui.SystemUIClient.ServerListener
    public void onServerConnected(ISystemUIService service) {
        super.onServerConnected(service);
    }

    @Override // com.xiaopeng.xuimanager.systemui.SystemUIManager, com.xiaopeng.xuimanager.systemui.SystemUIClient.ServerListener
    public void onServerDisconnected() {
        super.onServerDisconnected();
    }

    @Override // com.xiaopeng.xuimanager.systemui.SystemUIManager
    protected String logTag() {
        return TAG;
    }

    public List<DockItem> getDockItems() {
        ISystemUIService service = this.mService;
        log("getDockItems");
        if (service != null) {
            try {
                return service.getDockItems("");
            } catch (RemoteException e) {
                e.printStackTrace();
                return null;
            }
        }
        log("getDockItems service is null ");
        return null;
    }

    public List<DockItem> getShortcutAndComponents() {
        ISystemUIService service = this.mService;
        log("getShortcutAndComponents");
        if (service != null) {
            try {
                return service.getShortcutAndComponents("");
            } catch (RemoteException e) {
                e.printStackTrace();
                return null;
            }
        }
        log("getShortcutAndComponents service is null ");
        return null;
    }

    public synchronized boolean registerListener(DockEventListener listener) {
        log(String.format("registerListener listener:%s", listener));
        if (this.mDockEventListeners == null) {
            this.mDockEventListeners = new CopyOnWriteArraySet<>();
        }
        boolean isEmpty = this.mDockEventListeners.isEmpty();
        this.mDockEventListeners.add(listener);
        if (isEmpty) {
            if (this.mDockListener == null) {
                this.mDockListener = new DockListener();
            }
            ISystemUIService service = this.mService;
            if (service != null) {
                try {
                    service.registerDockListener(this.mPkg, this.mDockListener);
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

    public synchronized boolean unRegisterListener(DockEventListener listener) {
        log(String.format("unRegisterListener listener:%s", listener));
        if (this.mDockListener == null) {
            return true;
        }
        this.mDockEventListeners.remove(listener);
        if (!this.mDockEventListeners.isEmpty() || this.mDockListener == null) {
            return true;
        }
        ISystemUIService service = this.mService;
        if (service != null) {
            try {
                int code = service.unRegisterDockListener(this.mPkg, this.mDockListener);
                this.mDockListener = null;
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
    private class DockListener extends IDockEventListener.Stub {
        private DockListener() {
        }

        @Override // com.xiaopeng.xuimanager.systemui.dock.IDockEventListener
        public void onDockItemAdd(DockItem dockItem) throws RemoteException {
            if (DockManager.this.mDockEventListeners != null && !DockManager.this.mDockEventListeners.isEmpty()) {
                Iterator it = DockManager.this.mDockEventListeners.iterator();
                while (it.hasNext()) {
                    DockEventListener listener = (DockEventListener) it.next();
                    listener.onItemAdded(dockItem);
                }
            }
        }

        @Override // com.xiaopeng.xuimanager.systemui.dock.IDockEventListener
        public void onDockItemRemoved(DockItem dockItem) throws RemoteException {
            if (DockManager.this.mDockEventListeners != null && !DockManager.this.mDockEventListeners.isEmpty()) {
                Iterator it = DockManager.this.mDockEventListeners.iterator();
                while (it.hasNext()) {
                    DockEventListener listener = (DockEventListener) it.next();
                    listener.onItemRemoved(dockItem);
                }
            }
        }

        @Override // com.xiaopeng.xuimanager.systemui.dock.IDockEventListener
        public void onEnterEdit(boolean enable) throws RemoteException {
            if (DockManager.this.mDockEventListeners != null && !DockManager.this.mDockEventListeners.isEmpty()) {
                Iterator it = DockManager.this.mDockEventListeners.iterator();
                while (it.hasNext()) {
                    DockEventListener listener = (DockEventListener) it.next();
                    listener.onEnterEdit(enable);
                }
            }
        }

        @Override // com.xiaopeng.xuimanager.systemui.dock.IDockEventListener
        public void onDockEvent(int eventId, String params) throws RemoteException {
        }
    }

    /* loaded from: classes.dex */
    private static class Holder {
        private static final DockManager sInstance = new DockManager();

        private Holder() {
        }
    }

    public static DockManager get() {
        return Holder.sInstance;
    }

    private DockManager() {
    }
}
