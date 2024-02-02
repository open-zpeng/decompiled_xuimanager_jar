package com.xiaopeng.xuimanager;

import android.annotation.SystemApi;
import android.app.ActivityThread;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.util.Log;
import com.android.internal.annotations.GuardedBy;
import com.xiaopeng.xuimanager.IXUIService;
import com.xiaopeng.xuimanager.ambient.AmbientManager;
import com.xiaopeng.xuimanager.ambientlight.AmbientLightManager;
import com.xiaopeng.xuimanager.awareness.AwarenessManager;
import com.xiaopeng.xuimanager.condition.ConditionManager;
import com.xiaopeng.xuimanager.contextinfo.ContextInfoManager;
import com.xiaopeng.xuimanager.download.XPDownloadManager;
import com.xiaopeng.xuimanager.iot.IoTManager;
import com.xiaopeng.xuimanager.karaoke.KaraokeManager;
import com.xiaopeng.xuimanager.lightlanuage.LightLanuageManager;
import com.xiaopeng.xuimanager.mediacenter.MediaCenterManager;
import com.xiaopeng.xuimanager.message.MessageManager;
import com.xiaopeng.xuimanager.musicrecognize.MusicRecognizeManager;
import com.xiaopeng.xuimanager.operation.OperationManager;
import com.xiaopeng.xuimanager.seatmassager.SeatMassagerManager;
import com.xiaopeng.xuimanager.smart.SmartManager;
import com.xiaopeng.xuimanager.soundresource.SoundResourceManager;
import com.xiaopeng.xuimanager.store.StoreResourceProvider;
import com.xiaopeng.xuimanager.sysconfig.SysConfigManagerImpl;
import com.xiaopeng.xuimanager.themeoperation.ThemeOperationManager;
import com.xiaopeng.xuimanager.userscenario.UserScenarioManager;
import com.xiaopeng.xuimanager.xapp.XAppManager;
import java.util.HashMap;
/* loaded from: classes.dex */
public class XUIManager {
    @SystemApi
    public static final String AMBIENTLIGHT_SERVICE = "ambientlight";
    @SystemApi
    public static final String AMBIENT_SERVICE = "ambient";
    @SystemApi
    public static final String AWARENESS_SERVICE = "awareness";
    @SystemApi
    public static final String CONDITION_SERVICE = "condition";
    @SystemApi
    public static final String CONTEXTINFO_SERVICE = "contextinfo";
    @SystemApi
    public static final String IOT_MANAGER = "iotmanager";
    @SystemApi
    public static final String KARAOKE_SERVICE = "karaoke";
    @SystemApi
    public static final String LIGHTLANUAGE_SERVICE = "lightlanuage";
    @SystemApi
    public static final String MEDIACENTER_SERVICE = "mediacenter";
    @SystemApi
    public static final String MESSAGE_SERVICE = "message";
    @SystemApi
    public static final String MUSICRECOGNIZE_SERVICE = "musicrecognize";
    @SystemApi
    public static final String OPERATION_SERVICE = "operation";
    public static final String PERMISSION_AMBIENTLIGHT = "com.xiaopeng.xuimanager.permission.XUI_AMBIENTLIGHT";
    public static final String PERMISSION_AWARENESS = "com.xiaopeng.xuimanager.permission.XUI_AWARENESS";
    public static final String PERMISSION_CONTEXTINFO = "com.xiaopeng.xuimanager.permission.XUI_CONTEXTINFO";
    public static final String PERMISSION_KARAOKE = "com.xiaopeng.xuimanager.permission.XUI_KARAOKE";
    public static final String PERMISSION_LANGLIGHT = "com.xiaopeng.xuimanager.permission.XUI_LANGLIGHT";
    public static final String PERMISSION_LIGHTLANUAGE = "com.xiaopeng.xuimanager.permission.XUI_LIGHTLANUAGE";
    public static final String PERMISSION_MEDIACENTER = "com.xiaopeng.xuimanager.permission.XUI_MEDIACENTER";
    public static final String PERMISSION_MUSICRECOGNIZE = "com.xiaopeng.xuimanager.permission.XUI_MUSICRECOGNIZE";
    public static final String PERMISSION_OPERATION = "com.xiaopeng.xuimanager.permission.XUI_OPERATION";
    public static final String PERMISSION_SEATMASSAGER = "com.xiaopeng.xuimanager.permission.XUI_SEATMASSAGER";
    public static final String PERMISSION_SMART = "com.xiaopeng.xuimanager.permission.XUI_SMART";
    public static final String PERMISSION_XAPP = "com.xiaopeng.xuimanager.permission.XUI_XAPP";
    @SystemApi
    public static final String RESOURCE_PROVIDER = "resource_provider";
    @SystemApi
    public static final String SEATMASSAGER_SERVICE = "seatmassager";
    @SystemApi
    public static final String SMART_SERVICE = "smart";
    @SystemApi
    public static final String SOUND_RESOURCE_SERVICE = "sndresource";
    private static final int STATE_CONNECTED = 2;
    private static final int STATE_CONNECTING = 1;
    private static final int STATE_DISCONNECTED = 0;
    @SystemApi
    public static final String SYS_CONFIG = "sysconfig";
    @SystemApi
    public static final String THEME_OPERATION_SERVICE = "themeoperation";
    @SystemApi
    public static final String USER_SCENARIO_SERVICE = "userscenario";
    private static final String VERSION = "1.0.0";
    @SystemApi
    public static final String XAPP_SERVICE = "xapp";
    @SystemApi
    public static final String XPDOWNLOAD_SERVICE = "xpdownload";
    @SystemApi
    public static final String XUI_MANAGER_SERVICE = "XuiServiceManager";
    private static final long XUI_SERVICE_BIND_MAX_RETRY = 20;
    private static final long XUI_SERVICE_BIND_RETRY_INTERVAL_MS = 500;
    private static final String XUI_SERVICE_CLASS = "com.xiaopeng.xuiservice.XUIService";
    public static final String XUI_SERVICE_INTERFACE_NAME = "com.xiaopeng.xuimanager.IXUIService";
    public static final String XUI_SERVICE_NOT_CONNECTED_EXCEPTION_MSG = "XUIServiceNotConnected";
    private static final String XUI_SERVICE_PACKAGE = "com.xiaopeng.xuiservice";
    private static HandlerThread handlerThread;
    private static IBinder mObserverBinder = null;
    @GuardedBy("this")
    private int mConnectionRetryCount;
    private final Runnable mConnectionRetryFailedRunnable;
    private final Runnable mConnectionRetryRunnable;
    @GuardedBy("this")
    private int mConnectionState;
    private final Context mContext;
    private final Handler mEventHandler;
    private final Handler mMainThreadEventHandler;
    @GuardedBy("this")
    private IXUIService mService;
    private final ServiceConnection mServiceConnectionListener;
    private final ServiceConnection mServiceConnectionListenerClient;
    @GuardedBy("mXUIManagerLock")
    private final HashMap<String, XUIManagerBase> mServiceMap;
    private final Object mXUIManagerLock;

