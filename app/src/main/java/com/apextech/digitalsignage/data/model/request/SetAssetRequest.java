package com.apextech.digitalsignage.data.model.request;

import com.google.gson.annotations.SerializedName;

public class SetAssetRequest {

    @SerializedName("asset_no")
    String assetId;

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }
}
