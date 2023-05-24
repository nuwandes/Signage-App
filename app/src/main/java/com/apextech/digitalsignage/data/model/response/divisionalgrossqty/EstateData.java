package com.apextech.digitalsignage.data.model.response.divisionalgrossqty;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName = "divisional_gross_estate_data")
public class EstateData
{
    @PrimaryKey(autoGenerate = true)
    private int id;
    private Integer estate_id;
    private String estate_name;
    private Double total_gross;

    public EstateData() {
    }

    public EstateData(int id, Integer estate_id, String estate_name, ArrayList<DivisionData> divisions, Double total_gross) {
        this.id = id;
        this.estate_id = estate_id;
        this.estate_name = estate_name;
        this.total_gross = total_gross;
    }

    @Ignore
    public EstateData(Integer estate_id, String estate_name, ArrayList<DivisionData> divisions, Double total_gross) {
        this.estate_id = estate_id;
        this.estate_name = estate_name;
        this.total_gross = total_gross;
    }

    public Integer getEstate_id() {
        return estate_id;
    }

    public void setEstate_id(Integer estate_id) {
        this.estate_id = estate_id;
    }

    public String getEstate_name() {
        return estate_name;
    }

    public void setEstate_name(String estate_name) {
        this.estate_name = estate_name;
    }

    public Double getTotal_gross() {
        return total_gross;
    }

    public void setTotal_gross(Double total_gross) {
        this.total_gross = total_gross;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
