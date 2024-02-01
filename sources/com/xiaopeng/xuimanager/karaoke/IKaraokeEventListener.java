package com.xiaopeng.xuimanager.karaoke;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IKaraokeEventListener extends IInterface {
    void MicDevChangeCallBack(int i) throws RemoteException;

    void onError(int i, int i2) throws RemoteException;

    void volumeEffectCallBack(int i, int i2) throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements IKaraokeEventListener {
        @Override // com.xiaopeng.xuimanager.karaoke.IKaraokeEventListener
        public void MicDevChangeCallBack(int event) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraokeEventListener
        public void onError(int errorCode, int operation) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraokeEventListener
        public void volumeEffectCallBack(int type, int value) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IKaraokeEventListener {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.karaoke.IKaraokeEventListener";
        static final int TRANSACTION_MicDevChangeCallBack = 1;
        static final int TRANSACTION_onError = 2;
        static final int TRANSACTION_volumeEffectCallBack = 3;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IKaraokeEventListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IKaraokeEventListener)) {
                return (IKaraokeEventListener) iin;
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
                MicDevChangeCallBack(_arg0);
                return true;
            } else if (code == 2) {
                data.enforceInterface(DESCRIPTOR);
                int _arg02 = data.readInt();
                int _arg1 = data.readInt();
                onError(_arg02, _arg1);
                return true;
            } else if (code != 3) {
                if (code == 1598968902) {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(code, data, reply, flags);
            } else {
                data.enforceInterface(DESCRIPTOR);
                int _arg03 = data.readInt();
                int _arg12 = data.readInt();
                volumeEffectCallBack(_arg03, _arg12);
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements IKaraokeEventListener {
            public static IKaraokeEventListener sDefaultImpl;
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

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraokeEventListener
            public void MicDevChangeCallBack(int event) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(event);
                    boolean _status = this.mRemote.transact(1, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().MicDevChangeCallBack(event);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraokeEventListener
            public void onError(int errorCode, int operation) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(errorCode);
                    _data.writeInt(operation);
                    boolean _status = this.mRemote.transact(2, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onError(errorCode, operation);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraokeEventListener
            public void volumeEffectCallBack(int type, int value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(type);
                    _data.writeInt(value);
                    boolean _status = this.mRemote.transact(3, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().volumeEffectCallBack(type, value);
                    }
                } finally {
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IKaraokeEventListener impl) {
            if (Proxy.sDefaultImpl == null && impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static IKaraokeEventListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
