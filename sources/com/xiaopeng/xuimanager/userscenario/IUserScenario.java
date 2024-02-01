package com.xiaopeng.xuimanager.userscenario;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.xuimanager.userscenario.IUserScenarioListener;

/* loaded from: classes.dex */
public interface IUserScenario extends IInterface {
    String checkEnterUserScenario(String str, String str2) throws RemoteException;

    String enterUserScenario(String str, String str2) throws RemoteException;

    String enterUserScenarioWithExtra(String str, String str2, String str3) throws RemoteException;

    String exitUserScenario(String str) throws RemoteException;

    String getCurrentUserScenario() throws RemoteException;

    String[] getCurrentUserScenarios() throws RemoteException;

    int getUserScenarioStatus(String str) throws RemoteException;

    void registerBinderObserver(IBinder iBinder) throws RemoteException;

    void registerBinderObserverWithData(IBinder iBinder, String str) throws RemoteException;

    void registerListener(IUserScenarioListener iUserScenarioListener) throws RemoteException;

    void reportStatus(String str, int i) throws RemoteException;

    String setParameters(String str, String str2) throws RemoteException;

    void unregisterListener(IUserScenarioListener iUserScenarioListener) throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements IUserScenario {
        @Override // com.xiaopeng.xuimanager.userscenario.IUserScenario
        public String enterUserScenario(String scenario, String source) throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.userscenario.IUserScenario
        public String enterUserScenarioWithExtra(String scenario, String source, String extra) throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.userscenario.IUserScenario
        public String exitUserScenario(String scenario) throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.userscenario.IUserScenario
        public String getCurrentUserScenario() throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.userscenario.IUserScenario
        public String[] getCurrentUserScenarios() throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.userscenario.IUserScenario
        public int getUserScenarioStatus(String scenario) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.userscenario.IUserScenario
        public void registerListener(IUserScenarioListener listener) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.userscenario.IUserScenario
        public void unregisterListener(IUserScenarioListener listener) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.userscenario.IUserScenario
        public void reportStatus(String scenario, int status) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.userscenario.IUserScenario
        public void registerBinderObserver(IBinder binder) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.userscenario.IUserScenario
        public void registerBinderObserverWithData(IBinder binder, String data) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.userscenario.IUserScenario
        public String checkEnterUserScenario(String scenario, String source) throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.userscenario.IUserScenario
        public String setParameters(String scenario, String jsonStr) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IUserScenario {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.userscenario.IUserScenario";
        static final int TRANSACTION_checkEnterUserScenario = 12;
        static final int TRANSACTION_enterUserScenario = 1;
        static final int TRANSACTION_enterUserScenarioWithExtra = 2;
        static final int TRANSACTION_exitUserScenario = 3;
        static final int TRANSACTION_getCurrentUserScenario = 4;
        static final int TRANSACTION_getCurrentUserScenarios = 5;
        static final int TRANSACTION_getUserScenarioStatus = 6;
        static final int TRANSACTION_registerBinderObserver = 10;
        static final int TRANSACTION_registerBinderObserverWithData = 11;
        static final int TRANSACTION_registerListener = 7;
        static final int TRANSACTION_reportStatus = 9;
        static final int TRANSACTION_setParameters = 13;
        static final int TRANSACTION_unregisterListener = 8;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IUserScenario asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IUserScenario)) {
                return (IUserScenario) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code == 1598968902) {
                reply.writeString(DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg0 = data.readString();
                    String _arg1 = data.readString();
                    String _result = enterUserScenario(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeString(_result);
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg02 = data.readString();
                    String _arg12 = data.readString();
                    String _arg2 = data.readString();
                    String _result2 = enterUserScenarioWithExtra(_arg02, _arg12, _arg2);
                    reply.writeNoException();
                    reply.writeString(_result2);
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg03 = data.readString();
                    String _result3 = exitUserScenario(_arg03);
                    reply.writeNoException();
                    reply.writeString(_result3);
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    String _result4 = getCurrentUserScenario();
                    reply.writeNoException();
                    reply.writeString(_result4);
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    String[] _result5 = getCurrentUserScenarios();
                    reply.writeNoException();
                    reply.writeStringArray(_result5);
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg04 = data.readString();
                    int _result6 = getUserScenarioStatus(_arg04);
                    reply.writeNoException();
                    reply.writeInt(_result6);
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    IUserScenarioListener _arg05 = IUserScenarioListener.Stub.asInterface(data.readStrongBinder());
                    registerListener(_arg05);
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    IUserScenarioListener _arg06 = IUserScenarioListener.Stub.asInterface(data.readStrongBinder());
                    unregisterListener(_arg06);
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg07 = data.readString();
                    int _arg13 = data.readInt();
                    reportStatus(_arg07, _arg13);
                    reply.writeNoException();
                    return true;
                case 10:
                    data.enforceInterface(DESCRIPTOR);
                    IBinder _arg08 = data.readStrongBinder();
                    registerBinderObserver(_arg08);
                    reply.writeNoException();
                    return true;
                case 11:
                    data.enforceInterface(DESCRIPTOR);
                    IBinder _arg09 = data.readStrongBinder();
                    String _arg14 = data.readString();
                    registerBinderObserverWithData(_arg09, _arg14);
                    reply.writeNoException();
                    return true;
                case 12:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg010 = data.readString();
                    String _arg15 = data.readString();
                    String _result7 = checkEnterUserScenario(_arg010, _arg15);
                    reply.writeNoException();
                    reply.writeString(_result7);
                    return true;
                case 13:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg011 = data.readString();
                    String _arg16 = data.readString();
                    String _result8 = setParameters(_arg011, _arg16);
                    reply.writeNoException();
                    reply.writeString(_result8);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements IUserScenario {
            public static IUserScenario sDefaultImpl;
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

            @Override // com.xiaopeng.xuimanager.userscenario.IUserScenario
            public String enterUserScenario(String scenario, String source) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(scenario);
                    _data.writeString(source);
                    boolean _status = this.mRemote.transact(1, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().enterUserScenario(scenario, source);
                    }
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.userscenario.IUserScenario
            public String enterUserScenarioWithExtra(String scenario, String source, String extra) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(scenario);
                    _data.writeString(source);
                    _data.writeString(extra);
                    boolean _status = this.mRemote.transact(2, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().enterUserScenarioWithExtra(scenario, source, extra);
                    }
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.userscenario.IUserScenario
            public String exitUserScenario(String scenario) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(scenario);
                    boolean _status = this.mRemote.transact(3, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().exitUserScenario(scenario);
                    }
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.userscenario.IUserScenario
            public String getCurrentUserScenario() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(4, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCurrentUserScenario();
                    }
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.userscenario.IUserScenario
            public String[] getCurrentUserScenarios() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(5, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCurrentUserScenarios();
                    }
                    _reply.readException();
                    String[] _result = _reply.createStringArray();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.userscenario.IUserScenario
            public int getUserScenarioStatus(String scenario) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(scenario);
                    boolean _status = this.mRemote.transact(6, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getUserScenarioStatus(scenario);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.userscenario.IUserScenario
            public void registerListener(IUserScenarioListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = this.mRemote.transact(7, _data, _reply, 0);
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

            @Override // com.xiaopeng.xuimanager.userscenario.IUserScenario
            public void unregisterListener(IUserScenarioListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = this.mRemote.transact(8, _data, _reply, 0);
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

            @Override // com.xiaopeng.xuimanager.userscenario.IUserScenario
            public void reportStatus(String scenario, int status) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(scenario);
                    _data.writeInt(status);
                    boolean _status = this.mRemote.transact(9, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().reportStatus(scenario, status);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.userscenario.IUserScenario
            public void registerBinderObserver(IBinder binder) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(binder);
                    boolean _status = this.mRemote.transact(10, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerBinderObserver(binder);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.userscenario.IUserScenario
            public void registerBinderObserverWithData(IBinder binder, String data) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(binder);
                    _data.writeString(data);
                    boolean _status = this.mRemote.transact(11, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerBinderObserverWithData(binder, data);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.userscenario.IUserScenario
            public String checkEnterUserScenario(String scenario, String source) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(scenario);
                    _data.writeString(source);
                    boolean _status = this.mRemote.transact(12, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().checkEnterUserScenario(scenario, source);
                    }
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.userscenario.IUserScenario
            public String setParameters(String scenario, String jsonStr) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(scenario);
                    _data.writeString(jsonStr);
                    boolean _status = this.mRemote.transact(13, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setParameters(scenario, jsonStr);
                    }
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IUserScenario impl) {
            if (Proxy.sDefaultImpl == null && impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static IUserScenario getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
