package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.login_button);
        button.setOnClickListener(view -> correctCredentials(view));
    }
    private void correctCredentials(View view){
        EditText username = findViewById(R.id.editTextTextPersonName);
        EditText password = findViewById(R.id.editTextTextPassword);
        if (username.getText().toString().equals("Baer")){
            if (password.getText().toString().equals("hello1234")){
                openActivity2();
            }
            else{
                Snackbar.make(view, "Invalid Credentials", Snackbar.LENGTH_SHORT).show();
            }
        }
        else {
            Snackbar.make(view, "Invalid Credentials", Snackbar.LENGTH_SHORT).show();
        }
    }
    public void openActivity2(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}