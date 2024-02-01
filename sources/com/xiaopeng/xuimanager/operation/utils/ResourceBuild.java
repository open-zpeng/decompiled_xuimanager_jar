package com.xiaopeng.xuimanager.operation.utils;

import com.xiaopeng.xuimanager.operation.DownloadStatusInfo;
import com.xiaopeng.xuimanager.operation.FailedInfo;
import com.xiaopeng.xuimanager.operation.OpenAction;
import com.xiaopeng.xuimanager.operation.OperationResource;
import com.xiaopeng.xuimanager.operation.internal.OperationConstants;
import com.xiaopeng.xuimanager.utils.LogUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ResourceBuild {
    private static final String TAG = "ResourceBuild##";

    public static JSONObject toJson(OperationResource resource) {
        JSONObject jsonObj = null;
        try {
            jsonObj = new JSONObject();
            jsonObj.put("id", resource.getId());
            jsonObj.put(OperationConstants.MetaData.KEY_NAME, resource.getResourceName());
            jsonObj.put(OperationConstants.MetaData.KEY_TYPE, resource.getResourceType());
            jsonObj.put(OperationConstants.MetaData.KEY_TARGET_PATH, resource.getTargetPath());
            jsonObj.put(OperationConstants.MetaData.KEY_RESOURCE_FROM, resource.getResourceFrom());
            jsonObj.put(OperationConstants.MetaData.KEY_DOWNLOAD_URL, resource.getDownloadUrl());
            jsonObj.put(OperationConstants.MetaData.KEY_EFFECT_TIME, resource.getEffectTime());
            jsonObj.put(OperationConstants.MetaData.KEY_EXPIRE_TIME, resource.getExpireTime());
            jsonObj.put("status", resource.getStatus());
            jsonObj.put(OperationConstants.MetaData.KEY_CREATE_TIME, resource.getCreateTime());
            jsonObj.put(OperationConstants.MetaData.KEY_UPDATE_TIME, resource.getUpdateTime());
            jsonObj.put(OperationConstants.MetaData.KEY_RESOURCE_ICON, resource.getResourceIcon());
            jsonObj.put(OperationConstants.MetaData.KEY_DESCRIPTION, resource.getDescription());
            jsonObj.put(OperationConstants.MetaData.KEY_PRICE, resource.getPrice());
            jsonObj.put(OperationConstants.MetaData.KEY_EXTRA_DATA, resource.getExtraData());
            return jsonObj;
        } catch (JSONException e) {
            LogUtil.e(TAG, "toJson:" + e.toString());
            return jsonObj;
        }
    }

    public static JSONObject toJsonWithDownloadParams(OperationResource resource, boolean useSystemTraffic, OpenAction openAction) {
        JSONObject jsonObject = toJson(resource);
        if (jsonObject != null) {
            try {
                jsonObject.put("useSystemTraffic", useSystemTraffic);
                if (openAction != null) {
                    jsonObject.put("openAction", openAction2Json(openAction));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jsonObject;
    }

    public static JSONArray toJsonArray(List<OperationResource> resourceList) {
        if (resourceList == null) {
            return null;
        }
        JSONArray objArray = new JSONArray();
        for (OperationResource resource : resourceList) {
            JSONObject obj = toJson(resource);
            if (obj != null) {
                objArray.put(obj);
            }
        }
        return objArray;
    }

    public static OperationResource fromJson(JSONObject obj) {
        OperationResource resource = null;
        try {
            resource = new OperationResource();
            resource.setId(obj.optString("id", ""));
            resource.setResourceType(obj.optInt(OperationConstants.MetaData.KEY_TYPE, -1));
            resource.setResourceName(obj.optString(OperationConstants.MetaData.KEY_NAME, ""));
            resource.setTargetPath(obj.optString(OperationConstants.MetaData.KEY_TARGET_PATH, ""));
            resource.setResourceFrom(obj.optString(OperationConstants.MetaData.KEY_RESOURCE_FROM, ""));
            resource.setDownloadUrl(obj.optString(OperationConstants.MetaData.KEY_DOWNLOAD_URL, ""));
            resource.setExpireTime(obj.optLong(OperationConstants.MetaData.KEY_EXPIRE_TIME, -1L));
            resource.setEffectTime(obj.optLong(OperationConstants.MetaData.KEY_EFFECT_TIME, -1L));
            resource.setStatus(obj.optInt("status", 0));
            resource.setCreateTime(obj.optLong(OperationConstants.MetaData.KEY_CREATE_TIME));
            resource.setUpdateTime(obj.optLong(OperationConstants.MetaData.KEY_UPDATE_TIME));
            resource.setResourceIcon(obj.optString(OperationConstants.MetaData.KEY_RESOURCE_ICON));
            resource.setDescription(obj.optString(OperationConstants.MetaData.KEY_DESCRIPTION));
            resource.setPrice(obj.optString(OperationConstants.MetaData.KEY_PRICE));
            resource.setExtraData(obj.optString(OperationConstants.MetaData.KEY_EXTRA_DATA, ""));
            return resource;
        } catch (Exception e) {
            LogUtil.e(TAG, "fromJson 2:" + e.toString());
            return resource;
        }
    }

    public static List<OperationResource> fromJsonArray(String arrayStr) {
        List<OperationResource> resourceList = new ArrayList<>();
        try {
            JSONArray objArray = new JSONArray(arrayStr);
            if (objArray.length() > 0) {
                for (int i = 0; i < objArray.length(); i++) {
                    OperationResource resource = fromJson(objArray.getJSONObject(i));
                    if (resource != null) {
                        resourceList.add(resource);
                    }
                }
            }
        } catch (JSONException e) {
            LogUtil.e(TAG, "fromJsonArray:" + e.toString());
        }
        return resourceList;
    }

    public static JSONObject toJson(DownloadStatusInfo downloadStatusInfo) {
        JSONObject jsonObj = null;
        try {
            jsonObj = new JSONObject();
            jsonObj.put("id", downloadStatusInfo.getResourceId());
            jsonObj.put(OperationConstants.MetaData.KEY_NAME, downloadStatusInfo.getResourceName());
            jsonObj.put(OperationConstants.MetaData.KEY_TYPE, downloadStatusInfo.getResourceType());
            jsonObj.put(OperationConstants.MetaData.KEY_PROGRESS, downloadStatusInfo.getProgress());
            jsonObj.put(OperationConstants.MetaData.KEY_DOWNLOAD_STATUS, downloadStatusInfo.getState());
            jsonObj.put("extraInfo", downloadStatusInfo.getExtraInfo());
            return jsonObj;
        } catch (JSONException e) {
            LogUtil.e(TAG, "toJson:" + e.toString());
            return jsonObj;
        }
    }

    public static JSONArray toDownloadInfoJsonArray(List<DownloadStatusInfo> infoList) {
        JSONArray jsonArray = new JSONArray();
        for (DownloadStatusInfo downloadStatusInfo : infoList) {
            jsonArray.put(toJson(downloadStatusInfo));
        }
        return jsonArray;
    }

    public static DownloadStatusInfo toDownloadStatusInfo(String content) {
        try {
            JSONObject obj = new JSONObject(content);
            DownloadStatusInfo statusInfo = toDownloadStatusInfo(obj);
            return statusInfo;
        } catch (Exception e) {
            LogUtil.e(TAG, "fromJson 2:" + e.toString());
            return null;
        }
    }

    public static JSONObject toJson(FailedInfo failedInfo) {
        JSONObject jsonObj = null;
        try {
            jsonObj = new JSONObject();
            jsonObj.put("id", failedInfo.getResourceId());
            jsonObj.put(OperationConstants.MetaData.KEY_NAME, failedInfo.getResourceName());
            jsonObj.put(OperationConstants.MetaData.KEY_TYPE, failedInfo.getResourceType());
            jsonObj.put(OperationConstants.MetaData.KEY_FAILED_REASON, failedInfo.getFailedReason());
            return jsonObj;
        } catch (JSONException e) {
            LogUtil.e(TAG, "toJson:" + e.toString());
            return jsonObj;
        }
    }

    public static FailedInfo toFailedInfo(String content) {
        FailedInfo failedInfo = null;
        try {
            JSONObject obj = new JSONObject(content);
            failedInfo = new FailedInfo();
            failedInfo.setResourceId(obj.optString("id", ""));
            failedInfo.setResourceType(obj.optInt(OperationConstants.MetaData.KEY_TYPE, -1));
            failedInfo.setResourceName(obj.optString(OperationConstants.MetaData.KEY_NAME, ""));
            failedInfo.setFailedReason(obj.optString(OperationConstants.MetaData.KEY_FAILED_REASON, FailedInfo.DISK_NO_SPACE));
            return failedInfo;
        } catch (Exception e) {
            LogUtil.e(TAG, "fromJson 2:" + e.toString());
            return failedInfo;
        }
    }

    public static List<DownloadStatusInfo> toDownloadStatusList(String content) {
        List<DownloadStatusInfo> list = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(content);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                DownloadStatusInfo info = toDownloadStatusInfo(jsonObject);
                if (info != null) {
                    list.add(info);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static DownloadStatusInfo toDownloadStatusInfo(JSONObject jsonObject) {
        DownloadStatusInfo info = null;
        try {
            info = new DownloadStatusInfo();
            info.setResourceId(jsonObject.optString("id", ""));
            info.setResourceType(jsonObject.optInt(OperationConstants.MetaData.KEY_TYPE, -1));
            info.setResourceName(jsonObject.optString(OperationConstants.MetaData.KEY_NAME, ""));
            info.setProgress((float) jsonObject.optDouble(OperationConstants.MetaData.KEY_PROGRESS, 0.0d));
            info.setState(jsonObject.optInt(OperationConstants.MetaData.KEY_DOWNLOAD_STATUS, 0));
            info.setExtraInfo(jsonObject.optString("extraInfo", ""));
            return info;
        } catch (Exception e) {
            LogUtil.e(TAG, "fromJson 2:" + e.toString());
            return info;
        }
    }

    public static String getLegacyEventInfo(OperationResource resource) {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", resource.getId());
            jsonObject.put(OperationConstants.Legacy.KEY_TYPE, resource.getResourceType());
            JSONObject content = new JSONObject();
            try {
                JSONObject extraObject = new JSONObject(resource.getExtraData());
                content = extraObject.getJSONObject(OperationConstants.Legacy.KEY_EXTRA_INFO);
            } catch (Exception e) {
                LogUtil.w(TAG, "getLegacyEventInfo error:" + e.getMessage());
            }
            jsonObject.put(OperationConstants.Legacy.KEY_CONTENT, content);
            return jsonObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static OpenAction json2OpenAction(JSONObject jsonObject) {
        try {
            int openActionType = jsonObject.getInt("openActionType");
            String openActionComponent = jsonObject.getString("openActionComponent");
            if (openActionType == 0) {
                return OpenAction.activity(openActionComponent);
            }
            if (openActionType == 1) {
                return OpenAction.service(openActionComponent);
            }
            if (openActionType == 2) {
                return OpenAction.broadcast(openActionComponent);
            }
            return null;
        } catch (JSONException e) {
            LogUtil.e(TAG, "json2OpenAction:" + e.toString());
            return null;
        }
    }

    public static JSONObject openAction2Json(OpenAction openAction) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("openActionType", openAction.openActionType);
            jsonObject.put("openActionComponent", openAction.openActionComponent);
        } catch (Exception e) {
            LogUtil.e(TAG, "openAction2Json:" + e.toString());
        }
        return jsonObject;
    }
}
