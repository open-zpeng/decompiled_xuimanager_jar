package com.xiaopeng.xuimanager.seatmassager;

import android.content.res.AssetFileDescriptor;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.xuimanager.seatmassager.ISeatMassagerEventListener;
import java.util.List;

/* loaded from: classes.dex */
public interface ISeatMassager extends IInterface {
    int doVibrate(List<Seat> list, String str, int i, int i2) throws RemoteException;

    String getMassagerEffect(int i) throws RemoteException;

    int getMassagerIntensity(int i) throws RemoteException;

    int getMassagerStatus(int i) throws RemoteException;

    int getRhythmEnable(int i) throws RemoteException;

    int getRhythmIntensity(int i) throws RemoteException;

    int getRhythmPattern() throws RemoteException;

    int getVibrateIntensity(int i) throws RemoteException;

    void loadMassagerEffect() throws RemoteException;

    int loadVibrate(AssetFileDescriptor assetFileDescriptor, String str) throws RemoteException;

    void loadVibrateEffect() throws RemoteException;

    void registerListener(ISeatMassagerEventListener iSeatMassagerEventListener) throws RemoteException;

    int setMassagerEffect(List<String> list, String str) throws RemoteException;

    int setMassagerIntensity(List<String> list, int i) throws RemoteException;

    int setRhythmEnable(List<String> list, boolean z) throws RemoteException;

    int setRhythmIntensity(List<String> list, int i) throws RemoteException;

    int setRhythmPattern(int i) throws RemoteException;

    int setVibrateIntensity(List<String> list, int i) throws RemoteException;

    List<String> showMassagerEffect() throws RemoteException;

    List<String> showVibrateEffect() throws RemoteException;

    int startMassager(List<Seat> list, String str) throws RemoteException;

    int stopMassager(List<String> list) throws RemoteException;

    int stopVibrate() throws RemoteException;

