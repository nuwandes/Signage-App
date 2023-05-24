package com.apextech.digitalsignage.data.model.response.boughtleatdailyfactorycollectionsummary;

import java.util.ArrayList;

public class BoughtFactorySummaryResponse
{
    private String status;
    private ArrayList<BoughtFactorySummaryData> data;
    private Integer systemCode;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<BoughtFactorySummaryData> getData() {
        return data;
    }

    public void setData(ArrayList<BoughtFactorySummaryData> data) {
        this.data = data;
    }

    public Integer getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(Integer systemCode) {
        this.systemCode = systemCode;
    }
}
