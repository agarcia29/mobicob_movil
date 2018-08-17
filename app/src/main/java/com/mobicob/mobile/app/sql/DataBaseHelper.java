package com.mobicob.mobile.app.sql;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.mobicob.mobile.app.sql.MobicobContract.*;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Mobicob.db";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*db.execSQL(FeedUsers.SQL_CREATE_USERS);
        db.execSQL(FeedCampaigns.SQL_CREATE_CAMPAINGS);
        db.execSQL(FeedTasks.SQL_CREATE_TASKS);
        db.execSQL(FeedClients.SQL_CREATE_CLIENTS);
        db.execSQL(FeedContractors.SQL_CREATE_CONTRACTORS);
        db.execSQL(FeedDelegations.SQL_CREATE_DELEGATIONS);
        db.execSQL(FeedMagementTypes.SQL_CREATE_MANAGEMENT_TYPES);
        db.execSQL(FeedResultTypes.SQL_CREATE_RESULT_TYPES);
        db.execSQL(FeedAnomalyTypes.SQL_CREATE_ANOMALY_TYPES);
        db.execSQL(FeedRoles.SQL_CREATE_ROLES);*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(FeedUsers.SQL_DELETE_USERS);
        db.execSQL(FeedCampaigns.SQL_DELETE_CAMPAINGS);
        db.execSQL(FeedTasks.SQL_DELETE_TASKS);
        db.execSQL(FeedClients.SQL_DELETE_CLIENTS);
        db.execSQL(FeedContractors.SQL_DELETE_CONTRACTORS);
        db.execSQL(FeedDelegations.SQL_DELETE_DELEGATIONS);
        db.execSQL(FeedMagementTypes.SQL_DELETE_MANAGEMENT_TYPES);
        db.execSQL(FeedResultTypes.SQL_DELETE_RESULT_TYPES);
        db.execSQL(FeedAnomalyTypes.SQL_DELETE_ANOMALY_TYPES);
        db.execSQL(FeedRoles.SQL_DELETE_ROLES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}

