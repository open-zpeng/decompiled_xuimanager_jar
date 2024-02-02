package com.xiaopeng.xuimanager.themeoperation;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.ArraySet;
import android.util.Log;
import com.xiaopeng.xuimanager.XUIManagerBase;
import com.xiaopeng.xuimanager.themeoperation.IThemeOperation;
import com.xiaopeng.xuimanager.themeoperation.IThemeOperationListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class ThemeOperationManager implements AbsThemeOperation, XUIManagerBase {
    private static final int DATA_TYPE_EFFECT = 2;
    private static final int DATA_TYPE_THEME = 1;
    public static final String EFFECT_AMBIENT_LIGHT = "ambientlight";
    public static final String EFFECT_BOOT_ANIMATION = "bootani";
    public static final String EFFECT_BOOT_SOUND = "bootsound";
    public static final String EFFECT_LLU = "lightlang";
    public static final String EFFECT_SKIN = "skin";
    public static final String EFFECT_SOUND_THEME = "sndtheme";
    public static final String EVENT_EFFECT_FOCUS_CHANGE = "effect_focus_change";
    public static final String EVENT_THEME_AVAILABLE = "theme_available";
    public static final String EVENT_THEME_DELETED = "theme_deleted";
    public static final String EVENT_THEME_READY = "theme_ready";
    public static final String EVENT_THEME_SELECTED = "theme_selected";
    private static final int MSG_EVENT_NOTIFY = 1;
    public static final int RES_STORAGE_TYPE_OPERATION = 2;
    public static final int RES_STORAGE_TYPE_PRESET = 1;
    public static final String THEME_ID_DEFAULT = "default";
    public static final String THEME_NAME_DEFAULT = "default";
    private Handler mHandler;
    private final ArraySet<ThemeOperationListener> mListeners;
    private IThemeOperation mService;
    private boolean serverDisconnected;
    private ThemeOperationListenerImpl themeOperationListenerImpl;
    private static final String TAG = ThemeOperationManager.class.getSimpleName();
    private static String mServiceName = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ThemeOperationManagerHolder {
        private static final ThemeOperationManager instance = new ThemeOperationManager();

        private ThemeOperationManagerHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class EventMessage {
        int dataType;
        Object eventObj;
        String eventStr;
        String extraStr;

        public EventMessage(String event, String extra, Object obj, int type) {
            this.eventStr = event;
            this.extraStr = extra;
            this.eventObj = obj;
            this.dataType = type;
        }
    }

    /* loaded from: classes.dex */
    private static class ThemeOperationListenerImpl extends IThemeOperationListener.Stub {
        private Handler mHandler;

        public ThemeOperationListenerImpl(Handler handler) {
            this.mHandler = handler;
        }

        @Override // com.xiaopeng.xuimanager.themeoperation.IThemeOperationListener
        public void onThemeStatus(String event, String extra, List<ThemeOperationData> themeArray) throws RemoteException {
            this.mHandler.obtainMessage(1, new EventMessage(event, extra, themeArray, 1)).sendToTarget();
        }

        @Override // com.xiaopeng.xuimanager.themeoperation.IThemeOperationListener
        public void onEffectStatus(String event, String extra, List<AbilityEffect> effectArray) throws RemoteException {
            this.mHandler.obtainMessage(1, new EventMessage(event, extra, effectArray, 2)).sendToTarget();
        }
    }

    private ThemeOperationManager() {
        this.serverDisconnected = false;
        this.mService = null;
        this.mListeners = new ArraySet<>();
        this.themeOperationListenerImpl = null;
    }

    public static ThemeOperationManager getInstance() {
        return ThemeOperationManagerHolder.instance;
    }

    @Override // com.xiaopeng.xuimanager.themeoperation.AbsThemeOperation
    public ThemeOperationData[] getThemes() {
        Log.i(TAG, "getThemes");
        try {
            ThemeOperationData[] result = this.mService.getThemes();
            return result;
        } catch (Exception e) {
            String str = TAG;
            Log.w(str, "getThemes e=" + e);
            return null;
        }
    }

    @Override // com.xiaopeng.xuimanager.themeoperation.AbsThemeOperation
    public ThemeOperationData getCurrentTheme() {
        ThemeOperationData data = null;
        try {
            data = this.mService.getCurrentTheme();
        } catch (Exception e) {
            String str = TAG;
            Log.w(str, "getCurrentTheme e=" + e);
        }
        String str2 = TAG;
        Log.i(str2, "getCurrentTheme=" + data);
        return data;
    }

    @Override // com.xiaopeng.xuimanager.themeoperation.AbsThemeOperation
    public boolean selectTheme(ThemeOperationData themeData) {
        Log.i(TAG, "selectTheme");
        try {
            boolean ret = this.mService.selectTheme(themeData);
            return ret;
        } catch (Exception e) {
            String str = TAG;
            Log.w(str, "selectTheme e=" + e);
            return false;
        }
    }

    @Override // com.xiaopeng.xuimanager.themeoperation.AbsThemeOperation
    public boolean resetTheme(ThemeOperationData themeData) {
        Log.i(TAG, "resetTheme");
        try {
            boolean ret = this.mService.resetTheme(themeData);
            return ret;
        } catch (Exception e) {
            String str = TAG;
            Log.w(str, "resetTheme e=" + e);
            return false;
        }
    }

    @Override // com.xiaopeng.xuimanager.themeoperation.AbsThemeOperation
    public boolean updateTheme(ThemeOperationData themeData) {
        Log.i(TAG, "updateTheme");
        try {
            boolean ret = this.mService.updateTheme(themeData);
            return ret;
        } catch (Exception e) {
            String str = TAG;
            Log.w(str, "updateTheme e=" + e);
            return false;
        }
    }

    @Override // com.xiaopeng.xuimanager.themeoperation.AbsThemeOperation
    public boolean deleteTheme(ThemeOperationData themeData) {
        Log.i(TAG, "deleteTheme");
        try {
            boolean ret = this.mService.deleteTheme(themeData);
            return ret;
        } catch (Exception e) {
            String str = TAG;
            Log.w(str, "deleteTheme e=" + e);
            return false;
        }
    }

    @Override // com.xiaopeng.xuimanager.themeoperation.AbsThemeOperation
    public boolean selectEffect(AbilityEffect effect) {
        Log.i(TAG, "selectEffect");
        try {
            boolean ret = this.mService.selectEffect(effect);
            return ret;
        } catch (Exception e) {
            String str = TAG;
            Log.w(str, "selectEffect e=" + e);
            return false;
        }
    }

    @Override // com.xiaopeng.xuimanager.themeoperation.AbsThemeOperation
    public synchronized void registerListener(ThemeOperationListener listener) {
        String str = TAG;
        Log.i(str, "registerListener:" + listener);
        if (listener == null) {
            Log.w(TAG, "registerListener null!");
            return;
        }
        if (this.themeOperationListenerImpl == null) {
            this.themeOperationListenerImpl = new ThemeOperationListenerImpl(this.mHandler);
            try {
                this.mService.registerListener(this.themeOperationListenerImpl);
            } catch (Exception e) {
                String str2 = TAG;
                Log.w(str2, "registerListener e=" + e);
            }
        }
        synchronized (this.mListeners) {
            this.mListeners.add(listener);
        }
    }

    @Override // com.xiaopeng.xuimanager.themeoperation.AbsThemeOperation
    public synchronized void unRegisterListener(ThemeOperationListener listener) {
        String str = TAG;
        Log.i(str, "unRegisterListener:" + listener);
        synchronized (this.mListeners) {
            this.mListeners.remove(listener);
        }
        if (this.mListeners.isEmpty()) {
            try {
                this.mService.unRegisterListener(this.themeOperationListenerImpl);
            } catch (RemoteException e) {
                String str2 = TAG;
                Log.e(str2, "unregisterListener e=" + e);
            }
            this.themeOperationListenerImpl = null;
        }
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void init(IBinder service, Context context, Handler handler) {
        String str = TAG;
        Log.d(str, "create UserScenarioManager,context=" + context + ",handler=" + handler);
        this.mService = IThemeOperation.Stub.asInterface(service);
        this.mHandler = new Handler(handler.getLooper()) { // from class: com.xiaopeng.xuimanager.themeoperation.ThemeOperationManager.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                String str2 = ThemeOperationManager.TAG;
                Log.d(str2, "handle msg:" + msg.what);
                if (msg.what == 1) {
                    ThemeOperationManager.this.handleEventMessage(msg);
                }
            }
        };
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIDisconnected() {
        Log.d(TAG, "onXUIDisconnected");
        synchronized (this.mListeners) {
            this.mListeners.clear();
        }
        if (this.themeOperationListenerImpl != null) {
            try {
                this.mService.unRegisterListener(this.themeOperationListenerImpl);
            } catch (RemoteException e) {
                String str = TAG;
                Log.e(str, "onXUIDisconnected,unregisterListener e=" + e);
            }
            this.themeOperationListenerImpl = null;
        }
        this.mHandler = null;
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIConnected(IBinder service) {
        if (!this.serverDisconnected) {
            return;
        }
        this.serverDisconnected = false;
        this.mService = IThemeOperation.Stub.asInterface(service);
        if (this.themeOperationListenerImpl != null) {
            try {
                this.mService.registerListener(this.themeOperationListenerImpl);
            } catch (Exception e) {
                String str = TAG;
                Log.e(str, "onXUIConnected e=" + e);
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

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onServerDisconnected() {
        Log.d(TAG, "onServerDisconnected");
        this.serverDisconnected = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleEventMessage(Message msg) {
        EventMessage event = (EventMessage) msg.obj;
        String str = TAG;
        Log.d(str, "handle event,event=" + event.eventStr + ",extra=" + event.extraStr + ",obj=" + event.eventObj);
        new ArrayList();
        if (1 == event.dataType) {
            synchronized (this.mListeners) {
                Iterator<ThemeOperationListener> it = this.mListeners.iterator();
                while (it.hasNext()) {
                    ThemeOperationListener l = it.next();
                    l.onThemeStatus(event.eventStr, event.extraStr, (List) event.eventObj);
                }
            }
        } else if (2 == event.dataType) {
            synchronized (this.mListeners) {
                Iterator<ThemeOperationListener> it2 = this.mListeners.iterator();
                while (it2.hasNext()) {
                    ThemeOperationListener l2 = it2.next();
                    l2.onEffectStatus(event.eventStr, event.extraStr, (List) event.eventObj);
                }
            }
        } else {
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("handleEventMessage, unknown object:");
            sb.append(event.eventObj != null ? event.eventObj.getClass().getSimpleName() : null);
            Log.w(str2, sb.toString());
        }
    }
}
