package com.apextech.digitalsignage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.apextech.digitalsignage.common.Utility;
import com.apextech.digitalsignage.data.TestData;
import com.apextech.digitalsignage.data.WeatherAPIClient;
import com.apextech.digitalsignage.data.database.AppExecutors;
import com.apextech.digitalsignage.data.database.CrudOperations;
import com.apextech.digitalsignage.data.interfaces.signageapi.SignageAPIClient;
import com.apextech.digitalsignage.data.model.GenericResponse;
import com.apextech.digitalsignage.data.model.request.DeviceRegistrationRequest;
import com.apextech.digitalsignage.data.model.request.SetAssetRequest;
import com.apextech.digitalsignage.data.model.request.SignageRequest;
import com.apextech.digitalsignage.data.model.request.SignageRequestNew;
import com.apextech.digitalsignage.data.model.response.GenericResponseNew;
import com.apextech.digitalsignage.data.model.response.LocationResponse;
import com.apextech.digitalsignage.data.model.response.WeatherResponse;
import com.apextech.digitalsignage.data.model.response.boughtleafdailylinecollectionsummary.BoughtLineSummaryData;
import com.apextech.digitalsignage.data.model.response.boughtleafdailylinecollectionsummary.BoughtLineSummaryResponse;
import com.apextech.digitalsignage.data.model.response.boughtleatdailyfactorycollectionsummary.BoughtFactorySummaryData;
import com.apextech.digitalsignage.data.model.response.boughtleatdailyfactorycollectionsummary.BoughtFactorySummaryResponse;
import com.apextech.digitalsignage.data.model.response.deviceregistration.DeviceRegistrationResponse;
import com.apextech.digitalsignage.data.model.response.divisionalgrossqty.DivisionData;
import com.apextech.digitalsignage.data.model.response.divisionalgrossqty.DivisionalGrossQtyResponse;
import com.apextech.digitalsignage.data.model.response.divisionalgrossqty.EstateData;
import com.apextech.digitalsignage.data.model.response.factorycollectonsummary.FactoryCollectionSummaryData;
import com.apextech.digitalsignage.data.model.response.factorycollectonsummary.FactoryCollectionSummaryResponse;
import com.apextech.digitalsignage.data.model.response.interstateleafdailysummary.InterEstateLeafDailySummaryData;
import com.apextech.digitalsignage.data.model.response.interstateleafdailysummary.InterEstateLeafDailySummaryResponse;
import com.apextech.digitalsignage.data.model.response.weather.DailyForecastsData;
import com.apextech.digitalsignage.data.model.response.weathernew.WeatherData;
import com.apextech.digitalsignage.data.model.response.weathernew.WeatherDataResponse;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Header;

public class MainActivity extends AppCompatActivity {

    private TextView txtMainAppName, txtCopyright;
    private String colomboLocationKey;
    private String kandyLocationKey;
    private String TAG = "MainActivity";
    private List<BoughtLineSummaryData>boughtLineSummaryData;
    private List<BoughtFactorySummaryData>boughtFactorySummaryData;
    private List<InterEstateLeafDailySummaryData> innerEstateLeafDailySummaryData;
    private List<EstateData>estateDataList;
    private List<DivisionData>divisionDataList1;
    private List<DivisionData>divisionDataList2;
    private List<DivisionData>divisionDataList3;
    private List<DivisionData>divisionDataList4;
    private List<DivisionData>divisionDataList5;
    private List<DivisionData>divisionDataList6;
    private List<FactoryCollectionSummaryData> factoryCollectionSummaryData;
    private List<WeatherData> weatherData;
    private LinearLayout progressLayout;

