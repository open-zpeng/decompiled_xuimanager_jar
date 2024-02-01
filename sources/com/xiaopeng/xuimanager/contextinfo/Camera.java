package com.xiaopeng.xuimanager.contextinfo;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes.dex */
public class Camera implements Parcelable {
    public static final Parcelable.Creator<Camera> CREATOR = new Parcelable.Creator<Camera>() { // from class: com.xiaopeng.xuimanager.contextinfo.Camera.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Camera createFromParcel(Parcel source) {
            return new Camera(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Camera[] newArray(int size) {
            return new Camera[size];
        }
    };
    private List<CameraInfo> cameraInfo;
    private boolean isCameraShow;

    public Camera() {
    }

    protected Camera(Parcel in) {
        this.isCameraShow = in.readByte() != 0;
        this.cameraInfo = in.createTypedArrayList(CameraInfo.CREATOR);
    }

    public boolean getIsCameraShow() {
        return this.isCameraShow;
    }

    public void setIsCameraShow(boolean isCameraShow) {
        this.isCameraShow = isCameraShow;
    }

    public List<CameraInfo> getCameraInfo() {
        return this.cameraInfo;
    }

    public void setCameraInfo(List<CameraInfo> cameraInfo) {
        this.cameraInfo = cameraInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.isCameraShow ? (byte) 1 : (byte) 0);
        dest.writeTypedList(this.cameraInfo);
    }
}
