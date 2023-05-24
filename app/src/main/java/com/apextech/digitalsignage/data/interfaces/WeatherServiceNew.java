package com.apextech.digitalsignage.data.interfaces;


import com.apextech.digitalsignage.data.model.request.SignageRequestNew;
import com.apextech.digitalsignage.data.model.response.weathernew.WeatherDataResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface WeatherServiceNew
{
    @POST("api/weather/")
    Call<WeatherDataResponse> getWeatherData(@Header("Authorization") String authToken, @Body SignageRequestNew signageRequest);
}
