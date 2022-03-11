package com.example.loginpage;

import static com.example.loginpage.CalendarPage.current_day;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;


public class JournalPage extends AppCompatActivity {
    EditText rating;
    EditText description;
    Button saveButton;
    ArrayList<String> descriptions = new ArrayList<String>();

    @RequiresApi(api = Build.VERSION_CODES.O)//api level 26 required
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);

        View journal_layout = findViewById(R.id.activity_journal);
        Snackbar.make(journal_layout, "Opened Journal", Snackbar.LENGTH_SHORT).show();

        rating = findViewById(R.id.editTextRating);
        description = findViewById(R.id.editTextDescription);
        saveButton = findViewById(R.id.saveButton);

        TextView date_text = findViewById(R.id.journalDate);
        date_text.setText(current_day.updateDate());
    }

    private void saveText(){

    }
}
