package com.xiaopeng.xuimanager.ambientlight;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.xuimanager.ambientlight.IAmbientLightEventListener;
import java.util.List;

/* loaded from: classes.dex */
public interface IAmbientLight extends IInterface {
    int getAmbientLightBright() throws RemoteException;

    int getAmbientLightDoubleFirstColor(String str) throws RemoteException;

    int getAmbientLightDoubleSecondColor(String str) throws RemoteException;

    String getAmbientLightEffectType() throws RemoteException;

    List<String> getAmbientLightEffectTypeList() throws RemoteException;

    int getAmbientLightMonoColor(String str) throws RemoteException;

    boolean getAmbientLightOpen() throws RemoteException;

    boolean getDoubleThemeColorEnable(String str) throws RemoteException;

    boolean getMusicSpectrumEnable() throws RemoteException;

    boolean isSupportDoubleThemeColor(String str) throws RemoteException;

    int pausePlay() throws RemoteException;

    void registerListener(IAmbientLightEventListener iAmbientLightEventListener) throws RemoteException;

    int requestPermission(boolean z) throws RemoteException;

    void setAmbientLightBright(int i) throws RemoteException;

    void setAmbientLightDoubleColor(String str, int i, int i2) throws RemoteException;

    void setAmbientLightEffectType(String str) throws RemoteException;

    void setAmbientLightMemoryBright(int i) throws RemoteException;

    void setAmbientLightMonoColor(String str, int i) throws RemoteException;

    void setAmbientLightOpen(boolean z) throws RemoteException;

    void setDoubleThemeColorEnable(String str, boolean z) throws RemoteException;

    void setMusicRhythmMode(boolean z) throws RemoteException;

    void setMusicSpectrumEnable(boolean z) throws RemoteException;

    int startPlay(String[] strArr) throws RemoteException;

    int stopPlay() throws RemoteException;

