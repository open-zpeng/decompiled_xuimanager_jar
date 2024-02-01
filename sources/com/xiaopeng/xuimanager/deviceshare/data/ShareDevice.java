package com.xiaopeng.xuimanager.deviceshare.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaopeng.xuimanager.utils.LogUtil;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ShareDevice implements Parcelable {
    private int connectStatus;
    private String deviceId;
    private String deviceMac;
    private String deviceName;
    private long lastConnectTime;
    private int lastProtocolType;
    private static final String TAG = ShareDevice.class.getSimpleName();
    public static final Parcelable.Creator<ShareDevice> CREATOR = new Parcelable.Creator<ShareDevice>() { // from class: com.xiaopeng.xuimanager.deviceshare.data.ShareDevice.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareDevice createFromParcel(Parcel in) {
            return new ShareDevice(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareDevice[] newArray(int size) {
            return new ShareDevice[size];
        }
    };

    public ShareDevice() {
        this.lastConnectTime = 0L;
        this.lastProtocolType = -1;
        this.connectStatus = -1;
    }

    public void setDeviceId(String val) {
        this.deviceId = val;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceName(String val) {
        this.deviceName = val;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public void setDeviceMac(String val) {
        this.deviceMac = val;
    }

    public String getDeviceMac() {
        return this.deviceMac;
    }

    public void setLastConnectTime(long val) {
        this.lastConnectTime = val;
    }

    public long getLastConnectTime() {
        return this.lastConnectTime;
    }

    public void setLastProtocolType(int type) {
        this.lastProtocolType = type;
    }

    public int getLastProtocolType() {
        return this.lastProtocolType;
    }

    public ShareDevice(Parcel in) {
        this.deviceId = in.readString();
        this.deviceName = in.readString();
        this.deviceMac = in.readString();
        this.lastConnectTime = in.readLong();
        this.lastProtocolType = in.readInt();
        this.connectStatus = in.readInt();
    }

    public static ShareDevice buildFromJsonStr(String jsonStr) {
        try {
            JSONObject obj = new JSONObject(jsonStr);
            return buildFromJson(obj);
        } catch (Exception e) {
            return null;
        }
    }

    private static ShareDevice buildFromJson(JSONObject obj) {
        ShareDevice device = new ShareDevice();
        device.deviceId = obj.optString("deviceId", "unknown");
        device.deviceName = obj.optString("deviceName", "unknown");
        device.deviceMac = obj.optString("deviceMac", "unknown");
        device.lastConnectTime = obj.optLong("lastConnectTime", 0L);
        device.lastProtocolType = obj.optInt("lastProtocolType", -1);
        device.connectStatus = obj.optInt("connectStatus", -1);
        return device;
    }

    private JSONObject toJson() {
        JSONObject obj = new JSONObject();
        try {
            obj.put("deviceId", this.deviceId);
            obj.put("deviceName", this.deviceName);
            obj.put("deviceMac", this.deviceMac);
            obj.put("lastConnectTime", this.lastConnectTime);
            obj.put("lastProtocolType", this.lastProtocolType);
            obj.put("connectStatus", this.connectStatus);
            return obj;
        } catch (Exception e) {
            String str = TAG;
            LogUtil.w(str, "toJsonStr e=" + e);
            return null;
        }
    }

    public String toJsonStr() {
        JSONObject obj = toJson();
        if (obj != null) {
            return obj.toString();
        }
        return null;
    }

    public static String toJsonArrayStr(ShareDevice[] devices) {
        JSONArray array = new JSONArray();
        try {
            for (ShareDevice device : devices) {
                array.put(device.toJson());
            }
            return array.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static ShareDevice[] buildArrayFromJsonStr(String jsonStr) {
        try {
            JSONArray array = new JSONArray(jsonStr);
            int size = array.length();
            ShareDevice[] devices = new ShareDevice[size];
            for (int i = 0; i < size; i++) {
                devices[i] = buildFromJson(array.getJSONObject(i));
            }
            return devices;
        } catch (Exception e) {
            String str = TAG;
            LogUtil.w(str, "buildArrayFromJsonStr e=" + e);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.deviceId);
        dest.writeString(this.deviceName);
        dest.writeString(this.deviceMac);
        dest.writeLong(this.lastConnectTime);
        dest.writeInt(this.lastProtocolType);
        dest.writeInt(this.connectStatus);
    }

    public String toString() {
        return getClass().getSimpleName() + "[name:" + this.deviceName + ",id:" + this.deviceId + ",addr:" + this.deviceMac + "]";
    }

    public boolean equals(Object obj) {
        if (obj instanceof ShareDevice) {
            ShareDevice device = (ShareDevice) obj;
            return this == device || (this.deviceId != null && this.deviceId.equals(device.getDeviceId())) || (this.deviceMac != null && this.deviceMac.equals(device.getDeviceMac()));
        }
        return false;
    }
}
