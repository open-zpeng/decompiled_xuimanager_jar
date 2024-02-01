package com.xiaopeng.xuimanager.systemui.masklayer;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IMaskLayerListener extends IInterface {
    void dismissMaskLayer() throws RemoteException;

    void showMaskLayer(int i) throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements IMaskLayerListener {
        @Override // com.xiaopeng.xuimanager.systemui.masklayer.IMaskLayerListener
        public void showMaskLayer(int windowType) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.systemui.masklayer.IMaskLayerListener
        public void dismissMaskLayer() throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IMaskLayerListener {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.systemui.masklayer.IMaskLayerListener";
        static final int TRANSACTION_dismissMaskLayer = 2;
        static final int TRANSACTION_showMaskLayer = 1;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMaskLayerListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IMaskLayerListener)) {
                return (IMaskLayerListener) iin;
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
                int _arg0 = data.readInt();
                showMaskLayer(_arg0);
                reply.writeNoException();
                return true;
            } else if (code != 2) {
                if (code == 1598968902) {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(code, data, reply, flags);
            } else {
                data.enforceInterface(DESCRIPTOR);
                dismissMaskLayer();
                reply.writeNoException();
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements IMaskLayerListener {
            public static IMaskLayerListener sDefaultImpl;
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

            @Override // com.xiaopeng.xuimanager.systemui.masklayer.IMaskLayerListener
            public void showMaskLayer(int windowType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(windowType);
                    boolean _status = this.mRemote.transact(1, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().showMaskLayer(windowType);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.systemui.masklayer.IMaskLayerListener
            public void dismissMaskLayer() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(2, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().dismissMaskLayer();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IMaskLayerListener impl) {
            if (Proxy.sDefaultImpl == null && impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static IMaskLayerListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
