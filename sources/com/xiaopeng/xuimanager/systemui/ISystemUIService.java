package com.xiaopeng.xuimanager.systemui;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.xuimanager.systemui.osd.IOsdListener;
import com.xiaopeng.xuimanager.systemui.systembar.ISystemBarListener;
import com.xiaopeng.xuimanager.systemui.systembar.SystemBarItem;
/* loaded from: classes.dex */
public interface ISystemUIService extends IInterface {
    int cancelSystemBar(String str, String str2) throws RemoteException;

    int hideOsd(IOsdListener iOsdListener, String str) throws RemoteException;

    int registerSystemBarListener(String str, ISystemBarListener iSystemBarListener) throws RemoteException;

    int showOsd(IOsdListener iOsdListener, int i, String str) throws RemoteException;

    int showSystemBar(String str, String str2, SystemBarItem systemBarItem) throws RemoteException;

    int unRegisterSystemBarListener(String str, ISystemBarListener iSystemBarListener) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements ISystemUIService {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.systemui.ISystemUIService";
        static final int TRANSACTION_cancelSystemBar = 6;
        static final int TRANSACTION_hideOsd = 2;
        static final int TRANSACTION_registerSystemBarListener = 4;
        static final int TRANSACTION_showOsd = 1;
        static final int TRANSACTION_showSystemBar = 3;
        static final int TRANSACTION_unRegisterSystemBarListener = 5;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISystemUIService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof ISystemUIService)) {
                return (ISystemUIService) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            SystemBarItem _arg2;
            if (code == 1598968902) {
                reply.writeString(DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    IOsdListener _arg0 = IOsdListener.Stub.asInterface(data.readStrongBinder());
                    int _arg1 = data.readInt();
                    String _arg22 = data.readString();
                    int _result = showOsd(_arg0, _arg1, _arg22);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    IOsdListener _arg02 = IOsdListener.Stub.asInterface(data.readStrongBinder());
                    String _arg12 = data.readString();
                    int _result2 = hideOsd(_arg02, _arg12);
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg03 = data.readString();
                    String _arg13 = data.readString();
                    if (data.readInt() != 0) {
                        _arg2 = SystemBarItem.CREATOR.createFromParcel(data);
                    } else {
                        _arg2 = null;
                    }
                    int _result3 = showSystemBar(_arg03, _arg13, _arg2);
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg04 = data.readString();
                    ISystemBarListener _arg14 = ISystemBarListener.Stub.asInterface(data.readStrongBinder());
                    int _result4 = registerSystemBarListener(_arg04, _arg14);
                    reply.writeNoException();
                    reply.writeInt(_result4);
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg05 = data.readString();
                    ISystemBarListener _arg15 = ISystemBarListener.Stub.asInterface(data.readStrongBinder());
                    int _result5 = unRegisterSystemBarListener(_arg05, _arg15);
                    reply.writeNoException();
                    reply.writeInt(_result5);
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg06 = data.readString();
                    String _arg16 = data.readString();
                    int _result6 = cancelSystemBar(_arg06, _arg16);
                    reply.writeNoException();
                    reply.writeInt(_result6);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* loaded from: classes.dex */
        private static class Proxy implements ISystemUIService {
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

            @Override // com.xiaopeng.xuimanager.systemui.ISystemUIService
            public int showOsd(IOsdListener listener, int osdType, String regionId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    _data.writeInt(osdType);
                    _data.writeString(regionId);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.systemui.ISystemUIService
            public int hideOsd(IOsdListener listener, String regionId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    _data.writeString(regionId);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.systemui.ISystemUIService
            public int showSystemBar(String pkg, String id, SystemBarItem bar) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkg);
                    _data.writeString(id);
                    if (bar != null) {
                        _data.writeInt(1);
                        bar.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.systemui.ISystemUIService
            public int registerSystemBarListener(String pkg, ISystemBarListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkg);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.systemui.ISystemUIService
            public int unRegisterSystemBarListener(String pkg, ISystemBarListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkg);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.systemui.ISystemUIService
            public int cancelSystemBar(String pkg, String id) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkg);
                    _data.writeString(id);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}
