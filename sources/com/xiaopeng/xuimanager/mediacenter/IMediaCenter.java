package com.xiaopeng.xuimanager.mediacenter;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.xuimanager.mediacenter.IAudioCaptureListener;
import com.xiaopeng.xuimanager.mediacenter.IBTStatusListener;
import com.xiaopeng.xuimanager.mediacenter.ILyricUpdateListener;
import com.xiaopeng.xuimanager.mediacenter.IMediaCenterEventListener;
import com.xiaopeng.xuimanager.mediacenter.IModeChangedListener;
import com.xiaopeng.xuimanager.mediacenter.IPlaybackControlListener;
import com.xiaopeng.xuimanager.mediacenter.IPlaybackInfoListener;
import com.xiaopeng.xuimanager.mediacenter.IVisualizerViewEnableListener;
import com.xiaopeng.xuimanager.mediacenter.bluetooth.AvrcpMeteData;
import com.xiaopeng.xuimanager.mediacenter.bluetooth.IAvrcpEventListener;
import com.xiaopeng.xuimanager.mediacenter.lyric.ILyricInfoListener;
import com.xiaopeng.xuimanager.mediacenter.lyric.LyricInfo;
import com.xiaopeng.xuimanager.mediacenter.visualizer.ISDVisualizerDataListener;
/* loaded from: classes.dex */
public interface IMediaCenter extends IInterface {
    void avrcpNext() throws RemoteException;

    void avrcpPause() throws RemoteException;

    void avrcpPlay() throws RemoteException;

    void avrcpPrevious() throws RemoteException;

    void executeCmd(String str, String str2) throws RemoteException;

    void favorSong(Bundle bundle) throws RemoteException;

    AvrcpMeteData getAvrcpMeteData() throws RemoteException;

    int getAvrcpPlayStatus() throws RemoteException;

    long[] getAvrcpPosition() throws RemoteException;

    int getBtStatus() throws RemoteException;

    LyricInfo getCurrentLyricInfo(int i) throws RemoteException;

    MediaInfo getCurrentMediaInfo(int i) throws RemoteException;

    int getCurrentMode() throws RemoteException;

    int getCurrentPlayStatus(int i) throws RemoteException;

    long[] getCurrentPosition(int i) throws RemoteException;

    void notifyLyricInfoUpdated(LyricInfo lyricInfo) throws RemoteException;

    void notifyLyricUpdate(String str) throws RemoteException;

    void pauseBtMedia() throws RemoteException;

    void playBtMedia() throws RemoteException;

    int playbackControl(int i, int i2, int i3) throws RemoteException;

    void registerAvrcpEventListener(IAvrcpEventListener iAvrcpEventListener) throws RemoteException;

    void registerBtStatusListener(IBTStatusListener iBTStatusListener) throws RemoteException;

    void registerListener(IMediaCenterEventListener iMediaCenterEventListener) throws RemoteException;

    void registerLyricInfoListener(ILyricInfoListener iLyricInfoListener) throws RemoteException;

    void registerLyricUpdateListener(ILyricUpdateListener iLyricUpdateListener) throws RemoteException;

    void registerModeChangedListener(IModeChangedListener iModeChangedListener) throws RemoteException;

    void registerPlaybackInfoListener(IPlaybackInfoListener iPlaybackInfoListener) throws RemoteException;

    void registerVisualizerListener(IAudioCaptureListener iAudioCaptureListener) throws RemoteException;

    void registerVisualizerListenerWithDisplayId(int i, ISDVisualizerDataListener iSDVisualizerDataListener) throws RemoteException;

    void registerVisualizerListenerWithPackage(String str, ISDVisualizerDataListener iSDVisualizerDataListener) throws RemoteException;

    void registerVisualizerViewEnableListener(IVisualizerViewEnableListener iVisualizerViewEnableListener) throws RemoteException;

    void requestMediaButton(boolean z, Bundle bundle) throws RemoteException;

    void setBtVolume(float f) throws RemoteException;

    int setFavorite(boolean z, String str) throws RemoteException;

    void setSDPosition(int i, String str) throws RemoteException;

    void setVisualizerViewEnable(boolean z) throws RemoteException;

    int switchSource(int i) throws RemoteException;

    void unRegisterAvrcpEventListener(IAvrcpEventListener iAvrcpEventListener) throws RemoteException;

    void unRegisterBtStatusListener(IBTStatusListener iBTStatusListener) throws RemoteException;

