package com.xiaopeng.xuimanager.contextinfo;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class SapaInfo implements Parcelable {
    public static final Parcelable.Creator<SapaInfo> CREATOR = new Parcelable.Creator<SapaInfo>() { // from class: com.xiaopeng.xuimanager.contextinfo.SapaInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SapaInfo createFromParcel(Parcel source) {
            return new SapaInfo(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SapaInfo[] newArray(int size) {
            return new SapaInfo[size];
        }
    };
    private String name;
    private int remainDist;
    private String remainDistDisplay;
    private int remainDistUnitDisplay;
    private long sapaDetail;
    private int type;

    public SapaInfo() {
    }

    protected SapaInfo(Parcel in) {
        this.name = in.readString();
        this.sapaDetail = in.readLong();
        this.type = in.readInt();
        this.remainDist = in.readInt();
        this.remainDistDisplay = in.readString();
        this.remainDistUnitDisplay = in.readInt();
    }

    public String getRemainDistDisplay() {
        return this.remainDistDisplay;
    }

    public void setRemainDistDisplay(String remainDistDisplay) {
        this.remainDistDisplay = remainDistDisplay;
    }

    public int getRemainDistUnitDisplay() {
        return this.remainDistUnitDisplay;
    }

    public void setRemainDistUnitDisplay(int remainDistUnitDisplay) {
        this.remainDistUnitDisplay = remainDistUnitDisplay;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSapaDetail() {
        return this.sapaDetail;
    }

    public void setSapaDetail(long sapaDetail) {
        this.sapaDetail = sapaDetail;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getRemainDist() {
        return this.remainDist;
    }

    public void setRemainDist(int remainDist) {
        this.remainDist = remainDist;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeLong(this.sapaDetail);
        dest.writeInt(this.type);
        dest.writeInt(this.remainDist);
        dest.writeString(this.remainDistDisplay);
        dest.writeInt(this.remainDistUnitDisplay);
    }
}
