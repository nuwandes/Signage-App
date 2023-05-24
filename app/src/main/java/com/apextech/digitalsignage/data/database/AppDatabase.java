package com.apextech.digitalsignage.data.database;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.apextech.digitalsignage.data.database.dao.BoughtFactorySummaryDataDao;
import com.apextech.digitalsignage.data.database.dao.BoughtLineSummaryDataDao;
import com.apextech.digitalsignage.data.database.dao.FactoryCollectionSummaryDataDao;
import com.apextech.digitalsignage.data.database.dao.InterEstateLeafDailySummaryDataDao;
import com.apextech.digitalsignage.data.database.dao.WeatherDataDao;
import com.apextech.digitalsignage.data.database.dao.divisionalgross.DivisionDataDao;
import com.apextech.digitalsignage.data.database.dao.divisionalgross.EstateDataDao;
import com.apextech.digitalsignage.data.model.response.boughtleafdailylinecollectionsummary.BoughtLineSummaryData;
import com.apextech.digitalsignage.data.model.response.boughtleatdailyfactorycollectionsummary.BoughtFactorySummaryData;
import com.apextech.digitalsignage.data.model.response.divisionalgrossqty.DivisionData;
import com.apextech.digitalsignage.data.model.response.divisionalgrossqty.EstateData;
import com.apextech.digitalsignage.data.model.response.factorycollectonsummary.FactoryCollectionSummaryData;
import com.apextech.digitalsignage.data.model.response.interstateleafdailysummary.InterEstateLeafDailySummaryData;
import com.apextech.digitalsignage.data.model.response.weathernew.WeatherData;

@Database(entities = {BoughtLineSummaryData.class,
        BoughtFactorySummaryData.class,
        InterEstateLeafDailySummaryData.class,
        DivisionData.class,
        EstateData.class,
        FactoryCollectionSummaryData.class,
        WeatherData.class
        }, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static final String LOG_TAG = AppDatabase.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "digital_signage";
    private static AppDatabase sInstance;

    public static AppDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                Log.d(LOG_TAG, "Creating new database instance");
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, AppDatabase.DATABASE_NAME)
                        .build();
            }
        }
        Log.d(LOG_TAG, "Getting the database instance");
        return sInstance;
    }

    public abstract BoughtLineSummaryDataDao boughtLineSummaryDataDao();

    public abstract BoughtFactorySummaryDataDao boughtFactorySummaryDataDao();

    public abstract InterEstateLeafDailySummaryDataDao interEstateLeafDailySummaryDataDao();

    public abstract DivisionDataDao divisionDataDao();

    public abstract EstateDataDao estateDataDao();

    public abstract FactoryCollectionSummaryDataDao factoryCollectionSummaryDataDao();

    public abstract WeatherDataDao weatherDataDao();
}
