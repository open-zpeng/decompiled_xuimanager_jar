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

    int getUserScenarioStatus(String str) throws RemoteException;

    void registerBinderObserver(IBinder iBinder) throws RemoteException;

    void registerListener(IUserScenarioListener iUserScenarioListener) throws RemoteException;

    void reportStatus(String str, int i) throws RemoteException;

    String setParameters(String str, String str2) throws RemoteException;

    void unregisterListener(IUserScenarioListener iUserScenarioListener) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IUserScenario {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.userscenario.IUserScenario";
        static final int TRANSACTION_checkEnterUserScenario = 10;
        static final int TRANSACTION_enterUserScenario = 1;
        static final int TRANSACTION_enterUserScenarioWithExtra = 2;
        static final int TRANSACTION_exitUserScenario = 3;
        static final int TRANSACTION_getCurrentUserScenario = 4;
        static final int TRANSACTION_getUserScenarioStatus = 5;
        static final int TRANSACTION_registerBinderObserver = 9;
        static final int TRANSACTION_registerListener = 6;
        static final int TRANSACTION_reportStatus = 8;
        static final int TRANSACTION_setParameters = 11;
        static final int TRANSACTION_unregisterListener = 7;

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
                    String _arg04 = data.readString();
                    int _result5 = getUserScenarioStatus(_arg04);
                    reply.writeNoException();
                    reply.writeInt(_result5);
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    IUserScenarioListener _arg05 = IUserScenarioListener.Stub.asInterface(data.readStrongBinder());
                    registerListener(_arg05);
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    IUserScenarioListener _arg06 = IUserScenarioListener.Stub.asInterface(data.readStrongBinder());
                    unregisterListener(_arg06);
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg07 = data.readString();
                    int _arg13 = data.readInt();
                    reportStatus(_arg07, _arg13);
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    IBinder _arg08 = data.readStrongBinder();
                    registerBinderObserver(_arg08);
                    reply.writeNoException();
                    return true;
                case 10:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg09 = data.readString();
                    String _arg14 = data.readString();
                    String _result6 = checkEnterUserScenario(_arg09, _arg14);
                    reply.writeNoException();
                    reply.writeString(_result6);
                    return true;
                case 11:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg010 = data.readString();
                    String _arg15 = data.readString();
                    String _result7 = setParameters(_arg010, _arg15);
                    reply.writeNoException();
                    reply.writeString(_result7);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* loaded from: classes.dex */
        private static class Proxy implements IUserScenario {
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
                    this.mRemote.transact(1, _data, _reply, 0);
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
                    this.mRemote.transact(2, _data, _reply, 0);
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
                    this.mRemote.transact(3, _data, _reply, 0);
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
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
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
                    this.mRemote.transact(5, _data, _reply, 0);
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
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
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
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
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
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
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
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
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
                    this.mRemote.transact(10, _data, _reply, 0);
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
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}
