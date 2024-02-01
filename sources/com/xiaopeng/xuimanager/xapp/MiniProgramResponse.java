package com.xiaopeng.xuimanager.xapp;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class MiniProgramResponse implements Parcelable {
    public static final Parcelable.Creator<MiniProgramResponse> CREATOR = new Parcelable.Creator<MiniProgramResponse>() { // from class: com.xiaopeng.xuimanager.xapp.MiniProgramResponse.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MiniProgramResponse createFromParcel(Parcel in) {
            return new MiniProgramResponse(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MiniProgramResponse[] newArray(int size) {
            return new MiniProgramResponse[size];
        }
    };
    private int code;
    private boolean isLogin;
    private List<MiniProgramGroup> mMiniProgramGroups;
    private Map mParams;
    private String message;
    private String miniAppId;
    private String userAvatar;
    private String userKey;
    private String userNick;
    private String userRoute;

    public MiniProgramResponse() {
        this.miniAppId = "";
        this.isLogin = false;
        this.userAvatar = "";
        this.userKey = "";
        this.userNick = "";
        this.userRoute = "";
        this.message = "";
        this.mParams = new HashMap();
        this.mMiniProgramGroups = new ArrayList();
    }

    protected MiniProgramResponse(Parcel in) {
        this.miniAppId = "";
        this.isLogin = false;
        this.userAvatar = "";
        this.userKey = "";
        this.userNick = "";
        this.userRoute = "";
        this.message = "";
        this.mParams = new HashMap();
        this.mMiniProgramGroups = new ArrayList();
        this.code = in.readInt();
        this.miniAppId = in.readStringNoHelper();
        this.isLogin = in.readByte() != 0;
        this.userAvatar = in.readStringNoHelper();
        this.userKey = in.readStringNoHelper();
        this.userNick = in.readStringNoHelper();
        this.userRoute = in.readStringNoHelper();
        this.message = in.readStringNoHelper();
        this.mMiniProgramGroups = in.createTypedArrayList(MiniProgramGroup.CREATOR);
        in.readMap(this.mParams, Map.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.code);
        dest.writeStringNoHelper(this.miniAppId);
        dest.writeByte(this.isLogin ? (byte) 1 : (byte) 0);
        dest.writeStringNoHelper(this.userAvatar);
        dest.writeStringNoHelper(this.userKey);
        dest.writeStringNoHelper(this.userNick);
        dest.writeStringNoHelper(this.userRoute);
        dest.writeStringNoHelper(this.message);
        dest.writeTypedList(this.mMiniProgramGroups);
        dest.writeMap(this.mParams);
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMiniAppId() {
        return this.miniAppId;
    }

    public void setMiniAppId(String miniAppId) {
        this.miniAppId = miniAppId;
    }

    public boolean isLogin() {
        return this.isLogin;
    }

    public void setLogin(boolean login) {
        this.isLogin = login;
    }

    public String getUserAvatar() {
        return this.userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserKey() {
        return this.userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getUserNick() {
        return this.userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getUserRoute() {
        return this.userRoute;
    }

    public void setUserRoute(String userRoute) {
        this.userRoute = userRoute;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map getParams() {
        return this.mParams;
    }

    public void setParams(Map params) {
        this.mParams = params;
    }

    public List<MiniProgramGroup> getMiniProgramGroups() {
        return this.mMiniProgramGroups;
    }

    public void setMiniProgramGroups(List<MiniProgramGroup> miniProgramGroups) {
        this.mMiniProgramGroups.clear();
        this.mMiniProgramGroups.addAll(miniProgramGroups);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "MiniProgramResponse{code=" + this.code + ", miniAppId='" + this.miniAppId + "', isLogin=" + this.isLogin + ", userAvatar=" + this.userAvatar + ", userKey=" + this.userKey + ", userNick=" + this.userNick + ", userRoute=" + this.userRoute + ", message=" + this.message + ", params=" + this.mParams + '}';
    }
}
