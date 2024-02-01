package com.xiaopeng.xuimanager.mediacenter;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IPlaybackControlListener extends IInterface {
    int OnPlaybackControl(int i, int i2) throws RemoteException;

    int OnSetFavorite(boolean z, String str) throws RemoteException;

    int OnSwitchSource(int i) throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements IPlaybackControlListener {
        @Override // com.xiaopeng.xuimanager.mediacenter.IPlaybackControlListener
        public int OnPlaybackControl(int cmd, int param) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.IPlaybackControlListener
        public int OnSwitchSource(int source) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.IPlaybackControlListener
        public int OnSetFavorite(boolean favorite, String id) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IPlaybackControlListener {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.mediacenter.IPlaybackControlListener";
        static final int TRANSACTION_OnPlaybackControl = 1;
        static final int TRANSACTION_OnSetFavorite = 3;
        static final int TRANSACTION_OnSwitchSource = 2;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPlaybackControlListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IPlaybackControlListener)) {
                return (IPlaybackControlListener) iin;
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
                int _arg1 = data.readInt();
                int _result = OnPlaybackControl(_arg0, _arg1);
                reply.writeNoException();
                reply.writeInt(_result);
                return true;
            } else if (code == 2) {
                data.enforceInterface(DESCRIPTOR);
                int _arg02 = data.readInt();
                int _result2 = OnSwitchSource(_arg02);
                reply.writeNoException();
                reply.writeInt(_result2);
                return true;
            } else if (code != 3) {
                if (code == 1598968902) {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(code, data, reply, flags);
            } else {
                data.enforceInterface(DESCRIPTOR);
                boolean _arg03 = data.readInt() != 0;
                String _arg12 = data.readString();
                int _result3 = OnSetFavorite(_arg03, _arg12);
                reply.writeNoException();
                reply.writeInt(_result3);
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements IPlaybackControlListener {
            public static IPlaybackControlListener sDefaultImpl;
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

            @Override // com.xiaopeng.xuimanager.mediacenter.IPlaybackControlListener
            public int OnPlaybackControl(int cmd, int param) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(cmd);
                    _data.writeInt(param);
                    boolean _status = this.mRemote.transact(1, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().OnPlaybackControl(cmd, param);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IPlaybackControlListener
            public int OnSwitchSource(int source) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(source);
                    boolean _status = this.mRemote.transact(2, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().OnSwitchSource(source);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IPlaybackControlListener
            public int OnSetFavorite(boolean favorite, String id) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(favorite ? 1 : 0);
                    _data.writeString(id);
                    boolean _status = this.mRemote.transact(3, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().OnSetFavorite(favorite, id);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IPlaybackControlListener impl) {
            if (Proxy.sDefaultImpl == null && impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static IPlaybackControlListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
