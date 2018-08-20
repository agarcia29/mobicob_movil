package com.mobicob.mobile.app.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.mobicob.mobile.app.db.MobicobDB;
import com.mobicob.mobile.app.db.dao.RoleDao;
import com.mobicob.mobile.app.db.entity.Role;

import java.util.List;

public class RoleRepository {

    private RoleDao mRoleDao;
    private LiveData<List<Role>> mAllRoles;

    public RoleRepository(Application application) {
        MobicobDB db = MobicobDB.getDatabase(application);
        mRoleDao = db.roleDao();
        mAllRoles = mRoleDao.getAllRoles();
    }

    public LiveData<List<Role>> getAllRoles() {
        return mAllRoles;
    }


    public void insert (Role role) {
        new InsertAsyncTask(mRoleDao).execute(role);
    }

    private static class InsertAsyncTask extends AsyncTask<Role, Void, Void> {

        private RoleDao mAsyncTaskDao;

        InsertAsyncTask(RoleDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Role... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
