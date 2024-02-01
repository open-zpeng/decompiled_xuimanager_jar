package com.xiaopeng.xuimanager.contextinfo;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IContextInfoEventListener extends IInterface {
    void onATLSStatus(int i, int i2) throws RemoteException;

    void onAccelerationEvent(float f) throws RemoteException;

    void onAngularVelocityEvent(float f) throws RemoteException;

    void onAutoBrightness(int i, int i2) throws RemoteException;

    void onAvpWifi(int i) throws RemoteException;

    void onBcmLightMode(int i, int i2) throws RemoteException;

    void onBeltStatus(int i) throws RemoteException;

    void onCameraEvent(Camera camera, int i) throws RemoteException;

    void onCameraIntervalEvent(CameraInterval cameraInterval, int i) throws RemoteException;

    void onCarSpeed(float f) throws RemoteException;

    void onChargingGunStatus(int i) throws RemoteException;

    void onCommonEvent(int i, int i2) throws RemoteException;

    void onCrossEvent(Cross cross, int i) throws RemoteException;

    void onDeviceChargeStatus(int i) throws RemoteException;

    void onDriverSeatStatus(int i) throws RemoteException;

    void onError(int i, int i2) throws RemoteException;

    void onGearChanged(int i) throws RemoteException;

    void onHomeCompanyRouteInfo(HomeCompanyRouteInfo homeCompanyRouteInfo, int i) throws RemoteException;

    void onIGStatus(int i) throws RemoteException;

    void onLLUStatus(int i, int i2) throws RemoteException;

    void onLaneEvent(Lane lane, int i) throws RemoteException;

    void onLocationEvent(Location location, int i) throws RemoteException;

    void onManeuverEvent(Maneuver maneuver, int i) throws RemoteException;

    void onMsgEvent(int i) throws RemoteException;

    void onNaviEvent(Navi navi, int i) throws RemoteException;

    void onNaviStatus(NaviStatus naviStatus, int i) throws RemoteException;

    void onNavigationEnable(boolean z) throws RemoteException;

    void onNavigationInfo(String str) throws RemoteException;

    void onPowerAction(int i) throws RemoteException;

    void onPowerOffCount(int i) throws RemoteException;

    void onPsdMoto(int i) throws RemoteException;

    void onRemainInfoEvent(RemainInfo remainInfo, int i) throws RemoteException;

    void onRemoteCommand(int i) throws RemoteException;

    void onSapaEvent(Sapa sapa, int i) throws RemoteException;

    void onVpmEvent(int i, int i2) throws RemoteException;

    void onWeatherInfo(String str) throws RemoteException;

    void onXPilotWarning(int i, int i2) throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements IContextInfoEventListener {
        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onAccelerationEvent(float accelerationValue) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onAngularVelocityEvent(float angularVelocityValue) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onManeuverEvent(Maneuver maneuver, int msgType) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onRemainInfoEvent(RemainInfo remainInfo, int msgType) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onNaviEvent(Navi navi, int msgType) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onLaneEvent(Lane lane, int msgType) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onCameraEvent(Camera camera, int msgType) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onCameraIntervalEvent(CameraInterval cameraInterval, int msgType) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onSapaEvent(Sapa sapa, int msgType) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onCrossEvent(Cross cross, int msgType) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onLocationEvent(Location location, int msgType) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onNavigationInfo(String navInfo) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onNavigationEnable(boolean enable) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onMsgEvent(int msgType) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onWeatherInfo(String weatherInfo) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onGearChanged(int gear) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onCarSpeed(float speed) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onIGStatus(int status) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onAutoBrightness(int lux, int autolight) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onXPilotWarning(int type, int status) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onAvpWifi(int status) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onRemoteCommand(int remoteCmd) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onLLUStatus(int type, int status) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onATLSStatus(int type, int status) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onBeltStatus(int status) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onPowerAction(int powerAction) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onChargingGunStatus(int status) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onDeviceChargeStatus(int status) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onDriverSeatStatus(int status) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onBcmLightMode(int type, int mode) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onVpmEvent(int type, int mode) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onPsdMoto(int status) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onPowerOffCount(int cnt) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onCommonEvent(int eventType, int eventValue) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onError(int errorCode, int operation) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onNaviStatus(NaviStatus naviStatus, int msgType) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
        public void onHomeCompanyRouteInfo(HomeCompanyRouteInfo info, int msgType) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IContextInfoEventListener {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener";
        static final int TRANSACTION_onATLSStatus = 24;
        static final int TRANSACTION_onAccelerationEvent = 1;
        static final int TRANSACTION_onAngularVelocityEvent = 2;
        static final int TRANSACTION_onAutoBrightness = 19;
        static final int TRANSACTION_onAvpWifi = 21;
        static final int TRANSACTION_onBcmLightMode = 30;
        static final int TRANSACTION_onBeltStatus = 25;
        static final int TRANSACTION_onCameraEvent = 7;
        static final int TRANSACTION_onCameraIntervalEvent = 8;
        static final int TRANSACTION_onCarSpeed = 17;
        static final int TRANSACTION_onChargingGunStatus = 27;
        static final int TRANSACTION_onCommonEvent = 36;
        static final int TRANSACTION_onCrossEvent = 10;
        static final int TRANSACTION_onDeviceChargeStatus = 28;
        static final int TRANSACTION_onDriverSeatStatus = 29;
        static final int TRANSACTION_onError = 37;
        static final int TRANSACTION_onGearChanged = 16;
        static final int TRANSACTION_onHomeCompanyRouteInfo = 39;
        static final int TRANSACTION_onIGStatus = 18;
        static final int TRANSACTION_onLLUStatus = 23;
        static final int TRANSACTION_onLaneEvent = 6;
        static final int TRANSACTION_onLocationEvent = 11;
        static final int TRANSACTION_onManeuverEvent = 3;
        static final int TRANSACTION_onMsgEvent = 14;
        static final int TRANSACTION_onNaviEvent = 5;
        static final int TRANSACTION_onNaviStatus = 38;
        static final int TRANSACTION_onNavigationEnable = 13;
        static final int TRANSACTION_onNavigationInfo = 12;
        static final int TRANSACTION_onPowerAction = 26;
        static final int TRANSACTION_onPowerOffCount = 33;
        static final int TRANSACTION_onPsdMoto = 32;
        static final int TRANSACTION_onRemainInfoEvent = 4;
        static final int TRANSACTION_onRemoteCommand = 22;
        static final int TRANSACTION_onSapaEvent = 9;
        static final int TRANSACTION_onVpmEvent = 31;
        static final int TRANSACTION_onWeatherInfo = 15;
        static final int TRANSACTION_onXPilotWarning = 20;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IContextInfoEventListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IContextInfoEventListener)) {
                return (IContextInfoEventListener) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            Maneuver _arg0;
            RemainInfo _arg02;
            Navi _arg03;
            Lane _arg04;
            Camera _arg05;
            CameraInterval _arg06;
            Sapa _arg07;
            Cross _arg08;
            Location _arg09;
            NaviStatus _arg010;
            HomeCompanyRouteInfo _arg011;
            if (code == 1598968902) {
                reply.writeString(DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    float _arg012 = data.readFloat();
                    onAccelerationEvent(_arg012);
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    float _arg013 = data.readFloat();
                    onAngularVelocityEvent(_arg013);
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = Maneuver.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    int _arg1 = data.readInt();
                    onManeuverEvent(_arg0, _arg1);
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg02 = RemainInfo.CREATOR.createFromParcel(data);
                    } else {
                        _arg02 = null;
                    }
                    int _arg12 = data.readInt();
                    onRemainInfoEvent(_arg02, _arg12);
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg03 = Navi.CREATOR.createFromParcel(data);
                    } else {
                        _arg03 = null;
                    }
                    int _arg13 = data.readInt();
                    onNaviEvent(_arg03, _arg13);
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg04 = Lane.CREATOR.createFromParcel(data);
                    } else {
                        _arg04 = null;
                    }
                    int _arg14 = data.readInt();
                    onLaneEvent(_arg04, _arg14);
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg05 = Camera.CREATOR.createFromParcel(data);
                    } else {
                        _arg05 = null;
                    }
                    int _arg15 = data.readInt();
                    onCameraEvent(_arg05, _arg15);
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg06 = CameraInterval.CREATOR.createFromParcel(data);
                    } else {
                        _arg06 = null;
                    }
                    int _arg16 = data.readInt();
                    onCameraIntervalEvent(_arg06, _arg16);
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg07 = Sapa.CREATOR.createFromParcel(data);
                    } else {
                        _arg07 = null;
                    }
                    int _arg17 = data.readInt();
                    onSapaEvent(_arg07, _arg17);
                    return true;
                case 10:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg08 = Cross.CREATOR.createFromParcel(data);
                    } else {
                        _arg08 = null;
                    }
                    int _arg18 = data.readInt();
                    onCrossEvent(_arg08, _arg18);
                    return true;
                case 11:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg09 = Location.CREATOR.createFromParcel(data);
                    } else {
                        _arg09 = null;
                    }
                    int _arg19 = data.readInt();
                    onLocationEvent(_arg09, _arg19);
                    return true;
                case 12:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg014 = data.readString();
                    onNavigationInfo(_arg014);
                    return true;
                case 13:
                    data.enforceInterface(DESCRIPTOR);
                    boolean _arg015 = data.readInt() != 0;
                    onNavigationEnable(_arg015);
                    return true;
                case 14:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg016 = data.readInt();
                    onMsgEvent(_arg016);
                    return true;
                case 15:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg017 = data.readString();
                    onWeatherInfo(_arg017);
                    return true;
                case 16:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg018 = data.readInt();
                    onGearChanged(_arg018);
                    return true;
                case 17:
                    data.enforceInterface(DESCRIPTOR);
                    float _arg019 = data.readFloat();
                    onCarSpeed(_arg019);
                    return true;
                case 18:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg020 = data.readInt();
                    onIGStatus(_arg020);
                    return true;
                case 19:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg021 = data.readInt();
                    int _arg110 = data.readInt();
                    onAutoBrightness(_arg021, _arg110);
                    return true;
                case 20:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg022 = data.readInt();
                    int _arg111 = data.readInt();
                    onXPilotWarning(_arg022, _arg111);
                    return true;
                case TRANSACTION_onAvpWifi /* 21 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg023 = data.readInt();
                    onAvpWifi(_arg023);
                    return true;
                case TRANSACTION_onRemoteCommand /* 22 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg024 = data.readInt();
                    onRemoteCommand(_arg024);
                    return true;
                case TRANSACTION_onLLUStatus /* 23 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg025 = data.readInt();
                    int _arg112 = data.readInt();
                    onLLUStatus(_arg025, _arg112);
                    return true;
                case TRANSACTION_onATLSStatus /* 24 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg026 = data.readInt();
                    int _arg113 = data.readInt();
                    onATLSStatus(_arg026, _arg113);
                    return true;
                case TRANSACTION_onBeltStatus /* 25 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg027 = data.readInt();
                    onBeltStatus(_arg027);
                    return true;
                case TRANSACTION_onPowerAction /* 26 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg028 = data.readInt();
                    onPowerAction(_arg028);
                    return true;
                case TRANSACTION_onChargingGunStatus /* 27 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg029 = data.readInt();
                    onChargingGunStatus(_arg029);
                    return true;
                case TRANSACTION_onDeviceChargeStatus /* 28 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg030 = data.readInt();
                    onDeviceChargeStatus(_arg030);
                    return true;
                case TRANSACTION_onDriverSeatStatus /* 29 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg031 = data.readInt();
                    onDriverSeatStatus(_arg031);
                    return true;
                case TRANSACTION_onBcmLightMode /* 30 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg032 = data.readInt();
                    int _arg114 = data.readInt();
                    onBcmLightMode(_arg032, _arg114);
                    return true;
                case TRANSACTION_onVpmEvent /* 31 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg033 = data.readInt();
                    int _arg115 = data.readInt();
                    onVpmEvent(_arg033, _arg115);
                    return true;
                case 32:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg034 = data.readInt();
                    onPsdMoto(_arg034);
                    return true;
                case TRANSACTION_onPowerOffCount /* 33 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg035 = data.readInt();
                    onPowerOffCount(_arg035);
                    return true;
                default:
                    switch (code) {
                        case TRANSACTION_onCommonEvent /* 36 */:
                            data.enforceInterface(DESCRIPTOR);
                            int _arg036 = data.readInt();
                            int _arg116 = data.readInt();
                            onCommonEvent(_arg036, _arg116);
                            return true;
                        case TRANSACTION_onError /* 37 */:
                            data.enforceInterface(DESCRIPTOR);
                            int _arg037 = data.readInt();
                            int _arg117 = data.readInt();
                            onError(_arg037, _arg117);
                            return true;
                        case TRANSACTION_onNaviStatus /* 38 */:
                            data.enforceInterface(DESCRIPTOR);
                            if (data.readInt() != 0) {
                                _arg010 = NaviStatus.CREATOR.createFromParcel(data);
                            } else {
                                _arg010 = null;
                            }
                            int _arg118 = data.readInt();
                            onNaviStatus(_arg010, _arg118);
                            return true;
                        case TRANSACTION_onHomeCompanyRouteInfo /* 39 */:
                            data.enforceInterface(DESCRIPTOR);
                            if (data.readInt() != 0) {
                                _arg011 = HomeCompanyRouteInfo.CREATOR.createFromParcel(data);
                            } else {
                                _arg011 = null;
                            }
                            int _arg119 = data.readInt();
                            onHomeCompanyRouteInfo(_arg011, _arg119);
                            return true;
                        default:
                            return super.onTransact(code, data, reply, flags);
                    }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements IContextInfoEventListener {
            public static IContextInfoEventListener sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onAccelerationEvent(float accelerationValue) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeFloat(accelerationValue);
                    boolean _status = this.mRemote.transact(1, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onAccelerationEvent(accelerationValue);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onAngularVelocityEvent(float angularVelocityValue) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeFloat(angularVelocityValue);
                    boolean _status = this.mRemote.transact(2, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onAngularVelocityEvent(angularVelocityValue);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onManeuverEvent(Maneuver maneuver, int msgType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (maneuver != null) {
                        _data.writeInt(1);
                        maneuver.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(msgType);
                    boolean _status = this.mRemote.transact(3, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onManeuverEvent(maneuver, msgType);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onRemainInfoEvent(RemainInfo remainInfo, int msgType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (remainInfo != null) {
                        _data.writeInt(1);
                        remainInfo.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(msgType);
                    boolean _status = this.mRemote.transact(4, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onRemainInfoEvent(remainInfo, msgType);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onNaviEvent(Navi navi, int msgType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (navi != null) {
                        _data.writeInt(1);
                        navi.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(msgType);
                    boolean _status = this.mRemote.transact(5, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onNaviEvent(navi, msgType);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onLaneEvent(Lane lane, int msgType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (lane != null) {
                        _data.writeInt(1);
                        lane.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(msgType);
                    boolean _status = this.mRemote.transact(6, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onLaneEvent(lane, msgType);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onCameraEvent(Camera camera, int msgType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (camera != null) {
                        _data.writeInt(1);
                        camera.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(msgType);
                    boolean _status = this.mRemote.transact(7, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onCameraEvent(camera, msgType);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onCameraIntervalEvent(CameraInterval cameraInterval, int msgType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (cameraInterval != null) {
                        _data.writeInt(1);
                        cameraInterval.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(msgType);
                    boolean _status = this.mRemote.transact(8, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onCameraIntervalEvent(cameraInterval, msgType);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onSapaEvent(Sapa sapa, int msgType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (sapa != null) {
                        _data.writeInt(1);
                        sapa.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(msgType);
                    boolean _status = this.mRemote.transact(9, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onSapaEvent(sapa, msgType);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onCrossEvent(Cross cross, int msgType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (cross != null) {
                        _data.writeInt(1);
                        cross.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(msgType);
                    boolean _status = this.mRemote.transact(10, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onCrossEvent(cross, msgType);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onLocationEvent(Location location, int msgType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (location != null) {
                        _data.writeInt(1);
                        location.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(msgType);
                    boolean _status = this.mRemote.transact(11, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onLocationEvent(location, msgType);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onNavigationInfo(String navInfo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(navInfo);
                    boolean _status = this.mRemote.transact(12, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onNavigationInfo(navInfo);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onNavigationEnable(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enable ? 1 : 0);
                    boolean _status = this.mRemote.transact(13, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onNavigationEnable(enable);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onMsgEvent(int msgType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(msgType);
                    boolean _status = this.mRemote.transact(14, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onMsgEvent(msgType);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onWeatherInfo(String weatherInfo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(weatherInfo);
                    boolean _status = this.mRemote.transact(15, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onWeatherInfo(weatherInfo);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onGearChanged(int gear) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(gear);
                    boolean _status = this.mRemote.transact(16, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onGearChanged(gear);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onCarSpeed(float speed) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeFloat(speed);
                    boolean _status = this.mRemote.transact(17, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onCarSpeed(speed);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onIGStatus(int status) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(status);
                    boolean _status = this.mRemote.transact(18, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onIGStatus(status);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onAutoBrightness(int lux, int autolight) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(lux);
                    _data.writeInt(autolight);
                    boolean _status = this.mRemote.transact(19, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onAutoBrightness(lux, autolight);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onXPilotWarning(int type, int status) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(type);
                    _data.writeInt(status);
                    boolean _status = this.mRemote.transact(20, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onXPilotWarning(type, status);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onAvpWifi(int status) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(status);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_onAvpWifi, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onAvpWifi(status);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onRemoteCommand(int remoteCmd) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(remoteCmd);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_onRemoteCommand, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onRemoteCommand(remoteCmd);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onLLUStatus(int type, int status) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(type);
                    _data.writeInt(status);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_onLLUStatus, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onLLUStatus(type, status);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onATLSStatus(int type, int status) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(type);
                    _data.writeInt(status);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_onATLSStatus, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onATLSStatus(type, status);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onBeltStatus(int status) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(status);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_onBeltStatus, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onBeltStatus(status);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onPowerAction(int powerAction) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(powerAction);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_onPowerAction, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onPowerAction(powerAction);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onChargingGunStatus(int status) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(status);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_onChargingGunStatus, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onChargingGunStatus(status);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onDeviceChargeStatus(int status) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(status);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_onDeviceChargeStatus, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onDeviceChargeStatus(status);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onDriverSeatStatus(int status) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(status);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_onDriverSeatStatus, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onDriverSeatStatus(status);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onBcmLightMode(int type, int mode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(type);
                    _data.writeInt(mode);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_onBcmLightMode, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onBcmLightMode(type, mode);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onVpmEvent(int type, int mode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(type);
                    _data.writeInt(mode);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_onVpmEvent, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onVpmEvent(type, mode);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onPsdMoto(int status) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(status);
                    boolean _status = this.mRemote.transact(32, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onPsdMoto(status);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onPowerOffCount(int cnt) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(cnt);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_onPowerOffCount, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onPowerOffCount(cnt);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onCommonEvent(int eventType, int eventValue) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eventType);
                    _data.writeInt(eventValue);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_onCommonEvent, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onCommonEvent(eventType, eventValue);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onError(int errorCode, int operation) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(errorCode);
                    _data.writeInt(operation);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_onError, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onError(errorCode, operation);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onNaviStatus(NaviStatus naviStatus, int msgType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (naviStatus != null) {
                        _data.writeInt(1);
                        naviStatus.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(msgType);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_onNaviStatus, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onNaviStatus(naviStatus, msgType);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener
            public void onHomeCompanyRouteInfo(HomeCompanyRouteInfo info, int msgType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (info != null) {
                        _data.writeInt(1);
                        info.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(msgType);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_onHomeCompanyRouteInfo, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onHomeCompanyRouteInfo(info, msgType);
                    }
                } finally {
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IContextInfoEventListener impl) {
            if (Proxy.sDefaultImpl == null && impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static IContextInfoEventListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
