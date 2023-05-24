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
import com.apextech.digitalsignage.data.model.response.interstateleafdailysummary.InterEstateLeafDailySummaryData;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class InterEstateLeafDailySummaryActivity extends AppCompatActivity {

    TextView txtHeader, txtDate;
    TextView txtEstate1Name, txtEstate2Name, txtEstate3Name, txtEstate4Name, txtEstate5Name, txtEstate6Name,txtEstate7Name;
    TextView txtEstate1TotalQuantity, txtEstate2TotalQuantity, txtEstate3TotalQuantity, txtEstate4TotalQuantity, txtEstate5TotalQuantity, txtEstate6TotalQuantity,txtEstate7TotalQuantity;
    TextView txtEstate1DestinationEstate, txtEstate2DestinationEstate, txtEstate3DestinationEstate, txtEstate4DestinationEstate, txtEstate5DestinationEstate, txtEstate6DestinationEstate, txtEstate7DestinationEstate;
    TextView txtEstate1ConfirmedReceivedQuantity, txtEstate2ConfirmedReceivedQuantity, txtEstate3ConfirmedReceivedQuantity, txtEstate4ConfirmedReceivedQuantity, txtEstate5ConfirmedReceivedQuantity, txtEstate6ConfirmedReceivedQuantity, txtEstate7ConfirmedReceivedQuantity;
    TextView txtSummaryText, txtCopyright;
    private LinearLayout progressLayout, contentLayout;
    Calendar myCalendar = Calendar.getInstance();
    private AppDatabase mDb;

    private List<InterEstateLeafDailySummaryData> innerEstateLeafDailySummaryData;
    private String TAG = "InterEstateLeafDailySummaryActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter_estate_leaf_daily_summary);

        initViews();
    }

    private void initViews()
    {
        txtHeader = findViewById(R.id.tvTitleText);
        txtDate = findViewById(R.id.tvCurrentDate);
        txtEstate1Name = findViewById(R.id.txtFirstEstateName_inter_estate_daily_summary);
        txtEstate2Name = findViewById(R.id.txtSecondEstateName_inter_estate_daily_summary);
        txtEstate3Name = findViewById(R.id.txtThirdEstateName_inter_estate_daily_summary);
        txtEstate4Name = findViewById(R.id.txtFourthEstateName_inter_estate_daily_summary);
        txtEstate5Name = findViewById(R.id.txtFifthEstateName_inter_estate_daily_summary);
        txtEstate6Name = findViewById(R.id.txtSixthEstateName_inter_estate_daily_summary);
        txtEstate7Name = findViewById(R.id.txtSeventhEstateName_inter_estate_daily_summary);
        txtEstate1TotalQuantity = findViewById(R.id.txtFirstEstateTotalQuantity_inter_estate_daily_summary);
        txtEstate2TotalQuantity = findViewById(R.id.txtSecondEstateTotalQuantity_inter_estate_daily_summary);
        txtEstate3TotalQuantity = findViewById(R.id.txtThirdEstateTotalQuantity_inter_estate_daily_summary);
        txtEstate4TotalQuantity = findViewById(R.id.txtFourthEstateTotalQuantity_inter_estate_daily_summary);
        txtEstate5TotalQuantity = findViewById(R.id.txtFifthEstateTotalQuantity_inter_estate_daily_summary);
        txtEstate6TotalQuantity = findViewById(R.id.txtSixthEstateTotalQuantity_inter_estate_daily_summary);
        txtEstate7TotalQuantity = findViewById(R.id.txtSeventhEstateTotalQuantity_inter_estate_daily_summary);
        txtEstate1DestinationEstate = findViewById(R.id.txtFirstEstateDestinationEstate_inter_estate_daily_summary);
        txtEstate2DestinationEstate = findViewById(R.id.txtSecondEstateDestinationEstate_inter_estate_daily_summary);
        txtEstate3DestinationEstate = findViewById(R.id.txtThirdEstateDestinationEstate_inter_estate_daily_summary);
        txtEstate4DestinationEstate = findViewById(R.id.txtFourthEstateDestinationEstate_inter_estate_daily_summary);
        txtEstate5DestinationEstate = findViewById(R.id.txtFifthEstateDestinationEstate_inter_estate_daily_summary);
        txtEstate6DestinationEstate = findViewById(R.id.txtSixthEstateDestinationEstate_inter_estate_daily_summary);
        txtEstate7DestinationEstate = findViewById(R.id.txtSeventhEstateDestinationEstate_inter_estate_daily_summary);
        txtEstate1ConfirmedReceivedQuantity = findViewById(R.id.txtFirstConfirmedReceivedQuantity_inter_estate_daily_summary);
        txtEstate2ConfirmedReceivedQuantity = findViewById(R.id.txtSecondConfirmedReceivedQuantity_inter_estate_daily_summary);
        txtEstate3ConfirmedReceivedQuantity = findViewById(R.id.txtThirdConfirmedReceivedQuantity_inter_estate_daily_summary);
        txtEstate4ConfirmedReceivedQuantity = findViewById(R.id.txtFourthConfirmedReceivedQuantity_inter_estate_daily_summary);
        txtEstate5ConfirmedReceivedQuantity = findViewById(R.id.txtFifthConfirmedReceivedQuantity_inter_estate_daily_summary);
        txtEstate6ConfirmedReceivedQuantity = findViewById(R.id.txtSixthConfirmedReceivedQuantity_inter_estate_daily_summary);
        txtEstate7ConfirmedReceivedQuantity = findViewById(R.id.txtSeventhConfirmedReceivedQuantity_inter_estate_daily_summary);

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

        String copyrightText = "Copyright "+ Calendar.getInstance().get(Calendar.YEAR) +" Apex Technologies Private Limited";
        txtCopyright.setText(copyrightText);

        txtHeader.setText("Inter Estate Leaf Daily Summary");

        int day = myCalendar.get(Calendar.DATE);
        String monthName = (String)android.text.format.DateFormat.format("MMMM", new Date());
        int year = myCalendar.get(Calendar.YEAR);

        String calendarDate = day + ", " + monthName + " " + year;
        txtDate.setText(calendarDate);

        txtSummaryText = findViewById(R.id.tvSummaryText);
        txtSummaryText.setText("Ragalla Factory Received 3,275 kg from Alma Estate, " + "High Forest Factory Dispatched 2,875 kg from No.1 Estate, " + "Liddesdale Factory Dispatched 3,235 kg from Harasbedda Estate, " + "Gonapitiya Factory Dispatched 875 kg from Keenagolla Estate");
        txtSummaryText.setSelected(true);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                fetchData();
            }
        }, 500);
    }

    private void setValuesForScreen(List<InterEstateLeafDailySummaryData> mList)
    {
        if (mList != null && mList.size()>0)
        {
            txtEstate1Name.setText(String.valueOf(((mList.get(0).getEstate_name() == null ? "" : mList.get(0).getEstate_name()))));
            txtEstate1TotalQuantity.setText(String.valueOf(((mList.get(0).getTotal_collected() == null ? "" : mList.get(0).getTotal_collected()))));
            txtEstate1DestinationEstate.setText(String.valueOf((mList.get(0).getDestination() == null ? "" : mList.get(0).getDestination())));
            txtEstate1ConfirmedReceivedQuantity.setText(String.valueOf(((mList.get(0).getDestination_confirm_received() == null ? "" : mList.get(0).getDestination_confirm_received()))));

            if (mList.size()>1)
            {
                txtEstate2Name.setText(String.valueOf(((mList.get(1).getEstate_name() == null ? "" : mList.get(1).getEstate_name()))));
                txtEstate2TotalQuantity.setText(String.valueOf(((mList.get(1).getTotal_collected() == null ? "" : mList.get(1).getTotal_collected()))));
                txtEstate2DestinationEstate.setText(String.valueOf((mList.get(1).getDestination() == null ? "" : mList.get(1).getDestination())));
                txtEstate2ConfirmedReceivedQuantity.setText(String.valueOf(((mList.get(1).getDestination_confirm_received() == null ? "" : mList.get(1).getDestination_confirm_received()))));
            }

            if (mList.size()>2)
            {
                txtEstate3Name.setText(String.valueOf(((mList.get(2).getEstate_name() == null ? "" : mList.get(2).getEstate_name()))));
                txtEstate3TotalQuantity.setText(String.valueOf(((mList.get(2).getTotal_collected() == null ? "" : mList.get(2).getTotal_collected()))));
                txtEstate3DestinationEstate.setText(String.valueOf((mList.get(2).getDestination() == null ? "" : mList.get(2).getDestination())));
                txtEstate3ConfirmedReceivedQuantity.setText(String.valueOf(((mList.get(2).getDestination_confirm_received() == null ? "" : mList.get(2).getDestination_confirm_received()))));
            }

            if (mList.size()>3)
            {
                txtEstate4Name.setText(String.valueOf(((mList.get(3).getEstate_name() == null ? "" : mList.get(3).getEstate_name()))));
                txtEstate4TotalQuantity.setText(String.valueOf(((mList.get(3).getTotal_collected() == null ? "" : mList.get(3).getTotal_collected()))));
                txtEstate4DestinationEstate.setText(String.valueOf((mList.get(3).getDestination() == null ? "" : mList.get(3).getDestination())));
                txtEstate4ConfirmedReceivedQuantity.setText(String.valueOf(((mList.get(3).getDestination_confirm_received() == null ? "" : mList.get(3).getDestination_confirm_received()))));
            }

            if (mList.size()>4)
            {
                txtEstate5Name.setText(String.valueOf(((mList.get(4).getEstate_name() == null ? "" : mList.get(4).getEstate_name()))));
                txtEstate5TotalQuantity.setText(String.valueOf(((mList.get(4).getTotal_collected() == null ? "" : mList.get(4).getTotal_collected()))));
                txtEstate5DestinationEstate.setText(String.valueOf((mList.get(4).getDestination() == null ? "" : mList.get(4).getDestination())));
                txtEstate5ConfirmedReceivedQuantity.setText(String.valueOf(((mList.get(4).getDestination_confirm_received() == null ? "" : mList.get(4).getDestination_confirm_received()))));
            }

            if (mList.size()>5)
            {
                txtEstate6Name.setText(String.valueOf(((mList.get(5).getEstate_name() == null ? "" : mList.get(5).getEstate_name()))));
                txtEstate6TotalQuantity.setText(String.valueOf(((mList.get(5).getTotal_collected() == null ? "" : mList.get(5).getTotal_collected()))));
                txtEstate6DestinationEstate.setText(String.valueOf((mList.get(5).getDestination() == null ? "" : mList.get(5).getDestination())));
                txtEstate6ConfirmedReceivedQuantity.setText(String.valueOf(((mList.get(5).getDestination_confirm_received() == null ? "" : mList.get(5).getDestination_confirm_received()))));
            }

            if (mList.size()>6)
            {
                txtEstate7Name.setText(String.valueOf(((mList.get(6).getEstate_name() == null ? "" : mList.get(6).getEstate_name()))));
                txtEstate7TotalQuantity.setText(String.valueOf(((mList.get(6).getTotal_collected() == null ? "" : mList.get(6).getTotal_collected()))));
                txtEstate7DestinationEstate.setText(String.valueOf((mList.get(6).getDestination() == null ? "" : mList.get(6).getDestination())));
                txtEstate7ConfirmedReceivedQuantity.setText(String.valueOf(((mList.get(6).getDestination_confirm_received() == null ? "" : mList.get(6).getDestination_confirm_received()))));
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
                        Intent intent = new Intent(InterEstateLeafDailySummaryActivity.this, BoughtLeafDailyFactoryActivity.class);
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
                final List<InterEstateLeafDailySummaryData> dataList = mDb.interEstateLeafDailySummaryDataDao().loadAllInterEstateLeafDailySummaryData();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        innerEstateLeafDailySummaryData = dataList;
                        setValuesForScreen(innerEstateLeafDailySummaryData);
                    }
                });
            }
        });
    }
}