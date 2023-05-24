package com.apextech.digitalsignage.data.interfaces;

import com.apextech.digitalsignage.data.model.request.SignageRequest;
import com.apextech.digitalsignage.data.model.response.interstateleafdailysummary.InterEstateLeafDailySummaryResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface InterEstateSummaryService
{
    @POST("api/inter_estate/")
    Call<InterEstateLeafDailySummaryResponse> getInterEstateLeafDailySummary(@Header("Authorization") String authToken, @Header("imeino") String imeiNo, @Body SignageRequest signageRequest);
}
