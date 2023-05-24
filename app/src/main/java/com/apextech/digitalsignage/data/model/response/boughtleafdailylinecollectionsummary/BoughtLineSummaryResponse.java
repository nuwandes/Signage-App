package com.apextech.digitalsignage.data.model.response.boughtleafdailylinecollectionsummary;

import java.util.ArrayList;

public class BoughtLineSummaryResponse
{
    private String status;
    private Integer systemCode;
    private ArrayList<BoughtLineSummaryData> data;

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

    public ArrayList<BoughtLineSummaryData> getData() {
        return data;
    }

    public void setData(ArrayList<BoughtLineSummaryData> data) {
        this.data = data;
    }
}
