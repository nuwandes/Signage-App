package com.apextech.digitalsignage.data.interfaces;

import com.apextech.digitalsignage.data.model.response.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeatherService
{
    @GET("forecasts/v1/daily/5day/{locationKey}")
    Call<WeatherResponse> getColomboForecast(@Path("locationKey") String locationKey, @Query("apikey") String apiKey);
}
