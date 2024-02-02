package com.xiaopeng.xuimanager.store;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.xuimanager.store.bean.ResourceDownloadInfo;
/* loaded from: classes.dex */
public interface IRMDownloadCallback extends IInterface {
    void basicTypes(int i, long j, boolean z, float f, double d, String str) throws RemoteException;

    void onDownloadCallback(int i, ResourceDownloadInfo resourceDownloadInfo) throws RemoteException;

    void onMenuOpenCallback(String str) throws RemoteException;

    void unbindService() throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IRMDownloadCallback {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.store.IRMDownloadCallback";
        static final int TRANSACTION_basicTypes = 1;
        static final int TRANSACTION_onDownloadCallback = 2;
        static final int TRANSACTION_onMenuOpenCallback = 3;
        static final int TRANSACTION_unbindService = 4;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRMDownloadCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IRMDownloadCallback)) {
                return (IRMDownloadCallback) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            ResourceDownloadInfo _arg1;
            if (code == 1598968902) {
                reply.writeString(DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0 = data.readInt();
                    long _arg12 = data.readLong();
                    boolean _arg2 = data.readInt() != 0;
                    float _arg3 = data.readFloat();
                    double _arg4 = data.readDouble();
                    String _arg5 = data.readString();
                    basicTypes(_arg0, _arg12, _arg2, _arg3, _arg4, _arg5);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg02 = data.readInt();
                    if (data.readInt() != 0) {
                        _arg1 = ResourceDownloadInfo.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    onDownloadCallback(_arg02, _arg1);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg03 = data.readString();
                    onMenuOpenCallback(_arg03);
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    unbindService();
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* loaded from: classes.dex */
        private static class Proxy implements IRMDownloadCallback {
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

            @Override // com.xiaopeng.xuimanager.store.IRMDownloadCallback
            public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(anInt);
                    _data.writeLong(aLong);
                    _data.writeInt(aBoolean ? 1 : 0);
                    _data.writeFloat(aFloat);
                    _data.writeDouble(aDouble);
                    _data.writeString(aString);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.store.IRMDownloadCallback
            public void onDownloadCallback(int type, ResourceDownloadInfo resourceDownloadInfo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(type);
                    if (resourceDownloadInfo != null) {
                        _data.writeInt(1);
                        resourceDownloadInfo.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.store.IRMDownloadCallback
            public void onMenuOpenCallback(String resId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(resId);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.store.IRMDownloadCallback
            public void unbindService() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}
