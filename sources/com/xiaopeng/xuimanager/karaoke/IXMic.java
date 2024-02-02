package com.xiaopeng.xuimanager.karaoke;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.xuimanager.karaoke.IKaraokeEventListener;
/* loaded from: classes.dex */
public interface IXMic extends IInterface {
    int XMS_Create(String str, int i, String str2, IBinder iBinder) throws RemoteException;

    int XMS_Distroy(String str) throws RemoteException;

    int XMS_GetHandShakeStatus(String str) throws RemoteException;

    int XMS_GetMicPowerStatus(String str) throws RemoteException;

    int XMS_GetMicStatus(String str) throws RemoteException;

    int XMS_GetToken(String str) throws RemoteException;

    int XMS_GetVolume(String str, int i) throws RemoteException;

    int XMS_MicCreate(String str, int i, int i2, int i3) throws RemoteException;

    int XMS_MicDestroy(String str) throws RemoteException;

    int XMS_MicGetAvail(String str) throws RemoteException;

    int XMS_MicGetMinBuf(String str, int i, int i2) throws RemoteException;

    int XMS_MicRead(String str, byte[] bArr, int i) throws RemoteException;

    int XMS_Pause(String str) throws RemoteException;

    int XMS_PausePlay(String str) throws RemoteException;

    int XMS_Read(String str, byte[] bArr, int i) throws RemoteException;

    int XMS_RecCreate(String str, int i, int i2, int i3) throws RemoteException;

    int XMS_RecDestroy(String str) throws RemoteException;

    int XMS_RecGetAvail(String str) throws RemoteException;

    int XMS_RecGetMinBuf(String str, int i, int i2) throws RemoteException;

    int XMS_RecStart(String str) throws RemoteException;

    int XMS_RecStop(String str) throws RemoteException;

    void XMS_RegisterCallback(String str, IKaraokeEventListener iKaraokeEventListener) throws RemoteException;

    int XMS_Resume(String str) throws RemoteException;

    int XMS_ResumePlay(String str) throws RemoteException;

    int XMS_SaveRec(String str, int i, String str2, String str3) throws RemoteException;

    int XMS_SetRecMode(String str, int i) throws RemoteException;

    int XMS_SetSignedToken(String str, String str2) throws RemoteException;

    int XMS_SetVolume(String str, int i, int i2) throws RemoteException;

    int XMS_StopSaveRec(String str) throws RemoteException;

    int XMS_TrackCreate(String str, int i, int i2, int i3) throws RemoteException;

    int XMS_TrackDestroy(String str) throws RemoteException;

    int XMS_TrackGetAvail(String str) throws RemoteException;

    int XMS_TrackGetLatency(String str) throws RemoteException;

    int XMS_TrackGetMinBuf(String str, int i, int i2) throws RemoteException;

    void XMS_UnRegisterCallback(String str, IKaraokeEventListener iKaraokeEventListener) throws RemoteException;

    int XMS_Write(String str, byte[] bArr, int i, int i2) throws RemoteException;

    void XMS_connectMicFlow() throws RemoteException;

