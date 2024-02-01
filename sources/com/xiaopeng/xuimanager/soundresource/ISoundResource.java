package com.xiaopeng.xuimanager.soundresource;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.xuimanager.soundresource.ISoundResourceListener;
import com.xiaopeng.xuimanager.soundresource.data.BootSoundResource;
import com.xiaopeng.xuimanager.soundresource.data.SoundEffectResource;
import com.xiaopeng.xuimanager.soundresource.data.SoundEffectTheme;

/* loaded from: classes.dex */
public interface ISoundResource extends IInterface {
    BootSoundResource getActiveBootSoundResource() throws RemoteException;

    SoundEffectResource getActiveSoundEffectResource(int i) throws RemoteException;

    int getActiveSoundEffectTheme() throws RemoteException;

    SoundEffectTheme[] getAvailableThemes() throws RemoteException;

    int getBootSoundOnOff() throws RemoteException;

    BootSoundResource[] getBootSoundResource() throws RemoteException;

    SoundEffectResource[] getSoundEffectPlayResource(int i) throws RemoteException;

    SoundEffectResource[] getSoundEffectPreviewResource(int i) throws RemoteException;

    void registerListener(ISoundResourceListener iSoundResourceListener) throws RemoteException;

    int selectSoundEffectTheme(int i) throws RemoteException;

    int setBootSoundOnOff(boolean z) throws RemoteException;

    int setBootSoundResource(int i) throws RemoteException;

