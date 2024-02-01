package com.xiaopeng.xuimanager.mediacenter.visualizer;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public interface ISDVisualizerDataListener extends IInterface {
    void OnFftDataCapture(int i, String str, byte[] bArr, int i2) throws RemoteException;

    void OnRatioData(int i, String str, float f, float f2) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements ISDVisualizerDataListener {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.mediacenter.visualizer.ISDVisualizerDataListener";
        static final int TRANSACTION_OnFftDataCapture = 1;
        static final int TRANSACTION_OnRatioData = 2;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISDVisualizerDataListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof ISDVisualizerDataListener)) {
                return (ISDVisualizerDataListener) iin;
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
                    int _arg0 = data.readInt();
                    String _arg1 = data.readString();
                    byte[] _arg2 = data.createByteArray();
                    int _arg3 = data.readInt();
                    OnFftDataCapture(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg02 = data.readInt();
                    String _arg12 = data.readString();
                    float _arg22 = data.readFloat();
                    float _arg32 = data.readFloat();
                    OnRatioData(_arg02, _arg12, _arg22, _arg32);
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* loaded from: classes.dex */
        private static class Proxy implements ISDVisualizerDataListener {
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

            @Override // com.xiaopeng.xuimanager.mediacenter.visualizer.ISDVisualizerDataListener
            public void OnFftDataCapture(int displayId, String pkgName, byte[] fft, int samplingRate) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeString(pkgName);
                    _data.writeByteArray(fft);
                    _data.writeInt(samplingRate);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.mediacenter.visualizer.ISDVisualizerDataListener
            public void OnRatioData(int displayId, String pkgName, float ratio, float minRatio) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeString(pkgName);
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
