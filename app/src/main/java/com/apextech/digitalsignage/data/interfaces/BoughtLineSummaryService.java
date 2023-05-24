package com.apextech.digitalsignage.data.interfaces;

import com.apextech.digitalsignage.data.model.request.SignageRequest;
import com.apextech.digitalsignage.data.model.response.boughtleafdailylinecollectionsummary.BoughtLineSummaryResponse;
import com.apextech.digitalsignage.data.model.response.boughtleatdailyfactorycollectionsummary.BoughtFactorySummaryResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BoughtLineSummaryService
{
    @POST("api/bought_line/")
    Call<BoughtLineSummaryResponse> getBoughtLineSummaryResponse(@Header("Authorization") String authToken, @Header("imeino") String imeiNo, @Body SignageRequest signageRequest);
}
