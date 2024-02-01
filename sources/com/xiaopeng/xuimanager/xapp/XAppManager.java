package com.xiaopeng.xuimanager.xapp;

import android.annotation.SystemApi;
import android.app.AppGlobals;
import android.app.IActivityManager;
import android.app.INotificationManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.IPackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.provider.Settings;
import android.util.ArraySet;
import android.util.Log;
import android.view.WindowManager;
import com.xiaopeng.app.xpAppInfo;
import com.xiaopeng.xuimanager.XUIManager;
import com.xiaopeng.xuimanager.XUIManagerBase;
import com.xiaopeng.xuimanager.XUIServiceNotConnectedException;
import com.xiaopeng.xuimanager.userscenario.UserScenarioManager;
import com.xiaopeng.xuimanager.xapp.IXApp;
import com.xiaopeng.xuimanager.xapp.IXAppEventListener;
import com.xiaopeng.xuimanager.xapp.IXMiniProgEventListener;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SystemApi
/* loaded from: classes.dex */
public class XAppManager implements XUIManagerBase {
    public static final boolean DBG = true;
    private static final int MSG_XAPP_ERROR_EVENT = 0;
    private static final int MSG_XAPP_START_APP_EVENT = 1;
    public static final String TAG = "XAppManager";
    private static Context mContext;
    private static WindowManager mWindowManager;
    private final Handler mHandler;
    private IXApp mService;
    private static String mServiceName = null;
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
        public static final int TYPE_LAUNCH_SERVICE = 12;
        public static final int TYPE_MINI_DETAIL = 9;
        public static final int TYPE_UPLOAD_INFO = 13;
        public static final int TYPE_UPLOAD_LOG = 8;
        public static final int TYPE_VERIFY_IDENTITY = 10;
        public static final int TYPE_VERIFY_INFO = 11;
    }

    /* loaded from: classes.dex */
    public interface XMiniProgEventListener {
        void onMiniProgCallBack(int i, MiniProgramResponse miniProgramResponse);
    }

    /* loaded from: classes.dex */
    public interface XAppEventListener {
        void onErrorEvent(int i, int i2);

        default void onStartAppEvent(Bundle extras) {
        }
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
            XAppManager mgr = this.mMgr.get();
            int i = msg.what;
            if (i == 0) {
                if (mgr != null) {
                    mgr.dispatchErrorEventToClient(((Integer) msg.obj).intValue(), msg.arg1);
                }
            } else if (i == 1) {
                if (mgr != null) {
                    mgr.dispatchStartAppEventToClient((Bundle) msg.obj);
                }
            } else {
                Log.e(XAppManager.TAG, "Event type not handled?" + msg);
            }
        }
    }

    /* loaded from: classes.dex */
    private static class XAppEventListenerToService extends IXAppEventListener.Stub {
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

        @Override // com.xiaopeng.xuimanager.xapp.IXAppEventListener
        public void onStartAppEvent(Bundle extras) {
            XAppManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleStartAppEvent(extras);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchStartAppEventToClient(Bundle extras) {
        Collection<XAppEventListener> listeners;
        synchronized (this) {
            listeners = this.mListeners;
        }
        if (!listeners.isEmpty()) {
            for (XAppEventListener l : listeners) {
                l.onStartAppEvent(extras);
            }
            return;
        }
        Log.e(TAG, "Listener is null, not dispatching event.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStartAppEvent(Bundle extras) {
        Message message = this.mHandler.obtainMessage();
        message.what = 1;
        message.obj = extras;
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
        Log.d(TAG, "onXUIDisconnected");
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIConnected(IBinder service) {
        Log.d(TAG, "onXUIConnected");
        this.mService = IXApp.Stub.asInterface(service);
        if (!this.mListeners.isEmpty()) {
            try {
                if (this.mListenerToService == null) {
                    this.mListenerToService = new XAppEventListenerToService(this);
                }
                this.mService.registerListener(this.mListenerToService);
            } catch (Exception ex) {
                Log.e(TAG, "Could not connect: " + ex.toString());
            }
        }
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

    public void checkIdentityValid(String userKey) throws XUIServiceNotConnectedException {
        Log.d(TAG, "checkIdentityValid");
        try {
            this.mService.checkIdentityValid(userKey);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not checkIdentityValid: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void startCustomService(String serviceCode, String userIdentity) throws XUIServiceNotConnectedException {
        Log.d(TAG, "startCustomService");
        try {
            this.mService.startCustomService(serviceCode, userIdentity);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not startCustomService: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public boolean checkOrderValid(String orderId) throws XUIServiceNotConnectedException {
        Log.d(TAG, "checkOrderValid");
        try {
            return this.mService.checkOrderValid(orderId);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not checkOrderValid: " + e.toString());
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

    public static void setSpeechUIEnabled(Context context, boolean enabled) throws Exception {
        Log.i(TAG, "setSpeechUIEnabled enabled: " + enabled + " , call in: " + context.getPackageName());
        Settings.System.putInt(context.getContentResolver(), "xp_speechui_enable", enabled ? 1 : 0);
    }

    public static List<xpAppInfo> getXpAppPackageList(int screenId) throws Exception {
        IPackageManager pm = AppGlobals.getPackageManager();
        if (pm != null) {
            return pm.getXpAppPackageList(screenId);
        }
        return null;
    }

    public static List<xpAppInfo> getXpAppPackageList() throws Exception {
        String callingApp = mContext.getPackageName();
        WindowManager windowManager = mWindowManager;
        int screenId = windowManager != null ? windowManager.getScreenId(callingApp) : 0;
        return getXpAppPackageList(screenId);
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
        if (context == null || intent == null) {
            Log.w(TAG, "context or intent is null");
            return;
        }
        try {
            if (isTopActivityFullscreen()) {
                intent.putExtra("needFullScreen", true);
            }
            context.startActivity(intent);
        } catch (Exception e) {
            Log.e(TAG, "startPanel failed :" + e.toString());
        }
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
