package com.apextech.digitalsignage.data.database;

import android.content.Context;
import android.util.Log;

import com.apextech.digitalsignage.data.database.dao.FactoryCollectionSummaryDataDao;
import com.apextech.digitalsignage.data.model.response.boughtleafdailylinecollectionsummary.BoughtLineSummaryData;
import com.apextech.digitalsignage.data.model.response.boughtleatdailyfactorycollectionsummary.BoughtFactorySummaryData;
import com.apextech.digitalsignage.data.model.response.divisionalgrossqty.DivisionData;
import com.apextech.digitalsignage.data.model.response.divisionalgrossqty.EstateData;
import com.apextech.digitalsignage.data.model.response.factorycollectonsummary.FactoryCollectionSummaryData;
import com.apextech.digitalsignage.data.model.response.interstateleafdailysummary.InterEstateLeafDailySummaryData;
import com.apextech.digitalsignage.data.model.response.weathernew.WeatherData;

public class CrudOperations
{
    private AppDatabase mDb;
    public CrudOperations(Context context)
    {
        mDb = AppDatabase.getInstance(context);
    }

    public void deleteAllFromBoughtLineSummary()
    {
        mDb.boughtLineSummaryDataDao().deleteAllLines();
    }

    public void deleteAllFromBoughtFactorySummary()
    {
        mDb.boughtFactorySummaryDataDao().deleteAllFactories();
    }

    public void deleteAllFromInterEstateLeafDailySummary()
    {
        mDb.interEstateLeafDailySummaryDataDao().deleteAllInterEstateLeafDailySummaryData();
    }

    public void deleteAllFromDivisionData()
    {
        mDb.divisionDataDao().deleteAllDivisionData();
    }

    public void deleteAllFromEstateData()
    {
        mDb.estateDataDao().deleteAllEstateData();
    }

    public void deleteAllFromFactoryCollectionData()
    {
        mDb.factoryCollectionSummaryDataDao().deleteAllFactoryCollectionSummaryData();
    }

    public void deleteAllFromWeatherData()
    {
        mDb.weatherDataDao().deleteAllWeatherData();
    }

    public void insertBoughtLineSummaryData(BoughtLineSummaryData boughtLineSummaryData)
    {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                if (boughtLineSummaryData != null)
                {
                    mDb.boughtLineSummaryDataDao().insertBoughtLineSummaryData(boughtLineSummaryData);
                    Log.wtf("CRUD_OPERATION", "AN BOUGHT LINE ITEM INSERTED TO DB");
                }
            }
        });
    }

    public void insertBoughtFactorySummaryData(BoughtFactorySummaryData boughtFactorySummaryData)
    {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                if (boughtFactorySummaryData != null)
                {
                    mDb.boughtFactorySummaryDataDao().insertBoughtFactorySummaryData(boughtFactorySummaryData);
                    Log.wtf("CRUD_OPERATION", "AN BOUGHT FACTORY ITEM INSERTED TO DB");
                }
            }
        });
    }

    public void insertInterEstateLeafDailySummary(InterEstateLeafDailySummaryData interEstateLeafDailySummaryData)
    {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                if (interEstateLeafDailySummaryData != null)
                {
                    mDb.interEstateLeafDailySummaryDataDao().insertInterEstateLeafDailySummaryData(interEstateLeafDailySummaryData);
                    Log.wtf("CRUD_OPERATION", "AN INTER ESTATE LEAF DAILY SUMMARY ITEM INSERTED TO DB");

                }
            }
        });
    }

    public void insertDivisionData(DivisionData divisionData)
    {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                if (divisionData != null)
                {
                    mDb.divisionDataDao().insertDivisionData(divisionData);
                    Log.wtf("CRUD_OPERATION", "AN DIVISIONAL GROSS DIVISION ITEM INSERTED TO DB");

                }
            }
        });
    }

    public void insertEstateData(EstateData estateData)
    {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                if (estateData != null)
                {
                    mDb.estateDataDao().insertEstateData(estateData);
                    Log.wtf("CRUD_OPERATION", "AN DIVISIONAL GROSS ESTATE ITEM INSERTED TO DB");

                }
            }
        });
    }

    public void insertFactoryCollectionData(FactoryCollectionSummaryData factoryCollectionSummaryData)
    {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                if (factoryCollectionSummaryData != null)
                {
                    mDb.factoryCollectionSummaryDataDao().insertFactoryCollectionSummaryData(factoryCollectionSummaryData);
                    Log.wtf("CRUD_OPERATION", "A FACTORY COLLECTION ITEM INSERTED TO DB");

                }
            }
        });
    }

    public void insertWeatherData(WeatherData weatherData)
    {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                if (weatherData != null)
                {
                    mDb.weatherDataDao().insertWeatherData(weatherData);
                    Log.wtf("CRUD_OPERATION", "A WEATHER DATA ITEM INSERTED TO DB");

                }
            }
        });
    }
}
