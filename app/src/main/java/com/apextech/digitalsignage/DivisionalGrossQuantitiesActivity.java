package com.apextech.digitalsignage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.apextech.digitalsignage.data.database.AppDatabase;
import com.apextech.digitalsignage.data.database.AppExecutors;
import com.apextech.digitalsignage.data.model.response.divisionalgrossqty.DivisionData;
import com.apextech.digitalsignage.data.model.response.divisionalgrossqty.EstateData;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DivisionalGrossQuantitiesActivity extends AppCompatActivity {

    private TextView tvDate, txtCopyright, tvSummary, tvTitle;
    private Calendar myCalendar = Calendar.getInstance();
    private List<EstateData>myEstateData;
    private TextView tvHalgranoya, tvRagalaLower, tvRagalaMiddle, tvStafford, tvRagalaUpper, tvRagalaTotal;
    private TextView tvNo1, tvNo2, tvNo3, tvHighTotal, tvLDA, tvLDB, tvDiyanilla, tvHarasbedda, tvLiddesdaleTotal;
    private TextView tvGonapitiya, tvKeenagolla, tvGonakelle, tvMarigoldLower, tvMarigoldUpper, tvMahacoodagalla, tvGlendevon, tvConeygar, tvStLower, tvStUpper, tvGonapitiyaTotal, tvMahacoodagallaTotal, tvStTotal;
    private LinearLayout progressLayout, contentLayout;

    private String TAG = "DivisionalGrossQuantitiesActivity";
    private String sessionToken;
    private AppDatabase mDb;
    private List<DivisionData>myDivisionDataLIst;;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_divisional_gross_quantites);

        initViews();
    }

    private void initViews()
    {
        tvSummary = findViewById(R.id.tvSummaryText);
        tvDate = findViewById(R.id.tvCurrentDate);
        tvTitle = findViewById(R.id.tvTitleText);

        // Ragala TextViews
        tvHalgranoya = findViewById(R.id.tvHalgranoya);
        tvRagalaLower = findViewById(R.id.tvRagalaLower);
        tvRagalaMiddle = findViewById(R.id.tvRagalaMiddle);
        tvStafford = findViewById(R.id.tvStafford);
        tvRagalaUpper = findViewById(R.id.tvRagalaUpper);
        tvRagalaTotal = findViewById(R.id.tvRagalaTotal);

//        High Textviews
        tvNo1 = findViewById(R.id.tvNo1);
        tvNo2 = findViewById(R.id.tvNo2);
        tvNo3 = findViewById(R.id.tvNo3);
        tvHighTotal = findViewById(R.id.tvHighTotal);

//        Lddleslade Textviews
        tvLDA = findViewById(R.id.tvLDA);
        tvLDB = findViewById(R.id.tvLDB);
        tvDiyanilla = findViewById(R.id.tvDiyanilla);
        tvHarasbedda = findViewById(R.id.tvHarasbedda);
        tvLiddesdaleTotal = findViewById(R.id.tvLiddesdaleTotal);

//        Gonapitiya
        tvGonapitiya = findViewById(R.id.tvGonapitiya);
        tvGonakelle = findViewById(R.id.tvGonakelle);
        tvKeenagolla = findViewById(R.id.tvKeenagolla);
        tvMarigoldLower = findViewById(R.id.tvMarigoldLower);
        tvMarigoldUpper = findViewById(R.id.tvMarigoldUpper);
        tvGonapitiyaTotal = findViewById(R.id.tvGonapitiyaTotal);

//      Mahacoodagalla
        tvMahacoodagalla = findViewById(R.id.tvMahacoodagalla);
        tvGlendevon = findViewById(R.id.tvGlendevon);
        tvMahacoodagallaTotal = findViewById(R.id.tvMahacoodagallaTotal);

//      St. Leonards
        tvConeygar = findViewById(R.id.tvConeygar);
        tvStLower = findViewById(R.id.tvStLower);
        tvStUpper = findViewById(R.id.tvStUpper);
        tvStTotal = findViewById(R.id.tvLeonardTotal);

        progressLayout = findViewById(R.id.progressLayout);
        contentLayout = findViewById(R.id.contentLayout);

        mDb = AppDatabase.getInstance(getApplicationContext());

        populateUi();
    }

    private void populateUi()
    {
        progressLayout.setVisibility(View.VISIBLE);
        contentLayout.setVisibility(View.GONE);

        tvTitle.setText(getString(R.string.divisional_gross_title));
        tvSummary.setText("Ragalla Factory Received 3,275 kg from Alma Estate, " + "High Forest Factory Dispatched 2,875 kg from No.1 Estate, " + "Liddesdale Factory Dispatched 3,235 kg from Harasbedda Estate, " + "Gonapitiya Factory Dispatched 875 kg from Keenagolla Estate");
        tvSummary.setSelected(true);

        int day = myCalendar.get(Calendar.DATE);
        String monthName = (String)android.text.format.DateFormat.format("MMMM", new Date());
        int year = myCalendar.get(Calendar.YEAR);
        String calendarDate = day + ", " + monthName + " " + year;
        tvDate.setText(calendarDate);

        txtCopyright = findViewById(R.id.tvCopyRightText);
        txtCopyright.setText("Copyright @"+ String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) +" Apex Technologies Private Limited");

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        sessionToken = preferences.getString("SESSION_TOKEN","");

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                fetchData();
            }
        }, 500);
    }

    private void setValuesForScreen(List<EstateData> estList, List<DivisionData> divList)
    {
        if (estList.size()>0)
        {
            if (divList.size()>0)
            {
                //Ragala
                tvHalgranoya.setText(String.valueOf(((divList.get(0).getGross_quantity_collected() == null ? "" : divList.get(0).getGross_quantity_collected()))));
                tvRagalaLower.setText(String.valueOf(((divList.get(1).getGross_quantity_collected() == null ? "" : divList.get(1).getGross_quantity_collected()))));
                tvRagalaMiddle.setText(String.valueOf(((divList.get(2).getGross_quantity_collected() == null ? "" : divList.get(2).getGross_quantity_collected()))));
                tvStafford.setText(String.valueOf(divList.get(3).getGross_quantity_collected() == null ? "" : divList.get(3).getGross_quantity_collected()));
                tvRagalaUpper.setText(String.valueOf(divList.get(4).getGross_quantity_collected() == null ? "" : divList.get(4).getGross_quantity_collected()));

                //High
                tvNo1.setText(String.valueOf(((divList.get(5).getGross_quantity_collected() == null ? "" : divList.get(5).getGross_quantity_collected()))));
                tvNo2.setText(String.valueOf(((divList.get(6).getGross_quantity_collected() == null ? "" : divList.get(6).getGross_quantity_collected()))));
                tvNo3.setText(String.valueOf(((divList.get(7).getGross_quantity_collected() == null ? "" : divList.get(7).getGross_quantity_collected()))));

                // Lideslade
                tvLDA.setText(String.valueOf(divList.get(8).getGross_quantity_collected() == null ? "" : divList.get(8).getGross_quantity_collected()));
                tvLDB.setText(String.valueOf(divList.get(9).getGross_quantity_collected() == null ? "" : divList.get(9).getGross_quantity_collected()));
                tvDiyanilla.setText(String.valueOf(divList.get(10).getGross_quantity_collected() == null ? "" : divList.get(10).getGross_quantity_collected()));
                tvHarasbedda.setText(String.valueOf(divList.get(11).getGross_quantity_collected() == null ? "" : divList.get(11).getGross_quantity_collected()));

                // Gonapitiya
                tvGonapitiya.setText(String.valueOf(divList.get(12).getGross_quantity_collected() == null ? "" : divList.get(12).getGross_quantity_collected()));
                tvKeenagolla.setText(String.valueOf(divList.get(13).getGross_quantity_collected() == null ? "" : divList.get(13).getGross_quantity_collected()));
                tvGonakelle.setText(String.valueOf(divList.get(14).getGross_quantity_collected() == null ? "" : divList.get(14).getGross_quantity_collected()));
                tvMarigoldLower.setText(String.valueOf(divList.get(15).getGross_quantity_collected() == null ? "" : divList.get(15).getGross_quantity_collected()));
                tvMarigoldUpper.setText(String.valueOf(divList.get(16).getGross_quantity_collected() == null ? "" : divList.get(16).getGross_quantity_collected()));

                // Mahacoodagalla
                tvMahacoodagalla.setText(String.valueOf(divList.get(17).getGross_quantity_collected() == null ? "" : divList.get(17).getGross_quantity_collected()));
                tvGlendevon.setText(String.valueOf(divList.get(18).getGross_quantity_collected() == null ? "" : divList.get(18).getGross_quantity_collected()));

                // St. Leonard
                tvConeygar.setText(String.valueOf(divList.get(19).getGross_quantity_collected() == null ? "" : divList.get(19).getGross_quantity_collected()));
                tvStLower.setText(String.valueOf(divList.get(20).getGross_quantity_collected() == null ? "" : divList.get(20).getGross_quantity_collected()));
                tvStUpper.setText(String.valueOf(divList.get(21).getGross_quantity_collected() == null ? "" : divList.get(21).getGross_quantity_collected()));

                tvRagalaTotal.setText(String.valueOf(myEstateData.get(0).getTotal_gross()));
                tvHighTotal.setText(String.valueOf(myEstateData.get(1).getTotal_gross()));
                tvLiddesdaleTotal.setText(String.valueOf(myEstateData.get(2).getTotal_gross()));
                tvGonapitiyaTotal.setText(String.valueOf(myEstateData.get(3).getTotal_gross()));
                tvMahacoodagallaTotal.setText(String.valueOf(myEstateData.get(4).getTotal_gross()));
                tvStTotal.setText(String.valueOf(myEstateData.get(5).getTotal_gross()));
            }
        }

        contentLayout.setVisibility(View.VISIBLE);
        progressLayout.setVisibility(View.GONE);
        navigateToNext();
    }

    private void navigateToNext()
    {
        ArrayList<String> cDateList = getIntent().getStringArrayListExtra("C_DATElIST");
        ArrayList<String> cMaxList = getIntent().getStringArrayListExtra("C_MAXlIST");
        ArrayList<String> cMinList = getIntent().getStringArrayListExtra("C_MINlIST");
        ArrayList<String> cConList = getIntent().getStringArrayListExtra("C_CONLIST");

        ArrayList<String> kDateList = getIntent().getStringArrayListExtra("K_DATElIST");
        ArrayList<String> kMaxList = getIntent().getStringArrayListExtra("K_MAXlIST");
        ArrayList<String> kMinList = getIntent().getStringArrayListExtra("K_MINlIST");
        ArrayList<String> kConList = getIntent().getStringArrayListExtra("K_CONLIST");

        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(DivisionalGrossQuantitiesActivity.this, FactoryCollectionSummaryActivity.class);
//                      // colombo data
                        intent.putExtra("C_DATElIST", cDateList);
                        intent.putExtra("C_MAXlIST", cMaxList);
                        intent.putExtra("C_MINlIST", cMinList);
                        intent.putExtra("C_CONLIST", cConList);
                        //kandy data
                        intent.putExtra("K_DATElIST", kDateList);
                        intent.putExtra("K_MAXlIST", kMaxList);
                        intent.putExtra("K_MINlIST", kMinList);
                        intent.putExtra("K_CONLIST", kConList);

                        //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    }
                },
                10000
        );
    }

    private void fetchData()
    {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                final List<EstateData> dataList = mDb.estateDataDao().loadAllEstateData();
                final List<DivisionData> divisionDataList = mDb.divisionDataDao().loadAllDivisionData();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        myEstateData = dataList;
                        myDivisionDataLIst = divisionDataList;
                        setValuesForScreen(myEstateData, myDivisionDataLIst);
                    }
                });
            }
        });
    }
}