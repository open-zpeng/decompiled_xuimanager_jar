package com.xiaopeng.xuimanager.contextinfo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class RemainInfo implements Parcelable {
    public static final Parcelable.Creator<RemainInfo> CREATOR = new Parcelable.Creator<RemainInfo>() { // from class: com.xiaopeng.xuimanager.contextinfo.RemainInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemainInfo createFromParcel(Parcel source) {
            return new RemainInfo(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemainInfo[] newArray(int size) {
            return new RemainInfo[size];
        }
    };
    private int carRemainDist;
    private String carRemainDistDisplay;
    private int carRemainDistUnitDisplay;
    private int distType;
    private int routeRemainDist;
    private String routeRemainDistDisplay;
    private int routeRemainDistUnitDisplay;
    private int smartStatus;

    public RemainInfo() {
    }

    protected RemainInfo(Parcel in) {
        this.routeRemainDist = in.readInt();
        this.carRemainDist = in.readInt();
        this.distType = in.readInt();
        this.routeRemainDistDisplay = in.readString();
        this.routeRemainDistUnitDisplay = in.readInt();
        this.carRemainDistDisplay = in.readString();
        this.carRemainDistUnitDisplay = in.readInt();
        this.smartStatus = in.readInt();
    }

    public String getRouteRemainDistDisplay() {
        return this.routeRemainDistDisplay;
    }

    public void setRouteRemainDistDisplay(String routeRemainDistDisplay) {
        this.routeRemainDistDisplay = routeRemainDistDisplay;
    }

    public int getRouteRemainDistUnitDisplay() {
        return this.routeRemainDistUnitDisplay;
    }

    public void setRouteRemainDistUnitDisplay(int routeRemainDistUnitDisplay) {
        this.routeRemainDistUnitDisplay = routeRemainDistUnitDisplay;
    }

    public String getCarRemainDistDisplay() {
        return this.carRemainDistDisplay;
    }

    public void setCarRemainDistDisplay(String carRemainDistDisplay) {
        this.carRemainDistDisplay = carRemainDistDisplay;
    }

    public int getCarRemainDistUnitDisplay() {
        return this.carRemainDistUnitDisplay;
    }

    public void setCarRemainDistUnitDisplay(int carRemainDistUnitDisplay) {
        this.carRemainDistUnitDisplay = carRemainDistUnitDisplay;
    }

    public int getDistType() {
        return this.distType;
    }

    public void setDistType(int distType) {
        this.distType = distType;
    }

    public int getRouteRemainDist() {
        return this.routeRemainDist;
    }

    public void setRouteRemainDist(int routeRemainDist) {
        this.routeRemainDist = routeRemainDist;
    }

    public int getCarRemainDist() {
        return this.carRemainDist;
    }

    public void setCarRemainDist(int carRemainDist) {
        this.carRemainDist = carRemainDist;
    }

    public int getSmartStatus() {
        return this.smartStatus;
    }

    public void setSmartStatus(int smartStatus) {
        this.smartStatus = smartStatus;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.routeRemainDist);
        dest.writeInt(this.carRemainDist);
        dest.writeInt(this.distType);
        dest.writeString(this.routeRemainDistDisplay);
        dest.writeInt(this.routeRemainDistUnitDisplay);
        dest.writeString(this.carRemainDistDisplay);
        dest.writeInt(this.carRemainDistUnitDisplay);
        dest.writeInt(this.smartStatus);
    }
}
