package com.example.ourchores.calendar.monthly;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.example.ourchores.R;
import com.example.ourchores.calendar.monthly.daynamerow.DayCellModel;
import com.example.ourchores.calendar.monthly.daynamerow.NamesRowGVAdapter;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalendarViewMonth#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalendarViewMonth extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentManager mFragmentManager;
    private View mVRootView;
    private GridView mGVDay;
    private GridView mGVDaysName;
    private TextView mTVCurrentMonth;
    private Calendar mCcal;

    public CalendarViewMonth() {
        // Required empty public constructor
    }
    public CalendarViewMonth(FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalendarViewMonth.
     */
    // TODO: Rename and change types and number of parameters
    public static CalendarViewMonth newInstance(String param1, String param2) {
        CalendarViewMonth fragment = new CalendarViewMonth();
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mVRootView = inflater.inflate(R.layout.fragment_calendar_view_month, container, false);
        mGVDay = mVRootView.findViewById(R.id.daysGV);
        mGVDaysName = mVRootView.findViewById(R.id.weekNamesDaysGVMonth);
        mTVCurrentMonth = mVRootView.findViewById(R.id.tVCurrentMonth);

        mCcal = Calendar.getInstance();
        makeNamesRow();
        makeDaysData(mCcal);

        return mVRootView;
    }


    @SuppressWarnings("ConstantConditions")
    private void makeDaysData(Calendar cal){
        ArrayList<DayModel> courseModelArrayList = new ArrayList<DayModel>();

        //display current month + year
        displayCurrentMonth(cal);

        //set first day of month as monday
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_MONTH,1);
        int firstDayNameValue = cal.get(Calendar.DAY_OF_WEEK);

        //Set calendar to previous month
        //and starting from the position of the first day of the month going till
        //> 2 (the value of monday) to display the optional last few days from previous week
        cal.add(Calendar.MONTH,-1);
        int lastDayPM = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        for(int i = firstDayNameValue;i>2;i--){
            int ii = lastDayPM - firstDayNameValue + i;
            courseModelArrayList.add(new DayModel(Integer.toString(ii)));      //TODO: chnage name
        }
        //sort the previous days
        courseModelArrayList.sort((x,y)->{return x.day.compareTo(y.day);});

        //set the calendar to current month again
        //and display the current month days
        cal.add(Calendar.MONTH,1);
        int maxCurrentMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for(int i = 0;i < maxCurrentMonth;i++){
            int ii = i+1;
            courseModelArrayList.add(new DayModel(Integer.toString(ii)));
        }

        //display the first optional few days from the next month
        cal.set(Calendar.DAY_OF_MONTH,maxCurrentMonth);
        int lastDayInWeek = cal.get(Calendar.DAY_OF_WEEK);
        if(lastDayInWeek > 1 ){
            int ii = 1;
            for(int i = 0;i < 8 - lastDayInWeek;i++){
                courseModelArrayList.add(new DayModel(Integer.toString(ii++)));
            }
        }

        DayGVAdapter adapter = new DayGVAdapter(getContext(), courseModelArrayList);
        mGVDay.setAdapter(adapter);
    }

    /**
     * Displays the names of the days in a row
     */
    @SuppressWarnings("ConstantConditions")
    private void makeNamesRow(){
        ArrayList<DayCellModel> daysNameModelArrayList = new ArrayList<DayCellModel>();

        daysNameModelArrayList.add(new DayCellModel(getResources().getString(R.string.day_1)));
        daysNameModelArrayList.add(new DayCellModel(getResources().getString(R.string.day_2)));
        daysNameModelArrayList.add(new DayCellModel(getResources().getString(R.string.day_3)));
        daysNameModelArrayList.add(new DayCellModel(getResources().getString(R.string.day_4)));
        daysNameModelArrayList.add(new DayCellModel(getResources().getString(R.string.day_5)));
        daysNameModelArrayList.add(new DayCellModel(getResources().getString(R.string.day_6)));
        daysNameModelArrayList.add(new DayCellModel(getResources().getString(R.string.day_7)));

        NamesRowGVAdapter adapterDaysName = new NamesRowGVAdapter(getContext(), daysNameModelArrayList);
        mGVDaysName.setAdapter(adapterDaysName);
    }

    @SuppressLint("SetTextI18n")
    private void displayCurrentMonth(Calendar cal){
        int currentMonth = cal.get(Calendar.MONTH);
        int currentYear = cal.get(Calendar.YEAR);
        String text;
        switch(currentMonth){
            case 0:
                text = getResources().getText(R.string.month_1).toString();
                mTVCurrentMonth.setText(text + " " + currentYear);
                break;
            case 1:
                text = getResources().getText(R.string.month_2).toString();
                mTVCurrentMonth.setText(text + " " + currentYear);
                break;
            case 2:
                text = getResources().getText(R.string.month_3).toString();
                mTVCurrentMonth.setText(text + " " + currentYear);
                break;
            case 3:
                text = getResources().getText(R.string.month_4).toString();
                mTVCurrentMonth.setText(text + " " + currentYear);
                break;
            case 4:
                text = getResources().getText(R.string.month_5).toString();
                mTVCurrentMonth.setText(text + " " + currentYear);
                break;
            case 5:
                text = getResources().getText(R.string.month_6).toString();
                mTVCurrentMonth.setText(text + " " + currentYear);
                break;
            case 6:
                text = getResources().getText(R.string.month_7).toString();
                mTVCurrentMonth.setText(text + " " + currentYear);
                break;
            case 7:
                text = getResources().getText(R.string.month_8).toString();
                mTVCurrentMonth.setText(text + " " + currentYear);
                break;
            case 8:
                text = getResources().getText(R.string.month_9).toString();
                mTVCurrentMonth.setText(text + " " + currentYear);
                break;
            case 9:
                text = getResources().getText(R.string.month_10).toString();
                mTVCurrentMonth.setText(text + " " + currentYear);
                break;
            case 10:
                text = getResources().getText(R.string.month_11).toString();
                mTVCurrentMonth.setText(text + " " + currentYear);
                break;
            case 11:
                text = getResources().getText(R.string.month_12).toString();
                mTVCurrentMonth.setText(text + " " + currentYear);
                break;

        }
    }
}