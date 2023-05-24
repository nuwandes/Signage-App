package com.apextech.digitalsignage.data.model.request;

import com.google.gson.annotations.SerializedName;

public class SignageRequest {

    @SerializedName("plantationid")
    int plantationId;

    @SerializedName("last_updated_at")
    String lastUpdatedAt;

    public int getPlantationId() {
        return plantationId;
    }

    public void setPlantationId(int plantationId) {
        this.plantationId = plantationId;
    }

    public String getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(String lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }
}
