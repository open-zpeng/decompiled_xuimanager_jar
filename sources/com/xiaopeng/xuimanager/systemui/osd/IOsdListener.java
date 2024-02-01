package com.xiaopeng.xuimanager.systemui.osd;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IOsdListener extends IInterface {
    void hideOsd() throws RemoteException;

    void showOsd(OsdRegionRecord osdRegionRecord) throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements IOsdListener {
        @Override // com.xiaopeng.xuimanager.systemui.osd.IOsdListener
        public void hideOsd() throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.systemui.osd.IOsdListener
        public void showOsd(OsdRegionRecord record) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IOsdListener {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.systemui.osd.IOsdListener";
        static final int TRANSACTION_hideOsd = 1;
        static final int TRANSACTION_showOsd = 2;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IOsdListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IOsdListener)) {
                return (IOsdListener) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            OsdRegionRecord _arg0;
            if (code == 1) {
                data.enforceInterface(DESCRIPTOR);
                hideOsd();
                reply.writeNoException();
                return true;
            } else if (code != 2) {
                if (code == 1598968902) {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(code, data, reply, flags);
            } else {
                data.enforceInterface(DESCRIPTOR);
                if (data.readInt() != 0) {
                    _arg0 = OsdRegionRecord.CREATOR.createFromParcel(data);
                } else {
                    _arg0 = null;
                }
                showOsd(_arg0);
                reply.writeNoException();
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements IOsdListener {
            public static IOsdListener sDefaultImpl;
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

            @Override // com.xiaopeng.xuimanager.systemui.osd.IOsdListener
            public void hideOsd() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(1, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().hideOsd();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.systemui.osd.IOsdListener
            public void showOsd(OsdRegionRecord record) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (record != null) {
                        _data.writeInt(1);
                        record.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    boolean _status = this.mRemote.transact(2, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().showOsd(record);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IOsdListener impl) {
            if (Proxy.sDefaultImpl == null && impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static IOsdListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
