package com.xiaopeng.xuimanager.mediacenter.bluetooth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class AvrcpMeteData implements Parcelable {
    public static final Parcelable.Creator<AvrcpMeteData> CREATOR = new Parcelable.Creator<AvrcpMeteData>() { // from class: com.xiaopeng.xuimanager.mediacenter.bluetooth.AvrcpMeteData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AvrcpMeteData createFromParcel(Parcel source) {
            return new AvrcpMeteData(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AvrcpMeteData[] newArray(int size) {
            return new AvrcpMeteData[size];
        }
    };
    private String mAlbum;
    private String mArtist;
    private Bundle mExtras;
    private String mTitle;

    public AvrcpMeteData() {
        this.mTitle = "";
        this.mArtist = "";
        this.mAlbum = "";
    }

    private AvrcpMeteData(Parcel source) {
        this.mTitle = "";
        this.mArtist = "";
        this.mAlbum = "";
        readFromParcel(source);
    }

    public void readFromParcel(Parcel source) {
        this.mTitle = source.readString();
        this.mArtist = source.readString();
        this.mAlbum = source.readString();
        this.mExtras = source.readBundle();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mTitle);
        dest.writeString(this.mArtist);
        dest.writeString(this.mAlbum);
        dest.writeBundle(this.mExtras);
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getArtist() {
        return this.mArtist;
    }

    public void setArtist(String artist) {
        this.mArtist = artist;
    }

    public String getAlbum() {
        return this.mAlbum;
    }

    public void setAlbum(String album) {
        this.mAlbum = album;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public void setExtras(Bundle extras) {
        this.mExtras = extras;
    }
}
