package com.xiaopeng.xuimanager.soundresource.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class SoundEffectResource implements Parcelable {
    public static final Parcelable.Creator<SoundEffectResource> CREATOR = new Parcelable.Creator<SoundEffectResource>() { // from class: com.xiaopeng.xuimanager.soundresource.data.SoundEffectResource.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SoundEffectResource createFromParcel(Parcel in) {
            return new SoundEffectResource(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SoundEffectResource[] newArray(int size) {
            return new SoundEffectResource[size];
        }
    };
    private String friendlyName;
    private int resId;
    private String[] resPath;
    private int resType;

    public SoundEffectResource() {
    }

    protected SoundEffectResource(Parcel in) {
        this.resId = in.readInt();
        this.resType = in.readInt();
        this.friendlyName = in.readString();
        this.resPath = in.createStringArray();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.resId);
        dest.writeInt(this.resType);
        dest.writeString(this.friendlyName);
        dest.writeStringArray(this.resPath);
    }

    public void setResId(int id) {
        this.resId = id;
    }

    public int getResId() {
        return this.resId;
    }

    public void setResourceType(int type) {
        this.resType = type;
    }

    public int getResourceType() {
        return this.resType;
    }

    public void setFriendlyName(String name) {
        this.friendlyName = name;
    }

    public String getFriendlyName() {
        return this.friendlyName;
    }

    public void setResPath(String[] path) {
        this.resPath = path;
    }

    public String[] getResPath() {
        return this.resPath;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SoundEffectResource[id=");
        sb.append(this.resId);
        sb.append(",resType=");
        sb.append(this.resType);
        sb.append(",name=");
        sb.append(this.friendlyName);
        sb.append(",path=");
        String[] strArr = this.resPath;
        sb.append(strArr != null ? strArr[0] : null);
        sb.append("]");
        return sb.toString();
    }
}
