package com.apextech.digitalsignage.data.model.response.divisionalgrossqty;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "divisional_gross_division_data")
public class DivisionData
{
    @PrimaryKey(autoGenerate = true)
    private int id;
    private Integer division_id;
    private Integer estate_id;
    private String division_name;
    private Double gross_quantity_collected;

    public DivisionData(int id, Integer division_id, Integer estate_id, String division_name, Double gross_quantity_collected) {
        this.id = id;
        this.division_id = division_id;
        this.estate_id = estate_id;
        this.division_name = division_name;
        this.gross_quantity_collected = gross_quantity_collected;
    }

    @Ignore
    public DivisionData(Integer division_id, String division_name, Double gross_quantity_collected) {
        this.division_id = division_id;
        this.division_name = division_name;
        this.gross_quantity_collected = gross_quantity_collected;
    }

    public DivisionData() {
    }

    public Integer getDivision_id() {
        return division_id;
    }

    public void setDivision_id(Integer division_id) {
        this.division_id = division_id;
    }

    public String getDivision_name() {
        return division_name;
    }

    public void setDivision_name(String division_name) {
        this.division_name = division_name;
    }

    public Double getGross_quantity_collected() {
        return gross_quantity_collected;
    }

    public void setGross_quantity_collected(Double gross_quantity_collected) {
        this.gross_quantity_collected = gross_quantity_collected;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getEstate_id() {
        return estate_id;
    }

    public void setEstate_id(Integer estate_id) {
        this.estate_id = estate_id;
    }
}
