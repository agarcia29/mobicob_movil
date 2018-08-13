package com.mobicob.mobile.app.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mobicob.mobile.app.R;
import com.mobicob.mobile.app.activity.AssignmentsActivity;
import com.mobicob.mobile.app.activity.MainActivity;
import com.mobicob.mobile.app.model.Client;
import com.mobicob.mobile.app.model.Task;
import com.mobicob.mobile.app.model.TasksResponse;
import com.mobicob.mobile.app.restApi.JsonKeys;

import java.util.ArrayList;
import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.AssignmentsViewHolder> {

    private List<Task> mDataSet;
    private Context context;

    public TasksAdapter(TasksResponse mDataSet) {
        this.mDataSet = mDataSet.getTasks();
    }

    public TasksAdapter(Context context) {
        this.context = context;
        mDataSet = new ArrayList<>();
    }

    public void setDataSet(TasksResponse dataSet){
        mDataSet = dataSet.getTasks();
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
        final Task task = mDataSet.get(position);

        holder.txtAssignmentNic.setText(mDataSet.get(position).getClient().getNic()+"");
        holder.txtAssignmentAddress.setText(mDataSet.get(position).getClient().getAddress()+"");
        holder.txtAssignmentNeighborhood.setText(mDataSet.get(position).getClient().getNeighborhood()+"");
        holder.txtAssignmentMunicipality.setText(mDataSet.get(position).getClient().getMunicipality()+"");
        holder.txtAssignmentCorregimiento.setText(mDataSet.get(position).getClient().getCorregimiento()+"");
        holder.txtAssignmentDepartment.setText(mDataSet.get(position).getClient().getDepartament()+"");

        //Bind click

        holder.cardViewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AssignmentsActivity.class);
                intent.putExtra(JsonKeys.TASK_CAMPAIGN_NUMBER,task.getCampaign().getNumber());
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

        TextView txtAssignmentNic, txtAssignmentAddress,txtAssignmentNeighborhood
                , txtAssignmentMunicipality, txtAssignmentCorregimiento, txtAssignmentDepartment;
        CardView cardViewTask;
        AssignmentsViewHolder(View itemView) {
            super(itemView);
            cardViewTask = itemView.findViewById(R.id.cardViewTask);
            txtAssignmentNic =  itemView.findViewById(R.id.tvAssignmentNic);
            txtAssignmentAddress =  itemView.findViewById(R.id.tvAddress);
            txtAssignmentNeighborhood =  itemView.findViewById(R.id.tvNeighborhood);
            txtAssignmentMunicipality = itemView.findViewById(R.id.tvMunicipality);
            txtAssignmentCorregimiento = itemView.findViewById(R.id.tvCorregimiento);
            txtAssignmentDepartment = itemView.findViewById(R.id.tvDepartment);
        }
    }
}
