package com.apextech.digitalsignage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.apextech.digitalsignage.data.database.AppDatabase;
import com.apextech.digitalsignage.data.database.AppExecutors;
import com.apextech.digitalsignage.data.model.response.boughtleatdailyfactorycollectionsummary.BoughtFactorySummaryData;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BoughtLeafDailyFactoryActivity extends AppCompatActivity {

    TextView txtDate;
    TextView txtEstate1FactoryOfficerName, txtEstate2FactoryOfficerName, txtEstate3FactoryOfficerName, txtEstate4FactoryOfficerName;
    TextView txtEstate1ProcessedSupplierCount, txtEstate2ProcessedSupplierCount, txtEstate3ProcessedSupplierCount, txtEstate4ProcessedSupplierCount;
    TextView txtEstate1GrossWeightReceived, txtEstate2GrossWeightReceived, txtEstate3GrossWeightReceived, txtEstate4GrossWeightReceived;
    TextView txtEstate1NetWeightAccepted, txtEstate2NetWeightAccepted, txtEstate3NetWeightAccepted, txtEstate4NetWeightAccepted, txtNetGrandTotal, txtGrossGrandTotal, txtCountGrandTotal;
    TextView txtCopyright, tvSummary, tvTitle;
    private LinearLayout progressLayout, contentLayout;
    Calendar myCalendar = Calendar.getInstance();

    private List<BoughtFactorySummaryData> boughtFactorySummaryData;
    private AppDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bought_leaf_daily_factory);

        initViews();
    }

    private void initViews()
    {
        txtDate = findViewById(R.id.tvCurrentDate);
        tvSummary = findViewById(R.id.tvSummaryText);
        tvTitle = findViewById(R.id.tvTitleText);
        txtEstate1FactoryOfficerName = findViewById(R.id.txtFirstEstateFactoryOfficerName_bought_leaf_factory_activity);
        txtEstate2FactoryOfficerName = findViewById(R.id.txtSecondEstateFactoryOfficerName_bought_leaf_factory_activity);
        txtEstate3FactoryOfficerName = findViewById(R.id.txtThirdEstateFactoryOfficerName_bought_leaf_factory_activity);
        txtEstate4FactoryOfficerName = findViewById(R.id.txtFourthEstateFactoryOfficerName_bought_leaf_factory_activity);
        txtEstate1ProcessedSupplierCount = findViewById(R.id.txtFirstEstateSupplierCountProcessed_bought_leaf_factory_activity);
        txtEstate2ProcessedSupplierCount = findViewById(R.id.txtSecondEstateSupplierCountProcessed_bought_leaf_factory_activity);
        txtEstate3ProcessedSupplierCount = findViewById(R.id.txtThirdEstateSupplierCountProcessed_bought_leaf_factory_activity);
        txtEstate4ProcessedSupplierCount = findViewById(R.id.txtFourthEstateSupplierCountProcessed_bought_leaf_factory_activity);
        txtEstate1GrossWeightReceived = findViewById(R.id.txtFirstEstateTotalGrossWeightReceived_bought_leaf_factory_activity);
        txtEstate2GrossWeightReceived = findViewById(R.id.txtSecondEstateTotalGrossWeightReceived_bought_leaf_factory_activity);
        txtEstate3GrossWeightReceived = findViewById(R.id.txtThirdEstateTotalGrossWeightReceived_bought_leaf_factory_activity);
        txtEstate4GrossWeightReceived = findViewById(R.id.txtFourthEstateTotalGrossWeightReceived_bought_leaf_factory_activity);
        txtEstate1NetWeightAccepted = findViewById(R.id.txtFirstTotalNetWeightAccepted_bought_leaf_factory_activity);
        txtEstate2NetWeightAccepted = findViewById(R.id.txtSecondTotalNetWeightAccepted_bought_leaf_factory_activity);
        txtEstate3NetWeightAccepted = findViewById(R.id.txtThirdTotalNetWeightAccepted_bought_leaf_factory_activity);
        txtEstate4NetWeightAccepted = findViewById(R.id.txtFourthTotalNetWeightAccepted_bought_leaf_factory_activity);
        txtNetGrandTotal = findViewById(R.id.txtTotal_new_weight_bought_leaf_factory_activity);
        txtCountGrandTotal = findViewById(R.id.txtTotal_SupplierCountProcessed_bought_leaf_factory_activity);
        txtGrossGrandTotal =findViewById(R.id.txtTotal_gross_weight_bought_leaf_factory_activity);
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

        tvTitle.setText(getString(R.string.bought_leaf_daily_factory_collection_summary));

        int day = myCalendar.get(Calendar.DATE);
        String monthName = (String)android.text.format.DateFormat.format("MMMM", new Date());
        int year = myCalendar.get(Calendar.YEAR);

        String calendarDate = day + ", " + monthName + " " + year;
        txtDate.setText(calendarDate);

        tvSummary.setText("Ragalla Factory Received 3,275 kg from Alma Estate, " + "High Forest Factory Dispatched 2,875 kg from No.1 Estate, " + "Liddesdale Factory Dispatched 3,235 kg from Harasbedda Estate, " + "Gonapitiya Factory Dispatched 875 kg from Keenagolla Estate");
        tvSummary.setSelected(true);
        String copyrightText = "Copyright @"+ Calendar.getInstance().get(Calendar.YEAR) +" Apex Technologies Private Limited";
        txtCopyright.setText(copyrightText);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                fetchData();
            }
        }, 500);
    }

    private void setValuesForScreen(List<BoughtFactorySummaryData> mList)
    {
        if (mList != null && mList.size()>0)
        {
            txtEstate1FactoryOfficerName.setText(String.valueOf((mList.get(0).getFactory_officer_name() == null ? "" : mList.get(0).getFactory_officer_name())));
            txtEstate1ProcessedSupplierCount.setText(String.valueOf((mList.get(0).getSuppliers_count_processed() == null ? "" : mList.get(0).getSuppliers_count_processed())));
            txtEstate1GrossWeightReceived.setText(String.valueOf((mList.get(0).getTotal_gross_weight_received() == null ? "" : mList.get(0).getTotal_gross_weight_received())));
            txtEstate1NetWeightAccepted.setText(String.valueOf((mList.get(0).getTotal_net_weight_received() == null ? "" : mList.get(0).getTotal_net_weight_received())));

            if (mList.size()>1)
            {
                txtEstate2FactoryOfficerName.setText(String.valueOf((mList.get(1).getFactory_officer_name() == null ? "" : mList.get(1).getFactory_officer_name())));
                txtEstate2ProcessedSupplierCount.setText(String.valueOf((mList.get(1).getSuppliers_count_processed() == null ? "" : mList.get(1).getSuppliers_count_processed())));
                txtEstate2GrossWeightReceived.setText(String.valueOf((mList.get(1).getTotal_gross_weight_received() == null ? "" : mList.get(1).getTotal_gross_weight_received())));
                txtEstate2NetWeightAccepted.setText(String.valueOf((mList.get(1).getTotal_net_weight_received() == null ? "" : mList.get(1).getTotal_net_weight_received())));
            }

            if (mList.size()>2)
            {
                txtEstate3FactoryOfficerName.setText(String.valueOf((mList.get(2).getFactory_officer_name() == null ? "" : mList.get(2).getFactory_officer_name())));
                txtEstate3ProcessedSupplierCount.setText(String.valueOf((mList.get(2).getSuppliers_count_processed() == null ? "" : mList.get(2).getSuppliers_count_processed())));
                txtEstate3GrossWeightReceived.setText(String.valueOf((mList.get(2).getTotal_gross_weight_received() == null ? "" : mList.get(2).getTotal_gross_weight_received())));
                txtEstate3NetWeightAccepted.setText(String.valueOf((mList.get(2).getTotal_net_weight_received() == null ? "" : mList.get(2).getTotal_net_weight_received())));
            }

            if (mList.size()>3)
            {
                txtEstate4FactoryOfficerName.setText(String.valueOf((mList.get(3).getFactory_officer_name() == null ? "" : mList.get(3).getFactory_officer_name())));
                txtEstate4ProcessedSupplierCount.setText(String.valueOf((mList.get(3).getSuppliers_count_processed() == null ? "" : mList.get(3).getSuppliers_count_processed())));
                txtEstate4GrossWeightReceived.setText(String.valueOf((mList.get(3).getTotal_gross_weight_received() == null ? "" : mList.get(3).getTotal_gross_weight_received())));
                txtEstate4NetWeightAccepted.setText(String.valueOf((mList.get(3).getTotal_net_weight_received() == null ? "" : mList.get(3).getTotal_net_weight_received())));
            }

            txtCountGrandTotal.setText(getProcessedCount());
            txtGrossGrandTotal.setText(getGrossWeight());
            txtNetGrandTotal.setText(getNetWeight());
        }

        progressLayout.setVisibility(View.GONE);
        contentLayout.setVisibility(View.VISIBLE);
        navigateToNext();
    }

    private String getProcessedCount ()
    {
        double value1 = Double.parseDouble((txtEstate1ProcessedSupplierCount.getText().toString().equals("") ? "0.0" : txtEstate1ProcessedSupplierCount.getText().toString()))
                + Double.parseDouble((txtEstate2ProcessedSupplierCount.getText().toString().equals("") ? "0.0" : txtEstate2ProcessedSupplierCount.getText().toString()))
                + Double.parseDouble((txtEstate3ProcessedSupplierCount.getText().toString().equals("") ? "0.0" : txtEstate3ProcessedSupplierCount.getText().toString()))
                + Double.parseDouble((txtEstate4ProcessedSupplierCount.getText().toString().equals("") ? "0.0" : txtEstate4ProcessedSupplierCount.getText().toString()));

        return String.valueOf(value1);
    }

    private String getGrossWeight ()
    {
        double value1 = Double.parseDouble((txtEstate1GrossWeightReceived.getText().toString().equals("") ? "0.0" : txtEstate1GrossWeightReceived.getText().toString()))
                + Double.parseDouble((txtEstate2GrossWeightReceived.getText().toString().equals("") ? "0.0" : txtEstate2GrossWeightReceived.getText().toString()))
                + Double.parseDouble((txtEstate3GrossWeightReceived.getText().toString().equals("") ? "0.0" : txtEstate3GrossWeightReceived.getText().toString()))
                + Double.parseDouble((txtEstate4GrossWeightReceived.getText().toString().equals("") ? "0.0" : txtEstate4GrossWeightReceived.getText().toString()));

        return String.valueOf(value1);
    }

    private String getNetWeight ()
    {
        double value1 = Double.parseDouble((txtEstate1NetWeightAccepted.getText().toString().equals("") ? "0.0" : txtEstate1NetWeightAccepted.getText().toString()))
                + Double.parseDouble((txtEstate2NetWeightAccepted.getText().toString().equals("") ? "0.0" : txtEstate2NetWeightAccepted.getText().toString()))
                + Double.parseDouble((txtEstate3NetWeightAccepted.getText().toString().equals("") ? "0.0" : txtEstate3NetWeightAccepted.getText().toString()))
                + Double.parseDouble((txtEstate4NetWeightAccepted.getText().toString().equals("") ? "0.0" : txtEstate4NetWeightAccepted.getText().toString()));

        return String.valueOf(value1);
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
                        Intent intent = new Intent(BoughtLeafDailyFactoryActivity.this, BoughtLeafDailyLineActivity.class);
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
                final List<BoughtFactorySummaryData> dataList = mDb.boughtFactorySummaryDataDao().loadAllBoughtFactorySummaryData();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        boughtFactorySummaryData = dataList;
                        setValuesForScreen(boughtFactorySummaryData);
                    }
                });
            }
        });
    }
}