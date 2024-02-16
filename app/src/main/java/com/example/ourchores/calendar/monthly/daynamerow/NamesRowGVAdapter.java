package com.example.ourchores.calendar.monthly.daynamerow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ourchores.R;

import java.util.ArrayList;

public class NamesRowGVAdapter extends ArrayAdapter<DayCellModel> {

    public NamesRowGVAdapter(@NonNull Context context, ArrayList<DayCellModel> courseModelArrayList) {
        super(context, 0, courseModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View itemView = convertView;
        if (itemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.cell_day_name_layout, parent, false);
        }

        DayCellModel dayCellModel = getItem(position);
        TextView dayName = itemView.findViewById(R.id.textViewDayNameMonth);

        dayName.setText(dayCellModel.getDay());
        return itemView;
    }
}
