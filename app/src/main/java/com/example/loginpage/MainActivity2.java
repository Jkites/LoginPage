package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        View activity2_layout = findViewById(R.id.activity_main2);
        Snackbar.make(activity2_layout, "Logged In", Snackbar.LENGTH_SHORT).show();
    }
}