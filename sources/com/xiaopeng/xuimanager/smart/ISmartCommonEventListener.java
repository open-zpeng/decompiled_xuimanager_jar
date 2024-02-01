package com.xiaopeng.xuimanager.smart;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ISmartCommonEventListener extends IInterface {
    void onSmartCommonEvent(int i, int i2, int i3) throws RemoteException;

    void onSmartSpeechTtsEvent(int i, String str) throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements ISmartCommonEventListener {
        @Override // com.xiaopeng.xuimanager.smart.ISmartCommonEventListener
        public void onSmartCommonEvent(int type, int value1, int value2) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.smart.ISmartCommonEventListener
        public void onSmartSpeechTtsEvent(int type, String ttsId) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements ISmartCommonEventListener {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.smart.ISmartCommonEventListener";
        static final int TRANSACTION_onSmartCommonEvent = 1;
        static final int TRANSACTION_onSmartSpeechTtsEvent = 2;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISmartCommonEventListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof ISmartCommonEventListener)) {
                return (ISmartCommonEventListener) iin;
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
                int _arg2 = data.readInt();
                onSmartCommonEvent(_arg0, _arg1, _arg2);
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
                onSmartSpeechTtsEvent(_arg02, _arg12);
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements ISmartCommonEventListener {
            public static ISmartCommonEventListener sDefaultImpl;
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

            @Override // com.xiaopeng.xuimanager.smart.ISmartCommonEventListener
            public void onSmartCommonEvent(int type, int value1, int value2) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(type);
                    _data.writeInt(value1);
                    _data.writeInt(value2);
                    boolean _status = this.mRemote.transact(1, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onSmartCommonEvent(type, value1, value2);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmartCommonEventListener
            public void onSmartSpeechTtsEvent(int type, String ttsId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(type);
                    _data.writeString(ttsId);
                    boolean _status = this.mRemote.transact(2, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onSmartSpeechTtsEvent(type, ttsId);
                    }
                } finally {
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ISmartCommonEventListener impl) {
            if (Proxy.sDefaultImpl == null && impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static ISmartCommonEventListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
