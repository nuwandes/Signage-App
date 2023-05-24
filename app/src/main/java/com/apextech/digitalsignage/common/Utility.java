package com.apextech.digitalsignage.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Utility
{
    Calendar myCalendar = Calendar.getInstance();
    public Utility() {
    }

    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public String getCurrentDate()
    {
        String myFormat = "yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.getDefault());

        return dateFormat.format(myCalendar.getTime());
    }

    public String getCurrentTime()
    {
        String myFormat = "hh:mm";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.getDefault());

        return dateFormat.format(myCalendar.getTime());
    }

}