    /* loaded from: classes.dex */
    private static class XUIManagerHolder {
        private static final XUIManager instance = new XUIManager();

        private XUIManagerHolder() {
        }
    }

    private XUIManager() {
        this.mXUIManagerLock = new Object();
        this.mServiceMap = new HashMap<>();
        this.mServiceConnectionListener = new ServiceConnection() { // from class: com.xiaopeng.xuimanager.XUIManager.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.i(XUILog.TAG_XUIMANAGER, "##onServiceConnected,client listener=" + XUIManager.this.mServiceConnectionListenerClient);
                synchronized (XUIManager.this) {
                    XUIManager.this.mService = IXUIService.Stub.asInterface(service);
                    XUIManager.this.mConnectionState = 2;
                }
                XUIManager.this.bringUpXUIManagers();
                if (XUIManager.this.mServiceConnectionListenerClient != null) {
                    XUIManager.this.mServiceConnectionListenerClient.onServiceConnected(name, service);
                }
                if (XUIManager.mObserverBinder != null) {
                    try {
                        XUIManager.this.mService.registerObserver(XUIManager.mObserverBinder);
                    } catch (Exception e) {
                        Log.w(XUILog.TAG_XUIMANAGER, "registerObserver e=" + e);
                    }
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
                Log.i(XUILog.TAG_XUIMANAGER, "##onServiceDisconnected,client listener=" + XUIManager.this.mServiceConnectionListenerClient);
                synchronized (XUIManager.this) {
                    XUIManager.this.mService = null;
                    if (XUIManager.this.mConnectionState == 0) {
                        return;
                    }
                    XUIManager.this.mConnectionState = 0;
                    XUIManager.this.notifyServerDisconnectForXUIManagers();
                    if (XUIManager.this.mServiceConnectionListenerClient != null) {
                        XUIManager.this.mServiceConnectionListenerClient.onServiceDisconnected(name);
                    }
                }
            }
        };
        this.mConnectionRetryFailedRunnable = new Runnable() { // from class: com.xiaopeng.xuimanager.XUIManager.2
            @Override // java.lang.Runnable
            public void run() {
                XUIManager.this.mServiceConnectionListener.onServiceDisconnected(new ComponentName(XUIManager.XUI_SERVICE_PACKAGE, XUIManager.XUI_SERVICE_CLASS));
            }
        };
        this.mConnectionRetryRunnable = new Runnable() { // from class: com.xiaopeng.xuimanager.XUIManager.3
            @Override // java.lang.Runnable
            public void run() {
                XUIManager.this.startXUIService();
            }
        };
        this.mContext = ActivityThread.currentApplication();
        Log.i(XUILog.TAG_XUIMANAGER, "get application context=" + this.mContext);
        this.mServiceConnectionListenerClient = null;
        this.mEventHandler = determineEventHandler(null);
        this.mMainThreadEventHandler = determineMainThreadEventHandler(this.mEventHandler);
        this.mMainThreadEventHandler.post(new Runnable() { // from class: com.xiaopeng.xuimanager.-$$Lambda$XUIManager$l0fKIG_RuwR0S7d5i8db985cD-c
            @Override // java.lang.Runnable
            public final void run() {
                XUIManager.this.connect();
            }
        });
    }

