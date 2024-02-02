package com.xiaopeng.xuimanager.contextinfo;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class Lane implements Parcelable {
    public static final Parcelable.Creator<Lane> CREATOR = new Parcelable.Creator<Lane>() { // from class: com.xiaopeng.xuimanager.contextinfo.Lane.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Lane createFromParcel(Parcel source) {
            return new Lane(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Lane[] newArray(int size) {
            return new Lane[size];
        }
    };
    private int[] backLane;
    private int[] frontLane;
    private boolean isLaneShow;
    private int laneType;
    private int[] tollGateInfo;

    public boolean isLaneShow() {
        return this.isLaneShow;
    }

    public void setLaneShow(boolean laneShow) {
        this.isLaneShow = laneShow;
    }

    public int getLaneType() {
        return this.laneType;
    }

    public void setLaneType(int laneType) {
        this.laneType = laneType;
    }

    public int[] getBackLane() {
        return this.backLane;
    }

    public void setBackLane(int[] backLane) {
        this.backLane = backLane;
    }

    public int[] getFrontLane() {
        return this.frontLane;
    }

    public void setFrontLane(int[] frontLane) {
        this.frontLane = frontLane;
    }

    public int[] getTollGateInfo() {
        return this.tollGateInfo;
    }

    public void setTollGateInfo(int[] tollGateInfo) {
        this.tollGateInfo = tollGateInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.isLaneShow ? (byte) 1 : (byte) 0);
        dest.writeInt(this.laneType);
        dest.writeIntArray(this.backLane);
        dest.writeIntArray(this.frontLane);
        dest.writeIntArray(this.tollGateInfo);
    }

    public Lane() {
    }

    protected Lane(Parcel in) {
        this.isLaneShow = in.readByte() != 0;
        this.laneType = in.readInt();
        this.backLane = in.createIntArray();
        this.frontLane = in.createIntArray();
        this.tollGateInfo = in.createIntArray();
    }
}
