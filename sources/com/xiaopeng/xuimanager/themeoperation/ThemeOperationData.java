package com.xiaopeng.xuimanager.themeoperation;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.ArrayMap;
import com.xiaopeng.xuimanager.operation.OperationResource;
import java.util.Map;

/* loaded from: classes.dex */
public class ThemeOperationData extends OperationResource implements Parcelable {
    public static final Parcelable.Creator<ThemeOperationData> CREATOR = new Parcelable.Creator<ThemeOperationData>() { // from class: com.xiaopeng.xuimanager.themeoperation.ThemeOperationData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ThemeOperationData createFromParcel(Parcel in) {
            return new ThemeOperationData(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ThemeOperationData[] newArray(int size) {
            return new ThemeOperationData[size];
        }
    };
    private String friendlyName;
    private String innerName;
    private boolean mActive;
    private ArrayMap<String, AbilityEffect> mActiveEffectMap;
    private boolean mCanUpdate;
    private ArrayMap<String, AbilityEffect[]> mEffectMap;
    private int resStorageType;
    private String themePath;

    protected ThemeOperationData(Parcel in) {
        this.themePath = null;
        this.resStorageType = in.readInt();
        this.friendlyName = in.readString();
        this.innerName = in.readString();
        this.themePath = in.readString();
        this.mActive = in.readByte() != 0;
        this.mCanUpdate = in.readByte() != 0;
        setId(in.readString());
        setResourceType(in.readInt());
        setResourceName(in.readString());
        setResourceFrom(in.readString());
        setTargetPath(in.readString());
        setDownloadUrl(in.readString());
        setEffectTime(in.readLong());
        setExpireTime(in.readLong());
        setExtraData(in.readString());
        this.mEffectMap = new ArrayMap<>();
        in.readMap(this.mEffectMap, AbilityEffect.class.getClassLoader());
        this.mActiveEffectMap = new ArrayMap<>();
        in.readMap(this.mActiveEffectMap, AbilityEffect.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.resStorageType);
        dest.writeString(this.friendlyName);
        dest.writeString(this.innerName);
        dest.writeString(this.themePath);
        dest.writeByte(this.mActive ? (byte) 1 : (byte) 0);
        dest.writeByte(this.mCanUpdate ? (byte) 1 : (byte) 0);
        dest.writeString(getId());
        dest.writeInt(getResourceType());
        dest.writeString(getResourceName());
        dest.writeString(getResourceFrom());
        dest.writeString(getTargetPath());
        dest.writeString(getDownloadUrl());
        dest.writeLong(getEffectTime());
        dest.writeLong(getExpireTime());
        dest.writeString(getExtraData());
        dest.writeMap(this.mEffectMap);
        dest.writeMap(this.mActiveEffectMap);
    }

    public ThemeOperationData() {
        this.themePath = null;
    }

    public void setFriendlyName(String name) {
        this.friendlyName = name;
    }

    public String getFriendlyName() {
        return this.friendlyName;
    }

    public void setActive(boolean flag) {
        this.mActive = flag;
    }

    public boolean isActive() {
        return this.mActive;
    }

    public void setResStorageType(int type) {
        this.resStorageType = type;
    }

    public int getResStorageType() {
        return this.resStorageType;
    }

    public void setUpdateFlag(boolean flag) {
        this.mCanUpdate = flag;
    }

    public boolean getUpdateFlag() {
        return this.mCanUpdate;
    }

    public void setActiveEffectMap(ArrayMap<String, AbilityEffect> map) {
        this.mActiveEffectMap = map;
    }

    public ArrayMap<String, AbilityEffect> getActiveEffectMap() {
        return this.mActiveEffectMap;
    }

    public void setEffectMap(ArrayMap<String, AbilityEffect[]> map) {
        this.mEffectMap = map;
    }

    public ArrayMap<String, AbilityEffect[]> getEffectMap() {
        return this.mEffectMap;
    }

    public void setInnerName(String name) {
        this.innerName = name;
    }

    public String getInnerName() {
        return this.innerName;
    }

    public void setThemePath(String path) {
        this.themePath = path;
    }

    public String getThemePath() {
        return this.themePath;
    }

    @Override // com.xiaopeng.xuimanager.operation.OperationResource
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ThemeOperationData[friendlyName:");
        sb.append(this.friendlyName);
        sb.append(",innerName:");
        sb.append(this.innerName);
        sb.append(",id:");
        sb.append(getId());
        sb.append(",update:");
        sb.append(this.mCanUpdate);
        sb.append(",storageType:");
        sb.append(this.resStorageType);
        sb.append(",active:" + this.mActive);
        sb.append(",activeEffects:");
        sb.append(getMapContents(this.mActiveEffectMap));
        sb.append("]");
        return sb.toString();
    }

    private String getMapContents(ArrayMap<String, AbilityEffect> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, AbilityEffect> entry : map.entrySet()) {
                sb.append(entry.getKey());
                sb.append("-");
                sb.append(entry.getValue().toString());
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
