package com.xiaopeng.xuimanager.themeoperation;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.xuimanager.themeoperation.IThemeOperationListener;

/* loaded from: classes.dex */
public interface IThemeOperation extends IInterface {
    boolean deleteTheme(ThemeOperationData themeOperationData) throws RemoteException;

    ThemeOperationData getCurrentTheme() throws RemoteException;

    ThemeOperationData[] getThemes() throws RemoteException;

    void registerListener(IThemeOperationListener iThemeOperationListener) throws RemoteException;

    boolean resetTheme(ThemeOperationData themeOperationData) throws RemoteException;

    boolean selectEffect(AbilityEffect abilityEffect) throws RemoteException;

    boolean selectTheme(ThemeOperationData themeOperationData) throws RemoteException;

    void unRegisterListener(IThemeOperationListener iThemeOperationListener) throws RemoteException;

    boolean updateTheme(ThemeOperationData themeOperationData) throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements IThemeOperation {
        @Override // com.xiaopeng.xuimanager.themeoperation.IThemeOperation
        public ThemeOperationData[] getThemes() throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.themeoperation.IThemeOperation
        public ThemeOperationData getCurrentTheme() throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.themeoperation.IThemeOperation
        public boolean selectTheme(ThemeOperationData themeData) throws RemoteException {
            return false;
        }

        @Override // com.xiaopeng.xuimanager.themeoperation.IThemeOperation
        public boolean resetTheme(ThemeOperationData themeData) throws RemoteException {
            return false;
        }

        @Override // com.xiaopeng.xuimanager.themeoperation.IThemeOperation
        public boolean updateTheme(ThemeOperationData themeData) throws RemoteException {
            return false;
        }

        @Override // com.xiaopeng.xuimanager.themeoperation.IThemeOperation
        public boolean deleteTheme(ThemeOperationData themeData) throws RemoteException {
            return false;
        }

        @Override // com.xiaopeng.xuimanager.themeoperation.IThemeOperation
        public boolean selectEffect(AbilityEffect effect) throws RemoteException {
            return false;
        }

        @Override // com.xiaopeng.xuimanager.themeoperation.IThemeOperation
        public void registerListener(IThemeOperationListener listener) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.themeoperation.IThemeOperation
        public void unRegisterListener(IThemeOperationListener listener) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IThemeOperation {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.themeoperation.IThemeOperation";
        static final int TRANSACTION_deleteTheme = 6;
        static final int TRANSACTION_getCurrentTheme = 2;
        static final int TRANSACTION_getThemes = 1;
        static final int TRANSACTION_registerListener = 8;
        static final int TRANSACTION_resetTheme = 4;
        static final int TRANSACTION_selectEffect = 7;
        static final int TRANSACTION_selectTheme = 3;
        static final int TRANSACTION_unRegisterListener = 9;
        static final int TRANSACTION_updateTheme = 5;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IThemeOperation asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IThemeOperation)) {
                return (IThemeOperation) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            ThemeOperationData _arg0;
            ThemeOperationData _arg02;
            ThemeOperationData _arg03;
            ThemeOperationData _arg04;
            AbilityEffect _arg05;
            if (code == 1598968902) {
                reply.writeString(DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    ThemeOperationData[] _result = getThemes();
                    reply.writeNoException();
                    reply.writeTypedArray(_result, 1);
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    ThemeOperationData _result2 = getCurrentTheme();
                    reply.writeNoException();
                    if (_result2 != null) {
                        reply.writeInt(1);
                        _result2.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = ThemeOperationData.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    boolean selectTheme = selectTheme(_arg0);
                    reply.writeNoException();
                    reply.writeInt(selectTheme ? 1 : 0);
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg02 = ThemeOperationData.CREATOR.createFromParcel(data);
                    } else {
                        _arg02 = null;
                    }
                    boolean resetTheme = resetTheme(_arg02);
                    reply.writeNoException();
                    reply.writeInt(resetTheme ? 1 : 0);
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg03 = ThemeOperationData.CREATOR.createFromParcel(data);
                    } else {
                        _arg03 = null;
                    }
                    boolean updateTheme = updateTheme(_arg03);
                    reply.writeNoException();
                    reply.writeInt(updateTheme ? 1 : 0);
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg04 = ThemeOperationData.CREATOR.createFromParcel(data);
                    } else {
                        _arg04 = null;
                    }
                    boolean deleteTheme = deleteTheme(_arg04);
                    reply.writeNoException();
                    reply.writeInt(deleteTheme ? 1 : 0);
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg05 = AbilityEffect.CREATOR.createFromParcel(data);
                    } else {
                        _arg05 = null;
                    }
                    boolean selectEffect = selectEffect(_arg05);
                    reply.writeNoException();
                    reply.writeInt(selectEffect ? 1 : 0);
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    IThemeOperationListener _arg06 = IThemeOperationListener.Stub.asInterface(data.readStrongBinder());
                    registerListener(_arg06);
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    IThemeOperationListener _arg07 = IThemeOperationListener.Stub.asInterface(data.readStrongBinder());
                    unRegisterListener(_arg07);
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements IThemeOperation {
            public static IThemeOperation sDefaultImpl;
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

            @Override // com.xiaopeng.xuimanager.themeoperation.IThemeOperation
            public ThemeOperationData[] getThemes() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(1, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getThemes();
                    }
                    _reply.readException();
                    ThemeOperationData[] _result = (ThemeOperationData[]) _reply.createTypedArray(ThemeOperationData.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.themeoperation.IThemeOperation
            public ThemeOperationData getCurrentTheme() throws RemoteException {
                ThemeOperationData _result;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(2, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCurrentTheme();
                    }
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = ThemeOperationData.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.themeoperation.IThemeOperation
            public boolean selectTheme(ThemeOperationData themeData) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (themeData != null) {
                        _data.writeInt(1);
                        themeData.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    boolean _status = this.mRemote.transact(3, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().selectTheme(themeData);
                    }
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.themeoperation.IThemeOperation
            public boolean resetTheme(ThemeOperationData themeData) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (themeData != null) {
                        _data.writeInt(1);
                        themeData.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    boolean _status = this.mRemote.transact(4, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().resetTheme(themeData);
                    }
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.themeoperation.IThemeOperation
            public boolean updateTheme(ThemeOperationData themeData) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (themeData != null) {
                        _data.writeInt(1);
                        themeData.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    boolean _status = this.mRemote.transact(5, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().updateTheme(themeData);
                    }
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.themeoperation.IThemeOperation
            public boolean deleteTheme(ThemeOperationData themeData) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (themeData != null) {
                        _data.writeInt(1);
                        themeData.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    boolean _status = this.mRemote.transact(6, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().deleteTheme(themeData);
                    }
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.themeoperation.IThemeOperation
            public boolean selectEffect(AbilityEffect effect) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (effect != null) {
                        _data.writeInt(1);
                        effect.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    boolean _status = this.mRemote.transact(7, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().selectEffect(effect);
                    }
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.themeoperation.IThemeOperation
            public void registerListener(IThemeOperationListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = this.mRemote.transact(8, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerListener(listener);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.themeoperation.IThemeOperation
            public void unRegisterListener(IThemeOperationListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = this.mRemote.transact(9, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unRegisterListener(listener);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IThemeOperation impl) {
            if (Proxy.sDefaultImpl == null && impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static IThemeOperation getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
