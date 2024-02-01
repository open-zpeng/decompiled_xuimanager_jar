package com.xiaopeng.xuimanager.contextinfo;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes.dex */
public class CameraInterval implements Parcelable {
    public static final Parcelable.Creator<CameraInterval> CREATOR = new Parcelable.Creator<CameraInterval>() { // from class: com.xiaopeng.xuimanager.contextinfo.CameraInterval.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CameraInterval createFromParcel(Parcel source) {
            return new CameraInterval(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CameraInterval[] newArray(int size) {
            return new CameraInterval[size];
        }
    };
    private List<CameraInfoInterval> cameraInfoInterval;
    private boolean isIntervalCameraShow;

    public CameraInterval() {
    }

    protected CameraInterval(Parcel in) {
        this.isIntervalCameraShow = in.readByte() != 0;
        this.cameraInfoInterval = in.createTypedArrayList(CameraInfoInterval.CREATOR);
    }

    public boolean isIntervalCameraShow() {
        return this.isIntervalCameraShow;
    }

    public void setIntervalCameraShow(boolean intervalCameraShow) {
        this.isIntervalCameraShow = intervalCameraShow;
    }

    public List<CameraInfoInterval> getIntervalCameraInfo() {
        return this.cameraInfoInterval;
    }

    public void setIntervalCameraInfo(List<CameraInfoInterval> cameraInfoInterval) {
        this.cameraInfoInterval = cameraInfoInterval;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.isIntervalCameraShow ? (byte) 1 : (byte) 0);
        dest.writeTypedList(this.cameraInfoInterval);
    }
}
