package com.apextech.digitalsignage.data.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.apextech.digitalsignage.data.model.response.boughtleafdailylinecollectionsummary.BoughtLineSummaryData;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface BoughtLineSummaryDataDao
{
    @Query("SELECT * FROM bought_line_summary_data")
    List<BoughtLineSummaryData> loadAllBoughtLineSummaryData();

    @Insert
    void insertBoughtLineSummaryData(BoughtLineSummaryData boughtLineSummaryData);

    @Update
    void updateBoughtLineSummaryData(BoughtLineSummaryData boughtLineSummaryData);

    @Delete
    void delete(BoughtLineSummaryData boughtLineSummaryData);

    @Query("SELECT * FROM bought_line_summary_data WHERE id = :id")
    BoughtLineSummaryData loadBoughtLineSummaryDataById(int id);

    @Query("DELETE FROM bought_line_summary_data")
    void deleteAllLines();
}
