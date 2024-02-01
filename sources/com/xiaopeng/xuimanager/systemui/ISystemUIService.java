package com.xiaopeng.xuimanager.systemui;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.xuimanager.systemui.dock.DockItem;
import com.xiaopeng.xuimanager.systemui.dock.IDockEventListener;
import com.xiaopeng.xuimanager.systemui.masklayer.IMaskLayerListener;
import com.xiaopeng.xuimanager.systemui.osd.IOsdListener;
import com.xiaopeng.xuimanager.systemui.systembar.ISystemBarListener;
import com.xiaopeng.xuimanager.systemui.systembar.SystemBarItem;
import java.util.List;

/* loaded from: classes.dex */
public interface ISystemUIService extends IInterface {
    boolean canDockEdit(String str) throws RemoteException;

    int cancelSystemBar(String str, String str2) throws RemoteException;

    int dismissMaskLayer(IMaskLayerListener iMaskLayerListener, int i) throws RemoteException;

    void enterDockEdit(String str) throws RemoteException;

    List<DockItem> getDockItems(String str) throws RemoteException;

    List<DockItem> getShortcutAndComponents(String str) throws RemoteException;

    int hideOsd(IOsdListener iOsdListener, String str) throws RemoteException;

    int registerDockListener(String str, IDockEventListener iDockEventListener) throws RemoteException;

    int registerSystemBarListener(String str, ISystemBarListener iSystemBarListener) throws RemoteException;

    int showMaskLayer(IMaskLayerListener iMaskLayerListener, boolean z, int i) throws RemoteException;

    int showOsd(IOsdListener iOsdListener, int i, String str) throws RemoteException;

    int showSystemBar(String str, String str2, SystemBarItem systemBarItem) throws RemoteException;

    int unRegisterDockListener(String str, IDockEventListener iDockEventListener) throws RemoteException;

