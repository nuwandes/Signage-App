package com.apextech.digitalsignage.data.interfaces;

import com.apextech.digitalsignage.data.model.GenericResponse;
import com.apextech.digitalsignage.data.model.request.DeviceRegistrationRequest;
import com.apextech.digitalsignage.data.model.response.deviceregistration.DeviceRegistrationResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface DeviceRegistrationsService
{
    @POST("api/mobile/status")
    Call<GenericResponse> getDeviceRegistrationResponse(@Body DeviceRegistrationRequest deviceRegistrationRequest);
}
