package com.xiaopeng.xuimanager.pipebus;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public interface IPipeBusListener extends IInterface {
    void onPipeBusEvent(String str, String str2, String[] strArr) throws RemoteException;

    void onPipeBusParcelEvent(String str, String str2, ParcelableContainer parcelableContainer) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IPipeBusListener {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.pipebus.IPipeBusListener";
        static final int TRANSACTION_onPipeBusEvent = 1;
        static final int TRANSACTION_onPipeBusParcelEvent = 2;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPipeBusListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IPipeBusListener)) {
                return (IPipeBusListener) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            ParcelableContainer _arg2;
            if (code == 1598968902) {
                reply.writeString(DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg0 = data.readString();
                    String _arg1 = data.readString();
                    String[] _arg22 = data.createStringArray();
                    onPipeBusEvent(_arg0, _arg1, _arg22);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg02 = data.readString();
                    String _arg12 = data.readString();
                    if (data.readInt() != 0) {
                        _arg2 = ParcelableContainer.CREATOR.createFromParcel(data);
                    } else {
                        _arg2 = null;
                    }
                    onPipeBusParcelEvent(_arg02, _arg12, _arg2);
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* loaded from: classes.dex */
        private static class Proxy implements IPipeBusListener {
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

            @Override // com.xiaopeng.xuimanager.pipebus.IPipeBusListener
            public void onPipeBusEvent(String module, String types, String[] events) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(module);
                    _data.writeString(types);
                    _data.writeStringArray(events);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.pipebus.IPipeBusListener
            public void onPipeBusParcelEvent(String module, String types, ParcelableContainer data) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(module);
                    _data.writeString(types);
                    if (data != null) {
                        _data.writeInt(1);
                        data.writeToParcel(_data, 0);
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
        }
    }
}
