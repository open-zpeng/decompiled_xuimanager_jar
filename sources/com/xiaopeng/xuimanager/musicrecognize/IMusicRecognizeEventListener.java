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
            if (code == 1598968902) {
                reply.writeString(DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg02 = data.readString();
                    onFindCoverEvent(_arg02);
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = MusicRecognizeEvent.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    onRecognizeEvent(_arg0);
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg03 = data.readInt();
                    int _arg1 = data.readInt();
                    onError(_arg03, _arg1);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* loaded from: classes.dex */
        private static class Proxy implements IMusicRecognizeEventListener {
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
                    this.mRemote.transact(1, _data, null, 1);
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
                    this.mRemote.transact(2, _data, null, 1);
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
                    this.mRemote.transact(3, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }
    }
}
