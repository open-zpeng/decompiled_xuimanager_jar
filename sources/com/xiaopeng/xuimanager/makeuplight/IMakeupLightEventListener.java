package com.xiaopeng.xuimanager.makeuplight;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IMakeupLightEventListener extends IInterface {
    void onAvailableEvent(boolean z) throws RemoteException;

    void onColorTemperatureEvent(int i, int i2) throws RemoteException;

    void onEffectEvent(String str, int i) throws RemoteException;

    void onLuminanceEvent(int i) throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements IMakeupLightEventListener {
        @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLightEventListener
        public void onAvailableEvent(boolean status) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLightEventListener
        public void onColorTemperatureEvent(int rgb, int white) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLightEventListener
        public void onLuminanceEvent(int lux) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLightEventListener
        public void onEffectEvent(String effect, int type) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IMakeupLightEventListener {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.makeuplight.IMakeupLightEventListener";
        static final int TRANSACTION_onAvailableEvent = 1;
        static final int TRANSACTION_onColorTemperatureEvent = 2;
        static final int TRANSACTION_onEffectEvent = 4;
        static final int TRANSACTION_onLuminanceEvent = 3;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMakeupLightEventListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IMakeupLightEventListener)) {
                return (IMakeupLightEventListener) iin;
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
                boolean _arg0 = data.readInt() != 0;
                onAvailableEvent(_arg0);
                return true;
            } else if (code == 2) {
                data.enforceInterface(DESCRIPTOR);
                int _arg02 = data.readInt();
                int _arg1 = data.readInt();
                onColorTemperatureEvent(_arg02, _arg1);
                return true;
            } else if (code == 3) {
                data.enforceInterface(DESCRIPTOR);
                int _arg03 = data.readInt();
                onLuminanceEvent(_arg03);
                return true;
            } else if (code != 4) {
                if (code == 1598968902) {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(code, data, reply, flags);
            } else {
                data.enforceInterface(DESCRIPTOR);
                String _arg04 = data.readString();
                int _arg12 = data.readInt();
                onEffectEvent(_arg04, _arg12);
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements IMakeupLightEventListener {
            public static IMakeupLightEventListener sDefaultImpl;
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

            @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLightEventListener
            public void onAvailableEvent(boolean status) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(status ? 1 : 0);
                    boolean _status = this.mRemote.transact(1, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onAvailableEvent(status);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLightEventListener
            public void onColorTemperatureEvent(int rgb, int white) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(rgb);
                    _data.writeInt(white);
                    boolean _status = this.mRemote.transact(2, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onColorTemperatureEvent(rgb, white);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLightEventListener
            public void onLuminanceEvent(int lux) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(lux);
                    boolean _status = this.mRemote.transact(3, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onLuminanceEvent(lux);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLightEventListener
            public void onEffectEvent(String effect, int type) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(effect);
                    _data.writeInt(type);
                    boolean _status = this.mRemote.transact(4, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onEffectEvent(effect, type);
                    }
                } finally {
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IMakeupLightEventListener impl) {
            if (Proxy.sDefaultImpl == null && impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static IMakeupLightEventListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
