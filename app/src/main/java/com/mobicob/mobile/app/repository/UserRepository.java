package com.mobicob.mobile.app.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.mobicob.mobile.app.db.MobicobDB;
import com.mobicob.mobile.app.db.dao.UserDao;
import com.mobicob.mobile.app.db.entity.User;

import java.util.List;

public class UserRepository {

    private UserDao mUserDao;
    private LiveData<List<User>> mAllUsers;

    public UserRepository(Application application) {
        MobicobDB db = MobicobDB.getDatabase(application);
        mUserDao = db.userDao();
        mAllUsers = mUserDao.getAllUsers();
    }

    public LiveData<List<User>> getAllUsers() {
        return mAllUsers;
    }


    public void insert (User user) {
        new InsertAsyncTask(mUserDao).execute(user);
    }

    private static class InsertAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDao mAsyncTaskDao;

        InsertAsyncTask(UserDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final User... params) {
            mAsyncTaskDao.deleteAll();
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
