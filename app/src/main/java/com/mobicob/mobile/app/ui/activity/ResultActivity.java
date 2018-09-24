package com.mobicob.mobile.app.ui.activity;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.mobicob.mobile.app.R;
import com.mobicob.mobile.app.apiclient.JsonKeys;
import com.mobicob.mobile.app.db.entity.AnomalyType;
import com.mobicob.mobile.app.db.entity.ManagementType;
import com.mobicob.mobile.app.db.entity.ResultType;
import com.mobicob.mobile.app.db.entity.Task;
import com.mobicob.mobile.app.viewmodel.AnomalyTypeViewModel;
import com.mobicob.mobile.app.viewmodel.ManagementTypeViewModel;
import com.mobicob.mobile.app.viewmodel.ResultTypeViewModel;

import java.util.ArrayList;
import java.util.List;

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
    private List<ResultType> resultTypesList;
    private ArrayAdapter<ResultType> adapterResultSpinner;
    private List<AnomalyType> anomalyTypesList;
    private ArrayAdapter<AnomalyType> adapterAnomalySpinner;

    private List<ResultType> filteredResultTypesList;
    private List<AnomalyType> filteredAnomalyTypesList;

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

        resultTypesList = new ArrayList<>();
        anomalyTypesList = new ArrayList<>();

        managementTypesList = new ArrayList<>();
        filteredResultTypesList = new ArrayList<>();
        filteredAnomalyTypesList = new ArrayList<>();

        mManagementTypeViewModel = ViewModelProviders.of(this).get(ManagementTypeViewModel.class);
        mResultTypeViewModel = ViewModelProviders.of(this).get(ResultTypeViewModel.class);
        mAnomalyTypeViewModel = ViewModelProviders.of(this).get(AnomalyTypeViewModel.class);


        adapterManagementSpinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, managementTypesList);
        adapterManagementSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterManagementSpinner.setNotifyOnChange(true);
        managementTypeSpinner.setAdapter(adapterManagementSpinner);


        adapterResultSpinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, filteredResultTypesList);
        adapterResultSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        resultTypeSpinner.setAdapter(adapterResultSpinner);

        adapterAnomalySpinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, filteredAnomalyTypesList);
        adapterAnomalySpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        anomalyTypeSpinner.setAdapter(adapterAnomalySpinner);

        mManagementTypeViewModel.getAllManagementTypes().observe(this, new Observer<List<ManagementType>>() {
            @Override
            public void onChanged(@Nullable final List<ManagementType> managementTypes) {
                managementTypesList = managementTypes;
                adapterManagementSpinner.clear();
                adapterManagementSpinner.addAll(managementTypes);
            }
        });

        mResultTypeViewModel.getAllResultTypes().observe(this, new Observer<List<ResultType>>() {
            @Override
            public void onChanged(@Nullable final List<ResultType> resultTypes) {
                resultTypesList = resultTypes;
            }
        });
        mAnomalyTypeViewModel.getAllAnomalyTypes().observe(this, new Observer<List<AnomalyType>>() {
            @Override
            public void onChanged(@Nullable final List<AnomalyType> anomalyTypes) {
                anomalyTypesList = anomalyTypes;
            }
        });


        managementTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                itemManagementTypeSelected = managementTypesList.get(i);
                filteredResultTypesList = new ArrayList<>();
                filteredAnomalyTypesList = new ArrayList<>();
                for (ResultType result:resultTypesList){
                    if(result.belongsTo(itemManagementTypeSelected.getId())){
                        filteredResultTypesList.add(result);
                    }
                }
                adapterResultSpinner.clear();
                adapterResultSpinner.addAll(filteredResultTypesList);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        resultTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                itemResultTypeSelected = filteredResultTypesList.get(i);
                filteredAnomalyTypesList = new ArrayList<>();
                for (AnomalyType anomaly:anomalyTypesList){
                    if(anomaly.belongsTo(itemResultTypeSelected.getId())){
                        filteredAnomalyTypesList.add(anomaly);
                    }
                }
                adapterAnomalySpinner.clear();
                adapterAnomalySpinner.addAll(filteredAnomalyTypesList);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        anomalyTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                itemAnomalyTypeSelected = filteredAnomalyTypesList.get(i);
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
