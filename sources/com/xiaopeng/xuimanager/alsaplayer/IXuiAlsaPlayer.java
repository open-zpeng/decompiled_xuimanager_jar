package com.xiaopeng.xuimanager.alsaplayer;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.xuimanager.alsaplayer.IXuiAlsaPlayerEventListener;
/* loaded from: classes.dex */
public interface IXuiAlsaPlayer extends IInterface {
    void registerListener(IXuiAlsaPlayerEventListener iXuiAlsaPlayerEventListener) throws RemoteException;

    int resetRouteAndUpdatePath(String str, String str2, String str3) throws RemoteException;

    int setCaptureParameter(String str, int i, int i2, int i3, int i4, int i5, int i6) throws RemoteException;

    int setPlaybackParameter(String str, int i, int i2, int i3, int i4, int i5, int i6) throws RemoteException;

    int startPlay(String str) throws RemoteException;

    int stopPlay(String str) throws RemoteException;

    void unregisterListener(IXuiAlsaPlayerEventListener iXuiAlsaPlayerEventListener) throws RemoteException;

    int writeData(String str, byte[] bArr, int i, int i2) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IXuiAlsaPlayer {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.alsaplayer.IXuiAlsaPlayer";
        static final int TRANSACTION_registerListener = 7;
        static final int TRANSACTION_resetRouteAndUpdatePath = 6;
        static final int TRANSACTION_setCaptureParameter = 4;
        static final int TRANSACTION_setPlaybackParameter = 5;
        static final int TRANSACTION_startPlay = 1;
        static final int TRANSACTION_stopPlay = 2;
        static final int TRANSACTION_unregisterListener = 8;
        static final int TRANSACTION_writeData = 3;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IXuiAlsaPlayer asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IXuiAlsaPlayer)) {
                return (IXuiAlsaPlayer) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code == 1598968902) {
                reply.writeString(DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg0 = data.readString();
                    int _result = startPlay(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg02 = data.readString();
                    int _result2 = stopPlay(_arg02);
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg03 = data.readString();
                    byte[] _arg1 = data.createByteArray();
                    int _arg2 = data.readInt();
                    int _arg3 = data.readInt();
                    int _result3 = writeData(_arg03, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    reply.writeByteArray(_arg1);
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg04 = data.readString();
                    int _arg12 = data.readInt();
                    int _arg22 = data.readInt();
                    int _arg32 = data.readInt();
                    int _arg4 = data.readInt();
                    int _arg5 = data.readInt();
                    int _arg6 = data.readInt();
                    int _result4 = setCaptureParameter(_arg04, _arg12, _arg22, _arg32, _arg4, _arg5, _arg6);
                    reply.writeNoException();
                    reply.writeInt(_result4);
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg05 = data.readString();
                    int _arg13 = data.readInt();
                    int _arg23 = data.readInt();
                    int _arg33 = data.readInt();
                    int _arg42 = data.readInt();
                    int _arg52 = data.readInt();
                    int _arg62 = data.readInt();
                    int _result5 = setPlaybackParameter(_arg05, _arg13, _arg23, _arg33, _arg42, _arg52, _arg62);
                    reply.writeNoException();
                    reply.writeInt(_result5);
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg06 = data.readString();
                    String _arg14 = data.readString();
                    String _arg24 = data.readString();
                    int _result6 = resetRouteAndUpdatePath(_arg06, _arg14, _arg24);
                    reply.writeNoException();
                    reply.writeInt(_result6);
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    IXuiAlsaPlayerEventListener _arg07 = IXuiAlsaPlayerEventListener.Stub.asInterface(data.readStrongBinder());
                    registerListener(_arg07);
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    IXuiAlsaPlayerEventListener _arg08 = IXuiAlsaPlayerEventListener.Stub.asInterface(data.readStrongBinder());
                    unregisterListener(_arg08);
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* loaded from: classes.dex */
        private static class Proxy implements IXuiAlsaPlayer {
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

            @Override // com.xiaopeng.xuimanager.alsaplayer.IXuiAlsaPlayer
            public int startPlay(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.alsaplayer.IXuiAlsaPlayer
            public int stopPlay(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.alsaplayer.IXuiAlsaPlayer
            public int writeData(String pkgName, byte[] data, int offset, int size) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeByteArray(data);
                    _data.writeInt(offset);
                    _data.writeInt(size);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    _reply.readByteArray(data);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.alsaplayer.IXuiAlsaPlayer
            public int setCaptureParameter(String pkgName, int card, int device, int sampleRate, int channel, int periodSize, int periodCount) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeInt(card);
                    _data.writeInt(device);
                    _data.writeInt(sampleRate);
                    _data.writeInt(channel);
                    _data.writeInt(periodSize);
                    _data.writeInt(periodCount);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.alsaplayer.IXuiAlsaPlayer
            public int setPlaybackParameter(String pkgName, int card, int device, int sampleRate, int channel, int periodSize, int periodCount) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeInt(card);
                    _data.writeInt(device);
                    _data.writeInt(sampleRate);
                    _data.writeInt(channel);
                    _data.writeInt(periodSize);
                    _data.writeInt(periodCount);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.alsaplayer.IXuiAlsaPlayer
            public int resetRouteAndUpdatePath(String pkgName, String pathType, String enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeString(pathType);
                    _data.writeString(enable);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.alsaplayer.IXuiAlsaPlayer
            public void registerListener(IXuiAlsaPlayerEventListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.alsaplayer.IXuiAlsaPlayer
            public void unregisterListener(IXuiAlsaPlayerEventListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}
