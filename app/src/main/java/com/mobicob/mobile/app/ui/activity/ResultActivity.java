package com.mobicob.mobile.app.ui.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mobicob.mobile.app.R;
import com.mobicob.mobile.app.apiclient.JsonKeys;
import com.mobicob.mobile.app.apiclient.network.RetrofitInstance;
import com.mobicob.mobile.app.apiclient.services.MobicobApiServices;
import com.mobicob.mobile.app.db.entity.AnomalyType;
import com.mobicob.mobile.app.db.entity.ManagementType;
import com.mobicob.mobile.app.db.entity.ResultType;
import com.mobicob.mobile.app.db.entity.Task;
import com.mobicob.mobile.app.db.entity.User;
import com.mobicob.mobile.app.model.LoginResponse;
import com.mobicob.mobile.app.model.ResultResponse;
import com.mobicob.mobile.app.session.Preferences;
import com.mobicob.mobile.app.viewmodel.AnomalyTypeViewModel;
import com.mobicob.mobile.app.viewmodel.ManagementTypeViewModel;
import com.mobicob.mobile.app.viewmodel.ResultTypeViewModel;
import com.mobicob.mobile.app.viewmodel.TaskViewModel;
import com.mobicob.mobile.app.wrapper.LoginRequestWrapper;
import com.mobicob.mobile.app.wrapper.ResultRequestWrapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    private View mProgressView;

    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;

    private Task mTask;

    private AppCompatEditText userId;
    private AppCompatEditText managementDate;

    private AppCompatSpinner managementTypeSpinner;
    private ManagementType   itemManagementTypeSelected;
    private AppCompatSpinner resultTypeSpinner;
    private ResultType       itemResultTypeSelected;
    private AppCompatSpinner anomalyTypeSpinner;
    private AnomalyType      itemAnomalyTypeSelected;

    private AppCompatEditText collectionEntity;
    private AppCompatEditText paymentDate;
    private AppCompatEditText comPaymentDate;

    private AppCompatEditText personalContact;
    private AppCompatEditText idNumber;
   // private AppCompatEditText clientName;
    private AppCompatEditText phone;
    private AppCompatEditText email;

    private AppCompatEditText observation;
    private AppCompatEditText readingSignature;
    private AppCompatEditText dataphonePayment;
    private AppCompatEditText usedTime;

    private Button mSaveButton;

    private List<ManagementType> managementTypesList;
    private ArrayAdapter<ManagementType> adapterManagementSpinner;
    private List<ResultType> resultTypeList;
    private ArrayAdapter<ResultType> adapterResultSpinner;
    private List<AnomalyType> anomalyTypeList;
    private ArrayAdapter<AnomalyType> adapterAnomalySpinner;

    private ManagementTypeViewModel mManagementTypeViewModel;
    private ResultTypeViewModel mResultTypeViewModel;
    private AnomalyTypeViewModel mAnomalyTypeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle extra = getIntent().getExtras();
        mTask = (Task) extra.get(JsonKeys.TASK);

        initViews();
        initListeners();

        managementTypesList = new ArrayList<>();
        resultTypeList = new ArrayList<>();
        anomalyTypeList = new ArrayList<>();

        mManagementTypeViewModel = ViewModelProviders.of(this).get(ManagementTypeViewModel.class);
        mResultTypeViewModel = ViewModelProviders.of(this).get(ResultTypeViewModel.class);
        mAnomalyTypeViewModel = ViewModelProviders.of(this).get(AnomalyTypeViewModel.class);

        mManagementTypeViewModel.getAllManagementTypes().observe(this, new Observer<List<ManagementType>>() {
            @Override
            public void onChanged(@Nullable final List<ManagementType> managementTypes) {
                managementTypesList = managementTypes;
            }
        });

        adapterManagementSpinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, managementTypesList);
        adapterManagementSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterManagementSpinner.setNotifyOnChange(true);
        managementTypeSpinner.setAdapter(adapterManagementSpinner);

        managementTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                itemManagementTypeSelected = managementTypesList.get(i);

                mResultTypeViewModel.getByMangementType(itemManagementTypeSelected.getId()).
                        observe(ResultActivity.this, new Observer<List<ResultType>>() {
                    @Override
                    public void onChanged(@Nullable final List<ResultType> resultTypes) {
                        resultTypeList = resultTypes;
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        adapterResultSpinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, resultTypeList);
        adapterResultSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        resultTypeSpinner.setAdapter(adapterResultSpinner);

        resultTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                itemResultTypeSelected = resultTypeList.get(i);
                mAnomalyTypeViewModel.getAllAnomalyTypes().
                        observe(ResultActivity.this, new Observer<List<AnomalyType>>() {
                    @Override
                    public void onChanged(@Nullable final List<AnomalyType> anomalyTypes) {
                        anomalyTypeList = anomalyTypes;
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        adapterAnomalySpinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, anomalyTypeList);
        adapterAnomalySpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        anomalyTypeSpinner.setAdapter(adapterAnomalySpinner);

        anomalyTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                itemAnomalyTypeSelected = anomalyTypeList.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    private void initListeners() {
        mSaveButton.setOnClickListener(ResultActivity.this);
    }

    private void initViews() {
        userId = (AppCompatEditText) findViewById(R.id.userId);
        managementDate = (AppCompatEditText) findViewById(R.id.managementDate);

        managementTypeSpinner = (AppCompatSpinner) findViewById(R.id.managementType);
        resultTypeSpinner = (AppCompatSpinner) findViewById(R.id.resultType);
        anomalyTypeSpinner = (AppCompatSpinner) findViewById(R.id.anomalyType);

        collectionEntity = (AppCompatEditText) findViewById(R.id.collectionEntity);
        paymentDate = (AppCompatEditText) findViewById(R.id.paymentDate);
        comPaymentDate = (AppCompatEditText) findViewById(R.id.comPaymentDate);

        personalContact = (AppCompatEditText) findViewById(R.id.personalContact);
        idNumber = (AppCompatEditText) findViewById(R.id.idNumber);
       // clientName = (AppCompatEditText) findViewById(R.id.clientName);
        phone = (AppCompatEditText) findViewById(R.id.phone);
        email = (AppCompatEditText) findViewById(R.id.email);

        observation = (AppCompatEditText) findViewById(R.id.observation);
        readingSignature = (AppCompatEditText) findViewById(R.id.readingSignature);
        dataphonePayment = (AppCompatEditText) findViewById(R.id.dataphonePayment);
        usedTime = (AppCompatEditText) findViewById(R.id.usedTime);

        mSaveButton = (Button) findViewById(R.id.saveButton);
    }


    @Override
    public void onClick(View view) {
        updateDataTask();
    }

    private void updateDataTask() {
        int intUserId = Integer.parseInt(userId.getText().toString().trim());
        int intPersonalContact =  Integer.parseInt(personalContact.getText().toString().trim());
        int intIdNumber = Integer.parseInt(idNumber.getText().toString().trim());
        int intReadingSignature = Integer.parseInt(readingSignature.getText().toString().trim());
        int intDataphonePayment = Integer.parseInt(dataphonePayment.getText().toString().trim());
        mTask.setUserId(intUserId);
        mTask.setManagementDate(managementDate.getText().toString().trim());
        mTask.setManagementTypeId(itemManagementTypeSelected.getId());
        mTask.setResultTypeId(itemResultTypeSelected.getId());
        mTask.setAnomalyTypeId(itemAnomalyTypeSelected.getId());
        mTask.setCollectionEntity(collectionEntity.getText().toString().trim());
        mTask.setPaymentDate(paymentDate.getText().toString().trim());
        mTask.setCommitmentDate(comPaymentDate.getText().toString().trim());
        mTask.setPersonalContact(intPersonalContact);
        mTask.setIdNumber(intIdNumber);
        mTask.setPhone(phone.getText().toString().trim());
        mTask.setEmail(email.getText().toString().trim());
        mTask.setObservations(observation.getText().toString().trim());
        mTask.setReadingSignature(intReadingSignature);
        mTask.setDataphonePayment(intDataphonePayment);
        mTask.setUsedTime(usedTime.getText().toString().trim());
    }

}
