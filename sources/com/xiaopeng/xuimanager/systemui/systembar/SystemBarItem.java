package com.xiaopeng.xuimanager.systemui.systembar;

import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class SystemBarItem implements Parcelable {
    public static final Parcelable.Creator<SystemBarItem> CREATOR = new Parcelable.Creator<SystemBarItem>() { // from class: com.xiaopeng.xuimanager.systemui.systembar.SystemBarItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SystemBarItem createFromParcel(Parcel in) {
            return new SystemBarItem(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SystemBarItem[] newArray(int size) {
            return new SystemBarItem[size];
        }
    };
    public static final int ICON_PERSONAL = 100;
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_PERSONAL = 100;
    private int barType;
    private Bundle extras;
    private int flags;
    private int iconKey;
    private int screenId;
    private Icon smallIcon;
    private String title;
    private int type;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface IconKey {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Type {
    }

    public SystemBarItem() {
        this.extras = new Bundle();
    }

    protected SystemBarItem(Parcel in) {
        this.extras = new Bundle();
        this.barType = in.readInt();
        this.screenId = in.readInt();
        this.type = in.readInt();
        this.smallIcon = (Icon) in.readParcelable(Icon.class.getClassLoader());
        this.iconKey = in.readInt();
        this.title = in.readString();
        this.flags = in.readInt();
        this.extras = in.readBundle(getClass().getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.barType);
        dest.writeInt(this.screenId);
        dest.writeInt(this.type);
        dest.writeParcelable(this.smallIcon, flags);
        dest.writeInt(this.iconKey);
        dest.writeString(this.title);
        dest.writeInt(flags);
        dest.writeBundle(this.extras);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBarType() {
        return this.barType;
    }

    public int getScreenId() {
        return this.screenId;
    }

    public int getType() {
        return this.type;
    }

    public Icon getSmallIcon() {
        return this.smallIcon;
    }

    public int getIconKey() {
        return this.iconKey;
    }

    public CharSequence getTitle() {
        return this.title;
    }

    public int getFlags() {
        return this.flags;
    }

    public Bundle getExtras() {
        return this.extras;
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private SystemBarItem mBarItem = new SystemBarItem();
        private final Context mContext;

        public Builder(Context context) {
            this.mContext = context;
        }

        public Builder setBarType(int barType) {
            this.mBarItem.barType = barType;
            return this;
        }

        public Builder setScreenId(int screenId) {
            this.mBarItem.screenId = screenId;
            return this;
        }

        public Builder setType(int type) {
            this.mBarItem.type = type;
            return this;
        }

        public Builder setBarSmallIcon(int smallIcon) {
            Icon icon;
            if (smallIcon != 0) {
                icon = Icon.createWithResource(this.mContext, smallIcon);
            } else {
                icon = null;
            }
            return setSmallIcon(icon);
        }

        public Builder setSmallIcon(Icon icon) {
            this.mBarItem.smallIcon = icon;
            return this;
        }

        public Builder setTitle(String title) {
            this.mBarItem.title = title;
            return this;
        }

        public Builder setFlags(int flags) {
            this.mBarItem.flags = flags;
            return this;
        }

        public Builder setIconKey(int iconKey) {
            this.mBarItem.iconKey = iconKey;
            return this;
        }

        public Builder setExtras(Bundle extras) {
            this.mBarItem.extras = extras;
            return this;
        }

        public Bundle getExtras() {
            return this.mBarItem.extras;
        }

        public SystemBarItem build() {
            return this.mBarItem;
        }
    }

    public String toString() {
        return "SystemBarItem{barType=" + this.barType + ", screenId=" + this.screenId + ", type=" + this.type + ", smallIcon=" + this.smallIcon + ", iconKey=" + this.iconKey + ", title=" + this.title + ", flags=" + this.flags + ", extras=" + this.extras + '}';
    }
}
