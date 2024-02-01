package com.xiaopeng.xuimanager.operation;
/* loaded from: classes.dex */
public class FailedInfo {
    public static final String DISK_NO_SPACE = "disk space is not enough";
    public static final String UNZIP_ERROR = "file not exist or not a valid zip file";
    private String mFailedReason;
    private String mResourceId;
    private String mResourceName;
    private int mResourceType;

    public String getResourceId() {
        return this.mResourceId;
    }

    public void setResourceId(String resourceId) {
        this.mResourceId = resourceId;
    }

    public int getResourceType() {
        return this.mResourceType;
    }

    public void setResourceType(int resourceType) {
        this.mResourceType = resourceType;
    }

    public String getResourceName() {
        return this.mResourceName;
    }

    public void setResourceName(String resourceName) {
        this.mResourceName = resourceName;
    }

    public String getFailedReason() {
        return this.mFailedReason;
    }

    public void setFailedReason(String failedReason) {
        this.mFailedReason = failedReason;
    }

    public String toString() {
        return "FailedInfo{mResourceId='" + this.mResourceId + "', mResourceType=" + this.mResourceType + ", mResourceName='" + this.mResourceName + "', mFailedReason='" + this.mFailedReason + "'}";
    }
}
