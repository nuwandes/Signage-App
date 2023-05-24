package com.apextech.digitalsignage.data.model.response;

import com.apextech.digitalsignage.data.model.response.weather.DailyForecasts;
import com.apextech.digitalsignage.data.model.response.weather.DailyForecastsData;
import com.apextech.digitalsignage.data.model.response.weather.Headline;

import java.util.List;

public class WeatherResponse
{
    private Headline Headline;
    private List<DailyForecastsData> DailyForecasts;

    public com.apextech.digitalsignage.data.model.response.weather.Headline getHeadline() {
        return Headline;
    }

    public void setHeadline(com.apextech.digitalsignage.data.model.response.weather.Headline headline) {
        Headline = headline;
    }

    public List<DailyForecastsData> getDailyForecasts() {
        return DailyForecasts;
    }

    public void setDailyForecasts(List<DailyForecastsData> dailyForecasts) {
        DailyForecasts = dailyForecasts;
    }
}
