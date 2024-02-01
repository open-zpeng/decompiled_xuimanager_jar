package com.xiaopeng.xuimanager.contextinfo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class CameraInfo implements Parcelable {
    public static final Parcelable.Creator<CameraInfo> CREATOR = new Parcelable.Creator<CameraInfo>() { // from class: com.xiaopeng.xuimanager.contextinfo.CameraInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CameraInfo createFromParcel(Parcel source) {
            return new CameraInfo(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CameraInfo[] newArray(int size) {
            return new CameraInfo[size];
        }
    };
    private int cameraDist;
    private String cameraDistDisplay;
    private int cameraDistUnitDisplay;
    private int cameraSpeed;
    private int cameraType;

    public CameraInfo() {
    }

    protected CameraInfo(Parcel in) {
        this.cameraDist = in.readInt();
        this.cameraSpeed = in.readInt();
        this.cameraType = in.readInt();
        this.cameraDistDisplay = in.readString();
        this.cameraDistUnitDisplay = in.readInt();
    }

    public String getCameraDistDisplay() {
        return this.cameraDistDisplay;
    }

    public void setCameraDistDisplay(String cameraDistDisplay) {
        this.cameraDistDisplay = cameraDistDisplay;
    }

    public int getCameraDistUnitDisplay() {
        return this.cameraDistUnitDisplay;
    }

    public void setCameraDistUnitDisplay(int cameraDistUnitDisplay) {
        this.cameraDistUnitDisplay = cameraDistUnitDisplay;
    }

    public int getCameraDist() {
        return this.cameraDist;
    }

    public void setCameraDist(int cameraDist) {
        this.cameraDist = cameraDist;
    }

    public int getCameraSpeed() {
        return this.cameraSpeed;
    }

    public void setCameraSpeed(int cameraSpeed) {
        this.cameraSpeed = cameraSpeed;
    }

    public int getCameraType() {
        return this.cameraType;
    }

    public void setCameraType(int cameraType) {
        this.cameraType = cameraType;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.cameraDist);
        dest.writeInt(this.cameraSpeed);
        dest.writeInt(this.cameraType);
        dest.writeString(this.cameraDistDisplay);
        dest.writeInt(this.cameraDistUnitDisplay);
    }
}
