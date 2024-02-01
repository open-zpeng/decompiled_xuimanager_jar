package com.xiaopeng.xuimanager.karaoke;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.xuimanager.karaoke.IKaraokeEventListener;
import java.util.Map;

/* loaded from: classes.dex */
public interface IKaraoke extends IInterface {
    int XMS_Create(String str, int i, String str2, IBinder iBinder) throws RemoteException;

    int XMS_Distroy(String str) throws RemoteException;

    int XMS_GetEcho(String str) throws RemoteException;

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

    int XMS_SetEcho(String str, int i) throws RemoteException;

    int XMS_SetRecMode(String str, int i) throws RemoteException;

    int XMS_SetSignedToken(String str, String str2) throws RemoteException;

    int XMS_SetVolume(String str, int i, int i2) throws RemoteException;

    void XMS_ShowToast(String str) throws RemoteException;

    int XMS_StopSaveRec(String str) throws RemoteException;

    int XMS_TrackCreate(String str, int i, int i2, int i3) throws RemoteException;

    int XMS_TrackDestroy(String str) throws RemoteException;

    int XMS_TrackGetAvail(String str) throws RemoteException;

    int XMS_TrackGetLatency(String str) throws RemoteException;

    int XMS_TrackGetMinBuf(String str, int i, int i2) throws RemoteException;

    void XMS_UnRegisterCallback(String str, IKaraokeEventListener iKaraokeEventListener) throws RemoteException;

    int XMS_Write(String str, byte[] bArr, int i, int i2) throws RemoteException;

    int XMS_aiWakeUp() throws RemoteException;

    int XMS_atlSwitch(boolean z) throws RemoteException;

    int XMS_clientDied() throws RemoteException;

    void XMS_connectMicFlow() throws RemoteException;

    String XMS_getBuyMicUrl() throws RemoteException;

    String XMS_getMicName() throws RemoteException;

    Map XMS_getMicSoundEffectMap() throws RemoteException;

    boolean XMS_hasAtl() throws RemoteException;

    boolean XMS_isAtlEnabled() throws RemoteException;

    int XMS_releaseKaraokeResource(String str) throws RemoteException;

    int XMS_requestKaraokeResource(String str, int i, int i2, int i3) throws RemoteException;

    void XMS_setAtlEnable(boolean z) throws RemoteException;

    int XMS_setMusicInfo(String[] strArr) throws RemoteException;

