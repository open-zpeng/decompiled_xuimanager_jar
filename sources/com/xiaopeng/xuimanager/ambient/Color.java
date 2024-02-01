package com.xiaopeng.xuimanager.ambient;

/* loaded from: classes.dex */
public class Color {
    public boolean hasRgb;
    public int predef;
    public Rgb rgb;

    public Color(int predef) {
        this.hasRgb = false;
        this.predef = -1;
        this.rgb = null;
        this.predef = predef;
    }

    public Color(int red, int green, int blue) {
        this.hasRgb = false;
        this.predef = -1;
        this.rgb = null;
        this.hasRgb = true;
        this.rgb = new Rgb(red, green, blue);
    }

    public Color(boolean hasRgb, String hex) {
        this.hasRgb = false;
        this.predef = -1;
        this.rgb = null;
        this.hasRgb = hasRgb;
        if (hasRgb) {
            this.rgb = new Rgb(hex);
        } else {
            this.predef = Integer.valueOf(hex, 16).intValue();
        }
    }

    public String toHexString() {
        return this.hasRgb ? this.rgb.toHexString() : Integer.toHexString(this.predef);
    }
}
