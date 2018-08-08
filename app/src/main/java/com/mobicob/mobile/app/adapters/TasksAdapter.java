package com.mobicob.mobile.app.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mobicob.mobile.app.R;
import com.mobicob.mobile.app.model.Client;

import java.util.ArrayList;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.AssignmentsViewHolder> {

    private ArrayList<Client> mDataSet;

    public TasksAdapter(ArrayList<Client> mDataSet) {
        this.mDataSet = mDataSet;
    }

    public TasksAdapter() {
        mDataSet = new ArrayList<>();
    }

    public void setDataSet(ArrayList<Client> dataSet){
        mDataSet = dataSet;
        notifyDataSetChanged();
    }
    @Override
    public AssignmentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.tasks_view, parent, false);
        return new AssignmentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AssignmentsViewHolder holder, int position) {

        holder.txtAssignmentNic.setText(mDataSet.get(position).getNic());
        holder.txtAssignmentAddress.setText(mDataSet.get(position).getAddress());
        holder.txtAssignmentNeighborhood.setText(mDataSet.get(position).getNeighborhood());
        holder.txtAssignmentMunicipality.setText(mDataSet.get(position).getMunicipality());
        holder.txtAssignmentCorregimiento.setText(mDataSet.get(position).getCorregimiento());
        holder.txtAssignmentDepartment.setText(mDataSet.get(position).getDepartament());

    }

    @Override
    public int getItemCount() {

        return mDataSet.size();
    }

    class AssignmentsViewHolder extends RecyclerView.ViewHolder {

        TextView txtAssignmentNic, txtAssignmentAddress,txtAssignmentNeighborhood, txtAssignmentMunicipality, txtAssignmentCorregimiento, txtAssignmentDepartment;

        AssignmentsViewHolder(View itemView) {
            super(itemView);
            txtAssignmentNic =  itemView.findViewById(R.id.tvAssignmentNic);
            txtAssignmentAddress =  itemView.findViewById(R.id.tvAddress);
            txtAssignmentNeighborhood =  itemView.findViewById(R.id.tvNeighborhood);
            txtAssignmentMunicipality = itemView.findViewById(R.id.tvMunicipality);
            txtAssignmentCorregimiento = itemView.findViewById(R.id.tvCorregimiento);
            txtAssignmentDepartment = itemView.findViewById(R.id.tvDepartment);
        }
    }
}
