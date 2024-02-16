package com.example.ourchores.calendar.monthly.tasks;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ourchores.R;

public class TaskMonthlyViewHolder extends RecyclerView.ViewHolder {
    TextView textView;

    public TaskMonthlyViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.tVMILTaskName);
    }
}
