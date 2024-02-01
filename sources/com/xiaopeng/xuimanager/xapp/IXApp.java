package com.xiaopeng.xuimanager.xapp;

import android.content.Intent;
import android.os.Binder;
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

    int checkAppStart(String str) throws RemoteException;

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

    void startMiniProgram(String str, String str2, Map map) throws RemoteException;

    int startXpApp(String str, Intent intent) throws RemoteException;

    void unregisterListener(IXAppEventListener iXAppEventListener) throws RemoteException;

    void unregisterMiniProgListener(IXMiniProgEventListener iXMiniProgEventListener) throws RemoteException;

    void uploadAlipayLog() throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IXApp {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.xapp.IXApp";
        static final int TRANSACTION_activeArome = 15;
        static final int TRANSACTION_attachContext = 12;
        static final int TRANSACTION_checkAppStart = 22;
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
        static final int TRANSACTION_startMiniProgram = 10;
        static final int TRANSACTION_startXpApp = 26;
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
            Intent _arg1;
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
                    setAppUsedLimitEnable(data.readInt() != 0);
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
                    _arg1 = data.readInt() != 0 ? (xpPackageInfo) xpPackageInfo.CREATOR.createFromParcel(data) : null;
                    onAppModeChanged(_arg03, _arg1);
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
                    String _arg12 = data.readString();
                    ClassLoader cl = getClass().getClassLoader();
                    Map _arg2 = data.readHashMap(cl);
                    startMiniProgram(_arg07, _arg12, _arg2);
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
                    boolean _arg13 = data.readInt() != 0;
                    preloadApp(_arg010, _arg13);
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
                case TRANSACTION_startXpApp /* 26 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg015 = data.readString();
                    _arg1 = data.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(data) : null;
                    int _result6 = startXpApp(_arg015, _arg1);
                    reply.writeNoException();
                    reply.writeInt(_result6);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* loaded from: classes.dex */
        private static class Proxy implements IXApp {
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
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
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
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
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
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
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
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
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
                    this.mRemote.transact(5, _data, _reply, 0);
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
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
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
                    this.mRemote.transact(7, _data, _reply, 0);
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
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
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
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
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
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
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
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
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
                    this.mRemote.transact(12, _data, _reply, 0);
                    _reply.readException();
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
                    this.mRemote.transact(13, _data, _reply, 0);
                    _reply.readException();
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
                    this.mRemote.transact(14, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
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
                    this.mRemote.transact(15, _data, _reply, 0);
                    _reply.readException();
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
                    this.mRemote.transact(16, _data, _reply, 0);
                    _reply.readException();
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
                    this.mRemote.transact(17, _data, _reply, 0);
                    _reply.readException();
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
                    this.mRemote.transact(18, _data, _reply, 0);
                    _reply.readException();
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
                    this.mRemote.transact(19, _data, _reply, 0);
                    _reply.readException();
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
                    this.mRemote.transact(20, _data, _reply, 0);
                    _reply.readException();
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
                    this.mRemote.transact(Stub.TRANSACTION_uploadAlipayLog, _data, _reply, 0);
                    _reply.readException();
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
                    this.mRemote.transact(Stub.TRANSACTION_checkAppStart, _data, _reply, 0);
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
                    this.mRemote.transact(Stub.TRANSACTION_getAppType, _data, _reply, 0);
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
                    this.mRemote.transact(Stub.TRANSACTION_getInstalledAppList, _data, _reply, 0);
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
                    this.mRemote.transact(Stub.TRANSACTION_closeCancelableDialog, _data, _reply, 0);
                    _reply.readException();
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
                    this.mRemote.transact(Stub.TRANSACTION_startXpApp, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}
