package com.xiaopeng.xuimanager.ambient;

import android.util.Log;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AmbientData {
    private int bright;
    private List<Integer> colors;
    private int fade;
    private List<Integer> groups;
    private int period;

    public AmbientData(int group, int color, int bright, int fade, int period) {
        this.groups = Collections.singletonList(Integer.valueOf(group));
        this.colors = Collections.singletonList(Integer.valueOf(color));
        this.bright = bright;
        this.fade = fade;
        this.period = period;
    }

    public AmbientData(int[] groups, int[] colors, int bright, int fade, int period) {
        this.groups = (List) Arrays.stream(groups).boxed().collect(Collectors.toList());
        this.colors = (List) Arrays.stream(colors).boxed().collect(Collectors.toList());
        this.bright = bright;
        this.fade = fade;
        this.period = period;
    }

    public JSONObject toJsonObject() {
        JSONObject obj = new JSONObject();
        try {
            obj.put("groups", new JSONArray((Collection) this.groups));
            obj.put("colors", new JSONArray((Collection) this.colors));
            obj.put("bright", this.bright);
            obj.put("fade", this.fade);
            obj.put("period", this.period);
        } catch (Exception e) {
            Log.e("AmbientData", "serialize exception " + e);
        }
        return obj;
    }
}