    public static synchronized XUIManager getInstance() {
        XUIManager xUIManager;
        synchronized (XUIManager.class) {
            xUIManager = XUIManagerHolder.instance;
        }
        return xUIManager;
    }

    public Object getService(String serviceName) {
        try {
            Object service = getXUIServiceManager(serviceName);
            return service;
        } catch (XUIServiceNotConnectedException e) {
            Log.w(XUILog.TAG_XUIMANAGER, "getService e=" + e);
            return null;
        }
    }

    public static String getXuiVersion() {
        return VERSION;
    }

    private XUIManager(Context context, ServiceConnection serviceConnectionListener, Handler handler) {
        this.mXUIManagerLock = new Object();
        this.mServiceMap = new HashMap<>();
        this.mServiceConnectionListener = new ServiceConnection() { // from class: com.xiaopeng.xuimanager.XUIManager.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.i(XUILog.TAG_XUIMANAGER, "##onServiceConnected,client listener=" + XUIManager.this.mServiceConnectionListenerClient);
                synchronized (XUIManager.this) {
                    XUIManager.this.mService = IXUIService.Stub.asInterface(service);
                    XUIManager.this.mConnectionState = 2;
                }
                XUIManager.this.bringUpXUIManagers();
                if (XUIManager.this.mServiceConnectionListenerClient != null) {
                    XUIManager.this.mServiceConnectionListenerClient.onServiceConnected(name, service);
                }
                if (XUIManager.mObserverBinder != null) {
                    try {
                        XUIManager.this.mService.registerObserver(XUIManager.mObserverBinder);
                    } catch (Exception e) {
                        Log.w(XUILog.TAG_XUIMANAGER, "registerObserver e=" + e);
                    }
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
                Log.i(XUILog.TAG_XUIMANAGER, "##onServiceDisconnected,client listener=" + XUIManager.this.mServiceConnectionListenerClient);
                synchronized (XUIManager.this) {
                    XUIManager.this.mService = null;
                    if (XUIManager.this.mConnectionState == 0) {
                        return;
                    }
                    XUIManager.this.mConnectionState = 0;
                    XUIManager.this.notifyServerDisconnectForXUIManagers();
                    if (XUIManager.this.mServiceConnectionListenerClient != null) {
                        XUIManager.this.mServiceConnectionListenerClient.onServiceDisconnected(name);
                    }
                }
            }
        };
        this.mConnectionRetryFailedRunnable = new Runnable() { // from class: com.xiaopeng.xuimanager.XUIManager.2
            @Override // java.lang.Runnable
            public void run() {
                XUIManager.this.mServiceConnectionListener.onServiceDisconnected(new ComponentName(XUIManager.XUI_SERVICE_PACKAGE, XUIManager.XUI_SERVICE_CLASS));
            }
        };
        this.mConnectionRetryRunnable = new Runnable() { // from class: com.xiaopeng.xuimanager.XUIManager.3
            @Override // java.lang.Runnable
            public void run() {
                XUIManager.this.startXUIService();
            }
        };
        this.mContext = context;
        this.mServiceConnectionListenerClient = serviceConnectionListener;
        this.mEventHandler = determineEventHandler(handler);
        this.mMainThreadEventHandler = determineMainThreadEventHandler(this.mEventHandler);
    }

