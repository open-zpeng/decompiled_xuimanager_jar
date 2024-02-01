package com.xiaopeng.xuimanager.mediacenter.utils;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ParamsBuild {
    private static final String KEY_DISPLAY_ID = "displayId";

    public static int getDisplayId(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            int displayId = jsonObject.optInt(KEY_DISPLAY_ID, 0);
            return displayId;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getDisplayIdParams(int displayId) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.putOpt(KEY_DISPLAY_ID, Integer.valueOf(displayId));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
