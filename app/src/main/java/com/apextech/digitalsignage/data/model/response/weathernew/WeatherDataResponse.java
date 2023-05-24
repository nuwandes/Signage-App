package com.apextech.digitalsignage.data.model.response.weathernew;

import com.apextech.digitalsignage.data.model.response.boughtleatdailyfactorycollectionsummary.BoughtFactorySummaryData;

import java.util.ArrayList;

public class WeatherDataResponse
{
    private String status;
    private ArrayList<WeatherData> data;
    private Integer systemCode;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<WeatherData> getData() {
        return data;
    }

    public void setData(ArrayList<WeatherData> data) {
        this.data = data;
    }

    public Integer getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(Integer systemCode) {
        this.systemCode = systemCode;
    }
}
