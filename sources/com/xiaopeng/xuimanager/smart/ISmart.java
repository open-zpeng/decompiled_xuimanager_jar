package com.xiaopeng.xuimanager.smart;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.xuimanager.smart.ISmartCommonEventListener;
import com.xiaopeng.xuimanager.smart.ISmartEventListener;
import java.util.List;
/* loaded from: classes.dex */
public interface ISmart extends IInterface {
    void enableCarSpeedVolume(boolean z) throws RemoteException;

    boolean getAlarmFromAzimuthOrIcm() throws RemoteException;

    int getAlarmVolume() throws RemoteException;

    int getBootSoundEffect() throws RemoteException;

    int getBossKeyForCustomer() throws RemoteException;

    boolean getFftLLUEnable() throws RemoteException;

    boolean getKeyBoardTouchPrompt() throws RemoteException;

    boolean getLangLightEffectEnable() throws RemoteException;

    List<String> getLangLightEffectNameList(int i) throws RemoteException;

    int getLightEffect(int i) throws RemoteException;

    int getLluSleepMode() throws RemoteException;

    int getLluWakeWaitMode() throws RemoteException;

    String getRunnningLluEffectName() throws RemoteException;

    int getSayHiEffect() throws RemoteException;

    boolean getSayHiEnable() throws RemoteException;

    boolean getSpeechStatus() throws RemoteException;

    int getTouchRotationDirection() throws RemoteException;

    boolean getVolumeDownInReverseMode() throws RemoteException;

    boolean getVolumeDownWithDoorOpen() throws RemoteException;

    int getXKeyForCustomer() throws RemoteException;

    int isLightDanceAvailable() throws RemoteException;

    boolean isLightDancing() throws RemoteException;

    void registerCommonListener(ISmartCommonEventListener iSmartCommonEventListener) throws RemoteException;

    void registerListener(ISmartEventListener iSmartEventListener) throws RemoteException;

    void setAlarmFromAzimuthOrIcm(boolean z) throws RemoteException;

    void setAlarmVolume(int i) throws RemoteException;

    void setBootSoundEffect(int i) throws RemoteException;

    void setBossKeyForCustomer(int i) throws RemoteException;

    void setFftLLUEnable(boolean z) throws RemoteException;

    void setKeyBoardTouchPrompt(boolean z) throws RemoteException;

    void setLangLightEffectEnable(boolean z) throws RemoteException;

    void setLangLightEffectMode(String str, int i) throws RemoteException;

    void setLangLightEffectWithMode(String str, int i, int i2) throws RemoteException;

    void setLangLightMusicEffect(String str) throws RemoteException;

    void setLightEffect(int i, int i2) throws RemoteException;

    void setLightEffectAndMusic(int i, int i2, int i3) throws RemoteException;

    void setLluSleepMode(int i) throws RemoteException;

    void setLluWakeWaitMode(int i) throws RemoteException;

    void setMusicDelayTimeForDebug(int i) throws RemoteException;

    void setMusicSpectrumToLangLight(int i) throws RemoteException;

    void setMusicStartTickNumForDebug(int i) throws RemoteException;

    void setMusicStopTickNumForDebug(int i) throws RemoteException;

    void setMusicTableForDebug(int i) throws RemoteException;

    void setPause(boolean z) throws RemoteException;

    void setSayHiEffect(int i) throws RemoteException;

    void setSayHiEnable(boolean z) throws RemoteException;

    void setSpeedVolumeMode(int i) throws RemoteException;

    void setTouchRotationDirection(int i) throws RemoteException;

    void setVolumeDownInReverseMode(boolean z) throws RemoteException;

    void setVolumeDownWithDoorOpen(boolean z) throws RemoteException;

    void setXKeyForCustomer(int i) throws RemoteException;

    String speakByImportant(String str) throws RemoteException;

    String speakByInstant(String str, boolean z) throws RemoteException;

    String speakByNormal(String str) throws RemoteException;

    String speakByUrgent(String str) throws RemoteException;

    void startAiLluMode(int i) throws RemoteException;

