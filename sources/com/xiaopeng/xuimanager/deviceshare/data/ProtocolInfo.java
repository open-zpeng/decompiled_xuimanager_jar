package com.xiaopeng.xuimanager.deviceshare.data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class ProtocolInfo implements Parcelable {
    public static final Parcelable.Creator<ProtocolInfo> CREATOR = new Parcelable.Creator<ProtocolInfo>() { // from class: com.xiaopeng.xuimanager.deviceshare.data.ProtocolInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProtocolInfo createFromParcel(Parcel in) {
            return new ProtocolInfo(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProtocolInfo[] newArray(int size) {
            return new ProtocolInfo[size];
        }
    };
    private Bitmap icon;
    private int protocol;
    private String tabDescription;

    public ProtocolInfo() {
    }

    public void setProtocol(int val) {
        this.protocol = val;
    }

    public int getProtocol() {
        return this.protocol;
    }

    public void setTabDescription(String val) {
        this.tabDescription = val;
    }

    public String getTabDescription() {
        return this.tabDescription;
    }

    public void setIcon(Bitmap val) {
        this.icon = val;
    }

    public Bitmap getIcon() {
        return this.icon;
    }

    protected ProtocolInfo(Parcel in) {
        this.protocol = in.readInt();
        this.tabDescription = in.readStringNoHelper();
        this.icon = (Bitmap) in.readParcelable(Bitmap.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.protocol);
        dest.writeStringNoHelper(this.tabDescription);
        dest.writeParcelable(this.icon, flags);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
