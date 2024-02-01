package com.xiaopeng.xuimanager.condition;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.xuimanager.condition.IBrightnessLevelListener;
import com.xiaopeng.xuimanager.condition.IConditionListener;
import com.xiaopeng.xuimanager.condition.ITwilightStateListener;

/* loaded from: classes.dex */
public interface ICondition extends IInterface {
    void addConditionListener(int i, IConditionListener iConditionListener) throws RemoteException;

    int createCondition(String str) throws RemoteException;

    int getBrightnessLevel() throws RemoteException;

    TwilightState getTwilightState() throws RemoteException;

    boolean isConditionMatch(int i) throws RemoteException;

    void registerBrightnessLevelListener(IBrightnessLevelListener iBrightnessLevelListener) throws RemoteException;

    void registerTwilightStateListener(ITwilightStateListener iTwilightStateListener) throws RemoteException;

    void releaseCondition(int i) throws RemoteException;

    void removeConditionListener(int i, IConditionListener iConditionListener) throws RemoteException;

    void startWatchCondition(int i) throws RemoteException;

    void stopWatchCondition(int i) throws RemoteException;

    void unregisterBrightnessLevelListener(IBrightnessLevelListener iBrightnessLevelListener) throws RemoteException;

    void unregisterTwilightStateListener(ITwilightStateListener iTwilightStateListener) throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements ICondition {
        @Override // com.xiaopeng.xuimanager.condition.ICondition
        public int createCondition(String json) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.condition.ICondition
        public void releaseCondition(int conditionId) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.condition.ICondition
        public boolean isConditionMatch(int conditionId) throws RemoteException {
            return false;
        }

        @Override // com.xiaopeng.xuimanager.condition.ICondition
        public void startWatchCondition(int conditionId) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.condition.ICondition
        public void stopWatchCondition(int conditionId) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.condition.ICondition
        public void addConditionListener(int conditionId, IConditionListener listener) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.condition.ICondition
        public void removeConditionListener(int conditionId, IConditionListener listener) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.condition.ICondition
        public TwilightState getTwilightState() throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.condition.ICondition
        public void registerTwilightStateListener(ITwilightStateListener listener) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.condition.ICondition
        public void unregisterTwilightStateListener(ITwilightStateListener listener) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.condition.ICondition
        public int getBrightnessLevel() throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.condition.ICondition
        public void registerBrightnessLevelListener(IBrightnessLevelListener listener) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.condition.ICondition
        public void unregisterBrightnessLevelListener(IBrightnessLevelListener listener) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements ICondition {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.condition.ICondition";
        static final int TRANSACTION_addConditionListener = 6;
        static final int TRANSACTION_createCondition = 1;
        static final int TRANSACTION_getBrightnessLevel = 11;
        static final int TRANSACTION_getTwilightState = 8;
        static final int TRANSACTION_isConditionMatch = 3;
        static final int TRANSACTION_registerBrightnessLevelListener = 12;
        static final int TRANSACTION_registerTwilightStateListener = 9;
        static final int TRANSACTION_releaseCondition = 2;
        static final int TRANSACTION_removeConditionListener = 7;
        static final int TRANSACTION_startWatchCondition = 4;
        static final int TRANSACTION_stopWatchCondition = 5;
        static final int TRANSACTION_unregisterBrightnessLevelListener = 13;
        static final int TRANSACTION_unregisterTwilightStateListener = 10;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICondition asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof ICondition)) {
                return (ICondition) iin;
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
                    String _arg0 = data.readString();
                    int _result = createCondition(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg02 = data.readInt();
                    releaseCondition(_arg02);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg03 = data.readInt();
                    boolean isConditionMatch = isConditionMatch(_arg03);
                    reply.writeNoException();
                    reply.writeInt(isConditionMatch ? 1 : 0);
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg04 = data.readInt();
                    startWatchCondition(_arg04);
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg05 = data.readInt();
                    stopWatchCondition(_arg05);
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg06 = data.readInt();
                    IConditionListener _arg1 = IConditionListener.Stub.asInterface(data.readStrongBinder());
                    addConditionListener(_arg06, _arg1);
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg07 = data.readInt();
                    IConditionListener _arg12 = IConditionListener.Stub.asInterface(data.readStrongBinder());
                    removeConditionListener(_arg07, _arg12);
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    TwilightState _result2 = getTwilightState();
                    reply.writeNoException();
                    if (_result2 != null) {
                        reply.writeInt(1);
                        _result2.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    ITwilightStateListener _arg08 = ITwilightStateListener.Stub.asInterface(data.readStrongBinder());
                    registerTwilightStateListener(_arg08);
                    reply.writeNoException();
                    return true;
                case 10:
                    data.enforceInterface(DESCRIPTOR);
                    ITwilightStateListener _arg09 = ITwilightStateListener.Stub.asInterface(data.readStrongBinder());
                    unregisterTwilightStateListener(_arg09);
                    reply.writeNoException();
                    return true;
                case 11:
                    data.enforceInterface(DESCRIPTOR);
                    int _result3 = getBrightnessLevel();
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case 12:
                    data.enforceInterface(DESCRIPTOR);
                    IBrightnessLevelListener _arg010 = IBrightnessLevelListener.Stub.asInterface(data.readStrongBinder());
                    registerBrightnessLevelListener(_arg010);
                    reply.writeNoException();
                    return true;
                case 13:
                    data.enforceInterface(DESCRIPTOR);
                    IBrightnessLevelListener _arg011 = IBrightnessLevelListener.Stub.asInterface(data.readStrongBinder());
                    unregisterBrightnessLevelListener(_arg011);
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements ICondition {
            public static ICondition sDefaultImpl;
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

            @Override // com.xiaopeng.xuimanager.condition.ICondition
            public int createCondition(String json) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(json);
                    boolean _status = this.mRemote.transact(1, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().createCondition(json);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.condition.ICondition
            public void releaseCondition(int conditionId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(conditionId);
                    boolean _status = this.mRemote.transact(2, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().releaseCondition(conditionId);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.condition.ICondition
            public boolean isConditionMatch(int conditionId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(conditionId);
                    boolean _status = this.mRemote.transact(3, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isConditionMatch(conditionId);
                    }
                    _reply.readException();
                    boolean _status2 = _reply.readInt() != 0;
                    return _status2;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.condition.ICondition
            public void startWatchCondition(int conditionId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(conditionId);
                    boolean _status = this.mRemote.transact(4, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().startWatchCondition(conditionId);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.condition.ICondition
            public void stopWatchCondition(int conditionId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(conditionId);
                    boolean _status = this.mRemote.transact(5, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().stopWatchCondition(conditionId);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.condition.ICondition
            public void addConditionListener(int conditionId, IConditionListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(conditionId);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = this.mRemote.transact(6, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().addConditionListener(conditionId, listener);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.condition.ICondition
            public void removeConditionListener(int conditionId, IConditionListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(conditionId);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = this.mRemote.transact(7, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().removeConditionListener(conditionId, listener);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.condition.ICondition
            public TwilightState getTwilightState() throws RemoteException {
                TwilightState _result;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(8, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getTwilightState();
                    }
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = TwilightState.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.condition.ICondition
            public void registerTwilightStateListener(ITwilightStateListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = this.mRemote.transact(9, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerTwilightStateListener(listener);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.condition.ICondition
            public void unregisterTwilightStateListener(ITwilightStateListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = this.mRemote.transact(10, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterTwilightStateListener(listener);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.condition.ICondition
            public int getBrightnessLevel() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(11, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getBrightnessLevel();
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.condition.ICondition
            public void registerBrightnessLevelListener(IBrightnessLevelListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = this.mRemote.transact(12, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerBrightnessLevelListener(listener);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.condition.ICondition
            public void unregisterBrightnessLevelListener(IBrightnessLevelListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = this.mRemote.transact(13, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterBrightnessLevelListener(listener);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ICondition impl) {
            if (Proxy.sDefaultImpl == null && impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static ICondition getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
