package com.xiaopeng.xuimanager.systemui.dock;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class DockItem implements Parcelable {
    public static final Parcelable.Creator<DockItem> CREATOR = new Parcelable.Creator<DockItem>() { // from class: com.xiaopeng.xuimanager.systemui.dock.DockItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DockItem createFromParcel(Parcel in) {
            return new DockItem(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DockItem[] newArray(int size) {
            return new DockItem[size];
        }
    };
    private static final String TAG = "DockItem";
    public static final int TYPE_APP = 1000;
    public static final int TYPE_SHORTCUT = 3000;
    public static final int TYPE_WIDGET = 2000;
    private boolean canDelete;
    private int cellX;
    private Bundle extras;
    private Bitmap icon;
    private int id;
    private Intent intent;
    private int itemType;
    private String pkgName;
    private int spanX;
    private int swapLimit;
    private String title;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Type {
    }

    public DockItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @SuppressLint({"NewApi"})
    protected DockItem(Parcel in) {
        this.id = in.readInt();
        this.itemType = in.readInt();
        this.cellX = in.readInt();
        this.spanX = in.readInt();
        this.title = in.readString();
        this.pkgName = in.readString();
        this.canDelete = in.readBoolean();
        this.swapLimit = in.readInt();
        if (in.readInt() != 0) {
            this.icon = (Bitmap) Bitmap.CREATOR.createFromParcel(in);
        }
        if (in.readInt() != 0) {
            this.intent = (Intent) Intent.CREATOR.createFromParcel(in);
        }
        if (in.readInt() != 0) {
            this.extras = (Bundle) Bundle.CREATOR.createFromParcel(in);
        }
    }

    @Override // android.os.Parcelable
    @SuppressLint({"NewApi"})
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.itemType);
        dest.writeInt(this.cellX);
        dest.writeInt(this.spanX);
        dest.writeString(this.title);
        dest.writeString(this.pkgName);
        dest.writeBoolean(this.canDelete);
        dest.writeInt(this.swapLimit);
        if (this.icon != null) {
            dest.writeInt(1);
            this.icon.writeToParcel(dest, flags);
        } else {
            dest.writeInt(0);
        }
        if (this.intent != null) {
            dest.writeInt(1);
            this.intent.writeToParcel(dest, flags);
        } else {
            dest.writeInt(0);
        }
        if (this.extras != null) {
            dest.writeInt(1);
            this.extras.writeToParcel(dest, flags);
            return;
        }
        dest.writeInt(0);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemType() {
        return this.itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public int getCellX() {
        return this.cellX;
    }

    public void setCellX(int cellX) {
        this.cellX = cellX;
    }

    public int getSpanX() {
        return this.spanX;
    }

    public void setSpanX(int spanX) {
        this.spanX = spanX;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Bitmap getIcon() {
        return this.icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public void setPkgName(String pkgName) {
        this.pkgName = pkgName;
    }

    public boolean isCanDelete() {
        return this.canDelete;
    }

    public void setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
    }

    public int getSwapLimit() {
        return this.swapLimit;
    }

    public void setSwapLimit(int swapLimit) {
        this.swapLimit = swapLimit;
    }

    public Intent getIntent() {
        return this.intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public String toString() {
        return "DockItem{id=" + this.id + ", itemType=" + this.itemType + ", cellX=" + this.cellX + ", spanX=" + this.spanX + ", title='" + this.title + "', icon=" + this.icon + ", pkgName='" + this.pkgName + "', canDelete=" + this.canDelete + ", swapLimit=" + this.swapLimit + ", intent=" + this.intent + ", extras=" + this.extras + '}';
    }
}
