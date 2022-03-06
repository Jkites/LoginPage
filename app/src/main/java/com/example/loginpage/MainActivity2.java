package com.example.loginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class MainActivity2 extends AppCompatActivity {

    CalendarView calendarView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        View activity2_layout = findViewById(R.id.activity_main2);
        Snackbar.make(activity2_layout, "Logged In", Snackbar.LENGTH_SHORT).show();

        calendarView = findViewById(R.id.calendarView);
        button = findViewById(R.id.date_button);

        //updateDate(time.get); how to get current date
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                updateDate(year,month,day);
            }
        });
    }
    private String getMonthName(int month_num){
        String[] months={"January","February", "March", "April", "May","June","July",
                "August","September","October","November","December"};
        return months[month_num];
    }
    private void updateDate(int year, int month, int day){
            String date_str = "Edit "+getMonthName(month)+" "+day+", "+year;
            button.setText(date_str);
    }
}