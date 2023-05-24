package com.apextech.digitalsignage.data;

import com.apextech.digitalsignage.data.interfaces.LocationService;
import com.apextech.digitalsignage.data.interfaces.WeatherService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherAPIClient {

    private static Retrofit getRetrofit(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://dataservice.accuweather.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit;
    }

    public static LocationService getLocationService(){
        LocationService locationService = getRetrofit().create(LocationService.class);
        return locationService;
    }

    public static WeatherService getWeatherService(){
        WeatherService weatherService = getRetrofit().create(WeatherService.class);
        return weatherService;
    }

}