    public XUIManager(Context context, IXUIService service, Handler handler) {
        this.mXUIManagerLock = new Object();
        this.mServiceMap = new HashMap<>();
        this.mServiceConnectionListener = new ServiceConnection() { // from class: com.xiaopeng.xuimanager.XUIManager.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service2) {
                Log.i(XUILog.TAG_XUIMANAGER, "##onServiceConnected,client listener=" + XUIManager.this.mServiceConnectionListenerClient);
                synchronized (XUIManager.this) {
                    XUIManager.this.mService = IXUIService.Stub.asInterface(service2);
                    XUIManager.this.mConnectionState = 2;
                }
                XUIManager.this.bringUpXUIManagers();
                if (XUIManager.this.mServiceConnectionListenerClient != null) {
                    XUIManager.this.mServiceConnectionListenerClient.onServiceConnected(name, service2);
                }
                if (XUIManager.mObserverBinder != null) {
                    try {
                        XUIManager.this.mService.registerObserver(XUIManager.mObserverBinder);
                    } catch (Exception e) {
                        Log.w(XUILog.TAG_XUIMANAGER, "registerObserver e=" + e);
                    }
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
                Log.i(XUILog.TAG_XUIMANAGER, "##onServiceDisconnected,client listener=" + XUIManager.this.mServiceConnectionListenerClient);
                synchronized (XUIManager.this) {
                    XUIManager.this.mService = null;
                    if (XUIManager.this.mConnectionState == 0) {
                        return;
                    }
                    XUIManager.this.mConnectionState = 0;
                    XUIManager.this.notifyServerDisconnectForXUIManagers();
                    if (XUIManager.this.mServiceConnectionListenerClient != null) {
                        XUIManager.this.mServiceConnectionListenerClient.onServiceDisconnected(name);
                    }
                }
            }
        };
        this.mConnectionRetryFailedRunnable = new Runnable() { // from class: com.xiaopeng.xuimanager.XUIManager.2
            @Override // java.lang.Runnable
            public void run() {
                XUIManager.this.mServiceConnectionListener.onServiceDisconnected(new ComponentName(XUIManager.XUI_SERVICE_PACKAGE, XUIManager.XUI_SERVICE_CLASS));
            }
        };
        this.mConnectionRetryRunnable = new Runnable() { // from class: com.xiaopeng.xuimanager.XUIManager.3
            @Override // java.lang.Runnable
            public void run() {
                XUIManager.this.startXUIService();
            }
        };
        this.mContext = context;
        this.mEventHandler = determineEventHandler(handler);
        this.mMainThreadEventHandler = determineMainThreadEventHandler(this.mEventHandler);
        this.mService = service;
        this.mConnectionState = 2;
        this.mServiceConnectionListenerClient = null;
    }

