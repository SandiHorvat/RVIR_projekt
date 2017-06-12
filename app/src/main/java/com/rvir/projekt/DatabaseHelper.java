package com.rvir.projekt;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Lupusus on 23. 05. 2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Prehrana.db";
    public static final String TABLE_NAME = "uporabnik";
    public static String ID;
    public static String Ime;
    public static String Uporabnisko;
    public static String Starost;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, IME TEXT, UPORABNISKO TEXT, STAROST INT)");
        onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists" +TABLE_NAME);
    }

    public boolean insetData(String ime, String uporabnisko, String starost){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues( );
        contentValues.put(Ime, ime);
        contentValues.put(Uporabnisko, uporabnisko);
        contentValues.put(Starost, starost);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1){
            return false;

        }
        else {
            return true;
        }
    }
}
