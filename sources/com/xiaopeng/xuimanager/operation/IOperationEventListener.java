package com.xiaopeng.xuimanager.operation;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IOperationEventListener extends IInterface {
    void onError(int i, int i2) throws RemoteException;

    void onEvent(int i, String str, int i2, String str2) throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements IOperationEventListener {
        @Override // com.xiaopeng.xuimanager.operation.IOperationEventListener
        public void onError(int errorCode, int operation) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.operation.IOperationEventListener
        public void onEvent(int code, String id, int type, String mObject) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IOperationEventListener {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.operation.IOperationEventListener";
        static final int TRANSACTION_onError = 1;
        static final int TRANSACTION_onEvent = 2;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IOperationEventListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IOperationEventListener)) {
                return (IOperationEventListener) iin;
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
                onError(_arg0, _arg1);
                return true;
            } else if (code != 2) {
                if (code == 1598968902) {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(code, data, reply, flags);
            } else {
                data.enforceInterface(DESCRIPTOR);
                int _arg02 = data.readInt();
                String _arg12 = data.readString();
                int _arg2 = data.readInt();
                String _arg3 = data.readString();
                onEvent(_arg02, _arg12, _arg2, _arg3);
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements IOperationEventListener {
            public static IOperationEventListener sDefaultImpl;
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

            @Override // com.xiaopeng.xuimanager.operation.IOperationEventListener
            public void onError(int errorCode, int operation) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(errorCode);
                    _data.writeInt(operation);
                    boolean _status = this.mRemote.transact(1, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onError(errorCode, operation);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.operation.IOperationEventListener
            public void onEvent(int code, String id, int type, String mObject) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(code);
                    _data.writeString(id);
                    _data.writeInt(type);
                    _data.writeString(mObject);
                    boolean _status = this.mRemote.transact(2, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onEvent(code, id, type, mObject);
                    }
                } finally {
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IOperationEventListener impl) {
            if (Proxy.sDefaultImpl == null && impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static IOperationEventListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