    int XMS_setMusicLyric(String[] strArr) throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements IKaraoke {
        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_Create(String pkgName, int mic, String midware, IBinder cbt) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public void XMS_RegisterCallback(String pkgName, IKaraokeEventListener listener) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public void XMS_UnRegisterCallback(String pkgName, IKaraokeEventListener listener) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_Distroy(String pkgName) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_GetToken(String pkgName) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_SetSignedToken(String pkgName, String sToken) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_GetHandShakeStatus(String pkgName) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_GetMicStatus(String pkgName) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_GetMicPowerStatus(String pkgName) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_SetVolume(String pkgName, int type, int vol) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_GetVolume(String pkgName, int type) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_SetEcho(String pkgName, int echo) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_GetEcho(String pkgName) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_TrackGetMinBuf(String pkgName, int sampleRate, int channel) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_TrackCreate(String pkgName, int sampleRate, int channel, int bufSize) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_TrackGetLatency(String pkgName) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_Write(String pkgName, byte[] data, int off, int size) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_TrackGetAvail(String pkgName) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_TrackDestroy(String pkgName) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_Pause(String pkgName) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_RecStop(String pkgName) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_RecStart(String pkgName) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_Resume(String pkgName) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_ResumePlay(String pkgName) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_PausePlay(String pkgName) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_SaveRec(String pkgName, int mode, String micPath, String mixPath) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_StopSaveRec(String pkgName) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_RecGetMinBuf(String pkgName, int sampleRate, int channel) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_RecCreate(String pkgName, int sampleRate, int channel, int bufSize) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_RecGetAvail(String pkgName) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_SetRecMode(String pkgName, int mode) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_Read(String pkgName, byte[] data, int size) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_RecDestroy(String pkgName) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_MicGetMinBuf(String pkgName, int sampleRate, int channel) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_MicCreate(String pkgName, int sampleRate, int channel, int bufSize) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_MicGetAvail(String pkgName) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_MicRead(String pkgName, byte[] data, int size) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_MicDestroy(String pkgName) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_atlSwitch(boolean enable) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_aiWakeUp() throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public boolean XMS_hasAtl() throws RemoteException {
            return false;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public String XMS_getMicName() throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public void XMS_setAtlEnable(boolean enable) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public boolean XMS_isAtlEnabled() throws RemoteException {
            return false;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public String XMS_getBuyMicUrl() throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public void XMS_connectMicFlow() throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public void XMS_ShowToast(String toast) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_setMusicInfo(String[] musicInfo) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_setMusicLyric(String[] lyric) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_clientDied() throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public Map XMS_getMicSoundEffectMap() throws RemoteException {
            return null;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_requestKaraokeResource(String pkgName, int sampleRate, int channel, int bufferSize) throws RemoteException {
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
        public int XMS_releaseKaraokeResource(String pkgName) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IKaraoke {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.karaoke.IKaraoke";
        static final int TRANSACTION_XMS_Create = 1;
        static final int TRANSACTION_XMS_Distroy = 4;
        static final int TRANSACTION_XMS_GetEcho = 13;
        static final int TRANSACTION_XMS_GetHandShakeStatus = 7;
        static final int TRANSACTION_XMS_GetMicPowerStatus = 9;
        static final int TRANSACTION_XMS_GetMicStatus = 8;
        static final int TRANSACTION_XMS_GetToken = 5;
        static final int TRANSACTION_XMS_GetVolume = 11;
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
        static final int TRANSACTION_XMS_RegisterCallback = 2;
        static final int TRANSACTION_XMS_Resume = 23;
        static final int TRANSACTION_XMS_ResumePlay = 24;
        static final int TRANSACTION_XMS_SaveRec = 26;
        static final int TRANSACTION_XMS_SetEcho = 12;
        static final int TRANSACTION_XMS_SetRecMode = 31;
        static final int TRANSACTION_XMS_SetSignedToken = 6;
        static final int TRANSACTION_XMS_SetVolume = 10;
        static final int TRANSACTION_XMS_ShowToast = 47;
        static final int TRANSACTION_XMS_StopSaveRec = 27;
        static final int TRANSACTION_XMS_TrackCreate = 15;
        static final int TRANSACTION_XMS_TrackDestroy = 19;
        static final int TRANSACTION_XMS_TrackGetAvail = 18;
        static final int TRANSACTION_XMS_TrackGetLatency = 16;
        static final int TRANSACTION_XMS_TrackGetMinBuf = 14;
        static final int TRANSACTION_XMS_UnRegisterCallback = 3;
        static final int TRANSACTION_XMS_Write = 17;
        static final int TRANSACTION_XMS_aiWakeUp = 40;
        static final int TRANSACTION_XMS_atlSwitch = 39;
        static final int TRANSACTION_XMS_clientDied = 50;
        static final int TRANSACTION_XMS_connectMicFlow = 46;
        static final int TRANSACTION_XMS_getBuyMicUrl = 45;
        static final int TRANSACTION_XMS_getMicName = 42;
        static final int TRANSACTION_XMS_getMicSoundEffectMap = 51;
        static final int TRANSACTION_XMS_hasAtl = 41;
        static final int TRANSACTION_XMS_isAtlEnabled = 44;
        static final int TRANSACTION_XMS_releaseKaraokeResource = 53;
        static final int TRANSACTION_XMS_requestKaraokeResource = 52;
        static final int TRANSACTION_XMS_setAtlEnable = 43;
        static final int TRANSACTION_XMS_setMusicInfo = 48;
        static final int TRANSACTION_XMS_setMusicLyric = 49;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IKaraoke asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IKaraoke)) {
                return (IKaraoke) iin;
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
                    String _arg02 = data.readString();
                    int _arg1 = data.readInt();
                    String _arg2 = data.readString();
                    IBinder _arg3 = data.readStrongBinder();
                    int _result = XMS_Create(_arg02, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg03 = data.readString();
                    IKaraokeEventListener _arg12 = IKaraokeEventListener.Stub.asInterface(data.readStrongBinder());
                    XMS_RegisterCallback(_arg03, _arg12);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg04 = data.readString();
                    IKaraokeEventListener _arg13 = IKaraokeEventListener.Stub.asInterface(data.readStrongBinder());
                    XMS_UnRegisterCallback(_arg04, _arg13);
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    int _result2 = XMS_Distroy(data.readString());
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    int _result3 = XMS_GetToken(data.readString());
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg05 = data.readString();
                    String _arg14 = data.readString();
                    int _result4 = XMS_SetSignedToken(_arg05, _arg14);
                    reply.writeNoException();
                    reply.writeInt(_result4);
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    int _result5 = XMS_GetHandShakeStatus(data.readString());
                    reply.writeNoException();
                    reply.writeInt(_result5);
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    int _result6 = XMS_GetMicStatus(data.readString());
                    reply.writeNoException();
                    reply.writeInt(_result6);
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    int _result7 = XMS_GetMicPowerStatus(data.readString());
                    reply.writeNoException();
                    reply.writeInt(_result7);
                    return true;
                case 10:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg06 = data.readString();
                    int _arg15 = data.readInt();
                    int _arg22 = data.readInt();
                    int _result8 = XMS_SetVolume(_arg06, _arg15, _arg22);
                    reply.writeNoException();
                    reply.writeInt(_result8);
                    return true;
                case 11:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg07 = data.readString();
                    int _arg16 = data.readInt();
                    int _result9 = XMS_GetVolume(_arg07, _arg16);
                    reply.writeNoException();
                    reply.writeInt(_result9);
                    return true;
                case 12:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg08 = data.readString();
                    int _arg17 = data.readInt();
                    int _result10 = XMS_SetEcho(_arg08, _arg17);
                    reply.writeNoException();
                    reply.writeInt(_result10);
                    return true;
                case 13:
                    data.enforceInterface(DESCRIPTOR);
                    int _result11 = XMS_GetEcho(data.readString());
                    reply.writeNoException();
                    reply.writeInt(_result11);
                    return true;
                case 14:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg09 = data.readString();
                    int _arg18 = data.readInt();
                    int _arg23 = data.readInt();
                    int _result12 = XMS_TrackGetMinBuf(_arg09, _arg18, _arg23);
                    reply.writeNoException();
                    reply.writeInt(_result12);
                    return true;
                case 15:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg010 = data.readString();
                    int _arg19 = data.readInt();
                    int _arg24 = data.readInt();
                    int _arg32 = data.readInt();
                    int _result13 = XMS_TrackCreate(_arg010, _arg19, _arg24, _arg32);
                    reply.writeNoException();
                    reply.writeInt(_result13);
                    return true;
                case 16:
                    data.enforceInterface(DESCRIPTOR);
                    int _result14 = XMS_TrackGetLatency(data.readString());
                    reply.writeNoException();
                    reply.writeInt(_result14);
                    return true;
                case 17:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg011 = data.readString();
                    byte[] _arg110 = data.createByteArray();
                    int _arg25 = data.readInt();
                    int _arg33 = data.readInt();
                    int _result15 = XMS_Write(_arg011, _arg110, _arg25, _arg33);
                    reply.writeNoException();
                    reply.writeInt(_result15);
                    reply.writeByteArray(_arg110);
                    return true;
                case 18:
                    data.enforceInterface(DESCRIPTOR);
                    int _result16 = XMS_TrackGetAvail(data.readString());
                    reply.writeNoException();
                    reply.writeInt(_result16);
                    return true;
                case 19:
                    data.enforceInterface(DESCRIPTOR);
                    int _result17 = XMS_TrackDestroy(data.readString());
                    reply.writeNoException();
                    reply.writeInt(_result17);
                    return true;
                case 20:
                    data.enforceInterface(DESCRIPTOR);
                    int _result18 = XMS_Pause(data.readString());
                    reply.writeNoException();
                    reply.writeInt(_result18);
                    return true;
                case TRANSACTION_XMS_RecStop /* 21 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _result19 = XMS_RecStop(data.readString());
                    reply.writeNoException();
                    reply.writeInt(_result19);
                    return true;
                case TRANSACTION_XMS_RecStart /* 22 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _result20 = XMS_RecStart(data.readString());
                    reply.writeNoException();
                    reply.writeInt(_result20);
                    return true;
                case TRANSACTION_XMS_Resume /* 23 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _result21 = XMS_Resume(data.readString());
                    reply.writeNoException();
                    reply.writeInt(_result21);
                    return true;
                case TRANSACTION_XMS_ResumePlay /* 24 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _result22 = XMS_ResumePlay(data.readString());
                    reply.writeNoException();
                    reply.writeInt(_result22);
                    return true;
                case TRANSACTION_XMS_PausePlay /* 25 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _result23 = XMS_PausePlay(data.readString());
                    reply.writeNoException();
                    reply.writeInt(_result23);
                    return true;
                case TRANSACTION_XMS_SaveRec /* 26 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg012 = data.readString();
                    int _arg111 = data.readInt();
                    String _arg26 = data.readString();
                    String _arg34 = data.readString();
                    int _result24 = XMS_SaveRec(_arg012, _arg111, _arg26, _arg34);
                    reply.writeNoException();
                    reply.writeInt(_result24);
                    return true;
                case TRANSACTION_XMS_StopSaveRec /* 27 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _result25 = XMS_StopSaveRec(data.readString());
                    reply.writeNoException();
                    reply.writeInt(_result25);
                    return true;
                case TRANSACTION_XMS_RecGetMinBuf /* 28 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg013 = data.readString();
                    int _arg112 = data.readInt();
                    int _arg27 = data.readInt();
                    int _result26 = XMS_RecGetMinBuf(_arg013, _arg112, _arg27);
                    reply.writeNoException();
                    reply.writeInt(_result26);
                    return true;
                case TRANSACTION_XMS_RecCreate /* 29 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg014 = data.readString();
                    int _arg113 = data.readInt();
                    int _arg28 = data.readInt();
                    int _arg35 = data.readInt();
                    int _result27 = XMS_RecCreate(_arg014, _arg113, _arg28, _arg35);
                    reply.writeNoException();
                    reply.writeInt(_result27);
                    return true;
                case TRANSACTION_XMS_RecGetAvail /* 30 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _result28 = XMS_RecGetAvail(data.readString());
                    reply.writeNoException();
                    reply.writeInt(_result28);
                    return true;
                case TRANSACTION_XMS_SetRecMode /* 31 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg015 = data.readString();
                    int _arg114 = data.readInt();
                    int _result29 = XMS_SetRecMode(_arg015, _arg114);
                    reply.writeNoException();
                    reply.writeInt(_result29);
                    return true;
                case 32:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg016 = data.readString();
                    byte[] _arg115 = data.createByteArray();
                    int _arg29 = data.readInt();
                    int _result30 = XMS_Read(_arg016, _arg115, _arg29);
                    reply.writeNoException();
                    reply.writeInt(_result30);
                    reply.writeByteArray(_arg115);
                    return true;
                case TRANSACTION_XMS_RecDestroy /* 33 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _result31 = XMS_RecDestroy(data.readString());
                    reply.writeNoException();
                    reply.writeInt(_result31);
                    return true;
                case TRANSACTION_XMS_MicGetMinBuf /* 34 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg017 = data.readString();
                    int _arg116 = data.readInt();
                    int _arg210 = data.readInt();
                    int _result32 = XMS_MicGetMinBuf(_arg017, _arg116, _arg210);
                    reply.writeNoException();
                    reply.writeInt(_result32);
                    return true;
                case TRANSACTION_XMS_MicCreate /* 35 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg018 = data.readString();
                    int _arg117 = data.readInt();
                    int _arg211 = data.readInt();
                    int _arg36 = data.readInt();
                    int _result33 = XMS_MicCreate(_arg018, _arg117, _arg211, _arg36);
                    reply.writeNoException();
                    reply.writeInt(_result33);
                    return true;
                case TRANSACTION_XMS_MicGetAvail /* 36 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _result34 = XMS_MicGetAvail(data.readString());
                    reply.writeNoException();
                    reply.writeInt(_result34);
                    return true;
                case TRANSACTION_XMS_MicRead /* 37 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg019 = data.readString();
                    byte[] _arg118 = data.createByteArray();
                    int _arg212 = data.readInt();
                    int _result35 = XMS_MicRead(_arg019, _arg118, _arg212);
                    reply.writeNoException();
                    reply.writeInt(_result35);
                    reply.writeByteArray(_arg118);
                    return true;
                case TRANSACTION_XMS_MicDestroy /* 38 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _result36 = XMS_MicDestroy(data.readString());
                    reply.writeNoException();
                    reply.writeInt(_result36);
                    return true;
                case TRANSACTION_XMS_atlSwitch /* 39 */:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt() != 0;
                    int _result37 = XMS_atlSwitch(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result37);
                    return true;
                case TRANSACTION_XMS_aiWakeUp /* 40 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _result38 = XMS_aiWakeUp();
                    reply.writeNoException();
                    reply.writeInt(_result38);
                    return true;
                case TRANSACTION_XMS_hasAtl /* 41 */:
                    data.enforceInterface(DESCRIPTOR);
                    boolean XMS_hasAtl = XMS_hasAtl();
                    reply.writeNoException();
                    reply.writeInt(XMS_hasAtl ? 1 : 0);
                    return true;
                case TRANSACTION_XMS_getMicName /* 42 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _result39 = XMS_getMicName();
                    reply.writeNoException();
                    reply.writeString(_result39);
                    return true;
                case TRANSACTION_XMS_setAtlEnable /* 43 */:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt() != 0;
                    XMS_setAtlEnable(_arg0);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_XMS_isAtlEnabled /* 44 */:
                    data.enforceInterface(DESCRIPTOR);
                    boolean XMS_isAtlEnabled = XMS_isAtlEnabled();
                    reply.writeNoException();
                    reply.writeInt(XMS_isAtlEnabled ? 1 : 0);
                    return true;
                case TRANSACTION_XMS_getBuyMicUrl /* 45 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _result40 = XMS_getBuyMicUrl();
                    reply.writeNoException();
                    reply.writeString(_result40);
                    return true;
                case TRANSACTION_XMS_connectMicFlow /* 46 */:
                    data.enforceInterface(DESCRIPTOR);
                    XMS_connectMicFlow();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_XMS_ShowToast /* 47 */:
                    data.enforceInterface(DESCRIPTOR);
                    XMS_ShowToast(data.readString());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_XMS_setMusicInfo /* 48 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _result41 = XMS_setMusicInfo(data.createStringArray());
                    reply.writeNoException();
                    reply.writeInt(_result41);
                    return true;
                case TRANSACTION_XMS_setMusicLyric /* 49 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _result42 = XMS_setMusicLyric(data.createStringArray());
                    reply.writeNoException();
                    reply.writeInt(_result42);
                    return true;
                case TRANSACTION_XMS_clientDied /* 50 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _result43 = XMS_clientDied();
                    reply.writeNoException();
                    reply.writeInt(_result43);
                    return true;
                case TRANSACTION_XMS_getMicSoundEffectMap /* 51 */:
                    data.enforceInterface(DESCRIPTOR);
                    Map _result44 = XMS_getMicSoundEffectMap();
                    reply.writeNoException();
                    reply.writeMap(_result44);
                    return true;
                case TRANSACTION_XMS_requestKaraokeResource /* 52 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg020 = data.readString();
                    int _arg119 = data.readInt();
                    int _arg213 = data.readInt();
                    int _arg37 = data.readInt();
                    int _result45 = XMS_requestKaraokeResource(_arg020, _arg119, _arg213, _arg37);
                    reply.writeNoException();
                    reply.writeInt(_result45);
                    return true;
                case TRANSACTION_XMS_releaseKaraokeResource /* 53 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _result46 = XMS_releaseKaraokeResource(data.readString());
                    reply.writeNoException();
                    reply.writeInt(_result46);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements IKaraoke {
            public static IKaraoke sDefaultImpl;
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

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_Create(String pkgName, int mic, String midware, IBinder cbt) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeInt(mic);
                    _data.writeString(midware);
                    _data.writeStrongBinder(cbt);
                    boolean _status = this.mRemote.transact(1, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_Create(pkgName, mic, midware, cbt);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public void XMS_RegisterCallback(String pkgName, IKaraokeEventListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = this.mRemote.transact(2, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().XMS_RegisterCallback(pkgName, listener);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public void XMS_UnRegisterCallback(String pkgName, IKaraokeEventListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = this.mRemote.transact(3, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().XMS_UnRegisterCallback(pkgName, listener);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_Distroy(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    boolean _status = this.mRemote.transact(4, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_Distroy(pkgName);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_GetToken(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    boolean _status = this.mRemote.transact(5, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_GetToken(pkgName);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_SetSignedToken(String pkgName, String sToken) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeString(sToken);
                    boolean _status = this.mRemote.transact(6, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_SetSignedToken(pkgName, sToken);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_GetHandShakeStatus(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    boolean _status = this.mRemote.transact(7, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_GetHandShakeStatus(pkgName);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_GetMicStatus(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    boolean _status = this.mRemote.transact(8, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_GetMicStatus(pkgName);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_GetMicPowerStatus(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    boolean _status = this.mRemote.transact(9, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_GetMicPowerStatus(pkgName);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_SetVolume(String pkgName, int type, int vol) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeInt(type);
                    _data.writeInt(vol);
                    boolean _status = this.mRemote.transact(10, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_SetVolume(pkgName, type, vol);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_GetVolume(String pkgName, int type) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeInt(type);
                    boolean _status = this.mRemote.transact(11, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_GetVolume(pkgName, type);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_SetEcho(String pkgName, int echo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeInt(echo);
                    boolean _status = this.mRemote.transact(12, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_SetEcho(pkgName, echo);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_GetEcho(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    boolean _status = this.mRemote.transact(13, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_GetEcho(pkgName);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_TrackGetMinBuf(String pkgName, int sampleRate, int channel) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeInt(sampleRate);
                    _data.writeInt(channel);
                    boolean _status = this.mRemote.transact(14, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_TrackGetMinBuf(pkgName, sampleRate, channel);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_TrackCreate(String pkgName, int sampleRate, int channel, int bufSize) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeInt(sampleRate);
                    _data.writeInt(channel);
                    _data.writeInt(bufSize);
                    boolean _status = this.mRemote.transact(15, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_TrackCreate(pkgName, sampleRate, channel, bufSize);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_TrackGetLatency(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    boolean _status = this.mRemote.transact(16, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_TrackGetLatency(pkgName);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_Write(String pkgName, byte[] data, int off, int size) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeByteArray(data);
                    _data.writeInt(off);
                    _data.writeInt(size);
                    boolean _status = this.mRemote.transact(17, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_Write(pkgName, data, off, size);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    _reply.readByteArray(data);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_TrackGetAvail(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    boolean _status = this.mRemote.transact(18, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_TrackGetAvail(pkgName);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_TrackDestroy(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    boolean _status = this.mRemote.transact(19, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_TrackDestroy(pkgName);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_Pause(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    boolean _status = this.mRemote.transact(20, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_Pause(pkgName);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_RecStop(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_XMS_RecStop, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_RecStop(pkgName);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_RecStart(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_XMS_RecStart, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_RecStart(pkgName);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_Resume(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_XMS_Resume, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_Resume(pkgName);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_ResumePlay(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_XMS_ResumePlay, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_ResumePlay(pkgName);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_PausePlay(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_XMS_PausePlay, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_PausePlay(pkgName);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_SaveRec(String pkgName, int mode, String micPath, String mixPath) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeInt(mode);
                    _data.writeString(micPath);
                    _data.writeString(mixPath);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_XMS_SaveRec, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_SaveRec(pkgName, mode, micPath, mixPath);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_StopSaveRec(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_XMS_StopSaveRec, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_StopSaveRec(pkgName);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_RecGetMinBuf(String pkgName, int sampleRate, int channel) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeInt(sampleRate);
                    _data.writeInt(channel);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_XMS_RecGetMinBuf, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_RecGetMinBuf(pkgName, sampleRate, channel);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_RecCreate(String pkgName, int sampleRate, int channel, int bufSize) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeInt(sampleRate);
                    _data.writeInt(channel);
                    _data.writeInt(bufSize);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_XMS_RecCreate, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_RecCreate(pkgName, sampleRate, channel, bufSize);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_RecGetAvail(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_XMS_RecGetAvail, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_RecGetAvail(pkgName);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_SetRecMode(String pkgName, int mode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeInt(mode);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_XMS_SetRecMode, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_SetRecMode(pkgName, mode);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_Read(String pkgName, byte[] data, int size) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeByteArray(data);
                    _data.writeInt(size);
                    boolean _status = this.mRemote.transact(32, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_Read(pkgName, data, size);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    _reply.readByteArray(data);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_RecDestroy(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_XMS_RecDestroy, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_RecDestroy(pkgName);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_MicGetMinBuf(String pkgName, int sampleRate, int channel) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeInt(sampleRate);
                    _data.writeInt(channel);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_XMS_MicGetMinBuf, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_MicGetMinBuf(pkgName, sampleRate, channel);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_MicCreate(String pkgName, int sampleRate, int channel, int bufSize) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeInt(sampleRate);
                    _data.writeInt(channel);
                    _data.writeInt(bufSize);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_XMS_MicCreate, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_MicCreate(pkgName, sampleRate, channel, bufSize);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_MicGetAvail(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_XMS_MicGetAvail, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_MicGetAvail(pkgName);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_MicRead(String pkgName, byte[] data, int size) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeByteArray(data);
                    _data.writeInt(size);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_XMS_MicRead, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_MicRead(pkgName, data, size);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    _reply.readByteArray(data);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_MicDestroy(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_XMS_MicDestroy, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_MicDestroy(pkgName);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_atlSwitch(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enable ? 1 : 0);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_XMS_atlSwitch, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_atlSwitch(enable);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_aiWakeUp() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_XMS_aiWakeUp, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_aiWakeUp();
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public boolean XMS_hasAtl() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_XMS_hasAtl, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_hasAtl();
                    }
                    _reply.readException();
                    boolean _status2 = _reply.readInt() != 0;
                    return _status2;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public String XMS_getMicName() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_XMS_getMicName, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_getMicName();
                    }
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public void XMS_setAtlEnable(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enable ? 1 : 0);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_XMS_setAtlEnable, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().XMS_setAtlEnable(enable);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public boolean XMS_isAtlEnabled() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_XMS_isAtlEnabled, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_isAtlEnabled();
                    }
                    _reply.readException();
                    boolean _status2 = _reply.readInt() != 0;
                    return _status2;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public String XMS_getBuyMicUrl() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_XMS_getBuyMicUrl, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_getBuyMicUrl();
                    }
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public void XMS_connectMicFlow() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_XMS_connectMicFlow, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().XMS_connectMicFlow();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public void XMS_ShowToast(String toast) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(toast);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_XMS_ShowToast, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().XMS_ShowToast(toast);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_setMusicInfo(String[] musicInfo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStringArray(musicInfo);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_XMS_setMusicInfo, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_setMusicInfo(musicInfo);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_setMusicLyric(String[] lyric) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStringArray(lyric);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_XMS_setMusicLyric, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_setMusicLyric(lyric);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_clientDied() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_XMS_clientDied, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_clientDied();
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public Map XMS_getMicSoundEffectMap() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_XMS_getMicSoundEffectMap, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_getMicSoundEffectMap();
                    }
                    _reply.readException();
                    ClassLoader cl = getClass().getClassLoader();
                    Map _result = _reply.readHashMap(cl);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_requestKaraokeResource(String pkgName, int sampleRate, int channel, int bufferSize) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeInt(sampleRate);
                    _data.writeInt(channel);
                    _data.writeInt(bufferSize);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_XMS_requestKaraokeResource, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_requestKaraokeResource(pkgName, sampleRate, channel, bufferSize);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.karaoke.IKaraoke
            public int XMS_releaseKaraokeResource(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    boolean _status = this.mRemote.transact(Stub.TRANSACTION_XMS_releaseKaraokeResource, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().XMS_releaseKaraokeResource(pkgName);
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

        public static boolean setDefaultImpl(IKaraoke impl) {
            if (Proxy.sDefaultImpl == null && impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static IKaraoke getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
