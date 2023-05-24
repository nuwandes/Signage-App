package com.apextech.digitalsignage.data.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.apextech.digitalsignage.data.model.response.interstateleafdailysummary.InterEstateLeafDailySummaryData;
import com.apextech.digitalsignage.data.model.response.weathernew.WeatherData;

import java.util.List;

@Dao
public interface WeatherDataDao
{
    @Query("SELECT * FROM weather_data")
    List<WeatherData> loadAllWeatherData();

    @Insert
    void insertWeatherData(WeatherData weatherData);

    @Update
    void updateWeatherData(WeatherData weatherData);

    @Delete
    void delete(WeatherData weatherData);

    @Query("SELECT * FROM weather_data WHERE id = :id")
    WeatherData loadWeatherDataById(int id);

    @Query("DELETE FROM weather_data")
    void deleteAllWeatherData();
}
