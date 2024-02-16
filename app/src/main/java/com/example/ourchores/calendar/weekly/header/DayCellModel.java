package com.example.ourchores.calendar.weekly.header;

public class DayCellModel {
    private String day;
    private String dayNo;

    public DayCellModel(String day, String dayNo){
        this.day = day;
        this.dayNo = dayNo;
    }

    public String getDay(){
        return day;
    }

    public String getDayNo(){
        return dayNo;
    }
}
