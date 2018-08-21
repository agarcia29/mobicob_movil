package com.mobicob.mobile.app.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.mobicob.mobile.app.db.entity.Client;
import com.mobicob.mobile.app.repository.ClientRepository;

import java.util.List;

public class ClientViewModel extends AndroidViewModel {

    private ClientRepository mRepository;

    private LiveData<List<Client>> mAllClients;

    public ClientViewModel(Application application) {
        super(application);
        mRepository = new ClientRepository(application);
        mAllClients = mRepository.getAllClients();
    }

    LiveData<List<Client>> getAllClients() { return mAllClients; }

    public void insert(Client client) { mRepository.insert(client); }
}