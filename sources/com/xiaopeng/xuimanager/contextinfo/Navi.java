package com.xiaopeng.xuimanager.contextinfo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class Navi implements Parcelable {
    public static final Parcelable.Creator<Navi> CREATOR = new Parcelable.Creator<Navi>() { // from class: com.xiaopeng.xuimanager.contextinfo.Navi.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Navi createFromParcel(Parcel source) {
            return new Navi(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Navi[] newArray(int size) {
            return new Navi[size];
        }
    };
    private String curRouteName;
    private String exitInfo;
    private int exitInfoType;
    private boolean isShowExitInfo;
    private boolean isTightTurnShow;
    private int nextManeuverDist;
    private String nextManeuverDistDisplay;
    private int nextManeuverDistUnitDisplay;
    private long nextManeuverID;
    private String nextRouteName;
    private double routeRemainDist;
    private String routeRemainDistDisplay;
    private int routeRemainDistUnitDisplay;
    private int routeRemainLightCnt;
    private double routeRemainTime;
    private int segmentRemainDist;
    private String segmentRemainDistDisplay;
    private int segmentRemainDistUnitDisplay;
    private int segmentRemainProgress;
    private int smartStatus;
    private int viaRemainCnt;
    private double viaRemainTime;

    public Navi() {
    }

    protected Navi(Parcel in) {
        this.curRouteName = in.readString();
        this.nextRouteName = in.readString();
        this.isShowExitInfo = in.readByte() != 0;
        this.exitInfo = in.readString();
        this.segmentRemainDist = in.readInt();
        this.segmentRemainProgress = in.readInt();
        this.routeRemainDist = in.readDouble();
        this.routeRemainTime = in.readDouble();
        this.isTightTurnShow = in.readByte() != 0;
        this.nextManeuverID = in.readLong();
        this.nextManeuverDist = in.readInt();
        this.segmentRemainDistDisplay = in.readString();
        this.segmentRemainDistUnitDisplay = in.readInt();
        this.routeRemainDistDisplay = in.readString();
        this.routeRemainDistUnitDisplay = in.readInt();
        this.nextManeuverDistDisplay = in.readString();
        this.nextManeuverDistUnitDisplay = in.readInt();
        this.exitInfoType = in.readInt();
        this.smartStatus = in.readInt();
        this.viaRemainTime = in.readDouble();
        this.routeRemainLightCnt = in.readInt();
        this.viaRemainCnt = in.readInt();
    }

    public boolean isShowExitInfo() {
        return this.isShowExitInfo;
    }

    public void setShowExitInfo(boolean showExitInfo) {
        this.isShowExitInfo = showExitInfo;
    }

    public boolean isTightTurnShow() {
        return this.isTightTurnShow;
    }

    public void setTightTurnShow(boolean tightTurnShow) {
        this.isTightTurnShow = tightTurnShow;
    }

    public String getSegmentRemainDistDisplay() {
        return this.segmentRemainDistDisplay;
    }

    public void setSegmentRemainDistDisplay(String segmentRemainDistDisplay) {
        this.segmentRemainDistDisplay = segmentRemainDistDisplay;
    }

    public int getSegmentRemainDistUnitDisplay() {
        return this.segmentRemainDistUnitDisplay;
    }

    public void setSegmentRemainDistUnitDisplay(int segmentRemainDistUnitDisplay) {
        this.segmentRemainDistUnitDisplay = segmentRemainDistUnitDisplay;
    }

    public String getRouteRemainDistDisplay() {
        return this.routeRemainDistDisplay;
    }

    public void setRouteRemainDistDisplay(String routeRemainDistDisplay) {
        this.routeRemainDistDisplay = routeRemainDistDisplay;
    }

    public int getRouteRemainDistUnitDisplay() {
        return this.routeRemainDistUnitDisplay;
    }

    public void setRouteRemainDistUnitDisplay(int routeRemainDistUnitDisplay) {
        this.routeRemainDistUnitDisplay = routeRemainDistUnitDisplay;
    }

    public String getNextManeuverDistDisplay() {
        return this.nextManeuverDistDisplay;
    }

    public void setNextManeuverDistDisplay(String nextManeuverDistDisplay) {
        this.nextManeuverDistDisplay = nextManeuverDistDisplay;
    }

    public int getNextManeuverDistUnitDisplay() {
        return this.nextManeuverDistUnitDisplay;
    }

    public void setNextManeuverDistUnitDisplay(int nextManeuverDistUnitDisplay) {
        this.nextManeuverDistUnitDisplay = nextManeuverDistUnitDisplay;
    }

    public int getSegmentRemainProgress() {
        return this.segmentRemainProgress;
    }

    public void setSegmentRemainProgress(int segmentRemainProgress) {
        this.segmentRemainProgress = segmentRemainProgress;
    }

    public int getSegmentRemainDist() {
        return this.segmentRemainDist;
    }

    public void setSegmentRemainDist(int segmentRemainDist) {
        this.segmentRemainDist = segmentRemainDist;
    }

    public double getRouteRemainDist() {
        return this.routeRemainDist;
    }

    public void setRouteRemainDist(double routeRemainDist) {
        this.routeRemainDist = routeRemainDist;
    }

    public double getRouteRemainTime() {
        return this.routeRemainTime;
    }

    public void setRouteRemainTime(double routeRemainTime) {
        this.routeRemainTime = routeRemainTime;
    }

    public double getViaRemainTime() {
        return this.viaRemainTime;
    }

    public void setViaRemainTime(double viaRemainTime) {
        this.viaRemainTime = viaRemainTime;
    }

    public int getRouteRemainLightCnt() {
        return this.routeRemainLightCnt;
    }

    public void setRouteRemainLightCnt(int routeRemainLightCnt) {
        this.routeRemainLightCnt = routeRemainLightCnt;
    }

    public int getViaRemainCnt() {
        return this.viaRemainCnt;
    }

    public void setViaRemainCnt(int viaRemainCnt) {
        this.viaRemainCnt = viaRemainCnt;
    }

    public long getNextManeuverID() {
        return this.nextManeuverID;
    }

    public void setNextManeuverID(long nextManeuverID) {
        this.nextManeuverID = nextManeuverID;
    }

    public int getNextManeuverDist() {
        return this.nextManeuverDist;
    }

    public void setNextManeuverDist(int nextManeuverDist) {
        this.nextManeuverDist = nextManeuverDist;
    }

    public boolean getIsShowExitInfo() {
        return this.isShowExitInfo;
    }

    public void setIsShowExitInfo(boolean isShowExitInfo) {
        this.isShowExitInfo = isShowExitInfo;
    }

    public String getExitInfo() {
        return this.exitInfo;
    }

    public void setExitInfo(String exitInfo) {
        this.exitInfo = exitInfo;
    }

    public String getNextRouteName() {
        return this.nextRouteName;
    }

    public void setNextRouteName(String nextRouteName) {
        this.nextRouteName = nextRouteName;
    }

    public String getCurRouteName() {
        return this.curRouteName;
    }

    public void setCurRouteName(String curRouteName) {
        this.curRouteName = curRouteName;
    }

    public boolean getIsTightTurnShow() {
        return this.isTightTurnShow;
    }

    public void setIsTightTurnShow(boolean isTightTurnShow) {
        this.isTightTurnShow = isTightTurnShow;
    }

    public int getExitInfoType() {
        return this.exitInfoType;
    }

    public void setExitInfoType(int exitInfoType) {
        this.exitInfoType = exitInfoType;
    }

    public int getSmartStatus() {
        return this.smartStatus;
    }

    public void setSmartStatus(int smartStatus) {
        this.smartStatus = smartStatus;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.curRouteName);
        dest.writeString(this.nextRouteName);
        dest.writeByte(this.isShowExitInfo ? (byte) 1 : (byte) 0);
        dest.writeString(this.exitInfo);
        dest.writeInt(this.segmentRemainDist);
        dest.writeInt(this.segmentRemainProgress);
        dest.writeDouble(this.routeRemainDist);
        dest.writeDouble(this.routeRemainTime);
        dest.writeByte(this.isTightTurnShow ? (byte) 1 : (byte) 0);
        dest.writeLong(this.nextManeuverID);
        dest.writeInt(this.nextManeuverDist);
        dest.writeString(this.segmentRemainDistDisplay);
        dest.writeInt(this.segmentRemainDistUnitDisplay);
        dest.writeString(this.routeRemainDistDisplay);
        dest.writeInt(this.routeRemainDistUnitDisplay);
        dest.writeString(this.nextManeuverDistDisplay);
        dest.writeInt(this.nextManeuverDistUnitDisplay);
        dest.writeInt(this.exitInfoType);
        dest.writeInt(this.smartStatus);
        dest.writeDouble(this.viaRemainTime);
        dest.writeInt(this.routeRemainLightCnt);
        dest.writeInt(this.viaRemainCnt);
    }
}