    void unRegisterLyricUpdateListener(ILyricUpdateListener iLyricUpdateListener) throws RemoteException;

    void unRegisterModeChangedListener(IModeChangedListener iModeChangedListener) throws RemoteException;

    void unRegisterPlaybackInfoListener(IPlaybackInfoListener iPlaybackInfoListener) throws RemoteException;

    void unRegisterVisualizerListener(IAudioCaptureListener iAudioCaptureListener) throws RemoteException;

    void unRegisterVisualizerListenerWithDisplayId(int i, ISDVisualizerDataListener iSDVisualizerDataListener) throws RemoteException;

    void unRegisterVisualizerListenerWithPackage(String str, ISDVisualizerDataListener iSDVisualizerDataListener) throws RemoteException;

    void unRegisterVisualizerViewEnableListener(IVisualizerViewEnableListener iVisualizerViewEnableListener) throws RemoteException;

    void unregisterListener(IMediaCenterEventListener iMediaCenterEventListener) throws RemoteException;

    void unregisterLyricInfoListener(ILyricInfoListener iLyricInfoListener) throws RemoteException;

    void vendorMediaInfoNotify(MediaInfo mediaInfo) throws RemoteException;

    void vendorRegister() throws RemoteException;

    void vendorSetControlListener(String str, IPlaybackControlListener iPlaybackControlListener) throws RemoteException;

    void vendorStartAudioSession(int i, int i2, String str) throws RemoteException;

    void vendorStopAudioSession(int i, String str) throws RemoteException;

    void vendorUnRegister() throws RemoteException;

    void vendorUnSetControlListener(String str, IPlaybackControlListener iPlaybackControlListener) throws RemoteException;

    void vendorUpdatePlaybackStatus(int i) throws RemoteException;

