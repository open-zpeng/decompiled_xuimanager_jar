package com.xiaopeng.xuimanager.download;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.xuimanager.download.IDownloadListenerInterface;
import java.util.Map;
/* loaded from: classes.dex */
public interface IDownloadServiceInterface extends IInterface {
    void basicTypes(int i, long j, boolean z, float f, double d, String str) throws RemoteException;

    long enqueue(String str) throws RemoteException;

    long enqueueWithHeader(String str, String str2, String str3, Map map) throws RemoteException;

    long enqueueWtihTitleDescription(String str, String str2, String str3, Map map) throws RemoteException;

    String getState(long j, String str) throws RemoteException;

    int[] getStatusListByPackageName(String str, String str2) throws RemoteException;

    void registerListener(IDownloadListenerInterface iDownloadListenerInterface) throws RemoteException;

    void unRegisterListener(IDownloadListenerInterface iDownloadListenerInterface) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IDownloadServiceInterface {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.download.IDownloadServiceInterface";
        static final int TRANSACTION_basicTypes = 1;
        static final int TRANSACTION_enqueue = 2;
        static final int TRANSACTION_enqueueWithHeader = 4;
        static final int TRANSACTION_enqueueWtihTitleDescription = 3;
        static final int TRANSACTION_getState = 5;
        static final int TRANSACTION_getStatusListByPackageName = 8;
        static final int TRANSACTION_registerListener = 6;
        static final int TRANSACTION_unRegisterListener = 7;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDownloadServiceInterface asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IDownloadServiceInterface)) {
                return (IDownloadServiceInterface) iin;
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
                    int _arg0 = data.readInt();
                    long _arg1 = data.readLong();
                    boolean _arg2 = data.readInt() != 0;
                    float _arg3 = data.readFloat();
                    double _arg4 = data.readDouble();
                    String _arg5 = data.readString();
                    basicTypes(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg02 = data.readString();
                    long _result = enqueue(_arg02);
                    reply.writeNoException();
                    reply.writeLong(_result);
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg03 = data.readString();
                    String _arg12 = data.readString();
                    String _arg22 = data.readString();
                    ClassLoader cl = getClass().getClassLoader();
                    Map _arg32 = data.readHashMap(cl);
                    long _result2 = enqueueWtihTitleDescription(_arg03, _arg12, _arg22, _arg32);
                    reply.writeNoException();
                    reply.writeLong(_result2);
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg04 = data.readString();
                    String _arg13 = data.readString();
                    String _arg23 = data.readString();
                    ClassLoader cl2 = getClass().getClassLoader();
                    Map _arg33 = data.readHashMap(cl2);
                    long _result3 = enqueueWithHeader(_arg04, _arg13, _arg23, _arg33);
                    reply.writeNoException();
                    reply.writeLong(_result3);
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    long _arg05 = data.readLong();
                    String _arg14 = data.readString();
                    String _result4 = getState(_arg05, _arg14);
                    reply.writeNoException();
                    reply.writeString(_result4);
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    IDownloadListenerInterface _arg06 = IDownloadListenerInterface.Stub.asInterface(data.readStrongBinder());
                    registerListener(_arg06);
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    IDownloadListenerInterface _arg07 = IDownloadListenerInterface.Stub.asInterface(data.readStrongBinder());
                    unRegisterListener(_arg07);
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg08 = data.readString();
                    String _arg15 = data.readString();
                    int[] _result5 = getStatusListByPackageName(_arg08, _arg15);
                    reply.writeNoException();
                    reply.writeIntArray(_result5);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* loaded from: classes.dex */
        private static class Proxy implements IDownloadServiceInterface {
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

            @Override // com.xiaopeng.xuimanager.download.IDownloadServiceInterface
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

            @Override // com.xiaopeng.xuimanager.download.IDownloadServiceInterface
            public long enqueue(String uri) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(uri);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.download.IDownloadServiceInterface
            public long enqueueWtihTitleDescription(String url, String title, String description, Map requestHeaders) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(url);
                    _data.writeString(title);
                    _data.writeString(description);
                    _data.writeMap(requestHeaders);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.download.IDownloadServiceInterface
            public long enqueueWithHeader(String url, String title, String description, Map requestHeaders) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(url);
                    _data.writeString(title);
                    _data.writeString(description);
                    _data.writeMap(requestHeaders);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.download.IDownloadServiceInterface
            public String getState(long id, String stateKey) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLong(id);
                    _data.writeString(stateKey);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.download.IDownloadServiceInterface
            public void registerListener(IDownloadListenerInterface listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.download.IDownloadServiceInterface
            public void unRegisterListener(IDownloadListenerInterface listener) throws RemoteException {
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

            @Override // com.xiaopeng.xuimanager.download.IDownloadServiceInterface
            public int[] getStatusListByPackageName(String packageName, String stateKey) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeString(stateKey);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                    int[] _result = _reply.createIntArray();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}
