package com.apextech.digitalsignage.data.database.dao.divisionalgross;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.apextech.digitalsignage.data.model.response.divisionalgrossqty.DivisionData;
import com.apextech.digitalsignage.data.model.response.divisionalgrossqty.EstateData;

import java.util.List;

@Dao
public interface EstateDataDao
{
    @Query("SELECT * FROM divisional_gross_estate_data")
    List<EstateData> loadAllEstateData();

    @Insert
    void insertEstateData(EstateData estateData);

    @Update
    void updateEstateData(EstateData estateData);

    @Delete
    void delete(EstateData estateData);

    @Query("SELECT * FROM divisional_gross_estate_data WHERE id = :id")
    EstateData loadEstateDataById(int id);

    @Query("DELETE FROM divisional_gross_estate_data")
    void deleteAllEstateData();
}
