package com.xiaopeng.xuimanager.condition;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class TwilightState implements Parcelable {
    public static final Parcelable.Creator<TwilightState> CREATOR = new Parcelable.Creator<TwilightState>() { // from class: com.xiaopeng.xuimanager.condition.TwilightState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TwilightState createFromParcel(Parcel in) {
            return new TwilightState(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TwilightState[] newArray(int size) {
            return new TwilightState[size];
        }
    };
    private long sunriseTimeMillis;
    private long sunsetTimeMillis;

    public TwilightState(long sunriseTimeMillis, long sunsetTimeMillis) {
        this.sunriseTimeMillis = sunriseTimeMillis;
        this.sunsetTimeMillis = sunsetTimeMillis;
    }

    protected TwilightState(Parcel in) {
        this.sunriseTimeMillis = in.readLong();
        this.sunsetTimeMillis = in.readLong();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.sunriseTimeMillis);
        dest.writeLong(this.sunsetTimeMillis);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getSunriseTimeMillis() {
        return this.sunriseTimeMillis;
    }

    public void setSunriseTimeMillis(long sunriseTimeMillis) {
        this.sunriseTimeMillis = sunriseTimeMillis;
    }

    public long getSunsetTimeMillis() {
        return this.sunsetTimeMillis;
    }

    public void setSunsetTimeMillis(long sunsetTimeMillis) {
        this.sunsetTimeMillis = sunsetTimeMillis;
    }
}
