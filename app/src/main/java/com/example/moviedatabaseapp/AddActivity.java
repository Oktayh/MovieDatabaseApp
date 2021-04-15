package com.example.moviedatabaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.moviedatabaseapp.db.DBHelper;

public class AddActivity extends AppCompatActivity {
    EditText name,genre,year;
    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name = findViewById(R.id.name_movie);
        genre = findViewById(R.id.genre_movie);
        year = findViewById(R.id.year_movie);
        addBtn = findViewById(R.id.btn_add);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbHelper = new DBHelper(AddActivity.this);
                CustomModel customModel;

                customModel = new CustomModel(-1,name.getText().toString(),genre.getText().toString(),Integer.parseInt(year.getText().toString()));
                boolean success = dbHelper.addMovie(customModel);
                Toast.makeText(AddActivity.this, "Success= "+success, Toast.LENGTH_SHORT).show();
            }
        });
    }
}