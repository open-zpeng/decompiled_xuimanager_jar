package com.xiaopeng.xuimanager.pipebus;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/* loaded from: classes.dex */
public class ParcelableContainer implements Parcelable {
    private static final int FLAG_BYTE_ARRAY = -1163133183;
    private static final int FLAG_INT_ARRAY = -1163133182;
    private static final int FLAG_PARCEL = -1414791420;
    private static final int FLAG_PARCELABLE_ARRAY = -1414791419;
    private static final int FLAG_STRING_ARRAY = -1163133181;
    private byte[] mBytes;
    private int[] mInts;
    private String[] mStrings;
    private Parcel parcel;
    private Parcelable[] parcelableArray;
    private static final String TAG = ParcelableContainer.class.getSimpleName();
    public static final Parcelable.Creator<ParcelableContainer> CREATOR = new Parcelable.Creator<ParcelableContainer>() { // from class: com.xiaopeng.xuimanager.pipebus.ParcelableContainer.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableContainer createFromParcel(Parcel in) {
            return new ParcelableContainer(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableContainer[] newArray(int size) {
            return new ParcelableContainer[size];
        }
    };

    public ParcelableContainer() {
    }

    public void setBytes(byte[] bytes) {
        this.mBytes = bytes;
    }

    public byte[] getBytes() {
        return this.mBytes;
    }

    public void setIntArray(int[] array) {
        this.mInts = array;
    }

    public int[] getIntArray() {
        return this.mInts;
    }

    public void setStringArray(String[] array) {
        this.mStrings = array;
    }

    public String[] getStringArray() {
        return this.mStrings;
    }

    public void setParcel(Parcel p) {
        this.parcel = p;
    }

    public Parcel getParcel() {
        return this.parcel;
    }

    public void setParcelableArray(Parcelable[] array) {
        this.parcelableArray = array;
    }

    public Parcelable[] getParcelableArray() {
        return this.parcelableArray;
    }

    public void reset() {
        this.mBytes = null;
        this.mInts = null;
        this.mStrings = null;
        this.parcel = null;
        this.parcelableArray = null;
    }

    protected ParcelableContainer(Parcel in) {
        readFromParcel(in);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        if (this.mBytes != null) {
            dest.writeInt(FLAG_BYTE_ARRAY);
            dest.writeInt(this.mBytes.length);
            dest.writeByteArray(this.mBytes);
        }
        if (this.mInts != null) {
            dest.writeInt(FLAG_INT_ARRAY);
            dest.writeInt(this.mInts.length);
            dest.writeIntArray(this.mInts);
        }
        if (this.mStrings != null) {
            dest.writeInt(FLAG_STRING_ARRAY);
            dest.writeInt(this.mStrings.length);
            dest.writeStringArray(this.mStrings);
        }
        if (this.parcel != null) {
            dest.writeInt(FLAG_PARCEL);
            byte[] data = this.parcel.marshall();
            dest.writeInt(data.length);
            dest.writeByteArray(data);
        }
        if (this.parcelableArray != null) {
            dest.writeInt(FLAG_PARCELABLE_ARRAY);
            int length = this.parcelableArray.length;
            dest.writeInt(length);
            if (length > 0) {
                for (int i = 0; i < length; i++) {
                    dest.writeString(this.parcelableArray[i].getClass().getName());
                    dest.writeParcelable(this.parcelableArray[i], 0);
                }
            }
        }
    }

    public void readFromParcel(Parcel in) {
        if (in == null) {
            return;
        }
        int curPos = in.dataPosition();
        int size = in.dataSize();
        while (curPos < size) {
            int flag = in.readInt();
            boolean exit = false;
            switch (flag) {
                case FLAG_PARCEL /* -1414791420 */:
                    int len = in.readInt();
                    byte[] rawData = new byte[len];
                    in.readByteArray(rawData);
                    this.parcel = Parcel.obtain();
                    this.parcel.unmarshall(rawData, 0, rawData.length);
                    break;
                case FLAG_PARCELABLE_ARRAY /* -1414791419 */:
                    int length = in.readInt();
                    if (length < 1) {
                        String str = TAG;
                        Log.w(str, "read parcelable array but invalid length:" + length);
                        break;
                    } else {
                        this.parcelableArray = new Parcelable[length];
                        ClassLoader loader = null;
                        String lastPath = null;
                        for (int i = 0; i < length; i++) {
                            try {
                                String classPath = in.readString();
                                if (!classPath.equals(lastPath)) {
                                    lastPath = classPath;
                                    Class clazz = Class.forName(classPath);
                                    loader = clazz.getClassLoader();
                                }
                                Parcelable parcelable = in.readParcelable(loader);
                                this.parcelableArray[i] = parcelable;
                            } catch (Exception e) {
                                String str2 = TAG;
                                Log.w(str2, "read parcelable array e=" + e);
                                break;
                            }
                        }
                        break;
                    }
                case FLAG_BYTE_ARRAY /* -1163133183 */:
                    int len2 = in.readInt();
                    this.mBytes = new byte[len2];
                    in.readByteArray(this.mBytes);
                    break;
                case FLAG_INT_ARRAY /* -1163133182 */:
                    int len3 = in.readInt();
                    this.mInts = new int[len3];
                    in.readIntArray(this.mInts);
                    break;
                case FLAG_STRING_ARRAY /* -1163133181 */:
                    int len4 = in.readInt();
                    this.mStrings = new String[len4];
                    in.readStringArray(this.mStrings);
                    break;
                default:
                    exit = true;
                    String str3 = TAG;
                    Log.w(str3, "readFromParcel,magic number not match:0x" + Integer.toHexString(flag));
                    break;
            }
            if (!exit) {
                curPos = in.dataPosition();
            } else {
                return;
            }
        }
    }
}
