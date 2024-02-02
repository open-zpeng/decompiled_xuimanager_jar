package com.xiaopeng.xuimanager.themeoperation;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class AbilityEffect implements Parcelable {
    public static final Parcelable.Creator<AbilityEffect> CREATOR = new Parcelable.Creator<AbilityEffect>() { // from class: com.xiaopeng.xuimanager.themeoperation.AbilityEffect.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AbilityEffect createFromParcel(Parcel in) {
            return new AbilityEffect(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AbilityEffect[] newArray(int size) {
            return new AbilityEffect[size];
        }
    };
    private String mEffectAbilityType;
    private String mEffectBelongType;
    private String mEffectId;
    private String mFriendlyName;
    private AbilityEffect[] mLinkEffects;
    private String mParam;
    private int mPropertyType;

    public AbilityEffect() {
    }

    public AbilityEffect(int propertyType, String friendlyName, String abiliyType, String belongType, String effectId) {
        this.mPropertyType = propertyType;
        this.mFriendlyName = friendlyName;
        this.mEffectAbilityType = abiliyType;
        this.mEffectBelongType = belongType;
        this.mEffectId = effectId;
    }

    protected AbilityEffect(Parcel in) {
        this.mPropertyType = in.readInt();
        this.mFriendlyName = in.readString();
        this.mEffectId = in.readString();
        this.mEffectAbilityType = in.readString();
        this.mEffectBelongType = in.readString();
        this.mParam = in.readString();
        this.mLinkEffects = (AbilityEffect[]) in.createTypedArray(CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mPropertyType);
        dest.writeString(this.mFriendlyName);
        dest.writeString(this.mEffectId);
        dest.writeString(this.mEffectAbilityType);
        dest.writeString(this.mEffectBelongType);
        dest.writeString(this.mParam);
        dest.writeTypedArray(this.mLinkEffects, flags);
    }

    public void setPropertyType(int type) {
        this.mPropertyType = type;
    }

    public int getPropertyType() {
        return this.mPropertyType;
    }

    public void setFriendlyName(String name) {
        this.mFriendlyName = name;
    }

    public String getFriendlyName() {
        return this.mFriendlyName;
    }

    public void setEffectAbilityType(String value) {
        this.mEffectAbilityType = value;
    }

    public String getEffectAbilityType() {
        return this.mEffectAbilityType;
    }

    public void setEffectId(String id) {
        this.mEffectId = id;
    }

    public String getEffectId() {
        return this.mEffectId;
    }

    public void setParam(String param) {
        this.mParam = param;
    }

    public String getParam() {
        return this.mParam;
    }

    public String toString() {
        return "AbilityEffect[propertyType:" + this.mPropertyType + ",friendName:" + this.mFriendlyName + ",abilityType:" + this.mEffectAbilityType + ",id:" + this.mEffectId + "]";
    }
}
