package com.example.ourchores.calendar.monthly;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ourchores.R;
import com.example.ourchores.calendar.monthly.tasks.TaskMonthlyAdapter;

import java.util.ArrayList;
import java.util.List;

public class DayGVAdapter extends ArrayAdapter<DayModel> {
     int var = 1;
    public DayGVAdapter(@NonNull Context context, ArrayList<DayModel> courseModelArrayList) {
        super(context, 0, courseModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View itemView = convertView;
        if (itemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.monthly_day_layout, parent, false);
        }

        DayModel dayModel = getItem(position);
        TextView courseTV = itemView.findViewById(R.id.textViewDayNo);

        courseTV.setText(dayModel.day);


        RecyclerView recyclerView = itemView.findViewById(R.id.mothly_item);
        List<String> dataList = new ArrayList<>(); // Your data source
        if(position == 1){
            dataList.add("title1");
            dataList.add("title2");
        }else if(position == 3){
            dataList.add("title3");
            dataList.add("title4");
        }else if(position == 11){
            dataList.add("title5");
        }
        //dataList.add("title");
        System.out.println(position);
        var++;
        TaskMonthlyAdapter adapter = new TaskMonthlyAdapter(dataList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return itemView;
    }
}
