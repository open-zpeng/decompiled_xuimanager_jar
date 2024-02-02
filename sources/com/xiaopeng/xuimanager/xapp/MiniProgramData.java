package com.xiaopeng.xuimanager.xapp;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class MiniProgramData implements Parcelable {
    public static final Parcelable.Creator<MiniProgramData> CREATOR = new Parcelable.Creator<MiniProgramData>() { // from class: com.xiaopeng.xuimanager.xapp.MiniProgramData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MiniProgramData createFromParcel(Parcel in) {
            return new MiniProgramData(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MiniProgramData[] newArray(int size) {
            return new MiniProgramData[size];
        }
    };
    private String mAlipayVersion;
    private int mContentType;
    private String mIconName;
    private String mId;
    private String mMiniAppId;
    private String mName;
    private String mParams;

    public MiniProgramData() {
        this.mName = "";
        this.mId = "";
    }

    protected MiniProgramData(Parcel in) {
        this.mName = "";
        this.mId = "";
        this.mName = in.readStringNoHelper();
        this.mId = in.readStringNoHelper();
        this.mMiniAppId = in.readStringNoHelper();
        this.mAlipayVersion = in.readStringNoHelper();
        this.mIconName = in.readStringNoHelper();
        this.mParams = in.readStringNoHelper();
        this.mContentType = in.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringNoHelper(this.mName);
        dest.writeStringNoHelper(this.mId);
        dest.writeStringNoHelper(this.mMiniAppId);
        dest.writeStringNoHelper(this.mAlipayVersion);
        dest.writeStringNoHelper(this.mIconName);
        dest.writeStringNoHelper(this.mParams);
        dest.writeInt(this.mContentType);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String id) {
        this.mId = id;
    }

    public String getMiniAppId() {
        return this.mMiniAppId;
    }

    public void setMiniAppId(String miniAppId) {
        this.mMiniAppId = miniAppId;
    }

    public String getAlipayVersion() {
        return this.mAlipayVersion;
    }

    public void setAlipayVersion(String alipayVersion) {
        this.mAlipayVersion = alipayVersion;
    }

    public String getIconName() {
        return this.mIconName;
    }

    public void setIconName(String iconName) {
        this.mIconName = iconName;
    }

    public String getParams() {
        return this.mParams;
    }

    public void setParams(String params) {
        this.mParams = params;
    }

    public int getContentType() {
        return this.mContentType;
    }

    public void setContentType(int contentType) {
        this.mContentType = contentType;
    }

    public String toString() {
        return "MiniProgramData{mId=" + this.mId + ", mName='" + this.mName + "', mMiniAppId=" + this.mMiniAppId + ", mAlipayVersion=" + this.mAlipayVersion + ", mIconName=" + this.mIconName + ", mContentType=" + this.mContentType + '}';
    }
}
