package com.apextech.digitalsignage.data.interfaces;

import com.apextech.digitalsignage.data.model.response.LocationResponse;
import com.apextech.digitalsignage.data.model.response.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface LocationService {

    @GET("locations/v1/cities/geoposition/search")
    Call<LocationResponse> getLocationKey(@Query("apikey") String apiKey, @Query("q") String geoData);
}
