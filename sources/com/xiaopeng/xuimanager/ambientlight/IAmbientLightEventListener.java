package com.xiaopeng.xuimanager.ambientlight;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IAmbientLightEventListener extends IInterface {
    void onAmbientLightSetEvent(int i, String str, int[] iArr) throws RemoteException;

    void onError(int i, int i2) throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements IAmbientLightEventListener {
        @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLightEventListener
        public void onAmbientLightSetEvent(int type, String effectType, int[] data) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLightEventListener
        public void onError(int errorCode, int operation) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IAmbientLightEventListener {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.ambientlight.IAmbientLightEventListener";
        static final int TRANSACTION_onAmbientLightSetEvent = 1;
        static final int TRANSACTION_onError = 2;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAmbientLightEventListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IAmbientLightEventListener)) {
                return (IAmbientLightEventListener) iin;
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
                String _arg1 = data.readString();
                int[] _arg2 = data.createIntArray();
                onAmbientLightSetEvent(_arg0, _arg1, _arg2);
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
                int _arg12 = data.readInt();
                onError(_arg02, _arg12);
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements IAmbientLightEventListener {
            public static IAmbientLightEventListener sDefaultImpl;
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

            @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLightEventListener
            public void onAmbientLightSetEvent(int type, String effectType, int[] data) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(type);
                    _data.writeString(effectType);
                    _data.writeIntArray(data);
                    boolean _status = this.mRemote.transact(1, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onAmbientLightSetEvent(type, effectType, data);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLightEventListener
            public void onError(int errorCode, int operation) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(errorCode);
                    _data.writeInt(operation);
                    boolean _status = this.mRemote.transact(2, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onError(errorCode, operation);
                    }
                } finally {
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IAmbientLightEventListener impl) {
            if (Proxy.sDefaultImpl == null && impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static IAmbientLightEventListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
