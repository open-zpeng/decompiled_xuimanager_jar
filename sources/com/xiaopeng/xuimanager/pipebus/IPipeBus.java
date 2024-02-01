package com.xiaopeng.xuimanager.pipebus;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.xuimanager.pipebus.IPipeBusListener;

/* loaded from: classes.dex */
public interface IPipeBus extends IInterface {
    int ioControl(String str, String str2, String[] strArr) throws RemoteException;

    int ioControlWithParcelable(String str, String str2, ParcelableContainer parcelableContainer, ParcelableContainer parcelableContainer2) throws RemoteException;

    int ioControlWithPocket(String str, String str2, String[] strArr, String[] strArr2) throws RemoteException;

    void registerListener(IPipeBusListener iPipeBusListener) throws RemoteException;

    void registerListenerEx(String str, IPipeBusListener iPipeBusListener) throws RemoteException;

    void unRegisterListener(IPipeBusListener iPipeBusListener) throws RemoteException;

    void unRegisterListenerEx(String str) throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements IPipeBus {
        @Override // com.xiaopeng.xuimanager.pipebus.IPipeBus
        public int ioControl(String module, String cmd, String[] params) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.pipebus.IPipeBus
        public int ioControlWithPocket(String module, String cmd, String[] params, String[] results) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.pipebus.IPipeBus
        public int ioControlWithParcelable(String moduleName, String cmd, ParcelableContainer dataIn, ParcelableContainer dataOut) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.pipebus.IPipeBus
        public void registerListener(IPipeBusListener listener) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.pipebus.IPipeBus
        public void unRegisterListener(IPipeBusListener listener) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.pipebus.IPipeBus
        public void registerListenerEx(String moduleName, IPipeBusListener listener) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.pipebus.IPipeBus
        public void unRegisterListenerEx(String moduleName) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IPipeBus {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.pipebus.IPipeBus";
        static final int TRANSACTION_ioControl = 1;
        static final int TRANSACTION_ioControlWithParcelable = 3;
        static final int TRANSACTION_ioControlWithPocket = 2;
        static final int TRANSACTION_registerListener = 4;
        static final int TRANSACTION_registerListenerEx = 6;
        static final int TRANSACTION_unRegisterListener = 5;
        static final int TRANSACTION_unRegisterListenerEx = 7;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPipeBus asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IPipeBus)) {
                return (IPipeBus) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String[] _arg3;
            ParcelableContainer _arg2;
            if (code == 1598968902) {
                reply.writeString(DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg0 = data.readString();
                    String _arg1 = data.readString();
                    String[] _arg22 = data.createStringArray();
                    int _result = ioControl(_arg0, _arg1, _arg22);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg02 = data.readString();
                    String _arg12 = data.readString();
                    String[] _arg23 = data.createStringArray();
                    int _arg3_length = data.readInt();
                    if (_arg3_length < 0) {
                        _arg3 = null;
                    } else {
                        _arg3 = new String[_arg3_length];
                    }
                    int _result2 = ioControlWithPocket(_arg02, _arg12, _arg23, _arg3);
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    reply.writeStringArray(_arg3);
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg03 = data.readString();
                    String _arg13 = data.readString();
                    if (data.readInt() != 0) {
                        _arg2 = ParcelableContainer.CREATOR.createFromParcel(data);
                    } else {
                        _arg2 = null;
                    }
                    ParcelableContainer _arg32 = new ParcelableContainer();
                    int _result3 = ioControlWithParcelable(_arg03, _arg13, _arg2, _arg32);
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    reply.writeInt(1);
                    _arg32.writeToParcel(reply, 1);
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    IPipeBusListener _arg04 = IPipeBusListener.Stub.asInterface(data.readStrongBinder());
                    registerListener(_arg04);
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    IPipeBusListener _arg05 = IPipeBusListener.Stub.asInterface(data.readStrongBinder());
                    unRegisterListener(_arg05);
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg06 = data.readString();
                    IPipeBusListener _arg14 = IPipeBusListener.Stub.asInterface(data.readStrongBinder());
                    registerListenerEx(_arg06, _arg14);
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg07 = data.readString();
                    unRegisterListenerEx(_arg07);
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements IPipeBus {
            public static IPipeBus sDefaultImpl;
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

            @Override // com.xiaopeng.xuimanager.pipebus.IPipeBus
            public int ioControl(String module, String cmd, String[] params) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(module);
                    _data.writeString(cmd);
                    _data.writeStringArray(params);
                    boolean _status = this.mRemote.transact(1, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().ioControl(module, cmd, params);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.pipebus.IPipeBus
            public int ioControlWithPocket(String module, String cmd, String[] params, String[] results) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(module);
                    _data.writeString(cmd);
                    _data.writeStringArray(params);
                    if (results == null) {
                        _data.writeInt(-1);
                    } else {
                        _data.writeInt(results.length);
                    }
                    boolean _status = this.mRemote.transact(2, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().ioControlWithPocket(module, cmd, params, results);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    _reply.readStringArray(results);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.pipebus.IPipeBus
            public int ioControlWithParcelable(String moduleName, String cmd, ParcelableContainer dataIn, ParcelableContainer dataOut) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(moduleName);
                    _data.writeString(cmd);
                    if (dataIn != null) {
                        _data.writeInt(1);
                        dataIn.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    boolean _status = this.mRemote.transact(3, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().ioControlWithParcelable(moduleName, cmd, dataIn, dataOut);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    if (_reply.readInt() != 0) {
                        dataOut.readFromParcel(_reply);
                    }
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.pipebus.IPipeBus
            public void registerListener(IPipeBusListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = this.mRemote.transact(4, _data, _reply, 0);
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

            @Override // com.xiaopeng.xuimanager.pipebus.IPipeBus
            public void unRegisterListener(IPipeBusListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = this.mRemote.transact(5, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unRegisterListener(listener);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.pipebus.IPipeBus
            public void registerListenerEx(String moduleName, IPipeBusListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(moduleName);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = this.mRemote.transact(6, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerListenerEx(moduleName, listener);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.pipebus.IPipeBus
            public void unRegisterListenerEx(String moduleName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(moduleName);
                    boolean _status = this.mRemote.transact(7, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unRegisterListenerEx(moduleName);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IPipeBus impl) {
            if (Proxy.sDefaultImpl == null && impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static IPipeBus getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