    int startLightDancing(String str, int i) throws RemoteException;

    int startMicRecordMode(int i) throws RemoteException;

    void stopAiLluMode() throws RemoteException;

    void stopAllSpeech() throws RemoteException;

    int stopLightDancing() throws RemoteException;

    void stopLightEffectShow() throws RemoteException;

    int stopMicRecordMode() throws RemoteException;

    void stopSpeech(String str) throws RemoteException;

    void unregisterCommonListener(ISmartCommonEventListener iSmartCommonEventListener) throws RemoteException;

    void unregisterListener(ISmartEventListener iSmartEventListener) throws RemoteException;

    void updateEffectFiles(int i) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements ISmart {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.smart.ISmart";
        static final int TRANSACTION_enableCarSpeedVolume = 50;
        static final int TRANSACTION_getAlarmFromAzimuthOrIcm = 8;
        static final int TRANSACTION_getAlarmVolume = 29;
        static final int TRANSACTION_getBootSoundEffect = 40;
        static final int TRANSACTION_getBossKeyForCustomer = 14;
        static final int TRANSACTION_getFftLLUEnable = 46;
        static final int TRANSACTION_getKeyBoardTouchPrompt = 10;
        static final int TRANSACTION_getLangLightEffectEnable = 26;
        static final int TRANSACTION_getLangLightEffectNameList = 17;
        static final int TRANSACTION_getLightEffect = 41;
        static final int TRANSACTION_getLluSleepMode = 24;
        static final int TRANSACTION_getLluWakeWaitMode = 22;
        static final int TRANSACTION_getRunnningLluEffectName = 52;
        static final int TRANSACTION_getSayHiEffect = 38;
        static final int TRANSACTION_getSayHiEnable = 36;
        static final int TRANSACTION_getSpeechStatus = 59;
        static final int TRANSACTION_getTouchRotationDirection = 16;
        static final int TRANSACTION_getVolumeDownInReverseMode = 6;
        static final int TRANSACTION_getVolumeDownWithDoorOpen = 4;
        static final int TRANSACTION_getXKeyForCustomer = 12;
        static final int TRANSACTION_isLightDanceAvailable = 54;
        static final int TRANSACTION_isLightDancing = 49;
        static final int TRANSACTION_registerCommonListener = 55;
        static final int TRANSACTION_registerListener = 1;
        static final int TRANSACTION_setAlarmFromAzimuthOrIcm = 7;
        static final int TRANSACTION_setAlarmVolume = 28;
        static final int TRANSACTION_setBootSoundEffect = 39;
        static final int TRANSACTION_setBossKeyForCustomer = 13;
        static final int TRANSACTION_setFftLLUEnable = 45;
        static final int TRANSACTION_setKeyBoardTouchPrompt = 9;
        static final int TRANSACTION_setLangLightEffectEnable = 25;
        static final int TRANSACTION_setLangLightEffectMode = 18;
        static final int TRANSACTION_setLangLightEffectWithMode = 53;
        static final int TRANSACTION_setLangLightMusicEffect = 34;
        static final int TRANSACTION_setLightEffect = 42;
        static final int TRANSACTION_setLightEffectAndMusic = 43;
        static final int TRANSACTION_setLluSleepMode = 23;
        static final int TRANSACTION_setLluWakeWaitMode = 21;
        static final int TRANSACTION_setMusicDelayTimeForDebug = 33;
        static final int TRANSACTION_setMusicSpectrumToLangLight = 27;
        static final int TRANSACTION_setMusicStartTickNumForDebug = 31;
        static final int TRANSACTION_setMusicStopTickNumForDebug = 32;
        static final int TRANSACTION_setMusicTableForDebug = 30;
        static final int TRANSACTION_setPause = 19;
        static final int TRANSACTION_setSayHiEffect = 37;
        static final int TRANSACTION_setSayHiEnable = 35;
        static final int TRANSACTION_setSpeedVolumeMode = 51;
        static final int TRANSACTION_setTouchRotationDirection = 15;
        static final int TRANSACTION_setVolumeDownInReverseMode = 5;
        static final int TRANSACTION_setVolumeDownWithDoorOpen = 3;
        static final int TRANSACTION_setXKeyForCustomer = 11;
        static final int TRANSACTION_speakByImportant = 61;
        static final int TRANSACTION_speakByInstant = 63;
        static final int TRANSACTION_speakByNormal = 60;
        static final int TRANSACTION_speakByUrgent = 62;
        static final int TRANSACTION_startAiLluMode = 57;
        static final int TRANSACTION_startLightDancing = 47;
        static final int TRANSACTION_startMicRecordMode = 64;
        static final int TRANSACTION_stopAiLluMode = 58;
        static final int TRANSACTION_stopAllSpeech = 67;
        static final int TRANSACTION_stopLightDancing = 48;
        static final int TRANSACTION_stopLightEffectShow = 44;
        static final int TRANSACTION_stopMicRecordMode = 65;
        static final int TRANSACTION_stopSpeech = 66;
        static final int TRANSACTION_unregisterCommonListener = 56;
        static final int TRANSACTION_unregisterListener = 2;
        static final int TRANSACTION_updateEffectFiles = 20;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISmart asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof ISmart)) {
                return (ISmart) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean _arg1;
            if (code == 1598968902) {
                reply.writeString(DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    ISmartEventListener _arg0 = ISmartEventListener.Stub.asInterface(data.readStrongBinder());
                    registerListener(_arg0);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    ISmartEventListener _arg02 = ISmartEventListener.Stub.asInterface(data.readStrongBinder());
                    unregisterListener(_arg02);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    _arg1 = data.readInt() != 0;
                    setVolumeDownWithDoorOpen(_arg1);
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    boolean volumeDownWithDoorOpen = getVolumeDownWithDoorOpen();
                    reply.writeNoException();
                    reply.writeInt(volumeDownWithDoorOpen ? 1 : 0);
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    _arg1 = data.readInt() != 0;
                    setVolumeDownInReverseMode(_arg1);
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    boolean volumeDownInReverseMode = getVolumeDownInReverseMode();
                    reply.writeNoException();
                    reply.writeInt(volumeDownInReverseMode ? 1 : 0);
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    _arg1 = data.readInt() != 0;
                    setAlarmFromAzimuthOrIcm(_arg1);
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    boolean alarmFromAzimuthOrIcm = getAlarmFromAzimuthOrIcm();
                    reply.writeNoException();
                    reply.writeInt(alarmFromAzimuthOrIcm ? 1 : 0);
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    _arg1 = data.readInt() != 0;
                    setKeyBoardTouchPrompt(_arg1);
                    reply.writeNoException();
                    return true;
                case 10:
                    data.enforceInterface(DESCRIPTOR);
                    boolean keyBoardTouchPrompt = getKeyBoardTouchPrompt();
                    reply.writeNoException();
                    reply.writeInt(keyBoardTouchPrompt ? 1 : 0);
                    return true;
                case 11:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg03 = data.readInt();
                    setXKeyForCustomer(_arg03);
                    reply.writeNoException();
                    return true;
                case 12:
                    data.enforceInterface(DESCRIPTOR);
                    int _result = getXKeyForCustomer();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case 13:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg04 = data.readInt();
                    setBossKeyForCustomer(_arg04);
                    reply.writeNoException();
                    return true;
                case 14:
                    data.enforceInterface(DESCRIPTOR);
                    int _result2 = getBossKeyForCustomer();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 15:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg05 = data.readInt();
                    setTouchRotationDirection(_arg05);
                    reply.writeNoException();
                    return true;
                case 16:
                    data.enforceInterface(DESCRIPTOR);
                    int _result3 = getTouchRotationDirection();
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case 17:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg06 = data.readInt();
                    List<String> _result4 = getLangLightEffectNameList(_arg06);
                    reply.writeNoException();
                    reply.writeStringList(_result4);
                    return true;
                case 18:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg07 = data.readString();
                    setLangLightEffectMode(_arg07, data.readInt());
                    reply.writeNoException();
                    return true;
                case 19:
                    data.enforceInterface(DESCRIPTOR);
                    _arg1 = data.readInt() != 0;
                    setPause(_arg1);
                    reply.writeNoException();
                    return true;
                case 20:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg08 = data.readInt();
                    updateEffectFiles(_arg08);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_setLluWakeWaitMode /* 21 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg09 = data.readInt();
                    setLluWakeWaitMode(_arg09);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getLluWakeWaitMode /* 22 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _result5 = getLluWakeWaitMode();
                    reply.writeNoException();
                    reply.writeInt(_result5);
                    return true;
                case TRANSACTION_setLluSleepMode /* 23 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg010 = data.readInt();
                    setLluSleepMode(_arg010);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getLluSleepMode /* 24 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _result6 = getLluSleepMode();
                    reply.writeNoException();
                    reply.writeInt(_result6);
                    return true;
                case TRANSACTION_setLangLightEffectEnable /* 25 */:
                    data.enforceInterface(DESCRIPTOR);
                    _arg1 = data.readInt() != 0;
                    setLangLightEffectEnable(_arg1);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getLangLightEffectEnable /* 26 */:
                    data.enforceInterface(DESCRIPTOR);
                    boolean langLightEffectEnable = getLangLightEffectEnable();
                    reply.writeNoException();
                    reply.writeInt(langLightEffectEnable ? 1 : 0);
                    return true;
                case TRANSACTION_setMusicSpectrumToLangLight /* 27 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg011 = data.readInt();
                    setMusicSpectrumToLangLight(_arg011);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_setAlarmVolume /* 28 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg012 = data.readInt();
                    setAlarmVolume(_arg012);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getAlarmVolume /* 29 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _result7 = getAlarmVolume();
                    reply.writeNoException();
                    reply.writeInt(_result7);
                    return true;
                case TRANSACTION_setMusicTableForDebug /* 30 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg013 = data.readInt();
                    setMusicTableForDebug(_arg013);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_setMusicStartTickNumForDebug /* 31 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg014 = data.readInt();
                    setMusicStartTickNumForDebug(_arg014);
                    reply.writeNoException();
                    return true;
                case 32:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg015 = data.readInt();
                    setMusicStopTickNumForDebug(_arg015);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_setMusicDelayTimeForDebug /* 33 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg016 = data.readInt();
                    setMusicDelayTimeForDebug(_arg016);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_setLangLightMusicEffect /* 34 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg017 = data.readString();
                    setLangLightMusicEffect(_arg017);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_setSayHiEnable /* 35 */:
                    data.enforceInterface(DESCRIPTOR);
                    _arg1 = data.readInt() != 0;
                    setSayHiEnable(_arg1);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getSayHiEnable /* 36 */:
                    data.enforceInterface(DESCRIPTOR);
                    boolean sayHiEnable = getSayHiEnable();
                    reply.writeNoException();
                    reply.writeInt(sayHiEnable ? 1 : 0);
                    return true;
                case TRANSACTION_setSayHiEffect /* 37 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg018 = data.readInt();
                    setSayHiEffect(_arg018);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getSayHiEffect /* 38 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _result8 = getSayHiEffect();
                    reply.writeNoException();
                    reply.writeInt(_result8);
                    return true;
                case TRANSACTION_setBootSoundEffect /* 39 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg019 = data.readInt();
                    setBootSoundEffect(_arg019);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getBootSoundEffect /* 40 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _result9 = getBootSoundEffect();
                    reply.writeNoException();
                    reply.writeInt(_result9);
                    return true;
                case TRANSACTION_getLightEffect /* 41 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg020 = data.readInt();
                    int _result10 = getLightEffect(_arg020);
                    reply.writeNoException();
                    reply.writeInt(_result10);
                    return true;
                case TRANSACTION_setLightEffect /* 42 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg021 = data.readInt();
                    setLightEffect(_arg021, data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_setLightEffectAndMusic /* 43 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg022 = data.readInt();
                    int _arg12 = data.readInt();
                    int _arg2 = data.readInt();
                    setLightEffectAndMusic(_arg022, _arg12, _arg2);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_stopLightEffectShow /* 44 */:
                    data.enforceInterface(DESCRIPTOR);
                    stopLightEffectShow();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_setFftLLUEnable /* 45 */:
                    data.enforceInterface(DESCRIPTOR);
                    _arg1 = data.readInt() != 0;
                    setFftLLUEnable(_arg1);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getFftLLUEnable /* 46 */:
                    data.enforceInterface(DESCRIPTOR);
                    boolean fftLLUEnable = getFftLLUEnable();
                    reply.writeNoException();
                    reply.writeInt(fftLLUEnable ? 1 : 0);
                    return true;
                case TRANSACTION_startLightDancing /* 47 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg023 = data.readString();
                    int _result11 = startLightDancing(_arg023, data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result11);
                    return true;
                case TRANSACTION_stopLightDancing /* 48 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _result12 = stopLightDancing();
                    reply.writeNoException();
                    reply.writeInt(_result12);
                    return true;
                case TRANSACTION_isLightDancing /* 49 */:
                    data.enforceInterface(DESCRIPTOR);
                    boolean isLightDancing = isLightDancing();
                    reply.writeNoException();
                    reply.writeInt(isLightDancing ? 1 : 0);
                    return true;
                case TRANSACTION_enableCarSpeedVolume /* 50 */:
                    data.enforceInterface(DESCRIPTOR);
                    _arg1 = data.readInt() != 0;
                    enableCarSpeedVolume(_arg1);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_setSpeedVolumeMode /* 51 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg024 = data.readInt();
                    setSpeedVolumeMode(_arg024);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getRunnningLluEffectName /* 52 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _result13 = getRunnningLluEffectName();
                    reply.writeNoException();
                    reply.writeString(_result13);
                    return true;
                case TRANSACTION_setLangLightEffectWithMode /* 53 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg025 = data.readString();
                    int _arg13 = data.readInt();
                    int _arg22 = data.readInt();
                    setLangLightEffectWithMode(_arg025, _arg13, _arg22);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_isLightDanceAvailable /* 54 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _result14 = isLightDanceAvailable();
                    reply.writeNoException();
                    reply.writeInt(_result14);
                    return true;
                case TRANSACTION_registerCommonListener /* 55 */:
                    data.enforceInterface(DESCRIPTOR);
                    ISmartCommonEventListener _arg026 = ISmartCommonEventListener.Stub.asInterface(data.readStrongBinder());
                    registerCommonListener(_arg026);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_unregisterCommonListener /* 56 */:
                    data.enforceInterface(DESCRIPTOR);
                    ISmartCommonEventListener _arg027 = ISmartCommonEventListener.Stub.asInterface(data.readStrongBinder());
                    unregisterCommonListener(_arg027);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_startAiLluMode /* 57 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg028 = data.readInt();
                    startAiLluMode(_arg028);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_stopAiLluMode /* 58 */:
                    data.enforceInterface(DESCRIPTOR);
                    stopAiLluMode();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getSpeechStatus /* 59 */:
                    data.enforceInterface(DESCRIPTOR);
                    boolean speechStatus = getSpeechStatus();
                    reply.writeNoException();
                    reply.writeInt(speechStatus ? 1 : 0);
                    return true;
                case TRANSACTION_speakByNormal /* 60 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg029 = data.readString();
                    String _result15 = speakByNormal(_arg029);
                    reply.writeNoException();
                    reply.writeString(_result15);
                    return true;
                case TRANSACTION_speakByImportant /* 61 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg030 = data.readString();
                    String _result16 = speakByImportant(_arg030);
                    reply.writeNoException();
                    reply.writeString(_result16);
                    return true;
                case TRANSACTION_speakByUrgent /* 62 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg031 = data.readString();
                    String _result17 = speakByUrgent(_arg031);
                    reply.writeNoException();
                    reply.writeString(_result17);
                    return true;
                case TRANSACTION_speakByInstant /* 63 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg032 = data.readString();
                    _arg1 = data.readInt() != 0;
                    String _result18 = speakByInstant(_arg032, _arg1);
                    reply.writeNoException();
                    reply.writeString(_result18);
                    return true;
                case 64:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg033 = data.readInt();
                    int _result19 = startMicRecordMode(_arg033);
                    reply.writeNoException();
                    reply.writeInt(_result19);
                    return true;
                case TRANSACTION_stopMicRecordMode /* 65 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _result20 = stopMicRecordMode();
                    reply.writeNoException();
                    reply.writeInt(_result20);
                    return true;
                case TRANSACTION_stopSpeech /* 66 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg034 = data.readString();
                    stopSpeech(_arg034);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_stopAllSpeech /* 67 */:
                    data.enforceInterface(DESCRIPTOR);
                    stopAllSpeech();
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* loaded from: classes.dex */
        private static class Proxy implements ISmart {
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

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void registerListener(ISmartEventListener listener) throws RemoteException {
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

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void unregisterListener(ISmartEventListener listener) throws RemoteException {
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

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void setVolumeDownWithDoorOpen(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enable ? 1 : 0);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public boolean getVolumeDownWithDoorOpen() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void setVolumeDownInReverseMode(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enable ? 1 : 0);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public boolean getVolumeDownInReverseMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void setAlarmFromAzimuthOrIcm(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enable ? 1 : 0);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public boolean getAlarmFromAzimuthOrIcm() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void setKeyBoardTouchPrompt(boolean enable) throws RemoteException {
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

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public boolean getKeyBoardTouchPrompt() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void setXKeyForCustomer(int keyFunc) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(keyFunc);
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public int getXKeyForCustomer() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(12, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void setBossKeyForCustomer(int keyFunc) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(keyFunc);
                    this.mRemote.transact(13, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public int getBossKeyForCustomer() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(14, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void setTouchRotationDirection(int rotationDirection) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(rotationDirection);
                    this.mRemote.transact(15, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public int getTouchRotationDirection() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(16, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public List<String> getLangLightEffectNameList(int effectType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(effectType);
                    this.mRemote.transact(17, _data, _reply, 0);
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void setLangLightEffectMode(String effectName, int loop) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(effectName);
                    _data.writeInt(loop);
                    this.mRemote.transact(18, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void setPause(boolean pause) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(pause ? 1 : 0);
                    this.mRemote.transact(19, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void updateEffectFiles(int effectType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(effectType);
                    this.mRemote.transact(20, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void setLluWakeWaitMode(int type) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(type);
                    this.mRemote.transact(Stub.TRANSACTION_setLluWakeWaitMode, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public int getLluWakeWaitMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getLluWakeWaitMode, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void setLluSleepMode(int type) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(type);
                    this.mRemote.transact(Stub.TRANSACTION_setLluSleepMode, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public int getLluSleepMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getLluSleepMode, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void setLangLightEffectEnable(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enable ? 1 : 0);
                    this.mRemote.transact(Stub.TRANSACTION_setLangLightEffectEnable, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public boolean getLangLightEffectEnable() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getLangLightEffectEnable, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void setMusicSpectrumToLangLight(int tickNum) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(tickNum);
                    this.mRemote.transact(Stub.TRANSACTION_setMusicSpectrumToLangLight, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void setAlarmVolume(int type) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(type);
                    this.mRemote.transact(Stub.TRANSACTION_setAlarmVolume, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public int getAlarmVolume() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAlarmVolume, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void setMusicTableForDebug(int musicTable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(musicTable);
                    this.mRemote.transact(Stub.TRANSACTION_setMusicTableForDebug, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void setMusicStartTickNumForDebug(int tickNum) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(tickNum);
                    this.mRemote.transact(Stub.TRANSACTION_setMusicStartTickNumForDebug, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void setMusicStopTickNumForDebug(int tickNum) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(tickNum);
                    this.mRemote.transact(32, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void setMusicDelayTimeForDebug(int delayTime) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(delayTime);
                    this.mRemote.transact(Stub.TRANSACTION_setMusicDelayTimeForDebug, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void setLangLightMusicEffect(String effectName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(effectName);
                    this.mRemote.transact(Stub.TRANSACTION_setLangLightMusicEffect, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void setSayHiEnable(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enable ? 1 : 0);
                    this.mRemote.transact(Stub.TRANSACTION_setSayHiEnable, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public boolean getSayHiEnable() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getSayHiEnable, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void setSayHiEffect(int type) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(type);
                    this.mRemote.transact(Stub.TRANSACTION_setSayHiEffect, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public int getSayHiEffect() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getSayHiEffect, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void setBootSoundEffect(int type) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(type);
                    this.mRemote.transact(Stub.TRANSACTION_setBootSoundEffect, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public int getBootSoundEffect() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getBootSoundEffect, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public int getLightEffect(int effectName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(effectName);
                    this.mRemote.transact(Stub.TRANSACTION_getLightEffect, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void setLightEffect(int effectName, int effectMode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(effectName);
                    _data.writeInt(effectMode);
                    this.mRemote.transact(Stub.TRANSACTION_setLightEffect, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void setLightEffectAndMusic(int messageID, int effectName, int effectMusic) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(messageID);
                    _data.writeInt(effectName);
                    _data.writeInt(effectMusic);
                    this.mRemote.transact(Stub.TRANSACTION_setLightEffectAndMusic, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void stopLightEffectShow() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_stopLightEffectShow, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void setFftLLUEnable(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enable ? 1 : 0);
                    this.mRemote.transact(Stub.TRANSACTION_setFftLLUEnable, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public boolean getFftLLUEnable() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getFftLLUEnable, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public int startLightDancing(String file_name, int loop) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(file_name);
                    _data.writeInt(loop);
                    this.mRemote.transact(Stub.TRANSACTION_startLightDancing, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public int stopLightDancing() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_stopLightDancing, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public boolean isLightDancing() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isLightDancing, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void enableCarSpeedVolume(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enable ? 1 : 0);
                    this.mRemote.transact(Stub.TRANSACTION_enableCarSpeedVolume, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void setSpeedVolumeMode(int type) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(type);
                    this.mRemote.transact(Stub.TRANSACTION_setSpeedVolumeMode, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public String getRunnningLluEffectName() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getRunnningLluEffectName, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void setLangLightEffectWithMode(String effectName, int mode, int loop) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(effectName);
                    _data.writeInt(mode);
                    _data.writeInt(loop);
                    this.mRemote.transact(Stub.TRANSACTION_setLangLightEffectWithMode, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public int isLightDanceAvailable() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isLightDanceAvailable, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void registerCommonListener(ISmartCommonEventListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(Stub.TRANSACTION_registerCommonListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void unregisterCommonListener(ISmartCommonEventListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(Stub.TRANSACTION_unregisterCommonListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void startAiLluMode(int type) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(type);
                    this.mRemote.transact(Stub.TRANSACTION_startAiLluMode, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void stopAiLluMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_stopAiLluMode, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public boolean getSpeechStatus() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getSpeechStatus, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public String speakByNormal(String text) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(text);
                    this.mRemote.transact(Stub.TRANSACTION_speakByNormal, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public String speakByImportant(String text) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(text);
                    this.mRemote.transact(Stub.TRANSACTION_speakByImportant, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public String speakByUrgent(String text) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(text);
                    this.mRemote.transact(Stub.TRANSACTION_speakByUrgent, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public String speakByInstant(String text, boolean isShutUp) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(text);
                    _data.writeInt(isShutUp ? 1 : 0);
                    this.mRemote.transact(Stub.TRANSACTION_speakByInstant, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public int startMicRecordMode(int status) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(status);
                    this.mRemote.transact(64, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public int stopMicRecordMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_stopMicRecordMode, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void stopSpeech(String ttsId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(ttsId);
                    this.mRemote.transact(Stub.TRANSACTION_stopSpeech, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.smart.ISmart
            public void stopAllSpeech() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_stopAllSpeech, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}