    TimerTask timeoutTimerTask = null;
    Boolean timerStarted = false;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler();
        initViews();

    }

    private void initViews()
    {
        txtCopyright = findViewById(R.id.txtCopyright_splash_activity);
        progressLayout = findViewById(R.id.progressLayout);
        populateUi();
    }

    private void populateUi()
    {
        progressLayout.setVisibility(View.VISIBLE);
        txtCopyright.setText("Copyright @"+ String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) +" Apex Technologies Private Limited");

        deviceRegistrationApiCall(getAndroidId(), getOsVersion());
    }

    private String getColomboLocationKey(String weatherApiKey, String geoData)
    {
        if (new Utility().isNetworkAvailable(getApplicationContext()))
        {
            Call<LocationResponse> locationResponseCall = WeatherAPIClient.getLocationService().getLocationKey(weatherApiKey, geoData);
            locationResponseCall.enqueue(new Callback<LocationResponse>() {
                @SuppressLint("SuspiciousIndentation")
                @Override
                public void onResponse(Call<LocationResponse> call, Response<LocationResponse> response) {

                    if (response.isSuccessful())
                    {
                        colomboLocationKey = response.body().getKey();
                        Log.wtf(TAG, "success, data: " + colomboLocationKey);
                        if (colomboLocationKey != null)
                            getColomboWeatherForecast(colomboLocationKey, weatherApiKey);
                    }
                }

                @Override
                public void onFailure(Call<LocationResponse> call, Throwable t) {
                    Log.wtf(TAG, "Failed");

                }
            });

        }
        else
        {
            Toast.makeText(this, getString(R.string.network_error), Toast.LENGTH_LONG).show();
        }

        return colomboLocationKey;
    }

    private void getColomboWeatherForecast(String locationKey, String weatherApiKey)
    {

        if (new Utility().isNetworkAvailable(getApplicationContext()))
        {
            Call<WeatherResponse> weatherResponseCall = WeatherAPIClient.getWeatherService().getColomboForecast(locationKey,weatherApiKey);

            weatherResponseCall.enqueue(new Callback<WeatherResponse>() {
                @Override
                public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {

                    if (response.isSuccessful())
                    {
                        List<DailyForecastsData> dailyForecastsDataList = response.body().getDailyForecasts();

                        ArrayList<String> dateList = new ArrayList<>();
                        ArrayList<String> maxList = new ArrayList<>();
                        ArrayList<String> minList = new ArrayList<>();
                        ArrayList<String> conditionList = new ArrayList<>();

                        for (int i =0; i<dailyForecastsDataList.size(); i++)
                        {
                            String max = "";
                            String min = "";
                            dateList.add(dailyForecastsDataList.get(i).getDate());
                            conditionList.add(dailyForecastsDataList.get(i).getDay().getIconPhrase());
                            max = Double.valueOf(dailyForecastsDataList.get(i).getTemperature().getMaximum().getValue()).toString();
                            min = Double.valueOf(dailyForecastsDataList.get(i).getTemperature().getMinimum().getValue()).toString();
                            maxList.add(max);
                            minList.add(min);
                        }

                        getKandyLocationKey(weatherApiKey, "7.29,80.63", dateList, maxList, minList, conditionList);
                    }
                }

                @Override
                public void onFailure(Call<WeatherResponse> call, Throwable t) {
                    Log.wtf(TAG, "Weather Failed, ");
                }
            });
        }
        else {
            Toast.makeText(this, getString(R.string.network_error), Toast.LENGTH_LONG).show();
        }

    }

    private String getKandyLocationKey(String weatherApiKey, String geoData, ArrayList<String> cDateList, ArrayList<String> cMaxList, ArrayList<String> cMinList, ArrayList<String> cConList)
    {
        if (new Utility().isNetworkAvailable(getApplicationContext())){
            Call<LocationResponse> locationResponseCall = WeatherAPIClient.getLocationService().getLocationKey(weatherApiKey, geoData);
            locationResponseCall.enqueue(new Callback<LocationResponse>() {
                @SuppressLint("SuspiciousIndentation")
                @Override
                public void onResponse(Call<LocationResponse> call, Response<LocationResponse> response) {

                    if (response.isSuccessful())
                    {
                        kandyLocationKey = response.body().getKey();
                        Log.wtf(TAG, "success, data: " + kandyLocationKey);
                        if (kandyLocationKey != null)
                            getKandyWeatherForecast(kandyLocationKey, weatherApiKey, cDateList, cMaxList, cMinList, cConList);
                    }
                }

                @Override
                public void onFailure(Call<LocationResponse> call, Throwable t) {
                    Log.wtf(TAG, "Failed");

                }
            });
        }
        else {
            Toast.makeText(this, getString(R.string.network_error), Toast.LENGTH_LONG).show();
        }

        return kandyLocationKey;
    }

    private void getKandyWeatherForecast(String locationKey, String weatherApiKey, ArrayList<String> cDateList, ArrayList<String> cMaxList, ArrayList<String> cMinList, ArrayList<String> cConList)
    {

        if (new Utility().isNetworkAvailable(getApplicationContext())){
            Call<WeatherResponse> weatherResponseCall = WeatherAPIClient.getWeatherService().getColomboForecast(locationKey,weatherApiKey);

            weatherResponseCall.enqueue(new Callback<WeatherResponse>() {
                @Override
                public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {

                    if (response.isSuccessful())
                    {
                        List<DailyForecastsData> dailyForecastsDataList = response.body().getDailyForecasts();

                        ArrayList<String> kDateList = new ArrayList<>();
                        ArrayList<String> kMaxList = new ArrayList<>();
                        ArrayList<String> kMinList = new ArrayList<>();
                        ArrayList<String> kConditionList = new ArrayList<>();

                        for (int i =0; i<dailyForecastsDataList.size(); i++)
                        {
                            String max = "";
                            String min = "";
                            kDateList.add(dailyForecastsDataList.get(i).getDate());
                            kConditionList.add(dailyForecastsDataList.get(i).getDay().getIconPhrase());
                            max = Double.valueOf(dailyForecastsDataList.get(i).getTemperature().getMaximum().getValue()).toString();
                            min = Double.valueOf(dailyForecastsDataList.get(i).getTemperature().getMinimum().getValue()).toString();
                            kMaxList.add(max);
                            kMinList.add(min);
                        }

                        new Handler().postDelayed(new Runnable() {

                            @Override
                            public void run() {
                                Intent intent = new Intent(MainActivity.this, ColomboWhetherActivity.class);
                                // colombo data
                                intent.putExtra("C_DATElIST", cDateList);
                                intent.putExtra("C_MAXlIST", cMaxList);
                                intent.putExtra("C_MINlIST", cMinList);
                                intent.putExtra("C_CONLIST", cConList);
                                //kandy data
                                intent.putExtra("K_DATElIST", kDateList);
                                intent.putExtra("K_MAXlIST", kMaxList);
                                intent.putExtra("K_MINlIST", kMinList);
                                intent.putExtra("K_CONLIST", kConditionList);
                                startActivity(intent);
                                finish();
                            }

                        }, 10000);
                    }
                }

                @Override
                public void onFailure(Call<WeatherResponse> call, Throwable t) {
                    Log.wtf(TAG, "Weather Failed, ");
                }
            });
        }
        else {
            Toast.makeText(this, getString(R.string.network_error), Toast.LENGTH_LONG).show();
        }
    }

    private String getAndroidId()
    {
        @SuppressLint("HardwareIds") String deviceId = Settings.Secure.getString(this.getContentResolver(),
                Settings.Secure.ANDROID_ID);

        return deviceId;
    }

    private String getOsVersion()
    {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    private void deviceRegistrationApiCall(String androidId, String androidVersion)
    {

        DeviceRegistrationRequest deviceRegistrationRequest = new DeviceRegistrationRequest();
        deviceRegistrationRequest.setGroupId(1);
        deviceRegistrationRequest.setSimNo("0722555551");
        deviceRegistrationRequest.setAppVersion(BuildConfig.VERSION_NAME);
        deviceRegistrationRequest.setAndroidId(androidId);
        deviceRegistrationRequest.setAndroidOs(androidVersion);

        if (new Utility().isNetworkAvailable(this))
        {
            Call<GenericResponse>deviceRegistrationResponseCall = SignageAPIClient.getDeviceRegistrationService().getDeviceRegistrationResponse(deviceRegistrationRequest);

            deviceRegistrationResponseCall.enqueue(new Callback<GenericResponse>() {
                @Override
                public void onResponse(Call<GenericResponse> call, Response<GenericResponse> response) {
                    if (response.body().getStatus().equals("FAILED"))
                    {
                        //Log.wtf(TAG, "DEVICE_REGISTRATION: success" + response.body().getData().getId());
                        if (response.body().getData().getApi_token()== null)
                        {
                            //display a message to continue by manual adding the id
                            displayNoKeyMessage(String.valueOf(response.body().getData().getId()));
                        }
                    }
                    else
                    {
                        if (response.body().getData().getApi_token()!= null)
                        {
                            if (response.body().getData().getAsset_no() != null)
                            {
                                // save the session token
                                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.putString("SESSION_TOKEN",response.body().getData().getApi_token());
                                editor.apply();
                                Log.wtf(TAG, "DEVICE_REGISTRATION: success with asset id " + response.body().getData().getAsset_no());

                                Log.wtf(TAG, "NEXT TO WEATHER ACTIVITY WITH SESSION_API_KEY " + preferences.getString("SESSION_TOKEN", ""));

                                setSchedulerForApiCalls(preferences, androidId);

                                setSchedulerForWeatherApiCalls(preferences);

//                                getBoughtLineDataFromAPI(new Utility().getCurrentDate(), preferences.getString("SESSION_TOKEN", ""), androidId);
//
//                                getBoughtFactoryDataFromAPI(new Utility().getCurrentDate(), preferences.getString("SESSION_TOKEN", ""), androidId);
//
//                                getInterEstateLeafDailySummaryAPIData(new Utility().getCurrentDate(), preferences.getString("SESSION_TOKEN", ""), androidId);
//
//                                getDivisionalGrossQuantitiesAPIData(new Utility().getCurrentDate(), preferences.getString("SESSION_TOKEN", ""), androidId);
//
//                                getFactoryCollectionAPIData(new Utility().getCurrentDate(), preferences.getString("SESSION_TOKEN", ""), androidId);

                                
                                //getColomboLocationKey("xlLGy8qJRp2McMEfjsp13G49tFGBi2Al", "6.88,79.85");
                                //getColomboLocationKey("6HbcvFx1GCTySqqarurLkgN78WI9AQqO", "6.88,79.85");

                                new java.util.Timer().schedule(
                                        new java.util.TimerTask() {
                                            @Override
                                            public void run() {
                                                Intent intent = new Intent(MainActivity.this, DivisionalGrossQuantitiesActivity.class);
                                                startActivity(intent);
                                            }
                                        },
                                        10000
                                );

                                progressLayout.setVisibility(View.GONE);
                            }
                            else
                            {
                                Log.wtf(TAG, "DEVICE_REGISTRATION: success with API token only " + response.body().getData().getApi_token());
                                // dialog box with asset id edit text
                                displaySetAssetIdMessage(response.body().getData().getApi_token());
                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<GenericResponse> call, Throwable t) {
                    Log.wtf(TAG, "DEVICE_REGISTRATION: failed");
                }
            });
        }
        else
        {
            Toast.makeText(this, getString(R.string.network_error), Toast.LENGTH_LONG).show();
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void displayNoKeyMessage(String deviceId)
    {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.device_id_dialog);
        TextView tvTitle, tvMessage, tvDeviceId;
        Button btnOk;
        tvDeviceId = (TextView)dialog.findViewById(R.id.txtDeviceId_device_id_dialog);
        tvTitle = (TextView) dialog.findViewById(R.id.txtDeviceIdTitle_device_id_dialog);
        tvMessage = (TextView) dialog.findViewById(R.id.txtDeviceIdMessage_device_id_dialog);
        btnOk = (Button) dialog.findViewById(R.id.btnOk_device_id_dialog);

        Window window = dialog.getWindow();
        int width = (int)(getResources().getDisplayMetrics().widthPixels*0.40);
        int height = (int)(getResources().getDisplayMetrics().heightPixels*0.40);
        window.setLayout(width, height);
        window.setGravity(Gravity.CENTER);
        tvTitle.setText(R.string.registration_error1_title);
        tvMessage.setText(R.string.registration_error1);
        tvDeviceId.setText(deviceId);

        dialog.setCancelable(false);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       deviceRegistrationApiCall(getAndroidId(), getOsVersion());
                   }
               }, 1000);
                dialog.dismiss();
            }
        });
        dialog.show();

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void displaySetAssetIdMessage(String token)
    {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.asset_id_dialog);
        TextView tvTitle, tvMessage;
        Button btnSet;
        EditText etAssetId;
        tvTitle = (TextView) dialog.findViewById(R.id.txtAssetIdTitle_asset_id_dialog);
        tvMessage = (TextView) dialog.findViewById(R.id.txtAssetIdMessage_asset_id_dialog);
        btnSet = (Button) dialog.findViewById(R.id.btnSet_asset_id_dialog);
        etAssetId = (EditText) dialog.findViewById(R.id.txtAssetId_asset_id_dialog);

        Window window = dialog.getWindow();
        int width = (int)(getResources().getDisplayMetrics().widthPixels*0.40);
        int height = (int)(getResources().getDisplayMetrics().heightPixels*0.40);
        window.setLayout(width, height);
        window.setGravity(Gravity.CENTER);
        tvTitle.setText(R.string.registration_error2_title);
        tvMessage.setText(R.string.registration_error2);
        dialog.setCancelable(false);

        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editTextInput = etAssetId.getText().toString();
                if (new Utility().isNetworkAvailable(getApplicationContext()))
                {
                    if (!editTextInput.isEmpty())
                    {
                        setAssetIdForDeviceApiCall(getAndroidId(), editTextInput, token);
                        //Log.wtf(TAG, "ENTERED_VALUE: " + editTextInput +", " + getAndroidId() + ", " + token);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Please enter valid asset id.", Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(), getString(R.string.network_error), Toast.LENGTH_LONG).show();
                }
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void setAssetIdForDeviceApiCall(String androidId, String assetId, String token)
    {
        SetAssetRequest setAssetRequest = new SetAssetRequest();
        setAssetRequest.setAssetId(assetId);
        String _token = "Bearer " + token;

        Log.wtf(TAG, "ASSET_ID_ASSIGNING_CALL" + assetId + ", " + androidId + ", " + _token + " ");

        if (new Utility().isNetworkAvailable(this))
        {
            Call<GenericResponseNew>setAssetResponse = SignageAPIClient.getSetAssetService().setAssetResponse(_token, androidId , "1", BuildConfig.VERSION_NAME, "072255555", getOsVersion(), setAssetRequest);

            setAssetResponse.enqueue(new Callback<GenericResponseNew>() {
                @Override
                public void onResponse(Call<GenericResponseNew> call, Response<GenericResponseNew> response) {

                    if (response.body().getStatus().equals("SUCCESS"))
                    {
                        // next again mobile status API call to get the session Token if asset_id is same
                        deviceRegistrationApiCall(getAndroidId(), getOsVersion());
                    }
                    else
                    {
                        // show the dialog with asset id edit text
                        displaySetAssetIdMessage(token);
                    }
                }

                @Override
                public void onFailure(Call<GenericResponseNew> call, Throwable t) {

                }
            });
        }
        else
        {
            Toast.makeText(getApplicationContext(), getString(R.string.network_error), Toast.LENGTH_LONG).show();
        }
    }

    private void getBoughtLineDataFromAPI(String date, String token, String deviceId)
    {
        String _token = "Bearer "+ token;

        SignageRequest signageRequest = new SignageRequest();
        signageRequest.setPlantationId(1);
        signageRequest.setLastUpdatedAt(date);

        if (new Utility().isNetworkAvailable(getApplicationContext()))
        {
            Call<BoughtLineSummaryResponse>boughtLineSummaryResponseCall = SignageAPIClient.getBoughtLineSummaryService().getBoughtLineSummaryResponse(_token, deviceId, signageRequest);

            boughtLineSummaryResponseCall.enqueue(new Callback<BoughtLineSummaryResponse>() {
                @Override
                public void onResponse(Call<BoughtLineSummaryResponse> call, Response<BoughtLineSummaryResponse> response) {

                    boughtLineSummaryData = new TestData().getLineSummaryList();

                    if (boughtLineSummaryData.size()>0)
                    {
                        //delete all before insert
                        AppExecutors.getInstance().diskIO().execute(new Runnable() {
                            @Override
                            public void run() {

                                new CrudOperations(getApplicationContext()).deleteAllFromBoughtLineSummary();

                                Log.wtf(TAG, "INSERT_SIZE: " + boughtLineSummaryData);
                                for (BoughtLineSummaryData item : boughtLineSummaryData)
                                {
                                    new CrudOperations(getApplicationContext()).insertBoughtLineSummaryData(item);
                                }
                            }
                        });
                    }
                }

                @Override
                public void onFailure(Call<BoughtLineSummaryResponse> call, Throwable t) {

                }
            });
        }
        else
        {
            Toast.makeText(this, getString(R.string.network_error), Toast.LENGTH_LONG).show();
        }
    }

    private void getBoughtFactoryDataFromAPI(String date, String token, String deviceId)
    {
        String _token = "Bearer "+ token;

        SignageRequest signageRequest = new SignageRequest();
        signageRequest.setPlantationId(1);
        signageRequest.setLastUpdatedAt(date);

        if (new Utility().isNetworkAvailable(getApplicationContext()))
        {
            Call<BoughtFactorySummaryResponse> boughtFactorySummaryResponseCall = SignageAPIClient.getBoughtFactorySummaryService().getBoughtFactorySummaryResponse(_token, deviceId, signageRequest);

            boughtFactorySummaryResponseCall.enqueue(new Callback<BoughtFactorySummaryResponse>() {
                @Override
                public void onResponse(Call<BoughtFactorySummaryResponse> call, Response<BoughtFactorySummaryResponse> response) {

                    boughtFactorySummaryData = new TestData().getBoughtFactoryList();

                    if (boughtFactorySummaryData.size()>0)
                    {
                        AppExecutors.getInstance().diskIO().execute(new Runnable() {
                            @Override
                            public void run() {

                                new CrudOperations(getApplicationContext()).deleteAllFromBoughtFactorySummary();

                                Log.wtf(TAG, "INSERT_SIZE: " + boughtFactorySummaryData);
                                for (BoughtFactorySummaryData item : boughtFactorySummaryData)
                                {
                                    new CrudOperations(getApplicationContext()).insertBoughtFactorySummaryData(item);
                                }
                            }
                        });
                    }
                }

                @Override
                public void onFailure(Call<BoughtFactorySummaryResponse> call, Throwable t) {

                }
            });
        }
        else
        {
            Toast.makeText(this, getString(R.string.network_error), Toast.LENGTH_LONG).show();
        }
    }

    private void getInterEstateLeafDailySummaryAPIData(String date, String token, String deviceId)
    {
        String _token = "Bearer "+ token;

        SignageRequest signageRequest = new SignageRequest();
        signageRequest.setPlantationId(1);
        signageRequest.setLastUpdatedAt(date);

        if (new Utility().isNetworkAvailable(getApplicationContext()))
        {
            Call<InterEstateLeafDailySummaryResponse> interEstateLeafDailySummaryResponseCall = SignageAPIClient.getInterEstateSummaryService().getInterEstateLeafDailySummary(_token, deviceId, signageRequest);

            interEstateLeafDailySummaryResponseCall.enqueue(new Callback<InterEstateLeafDailySummaryResponse>() {
                @Override
                public void onResponse(Call<InterEstateLeafDailySummaryResponse> call, Response<InterEstateLeafDailySummaryResponse> response) {

                    innerEstateLeafDailySummaryData = new TestData().getInnerEstateLeafSummary();

                    if (innerEstateLeafDailySummaryData.size()>0)
                    {
                        AppExecutors.getInstance().diskIO().execute(new Runnable() {
                            @Override
                            public void run()
                            {
                                new CrudOperations(getApplicationContext()).deleteAllFromInterEstateLeafDailySummary();

                                Log.wtf(TAG, "INSERT_SIZE: " + innerEstateLeafDailySummaryData);
                                for (InterEstateLeafDailySummaryData item : innerEstateLeafDailySummaryData)
                                {
                                    new CrudOperations(getApplicationContext()).insertInterEstateLeafDailySummary(item);
                                }
                            }
                        });
                    }
                }

                @Override
                public void onFailure(Call<InterEstateLeafDailySummaryResponse> call, Throwable t) {

                }
            });
        }
        else
        {
            Toast.makeText(this, getString(R.string.network_error), Toast.LENGTH_LONG).show();
        }
    }

    private void getDivisionalGrossQuantitiesAPIData(String date, String token, String deviceId)
    {
        String _token = "Bearer "+ token;

        SignageRequest signageRequest = new SignageRequest();
        signageRequest.setPlantationId(1);
        signageRequest.setLastUpdatedAt(date);

        if (new Utility().isNetworkAvailable(getApplicationContext()))
        {
            Call<DivisionalGrossQtyResponse> divisionalGrossQtyResponseCall = SignageAPIClient.getDivisionalGrossQtyService().getDivisionalGrossQty(_token, deviceId, signageRequest);

            divisionalGrossQtyResponseCall.enqueue(new Callback<DivisionalGrossQtyResponse>() {
                @Override
                public void onResponse(Call<DivisionalGrossQtyResponse> call, Response<DivisionalGrossQtyResponse> response) {

                    estateDataList = new TestData().setEstatesDataList();

                    if (estateDataList.size()>0)
                    {
                        AppExecutors.getInstance().diskIO().execute(new Runnable() {
                            @Override
                            public void run()
                            {
                                new CrudOperations(getApplicationContext()).deleteAllFromEstateData();
                                new CrudOperations(getApplicationContext()).deleteAllFromDivisionData();

                                Log.wtf(TAG, "INSERT_SIZE: " + estateDataList);
                                for (EstateData item : estateDataList)
                                {
                                    new CrudOperations(getApplicationContext()).insertEstateData(item);
                                }

                                divisionDataList1 = new TestData().setEstate1DivisionsTestData();

                                if (divisionDataList1.size()>0)
                                {
                                    Log.wtf(TAG, "INSERT_SIZE: " + divisionDataList1);
                                    for (DivisionData item : divisionDataList1)
                                    {
                                        new CrudOperations(getApplicationContext()).insertDivisionData(item);
                                    }
                                }

                                divisionDataList2 = new TestData().setEstate2DivisionsTestData();

                                if (divisionDataList2.size()>0)
                                {
                                    Log.wtf(TAG, "INSERT_SIZE: " + divisionDataList2);
                                    for (DivisionData item : divisionDataList2)
                                    {
                                        new CrudOperations(getApplicationContext()).insertDivisionData(item);
                                    }
                                }

                                divisionDataList3 = new TestData().setEstate3DivisionsTestData();

                                if (divisionDataList3.size()>0)
                                {
                                    Log.wtf(TAG, "INSERT_SIZE: " + divisionDataList3);
                                    for (DivisionData item : divisionDataList3)
                                    {
                                        new CrudOperations(getApplicationContext()).insertDivisionData(item);
                                    }
                                }

                                divisionDataList4 = new TestData().setEstate4DivisionsTestData();

                                if (divisionDataList4.size()>0)
                                {
                                    Log.wtf(TAG, "INSERT_SIZE: " + divisionDataList4);
                                    for (DivisionData item : divisionDataList4)
                                    {
                                        new CrudOperations(getApplicationContext()).insertDivisionData(item);
                                    }
                                }

                                divisionDataList5 = new TestData().setEstate5DivisionsTestData();

                                if (divisionDataList5.size()>0)
                                {
                                    Log.wtf(TAG, "INSERT_SIZE: " + divisionDataList5);
                                    for (DivisionData item : divisionDataList5)
                                    {
                                        new CrudOperations(getApplicationContext()).insertDivisionData(item);
                                    }
                                }

                                divisionDataList6 = new TestData().setEstate6DivisionsTestData();

                                if (divisionDataList6.size()>0)
                                {
                                    Log.wtf(TAG, "INSERT_SIZE: " + divisionDataList6);
                                    for (DivisionData item : divisionDataList6)
                                    {
                                        new CrudOperations(getApplicationContext()).insertDivisionData(item);
                                    }
                                }
                            }
                        });
                    }



                }

                @Override
                public void onFailure(Call<DivisionalGrossQtyResponse> call, Throwable t) {

                }
            });
        }
        else
        {
            Toast.makeText(this, getString(R.string.network_error), Toast.LENGTH_LONG).show();
        }
    }

    private void getFactoryCollectionAPIData(String date, String token, String deviceId)
    {
        String _token = "Bearer "+ token;

        SignageRequest signageRequest = new SignageRequest();
        signageRequest.setPlantationId(1);
        signageRequest.setLastUpdatedAt(date);

        if (new Utility().isNetworkAvailable(getApplicationContext()))
        {
            Call<FactoryCollectionSummaryResponse> factoryCollectionSummaryResponseCall = SignageAPIClient.getFactoryCollectionSummaryService().getFactoryCollectionSummary(_token, deviceId, signageRequest);

            factoryCollectionSummaryResponseCall.enqueue(new Callback<FactoryCollectionSummaryResponse>() {
                @Override
                public void onResponse(Call<FactoryCollectionSummaryResponse> call, Response<FactoryCollectionSummaryResponse> response) {

                    factoryCollectionSummaryData = new TestData().getFactoryCollectionDataList();

                    if (factoryCollectionSummaryData.size()>0)
                    {
                        AppExecutors.getInstance().diskIO().execute(new Runnable() {
                            @Override
                            public void run()
                            {
                                new CrudOperations(getApplicationContext()).deleteAllFromFactoryCollectionData();

                                Log.wtf(TAG, "INSERT_SIZE: " + factoryCollectionSummaryData);
                                for (FactoryCollectionSummaryData item : factoryCollectionSummaryData)
                                {
                                    new CrudOperations(getApplicationContext()).insertFactoryCollectionData(item);
                                }
                            }
                        });
                    }

                }

                @Override
                public void onFailure(Call<FactoryCollectionSummaryResponse> call, Throwable t) {

                }
            });
        }
        else
        {
            Toast.makeText(this, getString(R.string.network_error), Toast.LENGTH_LONG).show();
        }
    }

    private void getWeatherAPIData(String token)
    {
        String _token = "Bearer "+ token;

        SignageRequestNew signageRequestNew = new SignageRequestNew();
        signageRequestNew.setDate(new Utility().getCurrentDate());
        signageRequestNew.setTime(new Utility().getCurrentTime());

        if (new Utility().isNetworkAvailable(getApplicationContext()))
        {
            Call<WeatherDataResponse> weatherDataResponseCall = SignageAPIClient.getWeatherServiceNew().getWeatherData(_token, signageRequestNew);

            weatherDataResponseCall.enqueue(new Callback<WeatherDataResponse>() {
                @Override
                public void onResponse(Call<WeatherDataResponse> call, Response<WeatherDataResponse> response) {

                    weatherData = new TestData().getWeatherDataList();

                    if (weatherData.size()>0)
                    {
                        AppExecutors.getInstance().diskIO().execute(new Runnable() {
                            @Override
                            public void run() {

                                new CrudOperations(getApplicationContext()).deleteAllFromWeatherData();

                                Log.wtf(TAG, "INSERT_SIZE: " + weatherData);
                                for (WeatherData item : weatherData)
                                {
                                    new CrudOperations(getApplicationContext()).insertWeatherData(item);
                                }
                            }
                        });
                    }
                }

                @Override
                public void onFailure(Call<WeatherDataResponse> call, Throwable t) {

                }
            });
        }
        else
        {
            Toast.makeText(this, getString(R.string.network_error), Toast.LENGTH_LONG).show();
        }
    }

    private void setSchedulerForApiCalls(SharedPreferences preferences, String androidId)
    {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub

                getBoughtLineDataFromAPI(new Utility().getCurrentDate(), preferences.getString("SESSION_TOKEN", ""), androidId);

                getBoughtFactoryDataFromAPI(new Utility().getCurrentDate(), preferences.getString("SESSION_TOKEN", ""), androidId);

                getInterEstateLeafDailySummaryAPIData(new Utility().getCurrentDate(), preferences.getString("SESSION_TOKEN", ""), androidId);

                getDivisionalGrossQuantitiesAPIData(new Utility().getCurrentDate(), preferences.getString("SESSION_TOKEN", ""), androidId);

                getFactoryCollectionAPIData(new Utility().getCurrentDate(), preferences.getString("SESSION_TOKEN", ""), androidId);

            }
        }, 0, 3, TimeUnit.MINUTES);
    }

    private void setSchedulerForWeatherApiCalls(SharedPreferences preferences)
    {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub

                getWeatherAPIData(preferences.getString("SESSION_TOKEN", ""));



            }
        }, 0, 5, TimeUnit.MINUTES);
    }
}