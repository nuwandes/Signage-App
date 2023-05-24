package com.apextech.digitalsignage.data.model.response.factorycollectonsummary;

import java.util.ArrayList;

public class FactoryCollectionSummaryResponse
{
    private String status;
    private Integer systemCode;
    private ArrayList<FactoryCollectionSummaryData> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(Integer systemCode) {
        this.systemCode = systemCode;
    }

    public ArrayList<FactoryCollectionSummaryData> getData() {
        return data;
    }

    public void setData(ArrayList<FactoryCollectionSummaryData> data) {
        this.data = data;
    }
}
