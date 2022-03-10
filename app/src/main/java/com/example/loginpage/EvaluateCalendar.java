package com.example.loginpage;

public class EvaluateCalendar {
    int month;
    int year;
    int day;

    public EvaluateCalendar(){

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
    public String updateDate(){
        String date_str = "Edit "+getMonthName(month)+" "+day+", "+year;
        return date_str;
    }
}
