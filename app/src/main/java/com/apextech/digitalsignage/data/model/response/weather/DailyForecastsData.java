package com.apextech.digitalsignage.data.model.response.weather;

public class DailyForecastsData {

    private String Date;
    private Temperature Temperature;
    private Day Day;

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public com.apextech.digitalsignage.data.model.response.weather.Temperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(com.apextech.digitalsignage.data.model.response.weather.Temperature temperature) {
        Temperature = temperature;
    }

    public com.apextech.digitalsignage.data.model.response.weather.Day getDay() {
        return Day;
    }

    public void setDay(com.apextech.digitalsignage.data.model.response.weather.Day day) {
        Day = day;
    }
}
