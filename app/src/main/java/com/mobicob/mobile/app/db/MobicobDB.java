package com.mobicob.mobile.app.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.mobicob.mobile.app.db.dao.UserDao;
import com.mobicob.mobile.app.db.entity.User;

@Database(entities = {User.class}, version = 1)
public abstract class MobicobDB extends RoomDatabase {

    public abstract UserDao userDao();

    private static MobicobDB INSTANCE;

    public static MobicobDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MobicobDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MobicobDB.class, "mobicob_database")
                            .build();

                }
            }
        }
        return INSTANCE;
    }
}
