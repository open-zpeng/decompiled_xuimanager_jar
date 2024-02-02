package com.xiaopeng.xuimanager.mediacenter;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public interface IAudioCaptureListener extends IInterface {
    void OnFftDataCapture(byte[] bArr, int i) throws RemoteException;

    void OnRatioData(float f, float f2) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IAudioCaptureListener {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.mediacenter.IAudioCaptureListener";
        static final int TRANSACTION_OnFftDataCapture = 1;
        static final int TRANSACTION_OnRatioData = 2;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAudioCaptureListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IAudioCaptureListener)) {
                return (IAudioCaptureListener) iin;
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
                    byte[] _arg0 = data.createByteArray();
                    int _arg1 = data.readInt();
                    OnFftDataCapture(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    float _arg02 = data.readFloat();
                    float _arg12 = data.readFloat();
                    OnRatioData(_arg02, _arg12);
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* loaded from: classes.dex */
        private static class Proxy implements IAudioCaptureListener {
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

            @Override // com.xiaopeng.xuimanager.mediacenter.IAudioCaptureListener
            public void OnFftDataCapture(byte[] fft, int samplingRate) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeByteArray(fft);
                    _data.writeInt(samplingRate);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.IAudioCaptureListener
            public void OnRatioData(float ratio, float minRatio) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeFloat(ratio);
                    _data.writeFloat(minRatio);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}
