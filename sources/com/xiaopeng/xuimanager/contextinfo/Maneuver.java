package com.xiaopeng.xuimanager.contextinfo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class Maneuver implements Parcelable {
    public static final Parcelable.Creator<Maneuver> CREATOR = new Parcelable.Creator<Maneuver>() { // from class: com.xiaopeng.xuimanager.contextinfo.Maneuver.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Maneuver createFromParcel(Parcel source) {
            return new Maneuver(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Maneuver[] newArray(int size) {
            return new Maneuver[size];
        }
    };
    private String maneuverData;
    private long maneuverID;

    public Maneuver() {
    }

    protected Maneuver(Parcel in) {
        this.maneuverID = in.readLong();
        this.maneuverData = in.readString();
    }

    public long getManeuverID() {
        return this.maneuverID;
    }

    public void setManeuverID(long maneuverID) {
        this.maneuverID = maneuverID;
    }

    public String getManeuverData() {
        return this.maneuverData;
    }

    public void setManeuverData(String maneuverData) {
        this.maneuverData = maneuverData;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.maneuverID);
        dest.writeString(this.maneuverData);
    }
}
