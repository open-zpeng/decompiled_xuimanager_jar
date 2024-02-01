package com.xiaopeng.xuimanager.contextinfo;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* loaded from: classes.dex */
public class Sapa implements Parcelable {
    public static final Parcelable.Creator<Sapa> CREATOR = new Parcelable.Creator<Sapa>() { // from class: com.xiaopeng.xuimanager.contextinfo.Sapa.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Sapa createFromParcel(Parcel source) {
            return new Sapa(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Sapa[] newArray(int size) {
            return new Sapa[size];
        }
    };
    private boolean isSapaShow;
    private List<SapaInfo> sapaInfo;

    public Sapa() {
    }

    protected Sapa(Parcel in) {
        this.sapaInfo = in.createTypedArrayList(SapaInfo.CREATOR);
        this.isSapaShow = in.readByte() != 0;
    }

    public List<SapaInfo> getSapaInfo() {
        return this.sapaInfo;
    }

    public void setSapaInfo(List<SapaInfo> sapaInfo) {
        this.sapaInfo = sapaInfo;
    }

    public boolean getIsSapaShow() {
        return this.isSapaShow;
    }

    public void setIsSapaShow(boolean isSapaShow) {
        this.isSapaShow = isSapaShow;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.sapaInfo);
        dest.writeByte(this.isSapaShow ? (byte) 1 : (byte) 0);
    }
}
