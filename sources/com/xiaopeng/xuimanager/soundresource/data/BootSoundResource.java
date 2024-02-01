package com.xiaopeng.xuimanager.soundresource.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class BootSoundResource implements Parcelable {
    public static final Parcelable.Creator<BootSoundResource> CREATOR = new Parcelable.Creator<BootSoundResource>() { // from class: com.xiaopeng.xuimanager.soundresource.data.BootSoundResource.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BootSoundResource createFromParcel(Parcel in) {
            return new BootSoundResource(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BootSoundResource[] newArray(int size) {
            return new BootSoundResource[size];
        }
    };
    private String friendlyName;
    private int resId;
    private String[] resPath;

    public BootSoundResource() {
    }

    protected BootSoundResource(Parcel in) {
        this.resId = in.readInt();
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
        dest.writeString(this.friendlyName);
        dest.writeStringArray(this.resPath);
    }

    public void setResId(int id) {
        this.resId = id;
    }

    public int getResId() {
        return this.resId;
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
        sb.append("BootSoundResource[id=");
        sb.append(this.resId);
        sb.append(",name=");
        sb.append(this.friendlyName);
        sb.append(",path=");
        String[] strArr = this.resPath;
        sb.append(strArr != null ? strArr[0] : null);
        sb.append("]");
        return sb.toString();
    }
}
