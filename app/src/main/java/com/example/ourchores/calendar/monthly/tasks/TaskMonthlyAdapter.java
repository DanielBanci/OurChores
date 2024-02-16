package com.example.ourchores.calendar.monthly.tasks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ourchores.R;

import java.util.List;

public class TaskMonthlyAdapter extends RecyclerView.Adapter<TaskMonthlyViewHolder> {
    private List<String> dataList;

    public TaskMonthlyAdapter(List<String> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public TaskMonthlyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mothly_item_layout, parent, false);
        return new TaskMonthlyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskMonthlyViewHolder holder, int position) {
        String data = dataList.get(position);
        holder.textView.setText(data);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
