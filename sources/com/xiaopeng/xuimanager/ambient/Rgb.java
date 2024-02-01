package com.xiaopeng.xuimanager.ambient;

/* loaded from: classes.dex */
public class Rgb {
    public int blue;
    public int green;
    public int red;

    public Rgb(int red, int green, int blue) {
        this.red = red & 255;
        this.green = green & 255;
        this.blue = blue & 255;
    }

    public Rgb(String hex) {
        int rgb = Integer.valueOf(hex, 16).intValue();
        this.red = (rgb >> 16) & 255;
        this.green = (rgb >> 8) & 255;
        this.blue = rgb & 255;
    }

    public String toHexString() {
        return String.format("%06x", Integer.valueOf((this.red << 16) | (this.green << 8) | this.blue));
    }
}
