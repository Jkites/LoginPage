package com.example.loginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import com.google.android.material.snackbar.Snackbar;

public class CalendarPage extends AppCompatActivity {

    CalendarView calendarView;
    Button button;
    public static EvaluateCalendar current_day = new EvaluateCalendar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        View activity2_layout = findViewById(R.id.activity_calendar);
        Snackbar.make(activity2_layout, "Logged In", Snackbar.LENGTH_SHORT).show();

        calendarView = findViewById(R.id.calendarView);
        button = findViewById(R.id.date_button);

        //updateDate(time.get); how to get current date

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                current_day.updateEvaluateCalendar(year, month, day);
                button.setText(current_day.updateDate());
            }
        });
        button.setOnClickListener(view -> evaluateOpeningActivity3(view));
    }
    private void evaluateOpeningActivity3(View view){
        openActivity3();
    }
    private void openActivity3(){
        Intent intent = new Intent(this, JournalPage.class);
        startActivity(intent);
    }
}