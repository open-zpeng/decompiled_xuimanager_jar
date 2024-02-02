package com.xiaopeng.xuimanager.contextinfo;

import android.annotation.SystemApi;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.ArraySet;
import android.util.Log;
import com.xiaopeng.xuimanager.XUIManager;
import com.xiaopeng.xuimanager.XUIManagerBase;
import com.xiaopeng.xuimanager.XUIServiceNotConnectedException;
import com.xiaopeng.xuimanager.contextinfo.IContextInfo;
import com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener;
import com.xiaopeng.xuimanager.utils.LogUtil;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
@SystemApi
/* loaded from: classes.dex */
public class ContextInfoManager implements XUIManagerBase {
    public static final boolean DBG = true;
    private static final int MSG_CONTEXTINFO_ACCELERATION_EVENT = 1;
    private static final int MSG_CONTEXTINFO_ANGULARVELOCITY_EVENT = 2;
    private static final int MSG_CONTEXTINFO_ASSIST_SYS = 35;
    private static final int MSG_CONTEXTINFO_ATLS_STATUS = 23;
    private static final int MSG_CONTEXTINFO_AUTO_BRIGHTNESS = 18;
    private static final int MSG_CONTEXTINFO_AVP_WIFI = 20;
    private static final int MSG_CONTEXTINFO_BELT_STATUS = 24;
    private static final int MSG_CONTEXTINFO_CAMERAINTERVAL_EVENT = 8;
    private static final int MSG_CONTEXTINFO_CAMERA_EVENT = 7;
    private static final int MSG_CONTEXTINFO_CAR_GEAR = 33;
    private static final int MSG_CONTEXTINFO_CAR_SPPED = 16;
    private static final int MSG_CONTEXTINFO_CHARGING_GUN = 26;
    private static final int MSG_CONTEXTINFO_COMMON_EVENT = 36;
    private static final int MSG_CONTEXTINFO_CROSS_EVENT = 10;
    private static final int MSG_CONTEXTINFO_DEVICE_CHARGE = 27;
    private static final int MSG_CONTEXTINFO_DOOR_OPEN = 34;
    private static final int MSG_CONTEXTINFO_DRIVER_SEAT = 28;
    private static final int MSG_CONTEXTINFO_ERROR_EVENT = 0;
    private static final int MSG_CONTEXTINFO_HOME_COMPANY_ROUTE_INFO = 38;
    private static final int MSG_CONTEXTINFO_IG_EVENT = 17;
    private static final int MSG_CONTEXTINFO_LANE_EVENT = 6;
    private static final int MSG_CONTEXTINFO_LIGHT_MODE = 29;
    private static final int MSG_CONTEXTINFO_LLU_STATUS = 22;
    private static final int MSG_CONTEXTINFO_LOCATION_EVENT = 11;
    private static final int MSG_CONTEXTINFO_MANEUVER_EVENT = 3;
    private static final int MSG_CONTEXTINFO_MSG_EVENT = 14;
    private static final int MSG_CONTEXTINFO_NAVIGATION_ENABLE_EVENT = 13;
    private static final int MSG_CONTEXTINFO_NAVIGATION_INFO = 12;
    private static final int MSG_CONTEXTINFO_NAVI_EVENT = 5;
    private static final int MSG_CONTEXTINFO_NAVI_STATUS = 37;
    private static final int MSG_CONTEXTINFO_POWEROFF_CNT = 32;
    private static final int MSG_CONTEXTINFO_POWER_ACTION = 25;
    private static final int MSG_CONTEXTINFO_PSD_MOTO = 31;
    private static final int MSG_CONTEXTINFO_REMAININFO_EVENT = 4;
    private static final int MSG_CONTEXTINFO_REMOTE_CMD = 21;
    private static final int MSG_CONTEXTINFO_SAPA_EVENT = 9;
    private static final int MSG_CONTEXTINFO_VPM_EVENT = 30;
    private static final int MSG_CONTEXTINFO_WARNING = 19;
    private static final int MSG_CONTEXTINFO_WEATHER_INFO = 15;
    public static final String TAG = "ContextInfoManager";
    private static String mServiceName = null;
    private final Handler mHandler;
    private IContextInfo mService;
    private final CopyOnWriteArraySet<ContextInfoEventListener> mAllListeners = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<ContextNaviInfoEventListener> mNaviListeners = new CopyOnWriteArraySet<>();
    private final ArraySet<ContextCarInfoEventListener> mCarListeners = new ArraySet<>();
    private final ArraySet<ContextWeatherInfoEventListener> mWeatherListeners = new ArraySet<>();
    private final ArraySet<ContextAutoBrightnessListener> mAutoBrightnessListeners = new ArraySet<>();
    private final ArraySet<ContextCarStatusEventListener> mCarStatusListeners = new ArraySet<>();
    private final ArraySet<ContextInfoCommonEventListener> mCommonEventListeners = new ArraySet<>();
    private ContextInfoEventListenerToService mListenerToService = null;
    private boolean serverDisconnected = false;

    public ContextInfoManager(IBinder service, Context context, Handler handler) {
        this.mService = IContextInfo.Stub.asInterface(service);
        this.mHandler = new EventCallbackHandler(this, handler.getLooper());
    }

    private boolean checkAllListenerEmpty() {
        if (this.mNaviListeners.isEmpty() && this.mCarListeners.isEmpty() && this.mWeatherListeners.isEmpty() && this.mAutoBrightnessListeners.isEmpty() && this.mCarStatusListeners.isEmpty() && this.mCommonEventListeners.isEmpty() && this.mAllListeners.isEmpty()) {
            return true;
        }
        return false;
    }

    private void initRegisterListener() throws XUIServiceNotConnectedException {
        if (checkAllListenerEmpty()) {
            try {
                this.mListenerToService = new ContextInfoEventListenerToService(this);
                this.mService.registerListeners(this.mListenerToService, 1);
            } catch (RemoteException ex) {
                Log.e(TAG, "Could not connect: " + ex.toString());
                throw new XUIServiceNotConnectedException(ex);
            } catch (IllegalStateException ex2) {
                XUIManager.checkXUIServiceNotConnectedExceptionFromXUIService(ex2);
            } catch (Exception e) {
                Log.e(TAG, ": " + e.toString());
            }
        }
    }

    private void initUnregisterListener() throws XUIServiceNotConnectedException {
        if (checkAllListenerEmpty() && this.mListenerToService != null) {
            try {
                this.mService.unregisterListener(this.mListenerToService);
                this.mListenerToService = null;
            } catch (RemoteException e) {
                Log.e(TAG, "Could not unregister: " + e.toString());
                throw new XUIServiceNotConnectedException(e);
            }
        }
    }

