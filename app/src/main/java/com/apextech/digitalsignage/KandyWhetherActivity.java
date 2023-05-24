package com.apextech.digitalsignage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class KandyWhetherActivity extends AppCompatActivity {

    private TextView tvDate, tvSatMax, tvSatMin, tvSunMax, tvSunMin, tvMonMax, tvMonMin, tvTueMax, tvTueMin, tvWedMax,
            tvWedMin, tvThuMax, tvThuMin, tvFriMax, tvFriMin, txtCopyright, tvSummary,
            tvOne, tvTwo, tvThree, tvFour, tvFive, tvSix, tvSeven;
    private ImageView ivOne, ivTwo, ivThree, ivFour, ivFive;
    private Calendar myCalendar = Calendar.getInstance();
    private String TAG = "KandyWhetherActivity";

    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whether_activity_kandy);

        tvDate = findViewById(R.id.tvCurrentDate);
        tvSatMax = findViewById(R.id.saturday_max_value);
        tvSatMin = findViewById(R.id.saturday_min_value);
        tvSunMax = findViewById(R.id.sunday_max_value);
        tvSunMin = findViewById(R.id.sunday_min_value);
        tvMonMax = findViewById(R.id.monday_max_value);
        tvMonMin = findViewById(R.id.monday_min_value);
        tvTueMax = findViewById(R.id.tuesday_max_value);
        tvTueMin = findViewById(R.id.tuesday_min_value);
        tvWedMax = findViewById(R.id.wednesday_max_value);
        tvWedMin = findViewById(R.id.wednesday_min_value);

        tvOne = findViewById(R.id.tvDayOne);
        tvTwo = findViewById(R.id.tvDayTwo);
        tvThree = findViewById(R.id.tvDayThree);
        tvFour = findViewById(R.id.tvDayFour);
        tvFive = findViewById(R.id.tvDayFive);

        ivOne = findViewById(R.id.ivDayOne);
        ivTwo = findViewById(R.id.ivDayTwo);
        ivThree = findViewById(R.id.ivDayThree);
        ivFour = findViewById(R.id.ivDayFour);
        ivFive = findViewById(R.id.ivDayFive);

        // need to be set from the API data (today maximum limit exceeded)

        ArrayList<String> cDateList = getIntent().getStringArrayListExtra("C_DATElIST");
        ArrayList<String> cMaxList = getIntent().getStringArrayListExtra("C_MAXlIST");
        ArrayList<String> cMinList = getIntent().getStringArrayListExtra("C_MINlIST");
        ArrayList<String> cConList = getIntent().getStringArrayListExtra("C_CONLIST");

        ArrayList<String> kDateList = getIntent().getStringArrayListExtra("K_DATElIST");
        ArrayList<String> kMaxList = getIntent().getStringArrayListExtra("K_MAXlIST");
        ArrayList<String> kMinList = getIntent().getStringArrayListExtra("K_MINlIST");
        ArrayList<String> kConList = getIntent().getStringArrayListExtra("K_CONLIST");

        Log.wtf(TAG, "INTENT_DATA_MAX: " + kMaxList.get(0) + ", MIN: " + kMinList.get(0) + ", DATE: " + kDateList.get(0) + ", CONDITION: " + kConList.get(0));

        tvSatMax.setText(convertFaranToCelci(kMaxList.get(0)) + " \u2103");
        tvSunMax.setText(convertFaranToCelci(kMaxList.get(1)) + " \u2103");
        tvMonMax.setText(convertFaranToCelci(kMaxList.get(2)) + " \u2103");
        tvTueMax.setText(convertFaranToCelci(kMaxList.get(3)) + " \u2103");
        tvWedMax.setText(convertFaranToCelci(kMaxList.get(4)) + " \u2103");

        tvSatMin.setText(convertFaranToCelci(kMinList.get(0)) + " \u2103");
        tvSunMin.setText(convertFaranToCelci(kMinList.get(1)) + " \u2103");
        tvMonMin.setText(convertFaranToCelci(kMinList.get(2)) + " \u2103");
        tvTueMin.setText(convertFaranToCelci(kMinList.get(3)) + " \u2103");
        tvWedMin.setText(convertFaranToCelci(kMinList.get(4)) + " \u2103");

        tvOne.setText(getSimpleDayName(kDateList.get(0)));
        tvTwo.setText(getSimpleDayName(kDateList.get(1)));
        tvThree.setText(getSimpleDayName(kDateList.get(2)));
        tvFour.setText(getSimpleDayName(kDateList.get(3)));
        tvFive.setText(getSimpleDayName(kDateList.get(4)));

        setIcon(kConList.get(0), ivOne);
        setIcon(kConList.get(1), ivTwo);
        setIcon(kConList.get(2), ivThree);
        setIcon(kConList.get(3), ivFour);
        setIcon(kConList.get(4), ivFive);

        tvSummary = findViewById(R.id.tvSummaryText);
        tvSummary.setText("Ragalla Factory Received 3,275 kg from Alma Estate, " + "High Forest Factory Dispatched 2,875 kg from No.1 Estate, " + "Liddesdale Factory Dispatched 3,235 kg from Harasbedda Estate, " + "Gonapitiya Factory Dispatched 875 kg from Keenagolla Estate");
        tvSummary.setSelected(true);

        int day = myCalendar.get(Calendar.DATE);
        String monthName = (String)android.text.format.DateFormat.format("MMMM", new Date());
        int year = myCalendar.get(Calendar.YEAR);
        String calendarDate = day + ", " + monthName + " " + year;
        tvDate.setText(calendarDate);

        txtCopyright = findViewById(R.id.tvCopyRightText);
        txtCopyright.setText("Copyright @"+ String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) +" Apex Technologies Private Limited");

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent inten = new Intent(KandyWhetherActivity.this, InterEstateLeafDailySummaryActivity.class);
                // colombo data
                inten.putExtra("C_DATElIST", cDateList);
                inten.putExtra("C_MAXlIST", cMaxList);
                inten.putExtra("C_MINlIST", cMinList);
                inten.putExtra("C_CONLIST", cConList);
                //kandy data
                inten.putExtra("K_DATElIST", kDateList);
                inten.putExtra("K_MAXlIST", kMaxList);
                inten.putExtra("K_MINlIST", kMinList);
                inten.putExtra("K_CONLIST", kConList);

                //inten.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(inten);
                finish();
            }

        }, 10000);
    }

    private String getSimpleTime(String date) throws ParseException {
        String newDate = date.substring(0, Math.min(date.length(), 10));
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        Date result;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            result = sdf.parse(newDate);
            System.out.println("date:"+result); //prints date in current locale

            //sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            //System.out.println(sdf.format(result)); //prints date in the format sdf
            String convertedDate = result.toString().substring(0, Math.min(date.length(), 3));
            return convertedDate;
        } catch (ParseException e) {
            e.printStackTrace();

            return "";
        }
    }

    private String getSimpleDayName (String date)
    {
        String dayName = "";
        try {
            String convertedDate = getSimpleTime(date);

            if (convertedDate.equals("Tue"))
            {
                dayName = "Tuesday";
            }
            else if (convertedDate.equals("Mon"))
            {
                dayName = "Monday";
            }
            else if (convertedDate.equals("Wed"))
            {
                dayName = "Wednesday";
            }
            else if (convertedDate.equals("Thu"))
            {
                dayName = "Thursday";
            }
            else if (convertedDate.equals("Fri"))
            {
                dayName = "Friday";
            }
            else if (convertedDate.equals("Sat"))
            {
                dayName = "Saturday";
            }
            else
            {
                dayName = "Sunday";
            }


            Log.wtf(TAG, "Date name: " + convertedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dayName;
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void setIcon(String condition, ImageView imageView)
    {
        if (condition.equalsIgnoreCase("rain"))
        {
            imageView.setBackground(getDrawable(R.drawable.rain_1));
        }
        else if (condition.equalsIgnoreCase("sunny"))
        {
            imageView.setBackground(getDrawable(R.drawable.sunny));
        }
        else if (condition.equalsIgnoreCase("mostly sunny"))
        {
            imageView.setBackground(getDrawable(R.drawable.mostly_sunny));
        }
        else if (condition.equalsIgnoreCase("partly sunny"))
        {
            imageView.setBackground(getDrawable(R.drawable.partially_sunny));
        }
        else if (condition.equalsIgnoreCase("intermittent clouds"))
        {
            imageView.setBackground(getDrawable(R.drawable.intermitants_clouds));
        }
        else if (condition.equalsIgnoreCase("mostly cloudy"))
        {
            imageView.setBackground(getDrawable(R.drawable.mostly_cloudy));
        }
        else if (condition.equalsIgnoreCase("cloudy"))
        {
            imageView.setBackground(getDrawable(R.drawable.cloudy));
        }
        else if (condition.equalsIgnoreCase("fog"))
        {
            imageView.setBackground(getDrawable(R.drawable.fog));
        }
        else if (condition.equalsIgnoreCase("showers"))
        {
            imageView.setBackground(getDrawable(R.drawable.showers));
        }
        else if (condition.equalsIgnoreCase("thunderstorms"))
        {
            imageView.setBackground(getDrawable(R.drawable.tstorms));
        }
    }

    private String convertFaranToCelci(String faran)
    {
        double dFaran = Double.parseDouble(faran);
        double dCelci = (double) Math.round((((dFaran - 32.0)*5)/9)*100)/100;

        return String.valueOf(dCelci);
    }
}