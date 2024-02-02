package com.xiaopeng.xuimanager.pipebus.server;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import com.xiaopeng.xuimanager.pipebus.IPipeBus;
import com.xiaopeng.xuimanager.pipebus.IPipeBusListener;
import com.xiaopeng.xuimanager.pipebus.ParcelableContainer;
import com.xiaopeng.xuimanager.utils.LogUtil;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes.dex */
public abstract class AbsPipeBusManagerService extends IPipeBus.Stub implements IPipeBusManagerCallback {
    private static volatile boolean serviceReady = false;
    private final String TAG = getClass().getSimpleName();
    protected final ConcurrentHashMap<String, PipeBusManager> managerMap = new ConcurrentHashMap<>();
    protected final Map<Integer, PipeListenerRecord> mListenersMap = new ConcurrentHashMap();

    public abstract String getServiceName();

    public abstract void onTransactEnter(int i, Parcel parcel, Parcel parcel2, int i2, String str);

    public abstract void onTransactLeave(int i, Parcel parcel, Parcel parcel2, int i2, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class PipeListenerRecord implements IBinder.DeathRecipient {
        public IPipeBusListener listener;
        public Set<String> moduleList = new CopyOnWriteArraySet();
        public final int pid;
        public final int uid;

        PipeListenerRecord(IPipeBusListener listener, int pid, int uid) {
            this.listener = listener;
            this.pid = pid;
            this.uid = uid;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            String str = AbsPipeBusManagerService.this.TAG;
            LogUtil.w(str, "binder died,pid=" + this.pid);
            AbsPipeBusManagerService.this.mListenersMap.remove(Integer.valueOf(this.pid));
            if (this.moduleList.size() > 0) {
                for (String m : this.moduleList) {
                    AbsPipeBusManagerService.this.diedToManagers(m, this.uid, this.pid);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diedToManagers(String name, int uid, int pid) {
        boolean pidLive = false;
        Iterator<PipeListenerRecord> it = this.mListenersMap.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            PipeListenerRecord record = it.next();
            if (record.moduleList.contains(name)) {
                pidLive = true;
                break;
            }
        }
        PipeBusManager manager = this.managerMap.get(name);
        if (manager != null) {
            String str = this.TAG;
            LogUtil.i(str, "diedToManagers, clear callback for:" + name + ",pidLive:" + pidLive);
            if (!pidLive) {
                manager.registerCallback(null);
            }
            if (pid > 0) {
                manager.onClientDied(uid, pid);
                return;
            }
            return;
        }
        String str2 = this.TAG;
        LogUtil.w(str2, "diedToManagers, manager not found:" + name);
    }

    public boolean init() {
        boolean ret = true;
        try {
            ServiceManager.addService(getServiceName(), this);
        } catch (Exception e) {
            LogUtil.w(this.TAG, "addService e=" + e);
            ret = false;
        }
        for (PipeBusManager manager : this.managerMap.values()) {
            manager.init();
        }
        synchronized (getClass()) {
            getClass().notifyAll();
        }
        serviceReady = true;
        return ret;
    }

    public void addManager(String module, PipeBusManager manager) {
        PipeBusManager managerOld = this.managerMap.get(module);
        if (managerOld != null) {
            String str = this.TAG;
            LogUtil.w(str, "addManager,old=" + managerOld + ",new=" + manager);
        }
        this.managerMap.put(module, manager);
    }

    public static boolean isServiceReady() {
        return serviceReady;
    }

    public void waitManagersReady(long timeoutMs) {
        synchronized (getClass()) {
            if (serviceReady) {
                return;
            }
            try {
                getClass().wait(timeoutMs);
            } catch (Exception e) {
                String str = this.TAG;
                LogUtil.w(str, "waitManagersReady e=" + e);
            }
        }
    }

    @Override // com.xiaopeng.xuimanager.pipebus.IPipeBus.Stub, android.os.Binder
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        String key = "code=" + code + ",pid=" + Binder.getCallingPid() + "@" + SystemClock.elapsedRealtimeNanos();
        onTransactEnter(code, data, reply, flags, key);
        try {
            try {
                boolean ret = super.onTransact(code, data, reply, flags);
                return ret;
            } catch (RemoteException e) {
                LogUtil.w(this.TAG, "onTransact e=" + e + ",code=" + code);
                throw e;
            }
        } finally {
            onTransactLeave(code, data, reply, flags, key);
        }
    }

    @Override // com.xiaopeng.xuimanager.pipebus.server.IPipeBusManagerCallback
    public void onPipeBusEvent(String module, String types, String[] events) {
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onPipeBusEvent,module=");
        sb.append(module);
        sb.append(",types:");
        sb.append(types);
        sb.append(",events:");
        sb.append(events != null ? events[0] : null);
        LogUtil.i(str, sb.toString());
        for (PipeListenerRecord record : this.mListenersMap.values()) {
            if (record.moduleList.contains(module)) {
                try {
                    record.listener.onPipeBusEvent(module, types, events);
                } catch (Exception e) {
                    String str2 = this.TAG;
                    LogUtil.w(str2, "onPipeBusEvent,e=" + e);
                }
            }
        }
    }

    @Override // com.xiaopeng.xuimanager.pipebus.server.IPipeBusManagerCallback
    public void onPipeBusEvent(String module, String types, String[] events, int pid) {
        PipeListenerRecord record = this.mListenersMap.get(Integer.valueOf(pid));
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onPipeBusEvent,module=");
        sb.append(module);
        sb.append(",types:");
        sb.append(types);
        sb.append(",events:");
        sb.append(events != null ? events[0] : null);
        sb.append(",target pid:");
        sb.append(pid);
        sb.append(",record:");
        sb.append(record);
        LogUtil.i(str, sb.toString());
        if (record != null && record.moduleList.contains(module)) {
            try {
                record.listener.onPipeBusEvent(module, types, events);
                return;
            } catch (Exception e) {
                String str2 = this.TAG;
                LogUtil.w(str2, "onPipeBusEvent, e=" + e + ",target pid=" + pid);
                return;
            }
        }
        String str3 = this.TAG;
        LogUtil.w(str3, "onPipeBusEvent,no valid record,target pid=" + pid + ",module=" + module + ",record=" + record);
    }

    @Override // com.xiaopeng.xuimanager.pipebus.server.IPipeBusManagerCallback
    public void onPipeBusParcelEvent(String module, String types, ParcelableContainer data) {
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onPipeBusParcelEvent,module=");
        sb.append(module);
        sb.append(",types:");
        sb.append(types);
        sb.append(",parcel data:");
        sb.append(data != null ? data : null);
        LogUtil.i(str, sb.toString());
        for (PipeListenerRecord record : this.mListenersMap.values()) {
            if (record.moduleList.contains(module)) {
                try {
                    record.listener.onPipeBusParcelEvent(module, types, data);
                } catch (Exception e) {
                    String str2 = this.TAG;
                    LogUtil.w(str2, "onPipeBusParcelEvent,e=" + e);
                }
            }
        }
    }

    @Override // com.xiaopeng.xuimanager.pipebus.server.IPipeBusManagerCallback
    public void onPipeBusParcelEvent(String module, String types, ParcelableContainer data, int pid) {
        PipeListenerRecord record = this.mListenersMap.get(Integer.valueOf(pid));
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onPipeBusParcelEvent,module=");
        sb.append(module);
        sb.append(",types:");
        sb.append(types);
        sb.append(",parcel data:");
        sb.append(data != null ? data : null);
        sb.append(",target pid:");
        sb.append(pid);
        sb.append(",record:");
        sb.append(record);
        LogUtil.i(str, sb.toString());
        if (record != null && record.moduleList.contains(module)) {
            try {
                record.listener.onPipeBusParcelEvent(module, types, data);
                return;
            } catch (Exception e) {
                String str2 = this.TAG;
                LogUtil.w(str2, "onPipeBusParcelEvent, e=" + e + ",target pid=" + pid);
                return;
            }
        }
        String str3 = this.TAG;
        LogUtil.w(str3, "onPipeBusParcelEvent,no valid record,target pid=" + pid + ",module=" + module + ",record=" + record);
    }

    @Override // com.xiaopeng.xuimanager.pipebus.IPipeBus
    public int ioControl(String module, String cmd, String[] params) throws RemoteException {
        int uid = Binder.getCallingUid();
        int pid = Binder.getCallingPid();
        PipeBusManager manager = this.managerMap.get(module);
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("ioControl,module:");
        sb.append(module);
        sb.append(",cmd:");
        sb.append(cmd);
        sb.append(",param:");
        sb.append(params != null ? params[0] : null);
        sb.append(",manager=");
        sb.append(manager);
        LogUtil.i(str, sb.toString());
        if (manager == null) {
            return -1;
        }
        int ret = manager.ioControl(cmd, params, uid, pid);
        return ret;
    }

    @Override // com.xiaopeng.xuimanager.pipebus.IPipeBus
    public int ioControlWithPocket(String moduleName, String cmd, String[] params, String[] results) {
        int uid = Binder.getCallingUid();
        int pid = Binder.getCallingPid();
        PipeBusManager manager = this.managerMap.get(moduleName);
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("ioControl,module:");
        sb.append(moduleName);
        sb.append(",cmd:");
        sb.append(cmd);
        sb.append(",param:");
        sb.append(params != null ? params[0] : null);
        sb.append(",manager=");
        sb.append(manager);
        LogUtil.i(str, sb.toString());
        if (manager == null) {
            return -1;
        }
        int ret = manager.ioControlWithPocket(cmd, params, results, uid, pid);
        return ret;
    }

    @Override // com.xiaopeng.xuimanager.pipebus.IPipeBus
    public int ioControlWithParcelable(String moduleName, String cmd, ParcelableContainer dataIn, ParcelableContainer dataOut) {
        int uid = Binder.getCallingUid();
        int pid = Binder.getCallingPid();
        PipeBusManager manager = this.managerMap.get(moduleName);
        String str = this.TAG;
        LogUtil.i(str, "ioControl,module:" + moduleName + ",cmd:" + cmd + ",dataIn:" + dataIn + ",dataOut:" + dataOut);
        if (manager == null) {
            return -1;
        }
        int ret = manager.ioControlWithParcelable(cmd, dataIn, dataOut, uid, pid);
        return ret;
    }

    @Override // com.xiaopeng.xuimanager.pipebus.IPipeBus
    public void registerListener(IPipeBusListener iPipeBusListener) {
        int uid = Binder.getCallingUid();
        int pid = Binder.getCallingPid();
        String str = this.TAG;
        LogUtil.w(str, "not implement,registerListener,uid=" + uid + ",pid=" + pid + ",binder=" + iPipeBusListener.getClass());
    }

    @Override // com.xiaopeng.xuimanager.pipebus.IPipeBus
    public void unRegisterListener(IPipeBusListener iPipeBusListener) throws RemoteException {
        int uid = Binder.getCallingUid();
        int pid = Binder.getCallingPid();
        String str = this.TAG;
        LogUtil.w(str, "not implement,unRegisterListener,uid=" + uid + ",pid=" + pid + ",binder=" + iPipeBusListener.getClass());
    }

    @Override // com.xiaopeng.xuimanager.pipebus.IPipeBus
    public synchronized void registerListenerEx(String moduleName, IPipeBusListener iPipeBusListener) {
        int uid = Binder.getCallingUid();
        int pid = Binder.getCallingPid();
        String str = this.TAG;
        LogUtil.i(str, "registerListenerEx,uid=" + uid + ",pid=" + pid + ",binder=" + iPipeBusListener.getClass());
        PipeBusManager manager = this.managerMap.get(moduleName);
        if (manager != null) {
            synchronized (manager) {
                manager.registerCallback(this);
                manager.registerListener(uid, pid);
            }
            PipeListenerRecord record = this.mListenersMap.get(Integer.valueOf(pid));
            if (record == null) {
                record = new PipeListenerRecord(iPipeBusListener, pid, uid);
                try {
                    iPipeBusListener.asBinder().linkToDeath(record, 0);
                    this.mListenersMap.put(Integer.valueOf(pid), record);
                } catch (Exception e) {
                    String str2 = this.TAG;
                    LogUtil.e(str2, "registerListenerEx,linkToDeath e=" + e.toString());
                    return;
                }
            }
            record.moduleList.add(moduleName);
            return;
        }
        String str3 = this.TAG;
        LogUtil.w(str3, "registerListenerEx, manager not found:" + moduleName);
    }

    @Override // com.xiaopeng.xuimanager.pipebus.IPipeBus
    public synchronized void unRegisterListenerEx(String moduleName) {
        int uid = Binder.getCallingUid();
        int pid = Binder.getCallingPid();
        String str = this.TAG;
        LogUtil.i(str, "unRegisterListenerEx,uid=" + uid + ",pid=" + pid + ",module=" + moduleName);
        PipeBusManager manager = this.managerMap.get(moduleName);
        if (manager != null) {
            synchronized (manager) {
                manager.unRegisterListener(uid, pid);
            }
            PipeListenerRecord record = this.mListenersMap.get(Integer.valueOf(pid));
            if (record == null) {
                String str2 = this.TAG;
                LogUtil.w(str2, "unRegisterListenerEx,no listener for:" + moduleName);
                return;
            }
            record.moduleList.remove(moduleName);
            if (record.moduleList.isEmpty()) {
                this.mListenersMap.remove(Integer.valueOf(pid));
                try {
                    record.listener.asBinder().unlinkToDeath(record, 0);
                    record.listener = null;
                } catch (Exception e) {
                    String str3 = this.TAG;
                    LogUtil.w(str3, "unlinkToDeath e=" + e);
                }
            }
            diedToManagers(moduleName, -1, -1);
            return;
        }
        String str4 = this.TAG;
        LogUtil.w(str4, "unRegisterListenerEx, manager not found:" + moduleName);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Binder
    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        char c;
        pw.println("dump " + this.TAG);
        if (args == null || args.length < 1) {
            pw.println("please input params");
            return;
        }
        for (int opti = 0; opti < args.length; opti++) {
            String str = args[opti];
            switch (str.hashCode()) {
                case 1503:
                    if (str.equals("-l")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 1504:
                    if (str.equals("-m")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 44880459:
                    if (str.equals("-list")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 214175961:
                    if (str.equals("-module")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                    pw.println("registered modules:");
                    for (String m : this.managerMap.keySet()) {
                        pw.println(m);
                    }
                    break;
                case 2:
                case 3:
                    if (opti + 1 >= args.length) {
                        pw.println("lack of module name...");
                        return;
                    }
                    String module = args[opti + 1];
                    pw.println("dump module:" + module);
                    PipeBusManager manager = this.managerMap.get(module);
                    if (manager == null) {
                        pw.println("no manager for:" + module);
                        return;
                    }
                    String[] argOpt = getOptArgs(args, opti + 2);
                    if (argOpt == null) {
                        pw.println("lack of module params...");
                        return;
                    } else {
                        manager.dump(pw, argOpt);
                        break;
                    }
            }
        }
    }

    private static String[] getOptArgs(String[] args, int start) {
        String[] subArgs = null;
        if (start < args.length) {
            subArgs = new String[args.length - start];
            for (int i = start; i < args.length; i++) {
                subArgs[i - start] = args[i];
            }
        }
        return subArgs;
    }
}
