package com.xiaopeng.xuimanager.mediacenter;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IModeChangedListener extends IInterface {
    void onModeChanged(int i) throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements IModeChangedListener {
        @Override // com.xiaopeng.xuimanager.mediacenter.IModeChangedListener
        public void onModeChanged(int currentMode) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IModeChangedListener {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.mediacenter.IModeChangedListener";
        static final int TRANSACTION_onModeChanged = 1;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IModeChangedListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IModeChangedListener)) {
                return (IModeChangedListener) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code != 1) {
                if (code == 1598968902) {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(code, data, reply, flags);
            }
            data.enforceInterface(DESCRIPTOR);
            int _arg0 = data.readInt();
            onModeChanged(_arg0);
            reply.writeNoException();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements IModeChangedListener {
            public static IModeChangedListener sDefaultImpl;
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

            @Override // com.xiaopeng.xuimanager.mediacenter.IModeChangedListener
            public void onModeChanged(int currentMode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(currentMode);
                    boolean _status = this.mRemote.transact(1, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onModeChanged(currentMode);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IModeChangedListener impl) {
            if (Proxy.sDefaultImpl == null && impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static IModeChangedListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
