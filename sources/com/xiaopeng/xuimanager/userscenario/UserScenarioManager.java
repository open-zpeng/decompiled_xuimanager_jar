package com.xiaopeng.xuimanager.userscenario;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.ArraySet;
import android.util.Log;
import com.xiaopeng.xuimanager.XUIManagerBase;
import com.xiaopeng.xuimanager.userscenario.IUserScenario;
import com.xiaopeng.xuimanager.userscenario.IUserScenarioListener;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class UserScenarioManager implements XUIManagerBase {
    public static final String ACTION_KEY_EXIT_REASON = "exitReason";
    public static final String ACTION_KEY_EXTRA_INFO = "extraInfo";
    public static final String ACTION_KEY_FRIEND_SCENARIO = "friendScenario";
    public static final String ACTION_KEY_NAME = "scenario_name";
    public static final String ACTION_KEY_PACKAGE = "package";
    public static final String ACTION_KEY_SOURCE = "source";
    public static final String ACTION_KEY_STATUS = "status";
    public static final String ACTION_USERSCENARIO = "com.xiaopeng.xui.userscenario";
    public static final String ACTION_VALUE_ENTER = "enter";
    public static final String ACTION_VALUE_EXIT = "exit";
    private static final boolean DBG = true;
    private static final int MSG_EVENT_NOTIFY = 1;
    public static final String PARAM_KEY_SCREEN_USE = "pScreenUse";
    public static final String REASON_APP_REQUEST = "rAppRequest";
    public static final String REASON_BATTERY_LOW = "rBatteryLow";
    public static final String REASON_DOOR_OPEN = "rDoorOpen";
    public static final String REASON_GEAR_NOT_P = "rGearNotP";
    public static final String REASON_IG_OFF = "rIgOff";
    public static final String REASON_IN_DC_CHARGE = "rInDcCharge";
    public static final String REASON_SCENARIO_SWITCH = "rScenarioSwitch";
    public static final String REASON_SCREEN_ON = "rScreenOn";
    public static final String REASON_VOICE_ACTIVE = "rVoiceActive";
    public static final String RET_DIALOG_CONFIRM = "dialogConfirm";
    public static final String RET_FAIL_DOOR_OPEN = "doorOpen";
    public static final String RET_FAIL_GEAR_NOT_P = "gearNotP";
    public static final String RET_FAIL_PANEL_INVALID = "panelInvalid#";
    public static final String RET_REMOTE_EXCEPTION = "remoteException";
    public static final String RET_SCENARIO_CONFLICT = "conflict#";
    public static final String RET_SCENARIO_CONFLICT_5D_CINEMA = "conflict#5d_cinema_mode";
    public static final String RET_SCENARIO_CONFLICT_CLEANING = "conflict#cleaning_mode";
    public static final String RET_SCENARIO_CONFLICT_COSMETIC_SPACE = "conflict#cosmetic_space_mode";
    public static final String RET_SCENARIO_CONFLICT_MEDITATION = "conflict#meditation_mode";
    public static final String RET_SCENARIO_CONFLICT_SPACECAPSULE = "conflict#spacecapsule_mode";
    public static final String RET_SCENARIO_CONFLICT_VIPSEAT = "conflict#vipseat_mode";
    public static final String RET_SCENARIO_CONFLICT_WAITING = "conflict#waiting_mode";
    public static final String RET_SCENARIO_INVALID = "scenarioInvalid";
    public static final String RET_SCENARIO_UNAVAILABLE = "scenarioUnavailable";
    public static final String RET_SUCCESS = "success";
    public static final String SCENARIO_5D_CINEMA_MODE = "5d_cinema_mode";
    public static final int SCENARIO_5D_CINEMA_MODE_VAL = 3;
    public static final String SCENARIO_ALL = "scenario_all";
    public static final String SCENARIO_CLEANING_MODE = "cleaning_mode";
    public static final int SCENARIO_CLEANING_MODE_VAL = 6;
    public static final String SCENARIO_COSMETIC_SPACE_MODE = "cosmetic_space_mode";
    public static final int SCENARIO_COSMETIC_SPACE_MODE_VAL = 10;
    public static final String SCENARIO_MEDITATION_BACK_ROW = "meditation_back_row_mode";
    public static final int SCENARIO_MEDITATION_BACK_ROW_VAL = 12;
    public static final String SCENARIO_MEDITATION_MODE = "meditation_mode";
    public static final int SCENARIO_MEDITATION_MODE_VAL = 4;
    public static final String SCENARIO_MEDITATION_PASSENGER_SEAT = "meditation_passenger_seat_mode";
    public static final int SCENARIO_MEDITATION_PASSENGER_SEAT_VAL = 11;
    public static final String SCENARIO_NORMAL = "normal_mode";
    public static final int SCENARIO_NORMAL_VAL = 0;
    public static final String SCENARIO_PARKING = "parking_mode";
    public static final int SCENARIO_PARKING_VAL = 13;
    public static final String SCENARIO_SPACECAPSULE_MODE = "spacecapsule_mode";
    public static final int SCENARIO_SPACECAPSULE_MODE_VAL = 7;
    public static final String SCENARIO_SPACECAPSULE_MOVIE_MODE = "spacecapsule_mode_movie";
    public static final int SCENARIO_SPACECAPSULE_MOVIE_MODE_VAL = 1;
    public static final String SCENARIO_SPACECAPSULE_SLEEP_MODE = "spacecapsule_mode_sleep";
    public static final int SCENARIO_SPACECAPSULE_SLEEP_MODE_VAL = 2;
    public static final String SCENARIO_TRAILED_MODE = "trailed_mode";
    public static final int SCENARIO_TRAILED_MODE_VAL = 9;
    public static final String SCENARIO_VIPSEAT_MODE = "vipseat_mode";
    public static final int SCENARIO_VIPSEAT_MODE_VAL = 8;
    public static final String SCENARIO_WAITING_MODE = "waiting_mode";
    public static final int SCENARIO_WAITING_MODE_VAL = 5;
    public static final String SOURCE_ACTIVITY = "activity";
    public static final String SOURCE_SERVICE = "service";
    public static final String SOURCE_SIGNAL = "signal";
    public static final String SOURCE_VOICE = "voice";
    public static final int STATE_EXITING = 3;
    public static final int STATE_IDLE = 0;
    public static final int STATE_INVALID = -1;
    public static final int STATE_RUNNING = 2;
    public static final int STATE_STARTING = 1;
    private Handler mHandler;
    private IUserScenario mService;
    public static final String TAG = UserScenarioManager.class.getSimpleName();
    private static String mServiceName = null;
    private static final HashMap<String, Integer> mScenarioNameValueMap = new HashMap<>();
    private boolean serverDisconnected = false;
    private final ArraySet<UserScenarioListener> mListeners = new ArraySet<>();
    private UserScenarioListenerImpl mUserScenarioListenerImpl = null;

    /* loaded from: classes.dex */
    public interface UserScenarioListener {
        void onUserScenarioStateChanged(String str, int i);
    }

    static {
        initNameValueMap();
    }

    private static void initNameValueMap() {
        mScenarioNameValueMap.put(SCENARIO_NORMAL, 0);
        mScenarioNameValueMap.put(SCENARIO_SPACECAPSULE_MOVIE_MODE, 1);
        mScenarioNameValueMap.put(SCENARIO_SPACECAPSULE_SLEEP_MODE, 2);
        mScenarioNameValueMap.put(SCENARIO_5D_CINEMA_MODE, 3);
        mScenarioNameValueMap.put(SCENARIO_MEDITATION_MODE, 4);
        mScenarioNameValueMap.put(SCENARIO_WAITING_MODE, 5);
        mScenarioNameValueMap.put(SCENARIO_CLEANING_MODE, 6);
        mScenarioNameValueMap.put(SCENARIO_SPACECAPSULE_MODE, 7);
        mScenarioNameValueMap.put(SCENARIO_VIPSEAT_MODE, 8);
        mScenarioNameValueMap.put(SCENARIO_TRAILED_MODE, 9);
        mScenarioNameValueMap.put(SCENARIO_COSMETIC_SPACE_MODE, 10);
        mScenarioNameValueMap.put(SCENARIO_MEDITATION_PASSENGER_SEAT, 11);
        mScenarioNameValueMap.put(SCENARIO_MEDITATION_BACK_ROW, 12);
        mScenarioNameValueMap.put(SCENARIO_PARKING, 13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyEvent(String scenario, int status) {
        Iterator<UserScenarioListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            UserScenarioListener listener = it.next();
            listener.onUserScenarioStateChanged(scenario, status);
        }
    }

    /* loaded from: classes.dex */
    private static class UserScenarioListenerImpl extends IUserScenarioListener.Stub {
        private Handler mHandler;

        public UserScenarioListenerImpl(Handler handler) {
            this.mHandler = handler;
        }

        @Override // com.xiaopeng.xuimanager.userscenario.IUserScenarioListener
        public void onUserScenarioStateChanged(String scenario, int status) throws RemoteException {
            this.mHandler.obtainMessage(1, status, 0, scenario).sendToTarget();
        }
    }

    public UserScenarioManager(IBinder service, Context context, Handler handler) {
        this.mService = null;
        String str = TAG;
        Log.d(str, "create UserScenarioManager,context=" + context + ",handler=" + handler);
        this.mService = IUserScenario.Stub.asInterface(service);
        this.mHandler = new Handler(handler.getLooper()) { // from class: com.xiaopeng.xuimanager.userscenario.UserScenarioManager.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                String str2 = UserScenarioManager.TAG;
                Log.d(str2, "handle msg:" + msg.what);
                if (msg.what == 1) {
                    UserScenarioManager.this.notifyEvent((String) msg.obj, msg.arg1);
                }
            }
        };
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public synchronized void onXUIDisconnected() {
        Log.d(TAG, "onXUIDisconnected");
        this.mListeners.clear();
        if (this.mUserScenarioListenerImpl != null) {
            try {
                this.mService.unregisterListener(this.mUserScenarioListenerImpl);
            } catch (RemoteException e) {
                String str = TAG;
                Log.e(str, "onXUIDisconnected,unregisterListener e=" + e);
            }
            this.mUserScenarioListenerImpl = null;
        }
        this.mHandler = null;
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public synchronized void onXUIConnected(IBinder service) {
        if (this.serverDisconnected) {
            this.serverDisconnected = false;
            this.mService = IUserScenario.Stub.asInterface(service);
            if (this.mUserScenarioListenerImpl != null) {
                try {
                    this.mService.registerListener(this.mUserScenarioListenerImpl);
                } catch (RemoteException e) {
                    String str = TAG;
                    Log.e(str, "registerListener e=" + e);
                }
            }
        }
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onServerDisconnected() {
        this.serverDisconnected = true;
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

    public String enterUserScenario(String scenario, String source) {
        String result;
        try {
            result = this.mService.enterUserScenario(scenario, source);
        } catch (RemoteException e) {
            String str = TAG;
            Log.e(str, "enterUserScenario e=" + e);
            result = RET_REMOTE_EXCEPTION;
        }
        String str2 = TAG;
        Log.i(str2, "enterUserScenario-" + scenario + ",source-" + source + ",ret-" + result);
        return result;
    }

    public String enterUserScenario(String scenario, String source, String extra) {
        String result;
        try {
            result = this.mService.enterUserScenarioWithExtra(scenario, source, extra);
        } catch (RemoteException e) {
            String str = TAG;
            Log.e(str, "enterUserScenario e=" + e);
            result = RET_REMOTE_EXCEPTION;
        }
        String str2 = TAG;
        Log.i(str2, "enterUserScenario-" + scenario + ",source-" + source + ",extra-" + extra + ",ret-" + result);
        return result;
    }

    public String exitUserScenario(String scenario) {
        String result;
        try {
            result = this.mService.exitUserScenario(scenario);
        } catch (RemoteException e) {
            String str = TAG;
            Log.e(str, "exitUserScenario e=" + e);
            result = RET_REMOTE_EXCEPTION;
        }
        String str2 = TAG;
        Log.i(str2, "exitUserScenario-" + scenario + ",ret-" + result);
        return result;
    }

    public String getCurrentUserScenario() {
        try {
            String scenario = this.mService.getCurrentUserScenario();
            return scenario;
        } catch (RemoteException e) {
            String str = TAG;
            Log.e(str, "getCurrentUserScenario e=" + e);
            return null;
        }
    }

    public String[] getCurrentUserScenarios() {
        try {
            String[] scenarios = this.mService.getCurrentUserScenarios();
            return scenarios;
        } catch (RemoteException e) {
            String str = TAG;
            Log.e(str, "getCurrentUserScenario e=" + e);
            return null;
        }
    }

    public int getUserScenarioStatus(String scenario) {
        try {
            int status = this.mService.getUserScenarioStatus(scenario);
            return status;
        } catch (RemoteException e) {
            String str = TAG;
            Log.e(str, "getUserScenarioStatus e=" + e);
            return -1;
        }
    }

    public synchronized void registerListener(UserScenarioListener listener) {
        String str = TAG;
        Log.i(str, "registerListener-" + listener);
        if (listener == null) {
            Log.w(TAG, "registerListener null!");
            return;
        }
        if (this.mUserScenarioListenerImpl == null) {
            this.mUserScenarioListenerImpl = new UserScenarioListenerImpl(this.mHandler);
            try {
                this.mService.registerListener(this.mUserScenarioListenerImpl);
            } catch (RemoteException e) {
                String str2 = TAG;
                Log.e(str2, "registerListener e=" + e);
            }
        }
        this.mListeners.add(listener);
    }

    public synchronized void unregisterListener(UserScenarioListener listener) {
        String str = TAG;
        Log.i(str, "unregisterListener-" + listener);
        this.mListeners.remove(listener);
        if (this.mListeners.isEmpty()) {
            try {
                this.mService.unregisterListener(this.mUserScenarioListenerImpl);
            } catch (RemoteException e) {
                String str2 = TAG;
                Log.e(str2, "unregisterListener e=" + e);
            }
            this.mUserScenarioListenerImpl = null;
        }
    }

    public void reportStatus(String scenario, int status) {
        IUserScenario iUserScenario = this.mService;
        if (iUserScenario == null) {
            Log.w(TAG, "reportStatus,invalid call");
            return;
        }
        try {
            iUserScenario.reportStatus(scenario, status);
        } catch (RemoteException e) {
            String str = TAG;
            Log.e(str, "reportStatus e=" + e);
        }
    }

    public String registerBinderObserver(IBinder binder) {
        IUserScenario iUserScenario = this.mService;
        if (iUserScenario == null) {
            Log.w(TAG, "registerBinderObserver,invalid call");
            return RET_REMOTE_EXCEPTION;
        }
        try {
            iUserScenario.registerBinderObserver(binder);
            return RET_SUCCESS;
        } catch (RemoteException e) {
            String str = TAG;
            Log.e(str, "registerBinderObserver e=" + e);
            return RET_REMOTE_EXCEPTION;
        }
    }

    public String registerBinderObserver(IBinder binder, String scenario) {
        IUserScenario iUserScenario = this.mService;
        if (iUserScenario == null) {
            String str = TAG;
            Log.w(str, "registerBinderObserver,svc null,scenario:" + scenario);
            return RET_REMOTE_EXCEPTION;
        }
        try {
            iUserScenario.registerBinderObserverWithData(binder, scenario);
            return RET_SUCCESS;
        } catch (Exception e) {
            String str2 = TAG;
            Log.e(str2, "registerBinderObserverWithData e=" + e);
            return RET_REMOTE_EXCEPTION;
        }
    }

    public String checkEnterUserScenario(String scenario, String source) {
        IUserScenario iUserScenario = this.mService;
        if (iUserScenario == null) {
            Log.w(TAG, "checkEnterUserScenario,invalid call");
            return RET_REMOTE_EXCEPTION;
        }
        try {
            String ret = iUserScenario.checkEnterUserScenario(scenario, source);
            return ret;
        } catch (Exception e) {
            String str = TAG;
            Log.e(str, "checkEnterUserScenario e=" + e);
            return RET_REMOTE_EXCEPTION;
        }
    }

    public String setParameters(String scenario, String jsonStr) {
        IUserScenario iUserScenario = this.mService;
        if (iUserScenario == null) {
            Log.w(TAG, "setParameters,invalid call");
            return RET_REMOTE_EXCEPTION;
        }
        try {
            String ret = iUserScenario.setParameters(scenario, jsonStr);
            return ret;
        } catch (Exception e) {
            String str = TAG;
            Log.e(str, "setParameters e=" + e);
            return RET_REMOTE_EXCEPTION;
        }
    }

    public static int getScenarioNameValue(String scenario) {
        Integer value = mScenarioNameValueMap.get(scenario);
        if (value != null) {
            return value.intValue();
        }
        return 0;
    }
}
