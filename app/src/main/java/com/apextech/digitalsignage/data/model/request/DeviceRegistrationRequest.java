package com.apextech.digitalsignage.data.model.request;

import com.google.gson.annotations.SerializedName;

public class DeviceRegistrationRequest {

    @SerializedName("group_id")
    int groupId;

    @SerializedName("unique_id")
    String androidId;

    @SerializedName("os")
    String androidOs;

    @SerializedName("sim_no")
    String simNo;

    @SerializedName("app_version")
    String appVersion;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getAndroidId() {
        return androidId;
    }

    public void setAndroidId(String androidId) {
        this.androidId = androidId;
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public String getAndroidOs() {
        return androidOs;
    }

    public void setAndroidOs(String androidOs) {
        this.androidOs = androidOs;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }
}
