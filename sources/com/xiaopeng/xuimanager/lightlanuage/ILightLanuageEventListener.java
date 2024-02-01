package com.xiaopeng.xuimanager.lightlanuage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ILightLanuageEventListener extends IInterface {
    void onErrorEvent(String str, int i) throws RemoteException;

    void onFinishEvent(String str, String str2) throws RemoteException;

    void onStartEvent(String str, String str2) throws RemoteException;

    void onStopEvent(String str, String str2) throws RemoteException;

    void onUpgradeEvent(int i, int i2) throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements ILightLanuageEventListener {
        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuageEventListener
        public void onStartEvent(String name, String type) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuageEventListener
        public void onStopEvent(String name, String type) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuageEventListener
        public void onFinishEvent(String name, String type) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuageEventListener
        public void onErrorEvent(String name, int errCode) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuageEventListener
        public void onUpgradeEvent(int name, int mode) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements ILightLanuageEventListener {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.lightlanuage.ILightLanuageEventListener";
        static final int TRANSACTION_onErrorEvent = 4;
        static final int TRANSACTION_onFinishEvent = 3;
        static final int TRANSACTION_onStartEvent = 1;
        static final int TRANSACTION_onStopEvent = 2;
        static final int TRANSACTION_onUpgradeEvent = 5;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ILightLanuageEventListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof ILightLanuageEventListener)) {
                return (ILightLanuageEventListener) iin;
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
                String _arg0 = data.readString();
                String _arg1 = data.readString();
                onStartEvent(_arg0, _arg1);
                return true;
            } else if (code == 2) {
                data.enforceInterface(DESCRIPTOR);
                String _arg02 = data.readString();
                String _arg12 = data.readString();
                onStopEvent(_arg02, _arg12);
                return true;
            } else if (code == 3) {
                data.enforceInterface(DESCRIPTOR);
                String _arg03 = data.readString();
                String _arg13 = data.readString();
                onFinishEvent(_arg03, _arg13);
                return true;
            } else if (code == 4) {
                data.enforceInterface(DESCRIPTOR);
                String _arg04 = data.readString();
                int _arg14 = data.readInt();
                onErrorEvent(_arg04, _arg14);
                return true;
            } else if (code != 5) {
                if (code == 1598968902) {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(code, data, reply, flags);
            } else {
                data.enforceInterface(DESCRIPTOR);
                int _arg05 = data.readInt();
                int _arg15 = data.readInt();
                onUpgradeEvent(_arg05, _arg15);
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements ILightLanuageEventListener {
            public static ILightLanuageEventListener sDefaultImpl;
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

            @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuageEventListener
            public void onStartEvent(String name, String type) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(name);
                    _data.writeString(type);
                    boolean _status = this.mRemote.transact(1, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onStartEvent(name, type);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuageEventListener
            public void onStopEvent(String name, String type) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(name);
                    _data.writeString(type);
                    boolean _status = this.mRemote.transact(2, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onStopEvent(name, type);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuageEventListener
            public void onFinishEvent(String name, String type) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(name);
                    _data.writeString(type);
                    boolean _status = this.mRemote.transact(3, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onFinishEvent(name, type);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuageEventListener
            public void onErrorEvent(String name, int errCode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(name);
                    _data.writeInt(errCode);
                    boolean _status = this.mRemote.transact(4, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onErrorEvent(name, errCode);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuageEventListener
            public void onUpgradeEvent(int name, int mode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(name);
                    _data.writeInt(mode);
                    boolean _status = this.mRemote.transact(5, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onUpgradeEvent(name, mode);
                    }
                } finally {
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ILightLanuageEventListener impl) {
            if (Proxy.sDefaultImpl == null && impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static ILightLanuageEventListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
