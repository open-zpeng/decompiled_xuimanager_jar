package com.xiaopeng.xuimanager.xapp;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IXMiniProgEventListener extends IInterface {
    void onMiniProgCallBack(int i, MiniProgramResponse miniProgramResponse) throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements IXMiniProgEventListener {
        @Override // com.xiaopeng.xuimanager.xapp.IXMiniProgEventListener
        public void onMiniProgCallBack(int type, MiniProgramResponse response) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IXMiniProgEventListener {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.xapp.IXMiniProgEventListener";
        static final int TRANSACTION_onMiniProgCallBack = 1;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IXMiniProgEventListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IXMiniProgEventListener)) {
                return (IXMiniProgEventListener) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            MiniProgramResponse _arg1;
            if (code != 1) {
                if (code == 1598968902) {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(code, data, reply, flags);
            }
            data.enforceInterface(DESCRIPTOR);
            int _arg0 = data.readInt();
            if (data.readInt() != 0) {
                _arg1 = MiniProgramResponse.CREATOR.createFromParcel(data);
            } else {
                _arg1 = null;
            }
            onMiniProgCallBack(_arg0, _arg1);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements IXMiniProgEventListener {
            public static IXMiniProgEventListener sDefaultImpl;
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

            @Override // com.xiaopeng.xuimanager.xapp.IXMiniProgEventListener
            public void onMiniProgCallBack(int type, MiniProgramResponse response) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(type);
                    if (response != null) {
                        _data.writeInt(1);
                        response.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    boolean _status = this.mRemote.transact(1, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onMiniProgCallBack(type, response);
                    }
                } finally {
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IXMiniProgEventListener impl) {
            if (Proxy.sDefaultImpl == null && impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static IXMiniProgEventListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