    public static XUIManager createXUIManager(Context context, ServiceConnection serviceConnectionListener, Handler handler) {
        if (!context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
            Log.e(XUILog.TAG_XUIMANAGER, "FEATURE_AUTOMOTIVE not declared while android.car is used");
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("createXUIManager,version=1.0.0,connection listener=");
            sb.append(serviceConnectionListener);
            sb.append(",handler=");
            sb.append(handler == null ? "null" : handler.getLooper() == Looper.getMainLooper() ? "main" : handler);
            Log.i(XUILog.TAG_XUIMANAGER, sb.toString());
            return new XUIManager(context, serviceConnectionListener, handler);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public static XUIManager createXUIManager(Context context, ServiceConnection serviceConnectionListener) {
        return createXUIManager(context, serviceConnectionListener, null);
    }

    private static Handler determineMainThreadEventHandler(Handler eventHandler) {
        Looper mainLooper = Looper.getMainLooper();
        return eventHandler.getLooper() == mainLooper ? eventHandler : new Handler(mainLooper);
    }

    private static Handler determineEventHandler(Handler handler) {
        if (handler == null) {
            Looper looper = Looper.getMainLooper();
            return new Handler(looper);
        }
        return handler;
    }

    public static void checkXUIServiceNotConnectedExceptionFromXUIService(IllegalStateException e) throws XUIServiceNotConnectedException, IllegalStateException {
        String message = e.getMessage();
        if (message.equals(XUI_SERVICE_NOT_CONNECTED_EXCEPTION_MSG)) {
            throw new XUIServiceNotConnectedException();
        }
        throw e;
    }

    public void connect() throws IllegalStateException {
        synchronized (this) {
            if (this.mConnectionState != 0) {
                throw new IllegalStateException("already connected or connecting");
            }
            this.mConnectionState = 1;
            startXUIService();
        }
    }

    public void disconnect() {
        synchronized (this) {
            if (this.mConnectionState == 0) {
                return;
            }
            this.mEventHandler.removeCallbacks(this.mConnectionRetryRunnable);
            this.mMainThreadEventHandler.removeCallbacks(this.mConnectionRetryFailedRunnable);
            this.mConnectionRetryCount = 0;
            tearDownXUIManagers();
            this.mService = null;
            this.mConnectionState = 0;
            this.mContext.unbindService(this.mServiceConnectionListener);
        }
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this) {
            z = this.mService != null;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this) {
            z = true;
            if (this.mConnectionState != 1) {
                z = false;
            }
        }
        return z;
    }

    public Object getXUIServiceManager(String serviceName) throws XUIServiceNotConnectedException {
        if (((serviceName.hashCode() == -1080235041 && serviceName.equals(IOT_MANAGER)) ? (char) 0 : (char) 65535) == 0) {
            synchronized (this.mXUIManagerLock) {
                XUIManagerBase manager = this.mServiceMap.get(serviceName);
                if (manager == null) {
                    manager = createXUIServiceManager(serviceName, null);
                    if (manager == null) {
                        return null;
                    }
                    manager.setServiceName(serviceName);
                    this.mServiceMap.put(serviceName, manager);
                }
                return manager;
            }
        }
        IXUIService service = getIXUIServiceOrThrow();
        synchronized (this.mXUIManagerLock) {
            XUIManagerBase manager2 = this.mServiceMap.get(serviceName);
            if (manager2 == null) {
                try {
                    IBinder binder = service.getXUIService(serviceName);
                    if (binder == null) {
                        Log.w(XUILog.TAG_XUIMANAGER, "getXUIServiceManager could not get binder for service:" + serviceName);
                        if (serviceName.equals(RESOURCE_PROVIDER)) {
                            manager2 = new StoreResourceProvider(this.mContext);
                            Log.i(XUILog.TAG_XUIMANAGER, "getXUIServiceManager get StoreResourceProvider");
                        }
                    } else {
                        manager2 = createXUIServiceManager(serviceName, binder);
                    }
                    if (manager2 == null) {
                        Log.w(XUILog.TAG_XUIMANAGER, "getCarManager could not create manager for service:" + serviceName);
                        return null;
                    }
                    manager2.setServiceName(serviceName);
                    Log.d("##xuimanager", "setname=" + serviceName);
                    this.mServiceMap.put(serviceName, manager2);
                } catch (RemoteException e) {
                    handleRemoteException(e);
                }
            }
            return manager2;
        }
    }

    public synchronized void registerObserver() {
        if (this.mService == null) {
            IBinder binder = ServiceManager.getService(XUI_MANAGER_SERVICE);
            this.mService = IXUIService.Stub.asInterface(binder);
        }
        IBinder binder2 = mObserverBinder;
        if (binder2 == null) {
            mObserverBinder = new Binder();
        }
        try {
            this.mService.registerObserver(mObserverBinder);
        } catch (Exception e) {
            Log.w(XUILog.TAG_XUIMANAGER, "registerObserver e=" + e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private XUIManagerBase createXUIServiceManager(String serviceName, IBinder binder) throws XUIServiceNotConnectedException {
        char c;
        switch (serviceName.hashCode()) {
            case -1608162213:
                if (serviceName.equals(USER_SCENARIO_SERVICE)) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case -1330509705:
                if (serviceName.equals(SOUND_RESOURCE_SERVICE)) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case -1250402432:
                if (serviceName.equals(XPDOWNLOAD_SERVICE)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1080235041:
                if (serviceName.equals(IOT_MANAGER)) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case -936045084:
                if (serviceName.equals(KARAOKE_SERVICE)) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case -892145000:
                if (serviceName.equals(AMBIENT_SERVICE)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -861311717:
                if (serviceName.equals(CONDITION_SERVICE)) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case -452142163:
                if (serviceName.equals(LIGHTLANUAGE_SERVICE)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -102225187:
                if (serviceName.equals(CONTEXTINFO_SERVICE)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 3671721:
                if (serviceName.equals(XAPP_SERVICE)) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 45747532:
                if (serviceName.equals(SEATMASSAGER_SERVICE)) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 106938681:
                if (serviceName.equals(MEDIACENTER_SERVICE)) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 109549001:
                if (serviceName.equals(SMART_SERVICE)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 649601406:
                if (serviceName.equals("ambientlight")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 651703375:
                if (serviceName.equals(SYS_CONFIG)) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 954925063:
                if (serviceName.equals(MESSAGE_SERVICE)) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 1260496309:
                if (serviceName.equals(AWARENESS_SERVICE)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1662702951:
                if (serviceName.equals(OPERATION_SERVICE)) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 1727280137:
                if (serviceName.equals(MUSICRECOGNIZE_SERVICE)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 1883558334:
                if (serviceName.equals(THEME_OPERATION_SERVICE)) {
                    c = 15;
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
                XUIManagerBase manager = new XPDownloadManager(binder, this.mContext, this.mEventHandler);
                return manager;
            case 1:
                XUIManagerBase manager2 = new ContextInfoManager(binder, this.mContext, this.mEventHandler);
                return manager2;
            case 2:
                XUIManagerBase manager3 = new AwarenessManager(binder, this.mContext, this.mEventHandler);
                return manager3;
            case 3:
                XUIManagerBase manager4 = new SmartManager(binder, this.mContext, this.mEventHandler);
                return manager4;
            case 4:
                XUIManagerBase manager5 = new AmbientLightManager(binder, this.mContext, this.mEventHandler);
                return manager5;
            case 5:
                XUIManagerBase manager6 = new AmbientManager(binder, this.mContext, this.mEventHandler);
                return manager6;
            case 6:
                XUIManagerBase manager7 = new LightLanuageManager(binder, this.mContext, this.mEventHandler);
                return manager7;
            case 7:
                XUIManagerBase manager8 = new SeatMassagerManager(binder, this.mContext, this.mEventHandler);
                return manager8;
            case '\b':
                XUIManagerBase manager9 = new MediaCenterManager(binder, this.mContext, this.mEventHandler);
                return manager9;
            case '\t':
                XUIManagerBase manager10 = new MusicRecognizeManager(binder, this.mContext, this.mEventHandler);
                return manager10;
            case '\n':
                XUIManagerBase manager11 = new XAppManager(binder, this.mContext, this.mEventHandler);
                return manager11;
            case 11:
                XUIManagerBase manager12 = new OperationManager(binder, this.mContext, this.mEventHandler);
                return manager12;
            case '\f':
                XUIManagerBase manager13 = new KaraokeManager(binder, this.mContext, this.mEventHandler);
                return manager13;
            case '\r':
                XUIManagerBase manager14 = IoTManager.getInstance();
                ((IoTManager) manager14).init(this.mContext);
                return manager14;
            case 14:
                XUIManagerBase manager15 = new UserScenarioManager(binder, this.mContext, this.mEventHandler);
                return manager15;
            case 15:
                XUIManagerBase manager16 = ThemeOperationManager.getInstance();
                manager16.init(binder, this.mContext, this.mEventHandler);
                return manager16;
            case 16:
                XUIManagerBase manager17 = SoundResourceManager.getInstance();
                manager17.init(binder, this.mContext, this.mEventHandler);
                return manager17;
            case 17:
                XUIManagerBase manager18 = ConditionManager.getInstance();
                manager18.init(binder, this.mContext, this.mEventHandler);
                return manager18;
            case 18:
                XUIManagerBase manager19 = MessageManager.getInstance();
                manager19.init(binder, this.mContext, this.mEventHandler);
                return manager19;
            case 19:
                XUIManagerBase manager20 = SysConfigManagerImpl.getInstance();
                manager20.init(binder, this.mContext, this.mEventHandler);
                return manager20;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startXUIService() {
        Intent intent = new Intent();
        intent.setPackage(XUI_SERVICE_PACKAGE);
        intent.setAction(XUI_SERVICE_INTERFACE_NAME);
        boolean bound = this.mContext.bindServiceAsUser(intent, this.mServiceConnectionListener, 1, UserHandle.CURRENT_OR_SELF);
        if (!bound) {
            this.mConnectionRetryCount++;
            if (this.mConnectionRetryCount > XUI_SERVICE_BIND_MAX_RETRY) {
                Log.w(XUILog.TAG_XUIMANAGER, "cannot bind to XUIService after max retry");
                this.mMainThreadEventHandler.post(this.mConnectionRetryFailedRunnable);
                return;
            }
            this.mEventHandler.postDelayed(this.mConnectionRetryRunnable, XUI_SERVICE_BIND_RETRY_INTERVAL_MS);
            return;
        }
        this.mConnectionRetryCount = 0;
    }

    private synchronized IXUIService getIXUIServiceOrThrow() throws IllegalStateException {
        if (this.mService == null) {
            IBinder binder = ServiceManager.getService(XUI_MANAGER_SERVICE);
            this.mService = IXUIService.Stub.asInterface(binder);
            if (this.mService == null) {
                throw new IllegalStateException("not connected");
            }
        }
        return this.mService;
    }

    private void handleRemoteException(RemoteException e) {
        Log.w(XUILog.TAG_XUIMANAGER, "RemoteException", e);
        disconnect();
    }

    private void tearDownXUIManagers() {
        synchronized (this.mXUIManagerLock) {
            for (XUIManagerBase manager : this.mServiceMap.values()) {
                manager.onXUIDisconnected();
            }
            this.mServiceMap.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyServerDisconnectForXUIManagers() {
        synchronized (this.mXUIManagerLock) {
            for (XUIManagerBase manager : this.mServiceMap.values()) {
                manager.onServerDisconnected();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bringUpXUIManagers() {
        synchronized (this.mXUIManagerLock) {
            for (XUIManagerBase manager : this.mServiceMap.values()) {
                try {
                    IBinder binder = this.mService.getXUIService(manager.getServiceName());
                    manager.onXUIConnected(binder);
                } catch (RemoteException e) {
                    Log.w(XUILog.TAG_XUIMANAGER, "bringUpXUIManagers,e=" + e);
                }
            }
        }
    }
}