    String XMS_getMicName() throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IXMic {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.karaoke.IXMic";
        static final int TRANSACTION_XMS_Create = 3;
        static final int TRANSACTION_XMS_Distroy = 6;
        static final int TRANSACTION_XMS_GetHandShakeStatus = 9;
        static final int TRANSACTION_XMS_GetMicPowerStatus = 11;
        static final int TRANSACTION_XMS_GetMicStatus = 10;
        static final int TRANSACTION_XMS_GetToken = 7;
        static final int TRANSACTION_XMS_GetVolume = 13;
        static final int TRANSACTION_XMS_MicCreate = 35;
        static final int TRANSACTION_XMS_MicDestroy = 38;
        static final int TRANSACTION_XMS_MicGetAvail = 36;
        static final int TRANSACTION_XMS_MicGetMinBuf = 34;
        static final int TRANSACTION_XMS_MicRead = 37;
        static final int TRANSACTION_XMS_Pause = 20;
        static final int TRANSACTION_XMS_PausePlay = 25;
        static final int TRANSACTION_XMS_Read = 32;
        static final int TRANSACTION_XMS_RecCreate = 29;
        static final int TRANSACTION_XMS_RecDestroy = 33;
        static final int TRANSACTION_XMS_RecGetAvail = 30;
        static final int TRANSACTION_XMS_RecGetMinBuf = 28;
        static final int TRANSACTION_XMS_RecStart = 22;
        static final int TRANSACTION_XMS_RecStop = 21;
        static final int TRANSACTION_XMS_RegisterCallback = 4;
        static final int TRANSACTION_XMS_Resume = 23;
        static final int TRANSACTION_XMS_ResumePlay = 24;
        static final int TRANSACTION_XMS_SaveRec = 26;
        static final int TRANSACTION_XMS_SetRecMode = 31;
        static final int TRANSACTION_XMS_SetSignedToken = 8;
        static final int TRANSACTION_XMS_SetVolume = 12;
        static final int TRANSACTION_XMS_StopSaveRec = 27;
        static final int TRANSACTION_XMS_TrackCreate = 15;
        static final int TRANSACTION_XMS_TrackDestroy = 19;
        static final int TRANSACTION_XMS_TrackGetAvail = 18;
        static final int TRANSACTION_XMS_TrackGetLatency = 16;
        static final int TRANSACTION_XMS_TrackGetMinBuf = 14;
        static final int TRANSACTION_XMS_UnRegisterCallback = 5;
        static final int TRANSACTION_XMS_Write = 17;
        static final int TRANSACTION_XMS_connectMicFlow = 40;
        static final int TRANSACTION_XMS_getMicName = 39;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IXMic asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IXMic)) {
                return (IXMic) iin;
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
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg0 = data.readString();
                    int _arg1 = data.readInt();
                    String _arg2 = data.readString();
                    IBinder _arg3 = data.readStrongBinder();
                    int _result = XMS_Create(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg02 = data.readString();
                    IKaraokeEventListener _arg12 = IKaraokeEventListener.Stub.asInterface(data.readStrongBinder());
                    XMS_RegisterCallback(_arg02, _arg12);
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg03 = data.readString();
                    IKaraokeEventListener _arg13 = IKaraokeEventListener.Stub.asInterface(data.readStrongBinder());
                    XMS_UnRegisterCallback(_arg03, _arg13);
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg04 = data.readString();
                    int _result2 = XMS_Distroy(_arg04);
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg05 = data.readString();
                    int _result3 = XMS_GetToken(_arg05);
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg06 = data.readString();
                    String _arg14 = data.readString();
                    int _result4 = XMS_SetSignedToken(_arg06, _arg14);
                    reply.writeNoException();
                    reply.writeInt(_result4);
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg07 = data.readString();
                    int _result5 = XMS_GetHandShakeStatus(_arg07);
                    reply.writeNoException();
                    reply.writeInt(_result5);
                    return true;
                case 10:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg08 = data.readString();
                    int _result6 = XMS_GetMicStatus(_arg08);
                    reply.writeNoException();
                    reply.writeInt(_result6);
                    return true;
                case 11:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg09 = data.readString();
                    int _result7 = XMS_GetMicPowerStatus(_arg09);
                    reply.writeNoException();
                    reply.writeInt(_result7);
                    return true;
                case 12:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg010 = data.readString();
                    int _arg15 = data.readInt();
                    int _arg22 = data.readInt();
                    int _result8 = XMS_SetVolume(_arg010, _arg15, _arg22);
                    reply.writeNoException();
                    reply.writeInt(_result8);
                    return true;
                case 13:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg011 = data.readString();
                    int _arg16 = data.readInt();
                    int _result9 = XMS_GetVolume(_arg011, _arg16);
                    reply.writeNoException();
                    reply.writeInt(_result9);
                    return true;
                case 14:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg012 = data.readString();
                    int _arg17 = data.readInt();
                    int _arg23 = data.readInt();
                    int _result10 = XMS_TrackGetMinBuf(_arg012, _arg17, _arg23);
                    reply.writeNoException();
                    reply.writeInt(_result10);
                    return true;
                case 15:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg013 = data.readString();
                    int _arg18 = data.readInt();
                    int _arg24 = data.readInt();
                    int _arg32 = data.readInt();
                    int _result11 = XMS_TrackCreate(_arg013, _arg18, _arg24, _arg32);
                    reply.writeNoException();
                    reply.writeInt(_result11);
                    return true;
                case 16:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg014 = data.readString();
                    int _result12 = XMS_TrackGetLatency(_arg014);
                    reply.writeNoException();
                    reply.writeInt(_result12);
                    return true;
                case 17:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg015 = data.readString();
                    byte[] _arg19 = data.createByteArray();
                    int _arg25 = data.readInt();
                    int _arg33 = data.readInt();
                    int _result13 = XMS_Write(_arg015, _arg19, _arg25, _arg33);
                    reply.writeNoException();
                    reply.writeInt(_result13);
                    reply.writeByteArray(_arg19);
                    return true;
                case 18:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg016 = data.readString();
                    int _result14 = XMS_TrackGetAvail(_arg016);
                    reply.writeNoException();
                    reply.writeInt(_result14);
                    return true;
                case 19:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg017 = data.readString();
                    int _result15 = XMS_TrackDestroy(_arg017);
                    reply.writeNoException();
                    reply.writeInt(_result15);
                    return true;
                case 20:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg018 = data.readString();
                    int _result16 = XMS_Pause(_arg018);
                    reply.writeNoException();
                    reply.writeInt(_result16);
                    return true;
                case TRANSACTION_XMS_RecStop /* 21 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg019 = data.readString();
                    int _result17 = XMS_RecStop(_arg019);
                    reply.writeNoException();
                    reply.writeInt(_result17);
                    return true;
                case TRANSACTION_XMS_RecStart /* 22 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg020 = data.readString();
                    int _result18 = XMS_RecStart(_arg020);
                    reply.writeNoException();
                    reply.writeInt(_result18);
                    return true;
                case TRANSACTION_XMS_Resume /* 23 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg021 = data.readString();
                    int _result19 = XMS_Resume(_arg021);
                    reply.writeNoException();
                    reply.writeInt(_result19);
                    return true;
                case TRANSACTION_XMS_ResumePlay /* 24 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg022 = data.readString();
                    int _result20 = XMS_ResumePlay(_arg022);
                    reply.writeNoException();
                    reply.writeInt(_result20);
                    return true;
                case TRANSACTION_XMS_PausePlay /* 25 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg023 = data.readString();
                    int _result21 = XMS_PausePlay(_arg023);
                    reply.writeNoException();
                    reply.writeInt(_result21);
                    return true;
                case TRANSACTION_XMS_SaveRec /* 26 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg024 = data.readString();
                    int _arg110 = data.readInt();
                    String _arg26 = data.readString();
                    String _arg34 = data.readString();
                    int _result22 = XMS_SaveRec(_arg024, _arg110, _arg26, _arg34);
                    reply.writeNoException();
                    reply.writeInt(_result22);
                    return true;
                case TRANSACTION_XMS_StopSaveRec /* 27 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg025 = data.readString();
                    int _result23 = XMS_StopSaveRec(_arg025);
                    reply.writeNoException();
                    reply.writeInt(_result23);
                    return true;
                case TRANSACTION_XMS_RecGetMinBuf /* 28 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg026 = data.readString();
                    int _arg111 = data.readInt();
                    int _arg27 = data.readInt();
                    int _result24 = XMS_RecGetMinBuf(_arg026, _arg111, _arg27);
                    reply.writeNoException();
                    reply.writeInt(_result24);
                    return true;
                case TRANSACTION_XMS_RecCreate /* 29 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg027 = data.readString();
                    int _arg112 = data.readInt();
                    int _arg28 = data.readInt();
                    int _arg35 = data.readInt();
                    int _result25 = XMS_RecCreate(_arg027, _arg112, _arg28, _arg35);
                    reply.writeNoException();
                    reply.writeInt(_result25);
                    return true;
                case TRANSACTION_XMS_RecGetAvail /* 30 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg028 = data.readString();
                    int _result26 = XMS_RecGetAvail(_arg028);
                    reply.writeNoException();
                    reply.writeInt(_result26);
                    return true;
                case TRANSACTION_XMS_SetRecMode /* 31 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg029 = data.readString();
                    int _arg113 = data.readInt();
                    int _result27 = XMS_SetRecMode(_arg029, _arg113);
                    reply.writeNoException();
                    reply.writeInt(_result27);
                    return true;
                case 32:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg030 = data.readString();
                    byte[] _arg114 = data.createByteArray();
                    int _arg29 = data.readInt();
                    int _result28 = XMS_Read(_arg030, _arg114, _arg29);
                    reply.writeNoException();
                    reply.writeInt(_result28);
                    reply.writeByteArray(_arg114);
                    return true;
                case TRANSACTION_XMS_RecDestroy /* 33 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg031 = data.readString();
                    int _result29 = XMS_RecDestroy(_arg031);
                    reply.writeNoException();
                    reply.writeInt(_result29);
                    return true;
                case TRANSACTION_XMS_MicGetMinBuf /* 34 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg032 = data.readString();
                    int _arg115 = data.readInt();
                    int _arg210 = data.readInt();
                    int _result30 = XMS_MicGetMinBuf(_arg032, _arg115, _arg210);
                    reply.writeNoException();
                    reply.writeInt(_result30);
                    return true;
                case TRANSACTION_XMS_MicCreate /* 35 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg033 = data.readString();
                    int _arg116 = data.readInt();
                    int _arg211 = data.readInt();
                    int _arg36 = data.readInt();
                    int _result31 = XMS_MicCreate(_arg033, _arg116, _arg211, _arg36);
                    reply.writeNoException();
                    reply.writeInt(_result31);
                    return true;
                case TRANSACTION_XMS_MicGetAvail /* 36 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg034 = data.readString();
                    int _result32 = XMS_MicGetAvail(_arg034);
                    reply.writeNoException();
                    reply.writeInt(_result32);
                    return true;
                case TRANSACTION_XMS_MicRead /* 37 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg035 = data.readString();
                    byte[] _arg117 = data.createByteArray();
                    int _arg212 = data.readInt();
                    int _result33 = XMS_MicRead(_arg035, _arg117, _arg212);
                    reply.writeNoException();
                    reply.writeInt(_result33);
                    reply.writeByteArray(_arg117);
                    return true;
                case TRANSACTION_XMS_MicDestroy /* 38 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg036 = data.readString();
                    int _result34 = XMS_MicDestroy(_arg036);
                    reply.writeNoException();
                    reply.writeInt(_result34);
                    return true;
                case TRANSACTION_XMS_getMicName /* 39 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _result35 = XMS_getMicName();
                    reply.writeNoException();
                    reply.writeString(_result35);
                    return true;
                case TRANSACTION_XMS_connectMicFlow /* 40 */:
                    data.enforceInterface(DESCRIPTOR);
                    XMS_connectMicFlow();
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* loaded from: classes.dex */
        private static class Proxy implements IXMic {
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

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_Create(String pkgName, int mic, String midware, IBinder cbt) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeInt(mic);
                    _data.writeString(midware);
                    _data.writeStrongBinder(cbt);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public void XMS_RegisterCallback(String pkgName, IKaraokeEventListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public void XMS_UnRegisterCallback(String pkgName, IKaraokeEventListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_Distroy(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_GetToken(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_SetSignedToken(String pkgName, String sToken) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeString(sToken);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_GetHandShakeStatus(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_GetMicStatus(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_GetMicPowerStatus(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_SetVolume(String pkgName, int type, int vol) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeInt(type);
                    _data.writeInt(vol);
                    this.mRemote.transact(12, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_GetVolume(String pkgName, int type) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeInt(type);
                    this.mRemote.transact(13, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_TrackGetMinBuf(String pkgName, int sampleRate, int channel) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeInt(sampleRate);
                    _data.writeInt(channel);
                    this.mRemote.transact(14, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_TrackCreate(String pkgName, int sampleRate, int channel, int bufSize) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeInt(sampleRate);
                    _data.writeInt(channel);
                    _data.writeInt(bufSize);
                    this.mRemote.transact(15, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_TrackGetLatency(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    this.mRemote.transact(16, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_Write(String pkgName, byte[] data, int off, int size) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeByteArray(data);
                    _data.writeInt(off);
                    _data.writeInt(size);
                    this.mRemote.transact(17, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    _reply.readByteArray(data);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_TrackGetAvail(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    this.mRemote.transact(18, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_TrackDestroy(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    this.mRemote.transact(19, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_Pause(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    this.mRemote.transact(20, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_RecStop(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    this.mRemote.transact(Stub.TRANSACTION_XMS_RecStop, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_RecStart(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    this.mRemote.transact(Stub.TRANSACTION_XMS_RecStart, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_Resume(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    this.mRemote.transact(Stub.TRANSACTION_XMS_Resume, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_ResumePlay(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    this.mRemote.transact(Stub.TRANSACTION_XMS_ResumePlay, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_PausePlay(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    this.mRemote.transact(Stub.TRANSACTION_XMS_PausePlay, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_SaveRec(String pkgName, int mode, String micPath, String mixPath) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeInt(mode);
                    _data.writeString(micPath);
                    _data.writeString(mixPath);
                    this.mRemote.transact(Stub.TRANSACTION_XMS_SaveRec, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_StopSaveRec(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    this.mRemote.transact(Stub.TRANSACTION_XMS_StopSaveRec, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_RecGetMinBuf(String pkgName, int sampleRate, int channel) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeInt(sampleRate);
                    _data.writeInt(channel);
                    this.mRemote.transact(Stub.TRANSACTION_XMS_RecGetMinBuf, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_RecCreate(String pkgName, int sampleRate, int channel, int bufSize) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeInt(sampleRate);
                    _data.writeInt(channel);
                    _data.writeInt(bufSize);
                    this.mRemote.transact(Stub.TRANSACTION_XMS_RecCreate, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_RecGetAvail(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    this.mRemote.transact(Stub.TRANSACTION_XMS_RecGetAvail, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_SetRecMode(String pkgName, int mode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeInt(mode);
                    this.mRemote.transact(Stub.TRANSACTION_XMS_SetRecMode, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_Read(String pkgName, byte[] data, int size) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeByteArray(data);
                    _data.writeInt(size);
                    this.mRemote.transact(32, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    _reply.readByteArray(data);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_RecDestroy(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    this.mRemote.transact(Stub.TRANSACTION_XMS_RecDestroy, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_MicGetMinBuf(String pkgName, int sampleRate, int channel) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeInt(sampleRate);
                    _data.writeInt(channel);
                    this.mRemote.transact(Stub.TRANSACTION_XMS_MicGetMinBuf, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_MicCreate(String pkgName, int sampleRate, int channel, int bufSize) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeInt(sampleRate);
                    _data.writeInt(channel);
                    _data.writeInt(bufSize);
                    this.mRemote.transact(Stub.TRANSACTION_XMS_MicCreate, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_MicGetAvail(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    this.mRemote.transact(Stub.TRANSACTION_XMS_MicGetAvail, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_MicRead(String pkgName, byte[] data, int size) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeByteArray(data);
                    _data.writeInt(size);
                    this.mRemote.transact(Stub.TRANSACTION_XMS_MicRead, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    _reply.readByteArray(data);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public int XMS_MicDestroy(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    this.mRemote.transact(Stub.TRANSACTION_XMS_MicDestroy, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public String XMS_getMicName() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_XMS_getMicName, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IXMic
            public void XMS_connectMicFlow() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_XMS_connectMicFlow, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}
