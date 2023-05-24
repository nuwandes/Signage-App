package com.apextech.digitalsignage.data.interfaces;

import com.apextech.digitalsignage.data.model.GenericResponse;
import com.apextech.digitalsignage.data.model.request.DeviceRegistrationRequest;
import com.apextech.digitalsignage.data.model.request.SetAssetRequest;
import com.apextech.digitalsignage.data.model.response.GenericResponseNew;
import com.apextech.digitalsignage.data.model.response.deviceregistration.DeviceRegistrationResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface SetAssetService
{
    @POST("api/mobile/set_asset_id")
    Call<GenericResponseNew> setAssetResponse(@Header("Authorization") String authToken,
                                              @Header("unique-id") String imeiNo,
                                              @Header("group-id") String groupId,
                                              @Header("app-version") String appVersion,
                                              @Header("sim-no") String simNo,
                                              @Header("os") String deviceOs,
                                              @Body SetAssetRequest assetRequest);
}