    void unRegisterListener(ISoundResourceListener iSoundResourceListener) throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements ISoundResource {
        @Override // com.xiaopeng.xuimanager.soundresource.ISoundResource
        public SoundEffectTheme[] getAvailableThemes() throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.soundresource.ISoundResource
        public int getActiveSoundEffectTheme() throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.soundresource.ISoundResource
        public int selectSoundEffectTheme(int themeId) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.soundresource.ISoundResource
        public SoundEffectResource[] getSoundEffectPlayResource(int themeId) throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.soundresource.ISoundResource
        public SoundEffectResource[] getSoundEffectPreviewResource(int themeId) throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.soundresource.ISoundResource
        public SoundEffectResource getActiveSoundEffectResource(int effectType) throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.soundresource.ISoundResource
        public int setBootSoundOnOff(boolean flag) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.soundresource.ISoundResource
        public int getBootSoundOnOff() throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.soundresource.ISoundResource
        public BootSoundResource[] getBootSoundResource() throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.soundresource.ISoundResource
        public int setBootSoundResource(int resourceId) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.soundresource.ISoundResource
        public BootSoundResource getActiveBootSoundResource() throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.soundresource.ISoundResource
        public void registerListener(ISoundResourceListener listener) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.soundresource.ISoundResource
        public void unRegisterListener(ISoundResourceListener listener) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements ISoundResource {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.soundresource.ISoundResource";
        static final int TRANSACTION_getActiveBootSoundResource = 11;
        static final int TRANSACTION_getActiveSoundEffectResource = 6;
        static final int TRANSACTION_getActiveSoundEffectTheme = 2;
        static final int TRANSACTION_getAvailableThemes = 1;
        static final int TRANSACTION_getBootSoundOnOff = 8;
        static final int TRANSACTION_getBootSoundResource = 9;
        static final int TRANSACTION_getSoundEffectPlayResource = 4;
        static final int TRANSACTION_getSoundEffectPreviewResource = 5;
        static final int TRANSACTION_registerListener = 12;
        static final int TRANSACTION_selectSoundEffectTheme = 3;
        static final int TRANSACTION_setBootSoundOnOff = 7;
        static final int TRANSACTION_setBootSoundResource = 10;
        static final int TRANSACTION_unRegisterListener = 13;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISoundResource asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof ISoundResource)) {
                return (ISoundResource) iin;
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
                    SoundEffectTheme[] _result = getAvailableThemes();
                    reply.writeNoException();
                    reply.writeTypedArray(_result, 1);
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    int _result2 = getActiveSoundEffectTheme();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0 = data.readInt();
                    int _result3 = selectSoundEffectTheme(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg02 = data.readInt();
                    SoundEffectResource[] _result4 = getSoundEffectPlayResource(_arg02);
                    reply.writeNoException();
                    reply.writeTypedArray(_result4, 1);
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg03 = data.readInt();
                    SoundEffectResource[] _result5 = getSoundEffectPreviewResource(_arg03);
                    reply.writeNoException();
                    reply.writeTypedArray(_result5, 1);
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg04 = data.readInt();
                    SoundEffectResource _result6 = getActiveSoundEffectResource(_arg04);
                    reply.writeNoException();
                    if (_result6 != null) {
                        reply.writeInt(1);
                        _result6.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    boolean _arg05 = data.readInt() != 0;
                    int _result7 = setBootSoundOnOff(_arg05);
                    reply.writeNoException();
                    reply.writeInt(_result7);
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    int _result8 = getBootSoundOnOff();
                    reply.writeNoException();
                    reply.writeInt(_result8);
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    BootSoundResource[] _result9 = getBootSoundResource();
                    reply.writeNoException();
                    reply.writeTypedArray(_result9, 1);
                    return true;
                case 10:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg06 = data.readInt();
                    int _result10 = setBootSoundResource(_arg06);
                    reply.writeNoException();
                    reply.writeInt(_result10);
                    return true;
                case 11:
                    data.enforceInterface(DESCRIPTOR);
                    BootSoundResource _result11 = getActiveBootSoundResource();
                    reply.writeNoException();
                    if (_result11 != null) {
                        reply.writeInt(1);
                        _result11.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 12:
                    data.enforceInterface(DESCRIPTOR);
                    ISoundResourceListener _arg07 = ISoundResourceListener.Stub.asInterface(data.readStrongBinder());
                    registerListener(_arg07);
                    reply.writeNoException();
                    return true;
                case 13:
                    data.enforceInterface(DESCRIPTOR);
                    ISoundResourceListener _arg08 = ISoundResourceListener.Stub.asInterface(data.readStrongBinder());
                    unRegisterListener(_arg08);
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements ISoundResource {
            public static ISoundResource sDefaultImpl;
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

            @Override // com.xiaopeng.xuimanager.soundresource.ISoundResource
            public SoundEffectTheme[] getAvailableThemes() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(1, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAvailableThemes();
                    }
                    _reply.readException();
                    SoundEffectTheme[] _result = (SoundEffectTheme[]) _reply.createTypedArray(SoundEffectTheme.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.soundresource.ISoundResource
            public int getActiveSoundEffectTheme() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(2, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getActiveSoundEffectTheme();
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.soundresource.ISoundResource
            public int selectSoundEffectTheme(int themeId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(themeId);
                    boolean _status = this.mRemote.transact(3, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().selectSoundEffectTheme(themeId);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.soundresource.ISoundResource
            public SoundEffectResource[] getSoundEffectPlayResource(int themeId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(themeId);
                    boolean _status = this.mRemote.transact(4, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSoundEffectPlayResource(themeId);
                    }
                    _reply.readException();
                    SoundEffectResource[] _result = (SoundEffectResource[]) _reply.createTypedArray(SoundEffectResource.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.soundresource.ISoundResource
            public SoundEffectResource[] getSoundEffectPreviewResource(int themeId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(themeId);
                    boolean _status = this.mRemote.transact(5, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSoundEffectPreviewResource(themeId);
                    }
                    _reply.readException();
                    SoundEffectResource[] _result = (SoundEffectResource[]) _reply.createTypedArray(SoundEffectResource.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.soundresource.ISoundResource
            public SoundEffectResource getActiveSoundEffectResource(int effectType) throws RemoteException {
                SoundEffectResource _result;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(effectType);
                    boolean _status = this.mRemote.transact(6, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getActiveSoundEffectResource(effectType);
                    }
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = SoundEffectResource.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.soundresource.ISoundResource
            public int setBootSoundOnOff(boolean flag) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(flag ? 1 : 0);
                    boolean _status = this.mRemote.transact(7, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setBootSoundOnOff(flag);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.soundresource.ISoundResource
            public int getBootSoundOnOff() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(8, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getBootSoundOnOff();
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.soundresource.ISoundResource
            public BootSoundResource[] getBootSoundResource() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(9, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getBootSoundResource();
                    }
                    _reply.readException();
                    BootSoundResource[] _result = (BootSoundResource[]) _reply.createTypedArray(BootSoundResource.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.soundresource.ISoundResource
            public int setBootSoundResource(int resourceId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(resourceId);
                    boolean _status = this.mRemote.transact(10, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setBootSoundResource(resourceId);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.soundresource.ISoundResource
            public BootSoundResource getActiveBootSoundResource() throws RemoteException {
                BootSoundResource _result;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(11, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getActiveBootSoundResource();
                    }
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = BootSoundResource.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.soundresource.ISoundResource
            public void registerListener(ISoundResourceListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = this.mRemote.transact(12, _data, _reply, 0);
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

            @Override // com.xiaopeng.xuimanager.soundresource.ISoundResource
            public void unRegisterListener(ISoundResourceListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = this.mRemote.transact(13, _data, _reply, 0);
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

        public static boolean setDefaultImpl(ISoundResource impl) {
            if (Proxy.sDefaultImpl == null && impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static ISoundResource getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
