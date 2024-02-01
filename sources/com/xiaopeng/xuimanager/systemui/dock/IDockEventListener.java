package com.xiaopeng.xuimanager.systemui.dock;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IDockEventListener extends IInterface {
    void onDockEvent(int i, String str) throws RemoteException;

    void onDockItemAdd(DockItem dockItem) throws RemoteException;

    void onDockItemRemoved(DockItem dockItem) throws RemoteException;

    void onEnterEdit(boolean z) throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements IDockEventListener {
        @Override // com.xiaopeng.xuimanager.systemui.dock.IDockEventListener
        public void onDockItemAdd(DockItem dockItem) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.systemui.dock.IDockEventListener
        public void onDockItemRemoved(DockItem dockItem) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.systemui.dock.IDockEventListener
        public void onEnterEdit(boolean enable) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.systemui.dock.IDockEventListener
        public void onDockEvent(int eventId, String params) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IDockEventListener {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.systemui.dock.IDockEventListener";
        static final int TRANSACTION_onDockEvent = 4;
        static final int TRANSACTION_onDockItemAdd = 1;
        static final int TRANSACTION_onDockItemRemoved = 2;
        static final int TRANSACTION_onEnterEdit = 3;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDockEventListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IDockEventListener)) {
                return (IDockEventListener) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            DockItem _arg0;
            DockItem _arg02;
            if (code == 1) {
                data.enforceInterface(DESCRIPTOR);
                if (data.readInt() != 0) {
                    _arg0 = DockItem.CREATOR.createFromParcel(data);
                } else {
                    _arg0 = null;
                }
                onDockItemAdd(_arg0);
                reply.writeNoException();
                return true;
            } else if (code == 2) {
                data.enforceInterface(DESCRIPTOR);
                if (data.readInt() != 0) {
                    _arg02 = DockItem.CREATOR.createFromParcel(data);
                } else {
                    _arg02 = null;
                }
                onDockItemRemoved(_arg02);
                reply.writeNoException();
                return true;
            } else if (code == 3) {
                data.enforceInterface(DESCRIPTOR);
                boolean _arg03 = data.readInt() != 0;
                onEnterEdit(_arg03);
                reply.writeNoException();
                return true;
            } else if (code != 4) {
                if (code == 1598968902) {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(code, data, reply, flags);
            } else {
                data.enforceInterface(DESCRIPTOR);
                int _arg04 = data.readInt();
                String _arg1 = data.readString();
                onDockEvent(_arg04, _arg1);
                reply.writeNoException();
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements IDockEventListener {
            public static IDockEventListener sDefaultImpl;
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

            @Override // com.xiaopeng.xuimanager.systemui.dock.IDockEventListener
            public void onDockItemAdd(DockItem dockItem) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (dockItem != null) {
                        _data.writeInt(1);
                        dockItem.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    boolean _status = this.mRemote.transact(1, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onDockItemAdd(dockItem);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.systemui.dock.IDockEventListener
            public void onDockItemRemoved(DockItem dockItem) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (dockItem != null) {
                        _data.writeInt(1);
                        dockItem.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    boolean _status = this.mRemote.transact(2, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onDockItemRemoved(dockItem);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.systemui.dock.IDockEventListener
            public void onEnterEdit(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enable ? 1 : 0);
                    boolean _status = this.mRemote.transact(3, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onEnterEdit(enable);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.systemui.dock.IDockEventListener
            public void onDockEvent(int eventId, String params) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eventId);
                    _data.writeString(params);
                    boolean _status = this.mRemote.transact(4, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onDockEvent(eventId, params);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IDockEventListener impl) {
            if (Proxy.sDefaultImpl == null && impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static IDockEventListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
