package com.apextech.digitalsignage.data.database.dao.divisionalgross;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.apextech.digitalsignage.data.model.response.boughtleatdailyfactorycollectionsummary.BoughtFactorySummaryData;
import com.apextech.digitalsignage.data.model.response.divisionalgrossqty.DivisionData;

import java.util.List;

@Dao
public interface DivisionDataDao
{
    @Query("SELECT * FROM divisional_gross_division_data")
    List<DivisionData> loadAllDivisionData();

    @Insert
    void insertDivisionData(DivisionData divisionData);

    @Update
    void updateDivisionData(DivisionData divisionData);

    @Delete
    void delete(DivisionData divisionData);

    @Query("SELECT * FROM divisional_gross_division_data WHERE id = :id")
    DivisionData loadDivisionDataById(int id);

    @Query("DELETE FROM divisional_gross_division_data")
    void deleteAllDivisionData();
}
