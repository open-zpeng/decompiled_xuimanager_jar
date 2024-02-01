package com.xiaopeng.xuimanager;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public interface IXUIService extends IInterface {
    IBinder getXUIService(String str) throws RemoteException;

    void nativeCall() throws RemoteException;

    void registerObserver(IBinder iBinder) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IXUIService {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.IXUIService";
        static final int TRANSACTION_getXUIService = 1;
        static final int TRANSACTION_nativeCall = 2;
        static final int TRANSACTION_registerObserver = 3;

        public Stub() {
            attachInterface(this, "com.xiaopeng.xuimanager.IXUIService");
        }

        public static IXUIService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface("com.xiaopeng.xuimanager.IXUIService");
            if (iin != null && (iin instanceof IXUIService)) {
                return (IXUIService) iin;
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
                reply.writeString("com.xiaopeng.xuimanager.IXUIService");
                return true;
            }
            switch (code) {
                case 1:
                    data.enforceInterface("com.xiaopeng.xuimanager.IXUIService");
                    String _arg0 = data.readString();
                    IBinder _result = getXUIService(_arg0);
                    reply.writeNoException();
                    reply.writeStrongBinder(_result);
                    return true;
                case 2:
                    data.enforceInterface("com.xiaopeng.xuimanager.IXUIService");
                    nativeCall();
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.xiaopeng.xuimanager.IXUIService");
                    IBinder _arg02 = data.readStrongBinder();
                    registerObserver(_arg02);
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* loaded from: classes.dex */
        private static class Proxy implements IXUIService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.xiaopeng.xuimanager.IXUIService";
            }

            @Override // com.xiaopeng.xuimanager.IXUIService
            public IBinder getXUIService(String serviceName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.xiaopeng.xuimanager.IXUIService");
                    _data.writeString(serviceName);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    IBinder _result = _reply.readStrongBinder();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.IXUIService
            public void nativeCall() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.xiaopeng.xuimanager.IXUIService");
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.IXUIService
            public void registerObserver(IBinder binder) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.xiaopeng.xuimanager.IXUIService");
                    _data.writeStrongBinder(binder);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}
