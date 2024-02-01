package com.xiaopeng.xuimanager.deviceshare.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class ShareAppInfo implements Parcelable {
    public static final Parcelable.Creator<ShareAppInfo> CREATOR = new Parcelable.Creator<ShareAppInfo>() { // from class: com.xiaopeng.xuimanager.deviceshare.data.ShareAppInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareAppInfo createFromParcel(Parcel in) {
            return new ShareAppInfo(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareAppInfo[] newArray(int size) {
            return new ShareAppInfo[size];
        }
    };
    private String friendName;
    private byte[] icon;
    private String packageName;
    private int protocol;

    public ShareAppInfo() {
        this.protocol = -1;
    }

    public String toString() {
        return "ShareApp[" + this.friendName + "/" + this.packageName + "]@" + hashCode();
    }

    public ShareAppInfo(Parcel in) {
        this.protocol = -1;
        this.protocol = in.readInt();
        this.packageName = in.readString();
        this.friendName = in.readString();
        this.icon = in.createByteArray();
    }

    public void setProtocol(int val) {
        this.protocol = val;
    }

    public int getProtocol() {
        return this.protocol;
    }

    public void setPackageName(String val) {
        this.packageName = val;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setFriendName(String val) {
        this.friendName = val;
    }

    public String getFriendName() {
        return this.friendName;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
    }

    public byte[] getIcon() {
        return this.icon;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.protocol);
        dest.writeString(this.packageName);
        dest.writeString(this.friendName);
        dest.writeByteArray(this.icon);
    }
}
