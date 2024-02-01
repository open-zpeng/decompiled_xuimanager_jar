package com.xiaopeng.xuimanager.contextinfo;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class Cross implements Parcelable {
    public static final Parcelable.Creator<Cross> CREATOR = new Parcelable.Creator<Cross>() { // from class: com.xiaopeng.xuimanager.contextinfo.Cross.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Cross createFromParcel(Parcel source) {
            return new Cross(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Cross[] newArray(int size) {
            return new Cross[size];
        }
    };
    private String arrowDataBuffer;
    private int crossType;
    private String dataBuffer;
    private boolean isCrossShow;

    public boolean isCrossShow() {
        return this.isCrossShow;
    }

    public void setCrossShow(boolean crossShow) {
        this.isCrossShow = crossShow;
    }

    public int getCrossType() {
        return this.crossType;
    }

    public void setCrossType(int crossType) {
        this.crossType = crossType;
    }

    public String getDataBuffer() {
        return this.dataBuffer;
    }

    public void setDataBuffer(String dataBuffer) {
        this.dataBuffer = dataBuffer;
    }

    public String getArrowDataBuffer() {
        return this.arrowDataBuffer;
    }

    public void setArrowDataBuffer(String arrowDataBuffer) {
        this.arrowDataBuffer = arrowDataBuffer;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.isCrossShow ? (byte) 1 : (byte) 0);
        dest.writeInt(this.crossType);
        dest.writeString(this.dataBuffer);
        dest.writeString(this.arrowDataBuffer);
    }

    public Cross() {
    }

    protected Cross(Parcel in) {
        this.isCrossShow = in.readByte() != 0;
        this.crossType = in.readInt();
        this.dataBuffer = in.readString();
        this.arrowDataBuffer = in.readString();
    }
}
