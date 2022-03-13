package com.example.loginpage;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;

public class EvaluateCalendar {
    int month;
    int year;
    int day;

    @RequiresApi(api = Build.VERSION_CODES.O) //api level 26 required
    public EvaluateCalendar(){
        LocalDateTime local_time = LocalDateTime.now();
        this.month = local_time.getMonthValue()-1;
        this.year = local_time.getYear();
        this.day = local_time.getDayOfMonth();
    }
    public EvaluateCalendar(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void updateEvaluateCalendar(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    private String getMonthName(int month){
        String[] months={"January","February", "March", "April", "May","June","July",
                "August","September","October","November","December"};
        return months[month];
    }

    public static EvaluateCalendar newInstance(EvaluateCalendar evaluateCalendar){ //copy constructor to make new object
        return new EvaluateCalendar(evaluateCalendar.year, evaluateCalendar.month, evaluateCalendar.day);
    }
    public String toString(){
        String date_str = "Edit "+getMonthName(month)+" "+day+", "+year;
        return date_str;
    }
}
