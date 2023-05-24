package com.apextech.digitalsignage;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.apextech.digitalsignage.data.database.AppDatabase;
import com.apextech.digitalsignage.data.database.AppExecutors;
import com.apextech.digitalsignage.data.model.response.boughtleafdailylinecollectionsummary.BoughtLineSummaryData;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BoughtLeafDailyLineActivity extends AppCompatActivity {

    TextView txtDate;
    TextView txtEstate1CollectorName, txtEstate2CollectorName, txtEstate3CollectorName, txtEstate4CollectorName;
    TextView txtEstate1CollectorID, txtEstate2CollectorID, txtEstate3CollectorID, txtEstate4CollectorID;
    TextView txtEstate1CollectorRoute, txtEstate2CollectorRoute, txtEstate3CollectorRoute, txtEstate4CollectorRoute;
    TextView txtEstate1CollectedQuantity, txtEstate2CollectedQuantity, txtEstate3CollectedQuantity, txtEstate4CollectedQuantity, txtGrandTotal;
    TextView txtCopyright, tvSummary, tvTitle;
    private LinearLayout progressLayout, contentLayout;
    Calendar myCalendar = Calendar.getInstance();
    private AppDatabase mDb;

    private List<BoughtLineSummaryData>boughtLineSummaryData;
    private String TAG = "BoughtLeafDailyLineActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bought_leaf_daily_line);

        initViews();
    }

    private void initViews()
    {
        txtDate = findViewById(R.id.tvCurrentDate);
        tvSummary = findViewById(R.id.tvSummaryText);
        tvTitle = findViewById(R.id.tvTitleText);
        txtEstate1CollectorName = findViewById(R.id.txtFirstEstateCollectorName_bought_leaf_line_activity);
        txtEstate2CollectorName = findViewById(R.id.txtSecondEstateCollectorName_bought_leaf_line_activity);
        txtEstate3CollectorName = findViewById(R.id.txtThirdEstateCollectorName_bought_leaf_line_activity);
        txtEstate4CollectorName = findViewById(R.id.txtFourthEstateCollectorName_bought_leaf_line_activity);
        txtEstate1CollectorID = findViewById(R.id.txtFirstEstateCollectorID_bought_leaf_line_activity);
        txtEstate2CollectorID = findViewById(R.id.txtSecondEstateCollectorID_bought_leaf_line_activity);
        txtEstate3CollectorID = findViewById(R.id.txtThirdEstateCollectorID_bought_leaf_line_activity);
        txtEstate4CollectorID = findViewById(R.id.txtFourthEstateCollectorID_bought_leaf_line_activity);
        txtEstate1CollectorRoute = findViewById(R.id.txtFirstEstateCollectorRoute_bought_leaf_line_activity);
        txtEstate2CollectorRoute = findViewById(R.id.txtSecondEstateCollectorRoute_bought_leaf_line_activity);
        txtEstate3CollectorRoute = findViewById(R.id.txtThirdEstateCollectorRoute_bought_leaf_line_activity);
        txtEstate4CollectorRoute = findViewById(R.id.txtFourthEstateCollectorRoute_bought_leaf_line_activity);
        txtEstate1CollectedQuantity = findViewById(R.id.txtFirstEstateQuantity_bought_leaf_line_activity);
        txtEstate2CollectedQuantity = findViewById(R.id.txtSecondEstateQuantity_bought_leaf_line_activity);
        txtEstate3CollectedQuantity = findViewById(R.id.txtThirdEstateQuantity_bought_leaf_line_activity);
        txtEstate4CollectedQuantity = findViewById(R.id.txtFourthEstateQuantity_bought_leaf_line_activity);
        txtGrandTotal = findViewById(R.id.txtTotal_new_weight_bought_leaf_line_activity);
        progressLayout = findViewById(R.id.progressLayout);
        contentLayout = findViewById(R.id.contentLayout);
        txtCopyright = findViewById(R.id.tvCopyRightText);

        mDb = AppDatabase.getInstance(getApplicationContext());

        populateUi();
    }

    private void populateUi()
    {
        progressLayout.setVisibility(View.VISIBLE);
        contentLayout.setVisibility(View.GONE);

        int day = myCalendar.get(Calendar.DATE);
        String monthName = (String)android.text.format.DateFormat.format("MMMM", new Date());
        int year = myCalendar.get(Calendar.YEAR);

        String calendarDate = day + ", " + monthName + " " + year;
        txtDate.setText(calendarDate);

        tvSummary.setText("Ragalla Factory Received 3,275 kg from Alma Estate, " + "High Forest Factory Dispatched 2,875 kg from No.1 Estate, " + "Liddesdale Factory Dispatched 3,235 kg from Harasbedda Estate, " + "Gonapitiya Factory Dispatched 875 kg from Keenagolla Estate");
        tvSummary.setSelected(true);
        String copyrightText = "Copyright @"+ Calendar.getInstance().get(Calendar.YEAR) +" Apex Technologies Private Limited";
        txtCopyright.setText(copyrightText);
        tvTitle.setText(getString(R.string.bought_leaf_daily_line_collection_summary));

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                fetchData();
            }
        }, 500);
    }

    private void setValueForScreen(List<BoughtLineSummaryData> mList)
    {
        if (mList != null && mList.size()>0)
        {
            txtEstate1CollectorName.setText((mList.get(0).getCollector_name() == null ? "" : mList.get(0).getCollector_name()));
            txtEstate1CollectorID.setText(String.valueOf((mList.get(0).getCollector_id()) == null ? "" : mList.get(0).getCollector_id()));
            txtEstate1CollectorRoute.setText((mList.get(0).getRoute() == null ? "" : mList.get(0).getRoute()));
            txtEstate1CollectedQuantity.setText(String.valueOf((mList.get(0).getCollected_quantities())== null ? "" : mList.get(0).getCollected_quantities()));

            if (mList.size()>1)
            {
                txtEstate2CollectorName.setText((mList.get(1).getCollector_name() == null ? "" : mList.get(1).getCollector_name()));
                txtEstate2CollectorID.setText(String.valueOf((mList.get(1).getCollector_id()) == null ? "" : mList.get(1).getCollector_id()));
                txtEstate2CollectorRoute.setText((mList.get(1).getRoute() == null ? "" : mList.get(1).getRoute()));
                txtEstate2CollectedQuantity.setText(String.valueOf((mList.get(1).getCollected_quantities())== null ? "" : mList.get(1).getCollected_quantities()));
            }

            if (mList.size()>2)
            {
                txtEstate3CollectorName.setText((mList.get(2).getCollector_name() == null ? "" : mList.get(2).getCollector_name()));
                txtEstate3CollectorID.setText(String.valueOf((mList.get(2).getCollector_id()) == null ? "" : mList.get(2).getCollector_id()));
                txtEstate3CollectorRoute.setText((mList.get(2).getRoute() == null ? "" : mList.get(2).getRoute()));
                txtEstate3CollectedQuantity.setText(String.valueOf((mList.get(2).getCollected_quantities())== null ? "" : mList.get(2).getCollected_quantities()));
            }

            if (mList.size()>3)
            {
                txtEstate4CollectorName.setText((mList.get(3).getCollector_name() == null ? "" : mList.get(3).getCollector_name()));
                txtEstate4CollectorID.setText(String.valueOf((mList.get(3).getCollector_id()) == null ? "" : mList.get(3).getCollector_id()));
                txtEstate4CollectorRoute.setText((mList.get(3).getRoute() == null ? "" : mList.get(3).getRoute()));
                txtEstate4CollectedQuantity.setText(String.valueOf((mList.get(3).getCollected_quantities())== null ? "" : mList.get(3).getCollected_quantities()));
            }

            txtGrandTotal.setText(getTotalWeight());
        }

        progressLayout.setVisibility(View.GONE);
        contentLayout.setVisibility(View.VISIBLE);
        navigateToNext();

    }

    private void fetchData()
    {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                final List<BoughtLineSummaryData> dataList = mDb.boughtLineSummaryDataDao().loadAllBoughtLineSummaryData();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        boughtLineSummaryData = dataList;
                        setValueForScreen(boughtLineSummaryData);
                    }
                });
            }
        });
    }

    @SuppressLint("DefaultLocale")
    private String getTotalWeight()
    {
        double tot = Double.parseDouble((txtEstate1CollectedQuantity.getText().toString().equals("") ? "0.0" : txtEstate1CollectedQuantity.getText().toString()))
                + Double.parseDouble((txtEstate2CollectedQuantity.getText().toString().equals("") ? "0.0" : txtEstate2CollectedQuantity.getText().toString()))
                + Double.parseDouble((txtEstate3CollectedQuantity.getText().toString().equals("") ? "0.0" : txtEstate3CollectedQuantity.getText().toString()))
                + Double.parseDouble((txtEstate4CollectedQuantity.getText().toString().equals("") ? "0.0" : txtEstate4CollectedQuantity.getText().toString()));

        return String.format("%.2f", tot);
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
                        //Intent intent = new Intent(BoughtLeafDailyLineActivity.this, ColomboWhetherActivity.class);
                        Intent intent = new Intent(BoughtLeafDailyLineActivity.this, DivisionalGrossQuantitiesActivity.class);
                        //Intent intent = new Intent(BoughtLeafDailyLineActivity.this, ColomboWhetherActivity.class);
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
}