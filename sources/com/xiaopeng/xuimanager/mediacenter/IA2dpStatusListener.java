package com.xiaopeng.xuimanager.mediacenter;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IA2dpStatusListener extends IInterface {
    void onA2dpConnected() throws RemoteException;

    void onA2dpDisconnected() throws RemoteException;

    void onA2dpServiceReady() throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements IA2dpStatusListener {
        @Override // com.xiaopeng.xuimanager.mediacenter.IA2dpStatusListener
        public void onA2dpServiceReady() throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.IA2dpStatusListener
        public void onA2dpConnected() throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.IA2dpStatusListener
        public void onA2dpDisconnected() throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IA2dpStatusListener {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.mediacenter.IA2dpStatusListener";
        static final int TRANSACTION_onA2dpConnected = 2;
        static final int TRANSACTION_onA2dpDisconnected = 3;
        static final int TRANSACTION_onA2dpServiceReady = 1;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IA2dpStatusListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IA2dpStatusListener)) {
                return (IA2dpStatusListener) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code == 1) {
                data.enforceInterface(DESCRIPTOR);
                onA2dpServiceReady();
                reply.writeNoException();
                return true;
            } else if (code == 2) {
                data.enforceInterface(DESCRIPTOR);
                onA2dpConnected();
                reply.writeNoException();
                return true;
            } else if (code != 3) {
                if (code == 1598968902) {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(code, data, reply, flags);
            } else {
                data.enforceInterface(DESCRIPTOR);
                onA2dpDisconnected();
                reply.writeNoException();
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements IA2dpStatusListener {
            public static IA2dpStatusListener sDefaultImpl;
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

            @Override // com.xiaopeng.xuimanager.mediacenter.IA2dpStatusListener
            public void onA2dpServiceReady() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(1, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onA2dpServiceReady();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IA2dpStatusListener
            public void onA2dpConnected() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(2, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onA2dpConnected();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IA2dpStatusListener
            public void onA2dpDisconnected() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(3, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onA2dpDisconnected();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IA2dpStatusListener impl) {
            if (Proxy.sDefaultImpl == null && impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static IA2dpStatusListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
