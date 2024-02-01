package com.xiaopeng.xuimanager.iot.utils;

import android.util.Log;
import com.xiaopeng.xuimanager.iot.BaseDevice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class DeviceBuilder {
    public static final String FIELD_DEVICE_CLASS = "device_class";
    public static final String FIELD_DEVICE_ID = "device_id";
    public static final String FIELD_DEVICE_NAME = "device_name";
    public static final String FIELD_DEVICE_PROPERTY = "device_property";
    public static final String FIELD_DEVICE_TYPE = "device_type";
    private static final String TAG = "DeviceBuilder##";

    public static JSONObject toJson(BaseDevice device) {
        JSONObject jsonObj = null;
        try {
            jsonObj = new JSONObject();
            jsonObj.put(FIELD_DEVICE_NAME, device.getDeviceName());
            jsonObj.put(FIELD_DEVICE_ID, device.getDeviceId());
            jsonObj.put(FIELD_DEVICE_TYPE, device.getDeviceType());
            jsonObj.put(FIELD_DEVICE_CLASS, device.getDeviceClass());
            Map<String, String> propMap = device.getPropertyMap();
            if (propMap != null) {
                jsonObj.put(FIELD_DEVICE_PROPERTY, propToJson(propMap).toString());
            } else {
                jsonObj.put(FIELD_DEVICE_PROPERTY, (Object) null);
            }
        } catch (JSONException e) {
            Log.e(TAG, "toJson:" + e.toString());
        }
        return jsonObj;
    }

    public static JSONObject propToJson(BaseDevice device) {
        JSONObject jsonObj = null;
        try {
            jsonObj = new JSONObject();
            Map<String, String> propMap = device.getPropertyMap();
            if (propMap != null) {
                for (Map.Entry<String, String> entry : propMap.entrySet()) {
                    jsonObj.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (JSONException e) {
            Log.e(TAG, "propToJson by device:" + e.toString());
        }
        return jsonObj;
    }

    public static JSONObject propToJson(Map<String, String> propMap) {
        JSONObject jsonObj = null;
        try {
            jsonObj = new JSONObject();
            if (propMap != null) {
                for (Map.Entry<String, String> entry : propMap.entrySet()) {
                    jsonObj.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (JSONException e) {
            Log.e(TAG, "propToJson by map:" + e.toString());
        }
        return jsonObj;
    }

    public static JSONArray toJsonArray(List<BaseDevice> deviceList) {
        if (deviceList == null) {
            return null;
        }
        JSONArray objArray = new JSONArray();
        for (BaseDevice device : deviceList) {
            JSONObject obj = toJson(device);
            if (obj != null) {
                objArray.put(obj);
            }
        }
        return objArray;
    }

    public static Map<String, String> jsonStrToPropMap(String jsonStr) {
        Map<String, String> propMap = null;
        try {
            JSONObject jsonObject = new JSONObject(jsonStr);
            propMap = new HashMap<>();
            Iterator<String> keyIter = jsonObject.keys();
            while (keyIter.hasNext()) {
                String key = keyIter.next();
                String value = jsonObject.getString(key);
                propMap.put(key, value);
            }
        } catch (JSONException e) {
            Log.e(TAG, "jsonStrToPropMap:" + e.toString());
        }
        return propMap;
    }

    public static BaseDevice fromJson(JSONObject obj) {
        Map<String, String> propMap;
        BaseDevice device = null;
        try {
            String deviceClass = obj.getString(FIELD_DEVICE_CLASS);
            device = (BaseDevice) Class.forName(deviceClass).newInstance();
            device.setDeviceName(obj.getString(FIELD_DEVICE_NAME)).setDeviceId(obj.getString(FIELD_DEVICE_ID)).setDeviceType(obj.getString(FIELD_DEVICE_TYPE));
            try {
                String propJson = obj.getString(FIELD_DEVICE_PROPERTY);
                if (propJson != null && (propMap = jsonStrToPropMap(propJson)) != null) {
                    device.setPropertyMap(propMap);
                }
            } catch (JSONException eJson) {
                Log.e(TAG, "fromJson 1:" + eJson.toString());
            }
        } catch (Exception e) {
            Log.e(TAG, "fromJson 2:" + e.toString());
        }
        return device;
    }

    public static List<BaseDevice> fromJsonArray(String arrayStr) {
        List<BaseDevice> deviceList = null;
        try {
            JSONArray objArray = new JSONArray(arrayStr);
            if (objArray.length() > 0) {
                for (int i = 0; i < objArray.length(); i++) {
                    BaseDevice device = fromJson(objArray.getJSONObject(i));
                    if (device != null) {
                        if (deviceList == null) {
                            deviceList = new ArrayList<>();
                        }
                        deviceList.add(device);
                    }
                }
            }
        } catch (JSONException e) {
            Log.e(TAG, "fromJsonArray:" + e.toString());
        }
        return deviceList;
    }
}
