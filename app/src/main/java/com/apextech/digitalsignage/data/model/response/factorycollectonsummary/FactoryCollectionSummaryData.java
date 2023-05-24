package com.apextech.digitalsignage.data.model.response.factorycollectonsummary;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "factory_collection_summary_data")
public class FactoryCollectionSummaryData
{
    @PrimaryKey(autoGenerate = true)
    private int id;

    private Integer estate_id;
    private String estate_name;
    private Double estate_leaf;
    private Double inner_estate_leaf;
    private Double total_gross;
    private Double total_net;

    public FactoryCollectionSummaryData() {
    }

    public FactoryCollectionSummaryData(int id, Integer estate_id, String estate_name, Double estate_leaf, Double inner_estate_leaf, Double total_gross, Double total_net) {
        this.id = id;
        this.estate_id = estate_id;
        this.estate_name = estate_name;
        this.estate_leaf = estate_leaf;
        this.inner_estate_leaf = inner_estate_leaf;
        this.total_gross = total_gross;
        this.total_net = total_net;
    }

    @Ignore
    public FactoryCollectionSummaryData(Integer estate_id, String estate_name, Double estate_leaf, Double inner_estate_leaf, Double total_gross, Double total_net) {
        this.estate_id = estate_id;
        this.estate_name = estate_name;
        this.estate_leaf = estate_leaf;
        this.inner_estate_leaf = inner_estate_leaf;
        this.total_gross = total_gross;
        this.total_net = total_net;
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

    public String getEstate_name() {
        return estate_name;
    }

    public void setEstate_name(String estate_name) {
        this.estate_name = estate_name;
    }

    public Double getEstate_leaf() {
        return estate_leaf;
    }

    public void setEstate_leaf(Double estate_leaf) {
        this.estate_leaf = estate_leaf;
    }

    public Double getInner_estate_leaf() {
        return inner_estate_leaf;
    }

    public void setInner_estate_leaf(Double inner_estate_leaf) {
        this.inner_estate_leaf = inner_estate_leaf;
    }

    public Double getTotal_gross() {
        return total_gross;
    }

    public void setTotal_gross(Double total_gross) {
        this.total_gross = total_gross;
    }

    public Double getTotal_net() {
        return total_net;
    }

    public void setTotal_net(Double total_net) {
        this.total_net = total_net;
    }
}
