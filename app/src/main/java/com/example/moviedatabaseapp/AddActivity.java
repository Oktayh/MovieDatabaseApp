package com.example.moviedatabaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.moviedatabaseapp.db.DBHelper;

public class AddActivity extends AppCompatActivity {
    EditText name,genre,year;
    RadioGroup statusRadioGroup;
    RadioButton statusChecked;
    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        statusRadioGroup = findViewById(R.id.radioGroup);
        name = findViewById(R.id.name_movie);
        genre = findViewById(R.id.genre_movie);
        year = findViewById(R.id.year_movie);
        addBtn = findViewById(R.id.btn_add);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedID = statusRadioGroup.getCheckedRadioButtonId();
                statusChecked = (RadioButton) findViewById(selectedID);
                DBHelper dbHelper = new DBHelper(AddActivity.this);
                CustomModel customModel;
                try {
                    customModel = new CustomModel(-1,name.getText().toString(),genre.getText().toString(),Integer.parseInt(year.getText().toString()),statusChecked.getText().toString());
                    Toast.makeText(AddActivity.this,customModel.toString(),Toast.LENGTH_LONG).show();
                }
                catch (Exception e){
                    Toast.makeText(AddActivity.this,"Missing Requirement",Toast.LENGTH_LONG).show();
                    customModel = new CustomModel(-1,"error","error",0,"error");
                }

                /*customModel = new CustomModel(-1,name.getText().toString(),genre.getText().toString(),Integer.parseInt(year.getText().toString()));*/
                boolean success = dbHelper.addMovie(customModel);
                Toast.makeText(AddActivity.this, "Success= "+success, Toast.LENGTH_SHORT).show();
            }
        });
    }
}