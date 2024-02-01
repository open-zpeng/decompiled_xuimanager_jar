package com.xiaopeng.xuimanager.musicrecognize;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class MusicRecognizeEvent implements Parcelable {
    public static final Parcelable.Creator<MusicRecognizeEvent> CREATOR = new Parcelable.Creator<MusicRecognizeEvent>() { // from class: com.xiaopeng.xuimanager.musicrecognize.MusicRecognizeEvent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MusicRecognizeEvent createFromParcel(Parcel in) {
            return new MusicRecognizeEvent(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MusicRecognizeEvent[] newArray(int size) {
            return new MusicRecognizeEvent[size];
        }
    };
    private String mAlbumCover;
    private String mAlbumName;
    private String mScore;
    private String mSinger;
    private String mSongName;

    public MusicRecognizeEvent() {
    }

    public MusicRecognizeEvent(String songName, String albumName, String albumCover, String singer, String score) {
        this.mSongName = songName;
        this.mAlbumName = albumName;
        this.mAlbumCover = albumCover;
        this.mSinger = singer;
        this.mScore = score;
    }

    protected MusicRecognizeEvent(Parcel in) {
        this.mSongName = in.readString();
        this.mAlbumName = in.readString();
        this.mAlbumCover = in.readString();
        this.mSinger = in.readString();
        this.mScore = in.readString();
    }

    public String getSongName() {
        return this.mSongName;
    }

    public void setSongName(String songName) {
        this.mSongName = songName;
    }

    public String getAlbumName() {
        return this.mAlbumName;
    }

    public void setAlbumName(String albumName) {
        this.mAlbumName = albumName;
    }

    public String getAlbumCover() {
        return this.mAlbumCover;
    }

    public void setAlbumCover(String albumCover) {
        this.mAlbumCover = albumCover;
    }

    public String getSinger() {
        return this.mSinger;
    }

    public void setSinger(String singer) {
        this.mSinger = singer;
    }

    public String getScore() {
        return this.mScore;
    }

    public void setScore(String score) {
        this.mScore = score;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mSongName);
        dest.writeString(this.mAlbumName);
        dest.writeString(this.mAlbumCover);
        dest.writeString(this.mSinger);
        dest.writeString(this.mScore);
    }
}
