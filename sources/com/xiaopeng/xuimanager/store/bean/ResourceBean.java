package com.xiaopeng.xuimanager.store.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class ResourceBean implements Parcelable {
    public static final Parcelable.Creator<ResourceBean> CREATOR = new Parcelable.Creator<ResourceBean>() { // from class: com.xiaopeng.xuimanager.store.bean.ResourceBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ResourceBean createFromParcel(Parcel in) {
            return new ResourceBean(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ResourceBean[] newArray(int size) {
            return new ResourceBean[size];
        }
    };
    private String mCreateTime;
    private String mDes;
    private String mDownloadUrl;
    private String mExpandContent;
    private String mExpandInstalledContent;
    private String mPrice;
    private String mRscIcon;
    private String mRscId;
    private String mRscName;
    private int mSource;
    private int mStatus;
    private String mType;

    public ResourceBean() {
        this.mStatus = 1;
    }

    protected ResourceBean(Parcel in) {
        this.mStatus = 1;
        this.mDownloadUrl = in.readStringNoHelper();
        this.mRscId = in.readStringNoHelper();
        this.mRscName = in.readStringNoHelper();
        this.mRscIcon = in.readStringNoHelper();
        this.mExpandContent = in.readStringNoHelper();
        this.mDes = in.readStringNoHelper();
        this.mPrice = in.readStringNoHelper();
        this.mStatus = in.readInt();
        this.mCreateTime = in.readStringNoHelper();
        this.mType = in.readStringNoHelper();
        this.mExpandInstalledContent = in.readStringNoHelper();
        this.mSource = in.readInt();
    }

    public int getSource() {
        return this.mSource;
    }

    public void setSource(int source) {
        this.mSource = source;
    }

    public String getExpandInstalledContent() {
        return this.mExpandInstalledContent;
    }

    public void setExpandInstalledContent(String expandInstalledContent) {
        this.mExpandInstalledContent = expandInstalledContent;
    }

    public String getExpandContent() {
        return this.mExpandContent;
    }

    public void setExpandContent(String expandContent) {
        this.mExpandContent = expandContent;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDes() {
        return this.mDes;
    }

    public void setDes(String des) {
        this.mDes = des;
    }

    public String getPrice() {
        return this.mPrice;
    }

    public void setPrice(String price) {
        this.mPrice = price;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String type) {
        this.mType = type;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringNoHelper(this.mDownloadUrl);
        dest.writeStringNoHelper(this.mRscId);
        dest.writeStringNoHelper(this.mRscName);
        dest.writeStringNoHelper(this.mRscIcon);
        dest.writeStringNoHelper(this.mExpandContent);
        dest.writeStringNoHelper(this.mDes);
        dest.writeStringNoHelper(this.mPrice);
        dest.writeInt(this.mStatus);
        dest.writeStringNoHelper(this.mCreateTime);
        dest.writeStringNoHelper(this.mType);
        dest.writeStringNoHelper(this.mExpandInstalledContent);
        dest.writeInt(this.mSource);
    }

    public String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.mDownloadUrl = downloadUrl;
    }

    public String getRscId() {
        return this.mRscId;
    }

    public void setRscId(String rscId) {
        this.mRscId = rscId;
    }

    public String getRscName() {
        return this.mRscName;
    }

    public void setRscName(String rscName) {
        this.mRscName = rscName;
    }

    public String getRscIcon() {
        return this.mRscIcon;
    }

    public void setRscIcon(String rscIcon) {
        this.mRscIcon = rscIcon;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int status) {
        this.mStatus = status;
    }

    public String getCreateTime() {
        return this.mCreateTime;
    }

    public void setCreateTime(String createTime) {
        this.mCreateTime = createTime;
    }

    public String toString() {
        return "ResourceBean{mDownloadUrl='" + this.mDownloadUrl + "', mRscId='" + this.mRscId + "', mRscName='" + this.mRscName + "', mRscIcon='" + this.mRscIcon + "', mStatus=" + this.mStatus + ", mExpandContent=" + this.mExpandContent + ", mExpandInstalledContent=" + this.mExpandInstalledContent + ", mCreateTime='" + this.mCreateTime + "'}";
    }
}
