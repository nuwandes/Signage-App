package com.apextech.digitalsignage.data.model.response.boughtleafdailylinecollectionsummary;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "bought_line_summary_data")
public class BoughtLineSummaryData
{
    @PrimaryKey(autoGenerate = true)
    private int id;
    private Integer estate_id;
    private String estate_name;
    private String collector_name;
    private Integer collector_id;
    private String route;
    private Double collected_quantities;

    @Ignore
    public BoughtLineSummaryData(Integer estate_id, String estate_name, String collector_name, Integer collector_id, String route, Double collected_quantities) {
        this.estate_id = estate_id;
        this.estate_name = estate_name;
        this.collector_name = collector_name;
        this.collector_id = collector_id;
        this.route = route;
        this.collected_quantities = collected_quantities;
    }

    public BoughtLineSummaryData(int id, Integer estate_id, String estate_name, String collector_name, Integer collector_id, String route, Double collected_quantities) {
        this.id = id;
        this.estate_id = estate_id;
        this.estate_name = estate_name;
        this.collector_name = collector_name;
        this.collector_id = collector_id;
        this.route = route;
        this.collected_quantities = collected_quantities;
    }

    public BoughtLineSummaryData() {
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

    public String getCollector_name() {
        return collector_name;
    }

    public void setCollector_name(String collector_name) {
        this.collector_name = collector_name;
    }

    public Integer getCollector_id() {
        return collector_id;
    }

    public void setCollector_id(Integer collector_id) {
        this.collector_id = collector_id;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Double getCollected_quantities() {
        return collected_quantities;
    }

    public void setCollected_quantities(Double collected_quantities) {
        this.collected_quantities = collected_quantities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
