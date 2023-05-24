package com.apextech.digitalsignage.data.model.response.boughtleatdailyfactorycollectionsummary;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "bought_factory_summary_data")
public class BoughtFactorySummaryData
{
    @PrimaryKey(autoGenerate = true)
    private int id;
    private Integer estate_id;
    private String estate_name;
    private String factory_officer_name;
    private Double suppliers_count_processed;
    private Double total_gross_weight_received;
    private Double total_net_weight_received;

    public BoughtFactorySummaryData() {
    }

    public BoughtFactorySummaryData(int id, Integer estate_id, String estate_name, String factory_officer_name, Double suppliers_count_processed, Double total_gross_weight_received, Double total_net_weight_received) {
        this.id = id;
        this.estate_id = estate_id;
        this.estate_name = estate_name;
        this.factory_officer_name = factory_officer_name;
        this.suppliers_count_processed = suppliers_count_processed;
        this.total_gross_weight_received = total_gross_weight_received;
        this.total_net_weight_received = total_net_weight_received;
    }

    @Ignore
    public BoughtFactorySummaryData(Integer estate_id, String estate_name, String factory_officer_name, Double suppliers_count_processed, Double total_gross_weight_received, Double total_net_weight_received) {
        this.estate_id = estate_id;
        this.estate_name = estate_name;
        this.factory_officer_name = factory_officer_name;
        this.suppliers_count_processed = suppliers_count_processed;
        this.total_gross_weight_received = total_gross_weight_received;
        this.total_net_weight_received = total_net_weight_received;
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

    public String getFactory_officer_name() {
        return factory_officer_name;
    }

    public void setFactory_officer_name(String factory_officer_name) {
        this.factory_officer_name = factory_officer_name;
    }

    public Double getSuppliers_count_processed() {
        return suppliers_count_processed;
    }

    public void setSuppliers_count_processed(Double suppliers_count_processed) {
        this.suppliers_count_processed = suppliers_count_processed;
    }

    public Double getTotal_gross_weight_received() {
        return total_gross_weight_received;
    }

    public void setTotal_gross_weight_received(Double total_gross_weight_received) {
        this.total_gross_weight_received = total_gross_weight_received;
    }

    public Double getTotal_net_weight_received() {
        return total_net_weight_received;
    }

    public void setTotal_net_weight_received(Double total_net_weight_received) {
        this.total_net_weight_received = total_net_weight_received;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
