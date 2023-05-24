package com.apextech.digitalsignage.data.model.response.weathernew;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "weather_data")
public class WeatherData
{
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String date;
    private String time;
    private String maximum_temp;
    private String minimum_temp;
    private String weather_condition;

    @Ignore
    public WeatherData(String date, String time, String maximum_temp, String minimum_temp, String weather_condition) {
        this.date = date;
        this.time = time;
        this.maximum_temp = maximum_temp;
        this.minimum_temp = minimum_temp;
        this.weather_condition = weather_condition;
    }

    public WeatherData(int id, String date, String time, String maximum_temp, String minimum_temp, String weather_condition) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.maximum_temp = maximum_temp;
        this.minimum_temp = minimum_temp;
        this.weather_condition = weather_condition;
    }

    public WeatherData() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMaximum_temp() {
        return maximum_temp;
    }

    public void setMaximum_temp(String maximum_temp) {
        this.maximum_temp = maximum_temp;
    }

    public String getMinimum_temp() {
        return minimum_temp;
    }

    public void setMinimum_temp(String minimum_temp) {
        this.minimum_temp = minimum_temp;
    }

    public String getWeather_condition() {
        return weather_condition;
    }

    public void setWeather_condition(String weather_condition) {
        this.weather_condition = weather_condition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
