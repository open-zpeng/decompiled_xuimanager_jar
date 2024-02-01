package com.xiaopeng.xuimanager.themeoperation;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
/* loaded from: classes.dex */
public interface IThemeOperationListener extends IInterface {
    void onEffectStatus(String str, String str2, List<AbilityEffect> list) throws RemoteException;

    void onThemeStatus(String str, String str2, List<ThemeOperationData> list) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IThemeOperationListener {
        private static final String DESCRIPTOR = "com.xiaopeng.xuimanager.themeoperation.IThemeOperationListener";
        static final int TRANSACTION_onEffectStatus = 2;
        static final int TRANSACTION_onThemeStatus = 1;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IThemeOperationListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IThemeOperationListener)) {
                return (IThemeOperationListener) iin;
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
                    String _arg1 = data.readString();
                    List<ThemeOperationData> _arg2 = data.createTypedArrayList(ThemeOperationData.CREATOR);
                    onThemeStatus(_arg0, _arg1, _arg2);
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg02 = data.readString();
                    String _arg12 = data.readString();
                    List<AbilityEffect> _arg22 = data.createTypedArrayList(AbilityEffect.CREATOR);
                    onEffectStatus(_arg02, _arg12, _arg22);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* loaded from: classes.dex */
        private static class Proxy implements IThemeOperationListener {
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

            @Override // com.xiaopeng.xuimanager.themeoperation.IThemeOperationListener
            public void onThemeStatus(String event, String extra, List<ThemeOperationData> themeArray) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(event);
                    _data.writeString(extra);
                    _data.writeTypedList(themeArray);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.xiaopeng.xuimanager.themeoperation.IThemeOperationListener
            public void onEffectStatus(String event, String extra, List<AbilityEffect> effectArray) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(event);
                    _data.writeString(extra);
                    _data.writeTypedList(effectArray);
                    this.mRemote.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }
    }
}
