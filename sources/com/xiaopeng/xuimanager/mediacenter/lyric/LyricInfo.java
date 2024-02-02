package com.xiaopeng.xuimanager.mediacenter.lyric;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class LyricInfo implements Parcelable {
    public static final Parcelable.Creator<LyricInfo> CREATOR = new Parcelable.Creator<LyricInfo>() { // from class: com.xiaopeng.xuimanager.mediacenter.lyric.LyricInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LyricInfo createFromParcel(Parcel source) {
            return new LyricInfo(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LyricInfo[] newArray(int size) {
            return new LyricInfo[size];
        }
    };
    private String albumName;
    private String artistName;
    private String lyricContent;
    private String lyricType;
    private Bundle mExtras;
    private String songId;
    private String songName;

    public LyricInfo() {
    }

    private LyricInfo(Parcel source) {
        readFromParcel(source);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.songId);
        dest.writeString(this.songName);
        dest.writeString(this.artistName);
        dest.writeString(this.albumName);
        dest.writeString(this.lyricType);
        dest.writeString(this.lyricContent);
        dest.writeBundle(this.mExtras);
    }

    public void readFromParcel(Parcel source) {
        this.songId = source.readString();
        this.songName = source.readString();
        this.artistName = source.readString();
        this.albumName = source.readString();
        this.lyricType = source.readString();
        this.lyricContent = source.readString();
        this.mExtras = source.readBundle();
    }

    public String getSongId() {
        return this.songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return this.songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return this.artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumName() {
        return this.albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getLyricType() {
        return this.lyricType;
    }

    public void setLyricType(String lyricType) {
        this.lyricType = lyricType;
    }

    public String getLyricContent() {
        return this.lyricContent;
    }

    public void setLyricContent(String lyricContent) {
        this.lyricContent = lyricContent;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public void setExtras(Bundle extras) {
        this.mExtras = extras;
    }

    public String toString() {
        return "LyricInfo{songId='" + this.songId + "', songName='" + this.songName + "', artistName='" + this.artistName + "', albumName='" + this.albumName + "', lyricType='" + this.lyricType + "', mExtras=" + this.mExtras + '}';
    }
}
