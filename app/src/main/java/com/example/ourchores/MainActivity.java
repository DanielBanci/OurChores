package com.example.ourchores;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.GridView;

import com.example.ourchores.calendar.monthly.CalendarViewMonth;
import com.example.ourchores.calendar.weekly.CalendarViewWeek;

public class MainActivity extends AppCompatActivity {

    public GridView dayGV;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, new CalendarViewMonth(getSupportFragmentManager()))
                .commit();

        /*getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, new CalendarViewWeek(getSupportFragmentManager()))
                .commit();*/

        /*dayGV = findViewById(R.id.daysGV);
        ArrayList<DayModel> courseModelArrayList = new ArrayList<DayModel>();

        courseModelArrayList.add(new DayModel("1"));
        courseModelArrayList.add(new DayModel("2"));
        courseModelArrayList.add(new DayModel("3"));
        courseModelArrayList.add(new DayModel("4"));
        courseModelArrayList.add(new DayModel("5"));
        courseModelArrayList.add(new DayModel("6"));

        DayGVAdapter adapter = new DayGVAdapter(this, courseModelArrayList);
        dayGV.setAdapter(adapter);*/
    }
}
