package com.mobicob.mobile.app.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mobicob.mobile.app.R;
import com.mobicob.mobile.app.ui.activity.AssignmentsActivity;
import com.mobicob.mobile.app.model.LoginResponse;
import com.mobicob.mobile.app.model.Task;
import com.mobicob.mobile.app.model.TasksResponse;

import java.util.ArrayList;
import java.util.List;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.AssignmentsViewHolder> {

    private List<Task> mDataSet;
    private LoginResponse loginResponse;
    private Context context;

    public ClientAdapter(TasksResponse mDataSet) {
        this.mDataSet = mDataSet.getTasks();
    }

    public ClientAdapter(Context context) {
        this.context = context;
        loginResponse = new LoginResponse();
        mDataSet = new ArrayList<>();
    }

    public void setDataSet(TasksResponse dataSet){
        mDataSet = dataSet.getTasks();
        notifyDataSetChanged();
    }
    @Override
    public ClientAdapter.AssignmentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.client_view, parent, false);
        return new ClientAdapter.AssignmentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ClientAdapter.AssignmentsViewHolder holder, int position) {

        holder.txtClientNoCampaign.setText(mDataSet.get(position).getCampaign().getNumber()+"");
        holder.txtClientDeadLine.setText(mDataSet.get(position).getDueDate()+"");
        holder.txtClientUnicom.setText(mDataSet.get(position).getClient().getUnicom()+"");
        holder.txtClientNic.setText(mDataSet.get(position).getClient().getNic()+"");
        holder.txtClientNisRad.setText(mDataSet.get(position).getClient().getNisRad()+"");
        holder.txtClientDepartment.setText(mDataSet.get(position).getClient().getDepartament()+"");
        holder.txtClientMunicipality.setText(mDataSet.get(position).getClient().getMunicipality()+"");
        holder.txtClientCorregimiento.setText(mDataSet.get(position).getClient().getCorregimiento()+"");
        holder.txtClientNeighborhood.setText(mDataSet.get(position).getClient().getNeighborhood()+"");
        holder.txtClientStreetType.setText(mDataSet.get(position).getClient().getStreetType()+"");
        holder.txtClientStreetName.setText(mDataSet.get(position).getClient().getStreetName()+"");
        holder.txtClientDuplicator.setText(mDataSet.get(position).getClient().getDuplicator()+"");
        holder.txtClientNro.setText(mDataSet.get(position).getClient().getNumber()+"");
        holder.txtClientCgv.setText(mDataSet.get(position).getClient().getCgv()+"");
        holder.txtClientAddressRef.setText(mDataSet.get(position).getClient().getAddress()+"");
        holder.txtClient.setText(mDataSet.get(position).getClient().getName()+"");
        holder.txtClientNumberId.setText(mDataSet.get(position).getClient().getIdNumber()+"");
        holder.txtClientPhone.setText(mDataSet.get(position).getClient().getPhone()+"");
        holder.txtClientRate.setText(mDataSet.get(position).getClient().getRate()+"");
        holder.txtClientState.setText(mDataSet.get(position).getClient().getState()+"");
        holder.txtClientRoute.setText(mDataSet.get(position).getClient().getRoute()+"");
        holder.txtClientItinLectura.setText(mDataSet.get(position).getClient().getReadingItinerary()+"");
        holder.txtClientAolFinca.setText(mDataSet.get(position).getClient().getaOLFinca()+"");
        holder.txtClientMeasurer.setText(mDataSet.get(position).getClient().getMeasurer()+"");
        holder.txtClientMeasurerType.setText(mDataSet.get(position).getClient().getMeasurerType()+"");
        holder.txtClientMeasurerBrand.setText(mDataSet.get(position).getClient().getMeasurerBrand()+"");
        holder.txtClientEnergyDebt.setText(mDataSet.get(position).getClient().getEnergyDebt()+"");
        holder.txtClientIrregularDebt.setText(mDataSet.get(position).getClient().getIrregularDebt()+"");
        holder.txtClientThirdPartyDebt.setText(mDataSet.get(position).getClient().getThirdPartyDebt()+"");
        holder.txtClientFinancedDebt.setText(mDataSet.get(position).getClient().getFinancedDebt()+"");
        holder.txtClientOverdueBill.setText(mDataSet.get(position).getClient().getOverdueBills()+"");
        holder.txtClientAgreedBill.setText(mDataSet.get(position).getClient().getAgreedBills()+"");
        holder.txtTaskPeriod.setText(mDataSet.get(position).getPeriod()+"");
        holder.txtTaskPlan.setText(mDataSet.get(position).getPlan()+"");
        holder.txtUserContractor.setText(loginResponse.getContractorId()+"");
        holder.txtUserDelegation.setText(loginResponse.getDelegationId()+"");

        //Bind click

        holder.cardViewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AssignmentsActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if(mDataSet != null) {
            return mDataSet.size();
        }else {
            return 0;
        }
    }

    class AssignmentsViewHolder extends RecyclerView.ViewHolder {

        TextView txtClientNoCampaign, txtClientDeadLine,txtClientUnicom
                , txtClientNic, txtClientNisRad, txtClientDepartment, txtClientMunicipality
                ,txtClientCorregimiento, txtClientNeighborhood, txtClientStreetType
                ,txtClientStreetName, txtClientDuplicator, txtClientNro, txtClientCgv, txtClientAddressRef
                ,txtClient, txtClientNumberId, txtClientPhone, txtClientRate, txtClientState
                , txtClientRoute, txtClientItinLectura, txtClientAolFinca, txtClientMeasurer
                , txtClientMeasurerType, txtClientMeasurerBrand, txtClientEnergyDebt,txtClientIrregularDebt
                , txtClientThirdPartyDebt, txtClientFinancedDebt, txtClientOverdueBill,txtClientAgreedBill
                ,txtTaskPeriod,txtTaskPlan, txtUserContractor, txtUserDelegation;
        CardView cardViewTask;
        AssignmentsViewHolder(View itemView) {
            super(itemView);
            cardViewTask = itemView.findViewById(R.id.cardViewTask);
            txtClientNoCampaign =  itemView.findViewById(R.id.tvClientNoCampaign);
            txtClientDeadLine =  itemView.findViewById(R.id.tvClientDeadLine);
            txtClientUnicom =  itemView.findViewById(R.id.tvClientUnicom);
            txtClientNic = itemView.findViewById(R.id.tvClientNic);
            txtClientNisRad = itemView.findViewById(R.id.tvClientNisRad);
            txtClientDepartment = itemView.findViewById(R.id.tvClientDepartment);
            txtClientMunicipality = itemView.findViewById(R.id.tvClientMunicipality);
            txtClientCorregimiento = itemView.findViewById(R.id.tvClientCorregimiento);
            txtClientNeighborhood = itemView.findViewById(R.id.tvClientNeighborhood);
            txtClientStreetType = itemView.findViewById(R.id.tvClientStreetType);
            txtClientStreetName = itemView.findViewById(R.id.tvClientStreetName);
            txtClientDuplicator = itemView.findViewById(R.id.tvClientDuplicator);
            txtClientNro = itemView.findViewById(R.id.tvClientNro);
            txtClientCgv = itemView.findViewById(R.id.tvClientCgv);
            txtClientAddressRef = itemView.findViewById(R.id.tvClientAddressRef);
            txtClient = itemView.findViewById(R.id.tvClient);
            txtClientNumberId = itemView.findViewById(R.id.tvClientNumberId);
            txtClientPhone = itemView.findViewById(R.id.tvClientPhone);
            txtClientRate = itemView.findViewById(R.id.tvClientRate);
            txtClientState = itemView.findViewById(R.id.tvClientState);
            txtClientRoute = itemView.findViewById(R.id.tvClientRoute);
            txtClientItinLectura = itemView.findViewById(R.id.tvClientItinLectura);
            txtClientAolFinca = itemView.findViewById(R.id.tvClientAolFinca);
            txtClientMeasurer = itemView.findViewById(R.id.tvClientMeasurer);
            txtClientMeasurerType = itemView.findViewById(R.id.tvClientMeasurerType);
            txtClientMeasurerBrand = itemView.findViewById(R.id.tvClientMeasurerBrand);
            txtClientEnergyDebt = itemView.findViewById(R.id.tvClientEnergyDebt);
            txtClientIrregularDebt = itemView.findViewById(R.id.tvClientIrregularDebt);
            txtClientThirdPartyDebt = itemView.findViewById(R.id.tvClientThirdPartyDebt);
            txtClientFinancedDebt = itemView.findViewById(R.id.tvClientFinancedDebt);
            txtClientOverdueBill = itemView.findViewById(R.id.tvClientOverdueBill);
            txtClientAgreedBill = itemView.findViewById(R.id.tvClientAgreedBill);
            txtTaskPeriod = itemView.findViewById(R.id.tvTaskPeriod);
            txtTaskPlan = itemView.findViewById(R.id.tvTaskPlan);
            txtUserContractor = itemView.findViewById(R.id.tvUserContractor);
            txtUserDelegation = itemView.findViewById(R.id.tvUserDelegation);
        }
    }
}
