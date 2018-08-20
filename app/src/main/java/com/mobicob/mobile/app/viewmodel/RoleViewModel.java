package com.mobicob.mobile.app.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.mobicob.mobile.app.db.entity.Role;
import com.mobicob.mobile.app.repository.RoleRepository;

import java.util.List;

public class RoleViewModel extends AndroidViewModel {

    private RoleRepository mRepository;

    private LiveData<List<Role>> mAllRoles;

    public RoleViewModel(Application application) {
        super(application);
        mRepository = new RoleRepository(application);
        mAllRoles = mRepository.getAllRoles();
    }

    LiveData<List<Role>> getAllRoles() { return mAllRoles; }

    public void insert(Role role) { mRepository.insert(role); }
}