    public synchronized void registerListener(ContextInfoEventListener listener) throws XUIServiceNotConnectedException {
        initRegisterListener();
        this.mAllListeners.add(listener);
    }

    public synchronized void unregisterListener(ContextInfoEventListener listener) throws XUIServiceNotConnectedException {
        Log.d(TAG, "unregisterListener(ContextInfoEventListener listener)");
        this.mAllListeners.remove(listener);
        initUnregisterListener();
    }

    public synchronized void registerListener(ContextInfoCommonEventListener listener) throws XUIServiceNotConnectedException {
        initRegisterListener();
        this.mCommonEventListeners.add(listener);
    }

    public synchronized void unregisterListener(ContextInfoCommonEventListener listener) throws XUIServiceNotConnectedException {
        Log.d(TAG, "unregisterListener(ContextInfoCommonEventListener listener)");
        this.mCommonEventListeners.remove(listener);
        initUnregisterListener();
    }

    public synchronized void registerListener(ContextNaviInfoEventListener listener) throws XUIServiceNotConnectedException {
        initRegisterListener();
        this.mNaviListeners.add(listener);
    }

    public synchronized void unregisterListener(ContextNaviInfoEventListener listener) throws XUIServiceNotConnectedException {
        Log.d(TAG, "unregisterListener(ContextNaviInfoEventListener listener)");
        this.mNaviListeners.remove(listener);
        initUnregisterListener();
    }

    public synchronized void registerListener(ContextCarInfoEventListener listener) throws XUIServiceNotConnectedException {
        initRegisterListener();
        this.mCarListeners.add(listener);
    }

    public synchronized void unregisterListener(ContextCarInfoEventListener listener) throws XUIServiceNotConnectedException {
        Log.d(TAG, "unregisterListener(ContextCarInfoEventListener listener)");
        this.mCarListeners.remove(listener);
        initUnregisterListener();
    }

    public synchronized void registerListener(ContextCarStatusEventListener listener) throws XUIServiceNotConnectedException {
        initRegisterListener();
        this.mCarStatusListeners.add(listener);
    }

    public synchronized void unregisterListener(ContextCarStatusEventListener listener) throws XUIServiceNotConnectedException {
        Log.d(TAG, "unregisterListener(ContextCarInfoEventListener listener)");
        this.mCarStatusListeners.remove(listener);
        initUnregisterListener();
    }

    public synchronized void registerListener(ContextWeatherInfoEventListener listener) throws XUIServiceNotConnectedException {
        initRegisterListener();
        this.mWeatherListeners.add(listener);
    }

    public synchronized void unregisterListener(ContextWeatherInfoEventListener listener) throws XUIServiceNotConnectedException {
        Log.d(TAG, "unregisterListener(ContextWeatherInfoEventListener listener)");
        this.mWeatherListeners.remove(listener);
        initUnregisterListener();
    }

    public synchronized void registerListener(ContextAutoBrightnessListener listener) throws XUIServiceNotConnectedException {
        initRegisterListener();
        this.mAutoBrightnessListeners.add(listener);
    }

