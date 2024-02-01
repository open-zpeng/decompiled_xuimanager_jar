package com.xiaopeng.xuimanager.musicrecognize;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IMusicRecognizeEventListener extends IInterface {
    void onError(int i, int i2) throws RemoteException;

    void onFindCoverEvent(String str) throws RemoteException;

    void onRecognizeEvent(MusicRecognizeEvent musicRecognizeEvent) throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements IMusicRecognizeEventListener {
        @Override // com.xiaopeng.xuimanager.musicrecognize.IMusicRecognizeEventListener
        public void onFindCoverEvent(String coverUrl) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.musicrecognize.IMusicRecognizeEventListener
        public void onRecognizeEvent(MusicRecognizeEvent event) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.musicrecognize.IMusicRecognizeEventListener
        public void onError(int errorCode, int operation) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IMusicRecognizeEventListener {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.musicrecognize.IMusicRecognizeEventListener";
        static final int TRANSACTION_onError = 3;
        static final int TRANSACTION_onFindCoverEvent = 1;
        static final int TRANSACTION_onRecognizeEvent = 2;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMusicRecognizeEventListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IMusicRecognizeEventListener)) {
                return (IMusicRecognizeEventListener) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            MusicRecognizeEvent _arg0;
            if (code == 1) {
                data.enforceInterface(DESCRIPTOR);
                String _arg02 = data.readString();
                onFindCoverEvent(_arg02);
                return true;
            } else if (code == 2) {
                data.enforceInterface(DESCRIPTOR);
                if (data.readInt() != 0) {
                    _arg0 = MusicRecognizeEvent.CREATOR.createFromParcel(data);
                } else {
                    _arg0 = null;
                }
                onRecognizeEvent(_arg0);
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
                int _arg1 = data.readInt();
                onError(_arg03, _arg1);
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements IMusicRecognizeEventListener {
            public static IMusicRecognizeEventListener sDefaultImpl;
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

            @Override // com.xiaopeng.xuimanager.musicrecognize.IMusicRecognizeEventListener
            public void onFindCoverEvent(String coverUrl) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(coverUrl);
                    boolean _status = this.mRemote.transact(1, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onFindCoverEvent(coverUrl);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.musicrecognize.IMusicRecognizeEventListener
            public void onRecognizeEvent(MusicRecognizeEvent event) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (event != null) {
                        _data.writeInt(1);
                        event.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    boolean _status = this.mRemote.transact(2, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onRecognizeEvent(event);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.musicrecognize.IMusicRecognizeEventListener
            public void onError(int errorCode, int operation) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(errorCode);
                    _data.writeInt(operation);
                    boolean _status = this.mRemote.transact(3, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onError(errorCode, operation);
                    }
                } finally {
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IMusicRecognizeEventListener impl) {
            if (Proxy.sDefaultImpl == null && impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static IMusicRecognizeEventListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
