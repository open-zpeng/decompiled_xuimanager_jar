package com.xiaopeng.xuimanager.operation;
/* loaded from: classes.dex */
public class OperationResource {
    private long createTime;
    private String description;
    private String downloadUrl;
    private long effectTime;
    private long expireTime;
    private String extraData;
    private String id;
    private String price;
    private String resourceFrom;
    private String resourceIcon;
    private String resourceName;
    private int resourceType;
    private int status;
    private String targetPath;
    private long updateTime;

    public String toString() {
        return "OperationResource{id='" + this.id + "', resourceType=" + this.resourceType + ", resourceName='" + this.resourceName + "', resourceFrom='" + this.resourceFrom + "', targetPath='" + this.targetPath + "', downloadUrl='" + this.downloadUrl + "', effectTime=" + this.effectTime + ", expireTime=" + this.expireTime + ", extraData='" + this.extraData + "', status=" + this.status + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", resourceIcon='" + this.resourceIcon + "', description='" + this.description + "', price='" + this.price + "'}";
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getResourceType() {
        return this.resourceType;
    }

    public void setResourceType(int resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceName() {
        return this.resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceFrom() {
        return this.resourceFrom;
    }

    public void setResourceFrom(String resourceFrom) {
        this.resourceFrom = resourceFrom;
    }

    public String getTargetPath() {
        return this.targetPath;
    }

    public void setTargetPath(String targetPath) {
        this.targetPath = targetPath;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public long getEffectTime() {
        return this.effectTime;
    }

    public void setEffectTime(long effectTime) {
        this.effectTime = effectTime;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }

    public String getExtraData() {
        return this.extraData;
    }

    public void setExtraData(String extraData) {
        this.extraData = extraData;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public String getResourceIcon() {
        return this.resourceIcon;
    }

    public void setResourceIcon(String resourceIcon) {
        this.resourceIcon = resourceIcon;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
