package com.apextech.digitalsignage.data.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.apextech.digitalsignage.data.model.response.factorycollectonsummary.FactoryCollectionSummaryData;

import java.util.List;

@Dao
public interface FactoryCollectionSummaryDataDao {

    @Query("SELECT * FROM factory_collection_summary_data")
    List<FactoryCollectionSummaryData> loadAllFactoryCollectionSummaryData();

    @Insert
    void insertFactoryCollectionSummaryData(FactoryCollectionSummaryData factoryCollectionSummaryData);

    @Update
    void updateFactoryCollectionSummaryData(FactoryCollectionSummaryData factoryCollectionSummaryData);

    @Delete
    void delete(FactoryCollectionSummaryData factoryCollectionSummaryData);

    @Query("SELECT * FROM factory_collection_summary_data WHERE id = :id")
    FactoryCollectionSummaryData loadFactoryCollectionSummaryDataById(int id);

    @Query("DELETE FROM factory_collection_summary_data")
    void deleteAllFactoryCollectionSummaryData();

//    kghklj;
}
