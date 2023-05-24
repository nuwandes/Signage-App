package com.apextech.digitalsignage.data.model;

import com.apextech.digitalsignage.data.model.response.deviceregistration.DeviceRegistrationResponse;

import java.util.List;

public class GenericResponse
{
    String status;
    DeviceRegistrationResponse data;
    int systemCode;

    public GenericResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DeviceRegistrationResponse getData() {
        return data;
    }

    public void setData(DeviceRegistrationResponse data) {
        this.data = data;
    }

    public int getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(int systemCode) {
        this.systemCode = systemCode;
    }
}
