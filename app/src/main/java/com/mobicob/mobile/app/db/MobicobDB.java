package com.mobicob.mobile.app.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.mobicob.mobile.app.db.dao.AnomalyTypeDao;
import com.mobicob.mobile.app.db.dao.CampaignDao;
import com.mobicob.mobile.app.db.dao.ClientDao;
import com.mobicob.mobile.app.db.dao.ContractorDao;
import com.mobicob.mobile.app.db.dao.DelegationDao;
import com.mobicob.mobile.app.db.dao.ManagementTypeDao;
import com.mobicob.mobile.app.db.dao.ResultTypeDao;
import com.mobicob.mobile.app.db.dao.RoleDao;
import com.mobicob.mobile.app.db.dao.TaskDao;
import com.mobicob.mobile.app.db.dao.UserDao;
import com.mobicob.mobile.app.db.entity.AnomalyType;
import com.mobicob.mobile.app.db.entity.Campaign;
import com.mobicob.mobile.app.db.entity.Client;
import com.mobicob.mobile.app.db.entity.Contractor;
import com.mobicob.mobile.app.db.entity.Delegation;
import com.mobicob.mobile.app.db.entity.ManagementType;
import com.mobicob.mobile.app.db.entity.ResultType;
import com.mobicob.mobile.app.db.entity.Role;
import com.mobicob.mobile.app.db.entity.Task;
import com.mobicob.mobile.app.db.entity.User;

@Database(entities = {
        User.class,
        AnomalyType.class,
        Campaign.class,
        Client.class,
        Contractor.class,
        Delegation.class,
        ManagementType.class,
        ResultType.class,
        Role.class,
        Task.class },
        version = 1,
        exportSchema = false)
public abstract class MobicobDB extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract AnomalyTypeDao anomalyTypeDao();
    public abstract CampaignDao campaignDao();
    public abstract ClientDao clientDao();
    public abstract ContractorDao contractorDao();
    public abstract DelegationDao delegationDao();
    public abstract ManagementTypeDao managementTypeDao();
    public abstract ResultTypeDao resultTypeDao();
    public abstract RoleDao roleDao();
    public abstract TaskDao taskDao();

    private static MobicobDB INSTANCE;

    public static MobicobDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MobicobDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MobicobDB.class, "mobicob_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onOpen (@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final UserDao mDao;

        PopulateDbAsync(MobicobDB db) {
            mDao = db.userDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            return null;
        }
    }
}
