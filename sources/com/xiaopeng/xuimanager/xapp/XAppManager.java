package com.xiaopeng.xuimanager.xapp;

import android.annotation.SystemApi;
import android.app.ActivityThread;
import android.app.AppGlobals;
import android.app.IActivityManager;
import android.app.INotificationManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.IPackageManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.ArraySet;
import android.util.Log;
import android.view.WindowManager;
import com.xiaopeng.app.xpAppInfo;
import com.xiaopeng.xuimanager.XUIManager;
import com.xiaopeng.xuimanager.XUIManagerBase;
import com.xiaopeng.xuimanager.XUIServiceNotConnectedException;
import com.xiaopeng.xuimanager.access.AccessAppManager;
import com.xiaopeng.xuimanager.userscenario.UserScenarioManager;
import com.xiaopeng.xuimanager.xapp.IXApp;
import com.xiaopeng.xuimanager.xapp.IXAppEventListener;
import com.xiaopeng.xuimanager.xapp.IXMiniProgEventListener;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@SystemApi
/* loaded from: classes.dex */
public class XAppManager implements XUIManagerBase {
    public static final int APP_CATEGORY_ACCESS = 100;
    public static final boolean DBG = true;
    private static final int MSG_XAPP_ERROR_EVENT = 0;
    public static final String TAG = "XAppManager";
    private static WindowManager mWindowManager;
    private final Handler mHandler;
    private IXApp mService;
    private static String mServiceName = null;
    private static Context mContext = ActivityThread.currentActivityThread().getApplication();
    private static final ArraySet<XMiniProgEventListener> mMiniProgListeners = new ArraySet<>();
    private final ArraySet<XAppEventListener> mListeners = new ArraySet<>();
    private XAppEventListenerToService mListenerToService = null;
    private XMiniProgEventListenerToService mMiniProgListenerToService = null;

    /* loaded from: classes.dex */
    public interface AppType {
        public static final int APP_TYPE_EDUCATION = 5;
        public static final int APP_TYPE_GAME = 3;
        public static final int APP_TYPE_INFO = 4;
        public static final int APP_TYPE_KARAOKE = 7;
        public static final int APP_TYPE_MUSIC = 1;
        public static final int APP_TYPE_OTHER = 0;
        public static final int APP_TYPE_TOOL = 6;
        public static final int APP_TYPE_VIDEO = 2;
    }

    /* loaded from: classes.dex */
    public interface MiniProgType {
        public static final int MINI_PROG_TYPE_EXIT = 5;
        public static final int MINI_PROG_TYPE_INIT = 0;
        public static final int MINI_PROG_TYPE_LAUNCH = 3;
        public static final int MINI_PROG_TYPE_LOGIN = 1;
        public static final int MINI_PROG_TYPE_LOGIN_INFO = 6;
        public static final int MINI_PROG_TYPE_LOGOUT = 2;
        public static final int MINI_PROG_TYPE_MINI_LIST = 7;
        public static final int MINI_PROG_TYPE_PRELOAD = 4;
    }

