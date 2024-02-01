package com.xiaopeng.xuimanager.lightlanuage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.xuimanager.lightlanuage.ILightLanuageEventListener;
import java.util.List;

/* loaded from: classes.dex */
public interface ILightLanuage extends IInterface {
    int getDanceEffectRunnable() throws RemoteException;

    List<String> getLightEffect() throws RemoteException;

    boolean getLightEffectEnable() throws RemoteException;

    String getLocalDanceEffectInfo() throws RemoteException;

    int getMcuEffect(int i) throws RemoteException;

    String getRhythmEffect() throws RemoteException;

    boolean getRhythmEffectEnable() throws RemoteException;

    String getRunningEffect() throws RemoteException;

    boolean getSayhiEffectEnable() throws RemoteException;

    String getUserEffectInfo(String str) throws RemoteException;

    String getUserEffectInfoList() throws RemoteException;

    boolean isDanceEffectRunning() throws RemoteException;

    void loadLightEffect() throws RemoteException;

    int playEffect(String str, int i) throws RemoteException;

    void playSmartEffect(int i) throws RemoteException;

    void registerListener(ILightLanuageEventListener iLightLanuageEventListener) throws RemoteException;

    void setLightEffectEnable(boolean z) throws RemoteException;

    void setMcuEffect(int i, int i2) throws RemoteException;

    void setRhythmEffect(String str) throws RemoteException;

    void setRhythmEffectEnable(boolean z) throws RemoteException;

    void setSayhiEffectEnable(boolean z) throws RemoteException;

    void stopEffect() throws RemoteException;

    void stopSmartEffect() throws RemoteException;

