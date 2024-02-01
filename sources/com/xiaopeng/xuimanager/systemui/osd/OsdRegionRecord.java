package com.xiaopeng.xuimanager.systemui.osd;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* loaded from: classes.dex */
public class OsdRegionRecord implements Parcelable {
    public static final Parcelable.Creator<OsdRegionRecord> CREATOR = new Parcelable.Creator<OsdRegionRecord>() { // from class: com.xiaopeng.xuimanager.systemui.osd.OsdRegionRecord.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OsdRegionRecord createFromParcel(Parcel in) {
            return new OsdRegionRecord(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OsdRegionRecord[] newArray(int size) {
            return new OsdRegionRecord[size];
        }
    };
    private int maxHeight;
    private int maxWidth;
    private int minHeight;
    private int minWidth;
    private String regionId;
    private int screenId;
    private int windowType;
    private int x;
    private int y;

    public OsdRegionRecord() {
    }

    protected OsdRegionRecord(Parcel in) {
        this.regionId = in.readString();
        this.x = in.readInt();
        this.y = in.readInt();
        this.minWidth = in.readInt();
        this.minHeight = in.readInt();
        this.maxWidth = in.readInt();
        this.maxHeight = in.readInt();
        this.screenId = in.readInt();
        this.windowType = in.readInt();
    }

    public String getRegionId() {
        return this.regionId;
    }

    public void setRegionId(String areaId) {
        this.regionId = areaId;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getMinWidth() {
        return this.minWidth;
    }

    public void setMinWidth(int minWidth) {
        this.minWidth = minWidth;
    }

    public int getMinHeight() {
        return this.minHeight;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }

    public int getMaxHeight() {
        return this.maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public int getScreenId() {
        return this.screenId;
    }

    public int getWindowType() {
        return this.windowType;
    }

    public void setWindowType(int windowType) {
        this.windowType = windowType;
    }

    public void setScreenId(String screenId) {
        if (Objects.equals(screenId, "ID_SHARED_PRIMARY")) {
            this.screenId = 1;
        } else if (Objects.equals(screenId, "ID_SHARED_SECONDARY")) {
            this.screenId = 2;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.regionId);
        parcel.writeInt(this.x);
        parcel.writeInt(this.y);
        parcel.writeInt(this.minWidth);
        parcel.writeInt(this.minHeight);
        parcel.writeInt(this.maxWidth);
        parcel.writeInt(this.maxHeight);
        parcel.writeInt(this.screenId);
        parcel.writeInt(this.windowType);
    }
}
