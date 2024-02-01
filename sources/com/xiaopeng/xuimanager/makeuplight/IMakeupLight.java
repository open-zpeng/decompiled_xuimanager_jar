package com.xiaopeng.xuimanager.makeuplight;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.xuimanager.makeuplight.IMakeupLightEventListener;
import java.util.List;

/* loaded from: classes.dex */
public interface IMakeupLight extends IInterface {
    List<String> getColorTemperature() throws RemoteException;

    int getLuminance() throws RemoteException;

    int getMakeupAvailable() throws RemoteException;

    void loadMakeupEffect() throws RemoteException;

    void registerListener(IMakeupLightEventListener iMakeupLightEventListener) throws RemoteException;

    int runEffect(String str, int i) throws RemoteException;

    int setAliasColorTemperature(String str) throws RemoteException;

    int setColorTemperature(int i, int i2) throws RemoteException;

    int setLuminance(int i) throws RemoteException;

    List<String> showAliasColorTemperature() throws RemoteException;

    List<String> showMakeupEffect() throws RemoteException;

    int stopEffect() throws RemoteException;

    void unregisterListener(IMakeupLightEventListener iMakeupLightEventListener) throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements IMakeupLight {
        @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLight
        public void registerListener(IMakeupLightEventListener listener) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLight
        public void unregisterListener(IMakeupLightEventListener listener) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLight
        public void loadMakeupEffect() throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLight
        public List<String> showMakeupEffect() throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLight
        public List<String> showAliasColorTemperature() throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLight
        public int getMakeupAvailable() throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLight
        public int setColorTemperature(int rgb, int white) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLight
        public int setAliasColorTemperature(String alias) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLight
        public List<String> getColorTemperature() throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLight
        public int setLuminance(int lux) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLight
        public int getLuminance() throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLight
        public int runEffect(String effect, int count) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLight
        public int stopEffect() throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IMakeupLight {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.makeuplight.IMakeupLight";
        static final int TRANSACTION_getColorTemperature = 9;
        static final int TRANSACTION_getLuminance = 11;
        static final int TRANSACTION_getMakeupAvailable = 6;
        static final int TRANSACTION_loadMakeupEffect = 3;
        static final int TRANSACTION_registerListener = 1;
        static final int TRANSACTION_runEffect = 12;
        static final int TRANSACTION_setAliasColorTemperature = 8;
        static final int TRANSACTION_setColorTemperature = 7;
        static final int TRANSACTION_setLuminance = 10;
        static final int TRANSACTION_showAliasColorTemperature = 5;
        static final int TRANSACTION_showMakeupEffect = 4;
        static final int TRANSACTION_stopEffect = 13;
        static final int TRANSACTION_unregisterListener = 2;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMakeupLight asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IMakeupLight)) {
                return (IMakeupLight) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code == 1598968902) {
                reply.writeString(DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    IMakeupLightEventListener _arg0 = IMakeupLightEventListener.Stub.asInterface(data.readStrongBinder());
                    registerListener(_arg0);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    IMakeupLightEventListener _arg02 = IMakeupLightEventListener.Stub.asInterface(data.readStrongBinder());
                    unregisterListener(_arg02);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    loadMakeupEffect();
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    List<String> _result = showMakeupEffect();
                    reply.writeNoException();
                    reply.writeStringList(_result);
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    List<String> _result2 = showAliasColorTemperature();
                    reply.writeNoException();
                    reply.writeStringList(_result2);
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    int _result3 = getMakeupAvailable();
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg03 = data.readInt();
                    int _arg1 = data.readInt();
                    int _result4 = setColorTemperature(_arg03, _arg1);
                    reply.writeNoException();
                    reply.writeInt(_result4);
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg04 = data.readString();
                    int _result5 = setAliasColorTemperature(_arg04);
                    reply.writeNoException();
                    reply.writeInt(_result5);
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    List<String> _result6 = getColorTemperature();
                    reply.writeNoException();
                    reply.writeStringList(_result6);
                    return true;
                case 10:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg05 = data.readInt();
                    int _result7 = setLuminance(_arg05);
                    reply.writeNoException();
                    reply.writeInt(_result7);
                    return true;
                case 11:
                    data.enforceInterface(DESCRIPTOR);
                    int _result8 = getLuminance();
                    reply.writeNoException();
                    reply.writeInt(_result8);
                    return true;
                case 12:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg06 = data.readString();
                    int _arg12 = data.readInt();
                    int _result9 = runEffect(_arg06, _arg12);
                    reply.writeNoException();
                    reply.writeInt(_result9);
                    return true;
                case 13:
                    data.enforceInterface(DESCRIPTOR);
                    int _result10 = stopEffect();
                    reply.writeNoException();
                    reply.writeInt(_result10);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements IMakeupLight {
            public static IMakeupLight sDefaultImpl;
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

            @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLight
            public void registerListener(IMakeupLightEventListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = this.mRemote.transact(1, _data, _reply, 0);
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

            @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLight
            public void unregisterListener(IMakeupLightEventListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = this.mRemote.transact(2, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterListener(listener);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLight
            public void loadMakeupEffect() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(3, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().loadMakeupEffect();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLight
            public List<String> showMakeupEffect() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(4, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().showMakeupEffect();
                    }
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLight
            public List<String> showAliasColorTemperature() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(5, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().showAliasColorTemperature();
                    }
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLight
            public int getMakeupAvailable() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(6, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getMakeupAvailable();
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLight
            public int setColorTemperature(int rgb, int white) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(rgb);
                    _data.writeInt(white);
                    boolean _status = this.mRemote.transact(7, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setColorTemperature(rgb, white);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLight
            public int setAliasColorTemperature(String alias) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(alias);
                    boolean _status = this.mRemote.transact(8, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setAliasColorTemperature(alias);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLight
            public List<String> getColorTemperature() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(9, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getColorTemperature();
                    }
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLight
            public int setLuminance(int lux) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(lux);
                    boolean _status = this.mRemote.transact(10, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setLuminance(lux);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLight
            public int getLuminance() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(11, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getLuminance();
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLight
            public int runEffect(String effect, int count) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(effect);
                    _data.writeInt(count);
                    boolean _status = this.mRemote.transact(12, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().runEffect(effect, count);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.makeuplight.IMakeupLight
            public int stopEffect() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(13, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().stopEffect();
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

        public static boolean setDefaultImpl(IMakeupLight impl) {
            if (Proxy.sDefaultImpl == null && impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static IMakeupLight getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
