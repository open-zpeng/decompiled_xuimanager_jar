package com.xiaopeng.xuimanager.xapp;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes.dex */
public class MiniProgramGroup implements Parcelable {
    public static final Parcelable.Creator<MiniProgramGroup> CREATOR = new Parcelable.Creator<MiniProgramGroup>() { // from class: com.xiaopeng.xuimanager.xapp.MiniProgramGroup.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MiniProgramGroup createFromParcel(Parcel in) {
            return new MiniProgramGroup(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MiniProgramGroup[] newArray(int size) {
            return new MiniProgramGroup[size];
        }
    };
    private int mContentType;
    private List<MiniProgramData> mData;
    private String mGroupName;
    public String mId;

    public MiniProgramGroup() {
    }

    protected MiniProgramGroup(Parcel in) {
        this.mId = in.readStringNoHelper();
        this.mGroupName = in.readStringNoHelper();
        this.mContentType = in.readInt();
        this.mData = in.createTypedArrayList(MiniProgramData.CREATOR);
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String id) {
        this.mId = id;
    }

    public String getGroupName() {
        return this.mGroupName;
    }

    public void setGroupName(String groupName) {
        this.mGroupName = groupName;
    }

    public int getContentType() {
        return this.mContentType;
    }

    public void setContentType(int contentType) {
        this.mContentType = contentType;
    }

    public List<MiniProgramData> getData() {
        return this.mData;
    }

    public void setData(List<MiniProgramData> data) {
        this.mData = data;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringNoHelper(this.mId);
        dest.writeStringNoHelper(this.mGroupName);
        dest.writeInt(this.mContentType);
        dest.writeTypedList(this.mData);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "MiniProgramGroup{mGroupName=" + this.mGroupName + ", mContentType='" + this.mContentType + "', mId=" + this.mId + '}';
    }
}
