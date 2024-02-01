package com.xiaopeng.xuimanager.sysconfig;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.xuimanager.sysconfig.ISysConfigListener;
/* loaded from: classes.dex */
public interface ISysConfig extends IInterface {
    void registerSysConfigListener(ISysConfigListener iSysConfigListener) throws RemoteException;

    void unregisterSysConfigListener(ISysConfigListener iSysConfigListener) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements ISysConfig {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.sysconfig.ISysConfig";
        static final int TRANSACTION_registerSysConfigListener = 1;
        static final int TRANSACTION_unregisterSysConfigListener = 2;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISysConfig asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof ISysConfig)) {
                return (ISysConfig) iin;
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
                    ISysConfigListener _arg0 = ISysConfigListener.Stub.asInterface(data.readStrongBinder());
                    registerSysConfigListener(_arg0);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    ISysConfigListener _arg02 = ISysConfigListener.Stub.asInterface(data.readStrongBinder());
                    unregisterSysConfigListener(_arg02);
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* loaded from: classes.dex */
        private static class Proxy implements ISysConfig {
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

            @Override // com.xiaopeng.xuimanager.sysconfig.ISysConfig
            public void registerSysConfigListener(ISysConfigListener listener) throws RemoteException {
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

            @Override // com.xiaopeng.xuimanager.sysconfig.ISysConfig
            public void unregisterSysConfigListener(ISysConfigListener listener) throws RemoteException {
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
        }
    }
}
