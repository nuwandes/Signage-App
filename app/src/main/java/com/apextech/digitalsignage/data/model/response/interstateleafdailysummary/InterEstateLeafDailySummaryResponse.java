package com.apextech.digitalsignage.data.model.response.interstateleafdailysummary;

import java.util.ArrayList;

public class InterEstateLeafDailySummaryResponse
{
    private String status;
    private Integer systemCode;
    private ArrayList<InterEstateLeafDailySummaryData> data;

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

    public ArrayList<InterEstateLeafDailySummaryData> getData() {
        return data;
    }

    public void setData(ArrayList<InterEstateLeafDailySummaryData> data) {
        this.data = data;
    }
}