    public synchronized void unregisterListener(ContextAutoBrightnessListener listener) throws XUIServiceNotConnectedException {
        Log.d(TAG, "unregisterListener(ContextAutoBrightnessListener listener)");
        this.mAutoBrightnessListeners.remove(listener);
        initUnregisterListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchCommonEventToClient(int eventType, int eventValue) {
        Collection<ContextInfoCommonEventListener> commonEventListeners;
        synchronized (this) {
            commonEventListeners = this.mCommonEventListeners;
        }
        if (!commonEventListeners.isEmpty()) {
            for (ContextInfoCommonEventListener l : commonEventListeners) {
                try {
                    l.onCommonEvent(eventType, eventValue);
                } catch (Exception e) {
                    Log.e("test", "dispatchCommonEventToClient  " + e);
                }
            }
        }
    }

    private void dispatchWeatherErrorEvent(int errorCode, int operation) {
        Collection<ContextWeatherInfoEventListener> weatherListeners;
        synchronized (this) {
            weatherListeners = this.mWeatherListeners;
        }
        if (!weatherListeners.isEmpty()) {
            for (ContextWeatherInfoEventListener l : weatherListeners) {
                l.onErrorEvent(errorCode, operation);
            }
        }
    }

    private void dispatchNaviErrorEvent(int errorCode, int operation) {
        Collection<ContextNaviInfoEventListener> naviListeners;
        synchronized (this) {
            naviListeners = this.mNaviListeners;
        }
        if (!naviListeners.isEmpty()) {
            for (ContextNaviInfoEventListener l : naviListeners) {
                l.onErrorEvent(errorCode, operation);
            }
        }
    }

    private void dispatchCarinfoErrorEvent(int errorCode, int operation) {
        Collection<ContextCarInfoEventListener> carListeners;
        synchronized (this) {
            carListeners = this.mCarListeners;
        }
        if (!carListeners.isEmpty()) {
            for (ContextCarInfoEventListener l : carListeners) {
                l.onErrorEvent(errorCode, operation);
            }
        }
    }

    private void dispatchErrorEventToAll(int errorCode, int operation) {
        Collection<ContextInfoEventListener> allListeners;
        synchronized (this) {
            allListeners = this.mAllListeners;
        }
        if (!allListeners.isEmpty()) {
            for (ContextInfoEventListener l : allListeners) {
                l.onErrorEvent(errorCode, operation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchErrorEventToClient(int errorCode, int operation) {
        switch (operation) {
            case 0:
                dispatchWeatherErrorEvent(errorCode, operation);
                break;
            case 1:
                dispatchNaviErrorEvent(errorCode, operation);
                break;
            case 2:
                dispatchCarinfoErrorEvent(errorCode, operation);
                break;
        }
        dispatchErrorEventToAll(errorCode, operation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchAccelerationEventToClient(float accelerationValue) {
        Collection<ContextCarInfoEventListener> carlisteners;
        Collection<ContextInfoEventListener> allListeners;
        synchronized (this) {
            carlisteners = this.mCarListeners;
        }
        if (!carlisteners.isEmpty()) {
            for (ContextCarInfoEventListener l : carlisteners) {
                l.onAccelerationEvent(accelerationValue);
            }
        }
        synchronized (this) {
            allListeners = this.mAllListeners;
        }
        if (!allListeners.isEmpty()) {
            for (ContextInfoEventListener l2 : allListeners) {
                l2.onAccelerationEvent(accelerationValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchAngularVelocityEventToClient(float angularVelocityValue) {
        Collection<ContextCarInfoEventListener> carlisteners;
        Collection<ContextInfoEventListener> allListeners;
        synchronized (this) {
            carlisteners = this.mCarListeners;
        }
        if (!carlisteners.isEmpty()) {
            for (ContextCarInfoEventListener l : carlisteners) {
                l.onAngularVelocityEvent(angularVelocityValue);
            }
        }
        synchronized (this) {
            allListeners = this.mAllListeners;
        }
        if (!allListeners.isEmpty()) {
            for (ContextInfoEventListener l2 : allListeners) {
                l2.onAngularVelocityEvent(angularVelocityValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchManeuverEventToClient(Maneuver maneuver, int msgType) {
        Collection<ContextNaviInfoEventListener> navilisteners;
        Collection<ContextInfoEventListener> allListeners;
        synchronized (this) {
            navilisteners = this.mNaviListeners;
        }
        if (!navilisteners.isEmpty()) {
            for (ContextNaviInfoEventListener l : navilisteners) {
                l.onManeuverEvent(maneuver, msgType);
            }
        }
        synchronized (this) {
            allListeners = this.mAllListeners;
        }
        if (!allListeners.isEmpty()) {
            for (ContextInfoEventListener l2 : allListeners) {
                l2.onManeuverEvent(maneuver, msgType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchRemainEventToClient(RemainInfo remainInfo, int msgType) {
        Collection<ContextNaviInfoEventListener> navilisteners;
        Collection<ContextInfoEventListener> allListeners;
        synchronized (this) {
            navilisteners = this.mNaviListeners;
        }
        if (!navilisteners.isEmpty()) {
            for (ContextNaviInfoEventListener l : navilisteners) {
                l.onRemainInfoEvent(remainInfo, msgType);
            }
        }
        synchronized (this) {
            allListeners = this.mAllListeners;
        }
        if (!allListeners.isEmpty()) {
            for (ContextInfoEventListener l2 : allListeners) {
                l2.onRemainInfoEvent(remainInfo, msgType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchNaviEventToClient(Navi navi, int msgType) {
        Collection<ContextNaviInfoEventListener> navilisteners;
        Collection<ContextInfoEventListener> allListeners;
        LogUtil.log(1, TAG, "dispatchNaviEventToClient :" + msgType);
        synchronized (this) {
            navilisteners = this.mNaviListeners;
        }
        if (!navilisteners.isEmpty()) {
            for (ContextNaviInfoEventListener l : navilisteners) {
                l.onNaviEvent(navi, msgType);
            }
        } else {
            LogUtil.log(3, TAG, "dispatchNaviEventToClient listener is null");
        }
        synchronized (this) {
            allListeners = this.mAllListeners;
        }
        if (!allListeners.isEmpty()) {
            for (ContextInfoEventListener l2 : allListeners) {
                l2.onNaviEvent(navi, msgType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchNaviStatusToClient(NaviStatus naviStatus, int msgType) {
        if (!this.mNaviListeners.isEmpty()) {
            Iterator<ContextNaviInfoEventListener> it = this.mNaviListeners.iterator();
            while (it.hasNext()) {
                ContextNaviInfoEventListener l = it.next();
                l.onNaviStatus(naviStatus, msgType);
            }
        }
        if (!this.mAllListeners.isEmpty()) {
            Iterator<ContextInfoEventListener> it2 = this.mAllListeners.iterator();
            while (it2.hasNext()) {
                ContextInfoEventListener l2 = it2.next();
                l2.onNaviStatus(naviStatus, msgType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchHomeCompanyRouteInfoToClient(HomeCompanyRouteInfo info, int msgType) {
        if (!this.mNaviListeners.isEmpty()) {
            Iterator<ContextNaviInfoEventListener> it = this.mNaviListeners.iterator();
            while (it.hasNext()) {
                ContextNaviInfoEventListener l = it.next();
                l.onHomeCompanyRouteInfo(info, msgType);
            }
        }
        if (!this.mAllListeners.isEmpty()) {
            Iterator<ContextInfoEventListener> it2 = this.mAllListeners.iterator();
            while (it2.hasNext()) {
                ContextInfoEventListener l2 = it2.next();
                l2.onHomeCompanyRouteInfo(info, msgType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchLaneEventToClient(Lane lane, int msgType) {
        Collection<ContextNaviInfoEventListener> navilisteners;
        Collection<ContextInfoEventListener> allListeners;
        synchronized (this) {
            navilisteners = this.mNaviListeners;
        }
        if (!navilisteners.isEmpty()) {
            for (ContextNaviInfoEventListener l : navilisteners) {
                l.onLaneEvent(lane, msgType);
            }
        }
        synchronized (this) {
            allListeners = this.mAllListeners;
        }
        if (!allListeners.isEmpty()) {
            for (ContextInfoEventListener l2 : allListeners) {
                l2.onLaneEvent(lane, msgType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchCameraEventToClient(Camera camera, int msgType) {
        Collection<ContextNaviInfoEventListener> navilisteners;
        Collection<ContextInfoEventListener> allListeners;
        synchronized (this) {
            navilisteners = this.mNaviListeners;
        }
        if (!navilisteners.isEmpty()) {
            for (ContextNaviInfoEventListener l : navilisteners) {
                l.onCameraEvent(camera, msgType);
            }
        }
        synchronized (this) {
            allListeners = this.mAllListeners;
        }
        if (!allListeners.isEmpty()) {
            for (ContextInfoEventListener l2 : allListeners) {
                l2.onCameraEvent(camera, msgType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchCameraIntervalEventToClient(CameraInterval cameraInterval, int msgType) {
        Collection<ContextNaviInfoEventListener> navilisteners;
        Collection<ContextInfoEventListener> allListeners;
        synchronized (this) {
            navilisteners = this.mNaviListeners;
        }
        if (!navilisteners.isEmpty()) {
            for (ContextNaviInfoEventListener l : navilisteners) {
                l.onCameraIntervalEvent(cameraInterval, msgType);
            }
        }
        synchronized (this) {
            allListeners = this.mAllListeners;
        }
        if (!allListeners.isEmpty()) {
            for (ContextInfoEventListener l2 : allListeners) {
                l2.onCameraIntervalEvent(cameraInterval, msgType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchSapaEventToClient(Sapa sapa, int msgType) {
        Collection<ContextNaviInfoEventListener> navilisteners;
        Collection<ContextInfoEventListener> allListeners;
        synchronized (this) {
            navilisteners = this.mNaviListeners;
        }
        if (!navilisteners.isEmpty()) {
            for (ContextNaviInfoEventListener l : navilisteners) {
                l.onSapaEvent(sapa, msgType);
            }
        }
        synchronized (this) {
            allListeners = this.mAllListeners;
        }
        if (!allListeners.isEmpty()) {
            for (ContextInfoEventListener l2 : allListeners) {
                l2.onSapaEvent(sapa, msgType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchCrossEventToClient(Cross cross, int msgType) {
        Collection<ContextNaviInfoEventListener> navilisteners;
        Collection<ContextInfoEventListener> allListeners;
        synchronized (this) {
            navilisteners = this.mNaviListeners;
        }
        if (!navilisteners.isEmpty()) {
            for (ContextNaviInfoEventListener l : navilisteners) {
                l.onCrossEvent(cross, msgType);
            }
        }
        synchronized (this) {
            allListeners = this.mAllListeners;
        }
        if (!allListeners.isEmpty()) {
            for (ContextInfoEventListener l2 : allListeners) {
                l2.onCrossEvent(cross, msgType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchLocationEventToClient(Location location, int msgType) {
        Collection<ContextNaviInfoEventListener> navilisteners;
        Collection<ContextInfoEventListener> allListeners;
        synchronized (this) {
            navilisteners = this.mNaviListeners;
        }
        if (!navilisteners.isEmpty()) {
            for (ContextNaviInfoEventListener l : navilisteners) {
                l.onLocationEvent(location, msgType);
            }
        }
        synchronized (this) {
            allListeners = this.mAllListeners;
        }
        if (!allListeners.isEmpty()) {
            for (ContextInfoEventListener l2 : allListeners) {
                l2.onLocationEvent(location, msgType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchNavigationInfoToClient(String naviInfo) {
        Collection<ContextNaviInfoEventListener> navilisteners;
        Collection<ContextInfoEventListener> allListeners;
        synchronized (this) {
            navilisteners = this.mNaviListeners;
        }
        if (!navilisteners.isEmpty()) {
            for (ContextNaviInfoEventListener l : navilisteners) {
                l.onNavigationInfo(naviInfo);
            }
        }
        synchronized (this) {
            allListeners = this.mAllListeners;
        }
        if (!allListeners.isEmpty()) {
            for (ContextInfoEventListener l2 : allListeners) {
                l2.onNavigationInfo(naviInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchNavigationEnableToClient(boolean enable) {
        Collection<ContextNaviInfoEventListener> navilisteners;
        Collection<ContextInfoEventListener> allListeners;
        synchronized (this) {
            navilisteners = this.mNaviListeners;
        }
        if (!navilisteners.isEmpty()) {
            for (ContextNaviInfoEventListener l : navilisteners) {
                l.onNavigationEnable(enable);
            }
        }
        synchronized (this) {
            allListeners = this.mAllListeners;
        }
        if (!allListeners.isEmpty()) {
            for (ContextInfoEventListener l2 : allListeners) {
                l2.onNavigationEnable(enable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchMsgToClient(int msgType) {
        Collection<ContextNaviInfoEventListener> navilisteners;
        Collection<ContextInfoEventListener> allListeners;
        synchronized (this) {
            navilisteners = this.mNaviListeners;
        }
        if (!navilisteners.isEmpty()) {
            for (ContextNaviInfoEventListener l : navilisteners) {
                l.onMsgEvent(msgType);
            }
        }
        synchronized (this) {
            allListeners = this.mAllListeners;
        }
        if (!allListeners.isEmpty()) {
            for (ContextInfoEventListener l2 : allListeners) {
                l2.onMsgEvent(msgType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchWeatherInfoToClient(String weatherInfo) {
        Collection<ContextWeatherInfoEventListener> weatherlisteners;
        Collection<ContextInfoEventListener> allListeners;
        synchronized (this) {
            weatherlisteners = this.mWeatherListeners;
        }
        if (!weatherlisteners.isEmpty()) {
            for (ContextWeatherInfoEventListener l : weatherlisteners) {
                l.onWeatherInfo(weatherInfo);
            }
        }
        synchronized (this) {
            allListeners = this.mAllListeners;
        }
        if (!allListeners.isEmpty()) {
            for (ContextInfoEventListener l2 : allListeners) {
                l2.onWeatherInfo(weatherInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchGearStatusToClient(int gear) {
        Collection<ContextCarStatusEventListener> listeners;
        synchronized (this) {
            listeners = this.mCarStatusListeners;
        }
        if (!listeners.isEmpty()) {
            for (ContextCarStatusEventListener l : listeners) {
                l.onGearChanged(gear);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchCarSpeedToClient(float speed) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchIGStatusToClient(int status) {
        Collection<ContextCarStatusEventListener> listeners;
        synchronized (this) {
            listeners = this.mCarStatusListeners;
        }
        if (!listeners.isEmpty()) {
            for (ContextCarStatusEventListener l : listeners) {
                l.onIGStatus(status);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchAutoBrightnessToClient(int lux, int autolight) {
        Collection<ContextAutoBrightnessListener> listeners;
        synchronized (this) {
            listeners = this.mAutoBrightnessListeners;
        }
        if (!listeners.isEmpty()) {
            for (ContextAutoBrightnessListener l : listeners) {
                l.onAutoBrightness(lux, autolight);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchXPilotWarningToClient(int type, int status) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchAvpWifiToClient(int status) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchRemoteCommandToClient(int remoteCmd) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchLLUStatusToClient(int type, int status) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchATLSStatusToClient(int type, int status) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchBeltStatusToClient(int status) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchPowerActionToClient(int powerAction) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchChargingGunStatusToClient(int status) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchDeviceChargeStatusToClient(int status) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchDriverSeatStatusToClient(int status) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchBcmLightModeToClient(int type, int mode) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchVpmEventToClient(int type, int mode) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchPsdMotoToClient(int status) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchPowerOffCountToClient(int cnt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCommonEvent(int eventType, int eventValue) {
        Message message = this.mHandler.obtainMessage();
        message.what = MSG_CONTEXTINFO_COMMON_EVENT;
        message.obj = Integer.valueOf(eventType);
        message.arg1 = eventValue;
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAccelerationEvent(float accelerationValue) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, Float.valueOf(accelerationValue)));
    }

    public void handleAngularVelocityEvent(float angularVelocityValue) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, Float.valueOf(angularVelocityValue)));
    }

    public void handleManeuverEvent(Maneuver maneuver, int msgType) {
        Message message = this.mHandler.obtainMessage();
        message.what = 3;
        message.obj = maneuver;
        message.arg1 = msgType;
        this.mHandler.sendMessage(message);
    }

    public void handleRemainInfoEvent(RemainInfo remainInfo, int msgType) {
        Message message = this.mHandler.obtainMessage();
        message.what = 4;
        message.obj = remainInfo;
        message.arg1 = msgType;
        this.mHandler.sendMessage(message);
    }

    public void handleNaviEvent(Navi navi, int msgType) {
        Message message = this.mHandler.obtainMessage();
        message.what = 5;
        message.obj = navi;
        message.arg1 = msgType;
        this.mHandler.sendMessage(message);
    }

    protected void handleNaviStatus(NaviStatus naviStatus, int msgType) {
        this.mHandler.obtainMessage(MSG_CONTEXTINFO_NAVI_STATUS, msgType, 0, naviStatus).sendToTarget();
    }

    protected void handleHomeCompanyRouteInfo(HomeCompanyRouteInfo info, int msgType) {
        this.mHandler.obtainMessage(MSG_CONTEXTINFO_HOME_COMPANY_ROUTE_INFO, msgType, 0, info).sendToTarget();
    }

    public void handleLaneEvent(Lane lane, int msgType) {
        Message message = this.mHandler.obtainMessage();
        message.what = 6;
        message.obj = lane;
        message.arg1 = msgType;
        this.mHandler.sendMessage(message);
    }

    public void handleCameraEvent(Camera camera, int msgType) {
        Message message = this.mHandler.obtainMessage();
        message.what = 7;
        message.obj = camera;
        message.arg1 = msgType;
        this.mHandler.sendMessage(message);
    }

    public void handleCameraIntervalEvent(CameraInterval cameraInterval, int msgType) {
        Message message = this.mHandler.obtainMessage();
        message.what = 8;
        message.obj = cameraInterval;
        message.arg1 = msgType;
        this.mHandler.sendMessage(message);
    }

    public void handleSapaEvent(Sapa sapa, int msgType) {
        Message message = this.mHandler.obtainMessage();
        message.what = 9;
        message.obj = sapa;
        message.arg1 = msgType;
        this.mHandler.sendMessage(message);
    }

    public void handleCrossEvent(Cross cross, int msgType) {
        Message message = this.mHandler.obtainMessage();
        message.what = 10;
        message.obj = cross;
        message.arg1 = msgType;
        this.mHandler.sendMessage(message);
    }

    public void handleLocationEvent(Location location, int msgType) {
        Message message = this.mHandler.obtainMessage();
        message.what = 11;
        message.obj = location;
        message.arg1 = msgType;
        this.mHandler.sendMessage(message);
    }

    public void handleNavigationInfo(String navInfo) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(12, navInfo));
    }

    public void handleNavigationEnableEvent(boolean enable) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(13, Boolean.valueOf(enable)));
    }

    public void handleMsgEvent(int msgType) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(14, Integer.valueOf(msgType)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleErrorEvent(int errorCode, int operation) {
        Message message = this.mHandler.obtainMessage();
        message.what = 0;
        message.obj = Integer.valueOf(errorCode);
        message.arg1 = operation;
        this.mHandler.sendMessage(message);
    }

    public void handleWeatherInfo(String weatherInfo) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(15, weatherInfo));
    }

    public void handleGearStatus(int gear) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(MSG_CONTEXTINFO_CAR_GEAR, Integer.valueOf(gear)));
    }

    public void handleCarSpeed(float speed) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(16, Float.valueOf(speed)));
    }

    public void handleIGStatus(int status) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(17, Integer.valueOf(status)));
    }

    public void handleAutoBrightness(int lux, int autolight) {
        Message message = this.mHandler.obtainMessage();
        message.what = 18;
        message.arg1 = lux;
        message.arg2 = autolight;
        this.mHandler.sendMessage(message);
    }

    public void handleXPilotWarnings(int type, int status) {
        Message message = this.mHandler.obtainMessage();
        message.what = 19;
        message.arg1 = type;
        message.arg2 = status;
        this.mHandler.sendMessage(message);
    }

    public void handleAvpWifi(int status) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(20, Integer.valueOf(status)));
    }

    public void handleRemoteCommand(int cmd) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(MSG_CONTEXTINFO_REMOTE_CMD, Integer.valueOf(cmd)));
    }

    public void handleLLUStatus(int type, int status) {
        Message message = this.mHandler.obtainMessage();
        message.what = MSG_CONTEXTINFO_LLU_STATUS;
        message.arg1 = type;
        message.arg2 = status;
        this.mHandler.sendMessage(message);
    }

    public void handleATLSStatus(int type, int status) {
        Message message = this.mHandler.obtainMessage();
        message.what = MSG_CONTEXTINFO_ATLS_STATUS;
        message.arg1 = type;
        message.arg2 = status;
        this.mHandler.sendMessage(message);
    }

    public void handleBeltStatus(int status) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(MSG_CONTEXTINFO_BELT_STATUS, Integer.valueOf(status)));
    }

    public void handlePowerAction(int poweraction) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(MSG_CONTEXTINFO_POWER_ACTION, Integer.valueOf(poweraction)));
    }

    public void handleChargingGunStatus(int status) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(MSG_CONTEXTINFO_CHARGING_GUN, Integer.valueOf(status)));
    }

    public void handleDeviceChargeStatus(int status) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(MSG_CONTEXTINFO_DEVICE_CHARGE, Integer.valueOf(status)));
    }

    public void handleDriverSeatStatus(int status) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(MSG_CONTEXTINFO_DRIVER_SEAT, Integer.valueOf(status)));
    }

    public void handleLightmode(int type, int status) {
        Message message = this.mHandler.obtainMessage();
        message.what = MSG_CONTEXTINFO_LIGHT_MODE;
        message.arg1 = type;
        message.arg2 = status;
        this.mHandler.sendMessage(message);
    }

    public void handleVpmEvent(int type, int mode) {
        Message message = this.mHandler.obtainMessage();
        message.what = MSG_CONTEXTINFO_VPM_EVENT;
        message.arg1 = type;
        message.arg2 = mode;
        this.mHandler.sendMessage(message);
    }

    public void handlePsdMoto(int status) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(MSG_CONTEXTINFO_PSD_MOTO, Integer.valueOf(status)));
    }

    public void handlePowerOffCount(int cnt) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(32, Integer.valueOf(cnt)));
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onServerDisconnected() {
        Log.e(TAG, "onServerDisconnected!");
        this.serverDisconnected = true;
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIDisconnected() {
        Iterator<ContextNaviInfoEventListener> it = this.mNaviListeners.iterator();
        while (it.hasNext()) {
            ContextNaviInfoEventListener l = it.next();
            try {
                unregisterListener(l);
            } catch (XUIServiceNotConnectedException e) {
            }
        }
        Iterator<ContextCarInfoEventListener> it2 = this.mCarListeners.iterator();
        while (it2.hasNext()) {
            ContextCarInfoEventListener l2 = it2.next();
            try {
                unregisterListener(l2);
            } catch (XUIServiceNotConnectedException e2) {
            }
        }
        Iterator<ContextWeatherInfoEventListener> it3 = this.mWeatherListeners.iterator();
        while (it3.hasNext()) {
            ContextWeatherInfoEventListener l3 = it3.next();
            try {
                unregisterListener(l3);
            } catch (XUIServiceNotConnectedException e3) {
            }
        }
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIConnected(IBinder service) {
        Log.i(TAG, "onXUIConnected!");
        if (!this.serverDisconnected) {
            return;
        }
        this.serverDisconnected = false;
        this.mService = IContextInfo.Stub.asInterface(service);
        if (this.mListenerToService != null) {
            try {
                this.mService.registerListeners(this.mListenerToService, 1);
            } catch (RemoteException e) {
                Log.e(TAG, "registerListener e=" + e);
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

    public void setCarSpeed(float speed, int deltaTime) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setCarSpeed");
        try {
            this.mService.setCarSpeed(speed, deltaTime);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setCarSpeed: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setCarAngular(float angularValue, int deltaTime) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setCarAngular");
        try {
            this.mService.setCarAngular(angularValue, deltaTime);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setCarAngular: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setCarAngularVelocity(float angularVelocityValue) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setCarAngularVelocity");
        try {
            this.mService.setCarAngularVelocity(angularVelocityValue);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setCarAngularVelocity: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public boolean getIntelligentEffectEnable() throws XUIServiceNotConnectedException {
        Log.d(TAG, "getIntelligentEffectEnable");
        try {
            return this.mService.getIntelligentEffectEnable();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getIntelligentEffectEnable: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setIntelligentEffectEnable(boolean enable) throws XUIServiceNotConnectedException {
        Log.d(TAG, "setIntelligentEffectEnable");
        try {
            this.mService.setIntelligentEffectEnable(enable);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setIntelligentEffectEnable: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setNavigationInfo(String navInfo) throws XUIServiceNotConnectedException {
        try {
            this.mService.setNavigationInfo(navInfo);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setNavigationInfo: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setNavigationEnable(boolean enable) throws XUIServiceNotConnectedException {
        try {
            Log.d(TAG, "setNavigationEnable, enable: " + enable);
            this.mService.setNavigationEnable(enable);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setNavigationEnable: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public String getWeather() throws XUIServiceNotConnectedException {
        Log.d(TAG, "getWeather");
        try {
            return this.mService.getWeather();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getWeather: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    @Deprecated
    public void updateWeatherFromServer() {
    }

    public void sendContextEvent(int eventType, int eventValue) throws XUIServiceNotConnectedException {
        Log.d(TAG, "sendContextEvent " + eventType + " " + eventValue);
        try {
            this.mService.sendContextEvent(eventType, eventValue);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not sendContextEvent: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    /* loaded from: classes.dex */
    public interface ContextInfoEventListener {
        void onAccelerationEvent(float f);

        void onAngularVelocityEvent(float f);

        void onErrorEvent(int i, int i2);

        default void onManeuverEvent(Maneuver maneuver, int msgType) {
        }

        default void onRemainInfoEvent(RemainInfo remainInfo, int msgType) {
        }

        default void onNaviEvent(Navi navi, int msgType) {
        }

        default void onNaviStatus(NaviStatus naviStatus, int msgType) {
        }

        default void onHomeCompanyRouteInfo(HomeCompanyRouteInfo info, int msgType) {
        }

        default void onLaneEvent(Lane lane, int msgType) {
        }

        default void onCameraEvent(Camera camera, int msgType) {
        }

        default void onCameraIntervalEvent(CameraInterval cameraInterval, int msgType) {
        }

        default void onSapaEvent(Sapa sapa, int msgType) {
        }

        default void onCrossEvent(Cross cross, int msgType) {
        }

        default void onLocationEvent(Location location, int msgType) {
        }

        default void onNavigationInfo(String naviInfo) {
        }

        default void onNavigationEnable(boolean enable) {
        }

        default void onMsgEvent(int msgType) {
        }

        default void onWeatherInfo(String weatherInfo) {
        }
    }

    /* loaded from: classes.dex */
    public interface ContextInfoCommonEventListener {
        default void onCommonEvent(int eventType, int eventValue) {
        }

        default void onErrorEvent(int errorCode, int operation) {
        }
    }

    /* loaded from: classes.dex */
    public interface ContextNaviInfoEventListener {
        default void onManeuverEvent(Maneuver maneuver, int msgType) {
        }

        default void onRemainInfoEvent(RemainInfo remainInfo, int msgType) {
        }

        default void onNaviEvent(Navi navi, int msgType) {
        }

        default void onNaviStatus(NaviStatus naviStatus, int msgType) {
        }

        default void onHomeCompanyRouteInfo(HomeCompanyRouteInfo info, int msgType) {
        }

        default void onLaneEvent(Lane lane, int msgType) {
        }

        default void onCameraEvent(Camera camera, int msgType) {
        }

        default void onCameraIntervalEvent(CameraInterval cameraInterval, int msgType) {
        }

        default void onSapaEvent(Sapa sapa, int msgType) {
        }

        default void onCrossEvent(Cross cross, int msgType) {
        }

        default void onLocationEvent(Location location, int msgType) {
        }

        default void onNavigationInfo(String naviInfo) {
        }

        default void onNavigationEnable(boolean enable) {
        }

        default void onMsgEvent(int msgType) {
        }

        default void onWeatherInfo(String weatherInfo) {
        }

        default void onGearChanged(int gear) {
        }

        default void onCarSpeed(float speed) {
        }

        default void onErrorEvent(int errorCode, int operation) {
        }
    }

    /* loaded from: classes.dex */
    public interface ContextCarInfoEventListener {
        default void onAccelerationEvent(float accelerationValue) {
        }

        default void onAngularVelocityEvent(float angularVelocityValue) {
        }

        default void onErrorEvent(int errorCode, int operation) {
        }
    }

    /* loaded from: classes.dex */
    public interface ContextAutoBrightnessListener {
        default void onAutoBrightness(int lux, int autolight) {
        }

        default void onErrorEvent(int errorCode, int operation) {
        }
    }

    /* loaded from: classes.dex */
    public interface ContextCarStatusEventListener {
        default void onIGStatus(int status) {
        }

        default void onGearChanged(int gear) {
        }

        default void onErrorEvent(int errorCode, int operation) {
        }
    }

    /* loaded from: classes.dex */
    public interface ContextWeatherInfoEventListener {
        default void onWeatherInfo(String weatherInfo) {
        }

        default void onErrorEvent(int errorCode, int operation) {
        }
    }

    /* loaded from: classes.dex */
    private static final class EventCallbackHandler extends Handler {
        WeakReference<ContextInfoManager> mMgr;

        EventCallbackHandler(ContextInfoManager mgr, Looper looper) {
            super(looper);
            this.mMgr = new WeakReference<>(mgr);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            ContextInfoManager mgr = this.mMgr.get();
            switch (msg.what) {
                case 0:
                    if (mgr != null) {
                        mgr.dispatchErrorEventToClient(((Integer) msg.obj).intValue(), msg.arg1);
                        return;
                    }
                    return;
                case 1:
                    if (mgr != null) {
                        mgr.dispatchAccelerationEventToClient(((Float) msg.obj).floatValue());
                        return;
                    }
                    return;
                case 2:
                    if (mgr != null) {
                        mgr.dispatchAngularVelocityEventToClient(((Float) msg.obj).floatValue());
                        return;
                    }
                    return;
                case 3:
                    if (mgr != null) {
                        mgr.dispatchManeuverEventToClient((Maneuver) msg.obj, msg.arg1);
                        return;
                    }
                    return;
                case 4:
                    if (mgr != null) {
                        mgr.dispatchRemainEventToClient((RemainInfo) msg.obj, msg.arg1);
                        return;
                    }
                    return;
                case 5:
                    if (mgr != null) {
                        mgr.dispatchNaviEventToClient((Navi) msg.obj, msg.arg1);
                        return;
                    }
                    return;
                case 6:
                    if (mgr != null) {
                        mgr.dispatchLaneEventToClient((Lane) msg.obj, msg.arg1);
                        return;
                    }
                    return;
                case 7:
                    if (mgr != null) {
                        mgr.dispatchCameraEventToClient((Camera) msg.obj, msg.arg1);
                        return;
                    }
                    return;
                case 8:
                    if (mgr != null) {
                        mgr.dispatchCameraIntervalEventToClient((CameraInterval) msg.obj, msg.arg1);
                        return;
                    }
                    return;
                case 9:
                    if (mgr != null) {
                        mgr.dispatchSapaEventToClient((Sapa) msg.obj, msg.arg1);
                        return;
                    }
                    return;
                case 10:
                    if (mgr != null) {
                        mgr.dispatchCrossEventToClient((Cross) msg.obj, msg.arg1);
                        return;
                    }
                    return;
                case 11:
                    if (mgr != null) {
                        mgr.dispatchLocationEventToClient((Location) msg.obj, msg.arg1);
                        return;
                    }
                    return;
                case 12:
                    if (mgr != null) {
                        mgr.dispatchNavigationInfoToClient((String) msg.obj);
                        return;
                    }
                    return;
                case 13:
                    if (mgr != null) {
                        mgr.dispatchNavigationEnableToClient(((Boolean) msg.obj).booleanValue());
                        return;
                    }
                    return;
                case 14:
                    if (mgr != null) {
                        mgr.dispatchMsgToClient(((Integer) msg.obj).intValue());
                        return;
                    }
                    return;
                case 15:
                    if (mgr != null) {
                        mgr.dispatchWeatherInfoToClient((String) msg.obj);
                        return;
                    }
                    return;
                case 16:
                    if (mgr != null) {
                        mgr.dispatchCarSpeedToClient(((Float) msg.obj).floatValue());
                        return;
                    }
                    return;
                case 17:
                    if (mgr != null) {
                        mgr.dispatchIGStatusToClient(((Integer) msg.obj).intValue());
                        return;
                    }
                    return;
                case 18:
                    if (mgr != null) {
                        mgr.dispatchAutoBrightnessToClient(msg.arg1, msg.arg2);
                        return;
                    }
                    return;
                case 19:
                    if (mgr != null) {
                        mgr.dispatchXPilotWarningToClient(msg.arg1, msg.arg2);
                        return;
                    }
                    return;
                case 20:
                    if (mgr != null) {
                        mgr.dispatchAvpWifiToClient(((Integer) msg.obj).intValue());
                        return;
                    }
                    return;
                case ContextInfoManager.MSG_CONTEXTINFO_REMOTE_CMD /* 21 */:
                    if (mgr != null) {
                        mgr.dispatchRemoteCommandToClient(((Integer) msg.obj).intValue());
                        return;
                    }
                    return;
                case ContextInfoManager.MSG_CONTEXTINFO_LLU_STATUS /* 22 */:
                    if (mgr != null) {
                        mgr.dispatchLLUStatusToClient(msg.arg1, msg.arg2);
                        return;
                    }
                    return;
                case ContextInfoManager.MSG_CONTEXTINFO_ATLS_STATUS /* 23 */:
                    if (mgr != null) {
                        mgr.dispatchATLSStatusToClient(msg.arg1, msg.arg2);
                        return;
                    }
                    return;
                case ContextInfoManager.MSG_CONTEXTINFO_BELT_STATUS /* 24 */:
                    if (mgr != null) {
                        mgr.dispatchBeltStatusToClient(((Integer) msg.obj).intValue());
                        return;
                    }
                    return;
                case ContextInfoManager.MSG_CONTEXTINFO_POWER_ACTION /* 25 */:
                    if (mgr != null) {
                        mgr.dispatchPowerActionToClient(((Integer) msg.obj).intValue());
                        return;
                    }
                    return;
                case ContextInfoManager.MSG_CONTEXTINFO_CHARGING_GUN /* 26 */:
                    if (mgr != null) {
                        mgr.dispatchChargingGunStatusToClient(((Integer) msg.obj).intValue());
                        return;
                    }
                    return;
                case ContextInfoManager.MSG_CONTEXTINFO_DEVICE_CHARGE /* 27 */:
                    if (mgr != null) {
                        mgr.dispatchDeviceChargeStatusToClient(((Integer) msg.obj).intValue());
                        return;
                    }
                    return;
                case ContextInfoManager.MSG_CONTEXTINFO_DRIVER_SEAT /* 28 */:
                    if (mgr != null) {
                        mgr.dispatchDriverSeatStatusToClient(((Integer) msg.obj).intValue());
                        return;
                    }
                    return;
                case ContextInfoManager.MSG_CONTEXTINFO_LIGHT_MODE /* 29 */:
                    if (mgr != null) {
                        mgr.dispatchBcmLightModeToClient(msg.arg1, msg.arg2);
                        return;
                    }
                    return;
                case ContextInfoManager.MSG_CONTEXTINFO_VPM_EVENT /* 30 */:
                    if (mgr != null) {
                        mgr.dispatchVpmEventToClient(msg.arg1, msg.arg2);
                        return;
                    }
                    return;
                case ContextInfoManager.MSG_CONTEXTINFO_PSD_MOTO /* 31 */:
                    if (mgr != null) {
                        mgr.dispatchPsdMotoToClient(((Integer) msg.obj).intValue());
                        return;
                    }
                    return;
                case 32:
                    if (mgr != null) {
                        mgr.dispatchPowerOffCountToClient(((Integer) msg.obj).intValue());
                        return;
                    }
                    return;
                case ContextInfoManager.MSG_CONTEXTINFO_CAR_GEAR /* 33 */:
                    if (mgr != null) {
                        mgr.dispatchGearStatusToClient(((Integer) msg.obj).intValue());
                        return;
                    }
                    return;
                case ContextInfoManager.MSG_CONTEXTINFO_DOOR_OPEN /* 34 */:
                case ContextInfoManager.MSG_CONTEXTINFO_ASSIST_SYS /* 35 */:
                    return;
                case ContextInfoManager.MSG_CONTEXTINFO_COMMON_EVENT /* 36 */:
                    if (mgr != null) {
                        mgr.dispatchCommonEventToClient(((Integer) msg.obj).intValue(), msg.arg1);
                        return;
                    }
                    return;
                case ContextInfoManager.MSG_CONTEXTINFO_NAVI_STATUS /* 37 */:
                    if (mgr != null) {
                        mgr.dispatchNaviStatusToClient((NaviStatus) msg.obj, msg.arg1);
                        return;
                    }
                    return;
                case ContextInfoManager.MSG_CONTEXTINFO_HOME_COMPANY_ROUTE_INFO /* 38 */:
                    if (mgr != null) {
                        mgr.dispatchHomeCompanyRouteInfoToClient((HomeCompanyRouteInfo) msg.obj, msg.arg1);
                        return;
                    }
                    return;
                default:
                    Log.e(ContextInfoManager.TAG, "Event type not handled?" + msg);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ContextInfoEventListenerToService extends IContextInfoEventListener.Stub {
        private final WeakReference<ContextInfoManager> mManager;

        public ContextInfoEventListenerToService(ContextInfoManager manager) {
            this.mManager = new WeakReference<>(manager);
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onCommonEvent(int eventType, int eventValue) {
            ContextInfoManager manager = this.mManager.get();
            Log.d(ContextInfoManager.TAG, "onCommonEvent " + eventType + " " + eventValue);
            if (manager != null) {
                manager.handleCommonEvent(eventType, eventValue);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onAccelerationEvent(float accelerationValue) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleAccelerationEvent(accelerationValue);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onAngularVelocityEvent(float angularVelocityValue) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleAngularVelocityEvent(angularVelocityValue);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onManeuverEvent(Maneuver maneuver, int msgType) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleManeuverEvent(maneuver, msgType);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onRemainInfoEvent(RemainInfo remainInfo, int msgType) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleRemainInfoEvent(remainInfo, msgType);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onNaviEvent(Navi navi, int msgType) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleNaviEvent(navi, msgType);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onNaviStatus(NaviStatus naviStatus, int msgType) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleNaviStatus(naviStatus, msgType);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onHomeCompanyRouteInfo(HomeCompanyRouteInfo info, int msgType) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleHomeCompanyRouteInfo(info, msgType);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onLaneEvent(Lane lane, int msgType) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleLaneEvent(lane, msgType);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onCameraEvent(Camera camera, int msgType) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleCameraEvent(camera, msgType);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onCameraIntervalEvent(CameraInterval cameraInterval, int msgType) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleCameraIntervalEvent(cameraInterval, msgType);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onSapaEvent(Sapa sapa, int msgType) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleSapaEvent(sapa, msgType);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onCrossEvent(Cross cross, int msgType) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleCrossEvent(cross, msgType);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onLocationEvent(Location location, int msgType) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleLocationEvent(location, msgType);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onNavigationInfo(String navInfo) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleNavigationInfo(navInfo);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onNavigationEnable(boolean enable) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleNavigationEnableEvent(enable);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onMsgEvent(int msgType) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleMsgEvent(msgType);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onWeatherInfo(String weatherInfo) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleWeatherInfo(weatherInfo);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onGearChanged(int gear) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleGearStatus(gear);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onCarSpeed(float speed) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleCarSpeed(speed);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onIGStatus(int status) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleIGStatus(status);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onAutoBrightness(int lux, int autolight) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleAutoBrightness(lux, autolight);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onXPilotWarning(int type, int status) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleXPilotWarnings(type, status);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onAvpWifi(int status) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleAvpWifi(status);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onRemoteCommand(int remoteCmd) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleRemoteCommand(remoteCmd);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onLLUStatus(int type, int status) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleLLUStatus(type, status);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onATLSStatus(int type, int status) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleATLSStatus(type, status);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onBeltStatus(int status) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleBeltStatus(status);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onPowerAction(int powerAction) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handlePowerAction(powerAction);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onChargingGunStatus(int status) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleChargingGunStatus(status);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onDeviceChargeStatus(int status) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleDeviceChargeStatus(status);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onDriverSeatStatus(int status) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleDriverSeatStatus(status);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onBcmLightMode(int type, int mode) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleLightmode(type, mode);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onVpmEvent(int type, int mode) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleVpmEvent(type, mode);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onPsdMoto(int status) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handlePsdMoto(status);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onPowerOffCount(int cnt) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handlePowerOffCount(cnt);
            }
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onError(int errorCode, int operation) {
            ContextInfoManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleErrorEvent(errorCode, operation);
            }
        }
    }
}
