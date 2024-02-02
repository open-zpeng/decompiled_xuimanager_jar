package com.xiaopeng.xuimanager.contextinfo;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.xuimanager.contextinfo.IContextInfoEventListener;
/* loaded from: classes.dex */
public interface IContextInfo extends IInterface {
    boolean getIntelligentEffectEnable() throws RemoteException;

    String getWeather() throws RemoteException;

    void registerListener(IContextInfoEventListener iContextInfoEventListener) throws RemoteException;

    void registerListeners(IContextInfoEventListener iContextInfoEventListener, int i) throws RemoteException;

    void sendContextEvent(int i, int i2) throws RemoteException;

    void setCarAngular(float f, int i) throws RemoteException;

    void setCarAngularVelocity(float f) throws RemoteException;

    void setCarSpeed(float f, int i) throws RemoteException;

    void setIntelligentEffectEnable(boolean z) throws RemoteException;

    void setNavigationEnable(boolean z) throws RemoteException;

    void setNavigationInfo(String str) throws RemoteException;

    void unregisterListener(IContextInfoEventListener iContextInfoEventListener) throws RemoteException;

    void updateWeatherFromServer() throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IContextInfo {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.contextinfo.IContextInfo";
        static final int TRANSACTION_getIntelligentEffectEnable = 7;
        static final int TRANSACTION_getWeather = 10;
        static final int TRANSACTION_registerListener = 1;
        static final int TRANSACTION_registerListeners = 13;
        static final int TRANSACTION_sendContextEvent = 12;
        static final int TRANSACTION_setCarAngular = 4;
        static final int TRANSACTION_setCarAngularVelocity = 5;
        static final int TRANSACTION_setCarSpeed = 3;
        static final int TRANSACTION_setIntelligentEffectEnable = 6;
        static final int TRANSACTION_setNavigationEnable = 9;
        static final int TRANSACTION_setNavigationInfo = 8;
        static final int TRANSACTION_unregisterListener = 2;
        static final int TRANSACTION_updateWeatherFromServer = 11;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IContextInfo asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IContextInfo)) {
                return (IContextInfo) iin;
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
                    registerListener(IContextInfoEventListener.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    unregisterListener(IContextInfoEventListener.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    float _arg02 = data.readFloat();
                    int _arg1 = data.readInt();
                    setCarSpeed(_arg02, _arg1);
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    float _arg03 = data.readFloat();
                    int _arg12 = data.readInt();
                    setCarAngular(_arg03, _arg12);
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    setCarAngularVelocity(data.readFloat());
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt() != 0;
                    setIntelligentEffectEnable(_arg0);
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    boolean intelligentEffectEnable = getIntelligentEffectEnable();
                    reply.writeNoException();
                    reply.writeInt(intelligentEffectEnable ? 1 : 0);
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    setNavigationInfo(data.readString());
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt() != 0;
                    setNavigationEnable(_arg0);
                    reply.writeNoException();
                    return true;
                case 10:
                    data.enforceInterface(DESCRIPTOR);
                    String _result = getWeather();
                    reply.writeNoException();
                    reply.writeString(_result);
                    return true;
                case 11:
                    data.enforceInterface(DESCRIPTOR);
                    updateWeatherFromServer();
                    reply.writeNoException();
                    return true;
                case 12:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg04 = data.readInt();
                    int _arg13 = data.readInt();
                    sendContextEvent(_arg04, _arg13);
                    reply.writeNoException();
                    return true;
                case 13:
                    data.enforceInterface(DESCRIPTOR);
                    IContextInfoEventListener _arg05 = IContextInfoEventListener.Stub.asInterface(data.readStrongBinder());
                    int _arg14 = data.readInt();
                    registerListeners(_arg05, _arg14);
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* loaded from: classes.dex */
        private static class Proxy implements IContextInfo {
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

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfo
            public void registerListener(IContextInfoEventListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfo
            public void unregisterListener(IContextInfoEventListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfo
            public void setCarSpeed(float speed, int deltaTime) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeFloat(speed);
                    _data.writeInt(deltaTime);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfo
            public void setCarAngular(float angularValue, int deltaTime) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeFloat(angularValue);
                    _data.writeInt(deltaTime);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfo
            public void setCarAngularVelocity(float angularValue) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeFloat(angularValue);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfo
            public void setIntelligentEffectEnable(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enable ? 1 : 0);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfo
            public boolean getIntelligentEffectEnable() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfo
            public void setNavigationInfo(String navInfo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(navInfo);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfo
            public void setNavigationEnable(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enable ? 1 : 0);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfo
            public String getWeather() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfo
            public void updateWeatherFromServer() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfo
            public void sendContextEvent(int eventType, int eventValue) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eventType);
                    _data.writeInt(eventValue);
                    this.mRemote.transact(12, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.contextinfo.IContextInfo
            public void registerListeners(IContextInfoEventListener listener, int level) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    _data.writeInt(level);
                    this.mRemote.transact(13, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}
