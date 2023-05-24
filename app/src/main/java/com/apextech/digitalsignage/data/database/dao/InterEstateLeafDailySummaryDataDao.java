package com.apextech.digitalsignage.data.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.apextech.digitalsignage.data.model.response.boughtleafdailylinecollectionsummary.BoughtLineSummaryData;
import com.apextech.digitalsignage.data.model.response.interstateleafdailysummary.InterEstateLeafDailySummaryData;

import java.util.List;

@Dao
public interface InterEstateLeafDailySummaryDataDao
{
    @Query("SELECT * FROM inter_estate_leaf_daily_summary")
    List<InterEstateLeafDailySummaryData> loadAllInterEstateLeafDailySummaryData();

    @Insert
    void insertInterEstateLeafDailySummaryData(InterEstateLeafDailySummaryData interEstateLeafDailySummaryData);

    @Update
    void updateInterEstateLeafDailySummaryData(InterEstateLeafDailySummaryData interEstateLeafDailySummaryData);

    @Delete
    void delete(InterEstateLeafDailySummaryData interEstateLeafDailySummaryData);

    @Query("SELECT * FROM inter_estate_leaf_daily_summary WHERE id = :id")
    InterEstateLeafDailySummaryData loadInterEstateLeafDailySummaryDataDataById(int id);

    @Query("DELETE FROM inter_estate_leaf_daily_summary")
    void deleteAllInterEstateLeafDailySummaryData();
}
