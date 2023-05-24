package com.apextech.digitalsignage.data.model.response.divisionalgrossqty;

import java.util.ArrayList;

public class DivisionalGrossQtyResponse
{
    private String status;
    private ArrayList<EstateData> data;
    private Integer systemCode;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<EstateData> getData() {
        return data;
    }

    public void setData(ArrayList<EstateData> data) {
        this.data = data;
    }

    public Integer getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(Integer systemCode) {
        this.systemCode = systemCode;
    }
}