    void vendorUpdatePosition(long j, long j2) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IMediaCenter {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.mediacenter.IMediaCenter";
        static final int TRANSACTION_avrcpNext = 39;
        static final int TRANSACTION_avrcpPause = 38;
        static final int TRANSACTION_avrcpPlay = 37;
        static final int TRANSACTION_avrcpPrevious = 40;
        static final int TRANSACTION_executeCmd = 46;
        static final int TRANSACTION_favorSong = 51;
        static final int TRANSACTION_getAvrcpMeteData = 41;
        static final int TRANSACTION_getAvrcpPlayStatus = 43;
        static final int TRANSACTION_getAvrcpPosition = 42;
        static final int TRANSACTION_getBtStatus = 34;
        static final int TRANSACTION_getCurrentLyricInfo = 53;
        static final int TRANSACTION_getCurrentMediaInfo = 19;
        static final int TRANSACTION_getCurrentMode = 29;
        static final int TRANSACTION_getCurrentPlayStatus = 18;
        static final int TRANSACTION_getCurrentPosition = 20;
        static final int TRANSACTION_notifyLyricInfoUpdated = 48;
        static final int TRANSACTION_notifyLyricUpdate = 24;
        static final int TRANSACTION_pauseBtMedia = 33;
        static final int TRANSACTION_playBtMedia = 32;
        static final int TRANSACTION_playbackControl = 16;
        static final int TRANSACTION_registerAvrcpEventListener = 44;
        static final int TRANSACTION_registerBtStatusListener = 30;
        static final int TRANSACTION_registerListener = 1;
        static final int TRANSACTION_registerLyricInfoListener = 49;
        static final int TRANSACTION_registerLyricUpdateListener = 25;
        static final int TRANSACTION_registerModeChangedListener = 27;
        static final int TRANSACTION_registerPlaybackInfoListener = 14;
        static final int TRANSACTION_registerVisualizerListener = 12;
        static final int TRANSACTION_registerVisualizerListenerWithDisplayId = 54;
        static final int TRANSACTION_registerVisualizerListenerWithPackage = 56;
        static final int TRANSACTION_registerVisualizerViewEnableListener = 22;
        static final int TRANSACTION_requestMediaButton = 52;
        static final int TRANSACTION_setBtVolume = 36;
        static final int TRANSACTION_setFavorite = 35;
        static final int TRANSACTION_setSDPosition = 47;
        static final int TRANSACTION_setVisualizerViewEnable = 21;
        static final int TRANSACTION_switchSource = 17;
        static final int TRANSACTION_unRegisterAvrcpEventListener = 45;
        static final int TRANSACTION_unRegisterBtStatusListener = 31;
        static final int TRANSACTION_unRegisterLyricUpdateListener = 26;
        static final int TRANSACTION_unRegisterModeChangedListener = 28;
        static final int TRANSACTION_unRegisterPlaybackInfoListener = 15;
        static final int TRANSACTION_unRegisterVisualizerListener = 13;
        static final int TRANSACTION_unRegisterVisualizerListenerWithDisplayId = 55;
        static final int TRANSACTION_unRegisterVisualizerListenerWithPackage = 57;
        static final int TRANSACTION_unRegisterVisualizerViewEnableListener = 23;
        static final int TRANSACTION_unregisterListener = 2;
        static final int TRANSACTION_unregisterLyricInfoListener = 50;
        static final int TRANSACTION_vendorMediaInfoNotify = 7;
        static final int TRANSACTION_vendorRegister = 3;
        static final int TRANSACTION_vendorSetControlListener = 8;
        static final int TRANSACTION_vendorStartAudioSession = 10;
        static final int TRANSACTION_vendorStopAudioSession = 11;
        static final int TRANSACTION_vendorUnRegister = 4;
        static final int TRANSACTION_vendorUnSetControlListener = 9;
        static final int TRANSACTION_vendorUpdatePlaybackStatus = 5;
        static final int TRANSACTION_vendorUpdatePosition = 6;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMediaCenter asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IMediaCenter)) {
                return (IMediaCenter) iin;
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
                    registerListener(IMediaCenterEventListener.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    unregisterListener(IMediaCenterEventListener.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    vendorRegister();
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    vendorUnRegister();
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    vendorUpdatePlaybackStatus(data.readInt());
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    long _arg02 = data.readLong();
                    long _arg1 = data.readLong();
                    vendorUpdatePosition(_arg02, _arg1);
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    vendorMediaInfoNotify(data.readInt() != 0 ? MediaInfo.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg03 = data.readString();
                    IPlaybackControlListener _arg12 = IPlaybackControlListener.Stub.asInterface(data.readStrongBinder());
                    vendorSetControlListener(_arg03, _arg12);
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg04 = data.readString();
                    IPlaybackControlListener _arg13 = IPlaybackControlListener.Stub.asInterface(data.readStrongBinder());
                    vendorUnSetControlListener(_arg04, _arg13);
                    reply.writeNoException();
                    return true;
                case 10:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg05 = data.readInt();
                    int _arg14 = data.readInt();
                    String _arg2 = data.readString();
                    vendorStartAudioSession(_arg05, _arg14, _arg2);
                    reply.writeNoException();
                    return true;
                case 11:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg06 = data.readInt();
                    String _arg15 = data.readString();
                    vendorStopAudioSession(_arg06, _arg15);
                    reply.writeNoException();
                    return true;
                case 12:
                    data.enforceInterface(DESCRIPTOR);
                    registerVisualizerListener(IAudioCaptureListener.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 13:
                    data.enforceInterface(DESCRIPTOR);
                    unRegisterVisualizerListener(IAudioCaptureListener.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 14:
                    data.enforceInterface(DESCRIPTOR);
                    registerPlaybackInfoListener(IPlaybackInfoListener.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 15:
                    data.enforceInterface(DESCRIPTOR);
                    unRegisterPlaybackInfoListener(IPlaybackInfoListener.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 16:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg07 = data.readInt();
                    int _arg16 = data.readInt();
                    int _arg22 = data.readInt();
                    int _result = playbackControl(_arg07, _arg16, _arg22);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case 17:
                    data.enforceInterface(DESCRIPTOR);
                    int _result2 = switchSource(data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 18:
                    data.enforceInterface(DESCRIPTOR);
                    int _result3 = getCurrentPlayStatus(data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case 19:
                    data.enforceInterface(DESCRIPTOR);
                    MediaInfo _result4 = getCurrentMediaInfo(data.readInt());
                    reply.writeNoException();
                    if (_result4 != null) {
                        reply.writeInt(1);
                        _result4.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 20:
                    data.enforceInterface(DESCRIPTOR);
                    long[] _result5 = getCurrentPosition(data.readInt());
                    reply.writeNoException();
                    reply.writeLongArray(_result5);
                    return true;
                case TRANSACTION_setVisualizerViewEnable /* 21 */:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt() != 0;
                    setVisualizerViewEnable(_arg0);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_registerVisualizerViewEnableListener /* 22 */:
                    data.enforceInterface(DESCRIPTOR);
                    registerVisualizerViewEnableListener(IVisualizerViewEnableListener.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case TRANSACTION_unRegisterVisualizerViewEnableListener /* 23 */:
                    data.enforceInterface(DESCRIPTOR);
                    unRegisterVisualizerViewEnableListener(IVisualizerViewEnableListener.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case TRANSACTION_notifyLyricUpdate /* 24 */:
                    data.enforceInterface(DESCRIPTOR);
                    notifyLyricUpdate(data.readString());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_registerLyricUpdateListener /* 25 */:
                    data.enforceInterface(DESCRIPTOR);
                    registerLyricUpdateListener(ILyricUpdateListener.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case TRANSACTION_unRegisterLyricUpdateListener /* 26 */:
                    data.enforceInterface(DESCRIPTOR);
                    unRegisterLyricUpdateListener(ILyricUpdateListener.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case TRANSACTION_registerModeChangedListener /* 27 */:
                    data.enforceInterface(DESCRIPTOR);
                    registerModeChangedListener(IModeChangedListener.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case TRANSACTION_unRegisterModeChangedListener /* 28 */:
                    data.enforceInterface(DESCRIPTOR);
                    unRegisterModeChangedListener(IModeChangedListener.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getCurrentMode /* 29 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _result6 = getCurrentMode();
                    reply.writeNoException();
                    reply.writeInt(_result6);
                    return true;
                case TRANSACTION_registerBtStatusListener /* 30 */:
                    data.enforceInterface(DESCRIPTOR);
                    registerBtStatusListener(IBTStatusListener.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case TRANSACTION_unRegisterBtStatusListener /* 31 */:
                    data.enforceInterface(DESCRIPTOR);
                    unRegisterBtStatusListener(IBTStatusListener.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 32:
                    data.enforceInterface(DESCRIPTOR);
                    playBtMedia();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_pauseBtMedia /* 33 */:
                    data.enforceInterface(DESCRIPTOR);
                    pauseBtMedia();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getBtStatus /* 34 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _result7 = getBtStatus();
                    reply.writeNoException();
                    reply.writeInt(_result7);
                    return true;
                case TRANSACTION_setFavorite /* 35 */:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt() != 0;
                    boolean _arg08 = _arg0;
                    String _arg17 = data.readString();
                    int _result8 = setFavorite(_arg08, _arg17);
                    reply.writeNoException();
                    reply.writeInt(_result8);
                    return true;
                case TRANSACTION_setBtVolume /* 36 */:
                    data.enforceInterface(DESCRIPTOR);
                    setBtVolume(data.readFloat());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_avrcpPlay /* 37 */:
                    data.enforceInterface(DESCRIPTOR);
                    avrcpPlay();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_avrcpPause /* 38 */:
                    data.enforceInterface(DESCRIPTOR);
                    avrcpPause();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_avrcpNext /* 39 */:
                    data.enforceInterface(DESCRIPTOR);
                    avrcpNext();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_avrcpPrevious /* 40 */:
                    data.enforceInterface(DESCRIPTOR);
                    avrcpPrevious();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getAvrcpMeteData /* 41 */:
                    data.enforceInterface(DESCRIPTOR);
                    AvrcpMeteData _result9 = getAvrcpMeteData();
                    reply.writeNoException();
                    if (_result9 != null) {
                        reply.writeInt(1);
                        _result9.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case TRANSACTION_getAvrcpPosition /* 42 */:
                    data.enforceInterface(DESCRIPTOR);
                    long[] _result10 = getAvrcpPosition();
                    reply.writeNoException();
                    reply.writeLongArray(_result10);
                    return true;
                case TRANSACTION_getAvrcpPlayStatus /* 43 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _result11 = getAvrcpPlayStatus();
                    reply.writeNoException();
                    reply.writeInt(_result11);
                    return true;
                case TRANSACTION_registerAvrcpEventListener /* 44 */:
                    data.enforceInterface(DESCRIPTOR);
                    registerAvrcpEventListener(IAvrcpEventListener.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case TRANSACTION_unRegisterAvrcpEventListener /* 45 */:
                    data.enforceInterface(DESCRIPTOR);
                    unRegisterAvrcpEventListener(IAvrcpEventListener.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case TRANSACTION_executeCmd /* 46 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg09 = data.readString();
                    String _arg18 = data.readString();
                    executeCmd(_arg09, _arg18);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_setSDPosition /* 47 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg010 = data.readInt();
                    String _arg19 = data.readString();
                    setSDPosition(_arg010, _arg19);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_notifyLyricInfoUpdated /* 48 */:
                    data.enforceInterface(DESCRIPTOR);
                    LyricInfo _arg011 = data.readInt() != 0 ? LyricInfo.CREATOR.createFromParcel(data) : null;
                    notifyLyricInfoUpdated(_arg011);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_registerLyricInfoListener /* 49 */:
                    data.enforceInterface(DESCRIPTOR);
                    registerLyricInfoListener(ILyricInfoListener.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case TRANSACTION_unregisterLyricInfoListener /* 50 */:
                    data.enforceInterface(DESCRIPTOR);
                    unregisterLyricInfoListener(ILyricInfoListener.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case TRANSACTION_favorSong /* 51 */:
                    data.enforceInterface(DESCRIPTOR);
                    Bundle _arg012 = data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null;
                    favorSong(_arg012);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_requestMediaButton /* 52 */:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt() != 0;
                    Bundle _arg110 = data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null;
                    requestMediaButton(_arg0, _arg110);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getCurrentLyricInfo /* 53 */:
                    data.enforceInterface(DESCRIPTOR);
                    LyricInfo _result12 = getCurrentLyricInfo(data.readInt());
                    reply.writeNoException();
                    if (_result12 != null) {
                        reply.writeInt(1);
                        _result12.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case TRANSACTION_registerVisualizerListenerWithDisplayId /* 54 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg013 = data.readInt();
                    ISDVisualizerDataListener _arg111 = ISDVisualizerDataListener.Stub.asInterface(data.readStrongBinder());
                    registerVisualizerListenerWithDisplayId(_arg013, _arg111);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_unRegisterVisualizerListenerWithDisplayId /* 55 */:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg014 = data.readInt();
                    ISDVisualizerDataListener _arg112 = ISDVisualizerDataListener.Stub.asInterface(data.readStrongBinder());
                    unRegisterVisualizerListenerWithDisplayId(_arg014, _arg112);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_registerVisualizerListenerWithPackage /* 56 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg015 = data.readString();
                    ISDVisualizerDataListener _arg113 = ISDVisualizerDataListener.Stub.asInterface(data.readStrongBinder());
                    registerVisualizerListenerWithPackage(_arg015, _arg113);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_unRegisterVisualizerListenerWithPackage /* 57 */:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg016 = data.readString();
                    ISDVisualizerDataListener _arg114 = ISDVisualizerDataListener.Stub.asInterface(data.readStrongBinder());
                    unRegisterVisualizerListenerWithPackage(_arg016, _arg114);
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* loaded from: classes.dex */
        private static class Proxy implements IMediaCenter {
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

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void registerListener(IMediaCenterEventListener listener) throws RemoteException {
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

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void unregisterListener(IMediaCenterEventListener listener) throws RemoteException {
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

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void vendorRegister() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void vendorUnRegister() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void vendorUpdatePlaybackStatus(int status) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(status);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void vendorUpdatePosition(long position, long duration) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLong(position);
                    _data.writeLong(duration);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void vendorMediaInfoNotify(MediaInfo info) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (info != null) {
                        _data.writeInt(1);
                        info.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void vendorSetControlListener(String pkgName, IPlaybackControlListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void vendorUnSetControlListener(String pkgName, IPlaybackControlListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void vendorStartAudioSession(int audioSession, int usage, String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(audioSession);
                    _data.writeInt(usage);
                    _data.writeString(pkgName);
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void vendorStopAudioSession(int audioSession, String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(audioSession);
                    _data.writeString(pkgName);
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void registerVisualizerListener(IAudioCaptureListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(12, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void unRegisterVisualizerListener(IAudioCaptureListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(13, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void registerPlaybackInfoListener(IPlaybackInfoListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(14, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void unRegisterPlaybackInfoListener(IPlaybackInfoListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(15, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public int playbackControl(int displayId, int cmd, int param) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(cmd);
                    _data.writeInt(param);
                    this.mRemote.transact(16, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public int switchSource(int source) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(source);
                    this.mRemote.transact(17, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public int getCurrentPlayStatus(int displayId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(displayId);
                    this.mRemote.transact(18, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public MediaInfo getCurrentMediaInfo(int displayId) throws RemoteException {
                MediaInfo _result;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(displayId);
                    this.mRemote.transact(19, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = MediaInfo.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public long[] getCurrentPosition(int displayId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(displayId);
                    this.mRemote.transact(20, _data, _reply, 0);
                    _reply.readException();
                    long[] _result = _reply.createLongArray();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void setVisualizerViewEnable(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enable ? 1 : 0);
                    this.mRemote.transact(Stub.TRANSACTION_setVisualizerViewEnable, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void registerVisualizerViewEnableListener(IVisualizerViewEnableListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(Stub.TRANSACTION_registerVisualizerViewEnableListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void unRegisterVisualizerViewEnableListener(IVisualizerViewEnableListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(Stub.TRANSACTION_unRegisterVisualizerViewEnableListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void notifyLyricUpdate(String lyric) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(lyric);
                    this.mRemote.transact(Stub.TRANSACTION_notifyLyricUpdate, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void registerLyricUpdateListener(ILyricUpdateListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(Stub.TRANSACTION_registerLyricUpdateListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void unRegisterLyricUpdateListener(ILyricUpdateListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(Stub.TRANSACTION_unRegisterLyricUpdateListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void registerModeChangedListener(IModeChangedListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(Stub.TRANSACTION_registerModeChangedListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void unRegisterModeChangedListener(IModeChangedListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(Stub.TRANSACTION_unRegisterModeChangedListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public int getCurrentMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getCurrentMode, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void registerBtStatusListener(IBTStatusListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(Stub.TRANSACTION_registerBtStatusListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void unRegisterBtStatusListener(IBTStatusListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(Stub.TRANSACTION_unRegisterBtStatusListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void playBtMedia() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(32, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void pauseBtMedia() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_pauseBtMedia, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public int getBtStatus() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getBtStatus, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public int setFavorite(boolean favorite, String id) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(favorite ? 1 : 0);
                    _data.writeString(id);
                    this.mRemote.transact(Stub.TRANSACTION_setFavorite, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void setBtVolume(float volume) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeFloat(volume);
                    this.mRemote.transact(Stub.TRANSACTION_setBtVolume, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void avrcpPlay() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_avrcpPlay, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void avrcpPause() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_avrcpPause, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void avrcpNext() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_avrcpNext, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void avrcpPrevious() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_avrcpPrevious, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public AvrcpMeteData getAvrcpMeteData() throws RemoteException {
                AvrcpMeteData _result;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAvrcpMeteData, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = AvrcpMeteData.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public long[] getAvrcpPosition() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAvrcpPosition, _data, _reply, 0);
                    _reply.readException();
                    long[] _result = _reply.createLongArray();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public int getAvrcpPlayStatus() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAvrcpPlayStatus, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void registerAvrcpEventListener(IAvrcpEventListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(Stub.TRANSACTION_registerAvrcpEventListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void unRegisterAvrcpEventListener(IAvrcpEventListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(Stub.TRANSACTION_unRegisterAvrcpEventListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void executeCmd(String cmd, String params) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(cmd);
                    _data.writeString(params);
                    this.mRemote.transact(Stub.TRANSACTION_executeCmd, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void setSDPosition(int displayId, String packageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeString(packageName);
                    this.mRemote.transact(Stub.TRANSACTION_setSDPosition, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void notifyLyricInfoUpdated(LyricInfo info) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (info != null) {
                        _data.writeInt(1);
                        info.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_notifyLyricInfoUpdated, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void registerLyricInfoListener(ILyricInfoListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(Stub.TRANSACTION_registerLyricInfoListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void unregisterLyricInfoListener(ILyricInfoListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(Stub.TRANSACTION_unregisterLyricInfoListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void favorSong(Bundle extras) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (extras != null) {
                        _data.writeInt(1);
                        extras.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_favorSong, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void requestMediaButton(boolean request, Bundle extras) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(request ? 1 : 0);
                    if (extras != null) {
                        _data.writeInt(1);
                        extras.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_requestMediaButton, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public LyricInfo getCurrentLyricInfo(int displayId) throws RemoteException {
                LyricInfo _result;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(displayId);
                    this.mRemote.transact(Stub.TRANSACTION_getCurrentLyricInfo, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = LyricInfo.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void registerVisualizerListenerWithDisplayId(int displayId, ISDVisualizerDataListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(Stub.TRANSACTION_registerVisualizerListenerWithDisplayId, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void unRegisterVisualizerListenerWithDisplayId(int displayId, ISDVisualizerDataListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(Stub.TRANSACTION_unRegisterVisualizerListenerWithDisplayId, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void registerVisualizerListenerWithPackage(String pkgName, ISDVisualizerDataListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(Stub.TRANSACTION_registerVisualizerListenerWithPackage, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenter
            public void unRegisterVisualizerListenerWithPackage(String pkgName, ISDVisualizerDataListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(Stub.TRANSACTION_unRegisterVisualizerListenerWithPackage, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}
