package com.xiaopeng.xuimanager.ambient;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public interface IAmbientEventListener extends IInterface {
    void onAmbientLightEvent(int i, String str, String str2, int i2) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IAmbientEventListener {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.ambient.IAmbientEventListener";
        static final int TRANSACTION_onAmbientLightEvent = 2;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAmbientEventListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IAmbientEventListener)) {
                return (IAmbientEventListener) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code != 2) {
                if (code == 1598968902) {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(code, data, reply, flags);
            }
            data.enforceInterface(DESCRIPTOR);
            int _arg0 = data.readInt();
            String _arg1 = data.readString();
            String _arg2 = data.readString();
            int _arg3 = data.readInt();
            onAmbientLightEvent(_arg0, _arg1, _arg2, _arg3);
            return true;
        }

        /* loaded from: classes.dex */
        private static class Proxy implements IAmbientEventListener {
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

            @Override // com.xiaopeng.xuimanager.ambient.IAmbientEventListener
            public void onAmbientLightEvent(int type, String sdata, String sdata2, int data) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(type);
                    _data.writeString(sdata);
                    _data.writeString(sdata2);
                    _data.writeInt(data);
                    this.mRemote.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }
    }
}
