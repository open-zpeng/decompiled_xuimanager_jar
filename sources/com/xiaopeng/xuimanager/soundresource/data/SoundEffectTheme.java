package com.xiaopeng.xuimanager.soundresource.data;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class SoundEffectTheme implements Parcelable {
    public static final Parcelable.Creator<SoundEffectTheme> CREATOR = new Parcelable.Creator<SoundEffectTheme>() { // from class: com.xiaopeng.xuimanager.soundresource.data.SoundEffectTheme.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SoundEffectTheme createFromParcel(Parcel in) {
            return new SoundEffectTheme(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SoundEffectTheme[] newArray(int size) {
            return new SoundEffectTheme[size];
        }
    };
    private String friendlyName;
    private String[] playbillPath;
    private String subName;
    private int themeId;

    public SoundEffectTheme() {
    }

    public SoundEffectTheme(Parcel in) {
        this.themeId = in.readInt();
        this.friendlyName = in.readString();
        this.subName = in.readString();
        this.playbillPath = in.createStringArray();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.themeId);
        dest.writeString(this.friendlyName);
        dest.writeString(this.subName);
        dest.writeStringArray(this.playbillPath);
    }

    public int getThemeId() {
        return this.themeId;
    }

    public void setThemeId(int id) {
        this.themeId = id;
    }

    public String getFriendlyName() {
        return this.friendlyName;
    }

    public void setFriendlyName(String name) {
        this.friendlyName = name;
    }

    public String getSubName() {
        return this.subName;
    }

    public void setSubName(String name) {
        this.subName = name;
    }

    public String[] getPlaybillPath() {
        return this.playbillPath;
    }

    public void setPlaybillPath(String[] path) {
        this.playbillPath = path;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SoundEffectTheme[id=");
        sb.append(this.themeId);
        sb.append(",name=");
        sb.append(this.friendlyName);
        sb.append(",subName=");
        sb.append(this.subName);
        sb.append(",picPath0=");
        sb.append(this.playbillPath != null ? this.playbillPath[0] : null);
        sb.append("]");
        return sb.toString();
    }
}
