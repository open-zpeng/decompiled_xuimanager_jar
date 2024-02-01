package com.xiaopeng.xuimanager.seatmassager;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes.dex */
public interface ISeatMassagerEventListener extends IInterface {
    void onMassagerEvent(int i, int i2, String str, int i3) throws RemoteException;

    void onVibrateEvent(List<String> list, int i, String str, int i2) throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements ISeatMassagerEventListener {
        @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassagerEventListener
        public void onMassagerEvent(int id, int type, String effect, int data) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassagerEventListener
        public void onVibrateEvent(List<String> ids, int type, String effect, int data) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements ISeatMassagerEventListener {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.seatmassager.ISeatMassagerEventListener";
        static final int TRANSACTION_onMassagerEvent = 1;
        static final int TRANSACTION_onVibrateEvent = 2;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISeatMassagerEventListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof ISeatMassagerEventListener)) {
                return (ISeatMassagerEventListener) iin;
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
                String _arg2 = data.readString();
                int _arg3 = data.readInt();
                onMassagerEvent(_arg0, _arg1, _arg2, _arg3);
                return true;
            } else if (code != 2) {
                if (code == 1598968902) {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(code, data, reply, flags);
            } else {
                data.enforceInterface(DESCRIPTOR);
                List<String> _arg02 = data.createStringArrayList();
                int _arg12 = data.readInt();
                String _arg22 = data.readString();
                int _arg32 = data.readInt();
                onVibrateEvent(_arg02, _arg12, _arg22, _arg32);
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements ISeatMassagerEventListener {
            public static ISeatMassagerEventListener sDefaultImpl;
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

            @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassagerEventListener
            public void onMassagerEvent(int id, int type, String effect, int data) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(id);
                    _data.writeInt(type);
                    _data.writeString(effect);
                    _data.writeInt(data);
                    boolean _status = this.mRemote.transact(1, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onMassagerEvent(id, type, effect, data);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassagerEventListener
            public void onVibrateEvent(List<String> ids, int type, String effect, int data) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStringList(ids);
                    _data.writeInt(type);
                    _data.writeString(effect);
                    _data.writeInt(data);
                    boolean _status = this.mRemote.transact(2, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onVibrateEvent(ids, type, effect, data);
                    }
                } finally {
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ISeatMassagerEventListener impl) {
            if (Proxy.sDefaultImpl == null && impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static ISeatMassagerEventListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
