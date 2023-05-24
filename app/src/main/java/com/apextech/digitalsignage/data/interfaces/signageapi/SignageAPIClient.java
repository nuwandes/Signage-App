package com.apextech.digitalsignage.data.interfaces.signageapi;

import com.apextech.digitalsignage.data.interfaces.BoughtFactorySummaryService;
import com.apextech.digitalsignage.data.interfaces.BoughtLineSummaryService;
import com.apextech.digitalsignage.data.interfaces.DivisionalGrossQtyService;
import com.apextech.digitalsignage.data.interfaces.FactoryCollectionSummaryService;
import com.apextech.digitalsignage.data.interfaces.InterEstateSummaryService;
import com.apextech.digitalsignage.data.interfaces.DeviceRegistrationsService;
import com.apextech.digitalsignage.data.interfaces.SetAssetService;
import com.apextech.digitalsignage.data.interfaces.WeatherServiceNew;
import com.apextech.digitalsignage.data.model.response.weathernew.WeatherData;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignageAPIClient {

    private static Retrofit getRetrofit(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        builder.connectTimeout(30, TimeUnit.SECONDS) // connect timeout
//                .writeTimeout(30, TimeUnit.SECONDS) // write timeout
//                .readTimeout(30, TimeUnit.SECONDS); // read timeout

        // need to implement the try catch for api calls when get a time out exception

        builder.writeTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS);

        OkHttpClient okHttpClient = builder.addInterceptor(httpLoggingInterceptor).build();
        //OkHttpClient okHttpClient = builder.build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://dev.infinity.com.lk/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit;
    }

    public static DivisionalGrossQtyService getDivisionalGrossQtyService(){
        DivisionalGrossQtyService divisionalGrossQtyService = getRetrofit().create(DivisionalGrossQtyService.class);
        return divisionalGrossQtyService;
    }

    public static FactoryCollectionSummaryService getFactoryCollectionSummaryService(){
        FactoryCollectionSummaryService factoryCollectionSummaryService = getRetrofit().create(FactoryCollectionSummaryService.class);
        return factoryCollectionSummaryService;
    }

    public static InterEstateSummaryService getInterEstateSummaryService(){
        InterEstateSummaryService interEstateSummaryService = getRetrofit().create(InterEstateSummaryService.class);
        return interEstateSummaryService;
    }

    public static BoughtFactorySummaryService getBoughtFactorySummaryService(){
        BoughtFactorySummaryService boughtFactorySummaryService = getRetrofit().create(BoughtFactorySummaryService.class);
        return boughtFactorySummaryService;
    }

    public static BoughtLineSummaryService getBoughtLineSummaryService(){
        BoughtLineSummaryService boughtLineSummaryService = getRetrofit().create(BoughtLineSummaryService.class);
        return boughtLineSummaryService;
    }

    public static DeviceRegistrationsService getDeviceRegistrationService(){
        DeviceRegistrationsService mobileStatusService = getRetrofit().create(DeviceRegistrationsService.class);
        return mobileStatusService;
    }

    public static SetAssetService getSetAssetService(){
        SetAssetService setAssetService = getRetrofit().create(SetAssetService.class);
        return setAssetService;
    }

    public static WeatherServiceNew getWeatherServiceNew(){
        WeatherServiceNew weatherServiceNew = getRetrofit().create(WeatherServiceNew.class);
        return weatherServiceNew;
    }
}
