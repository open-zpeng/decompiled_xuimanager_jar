package com.xiaopeng.xuimanager.contextinfo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class HomeCompanyRouteInfo implements Parcelable {
    public static final Parcelable.Creator<HomeCompanyRouteInfo> CREATOR = new Parcelable.Creator<HomeCompanyRouteInfo>() { // from class: com.xiaopeng.xuimanager.contextinfo.HomeCompanyRouteInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HomeCompanyRouteInfo createFromParcel(Parcel in) {
            return new HomeCompanyRouteInfo(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HomeCompanyRouteInfo[] newArray(int size) {
            return new HomeCompanyRouteInfo[size];
        }
    };
    private long distance;
    private int isOnline;
    private int routeInfoType;
    private String trafficBar;
    private long travelTime;

    public HomeCompanyRouteInfo() {
    }

    protected HomeCompanyRouteInfo(Parcel in) {
        this.routeInfoType = in.readInt();
        this.distance = in.readLong();
        this.travelTime = in.readLong();
        this.isOnline = in.readInt();
        this.trafficBar = in.readString();
    }

    public void setRouteInfoType(int type) {
        this.routeInfoType = type;
    }

    public int getRouteInfoType() {
        return this.routeInfoType;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public long getDistance() {
        return this.distance;
    }

    public void setTravelTime(long travelTime) {
        this.travelTime = travelTime;
    }

    public long getTravelTime() {
        return this.travelTime;
    }

    public void setIsOnline(int val) {
        this.isOnline = val;
    }

    public int getIsOnline() {
        return this.isOnline;
    }

    public void setTrafficBar(String val) {
        this.trafficBar = val;
    }

    public String getTrafficBar() {
        return this.trafficBar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.routeInfoType);
        dest.writeLong(this.distance);
        dest.writeLong(this.travelTime);
        dest.writeInt(this.isOnline);
        dest.writeString(this.trafficBar);
    }
}
