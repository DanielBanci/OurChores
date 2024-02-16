package com.example.ourchores.calendar.monthly.daynamerow;

public class DayCellModel {
    private String day;

    public DayCellModel(String day){

        this.day = day.substring(0,3) + ".";
    }

    public String getDay(){
        return day;
    }

}
