package com.xiaopeng.xuimanager.contextinfo;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class Location implements Parcelable {
    public static final Parcelable.Creator<Location> CREATOR = new Parcelable.Creator<Location>() { // from class: com.xiaopeng.xuimanager.contextinfo.Location.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Location createFromParcel(Parcel source) {
            return new Location(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };
    private int carDir;

    public int getCarDir() {
        return this.carDir;
    }

    public void setCarDir(int carDir) {
        this.carDir = carDir;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.carDir);
    }

    public Location() {
    }

    protected Location(Parcel in) {
        this.carDir = in.readInt();
    }
}
