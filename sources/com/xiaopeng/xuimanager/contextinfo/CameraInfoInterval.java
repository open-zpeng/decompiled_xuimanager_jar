package com.xiaopeng.xuimanager.contextinfo;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class CameraInfoInterval implements Parcelable {
    public static final Parcelable.Creator<CameraInfoInterval> CREATOR = new Parcelable.Creator<CameraInfoInterval>() { // from class: com.xiaopeng.xuimanager.contextinfo.CameraInfoInterval.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CameraInfoInterval createFromParcel(Parcel source) {
            return new CameraInfoInterval(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CameraInfoInterval[] newArray(int size) {
            return new CameraInfoInterval[size];
        }
    };
    private int averageSpeed;
    private int cameraDist;
    private String cameraDistDisplay;
    private int cameraDistUnitDisplay;
    private int cameraSpeed;
    private int cameraType;
    private int reasonableSpeedInRemainDist;
    private int remainDistance;

    public CameraInfoInterval() {
    }

    protected CameraInfoInterval(Parcel in) {
        this.cameraDist = in.readInt();
        this.cameraSpeed = in.readInt();
        this.cameraType = in.readInt();
        this.remainDistance = in.readInt();
        this.averageSpeed = in.readInt();
        this.reasonableSpeedInRemainDist = in.readInt();
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

    public int getRemainDistance() {
        return this.remainDistance;
    }

    public void setRemainDistance(int remainDistance) {
        this.remainDistance = remainDistance;
    }

    public int getAverageSpeed() {
        return this.averageSpeed;
    }

    public void setAverageSpeed(int averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public int getReasonableSpeedInRemainDist() {
        return this.reasonableSpeedInRemainDist;
    }

    public void setReasonableSpeedInRemainDist(int reasonableSpeedInRemainDist) {
        this.reasonableSpeedInRemainDist = reasonableSpeedInRemainDist;
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
        dest.writeInt(this.remainDistance);
        dest.writeInt(this.averageSpeed);
        dest.writeInt(this.reasonableSpeedInRemainDist);
        dest.writeString(this.cameraDistDisplay);
        dest.writeInt(this.cameraDistUnitDisplay);
    }
}
