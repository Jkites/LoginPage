package com.example.loginpage;

import static com.example.loginpage.CalendarPage.current_day;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;


public class JournalPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);

        View journal_layout = findViewById(R.id.activity_journal);
        Snackbar.make(journal_layout, "Opened Journal", Snackbar.LENGTH_SHORT).show();

        TextView date_text = findViewById(R.id.textView3);
        date_text.setText(current_day.updateDate());
    }
}