    /* loaded from: classes.dex */
    public interface XAppEventListener {
        void onErrorEvent(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface XMiniProgEventListener {
        void onMiniProgCallBack(int i, MiniProgramResponse miniProgramResponse);
    }

    /* loaded from: classes.dex */
    private static final class EventCallbackHandler extends Handler {
        WeakReference<XAppManager> mMgr;

        EventCallbackHandler(XAppManager mgr, Looper looper) {
            super(looper);
            this.mMgr = new WeakReference<>(mgr);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                XAppManager mgr = this.mMgr.get();
                if (mgr != null) {
                    mgr.dispatchErrorEventToClient(((Integer) msg.obj).intValue(), msg.arg1);
                    return;
                }
                return;
            }
            Log.e(XAppManager.TAG, "Event type not handled?" + msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class XAppEventListenerToService extends IXAppEventListener.Stub {
        private final WeakReference<XAppManager> mManager;

        public XAppEventListenerToService(XAppManager manager) {
            this.mManager = new WeakReference<>(manager);
        }

        @Override // com.xiaopeng.xuimanager.xapp.IXAppEventListener
        public void onError(int errorCode, int operation) {
            XAppManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleErrorEvent(errorCode, operation);
            }
        }
    }

    public XAppManager(IBinder service, Context context, Handler handler) {
        mContext = context;
        mWindowManager = (WindowManager) mContext.getSystemService("window");
        this.mService = IXApp.Stub.asInterface(service);
        this.mHandler = new EventCallbackHandler(this, handler.getLooper());
    }

    public synchronized void registerListener(XAppEventListener listener) throws XUIServiceNotConnectedException {
        if (this.mListeners.isEmpty()) {
            try {
                this.mListenerToService = new XAppEventListenerToService(this);
                this.mService.registerListener(this.mListenerToService);
            } catch (RemoteException ex) {
                Log.e(TAG, "Could not connect: " + ex.toString());
                throw new XUIServiceNotConnectedException(ex);
            } catch (IllegalStateException ex2) {
                XUIManager.checkXUIServiceNotConnectedExceptionFromXUIService(ex2);
            }
        }
        this.mListeners.add(listener);
    }

    public synchronized void unregisterListener(XAppEventListener listener) throws XUIServiceNotConnectedException {
        Log.d(TAG, "unregisterListener");
        this.mListeners.remove(listener);
        if (this.mListeners.isEmpty()) {
            try {
                this.mService.unregisterListener(this.mListenerToService);
                this.mListenerToService = null;
            } catch (RemoteException e) {
                Log.e(TAG, "Could not unregister: " + e.toString());
                throw new XUIServiceNotConnectedException(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchErrorEventToClient(int errorCode, int operation) {
        Collection<XAppEventListener> listeners;
        synchronized (this) {
            listeners = this.mListeners;
        }
        if (!listeners.isEmpty()) {
            for (XAppEventListener l : listeners) {
                l.onErrorEvent(errorCode, operation);
            }
            return;
        }
        Log.e(TAG, "Listener is null, not dispatching event.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleErrorEvent(int errorCode, int operation) {
        Message message = this.mHandler.obtainMessage();
        message.what = 0;
        message.obj = Integer.valueOf(errorCode);
        message.arg1 = operation;
        this.mHandler.sendMessage(message);
    }

    public void setAppUsedLimitEnable(boolean enable) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setAppUsedLimitEnable(boolean enable):" + enable);
        try {
            this.mService.setAppUsedLimitEnable(enable);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setAppUsedLimitEnable: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public boolean getAppUsedLimitEnable() throws XUIServiceNotConnectedException {
        Log.d(TAG, "getAppUsedLimitEnable()");
        try {
            return this.mService.getAppUsedLimitEnable();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getAppUsedLimitEnable: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int checkAppStart(String packageName) throws XUIServiceNotConnectedException {
        Log.d(TAG, "checkAppStart()");
        try {
            return this.mService.checkAppStart(packageName);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not checkAppStart: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int onAppConfigUpload(String pkgName, String config) throws XUIServiceNotConnectedException {
        Log.d(TAG, "onAppConfigUpload()");
        try {
            return this.mService.onAppConfigUpload(pkgName, config);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not onAppConfigUpload: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIDisconnected() {
        Iterator<XAppEventListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            XAppEventListener l = it.next();
            try {
                unregisterListener(l);
            } catch (XUIServiceNotConnectedException e) {
            }
        }
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIConnected(IBinder service) {
        this.mService = IXApp.Stub.asInterface(service);
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void setServiceName(String name) {
        mServiceName = name;
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public String getServiceName() {
        if (mServiceName == null) {
            mServiceName = getClass().getSimpleName();
        }
        return mServiceName;
    }

    public synchronized void registerMiniProgListener(XMiniProgEventListener mListener) throws XUIServiceNotConnectedException {
        Log.d(TAG, "registerMiniProgListener");
        if (mMiniProgListeners.isEmpty()) {
            try {
                this.mMiniProgListenerToService = new XMiniProgEventListenerToService(this);
                this.mService.registerMiniProgListener(this.mMiniProgListenerToService);
            } catch (Exception ex) {
                Log.e(TAG, "Could not connect: " + ex.toString());
            }
        }
        mMiniProgListeners.add(mListener);
    }

    public synchronized void unregisterMiniProgListener(XMiniProgEventListener listener) throws XUIServiceNotConnectedException {
        Log.d(TAG, "unregisterMiniProgListener");
        mMiniProgListeners.remove(listener);
        if (mMiniProgListeners.isEmpty()) {
            try {
                this.mService.unregisterMiniProgListener(this.mMiniProgListenerToService);
                this.mMiniProgListenerToService = null;
            } catch (RemoteException e) {
                Log.e(TAG, "Could not unregister: " + e.toString());
                throw new XUIServiceNotConnectedException(e);
            }
        }
    }

    public void startMiniProgram(String id, String name, Map<String, String> params) throws XUIServiceNotConnectedException {
        Log.d(TAG, "startMiniProgram id:" + id + " name:" + name + " params:" + params);
        try {
            this.mService.startMiniProgram(id, name, params);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not startMiniProgram: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void logoutAccount() throws XUIServiceNotConnectedException {
        Log.d(TAG, "logoutAccount");
        try {
            this.mService.logoutAccount();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not logoutAccount: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void attachContext() throws XUIServiceNotConnectedException {
        Log.d(TAG, "attachContext");
        try {
            this.mService.attachContext();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not attachContext: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void initService() throws XUIServiceNotConnectedException {
        Log.d(TAG, "initService");
        try {
            this.mService.initService();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not initService: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public boolean isServiceOnline() throws XUIServiceNotConnectedException {
        Log.d(TAG, "isServiceOnline");
        try {
            return this.mService.isServiceOnline();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not isServiceOnline: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void activeArome(Map pamams) throws XUIServiceNotConnectedException {
        Log.d(TAG, "activeArome");
        try {
            this.mService.activeArome(pamams);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not activeArome: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void loginAccount() throws XUIServiceNotConnectedException {
        Log.d(TAG, "loginAccount");
        try {
            this.mService.loginAccount();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not loginAccount: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void exitApp(String id) throws XUIServiceNotConnectedException {
        Log.d(TAG, "exitApp");
        try {
            this.mService.exitApp(id);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not exitApp: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void preloadApp(String appId, boolean loadToMemory) throws XUIServiceNotConnectedException {
        Log.d(TAG, "preloadApp");
        try {
            this.mService.preloadApp(appId, loadToMemory);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not preloadApp: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void requestLoginInfo() throws XUIServiceNotConnectedException {
        Log.d(TAG, "requestLoginInfo");
        try {
            this.mService.requestLoginInfo();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not requestLoginInfo: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void requestMiniList(String alipayVersion) throws XUIServiceNotConnectedException {
        Log.d(TAG, "requestMiniList");
        try {
            this.mService.requestMiniList(alipayVersion);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not requestMiniList: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void uploadAlipayLog() throws XUIServiceNotConnectedException {
        Log.d(TAG, "uploadAlipayLog");
        try {
            this.mService.uploadAlipayLog();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not uploadAlipayLog: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public boolean isTopActivityFullscreen() throws Exception {
        IBinder b = ServiceManager.getService(UserScenarioManager.SOURCE_ACTIVITY);
        return IActivityManager.Stub.asInterface(b).isTopActivityFullscreen();
    }

    public void forceGrantFolderPermission(String path) throws Exception {
        IBinder b = ServiceManager.getService(UserScenarioManager.SOURCE_ACTIVITY);
        IActivityManager.Stub.asInterface(b).forceGrantFolderPermission(path);
    }

    public static List<String> getSpeechObserver() throws Exception {
        IBinder b = ServiceManager.getService(UserScenarioManager.SOURCE_ACTIVITY);
        return IActivityManager.Stub.asInterface(b).getSpeechObserver();
    }

    public static void setToastEnabled(boolean enabled) throws Exception {
        INotificationManager nm = NotificationManager.getService();
        if (nm != null) {
            nm.setToastEnabled(enabled);
        }
    }

    public static void setOsdEnabled(boolean enabled) throws Exception {
        INotificationManager nm = NotificationManager.getService();
        if (nm != null) {
            nm.setOsdEnabled(enabled);
        }
    }

    public static List<xpAppInfo> getXpAppPackageList(int screenId) throws Exception {
        IPackageManager pm = AppGlobals.getPackageManager();
        List<xpAppInfo> defaultList = null;
        if (pm != null) {
            defaultList = pm.getXpAppPackageList(screenId);
        } else {
            Log.w(TAG, "getXpAppPackageList from pm null");
        }
        List<xpAppInfo> accessAppList = getAccessAppList();
        if (accessAppList != null && !accessAppList.isEmpty()) {
            if (defaultList != null) {
                defaultList.addAll((Collection) accessAppList.stream().collect(Collectors.toList()));
                return defaultList;
            }
            return accessAppList;
        }
        return defaultList;
    }

    public static List<xpAppInfo> getXpAppPackageList() throws Exception {
        mContext.getPackageName();
        return getXpAppPackageList(0);
    }

    public static List<xpAppInfo> getXpAppPackageListByCategory(int category) {
        if (100 == category) {
            return AccessAppManager.getInstance().getAppList();
        }
        return null;
    }

    private static List<xpAppInfo> getAccessAppList() {
        return AccessAppManager.getInstance().getAppList();
    }

    public int startXpApp(String uriParam, Intent intent) {
        Log.d(TAG, "startXpApp with uriParam:" + uriParam);
        try {
            return this.mService.startXpApp(uriParam, intent);
        } catch (Exception e) {
            Log.e(TAG, "Could not startXpApp: " + e);
            return -1;
        }
    }

    public int getAppType(String pkgName) throws XUIServiceNotConnectedException {
        Log.d(TAG, "getAppType with pkgName:" + pkgName);
        try {
            return this.mService.getAppType(pkgName);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getAppType: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public List<String> getInstalledAppList(int appType) throws XUIServiceNotConnectedException {
        Log.d(TAG, "getInstalledAppList with type:" + appType);
        try {
            return this.mService.getInstalledAppList(appType);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getInstalledAppList: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void closeCancelableDialog() throws XUIServiceNotConnectedException {
        Log.d(TAG, "closeCancelableDialog");
        try {
            this.mService.closeCancelableDialog();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not closeCancelableDialog: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void startPanel(Context context, Intent intent) {
        Log.d(TAG, "startPanel");
        if (context != null && intent != null) {
            try {
                if (isTopActivityFullscreen()) {
                    intent.putExtra("needFullScreen", true);
                }
                context.startActivity(intent);
                return;
            } catch (Exception e) {
                Log.e(TAG, "startPanel failed :" + e.toString());
                return;
            }
        }
        Log.w(TAG, "context or intent is null");
    }

    /* loaded from: classes.dex */
    private static class XMiniProgEventListenerToService extends IXMiniProgEventListener.Stub {
        private final WeakReference<XAppManager> mManager;

        public XMiniProgEventListenerToService(XAppManager manager) {
            this.mManager = new WeakReference<>(manager);
        }

        @Override // com.xiaopeng.xuimanager.xapp.IXMiniProgEventListener
        public void onMiniProgCallBack(int type, MiniProgramResponse response) {
            try {
                Iterator it = XAppManager.mMiniProgListeners.iterator();
                while (it.hasNext()) {
                    XMiniProgEventListener l = (XMiniProgEventListener) it.next();
                    l.onMiniProgCallBack(type, response);
                }
            } catch (Exception e) {
            }
        }
    }
}
