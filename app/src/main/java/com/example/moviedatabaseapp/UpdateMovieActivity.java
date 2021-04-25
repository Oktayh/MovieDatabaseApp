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

public class UpdateMovieActivity extends AppCompatActivity {

    EditText name,genre,year;
    RadioGroup statusRadioGroup;
    RadioButton statusChecked;
    Button updateBtn,deleteBtn;
    String mName,mGenre,mYear,mId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_movie);

        statusRadioGroup = findViewById(R.id.radioGroup);
        name = findViewById(R.id.name_movie_u);
        genre = findViewById(R.id.genre_movie_u);
        year = findViewById(R.id.year_movie_u);
        updateBtn = findViewById(R.id.btn_update_u);
        deleteBtn = findViewById(R.id.btn_delete_u);

        if (getIntent().hasExtra("id_movie") && getIntent().hasExtra("name_movie") && getIntent().hasExtra("movie_genre") &&
                getIntent().hasExtra("movie_year") && getIntent().hasExtra("movie_status"))
        {
            mId = getIntent().getStringExtra("id_movie");
            mName = getIntent().getStringExtra("name_movie");
            mGenre = getIntent().getStringExtra("movie_genre");
            mYear = getIntent().getStringExtra("movie_year");

            name.setText(mName);
            genre.setText(mGenre);
            year.setText(mYear);
        }
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBHelper db = new DBHelper(UpdateMovieActivity.this);
                mName = name.getText().toString().trim();
                mGenre = genre.getText().toString().trim();
                mYear = year.getText().toString().trim();
                int selectedID = statusRadioGroup.getCheckedRadioButtonId();
                statusChecked = findViewById(selectedID);
                String mStatus = statusChecked.getText().toString();
                db.updateMovie(mId,mName,mGenre,mYear,mStatus);


            }
        });
    }
}