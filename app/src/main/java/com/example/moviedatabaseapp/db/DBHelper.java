package com.example.moviedatabaseapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.Nullable;

import com.example.moviedatabaseapp.CustomAdapter;
import com.example.moviedatabaseapp.CustomModel;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    Context context;
    private static final String DATABASE_NAME = "MovieLibrary.db";
    private static final int VERSION = 1;
    private static final String TABLE_NAME = "personal_library";

    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_GENRE = "genre";
    private static final String COLUMN_YEAR = "year";
    private static final String COLUMN_STATUS = "status";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT," + COLUMN_GENRE + " TEXT," + COLUMN_YEAR + " INTEGER," + COLUMN_STATUS + " TEXT)";
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
        values.put(COLUMN_STATUS,customModel.getStatus());


        long result = db.insert(TABLE_NAME,null, values);
        if(result == -1){return false;}
        else{return true;}

    }

    public List<CustomModel> getMovie(){
        List<CustomModel> cModel = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if (cursor.moveToFirst()){
            while (cursor.moveToNext()){
                int movieID = cursor.getInt(0);
                String movieName = cursor.getString(1);
                String movieGenre = cursor.getString(2);
                int movieYear = cursor.getInt(3);
                String movieStatus = cursor.getString(4);
                CustomModel newModel = new CustomModel(movieID,movieName,movieGenre,movieYear,movieStatus);
                cModel.add(newModel);
            }

        }else{}

        cursor.close();
        db.close();
        return cModel;

}

    public void updateMovie(String mId, String mName, String mGenre, String mYear, String mStatus) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_NAME,mName);
        values.put(COLUMN_GENRE,mGenre);
        values.put(COLUMN_YEAR,mYear);
        values.put(COLUMN_STATUS,mStatus);

        long result = db.update(TABLE_NAME, values, "name=?", new String[]{mId});
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }


    }
}