    int unRegisterSystemBarListener(String str, ISystemBarListener iSystemBarListener) throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements ISystemUIService {
        @Override // com.xiaopeng.xuimanager.systemui.ISystemUIService
        public int showOsd(IOsdListener listener, int osdType, String regionId) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.systemui.ISystemUIService
        public int hideOsd(IOsdListener listener, String regionId) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.systemui.ISystemUIService
        public int showMaskLayer(IMaskLayerListener listener, boolean isStackWindow, int screenId) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.systemui.ISystemUIService
        public int dismissMaskLayer(IMaskLayerListener listener, int screenId) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.systemui.ISystemUIService
        public int showSystemBar(String pkg, String id, SystemBarItem bar) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.systemui.ISystemUIService
        public int registerSystemBarListener(String pkg, ISystemBarListener listener) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.systemui.ISystemUIService
        public int unRegisterSystemBarListener(String pkg, ISystemBarListener listener) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.systemui.ISystemUIService
        public int cancelSystemBar(String pkg, String id) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.systemui.ISystemUIService
        public List<DockItem> getDockItems(String params) throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.systemui.ISystemUIService
        public List<DockItem> getShortcutAndComponents(String params) throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.systemui.ISystemUIService
        public void enterDockEdit(String params) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.systemui.ISystemUIService
        public boolean canDockEdit(String params) throws RemoteException {
            return false;
        }

        @Override // com.xiaopeng.xuimanager.systemui.ISystemUIService
        public int registerDockListener(String pkg, IDockEventListener listener) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.systemui.ISystemUIService
        public int unRegisterDockListener(String pkg, IDockEventListener listener) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements ISystemUIService {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.systemui.ISystemUIService";
        static final int TRANSACTION_canDockEdit = 12;
        static final int TRANSACTION_cancelSystemBar = 8;
        static final int TRANSACTION_dismissMaskLayer = 4;
        static final int TRANSACTION_enterDockEdit = 11;
        static final int TRANSACTION_getDockItems = 9;
        static final int TRANSACTION_getShortcutAndComponents = 10;
        static final int TRANSACTION_hideOsd = 2;
        static final int TRANSACTION_registerDockListener = 13;
        static final int TRANSACTION_registerSystemBarListener = 6;
        static final int TRANSACTION_showMaskLayer = 3;
        static final int TRANSACTION_showOsd = 1;
        static final int TRANSACTION_showSystemBar = 5;
        static final int TRANSACTION_unRegisterDockListener = 14;
        static final int TRANSACTION_unRegisterSystemBarListener = 7;

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
                    IMaskLayerListener _arg03 = IMaskLayerListener.Stub.asInterface(data.readStrongBinder());
                    boolean _arg13 = data.readInt() != 0;
                    int _arg23 = data.readInt();
                    int _result3 = showMaskLayer(_arg03, _arg13, _arg23);
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    IMaskLayerListener _arg04 = IMaskLayerListener.Stub.asInterface(data.readStrongBinder());
                    int _arg14 = data.readInt();
                    int _result4 = dismissMaskLayer(_arg04, _arg14);
                    reply.writeNoException();
                    reply.writeInt(_result4);
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg05 = data.readString();
                    String _arg15 = data.readString();
                    if (data.readInt() != 0) {
                        _arg2 = SystemBarItem.CREATOR.createFromParcel(data);
                    } else {
                        _arg2 = null;
                    }
                    int _result5 = showSystemBar(_arg05, _arg15, _arg2);
                    reply.writeNoException();
                    reply.writeInt(_result5);
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg06 = data.readString();
                    ISystemBarListener _arg16 = ISystemBarListener.Stub.asInterface(data.readStrongBinder());
                    int _result6 = registerSystemBarListener(_arg06, _arg16);
                    reply.writeNoException();
                    reply.writeInt(_result6);
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg07 = data.readString();
                    ISystemBarListener _arg17 = ISystemBarListener.Stub.asInterface(data.readStrongBinder());
                    int _result7 = unRegisterSystemBarListener(_arg07, _arg17);
                    reply.writeNoException();
                    reply.writeInt(_result7);
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg08 = data.readString();
                    String _arg18 = data.readString();
                    int _result8 = cancelSystemBar(_arg08, _arg18);
                    reply.writeNoException();
                    reply.writeInt(_result8);
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg09 = data.readString();
                    List<DockItem> _result9 = getDockItems(_arg09);
                    reply.writeNoException();
                    reply.writeTypedList(_result9);
                    return true;
                case 10:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg010 = data.readString();
                    List<DockItem> _result10 = getShortcutAndComponents(_arg010);
                    reply.writeNoException();
                    reply.writeTypedList(_result10);
                    return true;
                case 11:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg011 = data.readString();
                    enterDockEdit(_arg011);
                    reply.writeNoException();
                    return true;
                case 12:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg012 = data.readString();
                    boolean canDockEdit = canDockEdit(_arg012);
                    reply.writeNoException();
                    reply.writeInt(canDockEdit ? 1 : 0);
                    return true;
                case 13:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg013 = data.readString();
                    IDockEventListener _arg19 = IDockEventListener.Stub.asInterface(data.readStrongBinder());
                    int _result11 = registerDockListener(_arg013, _arg19);
                    reply.writeNoException();
                    reply.writeInt(_result11);
                    return true;
                case 14:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg014 = data.readString();
                    IDockEventListener _arg110 = IDockEventListener.Stub.asInterface(data.readStrongBinder());
                    int _result12 = unRegisterDockListener(_arg014, _arg110);
                    reply.writeNoException();
                    reply.writeInt(_result12);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements ISystemUIService {
            public static ISystemUIService sDefaultImpl;
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
                    boolean _status = this.mRemote.transact(1, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().showOsd(listener, osdType, regionId);
                    }
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
                    boolean _status = this.mRemote.transact(2, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().hideOsd(listener, regionId);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.systemui.ISystemUIService
            public int showMaskLayer(IMaskLayerListener listener, boolean isStackWindow, int screenId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    _data.writeInt(isStackWindow ? 1 : 0);
                    _data.writeInt(screenId);
                    boolean _status = this.mRemote.transact(3, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().showMaskLayer(listener, isStackWindow, screenId);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.systemui.ISystemUIService
            public int dismissMaskLayer(IMaskLayerListener listener, int screenId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    _data.writeInt(screenId);
                    boolean _status = this.mRemote.transact(4, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().dismissMaskLayer(listener, screenId);
                    }
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
                    boolean _status = this.mRemote.transact(5, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().showSystemBar(pkg, id, bar);
                    }
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
                    boolean _status = this.mRemote.transact(6, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().registerSystemBarListener(pkg, listener);
                    }
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
                    boolean _status = this.mRemote.transact(7, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().unRegisterSystemBarListener(pkg, listener);
                    }
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
                    boolean _status = this.mRemote.transact(8, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().cancelSystemBar(pkg, id);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.systemui.ISystemUIService
            public List<DockItem> getDockItems(String params) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(params);
                    boolean _status = this.mRemote.transact(9, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDockItems(params);
                    }
                    _reply.readException();
                    List<DockItem> _result = _reply.createTypedArrayList(DockItem.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.systemui.ISystemUIService
            public List<DockItem> getShortcutAndComponents(String params) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(params);
                    boolean _status = this.mRemote.transact(10, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getShortcutAndComponents(params);
                    }
                    _reply.readException();
                    List<DockItem> _result = _reply.createTypedArrayList(DockItem.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.systemui.ISystemUIService
            public void enterDockEdit(String params) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(params);
                    boolean _status = this.mRemote.transact(11, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().enterDockEdit(params);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.systemui.ISystemUIService
            public boolean canDockEdit(String params) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(params);
                    boolean _status = this.mRemote.transact(12, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().canDockEdit(params);
                    }
                    _reply.readException();
                    boolean _status2 = _reply.readInt() != 0;
                    return _status2;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.systemui.ISystemUIService
            public int registerDockListener(String pkg, IDockEventListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkg);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = this.mRemote.transact(13, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().registerDockListener(pkg, listener);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.systemui.ISystemUIService
            public int unRegisterDockListener(String pkg, IDockEventListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkg);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = this.mRemote.transact(14, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().unRegisterDockListener(pkg, listener);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ISystemUIService impl) {
            if (Proxy.sDefaultImpl == null && impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static ISystemUIService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
