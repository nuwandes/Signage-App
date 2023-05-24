package com.apextech.digitalsignage.data.model.response.weather;

public class Maximum {

    private double Value;
    private String Unit;

    public double getValue() {
        return Value;
    }

    public void setValue(double value) {
        Value = value;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }
}