    void unregisterListener(ILightLanuageEventListener iLightLanuageEventListener) throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements ILightLanuage {
        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
        public void registerListener(ILightLanuageEventListener listener) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
        public void unregisterListener(ILightLanuageEventListener listener) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
        public void loadLightEffect() throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
        public List<String> getLightEffect() throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
        public String getUserEffectInfoList() throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
        public String getUserEffectInfo(String subdir) throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
        public String getLocalDanceEffectInfo() throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
        public boolean getSayhiEffectEnable() throws RemoteException {
            return false;
        }

        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
        public void setSayhiEffectEnable(boolean enable) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
        public boolean getRhythmEffectEnable() throws RemoteException {
            return false;
        }

        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
        public void setRhythmEffectEnable(boolean enable) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
        public boolean getLightEffectEnable() throws RemoteException {
            return false;
        }

        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
        public void setLightEffectEnable(boolean enable) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
        public int getMcuEffect(int name) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
        public void setMcuEffect(int name, int mode) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
        public String getRhythmEffect() throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
        public void setRhythmEffect(String name) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
        public String getRunningEffect() throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
        public boolean isDanceEffectRunning() throws RemoteException {
            return false;
        }

        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
        public int getDanceEffectRunnable() throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
        public int playEffect(String name, int count) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
        public void stopEffect() throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
        public void playSmartEffect(int type) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
        public void stopSmartEffect() throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements ILightLanuage {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.lightlanuage.ILightLanuage";
        static final int TRANSACTION_getDanceEffectRunnable = 20;
        static final int TRANSACTION_getLightEffect = 4;
        static final int TRANSACTION_getLightEffectEnable = 12;
        static final int TRANSACTION_getLocalDanceEffectInfo = 7;
        static final int TRANSACTION_getMcuEffect = 14;
        static final int TRANSACTION_getRhythmEffect = 16;
        static final int TRANSACTION_getRhythmEffectEnable = 10;
        static final int TRANSACTION_getRunningEffect = 18;
        static final int TRANSACTION_getSayhiEffectEnable = 8;
        static final int TRANSACTION_getUserEffectInfo = 6;
        static final int TRANSACTION_getUserEffectInfoList = 5;
        static final int TRANSACTION_isDanceEffectRunning = 19;
        static final int TRANSACTION_loadLightEffect = 3;
        static final int TRANSACTION_playEffect = 21;
        static final int TRANSACTION_playSmartEffect = 23;
        static final int TRANSACTION_registerListener = 1;
        static final int TRANSACTION_setLightEffectEnable = 13;
        static final int TRANSACTION_setMcuEffect = 15;
        static final int TRANSACTION_setRhythmEffect = 17;
        static final int TRANSACTION_setRhythmEffectEnable = 11;
        static final int TRANSACTION_setSayhiEffectEnable = 9;
        static final int TRANSACTION_stopEffect = 22;
        static final int TRANSACTION_stopSmartEffect = 24;
        static final int TRANSACTION_unregisterListener = 2;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ILightLanuage asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof ILightLanuage)) {
                return (ILightLanuage) iin;
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
                    registerListener(ILightLanuageEventListener.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    unregisterListener(ILightLanuageEventListener.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    loadLightEffect();
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    List<String> _result = getLightEffect();
                    reply.writeNoException();
                    reply.writeStringList(_result);
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    String _result2 = getUserEffectInfoList();
                    reply.writeNoException();
                    reply.writeString(_result2);
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    String _result3 = getUserEffectInfo(data.readString());
                    reply.writeNoException();
                    reply.writeString(_result3);
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    String _result4 = getLocalDanceEffectInfo();
                    reply.writeNoException();
                    reply.writeString(_result4);
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    boolean sayhiEffectEnable = getSayhiEffectEnable();
                    reply.writeNoException();
                    reply.writeInt(sayhiEffectEnable ? 1 : 0);
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt() != 0;
                    setSayhiEffectEnable(_arg0);
                    reply.writeNoException();
                    return true;
                case 10:
                    data.enforceInterface(DESCRIPTOR);
                    boolean rhythmEffectEnable = getRhythmEffectEnable();
                    reply.writeNoException();
                    reply.writeInt(rhythmEffectEnable ? 1 : 0);
                    return true;
                case 11:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt() != 0;
                    setRhythmEffectEnable(_arg0);
                    reply.writeNoException();
                    return true;
                case 12:
                    data.enforceInterface(DESCRIPTOR);
                    boolean lightEffectEnable = getLightEffectEnable();
                    reply.writeNoException();
                    reply.writeInt(lightEffectEnable ? 1 : 0);
                    return true;
                case 13:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt() != 0;
                    setLightEffectEnable(_arg0);
                    reply.writeNoException();
                    return true;
                case 14:
                    data.enforceInterface(DESCRIPTOR);
                    int _result5 = getMcuEffect(data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result5);
                    return true;
                case 15:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg02 = data.readInt();
                    int _arg1 = data.readInt();
                    setMcuEffect(_arg02, _arg1);
                    reply.writeNoException();
                    return true;
                case 16:
                    data.enforceInterface(DESCRIPTOR);
                    String _result6 = getRhythmEffect();
                    reply.writeNoException();
                    reply.writeString(_result6);
                    return true;
                case 17:
                    data.enforceInterface(DESCRIPTOR);
                    setRhythmEffect(data.readString());
                    reply.writeNoException();
                    return true;
                case 18:
                    data.enforceInterface(DESCRIPTOR);
                    String _result7 = getRunningEffect();
                    reply.writeNoException();
                    reply.writeString(_result7);
                    return true;
                case 19:
                    data.enforceInterface(DESCRIPTOR);
                    boolean isDanceEffectRunning = isDanceEffectRunning();
                    reply.writeNoException();
                    reply.writeInt(isDanceEffectRunning ? 1 : 0);
                    return true;
                case 20:
                    data.enforceInterface(DESCRIPTOR);
                    int _result8 = getDanceEffectRunnable();
                    reply.writeNoException();
                    reply.writeInt(_result8);
                    return true;
                case TRANSACTION_playEffect /* 21 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg03 = data.readString();
                    int _arg12 = data.readInt();
                    int _result9 = playEffect(_arg03, _arg12);
                    reply.writeNoException();
                    reply.writeInt(_result9);
                    return true;
                case TRANSACTION_stopEffect /* 22 */:
                    data.enforceInterface(DESCRIPTOR);
                    stopEffect();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_playSmartEffect /* 23 */:
                    data.enforceInterface(DESCRIPTOR);
                    playSmartEffect(data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_stopSmartEffect /* 24 */:
                    data.enforceInterface(DESCRIPTOR);
                    stopSmartEffect();
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements ILightLanuage {
            public static ILightLanuage sDefaultImpl;
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

            @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
            public void registerListener(ILightLanuageEventListener listener) throws RemoteException {
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

            @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
            public void unregisterListener(ILightLanuageEventListener listener) throws RemoteException {
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

            @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
            public void loadLightEffect() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(3, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().loadLightEffect();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
            public List<String> getLightEffect() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(4, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getLightEffect();
                    }
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
            public String getUserEffectInfoList() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(5, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getUserEffectInfoList();
                    }
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
            public String getUserEffectInfo(String subdir) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(subdir);
                    boolean _status = this.mRemote.transact(6, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getUserEffectInfo(subdir);
                    }
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
            public String getLocalDanceEffectInfo() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(7, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getLocalDanceEffectInfo();
                    }
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
            public boolean getSayhiEffectEnable() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(8, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSayhiEffectEnable();
                    }
                    _reply.readException();
                    boolean _status2 = _reply.readInt() != 0;
                    return _status2;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
            public void setSayhiEffectEnable(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enable ? 1 : 0);
                    boolean _status = this.mRemote.transact(9, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setSayhiEffectEnable(enable);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
            public boolean getRhythmEffectEnable() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(10, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getRhythmEffectEnable();
                    }
                    _reply.readException();
                    boolean _status2 = _reply.readInt() != 0;
                    return _status2;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
            public void setRhythmEffectEnable(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enable ? 1 : 0);
                    boolean _status = this.mRemote.transact(11, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setRhythmEffectEnable(enable);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
            public boolean getLightEffectEnable() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(12, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getLightEffectEnable();
                    }
                    _reply.readException();
                    boolean _status2 = _reply.readInt() != 0;
                    return _status2;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
            public void setLightEffectEnable(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enable ? 1 : 0);
                    boolean _status = this.mRemote.transact(13, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setLightEffectEnable(enable);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
            public int getMcuEffect(int name) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(name);
                    boolean _status = this.mRemote.transact(14, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getMcuEffect(name);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
            public void setMcuEffect(int name, int mode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(name);
                    _data.writeInt(mode);
                    boolean _status = this.mRemote.transact(15, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setMcuEffect(name, mode);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
            public String getRhythmEffect() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(16, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getRhythmEffect();
                    }
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
            public void setRhythmEffect(String name) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(name);
                    boolean _status = this.mRemote.transact(17, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setRhythmEffect(name);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
            public String getRunningEffect() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(18, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getRunningEffect();
                    }
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
            public boolean isDanceEffectRunning() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(19, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isDanceEffectRunning();
                    }
                    _reply.readException();
                    boolean _status2 = _reply.readInt() != 0;
                    return _status2;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
            public int getDanceEffectRunnable() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(20, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDanceEffectRunnable();
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
            public int playEffect(String name, int count) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(name);
                    _data.writeInt(count);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_playEffect, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().playEffect(name, count);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
            public void stopEffect() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_stopEffect, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().stopEffect();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
            public void playSmartEffect(int type) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(type);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_playSmartEffect, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().playSmartEffect(type);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.lightlanuage.ILightLanuage
            public void stopSmartEffect() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_stopSmartEffect, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().stopSmartEffect();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ILightLanuage impl) {
            if (Proxy.sDefaultImpl == null && impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static ILightLanuage getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
