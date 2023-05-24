package com.apextech.digitalsignage.data.model.request;

import com.google.gson.annotations.SerializedName;

public class SignageRequestNew {

    @SerializedName("date")
    String date;

    @SerializedName("time")
    String time;

    public SignageRequestNew()
    {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
