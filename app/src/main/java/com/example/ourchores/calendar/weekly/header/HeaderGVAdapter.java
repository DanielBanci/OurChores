package com.example.ourchores.calendar.weekly.header;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ourchores.R;
import com.example.ourchores.calendar.weekly.HourModel;

import java.util.ArrayList;

public class HeaderGVAdapter extends ArrayAdapter<DayCellModel> {

    public HeaderGVAdapter(@NonNull Context context, ArrayList<DayCellModel> courseModelArrayList) {
        super(context, 0, courseModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View itemView = convertView;
        if (itemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.week_header_cell_layout, parent, false);
        }

        DayCellModel hourModel = getItem(position);
        TextView day = itemView.findViewById(R.id.tVWHDayName);
        TextView dayNo = itemView.findViewById(R.id.tVWHDayNo);

        day.setText(hourModel.getDay());
        dayNo.setText(hourModel.getDayNo());
        return itemView;
    }

}
