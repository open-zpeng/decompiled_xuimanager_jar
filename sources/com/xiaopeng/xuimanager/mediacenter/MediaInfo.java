package com.xiaopeng.xuimanager.mediacenter;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class MediaInfo implements Parcelable {
    private static final int AMBIENTLIGHT_DEFAULT_COLOR = 5;
    public static final int FAVOR_NOT_SET = 0;
    public static final int FAVOR_NOT_SUPPORT = -1;
    public static final int FAVOR_SET = 1;
    public static final int MEDIA_SOURCE_BT = 3;
    public static final int MEDIA_SOURCE_DOLBY = 6;
    public static final int MEDIA_SOURCE_FM = 1;
    public static final int MEDIA_SOURCE_MUSIC = 0;
    public static final int MEDIA_SOURCE_READING = 2;
    public static final int MEDIA_SOURCE_SHOWMODE = 4;
    public static final int MEDIA_SOURCE_USB = 5;
    public static final int MEDIA_STYLE_CLASSIC = 5;
    public static final int MEDIA_STYLE_DANCE = 11;
    public static final int MEDIA_STYLE_DEFAULT = -1;
    public static final int MEDIA_STYLE_FOLK = 8;
    public static final int MEDIA_STYLE_JAZZ = 2;
    public static final int MEDIA_STYLE_LIGHT = 4;
    public static final int MEDIA_STYLE_MOVIE = 7;
    public static final int MEDIA_STYLE_OPERA = 6;
    public static final int MEDIA_STYLE_OST = 10;
    public static final int MEDIA_STYLE_POP = 1;
    public static final int MEDIA_STYLE_RAP = 9;
    public static final int MEDIA_STYLE_ROCK = 3;
    public static final String TAG = "MediaInfo";
    private String mAlbum;
    private Bitmap mAlbumBmp;
    private String mAlbumUri;
    private String mArtist;
    private Bundle mExtras;
    private int mFavor;
    private String mId;
    private boolean mIsAudition;
    private boolean mIsXpMusic;
    private String mPackageName;
    private String mQualityName;
    private int mSource;
    private int mStyle;
    private int mStyleColor;
    private String mStyleName;
    private String mTitle;
    private static final int[] STYLECOLOR = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    public static final Parcelable.Creator<MediaInfo> CREATOR = new Parcelable.Creator<MediaInfo>() { // from class: com.xiaopeng.xuimanager.mediacenter.MediaInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaInfo createFromParcel(Parcel source) {
            return new MediaInfo(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaInfo[] newArray(int size) {
            return new MediaInfo[size];
        }
    };

    public MediaInfo() {
        this.mStyle = -1;
        this.mStyleColor = 5;
        this.mSource = 0;
        this.mFavor = -1;
    }

    private MediaInfo(Parcel source) {
        this.mStyle = -1;
        this.mStyleColor = 5;
        this.mSource = 0;
        this.mFavor = -1;
        readFromParcel(source);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mId);
        dest.writeString(this.mTitle);
        dest.writeString(this.mAlbum);
        dest.writeString(this.mArtist);
        dest.writeInt(this.mStyle);
        dest.writeInt(this.mStyleColor);
        dest.writeInt(this.mSource);
        dest.writeInt(this.mIsXpMusic ? 1 : 0);
        dest.writeInt(this.mFavor);
        dest.writeInt(this.mIsAudition ? 1 : 0);
        dest.writeString(this.mAlbumUri);
        dest.writeString(this.mStyleName);
        dest.writeString(this.mQualityName);
        dest.writeString(this.mPackageName);
        Bitmap bitmap = this.mAlbumBmp;
        if (bitmap != null && !bitmap.isRecycled()) {
            dest.writeInt(1);
            this.mAlbumBmp.writeToParcel(dest, 0);
        } else {
            dest.writeInt(0);
        }
        dest.writeBundle(this.mExtras);
    }

    public void readFromParcel(Parcel source) {
        this.mId = source.readString();
        this.mTitle = source.readString();
        this.mAlbum = source.readString();
        this.mArtist = source.readString();
        this.mStyle = source.readInt();
        this.mStyleColor = source.readInt();
        this.mSource = source.readInt();
        this.mIsXpMusic = source.readInt() == 1;
        this.mFavor = source.readInt();
        this.mIsAudition = source.readInt() == 1;
        this.mAlbumUri = source.readString();
        this.mStyleName = source.readString();
        this.mQualityName = source.readString();
        this.mPackageName = source.readString();
        int hasBmp = source.readInt();
        if (hasBmp == 1) {
            this.mAlbumBmp = (Bitmap) Bitmap.CREATOR.createFromParcel(source);
        } else {
            this.mAlbumBmp = null;
        }
        this.mExtras = Bundle.setDefusable(source.readBundle(), true);
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String id) {
        this.mId = id;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getAlbum() {
        return this.mAlbum;
    }

    public void setAlbum(String album) {
        this.mAlbum = album;
    }

    public String getArtist() {
        return this.mArtist;
    }

    public void setArtist(String artist) {
        this.mArtist = artist;
    }

    public int getStyle() {
        return this.mStyle;
    }

    public void setStyle(int style) {
        this.mStyle = style;
        this.mStyleColor = getColor(style);
    }

    public int getSource() {
        return this.mSource;
    }

    public void setSource(int source) {
        this.mSource = source;
    }

    public boolean isXpMusic() {
        return this.mIsXpMusic;
    }

    public void setXpMusic(boolean isXpMusic) {
        this.mIsXpMusic = isXpMusic;
    }

    public int getFavor() {
        return this.mFavor;
    }

    public void setFavor(int favor) {
        this.mFavor = favor;
    }

    public boolean isFavor() {
        return this.mFavor == 1;
    }

    public void setFavor(boolean isFavor) {
        this.mFavor = isFavor ? 1 : 0;
    }

    public boolean isAudition() {
        return this.mIsAudition;
    }

    public void setAudition(boolean isAudition) {
        this.mIsAudition = isAudition;
    }

    public String getAlbumUri() {
        return this.mAlbumUri;
    }

    public void setAlbumUri(String albumUri) {
        this.mAlbumUri = albumUri;
    }

    public String getStyleName() {
        return this.mStyleName;
    }

    public void setStyleName(String styleName) {
        this.mStyleName = styleName;
    }

    public String getQualityName() {
        return this.mQualityName;
    }

    public void setQualityName(String qualityName) {
        this.mQualityName = qualityName;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public void setPackageName(String packageName) {
        this.mPackageName = packageName;
    }

    public Bitmap getAlbumBitmap() {
        return this.mAlbumBmp;
    }

    public void setAlbumBitmap(Bitmap bmp) {
        this.mAlbumBmp = bmp;
    }

    public int getStyleColor() {
        return this.mStyleColor;
    }

    private static int getColor(int mediaStyle) {
        if (mediaStyle >= 0) {
            int[] iArr = STYLECOLOR;
            if (mediaStyle >= iArr.length) {
                return 5;
            }
            int color = iArr[mediaStyle];
            return color;
        }
        return 5;
    }

    public String getString(String key) {
        CharSequence text;
        if (this.mExtras == null || (text = getText(key)) == null) {
            return null;
        }
        return text.toString();
    }

    public CharSequence getText(String key) {
        return this.mExtras.getCharSequence(key);
    }

    public void putString(String key, String value) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        Bundle bundle = this.mExtras;
        if (bundle != null) {
            bundle.putCharSequence(key, value);
        }
    }

    public String toString() {
        return "MediaInfo{mId='" + this.mId + "', mTitle='" + this.mTitle + "', mAlbum='" + this.mAlbum + "', mArtist='" + this.mArtist + "', mStyle=" + this.mStyle + ", mStyleColor=" + this.mStyleColor + ", mSource=" + this.mSource + ", mIsXpMusic=" + this.mIsXpMusic + ", mFavor=" + this.mFavor + ", mIsAudition=" + this.mIsAudition + ", mAlbumUri='" + this.mAlbumUri + "', mStyleName='" + this.mStyleName + "', mQualityName='" + this.mQualityName + "', mPackageName='" + this.mPackageName + "'}";
    }
}
