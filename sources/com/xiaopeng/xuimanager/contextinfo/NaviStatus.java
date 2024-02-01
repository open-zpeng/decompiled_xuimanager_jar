package com.xiaopeng.xuimanager.contextinfo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class NaviStatus implements Parcelable {
    public static final Parcelable.Creator<NaviStatus> CREATOR = new Parcelable.Creator<NaviStatus>() { // from class: com.xiaopeng.xuimanager.contextinfo.NaviStatus.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NaviStatus createFromParcel(Parcel in) {
            return new NaviStatus(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NaviStatus[] newArray(int size) {
            return new NaviStatus[size];
        }
    };
    private int naviStatus;

    public NaviStatus() {
    }

    protected NaviStatus(Parcel in) {
        this.naviStatus = in.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.naviStatus);
    }

    public void setNaviStatus(int status) {
        this.naviStatus = status;
    }

    public int getNaviStatus() {
        return this.naviStatus;
    }
}
