package com.example.ourchores.calendar.weekly;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ourchores.R;
import com.example.ourchores.calendar.monthly.DayModel;

import java.util.ArrayList;

public class HourGVAdapter extends ArrayAdapter<HourModel> {

    public HourGVAdapter(@NonNull Context context, ArrayList<HourModel> courseModelArrayList) {
        super(context, 0, courseModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View itemView = convertView;
        if (itemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.hour_display_layout, parent, false);
        }

        HourModel hourModel = getItem(position);
        TextView courseTV = itemView.findViewById(R.id.tVHour);

        courseTV.setText(hourModel.getTime());
        return itemView;
    }
}
