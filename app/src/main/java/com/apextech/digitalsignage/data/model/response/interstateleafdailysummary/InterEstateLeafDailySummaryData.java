package com.apextech.digitalsignage.data.model.response.interstateleafdailysummary;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "inter_estate_leaf_daily_summary")
public class InterEstateLeafDailySummaryData
{
    @PrimaryKey(autoGenerate = true)
    private int id;
    private Integer estate_id;
    private String estate_name;
    private Double total_collected;
    private String destination;
    private Double destination_confirm_received;

    @Ignore
    public InterEstateLeafDailySummaryData(Integer estate_id, String estate_name, Double total_collected, String destination, Double destination_confirm_received) {
        this.estate_id = estate_id;
        this.estate_name = estate_name;
        this.total_collected = total_collected;
        this.destination = destination;
        this.destination_confirm_received = destination_confirm_received;
    }

    public InterEstateLeafDailySummaryData(int id, Integer estate_id, String estate_name, Double total_collected, String destination, Double destination_confirm_received) {
        this.id = id;
        this.estate_id = estate_id;
        this.estate_name = estate_name;
        this.total_collected = total_collected;
        this.destination = destination;
        this.destination_confirm_received = destination_confirm_received;
    }

    public InterEstateLeafDailySummaryData() {
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

    public Double getTotal_collected() {
        return total_collected;
    }

    public void setTotal_collected(Double total_collected) {
        this.total_collected = total_collected;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Double getDestination_confirm_received() {
        return destination_confirm_received;
    }

    public void setDestination_confirm_received(Double destination_confirm_received) {
        this.destination_confirm_received = destination_confirm_received;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
