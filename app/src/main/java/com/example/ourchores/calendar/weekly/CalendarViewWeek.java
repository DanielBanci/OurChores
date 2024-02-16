package com.example.ourchores.calendar.weekly;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.ourchores.R;
import com.example.ourchores.calendar.monthly.DayGVAdapter;
import com.example.ourchores.calendar.weekly.header.DayCellModel;
import com.example.ourchores.calendar.weekly.header.HeaderGVAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalendarViewWeek#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalendarViewWeek extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentManager mFragmentManager;

    public CalendarViewWeek() {
        // Required empty public constructor
    }

    public CalendarViewWeek(FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalendarViewWeek.
     */
    // TODO: Rename and change types and number of parameters
    public static CalendarViewWeek newInstance(String param1, String param2) {
        CalendarViewWeek fragment = new CalendarViewWeek();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private View root;
    private GridView gVHours;
    private GridView gVHeader;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_calendar_view_week, container, false);
        gVHours = root.findViewById(R.id.gVDisplayHour);
        gVHeader = root.findViewById(R.id.gVDayNamesWeekly);

        ArrayList<HourModel> HoursModelArrayList = new ArrayList<HourModel>();

        HoursModelArrayList.add(new HourModel("00:00"));
        HoursModelArrayList.add(new HourModel("01:00"));
        HoursModelArrayList.add(new HourModel("02:00"));
        HoursModelArrayList.add(new HourModel("03:00"));
        HoursModelArrayList.add(new HourModel("04:00"));
        HoursModelArrayList.add(new HourModel("05:00"));
        HoursModelArrayList.add(new HourModel("06:00"));
        HoursModelArrayList.add(new HourModel("07:00"));
        HoursModelArrayList.add(new HourModel("08:00"));
        HoursModelArrayList.add(new HourModel("09:00"));
        HoursModelArrayList.add(new HourModel("10:00"));
        HoursModelArrayList.add(new HourModel("11:00"));
        HoursModelArrayList.add(new HourModel("12:00"));
        HoursModelArrayList.add(new HourModel("13:00"));
        HoursModelArrayList.add(new HourModel("14:00"));
        HoursModelArrayList.add(new HourModel("15:00"));
        HoursModelArrayList.add(new HourModel("16:00"));
        HoursModelArrayList.add(new HourModel("17:00"));
        HoursModelArrayList.add(new HourModel("18:00"));
        HoursModelArrayList.add(new HourModel("19:00"));
        HoursModelArrayList.add(new HourModel("20:00"));
        HoursModelArrayList.add(new HourModel("21:00"));
        HoursModelArrayList.add(new HourModel("22:00"));
        HoursModelArrayList.add(new HourModel("23:00"));

        HourGVAdapter adapter = new HourGVAdapter(getContext(), HoursModelArrayList);
        gVHours.setAdapter(adapter);

        ArrayList<DayCellModel> HeaderModelArrayList = new ArrayList<DayCellModel>();

        HeaderModelArrayList.add(new DayCellModel("Lun.","4"));
        HeaderModelArrayList.add(new DayCellModel("Mar.","5"));
        HeaderModelArrayList.add(new DayCellModel("Mie.","6"));
        HeaderModelArrayList.add(new DayCellModel("Joi","7"));
        HeaderModelArrayList.add(new DayCellModel("Vin.","8"));
        HeaderModelArrayList.add(new DayCellModel("Sam.","9"));
        HeaderModelArrayList.add(new DayCellModel("Dum.","10"));

        HeaderGVAdapter headerAdapter = new HeaderGVAdapter(getContext(), HeaderModelArrayList);

        gVHeader.setAdapter(headerAdapter);

        return root;
    }
}