package com.example.loginpage;

import static com.example.loginpage.CalendarPage.current_day;
import static com.example.loginpage.CalendarPage.dates;
import static com.example.loginpage.CalendarPage.descriptions;
import static com.example.loginpage.CalendarPage.ratings;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;


@RequiresApi(api = Build.VERSION_CODES.O)
public class JournalPage extends AppCompatActivity {
    EditText rating;
    EditText description;
    Button saveButton;


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

        if (date_exists()){
            fillFields(rating, description);
        }

        TextView date_text = findViewById(R.id.journalDate);
        date_text.setText(current_day.toString());
        saveButton.setOnClickListener(view -> saveText(view));
    }
    //populate text fields with previous information
    private void fillFields(EditText rating, EditText description){
        for (int index_num=0; index_num<dates.size();index_num++) {
            if (dates.get(index_num).month == current_day.month && dates.get(index_num).year == current_day.year &&
                    dates.get(index_num).day == current_day.day) {//checks if month, year, and day number are equal
                rating.setText(ratings.get(index_num));
                description.setText(descriptions.get(index_num));
            }
        }
    }
    //check if rating is valid integer
    private boolean is_int(String unknown_integer){
        try {
            int test_integer = Integer.parseInt(unknown_integer);
        } catch (Exception NumberFormatException){
            return false;
        }
        return true;
    }
    //check if date already exists
    private boolean date_exists(){
        for (int index_num=0; index_num<dates.size();index_num++){
            if (dates.get(index_num).month==current_day.month&&dates.get(index_num).year==current_day.year&&
                    dates.get(index_num).day==current_day.day){//checks if month, year, and day number are equal
                Log.i("date_exists", "date in index"+dates.get(index_num).toString()); //delete logs in 60,61,78
                Log.i("current date", "current"+current_day.toString());
                return true;
            }
        }
        return false;
    }
    //on click of saveButton
    private void saveText(View view){
        String input_rating = rating.getText().toString();
        String input_description = description.getText().toString();
       if (is_int(input_rating)&&Integer.parseInt(input_rating)<=5&&Integer.parseInt(input_rating)>0) {
           if (!input_description.isEmpty()||input_description!=null){
               if (!date_exists()){
                   ratings.add(input_rating);
                   descriptions.add(input_description);
                   dates.add(current_day.newInstance(current_day));
                   Snackbar.make(view, "Entry successfully saved", Snackbar.LENGTH_SHORT).show();
                   //dates.add(current_day); realize that objects, like arrays are accessed through memory, so simply adding it like this will cause it to change whenever the original object changes
                   Log.i("updateArray",current_day.toString());
               } else { //date already exists
                   for (int index_num=0; index_num<dates.size();index_num++) {
                       if (dates.get(index_num).month == current_day.month && dates.get(index_num).year == current_day.year &&
                               dates.get(index_num).day == current_day.day) {
                           ratings.set(index_num, input_rating);
                           descriptions.set(index_num,input_description);
                           Snackbar.make(view, "Entry overwritten", Snackbar.LENGTH_SHORT).show();
                       }
                   }
               }
           } else {
               Snackbar.make(view, "Error in description text", Snackbar.LENGTH_SHORT).show();
           }
       } else {
           Snackbar.make(view, "Error in rating number", Snackbar.LENGTH_SHORT).show();
       }
    }

}
