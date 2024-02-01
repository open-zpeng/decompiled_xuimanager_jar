package com.xiaopeng.xuimanager.mediacenter.bluetooth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IAvrcpEventListener extends IInterface {
    void onConnectedChanged(int i, int i2) throws RemoteException;

    void onMeteDataChanged(AvrcpMeteData avrcpMeteData) throws RemoteException;

    void onPlaybackChanged(int i) throws RemoteException;

    void onPositionChanged(long j, long j2) throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements IAvrcpEventListener {
        @Override // com.xiaopeng.xuimanager.mediacenter.bluetooth.IAvrcpEventListener
        public void onConnectedChanged(int prevState, int newState) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.bluetooth.IAvrcpEventListener
        public void onPlaybackChanged(int playStatus) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.bluetooth.IAvrcpEventListener
        public void onPositionChanged(long position, long duration) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.bluetooth.IAvrcpEventListener
        public void onMeteDataChanged(AvrcpMeteData meteData) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IAvrcpEventListener {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.mediacenter.bluetooth.IAvrcpEventListener";
        static final int TRANSACTION_onConnectedChanged = 1;
        static final int TRANSACTION_onMeteDataChanged = 4;
        static final int TRANSACTION_onPlaybackChanged = 2;
        static final int TRANSACTION_onPositionChanged = 3;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAvrcpEventListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IAvrcpEventListener)) {
                return (IAvrcpEventListener) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            AvrcpMeteData _arg0;
            if (code == 1) {
                data.enforceInterface(DESCRIPTOR);
                int _arg02 = data.readInt();
                int _arg1 = data.readInt();
                onConnectedChanged(_arg02, _arg1);
                reply.writeNoException();
                return true;
            } else if (code == 2) {
                data.enforceInterface(DESCRIPTOR);
                int _arg03 = data.readInt();
                onPlaybackChanged(_arg03);
                reply.writeNoException();
                return true;
            } else if (code == 3) {
                data.enforceInterface(DESCRIPTOR);
                long _arg04 = data.readLong();
                long _arg12 = data.readLong();
                onPositionChanged(_arg04, _arg12);
                reply.writeNoException();
                return true;
            } else if (code != 4) {
                if (code == 1598968902) {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(code, data, reply, flags);
            } else {
                data.enforceInterface(DESCRIPTOR);
                if (data.readInt() != 0) {
                    _arg0 = AvrcpMeteData.CREATOR.createFromParcel(data);
                } else {
                    _arg0 = null;
                }
                onMeteDataChanged(_arg0);
                reply.writeNoException();
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements IAvrcpEventListener {
            public static IAvrcpEventListener sDefaultImpl;
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

            @Override // com.xiaopeng.xuimanager.mediacenter.bluetooth.IAvrcpEventListener
            public void onConnectedChanged(int prevState, int newState) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(prevState);
                    _data.writeInt(newState);
                    boolean _status = this.mRemote.transact(1, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onConnectedChanged(prevState, newState);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.bluetooth.IAvrcpEventListener
            public void onPlaybackChanged(int playStatus) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(playStatus);
                    boolean _status = this.mRemote.transact(2, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onPlaybackChanged(playStatus);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.bluetooth.IAvrcpEventListener
            public void onPositionChanged(long position, long duration) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLong(position);
                    _data.writeLong(duration);
                    boolean _status = this.mRemote.transact(3, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onPositionChanged(position, duration);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.bluetooth.IAvrcpEventListener
            public void onMeteDataChanged(AvrcpMeteData meteData) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (meteData != null) {
                        _data.writeInt(1);
                        meteData.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    boolean _status = this.mRemote.transact(4, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onMeteDataChanged(meteData);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IAvrcpEventListener impl) {
            if (Proxy.sDefaultImpl == null && impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static IAvrcpEventListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
