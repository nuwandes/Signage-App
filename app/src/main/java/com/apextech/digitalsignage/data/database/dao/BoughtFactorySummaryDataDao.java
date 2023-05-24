package com.apextech.digitalsignage.data.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.apextech.digitalsignage.data.model.response.boughtleafdailylinecollectionsummary.BoughtLineSummaryData;
import com.apextech.digitalsignage.data.model.response.boughtleatdailyfactorycollectionsummary.BoughtFactorySummaryData;

import java.util.List;

@Dao
public interface BoughtFactorySummaryDataDao
{
    @Query("SELECT * FROM bought_factory_summary_data")
    List<BoughtFactorySummaryData> loadAllBoughtFactorySummaryData();

    @Insert
    void insertBoughtFactorySummaryData(BoughtFactorySummaryData boughtfactorySummaryData);

    @Update
    void updateBoughtFactorySummaryData(BoughtFactorySummaryData boughtFactorySummaryData);

    @Delete
    void delete(BoughtFactorySummaryData boughtFactorySummaryData);

    @Query("SELECT * FROM bought_factory_summary_data WHERE id = :id")
    BoughtFactorySummaryData loadBoughtFactorySummaryDataById(int id);

    @Query("DELETE FROM bought_factory_summary_data")
    void deleteAllFactories();
}
