package com.mobicob.mobile.app.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.mobicob.mobile.app.db.MobicobDB;
import com.mobicob.mobile.app.db.dao.ClientDao;
import com.mobicob.mobile.app.db.entity.Client;

import java.util.List;

public class ClientRepository {

    private ClientDao mClientDao;
    private LiveData<List<Client>> mAllClients;

    public ClientRepository(Application application) {
        MobicobDB db = MobicobDB.getDatabase(application);
        mClientDao = db.clientDao();
        mAllClients = mClientDao.getAllClients();
    }

    public LiveData<List<Client>> getAllClients() {
        return mAllClients;
    }


    public void insert (Client client) {
        new InsertAsyncTask(mClientDao).execute(client);
    }

    private static class InsertAsyncTask extends AsyncTask<Client, Void, Void> {

        private ClientDao mAsyncTaskDao;

        InsertAsyncTask(ClientDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Client... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
