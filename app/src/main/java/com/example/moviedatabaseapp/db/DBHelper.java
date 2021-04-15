package com.example.moviedatabaseapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.moviedatabaseapp.CustomModel;

public class DBHelper extends SQLiteOpenHelper {
    Context context;
    private static final String DATABASE_NAME = "MovieLibrary.db";
    private static final int VERSION = 1;
    private static final String TABLE_NAME = "personal_library";

    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_GENRE = "genre";
    private static final String COLUMN_YEAR = "year";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME + " TEXT," + COLUMN_GENRE + " TEXT," + COLUMN_YEAR + " INTEGER)";
        String query = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_NAME + " TEXT, " +
                COLUMN_GENRE + " TEXT, " +
                COLUMN_YEAR + " INTEGER);";
        db.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean addMovie(CustomModel customModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_NAME,customModel.getName());
        values.put(COLUMN_GENRE,customModel.getGenra());
        values.put(COLUMN_YEAR,customModel.getYear());


        long result = db.insert(TABLE_NAME,null, values);
        if(result == -1){return false;}
        else{return true;}

    }


}
