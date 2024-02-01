package com.xiaopeng.xuimanager.mediacenter;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IPlaybackInfoListener extends IInterface {
    void OnMediaInfoNotify(int i, MediaInfo mediaInfo) throws RemoteException;

    void OnPlaybackChanged(int i, int i2) throws RemoteException;

    void OnUpdatePosition(int i, long j, long j2) throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements IPlaybackInfoListener {
        @Override // com.xiaopeng.xuimanager.mediacenter.IPlaybackInfoListener
        public void OnPlaybackChanged(int displayId, int status) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.IPlaybackInfoListener
        public void OnUpdatePosition(int displayId, long position, long duration) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.IPlaybackInfoListener
        public void OnMediaInfoNotify(int displayId, MediaInfo info) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IPlaybackInfoListener {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.mediacenter.IPlaybackInfoListener";
        static final int TRANSACTION_OnMediaInfoNotify = 3;
        static final int TRANSACTION_OnPlaybackChanged = 1;
        static final int TRANSACTION_OnUpdatePosition = 2;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPlaybackInfoListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IPlaybackInfoListener)) {
                return (IPlaybackInfoListener) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            MediaInfo _arg1;
            if (code == 1) {
                data.enforceInterface(DESCRIPTOR);
                int _arg0 = data.readInt();
                int _arg12 = data.readInt();
                OnPlaybackChanged(_arg0, _arg12);
                reply.writeNoException();
                return true;
            } else if (code == 2) {
                data.enforceInterface(DESCRIPTOR);
                int _arg02 = data.readInt();
                long _arg13 = data.readLong();
                long _arg2 = data.readLong();
                OnUpdatePosition(_arg02, _arg13, _arg2);
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
                int _arg03 = data.readInt();
                if (data.readInt() != 0) {
                    _arg1 = MediaInfo.CREATOR.createFromParcel(data);
                } else {
                    _arg1 = null;
                }
                OnMediaInfoNotify(_arg03, _arg1);
                reply.writeNoException();
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements IPlaybackInfoListener {
            public static IPlaybackInfoListener sDefaultImpl;
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

            @Override // com.xiaopeng.xuimanager.mediacenter.IPlaybackInfoListener
            public void OnPlaybackChanged(int displayId, int status) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(status);
                    boolean _status = this.mRemote.transact(1, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().OnPlaybackChanged(displayId, status);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IPlaybackInfoListener
            public void OnUpdatePosition(int displayId, long position, long duration) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeLong(position);
                    _data.writeLong(duration);
                    boolean _status = this.mRemote.transact(2, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().OnUpdatePosition(displayId, position, duration);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IPlaybackInfoListener
            public void OnMediaInfoNotify(int displayId, MediaInfo info) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(displayId);
                    if (info != null) {
                        _data.writeInt(1);
                        info.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    boolean _status = this.mRemote.transact(3, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().OnMediaInfoNotify(displayId, info);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IPlaybackInfoListener impl) {
            if (Proxy.sDefaultImpl == null && impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static IPlaybackInfoListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
