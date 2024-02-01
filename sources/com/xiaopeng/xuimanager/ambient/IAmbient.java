package com.xiaopeng.xuimanager.ambient;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.xuimanager.ambient.IAmbientEventListener;
import java.util.List;

/* loaded from: classes.dex */
public interface IAmbient extends IInterface {
    int getAmbientLightBright(String str) throws RemoteException;

    String getAmbientLightColorType(String str) throws RemoteException;

    List<String> getAmbientLightDoubleColor(String str) throws RemoteException;

    boolean getAmbientLightEnable() throws RemoteException;

    String getAmbientLightMode(String str) throws RemoteException;

    int getAmbientLightMonoColor(String str) throws RemoteException;

    String getAmbientLightPartitionModes() throws RemoteException;

    int getAmbientLightRegionBright(String str, String str2) throws RemoteException;

    int getAmbientLightRegionColor(String str, String str2) throws RemoteException;

    String getAmbientLightThemeColor(String str) throws RemoteException;

    int playAmbientLightEffect(String str, String str2, boolean z) throws RemoteException;

    void registerListener(IAmbientEventListener iAmbientEventListener) throws RemoteException;

    int requestAmbientLightPermission(boolean z) throws RemoteException;

    int setAmbientLightBright(String str, int i) throws RemoteException;

    int setAmbientLightColorType(String str, String str2) throws RemoteException;

    int setAmbientLightDoubleColor(String str, int i, int i2) throws RemoteException;

    int setAmbientLightEnable(boolean z) throws RemoteException;

    int setAmbientLightMode(String str, String str2) throws RemoteException;

    int setAmbientLightMonoColor(String str, int i) throws RemoteException;

    int setAmbientLightRegionBright(String str, String str2, int i) throws RemoteException;

    int setAmbientLightRegionColor(String str, String str2, int i) throws RemoteException;

    int setAmbientLightThemeColor(String str, String str2) throws RemoteException;

    List<String> showAmbientLightColorTypes() throws RemoteException;

    List<String> showAmbientLightEffectPartitions() throws RemoteException;

    List<String> showAmbientLightEffects() throws RemoteException;

    List<String> showAmbientLightModePartitions() throws RemoteException;

    List<String> showAmbientLightModes() throws RemoteException;

    List<String> showAmbientLightRegions() throws RemoteException;

    List<String> showAmbientLightThemesColor() throws RemoteException;

    int stopAmbientLightEffect() throws RemoteException;

    int subAmbientLightMode(String str, String str2) throws RemoteException;

