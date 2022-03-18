package com.example.loginpage;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @RequiresApi(api = Build.VERSION_CODES.O)//api level 26 required
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //defining UI objects
        button = findViewById(R.id.login_button);
        button.setOnClickListener(view -> correctCredentials(view));
    }
    //Login
    @RequiresApi(api = Build.VERSION_CODES.O)//api level 26 required
    private void correctCredentials(View view){
        EditText username = findViewById(R.id.editTextTextPersonName);
        EditText password = findViewById(R.id.editTextTextPassword);
        InputMethodManager hide_keyboard = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        hide_keyboard.hideSoftInputFromWindow(view.getWindowToken(),0);
        if (username.getText().toString().equals("Baer")&&password.getText().toString().equals("hello1234")) {
            openActivity2();
        }
        else {
            Snackbar.make(view, "Invalid Credentials", Snackbar.LENGTH_SHORT).show();
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.O) //api level 26 required
    public void openActivity2(){
        Intent intent = new Intent(this, CalendarPage.class);
        startActivity(intent);
    }
}