package com.xiaopeng.xuimanager.xapp;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.app.xpPackageInfo;
import com.xiaopeng.xuimanager.xapp.IXAppEventListener;
import com.xiaopeng.xuimanager.xapp.IXMiniProgEventListener;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public interface IXApp extends IInterface {
    void activeArome(Map map) throws RemoteException;

    void attachContext() throws RemoteException;

    int checkAppPolicy(String str, Bundle bundle) throws RemoteException;

    int checkAppStart(String str) throws RemoteException;

    void checkIdentityValid(String str) throws RemoteException;

    boolean checkOrderValid(String str) throws RemoteException;

    void closeCancelableDialog() throws RemoteException;

    void exitApp(String str) throws RemoteException;

    int getAppType(String str) throws RemoteException;

    boolean getAppUsedLimitEnable() throws RemoteException;

    int getCarGearLevel() throws RemoteException;

    List<String> getInstalledAppList(int i) throws RemoteException;

    void initService() throws RemoteException;

    boolean isServiceOnline() throws RemoteException;

    void loginAccount() throws RemoteException;

    void logoutAccount() throws RemoteException;

    int onAppConfigUpload(String str, String str2) throws RemoteException;

    void onAppModeChanged(String str, xpPackageInfo xppackageinfo) throws RemoteException;

    void preloadApp(String str, boolean z) throws RemoteException;

    void registerListener(IXAppEventListener iXAppEventListener) throws RemoteException;

    void registerMiniProgListener(IXMiniProgEventListener iXMiniProgEventListener) throws RemoteException;

    void requestLoginInfo() throws RemoteException;

    void requestMiniList(String str) throws RemoteException;

    void setAppUsedLimitEnable(boolean z) throws RemoteException;

    void startCustomService(String str, String str2) throws RemoteException;

    void startMiniProgram(String str, String str2, Map map) throws RemoteException;

    int startXpApp(String str, Intent intent) throws RemoteException;

    void unregisterListener(IXAppEventListener iXAppEventListener) throws RemoteException;

    void unregisterMiniProgListener(IXMiniProgEventListener iXMiniProgEventListener) throws RemoteException;

    void uploadAlipayLog() throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements IXApp {
        @Override // com.xiaopeng.xuimanager.xapp.IXApp
        public void registerListener(IXAppEventListener listener) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.xapp.IXApp
        public void unregisterListener(IXAppEventListener listener) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.xapp.IXApp
        public void setAppUsedLimitEnable(boolean enable) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.xapp.IXApp
        public boolean getAppUsedLimitEnable() throws RemoteException {
            return false;
        }

        @Override // com.xiaopeng.xuimanager.xapp.IXApp
        public int getCarGearLevel() throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.xapp.IXApp
        public void onAppModeChanged(String pkgName, xpPackageInfo info) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.xapp.IXApp
        public int onAppConfigUpload(String pkgName, String config) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.xapp.IXApp
        public void registerMiniProgListener(IXMiniProgEventListener listener) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.xapp.IXApp
        public void unregisterMiniProgListener(IXMiniProgEventListener listener) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.xapp.IXApp
        public void startMiniProgram(String id, String name, Map params) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.xapp.IXApp
        public void logoutAccount() throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.xapp.IXApp
        public void attachContext() throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.xapp.IXApp
        public void initService() throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.xapp.IXApp
        public boolean isServiceOnline() throws RemoteException {
            return false;
        }

        @Override // com.xiaopeng.xuimanager.xapp.IXApp
        public void activeArome(Map pamams) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.xapp.IXApp
        public void loginAccount() throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.xapp.IXApp
        public void exitApp(String id) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.xapp.IXApp
        public void preloadApp(String appId, boolean loadToMemory) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.xapp.IXApp
        public void requestLoginInfo() throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.xapp.IXApp
        public void requestMiniList(String alipayVersion) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.xapp.IXApp
        public void uploadAlipayLog() throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.xapp.IXApp
        public int checkAppStart(String packageName) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.xapp.IXApp
        public int getAppType(String packageName) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.xapp.IXApp
        public List<String> getInstalledAppList(int appType) throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.xapp.IXApp
        public void closeCancelableDialog() throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.xapp.IXApp
        public void checkIdentityValid(String userKey) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.xapp.IXApp
        public void startCustomService(String serviceCode, String userIdentity) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.xapp.IXApp
        public boolean checkOrderValid(String orderId) throws RemoteException {
            return false;
        }

        @Override // com.xiaopeng.xuimanager.xapp.IXApp
        public int checkAppPolicy(String packageName, Bundle params) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.xapp.IXApp
        public int startXpApp(String uriParam, Intent intent) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IXApp {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.xapp.IXApp";
        static final int TRANSACTION_activeArome = 15;
        static final int TRANSACTION_attachContext = 12;
        static final int TRANSACTION_checkAppPolicy = 29;
        static final int TRANSACTION_checkAppStart = 22;
        static final int TRANSACTION_checkIdentityValid = 26;
        static final int TRANSACTION_checkOrderValid = 28;
        static final int TRANSACTION_closeCancelableDialog = 25;
        static final int TRANSACTION_exitApp = 17;
        static final int TRANSACTION_getAppType = 23;
        static final int TRANSACTION_getAppUsedLimitEnable = 4;
        static final int TRANSACTION_getCarGearLevel = 5;
        static final int TRANSACTION_getInstalledAppList = 24;
        static final int TRANSACTION_initService = 13;
        static final int TRANSACTION_isServiceOnline = 14;
        static final int TRANSACTION_loginAccount = 16;
        static final int TRANSACTION_logoutAccount = 11;
        static final int TRANSACTION_onAppConfigUpload = 7;
        static final int TRANSACTION_onAppModeChanged = 6;
        static final int TRANSACTION_preloadApp = 18;
        static final int TRANSACTION_registerListener = 1;
        static final int TRANSACTION_registerMiniProgListener = 8;
        static final int TRANSACTION_requestLoginInfo = 19;
        static final int TRANSACTION_requestMiniList = 20;
        static final int TRANSACTION_setAppUsedLimitEnable = 3;
        static final int TRANSACTION_startCustomService = 27;
        static final int TRANSACTION_startMiniProgram = 10;
        static final int TRANSACTION_startXpApp = 30;
        static final int TRANSACTION_unregisterListener = 2;
        static final int TRANSACTION_unregisterMiniProgListener = 9;
        static final int TRANSACTION_uploadAlipayLog = 21;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IXApp asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IXApp)) {
                return (IXApp) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean _arg1;
            xpPackageInfo _arg12;
            Bundle _arg13;
            Intent _arg14;
            if (code == 1598968902) {
                reply.writeString(DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    IXAppEventListener _arg0 = IXAppEventListener.Stub.asInterface(data.readStrongBinder());
                    registerListener(_arg0);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    IXAppEventListener _arg02 = IXAppEventListener.Stub.asInterface(data.readStrongBinder());
                    unregisterListener(_arg02);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    _arg1 = data.readInt() != 0;
                    setAppUsedLimitEnable(_arg1);
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    boolean appUsedLimitEnable = getAppUsedLimitEnable();
                    reply.writeNoException();
                    reply.writeInt(appUsedLimitEnable ? 1 : 0);
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    int _result = getCarGearLevel();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg03 = data.readString();
                    if (data.readInt() != 0) {
                        _arg12 = (xpPackageInfo) xpPackageInfo.CREATOR.createFromParcel(data);
                    } else {
                        _arg12 = null;
                    }
                    onAppModeChanged(_arg03, _arg12);
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg04 = data.readString();
                    int _result2 = onAppConfigUpload(_arg04, data.readString());
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    IXMiniProgEventListener _arg05 = IXMiniProgEventListener.Stub.asInterface(data.readStrongBinder());
                    registerMiniProgListener(_arg05);
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    IXMiniProgEventListener _arg06 = IXMiniProgEventListener.Stub.asInterface(data.readStrongBinder());
                    unregisterMiniProgListener(_arg06);
                    reply.writeNoException();
                    return true;
                case 10:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg07 = data.readString();
                    String _arg15 = data.readString();
                    ClassLoader cl = getClass().getClassLoader();
                    Map _arg2 = data.readHashMap(cl);
                    startMiniProgram(_arg07, _arg15, _arg2);
                    reply.writeNoException();
                    return true;
                case 11:
                    data.enforceInterface(DESCRIPTOR);
                    logoutAccount();
                    reply.writeNoException();
                    return true;
                case 12:
                    data.enforceInterface(DESCRIPTOR);
                    attachContext();
                    reply.writeNoException();
                    return true;
                case 13:
                    data.enforceInterface(DESCRIPTOR);
                    initService();
                    reply.writeNoException();
                    return true;
                case 14:
                    data.enforceInterface(DESCRIPTOR);
                    boolean isServiceOnline = isServiceOnline();
                    reply.writeNoException();
                    reply.writeInt(isServiceOnline ? 1 : 0);
                    return true;
                case 15:
                    data.enforceInterface(DESCRIPTOR);
                    ClassLoader cl2 = getClass().getClassLoader();
                    Map _arg08 = data.readHashMap(cl2);
                    activeArome(_arg08);
                    reply.writeNoException();
                    return true;
                case 16:
                    data.enforceInterface(DESCRIPTOR);
                    loginAccount();
                    reply.writeNoException();
                    return true;
                case 17:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg09 = data.readString();
                    exitApp(_arg09);
                    reply.writeNoException();
                    return true;
                case 18:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg010 = data.readString();
                    _arg1 = data.readInt() != 0;
                    preloadApp(_arg010, _arg1);
                    reply.writeNoException();
                    return true;
                case 19:
                    data.enforceInterface(DESCRIPTOR);
                    requestLoginInfo();
                    reply.writeNoException();
                    return true;
                case 20:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg011 = data.readString();
                    requestMiniList(_arg011);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_uploadAlipayLog /* 21 */:
                    data.enforceInterface(DESCRIPTOR);
                    uploadAlipayLog();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_checkAppStart /* 22 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg012 = data.readString();
                    int _result3 = checkAppStart(_arg012);
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case TRANSACTION_getAppType /* 23 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg013 = data.readString();
                    int _result4 = getAppType(_arg013);
                    reply.writeNoException();
                    reply.writeInt(_result4);
                    return true;
                case TRANSACTION_getInstalledAppList /* 24 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg014 = data.readInt();
                    List<String> _result5 = getInstalledAppList(_arg014);
                    reply.writeNoException();
                    reply.writeStringList(_result5);
                    return true;
                case TRANSACTION_closeCancelableDialog /* 25 */:
                    data.enforceInterface(DESCRIPTOR);
                    closeCancelableDialog();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_checkIdentityValid /* 26 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg015 = data.readString();
                    checkIdentityValid(_arg015);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_startCustomService /* 27 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg016 = data.readString();
                    startCustomService(_arg016, data.readString());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_checkOrderValid /* 28 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg017 = data.readString();
                    boolean checkOrderValid = checkOrderValid(_arg017);
                    reply.writeNoException();
                    reply.writeInt(checkOrderValid ? 1 : 0);
                    return true;
                case TRANSACTION_checkAppPolicy /* 29 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg018 = data.readString();
                    if (data.readInt() != 0) {
                        _arg13 = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg13 = null;
                    }
                    int _result6 = checkAppPolicy(_arg018, _arg13);
                    reply.writeNoException();
                    reply.writeInt(_result6);
                    return true;
                case TRANSACTION_startXpApp /* 30 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg019 = data.readString();
                    if (data.readInt() != 0) {
                        _arg14 = (Intent) Intent.CREATOR.createFromParcel(data);
                    } else {
                        _arg14 = null;
                    }
                    int _result7 = startXpApp(_arg019, _arg14);
                    reply.writeNoException();
                    reply.writeInt(_result7);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements IXApp {
            public static IXApp sDefaultImpl;
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

            @Override // com.xiaopeng.xuimanager.xapp.IXApp
            public void registerListener(IXAppEventListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = this.mRemote.transact(1, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerListener(listener);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.xapp.IXApp
            public void unregisterListener(IXAppEventListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = this.mRemote.transact(2, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterListener(listener);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.xapp.IXApp
            public void setAppUsedLimitEnable(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enable ? 1 : 0);
                    boolean _status = this.mRemote.transact(3, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setAppUsedLimitEnable(enable);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.xapp.IXApp
            public boolean getAppUsedLimitEnable() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(4, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAppUsedLimitEnable();
                    }
                    _reply.readException();
                    boolean _status2 = _reply.readInt() != 0;
                    return _status2;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.xapp.IXApp
            public int getCarGearLevel() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(5, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCarGearLevel();
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.xapp.IXApp
            public void onAppModeChanged(String pkgName, xpPackageInfo info) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    if (info != null) {
                        _data.writeInt(1);
                        info.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    boolean _status = this.mRemote.transact(6, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onAppModeChanged(pkgName, info);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.xapp.IXApp
            public int onAppConfigUpload(String pkgName, String config) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeString(config);
                    boolean _status = this.mRemote.transact(7, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().onAppConfigUpload(pkgName, config);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.xapp.IXApp
            public void registerMiniProgListener(IXMiniProgEventListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = this.mRemote.transact(8, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerMiniProgListener(listener);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.xapp.IXApp
            public void unregisterMiniProgListener(IXMiniProgEventListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = this.mRemote.transact(9, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterMiniProgListener(listener);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.xapp.IXApp
            public void startMiniProgram(String id, String name, Map params) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(id);
                    _data.writeString(name);
                    _data.writeMap(params);
                    boolean _status = this.mRemote.transact(10, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().startMiniProgram(id, name, params);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.xapp.IXApp
            public void logoutAccount() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(11, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().logoutAccount();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.xapp.IXApp
            public void attachContext() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(12, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().attachContext();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.xapp.IXApp
            public void initService() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(13, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().initService();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.xapp.IXApp
            public boolean isServiceOnline() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(14, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isServiceOnline();
                    }
                    _reply.readException();
                    boolean _status2 = _reply.readInt() != 0;
                    return _status2;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.xapp.IXApp
            public void activeArome(Map pamams) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeMap(pamams);
                    boolean _status = this.mRemote.transact(15, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().activeArome(pamams);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.xapp.IXApp
            public void loginAccount() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(16, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().loginAccount();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.xapp.IXApp
            public void exitApp(String id) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(id);
                    boolean _status = this.mRemote.transact(17, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().exitApp(id);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.xapp.IXApp
            public void preloadApp(String appId, boolean loadToMemory) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(appId);
                    _data.writeInt(loadToMemory ? 1 : 0);
                    boolean _status = this.mRemote.transact(18, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().preloadApp(appId, loadToMemory);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.xapp.IXApp
            public void requestLoginInfo() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(19, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().requestLoginInfo();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.xapp.IXApp
            public void requestMiniList(String alipayVersion) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(alipayVersion);
                    boolean _status = this.mRemote.transact(20, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().requestMiniList(alipayVersion);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.xapp.IXApp
            public void uploadAlipayLog() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_uploadAlipayLog, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().uploadAlipayLog();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.xapp.IXApp
            public int checkAppStart(String packageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(packageName);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_checkAppStart, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().checkAppStart(packageName);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.xapp.IXApp
            public int getAppType(String packageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(packageName);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_getAppType, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAppType(packageName);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.xapp.IXApp
            public List<String> getInstalledAppList(int appType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(appType);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_getInstalledAppList, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getInstalledAppList(appType);
                    }
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.xapp.IXApp
            public void closeCancelableDialog() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_closeCancelableDialog, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().closeCancelableDialog();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.xapp.IXApp
            public void checkIdentityValid(String userKey) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(userKey);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_checkIdentityValid, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().checkIdentityValid(userKey);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.xapp.IXApp
            public void startCustomService(String serviceCode, String userIdentity) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(serviceCode);
                    _data.writeString(userIdentity);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_startCustomService, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().startCustomService(serviceCode, userIdentity);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.xapp.IXApp
            public boolean checkOrderValid(String orderId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(orderId);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_checkOrderValid, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().checkOrderValid(orderId);
                    }
                    _reply.readException();
                    boolean _status2 = _reply.readInt() != 0;
                    return _status2;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.xapp.IXApp
            public int checkAppPolicy(String packageName, Bundle params) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(packageName);
                    if (params != null) {
                        _data.writeInt(1);
                        params.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_checkAppPolicy, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().checkAppPolicy(packageName, params);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.xapp.IXApp
            public int startXpApp(String uriParam, Intent intent) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(uriParam);
                    if (intent != null) {
                        _data.writeInt(1);
                        intent.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_startXpApp, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().startXpApp(uriParam, intent);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IXApp impl) {
            if (Proxy.sDefaultImpl == null && impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static IXApp getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