    void unregisterListener(IAmbientEventListener iAmbientEventListener) throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements IAmbient {
        @Override // com.xiaopeng.xuimanager.ambient.IAmbient
        public void registerListener(IAmbientEventListener listener) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.ambient.IAmbient
        public void unregisterListener(IAmbientEventListener listener) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.ambient.IAmbient
        public int requestAmbientLightPermission(boolean apply) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.ambient.IAmbient
        public int setAmbientLightEnable(boolean enable) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.ambient.IAmbient
        public boolean getAmbientLightEnable() throws RemoteException {
            return false;
        }

        @Override // com.xiaopeng.xuimanager.ambient.IAmbient
        public List<String> showAmbientLightEffectPartitions() throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.ambient.IAmbient
        public List<String> showAmbientLightEffects() throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.ambient.IAmbient
        public int playAmbientLightEffect(String partition, String effect, boolean hasJson) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.ambient.IAmbient
        public int stopAmbientLightEffect() throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.ambient.IAmbient
        public List<String> showAmbientLightModePartitions() throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.ambient.IAmbient
        public List<String> showAmbientLightModes() throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.ambient.IAmbient
        public int setAmbientLightMode(String partition, String mode) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.ambient.IAmbient
        public int subAmbientLightMode(String partition, String mode) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.ambient.IAmbient
        public String getAmbientLightMode(String partition) throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.ambient.IAmbient
        public String getAmbientLightPartitionModes() throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.ambient.IAmbient
        public int setAmbientLightBright(String partition, int bright) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.ambient.IAmbient
        public int getAmbientLightBright(String partition) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.ambient.IAmbient
        public List<String> showAmbientLightColorTypes() throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.ambient.IAmbient
        public int setAmbientLightColorType(String partition, String colorType) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.ambient.IAmbient
        public String getAmbientLightColorType(String partition) throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.ambient.IAmbient
        public int setAmbientLightMonoColor(String partition, int color) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.ambient.IAmbient
        public int getAmbientLightMonoColor(String partition) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.ambient.IAmbient
        public int setAmbientLightDoubleColor(String partition, int first, int second) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.ambient.IAmbient
        public List<String> getAmbientLightDoubleColor(String partition) throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.ambient.IAmbient
        public List<String> showAmbientLightThemesColor() throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.ambient.IAmbient
        public int setAmbientLightThemeColor(String partition, String themeColor) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.ambient.IAmbient
        public String getAmbientLightThemeColor(String partition) throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.ambient.IAmbient
        public List<String> showAmbientLightRegions() throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.ambient.IAmbient
        public int setAmbientLightRegionColor(String partition, String region, int color) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.ambient.IAmbient
        public int getAmbientLightRegionColor(String partition, String region) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.ambient.IAmbient
        public int setAmbientLightRegionBright(String partition, String region, int bright) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.ambient.IAmbient
        public int getAmbientLightRegionBright(String partition, String region) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IAmbient {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.ambient.IAmbient";
        static final int TRANSACTION_getAmbientLightBright = 17;
        static final int TRANSACTION_getAmbientLightColorType = 20;
        static final int TRANSACTION_getAmbientLightDoubleColor = 24;
        static final int TRANSACTION_getAmbientLightEnable = 5;
        static final int TRANSACTION_getAmbientLightMode = 14;
        static final int TRANSACTION_getAmbientLightMonoColor = 22;
        static final int TRANSACTION_getAmbientLightPartitionModes = 15;
        static final int TRANSACTION_getAmbientLightRegionBright = 32;
        static final int TRANSACTION_getAmbientLightRegionColor = 30;
        static final int TRANSACTION_getAmbientLightThemeColor = 27;
        static final int TRANSACTION_playAmbientLightEffect = 8;
        static final int TRANSACTION_registerListener = 1;
        static final int TRANSACTION_requestAmbientLightPermission = 3;
        static final int TRANSACTION_setAmbientLightBright = 16;
        static final int TRANSACTION_setAmbientLightColorType = 19;
        static final int TRANSACTION_setAmbientLightDoubleColor = 23;
        static final int TRANSACTION_setAmbientLightEnable = 4;
        static final int TRANSACTION_setAmbientLightMode = 12;
        static final int TRANSACTION_setAmbientLightMonoColor = 21;
        static final int TRANSACTION_setAmbientLightRegionBright = 31;
        static final int TRANSACTION_setAmbientLightRegionColor = 29;
        static final int TRANSACTION_setAmbientLightThemeColor = 26;
        static final int TRANSACTION_showAmbientLightColorTypes = 18;
        static final int TRANSACTION_showAmbientLightEffectPartitions = 6;
        static final int TRANSACTION_showAmbientLightEffects = 7;
        static final int TRANSACTION_showAmbientLightModePartitions = 10;
        static final int TRANSACTION_showAmbientLightModes = 11;
        static final int TRANSACTION_showAmbientLightRegions = 28;
        static final int TRANSACTION_showAmbientLightThemesColor = 25;
        static final int TRANSACTION_stopAmbientLightEffect = 9;
        static final int TRANSACTION_subAmbientLightMode = 13;
        static final int TRANSACTION_unregisterListener = 2;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAmbient asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IAmbient)) {
                return (IAmbient) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean _arg2;
            if (code == 1598968902) {
                reply.writeString(DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    IAmbientEventListener _arg0 = IAmbientEventListener.Stub.asInterface(data.readStrongBinder());
                    registerListener(_arg0);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    IAmbientEventListener _arg02 = IAmbientEventListener.Stub.asInterface(data.readStrongBinder());
                    unregisterListener(_arg02);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    _arg2 = data.readInt() != 0;
                    int _result = requestAmbientLightPermission(_arg2);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    _arg2 = data.readInt() != 0;
                    int _result2 = setAmbientLightEnable(_arg2);
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    boolean ambientLightEnable = getAmbientLightEnable();
                    reply.writeNoException();
                    reply.writeInt(ambientLightEnable ? 1 : 0);
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    List<String> _result3 = showAmbientLightEffectPartitions();
                    reply.writeNoException();
                    reply.writeStringList(_result3);
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    List<String> _result4 = showAmbientLightEffects();
                    reply.writeNoException();
                    reply.writeStringList(_result4);
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg03 = data.readString();
                    String _arg1 = data.readString();
                    _arg2 = data.readInt() != 0;
                    int _result5 = playAmbientLightEffect(_arg03, _arg1, _arg2);
                    reply.writeNoException();
                    reply.writeInt(_result5);
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    int _result6 = stopAmbientLightEffect();
                    reply.writeNoException();
                    reply.writeInt(_result6);
                    return true;
                case 10:
                    data.enforceInterface(DESCRIPTOR);
                    List<String> _result7 = showAmbientLightModePartitions();
                    reply.writeNoException();
                    reply.writeStringList(_result7);
                    return true;
                case 11:
                    data.enforceInterface(DESCRIPTOR);
                    List<String> _result8 = showAmbientLightModes();
                    reply.writeNoException();
                    reply.writeStringList(_result8);
                    return true;
                case 12:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg04 = data.readString();
                    String _arg12 = data.readString();
                    int _result9 = setAmbientLightMode(_arg04, _arg12);
                    reply.writeNoException();
                    reply.writeInt(_result9);
                    return true;
                case 13:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg05 = data.readString();
                    String _arg13 = data.readString();
                    int _result10 = subAmbientLightMode(_arg05, _arg13);
                    reply.writeNoException();
                    reply.writeInt(_result10);
                    return true;
                case 14:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg06 = data.readString();
                    String _result11 = getAmbientLightMode(_arg06);
                    reply.writeNoException();
                    reply.writeString(_result11);
                    return true;
                case 15:
                    data.enforceInterface(DESCRIPTOR);
                    String _result12 = getAmbientLightPartitionModes();
                    reply.writeNoException();
                    reply.writeString(_result12);
                    return true;
                case 16:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg07 = data.readString();
                    int _arg14 = data.readInt();
                    int _result13 = setAmbientLightBright(_arg07, _arg14);
                    reply.writeNoException();
                    reply.writeInt(_result13);
                    return true;
                case 17:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg08 = data.readString();
                    int _result14 = getAmbientLightBright(_arg08);
                    reply.writeNoException();
                    reply.writeInt(_result14);
                    return true;
                case 18:
                    data.enforceInterface(DESCRIPTOR);
                    List<String> _result15 = showAmbientLightColorTypes();
                    reply.writeNoException();
                    reply.writeStringList(_result15);
                    return true;
                case 19:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg09 = data.readString();
                    String _arg15 = data.readString();
                    int _result16 = setAmbientLightColorType(_arg09, _arg15);
                    reply.writeNoException();
                    reply.writeInt(_result16);
                    return true;
                case 20:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg010 = data.readString();
                    String _result17 = getAmbientLightColorType(_arg010);
                    reply.writeNoException();
                    reply.writeString(_result17);
                    return true;
                case TRANSACTION_setAmbientLightMonoColor /* 21 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg011 = data.readString();
                    int _arg16 = data.readInt();
                    int _result18 = setAmbientLightMonoColor(_arg011, _arg16);
                    reply.writeNoException();
                    reply.writeInt(_result18);
                    return true;
                case TRANSACTION_getAmbientLightMonoColor /* 22 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg012 = data.readString();
                    int _result19 = getAmbientLightMonoColor(_arg012);
                    reply.writeNoException();
                    reply.writeInt(_result19);
                    return true;
                case TRANSACTION_setAmbientLightDoubleColor /* 23 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg013 = data.readString();
                    int _arg17 = data.readInt();
                    int _result20 = setAmbientLightDoubleColor(_arg013, _arg17, data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result20);
                    return true;
                case TRANSACTION_getAmbientLightDoubleColor /* 24 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg014 = data.readString();
                    List<String> _result21 = getAmbientLightDoubleColor(_arg014);
                    reply.writeNoException();
                    reply.writeStringList(_result21);
                    return true;
                case TRANSACTION_showAmbientLightThemesColor /* 25 */:
                    data.enforceInterface(DESCRIPTOR);
                    List<String> _result22 = showAmbientLightThemesColor();
                    reply.writeNoException();
                    reply.writeStringList(_result22);
                    return true;
                case TRANSACTION_setAmbientLightThemeColor /* 26 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg015 = data.readString();
                    String _arg18 = data.readString();
                    int _result23 = setAmbientLightThemeColor(_arg015, _arg18);
                    reply.writeNoException();
                    reply.writeInt(_result23);
                    return true;
                case TRANSACTION_getAmbientLightThemeColor /* 27 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg016 = data.readString();
                    String _result24 = getAmbientLightThemeColor(_arg016);
                    reply.writeNoException();
                    reply.writeString(_result24);
                    return true;
                case TRANSACTION_showAmbientLightRegions /* 28 */:
                    data.enforceInterface(DESCRIPTOR);
                    List<String> _result25 = showAmbientLightRegions();
                    reply.writeNoException();
                    reply.writeStringList(_result25);
                    return true;
                case TRANSACTION_setAmbientLightRegionColor /* 29 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg017 = data.readString();
                    String _arg19 = data.readString();
                    int _result26 = setAmbientLightRegionColor(_arg017, _arg19, data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result26);
                    return true;
                case TRANSACTION_getAmbientLightRegionColor /* 30 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg018 = data.readString();
                    String _arg110 = data.readString();
                    int _result27 = getAmbientLightRegionColor(_arg018, _arg110);
                    reply.writeNoException();
                    reply.writeInt(_result27);
                    return true;
                case TRANSACTION_setAmbientLightRegionBright /* 31 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg019 = data.readString();
                    String _arg111 = data.readString();
                    int _result28 = setAmbientLightRegionBright(_arg019, _arg111, data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result28);
                    return true;
                case 32:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg020 = data.readString();
                    String _arg112 = data.readString();
                    int _result29 = getAmbientLightRegionBright(_arg020, _arg112);
                    reply.writeNoException();
                    reply.writeInt(_result29);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements IAmbient {
            public static IAmbient sDefaultImpl;
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

            @Override // com.xiaopeng.xuimanager.ambient.IAmbient
            public void registerListener(IAmbientEventListener listener) throws RemoteException {
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

            @Override // com.xiaopeng.xuimanager.ambient.IAmbient
            public void unregisterListener(IAmbientEventListener listener) throws RemoteException {
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

            @Override // com.xiaopeng.xuimanager.ambient.IAmbient
            public int requestAmbientLightPermission(boolean apply) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(apply ? 1 : 0);
                    boolean _status = this.mRemote.transact(3, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().requestAmbientLightPermission(apply);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambient.IAmbient
            public int setAmbientLightEnable(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enable ? 1 : 0);
                    boolean _status = this.mRemote.transact(4, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setAmbientLightEnable(enable);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambient.IAmbient
            public boolean getAmbientLightEnable() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(5, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAmbientLightEnable();
                    }
                    _reply.readException();
                    boolean _status2 = _reply.readInt() != 0;
                    return _status2;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambient.IAmbient
            public List<String> showAmbientLightEffectPartitions() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(6, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().showAmbientLightEffectPartitions();
                    }
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambient.IAmbient
            public List<String> showAmbientLightEffects() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(7, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().showAmbientLightEffects();
                    }
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambient.IAmbient
            public int playAmbientLightEffect(String partition, String effect, boolean hasJson) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(partition);
                    _data.writeString(effect);
                    _data.writeInt(hasJson ? 1 : 0);
                    boolean _status = this.mRemote.transact(8, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().playAmbientLightEffect(partition, effect, hasJson);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambient.IAmbient
            public int stopAmbientLightEffect() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(9, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().stopAmbientLightEffect();
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambient.IAmbient
            public List<String> showAmbientLightModePartitions() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(10, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().showAmbientLightModePartitions();
                    }
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambient.IAmbient
            public List<String> showAmbientLightModes() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(11, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().showAmbientLightModes();
                    }
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambient.IAmbient
            public int setAmbientLightMode(String partition, String mode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(partition);
                    _data.writeString(mode);
                    boolean _status = this.mRemote.transact(12, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setAmbientLightMode(partition, mode);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambient.IAmbient
            public int subAmbientLightMode(String partition, String mode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(partition);
                    _data.writeString(mode);
                    boolean _status = this.mRemote.transact(13, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().subAmbientLightMode(partition, mode);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambient.IAmbient
            public String getAmbientLightMode(String partition) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(partition);
                    boolean _status = this.mRemote.transact(14, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAmbientLightMode(partition);
                    }
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambient.IAmbient
            public String getAmbientLightPartitionModes() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(15, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAmbientLightPartitionModes();
                    }
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambient.IAmbient
            public int setAmbientLightBright(String partition, int bright) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(partition);
                    _data.writeInt(bright);
                    boolean _status = this.mRemote.transact(16, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setAmbientLightBright(partition, bright);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambient.IAmbient
            public int getAmbientLightBright(String partition) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(partition);
                    boolean _status = this.mRemote.transact(17, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAmbientLightBright(partition);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambient.IAmbient
            public List<String> showAmbientLightColorTypes() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(18, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().showAmbientLightColorTypes();
                    }
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambient.IAmbient
            public int setAmbientLightColorType(String partition, String colorType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(partition);
                    _data.writeString(colorType);
                    boolean _status = this.mRemote.transact(19, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setAmbientLightColorType(partition, colorType);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambient.IAmbient
            public String getAmbientLightColorType(String partition) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(partition);
                    boolean _status = this.mRemote.transact(20, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAmbientLightColorType(partition);
                    }
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambient.IAmbient
            public int setAmbientLightMonoColor(String partition, int color) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(partition);
                    _data.writeInt(color);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_setAmbientLightMonoColor, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setAmbientLightMonoColor(partition, color);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambient.IAmbient
            public int getAmbientLightMonoColor(String partition) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(partition);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_getAmbientLightMonoColor, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAmbientLightMonoColor(partition);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambient.IAmbient
            public int setAmbientLightDoubleColor(String partition, int first, int second) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(partition);
                    _data.writeInt(first);
                    _data.writeInt(second);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_setAmbientLightDoubleColor, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setAmbientLightDoubleColor(partition, first, second);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambient.IAmbient
            public List<String> getAmbientLightDoubleColor(String partition) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(partition);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_getAmbientLightDoubleColor, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAmbientLightDoubleColor(partition);
                    }
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambient.IAmbient
            public List<String> showAmbientLightThemesColor() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_showAmbientLightThemesColor, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().showAmbientLightThemesColor();
                    }
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambient.IAmbient
            public int setAmbientLightThemeColor(String partition, String themeColor) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(partition);
                    _data.writeString(themeColor);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_setAmbientLightThemeColor, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setAmbientLightThemeColor(partition, themeColor);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambient.IAmbient
            public String getAmbientLightThemeColor(String partition) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(partition);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_getAmbientLightThemeColor, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAmbientLightThemeColor(partition);
                    }
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambient.IAmbient
            public List<String> showAmbientLightRegions() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_showAmbientLightRegions, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().showAmbientLightRegions();
                    }
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambient.IAmbient
            public int setAmbientLightRegionColor(String partition, String region, int color) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(partition);
                    _data.writeString(region);
                    _data.writeInt(color);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_setAmbientLightRegionColor, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setAmbientLightRegionColor(partition, region, color);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambient.IAmbient
            public int getAmbientLightRegionColor(String partition, String region) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(partition);
                    _data.writeString(region);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_getAmbientLightRegionColor, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAmbientLightRegionColor(partition, region);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambient.IAmbient
            public int setAmbientLightRegionBright(String partition, String region, int bright) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(partition);
                    _data.writeString(region);
                    _data.writeInt(bright);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_setAmbientLightRegionBright, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setAmbientLightRegionBright(partition, region, bright);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.ambient.IAmbient
            public int getAmbientLightRegionBright(String partition, String region) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(partition);
                    _data.writeString(region);
                    boolean _status = this.mRemote.transact(32, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAmbientLightRegionBright(partition, region);
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

        public static boolean setDefaultImpl(IAmbient impl) {
            if (Proxy.sDefaultImpl == null && impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static IAmbient getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
