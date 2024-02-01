package com.xiaopeng.xuimanager.operation;

/* loaded from: classes.dex */
public class DownloadStatusInfo {
    public static final int STATE_CANCELLED = 1150;
    public static final int STATE_COMPLETE = 1100;
    public static final int STATE_ERROR = 1000;
    public static final int STATE_LOADING = 1;
    public static final int STATE_PAUSED = 200;
    public static final int STATE_PENDING = 2;
    public static final int STATE_RUNNING = 100;
    public static final int STATE_RUNNING_DOWNLOAD = 101;
    public static final int STATE_RUNNING_INSTALLING = 102;
    public static final int STATE_UNKNOWN = 0;
    private String extraInfo;
    private float mProgress;
    private String mResourceId;
    private String mResourceName;
    private int mResourceType;
    private int mState = 0;

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

    public float getProgress() {
        return this.mProgress;
    }

    public void setProgress(float progress) {
        this.mProgress = progress;
    }

    public int getState() {
        return this.mState;
    }

    public void setState(int state) {
        this.mState = state;
    }

    public String getExtraInfo() {
        return this.extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public String toString() {
        return "DownloadStatusInfo{mResourceId='" + this.mResourceId + "', mResourceType=" + this.mResourceType + ", mResourceName='" + this.mResourceName + "', mProgress=" + this.mProgress + ", mState=" + this.mState + ", extraInfo='" + this.extraInfo + "'}";
    }
}
