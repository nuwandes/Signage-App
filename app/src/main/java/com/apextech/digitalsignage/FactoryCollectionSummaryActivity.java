package com.apextech.digitalsignage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.apextech.digitalsignage.data.database.AppDatabase;
import com.apextech.digitalsignage.data.database.AppExecutors;
import com.apextech.digitalsignage.data.model.response.factorycollectonsummary.FactoryCollectionSummaryData;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FactoryCollectionSummaryActivity extends AppCompatActivity {

    private TextView tvDate, txtCopyright, tvSummary, tvTitle;
    private Calendar myCalendar = Calendar.getInstance();
    private List<FactoryCollectionSummaryData> factoryCollectionSummaryData;
    private TextView tvRagalaEstateLeaf, tvRagalaInterEstateLeaf, tvRagalaTotalGross, tvRagalaTotalNet;
    private TextView tvHighEstateLeaf, tvHighInterEstateLeaf, tvHighTotalGross, tvHighTotalNet;
    private TextView tvLiddleEstateLeaf, tvLiddleInterEstateLeaf, tvLiddleTotalGross, tvLiddleTotalNet;
    private TextView tvGonapitiyaEstateLeaf, tvGonapitiyaInterEstateLeaf, tvGonapitiyaTotalGross, tvGonapitiyaTotalNet;
    private LinearLayout progressLayout, contentLayout;
    private AppDatabase aDb;

    private String TAG = "FactoryCollectionSummaryActivity";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factory_collection_summary);

        initViews();
    }

    private void initViews() {
        tvSummary = findViewById(R.id.tvSummaryText);
        tvDate = findViewById(R.id.tvCurrentDate);
        tvTitle = findViewById(R.id.tvTitleText);

        tvRagalaEstateLeaf = findViewById(R.id.tvRagalaEstateLeaf);
        tvRagalaInterEstateLeaf = findViewById(R.id.tvRagalaInterEstateLeaf);
        tvRagalaTotalGross = findViewById(R.id.tvRagalaTotalGross);
        tvRagalaTotalNet = findViewById(R.id.tvRagalaTotalNet);

        tvHighEstateLeaf = findViewById(R.id.tvHighForestEstateLeaf);
        tvHighInterEstateLeaf = findViewById(R.id.tvHighForestInterEstateLeaf);
        tvHighTotalGross = findViewById(R.id.tvHighForestTotalGross);
        tvHighTotalNet = findViewById(R.id.tvHighForestTotalNet);

        tvLiddleEstateLeaf = findViewById(R.id.tvLiddesdaleEstateLeaf);
        tvLiddleInterEstateLeaf = findViewById(R.id.tvLiddesdaleInterEstateLeaf);
        tvLiddleTotalGross = findViewById(R.id.tvLiddesdaleTotalGross);
        tvLiddleTotalNet = findViewById(R.id.tvLiddesdaleTotalNet);

        tvGonapitiyaEstateLeaf = findViewById(R.id.tvGonapitiyaEstateLeaf);
        tvGonapitiyaInterEstateLeaf = findViewById(R.id.tvGonapitiyaInterEstateLeaf);
        tvGonapitiyaTotalGross = findViewById(R.id.tvGonapitiyaTotalGross);
        tvGonapitiyaTotalNet = findViewById(R.id.tvGonapitiyaTotalNet);

        progressLayout = findViewById(R.id.progressLayout);
        contentLayout = findViewById(R.id.contentLayout);

        aDb = AppDatabase.getInstance(getApplicationContext());

        populateUI();
    }

    private void populateUI()
    {
        progressLayout.setVisibility(View.VISIBLE);
        contentLayout.setVisibility(View.GONE);

        tvTitle.setText(getString(R.string.text_factory_collection_summary));
        tvSummary.setText("Ragalla Factory Received 3,275 kg from Alma Estate, " + "High Forest Factory Dispatched 2,875 kg from No.1 Estate, " + "Liddesdale Factory Dispatched 3,235 kg from Harasbedda Estate, " + "Gonapitiya Factory Dispatched 875 kg from Keenagolla Estate");
        tvSummary.setSelected(true);
        //setAnimation(tvSummary);

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
                fetchData();
            }
        }, 500);
    }


    private void setValuesForScreen(List<FactoryCollectionSummaryData> mList)
    {
        if (mList != null && mList.size()>0)
        {
            tvRagalaEstateLeaf.setText(String.valueOf(((mList.get(0) == null ? "" : mList.get(0).getEstate_leaf()))));
            tvRagalaInterEstateLeaf.setText(String.valueOf(((mList.get(0) == null ? "" : mList.get(0).getInner_estate_leaf()))));
            tvRagalaTotalGross.setText(String.valueOf(((mList.get(0) == null ? "" : mList.get(0).getTotal_gross()))));
            tvRagalaTotalNet.setText(String.valueOf(((mList.get(0) == null ? "" : mList.get(0).getTotal_net()))));

            if (mList.size()>1)
            {
                tvHighEstateLeaf.setText(String.valueOf(((mList.get(1) == null ? "" : mList.get(1).getEstate_leaf()))));
                tvHighInterEstateLeaf.setText(String.valueOf(((mList.get(1) == null ? "" : mList.get(1).getInner_estate_leaf()))));
                tvHighTotalGross.setText(String.valueOf(((mList.get(1) == null ? "" : mList.get(1).getTotal_gross()))));
                tvHighTotalNet.setText(String.valueOf(((mList.get(1) == null ? "" : mList.get(1).getTotal_net()))));
            }

            if (mList.size()>2)
            {
                tvLiddleEstateLeaf.setText(String.valueOf(((mList.get(2) == null ? "" : mList.get(2).getEstate_leaf()))));
                tvLiddleInterEstateLeaf.setText(String.valueOf(((mList.get(2) == null ? "" : mList.get(2).getInner_estate_leaf()))));
                tvLiddleTotalGross.setText(String.valueOf(((mList.get(2) == null ? "" : mList.get(2).getTotal_gross()))));
                tvLiddleTotalNet.setText(String.valueOf(((mList.get(2) == null ? "" : mList.get(2).getTotal_net()))));
            }

            if (mList.size()>3)
            {
                tvGonapitiyaEstateLeaf.setText(String.valueOf(((mList.get(3) == null ? "" : mList.get(3).getEstate_leaf()))));
                tvGonapitiyaInterEstateLeaf.setText(String.valueOf(((mList.get(3) == null ? "" : mList.get(3).getInner_estate_leaf()))));
                tvGonapitiyaTotalGross.setText(String.valueOf(((mList.get(3) == null ? "" : mList.get(3).getTotal_gross()))));
                tvGonapitiyaTotalNet.setText(String.valueOf(((mList.get(3) == null ? "" : mList.get(3).getTotal_net()))));
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
                        //Intent intent = new Intent(FactoryCollectionSummaryActivity.this, KandyWhetherActivity.class);
                        Intent intent = new Intent(FactoryCollectionSummaryActivity.this, InterEstateLeafDailySummaryActivity.class);
                        // colombo data
                        intent.putExtra("C_DATElIST", cDateList);
                        intent.putExtra("C_MAXlIST", cMaxList);
                        intent.putExtra("C_MINlIST", cMinList);
                        intent.putExtra("C_CONLIST", cConList);
                        //kandy data
                        intent.putExtra("K_DATElIST", kDateList);
                        intent.putExtra("K_MAXlIST", kMaxList);
                        intent.putExtra("K_MINlIST", kMinList);
                        intent.putExtra("K_CONLIST", kConList);

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
                final List<FactoryCollectionSummaryData> dataList = aDb.factoryCollectionSummaryDataDao().loadAllFactoryCollectionSummaryData();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        factoryCollectionSummaryData = dataList;
                        setValuesForScreen(factoryCollectionSummaryData);
                    }
                });
            }
        });
    }
}