    void unregisterListener(ISeatMassagerEventListener iSeatMassagerEventListener) throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements ISeatMassager {
        @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
        public void registerListener(ISeatMassagerEventListener listener) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
        public void unregisterListener(ISeatMassagerEventListener listener) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
        public void loadMassagerEffect() throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
        public List<String> showMassagerEffect() throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
        public int startMassager(List<Seat> seats, String effect) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
        public int stopMassager(List<String> ids) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
        public int setMassagerEffect(List<String> ids, String effect) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
        public String getMassagerEffect(int id) throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
        public int setMassagerIntensity(List<String> ids, int intensity) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
        public int getMassagerIntensity(int id) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
        public int getMassagerStatus(int id) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
        public void loadVibrateEffect() throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
        public int loadVibrate(AssetFileDescriptor fd, String effect) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
        public List<String> showVibrateEffect() throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
        public int setRhythmEnable(List<String> ids, boolean enable) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
        public int getRhythmEnable(int id) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
        public int doVibrate(List<Seat> seats, String effect, int loop, int position) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
        public int stopVibrate() throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
        public int setVibrateIntensity(List<String> ids, int intensity) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
        public int getVibrateIntensity(int id) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
        public int setRhythmIntensity(List<String> ids, int intensity) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
        public int getRhythmIntensity(int id) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
        public int setRhythmPattern(int pattern) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
        public int getRhythmPattern() throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements ISeatMassager {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.seatmassager.ISeatMassager";
        static final int TRANSACTION_doVibrate = 17;
        static final int TRANSACTION_getMassagerEffect = 8;
        static final int TRANSACTION_getMassagerIntensity = 10;
        static final int TRANSACTION_getMassagerStatus = 11;
        static final int TRANSACTION_getRhythmEnable = 16;
        static final int TRANSACTION_getRhythmIntensity = 22;
        static final int TRANSACTION_getRhythmPattern = 24;
        static final int TRANSACTION_getVibrateIntensity = 20;
        static final int TRANSACTION_loadMassagerEffect = 3;
        static final int TRANSACTION_loadVibrate = 13;
        static final int TRANSACTION_loadVibrateEffect = 12;
        static final int TRANSACTION_registerListener = 1;
        static final int TRANSACTION_setMassagerEffect = 7;
        static final int TRANSACTION_setMassagerIntensity = 9;
        static final int TRANSACTION_setRhythmEnable = 15;
        static final int TRANSACTION_setRhythmIntensity = 21;
        static final int TRANSACTION_setRhythmPattern = 23;
        static final int TRANSACTION_setVibrateIntensity = 19;
        static final int TRANSACTION_showMassagerEffect = 4;
        static final int TRANSACTION_showVibrateEffect = 14;
        static final int TRANSACTION_startMassager = 5;
        static final int TRANSACTION_stopMassager = 6;
        static final int TRANSACTION_stopVibrate = 18;
        static final int TRANSACTION_unregisterListener = 2;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISeatMassager asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof ISeatMassager)) {
                return (ISeatMassager) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            AssetFileDescriptor _arg0;
            if (code == 1598968902) {
                reply.writeString(DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    ISeatMassagerEventListener _arg02 = ISeatMassagerEventListener.Stub.asInterface(data.readStrongBinder());
                    registerListener(_arg02);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    ISeatMassagerEventListener _arg03 = ISeatMassagerEventListener.Stub.asInterface(data.readStrongBinder());
                    unregisterListener(_arg03);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    loadMassagerEffect();
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    List<String> _result = showMassagerEffect();
                    reply.writeNoException();
                    reply.writeStringList(_result);
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    List<Seat> _arg04 = data.createTypedArrayList(Seat.CREATOR);
                    String _arg1 = data.readString();
                    int _result2 = startMassager(_arg04, _arg1);
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    List<String> _arg05 = data.createStringArrayList();
                    int _result3 = stopMassager(_arg05);
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    List<String> _arg06 = data.createStringArrayList();
                    String _arg12 = data.readString();
                    int _result4 = setMassagerEffect(_arg06, _arg12);
                    reply.writeNoException();
                    reply.writeInt(_result4);
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg07 = data.readInt();
                    String _result5 = getMassagerEffect(_arg07);
                    reply.writeNoException();
                    reply.writeString(_result5);
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    List<String> _arg08 = data.createStringArrayList();
                    int _arg13 = data.readInt();
                    int _result6 = setMassagerIntensity(_arg08, _arg13);
                    reply.writeNoException();
                    reply.writeInt(_result6);
                    return true;
                case 10:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg09 = data.readInt();
                    int _result7 = getMassagerIntensity(_arg09);
                    reply.writeNoException();
                    reply.writeInt(_result7);
                    return true;
                case 11:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg010 = data.readInt();
                    int _result8 = getMassagerStatus(_arg010);
                    reply.writeNoException();
                    reply.writeInt(_result8);
                    return true;
                case 12:
                    data.enforceInterface(DESCRIPTOR);
                    loadVibrateEffect();
                    reply.writeNoException();
                    return true;
                case 13:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = (AssetFileDescriptor) AssetFileDescriptor.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    String _arg14 = data.readString();
                    int _result9 = loadVibrate(_arg0, _arg14);
                    reply.writeNoException();
                    reply.writeInt(_result9);
                    return true;
                case 14:
                    data.enforceInterface(DESCRIPTOR);
                    List<String> _result10 = showVibrateEffect();
                    reply.writeNoException();
                    reply.writeStringList(_result10);
                    return true;
                case 15:
                    data.enforceInterface(DESCRIPTOR);
                    List<String> _arg011 = data.createStringArrayList();
                    boolean _arg15 = data.readInt() != 0;
                    int _result11 = setRhythmEnable(_arg011, _arg15);
                    reply.writeNoException();
                    reply.writeInt(_result11);
                    return true;
                case 16:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg012 = data.readInt();
                    int _result12 = getRhythmEnable(_arg012);
                    reply.writeNoException();
                    reply.writeInt(_result12);
                    return true;
                case 17:
                    data.enforceInterface(DESCRIPTOR);
                    List<Seat> _arg013 = data.createTypedArrayList(Seat.CREATOR);
                    String _arg16 = data.readString();
                    int _arg2 = data.readInt();
                    int _arg3 = data.readInt();
                    int _result13 = doVibrate(_arg013, _arg16, _arg2, _arg3);
                    reply.writeNoException();
                    reply.writeInt(_result13);
                    return true;
                case 18:
                    data.enforceInterface(DESCRIPTOR);
                    int _result14 = stopVibrate();
                    reply.writeNoException();
                    reply.writeInt(_result14);
                    return true;
                case 19:
                    data.enforceInterface(DESCRIPTOR);
                    List<String> _arg014 = data.createStringArrayList();
                    int _arg17 = data.readInt();
                    int _result15 = setVibrateIntensity(_arg014, _arg17);
                    reply.writeNoException();
                    reply.writeInt(_result15);
                    return true;
                case 20:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg015 = data.readInt();
                    int _result16 = getVibrateIntensity(_arg015);
                    reply.writeNoException();
                    reply.writeInt(_result16);
                    return true;
                case TRANSACTION_setRhythmIntensity /* 21 */:
                    data.enforceInterface(DESCRIPTOR);
                    List<String> _arg016 = data.createStringArrayList();
                    int _arg18 = data.readInt();
                    int _result17 = setRhythmIntensity(_arg016, _arg18);
                    reply.writeNoException();
                    reply.writeInt(_result17);
                    return true;
                case TRANSACTION_getRhythmIntensity /* 22 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg017 = data.readInt();
                    int _result18 = getRhythmIntensity(_arg017);
                    reply.writeNoException();
                    reply.writeInt(_result18);
                    return true;
                case TRANSACTION_setRhythmPattern /* 23 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg018 = data.readInt();
                    int _result19 = setRhythmPattern(_arg018);
                    reply.writeNoException();
                    reply.writeInt(_result19);
                    return true;
                case TRANSACTION_getRhythmPattern /* 24 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _result20 = getRhythmPattern();
                    reply.writeNoException();
                    reply.writeInt(_result20);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements ISeatMassager {
            public static ISeatMassager sDefaultImpl;
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

            @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
            public void registerListener(ISeatMassagerEventListener listener) throws RemoteException {
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

            @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
            public void unregisterListener(ISeatMassagerEventListener listener) throws RemoteException {
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

            @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
            public void loadMassagerEffect() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(3, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().loadMassagerEffect();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
            public List<String> showMassagerEffect() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(4, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().showMassagerEffect();
                    }
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
            public int startMassager(List<Seat> seats, String effect) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeTypedList(seats);
                    _data.writeString(effect);
                    boolean _status = this.mRemote.transact(5, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().startMassager(seats, effect);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
            public int stopMassager(List<String> ids) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStringList(ids);
                    boolean _status = this.mRemote.transact(6, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().stopMassager(ids);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
            public int setMassagerEffect(List<String> ids, String effect) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStringList(ids);
                    _data.writeString(effect);
                    boolean _status = this.mRemote.transact(7, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setMassagerEffect(ids, effect);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
            public String getMassagerEffect(int id) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(id);
                    boolean _status = this.mRemote.transact(8, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getMassagerEffect(id);
                    }
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
            public int setMassagerIntensity(List<String> ids, int intensity) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStringList(ids);
                    _data.writeInt(intensity);
                    boolean _status = this.mRemote.transact(9, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setMassagerIntensity(ids, intensity);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
            public int getMassagerIntensity(int id) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(id);
                    boolean _status = this.mRemote.transact(10, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getMassagerIntensity(id);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
            public int getMassagerStatus(int id) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(id);
                    boolean _status = this.mRemote.transact(11, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getMassagerStatus(id);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
            public void loadVibrateEffect() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(12, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().loadVibrateEffect();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
            public int loadVibrate(AssetFileDescriptor fd, String effect) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (fd != null) {
                        _data.writeInt(1);
                        fd.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeString(effect);
                    boolean _status = this.mRemote.transact(13, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().loadVibrate(fd, effect);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
            public List<String> showVibrateEffect() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(14, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().showVibrateEffect();
                    }
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
            public int setRhythmEnable(List<String> ids, boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStringList(ids);
                    _data.writeInt(enable ? 1 : 0);
                    boolean _status = this.mRemote.transact(15, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setRhythmEnable(ids, enable);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
            public int getRhythmEnable(int id) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(id);
                    boolean _status = this.mRemote.transact(16, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getRhythmEnable(id);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
            public int doVibrate(List<Seat> seats, String effect, int loop, int position) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeTypedList(seats);
                    _data.writeString(effect);
                    _data.writeInt(loop);
                    _data.writeInt(position);
                    boolean _status = this.mRemote.transact(17, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().doVibrate(seats, effect, loop, position);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
            public int stopVibrate() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(18, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().stopVibrate();
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
            public int setVibrateIntensity(List<String> ids, int intensity) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStringList(ids);
                    _data.writeInt(intensity);
                    boolean _status = this.mRemote.transact(19, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setVibrateIntensity(ids, intensity);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
            public int getVibrateIntensity(int id) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(id);
                    boolean _status = this.mRemote.transact(20, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getVibrateIntensity(id);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
            public int setRhythmIntensity(List<String> ids, int intensity) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStringList(ids);
                    _data.writeInt(intensity);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_setRhythmIntensity, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setRhythmIntensity(ids, intensity);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
            public int getRhythmIntensity(int id) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(id);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_getRhythmIntensity, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getRhythmIntensity(id);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
            public int setRhythmPattern(int pattern) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(pattern);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_setRhythmPattern, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setRhythmPattern(pattern);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassager
            public int getRhythmPattern() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_getRhythmPattern, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getRhythmPattern();
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

        public static boolean setDefaultImpl(ISeatMassager impl) {
            if (Proxy.sDefaultImpl == null && impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static ISeatMassager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
