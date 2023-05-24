package com.apextech.digitalsignage.data.interfaces;

import com.apextech.digitalsignage.data.model.request.SignageRequest;
import com.apextech.digitalsignage.data.model.response.WeatherResponse;
import com.apextech.digitalsignage.data.model.response.divisionalgrossqty.DivisionalGrossQtyResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DivisionalGrossQtyService
{
    @POST("api/divisional_gross/")
    Call<DivisionalGrossQtyResponse> getDivisionalGrossQty(@Header("Authorization") String authToken, @Header("imeino") String imeiNo, @Body SignageRequest signageRequest);
}
