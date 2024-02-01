package com.xiaopeng.xuimanager.seatmassager;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class Seat implements Parcelable {
    public static final Parcelable.Creator<Seat> CREATOR = new Parcelable.Creator<Seat>() { // from class: com.xiaopeng.xuimanager.seatmassager.Seat.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Seat createFromParcel(Parcel source) {
            return new Seat(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Seat[] newArray(int size) {
            return new Seat[size];
        }
    };
    private int id;
    private int intensity;

    private Seat(Parcel source) {
        readFromParcel(source);
    }

    public Seat(int id, int intensity) {
        this.id = id;
        this.intensity = intensity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    public int getIntensity() {
        return this.intensity;
    }

    public String toString() {
        return "id=" + this.id + ", intensity=" + this.intensity;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof Seat)) {
            return false;
        }
        if (((Seat) obj).id == this.id && ((Seat) obj).intensity == this.intensity) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.intensity);
    }

    public void readFromParcel(Parcel source) {
        this.id = source.readInt();
        this.intensity = source.readInt();
    }
}
