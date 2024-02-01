package com.xiaopeng.xuimanager.download;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public interface IDownloadListenerInterface extends IInterface {
    void basicTypes(int i, long j, boolean z, float f, double d, String str) throws RemoteException;

    void onDownloadCancel(long j, String str) throws RemoteException;

    void onDownloadCompleted(long j, String str, String str2) throws RemoteException;

    void onDownloadError(long j, String str, String str2) throws RemoteException;

    void onDownloadInProgress(long j, String str, long j2, float f, long j3) throws RemoteException;

    void onDownloadPause(long j, String str) throws RemoteException;

    void onDownloadStart(long j, String str) throws RemoteException;

    void onRegisterError(IDownloadListenerInterface iDownloadListenerInterface, String str) throws RemoteException;

    void onRegisterSuccess(IDownloadListenerInterface iDownloadListenerInterface) throws RemoteException;

    void onUnRegisterError(IDownloadListenerInterface iDownloadListenerInterface, String str) throws RemoteException;

    void onUnRegisterSuccess(IDownloadListenerInterface iDownloadListenerInterface) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IDownloadListenerInterface {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.download.IDownloadListenerInterface";
        static final int TRANSACTION_basicTypes = 1;
        static final int TRANSACTION_onDownloadCancel = 9;
        static final int TRANSACTION_onDownloadCompleted = 11;
        static final int TRANSACTION_onDownloadError = 10;
        static final int TRANSACTION_onDownloadInProgress = 7;
        static final int TRANSACTION_onDownloadPause = 8;
        static final int TRANSACTION_onDownloadStart = 6;
        static final int TRANSACTION_onRegisterError = 3;
        static final int TRANSACTION_onRegisterSuccess = 2;
        static final int TRANSACTION_onUnRegisterError = 5;
        static final int TRANSACTION_onUnRegisterSuccess = 4;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDownloadListenerInterface asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IDownloadListenerInterface)) {
                return (IDownloadListenerInterface) iin;
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
                    IDownloadListenerInterface _arg02 = asInterface(data.readStrongBinder());
                    onRegisterSuccess(_arg02);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    IDownloadListenerInterface _arg03 = asInterface(data.readStrongBinder());
                    String _arg12 = data.readString();
                    onRegisterError(_arg03, _arg12);
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    IDownloadListenerInterface _arg04 = asInterface(data.readStrongBinder());
                    onUnRegisterSuccess(_arg04);
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    IDownloadListenerInterface _arg05 = asInterface(data.readStrongBinder());
                    String _arg13 = data.readString();
                    onUnRegisterError(_arg05, _arg13);
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    long _arg06 = data.readLong();
                    String _arg14 = data.readString();
                    onDownloadStart(_arg06, _arg14);
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    long _arg07 = data.readLong();
                    String _arg15 = data.readString();
                    long _arg22 = data.readLong();
                    float _arg32 = data.readFloat();
                    long _arg42 = data.readLong();
                    onDownloadInProgress(_arg07, _arg15, _arg22, _arg32, _arg42);
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    long _arg08 = data.readLong();
                    String _arg16 = data.readString();
                    onDownloadPause(_arg08, _arg16);
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    long _arg09 = data.readLong();
                    String _arg17 = data.readString();
                    onDownloadCancel(_arg09, _arg17);
                    reply.writeNoException();
                    return true;
                case 10:
                    data.enforceInterface(DESCRIPTOR);
                    long _arg010 = data.readLong();
                    String _arg18 = data.readString();
                    String _arg23 = data.readString();
                    onDownloadError(_arg010, _arg18, _arg23);
                    reply.writeNoException();
                    return true;
                case 11:
                    data.enforceInterface(DESCRIPTOR);
                    long _arg011 = data.readLong();
                    String _arg19 = data.readString();
                    String _arg24 = data.readString();
                    onDownloadCompleted(_arg011, _arg19, _arg24);
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements IDownloadListenerInterface {
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

            @Override // com.xiaopeng.xuimanager.download.IDownloadListenerInterface
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

            @Override // com.xiaopeng.xuimanager.download.IDownloadListenerInterface
            public void onRegisterSuccess(IDownloadListenerInterface listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.download.IDownloadListenerInterface
            public void onRegisterError(IDownloadListenerInterface listener, String errorMessage) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    _data.writeString(errorMessage);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.download.IDownloadListenerInterface
            public void onUnRegisterSuccess(IDownloadListenerInterface listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.download.IDownloadListenerInterface
            public void onUnRegisterError(IDownloadListenerInterface listener, String errorMessage) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    _data.writeString(errorMessage);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.download.IDownloadListenerInterface
            public void onDownloadStart(long taskId, String uri) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLong(taskId);
                    _data.writeString(uri);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.download.IDownloadListenerInterface
            public void onDownloadInProgress(long taskId, String url, long totalBytes, float percentage, long byteTillNow) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLong(taskId);
                    _data.writeString(url);
                    _data.writeLong(totalBytes);
                    _data.writeFloat(percentage);
                    _data.writeLong(byteTillNow);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.download.IDownloadListenerInterface
            public void onDownloadPause(long taskId, String uri) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLong(taskId);
                    _data.writeString(uri);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.download.IDownloadListenerInterface
            public void onDownloadCancel(long taskId, String uri) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLong(taskId);
                    _data.writeString(uri);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.download.IDownloadListenerInterface
            public void onDownloadError(long taskId, String uri, String errorMessage) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLong(taskId);
                    _data.writeString(uri);
                    _data.writeString(errorMessage);
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.download.IDownloadListenerInterface
            public void onDownloadCompleted(long taskId, String downloadUri, String fileUri) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLong(taskId);
                    _data.writeString(downloadUri);
                    _data.writeString(fileUri);
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}
