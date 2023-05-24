package com.apextech.digitalsignage.data.model.response.weather;

public class Temperature {

    private Maximum Maximum;
    private Minimum Minimum;

    public com.apextech.digitalsignage.data.model.response.weather.Maximum getMaximum() {
        return Maximum;
    }

    public void setMaximum(com.apextech.digitalsignage.data.model.response.weather.Maximum maximum) {
        Maximum = maximum;
    }

    public com.apextech.digitalsignage.data.model.response.weather.Minimum getMinimum() {
        return Minimum;
    }

    public void setMinimum(com.apextech.digitalsignage.data.model.response.weather.Minimum minimum) {
        Minimum = minimum;
    }
}