    void unregisterListener(IAmbientLightEventListener iAmbientLightEventListener) throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements IAmbientLight {
        @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
        public void registerListener(IAmbientLightEventListener listener) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
        public void unregisterListener(IAmbientLightEventListener listener) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
        public boolean getMusicSpectrumEnable() throws RemoteException {
            return false;
        }

        @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
        public void setMusicSpectrumEnable(boolean enable) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
        public void setMusicRhythmMode(boolean enable) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
        public void setAmbientLightMonoColor(String effectType, int color) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
        public int getAmbientLightMonoColor(String effectType) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
        public void setAmbientLightDoubleColor(String effectType, int first_color, int second_color) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
        public int getAmbientLightDoubleFirstColor(String effectType) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
        public int getAmbientLightDoubleSecondColor(String effectType) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
        public boolean getDoubleThemeColorEnable(String effectType) throws RemoteException {
            return false;
        }

        @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
        public void setDoubleThemeColorEnable(String effectType, boolean enable) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
        public String getAmbientLightEffectType() throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
        public void setAmbientLightEffectType(String effectType) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
        public boolean getAmbientLightOpen() throws RemoteException {
            return false;
        }

        @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
        public void setAmbientLightOpen(boolean enable) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
        public List<String> getAmbientLightEffectTypeList() throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
        public boolean isSupportDoubleThemeColor(String effectType) throws RemoteException {
            return false;
        }

        @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
        public void setAmbientLightBright(int bright) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
        public int getAmbientLightBright() throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
        public int startPlay(String[] effectData) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
        public int pausePlay() throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
        public int stopPlay() throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
        public void setAmbientLightMemoryBright(int bright) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
        public int requestPermission(boolean apply) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IAmbientLight {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.ambientlight.IAmbientLight";
        static final int TRANSACTION_getAmbientLightBright = 20;
        static final int TRANSACTION_getAmbientLightDoubleFirstColor = 9;
        static final int TRANSACTION_getAmbientLightDoubleSecondColor = 10;
        static final int TRANSACTION_getAmbientLightEffectType = 13;
        static final int TRANSACTION_getAmbientLightEffectTypeList = 17;
        static final int TRANSACTION_getAmbientLightMonoColor = 7;
        static final int TRANSACTION_getAmbientLightOpen = 15;
        static final int TRANSACTION_getDoubleThemeColorEnable = 11;
        static final int TRANSACTION_getMusicSpectrumEnable = 3;
        static final int TRANSACTION_isSupportDoubleThemeColor = 18;
        static final int TRANSACTION_pausePlay = 22;
        static final int TRANSACTION_registerListener = 1;
        static final int TRANSACTION_requestPermission = 25;
        static final int TRANSACTION_setAmbientLightBright = 19;
        static final int TRANSACTION_setAmbientLightDoubleColor = 8;
        static final int TRANSACTION_setAmbientLightEffectType = 14;
        static final int TRANSACTION_setAmbientLightMemoryBright = 24;
        static final int TRANSACTION_setAmbientLightMonoColor = 6;
        static final int TRANSACTION_setAmbientLightOpen = 16;
        static final int TRANSACTION_setDoubleThemeColorEnable = 12;
        static final int TRANSACTION_setMusicRhythmMode = 5;
        static final int TRANSACTION_setMusicSpectrumEnable = 4;
        static final int TRANSACTION_startPlay = 21;
        static final int TRANSACTION_stopPlay = 23;
        static final int TRANSACTION_unregisterListener = 2;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAmbientLight asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IAmbientLight)) {
                return (IAmbientLight) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean _arg0;
            if (code == 1598968902) {
                reply.writeString(DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    registerListener(IAmbientLightEventListener.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    unregisterListener(IAmbientLightEventListener.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    boolean musicSpectrumEnable = getMusicSpectrumEnable();
                    reply.writeNoException();
                    reply.writeInt(musicSpectrumEnable ? 1 : 0);
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt() != 0;
                    setMusicSpectrumEnable(_arg0);
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt() != 0;
                    setMusicRhythmMode(_arg0);
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg02 = data.readString();
                    int _arg1 = data.readInt();
                    setAmbientLightMonoColor(_arg02, _arg1);
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    int _result = getAmbientLightMonoColor(data.readString());
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg03 = data.readString();
                    int _arg12 = data.readInt();
                    int _arg2 = data.readInt();
                    setAmbientLightDoubleColor(_arg03, _arg12, _arg2);
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    int _result2 = getAmbientLightDoubleFirstColor(data.readString());
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 10:
                    data.enforceInterface(DESCRIPTOR);
                    int _result3 = getAmbientLightDoubleSecondColor(data.readString());
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case 11:
                    data.enforceInterface(DESCRIPTOR);
                    boolean doubleThemeColorEnable = getDoubleThemeColorEnable(data.readString());
                    reply.writeNoException();
                    reply.writeInt(doubleThemeColorEnable ? 1 : 0);
                    return true;
                case 12:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg04 = data.readString();
                    _arg0 = data.readInt() != 0;
                    setDoubleThemeColorEnable(_arg04, _arg0);
                    reply.writeNoException();
                    return true;
                case 13:
                    data.enforceInterface(DESCRIPTOR);
                    String _result4 = getAmbientLightEffectType();
                    reply.writeNoException();
                    reply.writeString(_result4);
                    return true;
                case 14:
                    data.enforceInterface(DESCRIPTOR);
                    setAmbientLightEffectType(data.readString());
                    reply.writeNoException();
                    return true;
                case 15:
                    data.enforceInterface(DESCRIPTOR);
                    boolean ambientLightOpen = getAmbientLightOpen();
                    reply.writeNoException();
                    reply.writeInt(ambientLightOpen ? 1 : 0);
                    return true;
                case 16:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt() != 0;
                    setAmbientLightOpen(_arg0);
                    reply.writeNoException();
                    return true;
                case 17:
                    data.enforceInterface(DESCRIPTOR);
                    List<String> _result5 = getAmbientLightEffectTypeList();
                    reply.writeNoException();
                    reply.writeStringList(_result5);
                    return true;
                case 18:
                    data.enforceInterface(DESCRIPTOR);
                    boolean isSupportDoubleThemeColor = isSupportDoubleThemeColor(data.readString());
                    reply.writeNoException();
                    reply.writeInt(isSupportDoubleThemeColor ? 1 : 0);
                    return true;
                case 19:
                    data.enforceInterface(DESCRIPTOR);
                    setAmbientLightBright(data.readInt());
                    reply.writeNoException();
                    return true;
                case 20:
                    data.enforceInterface(DESCRIPTOR);
                    int _result6 = getAmbientLightBright();
                    reply.writeNoException();
                    reply.writeInt(_result6);
                    return true;
                case TRANSACTION_startPlay /* 21 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _result7 = startPlay(data.createStringArray());
                    reply.writeNoException();
                    reply.writeInt(_result7);
                    return true;
                case TRANSACTION_pausePlay /* 22 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _result8 = pausePlay();
                    reply.writeNoException();
                    reply.writeInt(_result8);
                    return true;
                case TRANSACTION_stopPlay /* 23 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _result9 = stopPlay();
                    reply.writeNoException();
                    reply.writeInt(_result9);
                    return true;
                case TRANSACTION_setAmbientLightMemoryBright /* 24 */:
                    data.enforceInterface(DESCRIPTOR);
                    setAmbientLightMemoryBright(data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_requestPermission /* 25 */:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt() != 0;
                    int _result10 = requestPermission(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result10);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements IAmbientLight {
            public static IAmbientLight sDefaultImpl;
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

            @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
            public void registerListener(IAmbientLightEventListener listener) throws RemoteException {
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

            @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
            public void unregisterListener(IAmbientLightEventListener listener) throws RemoteException {
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

            @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
            public boolean getMusicSpectrumEnable() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(3, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getMusicSpectrumEnable();
                    }
                    _reply.readException();
                    boolean _status2 = _reply.readInt() != 0;
                    return _status2;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
            public void setMusicSpectrumEnable(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enable ? 1 : 0);
                    boolean _status = this.mRemote.transact(4, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setMusicSpectrumEnable(enable);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
            public void setMusicRhythmMode(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enable ? 1 : 0);
                    boolean _status = this.mRemote.transact(5, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setMusicRhythmMode(enable);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
            public void setAmbientLightMonoColor(String effectType, int color) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(effectType);
                    _data.writeInt(color);
                    boolean _status = this.mRemote.transact(6, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setAmbientLightMonoColor(effectType, color);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
            public int getAmbientLightMonoColor(String effectType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(effectType);
                    boolean _status = this.mRemote.transact(7, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAmbientLightMonoColor(effectType);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
            public void setAmbientLightDoubleColor(String effectType, int first_color, int second_color) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(effectType);
                    _data.writeInt(first_color);
                    _data.writeInt(second_color);
                    boolean _status = this.mRemote.transact(8, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setAmbientLightDoubleColor(effectType, first_color, second_color);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
            public int getAmbientLightDoubleFirstColor(String effectType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(effectType);
                    boolean _status = this.mRemote.transact(9, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAmbientLightDoubleFirstColor(effectType);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
            public int getAmbientLightDoubleSecondColor(String effectType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(effectType);
                    boolean _status = this.mRemote.transact(10, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAmbientLightDoubleSecondColor(effectType);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
            public boolean getDoubleThemeColorEnable(String effectType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(effectType);
                    boolean _status = this.mRemote.transact(11, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDoubleThemeColorEnable(effectType);
                    }
                    _reply.readException();
                    boolean _status2 = _reply.readInt() != 0;
                    return _status2;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
            public void setDoubleThemeColorEnable(String effectType, boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(effectType);
                    _data.writeInt(enable ? 1 : 0);
                    boolean _status = this.mRemote.transact(12, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setDoubleThemeColorEnable(effectType, enable);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
            public String getAmbientLightEffectType() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(13, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAmbientLightEffectType();
                    }
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
            public void setAmbientLightEffectType(String effectType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(effectType);
                    boolean _status = this.mRemote.transact(14, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setAmbientLightEffectType(effectType);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
            public boolean getAmbientLightOpen() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(15, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAmbientLightOpen();
                    }
                    _reply.readException();
                    boolean _status2 = _reply.readInt() != 0;
                    return _status2;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
            public void setAmbientLightOpen(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enable ? 1 : 0);
                    boolean _status = this.mRemote.transact(16, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setAmbientLightOpen(enable);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
            public List<String> getAmbientLightEffectTypeList() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(17, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAmbientLightEffectTypeList();
                    }
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
            public boolean isSupportDoubleThemeColor(String effectType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(effectType);
                    boolean _status = this.mRemote.transact(18, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isSupportDoubleThemeColor(effectType);
                    }
                    _reply.readException();
                    boolean _status2 = _reply.readInt() != 0;
                    return _status2;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
            public void setAmbientLightBright(int bright) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(bright);
                    boolean _status = this.mRemote.transact(19, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setAmbientLightBright(bright);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
            public int getAmbientLightBright() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(20, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAmbientLightBright();
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
            public int startPlay(String[] effectData) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStringArray(effectData);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_startPlay, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().startPlay(effectData);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
            public int pausePlay() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_pausePlay, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().pausePlay();
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
            public int stopPlay() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_stopPlay, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().stopPlay();
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
            public void setAmbientLightMemoryBright(int bright) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(bright);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_setAmbientLightMemoryBright, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setAmbientLightMemoryBright(bright);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambientlight.IAmbientLight
            public int requestPermission(boolean apply) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(apply ? 1 : 0);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_requestPermission, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().requestPermission(apply);
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

        public static boolean setDefaultImpl(IAmbientLight impl) {
            if (Proxy.sDefaultImpl == null && impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static IAmbientLight getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
