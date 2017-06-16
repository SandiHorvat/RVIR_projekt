package com.rvir.projekt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lupusus on 23. 05. 2017.
 */

/**
 * Created by Lupusus on 23. 05. 2017.
 */

public class DatabaseHelper{

    private SQLiteDatabase db;
    public static final String DB_NAME = "GG.db";
    private final int DB_VERSION = 1;
    public static final String TABLE_NAME = "uporabnik";
    public final String TABELA_STOLPEC_ID = "id";
    public final String TABELA_STOLPEC_IME = "ime";
    public final String TABELA_STOLPEC_EMAIL= "email";
    public final String TABELA_STOLPEC_GESLO = "geslo";
    public final String TABELA_STOLPEC_SPOL = "spol";
    public final String TABELA_STOLPEC_STAROST = "starost";
    public final String TABELA_STOLPEC_VISINA = "visina";
    public final String TABELA_STOLPEC_TEZA = "teza";
    public final String TABELA_STOLPEC_KALORIJE = "kalorije";

    public static final String TABLE_FOOD = "seznam_hrana";

    // Contacts Table Columns names
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "ime";
    public static final String KEY_IMAGE = "slika";
    public static final String KEY_CALORIES = "kal";

    Context context;

    class DBmanager extends SQLiteOpenHelper{
        public DBmanager(Context context) {
            // super(context, name, factory, version);
            super(context, DB_NAME, null, DB_VERSION);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                //CREATE TABLE database_tabela ( id int primary key,tabela_stolpec_ena int,tabela_stolpec_dva text);
                String table="create table " + TABLE_NAME+ " ("
                        + TABELA_STOLPEC_ID + " integer primary key autoincrement,"
                        + TABELA_STOLPEC_IME + " text," + TABELA_STOLPEC_EMAIL + " text," + TABELA_STOLPEC_GESLO
                        + " text," + TABELA_STOLPEC_SPOL + " text," + TABELA_STOLPEC_STAROST + " text," + TABELA_STOLPEC_VISINA
                        + " text," + TABELA_STOLPEC_TEZA + " text," + TABELA_STOLPEC_KALORIJE+ " real)";

                db.execSQL(table);
                String table2 = "create table " + TABLE_FOOD + " ("
                        + KEY_ID + " integer primary key autoincrement," + KEY_NAME + " text,"
                        + KEY_IMAGE + " blob," + KEY_CALORIES + " integer)";
                db.execSQL(table2);
            } catch (SQLException e) {
                Log.e("DBHelper onCreate  ","Error creating table "+e.getMessage());
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table " + TABLE_NAME);
            db.execSQL("drop table " + TABLE_FOOD);
            this.onCreate(db);
        }

    }
    private  DBmanager dbManager; //obstaja naj le ena instanca baze

    public DatabaseHelper(Context context) {
        this.context=context;

    }

    public void close(){ //poskrbimo za zapiranje baze
        this.dbManager.close();
    }

    public void open(){

        try {
            this.dbManager = new DBmanager(context);
            db = this.dbManager.getWritableDatabase();
        } catch (SQLException e) {
            // TODO: handle exception
            Log.e("DBHelper ","Error openning db "+e.getMessage());
        }
    }



    public Boolean addRow(Uporabnik u){

        ContentValues initialValues = new ContentValues();
        initialValues.put(TABELA_STOLPEC_IME, u.getIme());
        initialValues.put(TABELA_STOLPEC_EMAIL,u.getEmail());
        initialValues.put(TABELA_STOLPEC_GESLO,u.getGeslo());
        initialValues.put(TABELA_STOLPEC_SPOL, u.getSpol());
        initialValues.put(TABELA_STOLPEC_STAROST,u.getStarost());
        initialValues.put(TABELA_STOLPEC_VISINA,u.getVisina());
        initialValues.put(TABELA_STOLPEC_TEZA, u.getTeza());
        initialValues.put(TABELA_STOLPEC_KALORIJE, u.getKalorije());

        return db.insert(TABLE_NAME,null, initialValues)>0;

    }

    public Cursor getAll() throws SQLException {
        String rawQueryString="SELECT " + TABELA_STOLPEC_IME + ","
                + TABELA_STOLPEC_EMAIL + "," + TABELA_STOLPEC_GESLO + "," + TABELA_STOLPEC_SPOL + " FROM " +TABLE_NAME;

        Cursor cursor=db.rawQuery(rawQueryString, null);


       /* if (cursor != null) {
            cursor.moveToFirst();
        } */

        return cursor;
    }



    public String searchPass(String uname){

        String query ="select email, geslo from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a,b;
        b="not found";
        if(cursor.moveToFirst()){
            do {
                a=cursor.getString(0);

                if(a.equals(uname)){
                    b=cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;
    }

    public Boolean addHrana(Hrana hrana) {


        ContentValues values = new ContentValues();
        values.put(KEY_NAME, hrana._name);
        values.put(KEY_IMAGE, hrana._image);
        values.put(KEY_CALORIES, hrana._calories);

// Inserting Row
        return db.insert(TABLE_FOOD,null,values)>0;


    }

    // Getting single contact
  /* Hrana getHrana(int id) {
         db = this.dbManager.getReadableDatabase();

        Cursor cursor = db.query(TABLE_HRANA, new String[] { KEY_ID,
                        KEY_NAME, KEY_IMAGE, KEY_CALORIES }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Hrana hrana = new Hrana(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getBlob(1), Integer.parseInt(cursor.getString(1)));

// return contact
        return hrana;

    }*/

    // Getting All Contacts
    public List<Hrana> getAllHrana() {
        List<Hrana> hranaList = new ArrayList<Hrana>();
// Select All Query
        String selectQuery = "SELECT * FROM seznam_hrana ORDER BY ime";

        Cursor cursor = db.rawQuery(selectQuery, null);
// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Hrana hrana = new Hrana();
                hrana.setId(Integer.parseInt(cursor.getString(0)));
                hrana.setName(cursor.getString(1));
                hrana.setImage(cursor.getBlob(2));
                hrana.setCalories(Integer.parseInt(cursor.getString(3)));
// Adding contact to list
                hranaList.add(hrana);
            } while (cursor.moveToNext());
        }
// close inserting data from database

// return contact list
        return hranaList;

    }

    // Updating single contact
    public int updateHrana(Hrana hrana) {


        ContentValues values = new ContentValues();
        values.put(KEY_NAME, hrana.getName());
        values.put(KEY_IMAGE, hrana.getImage());
        values.put(KEY_IMAGE, hrana.getCalories());

// updating row
        return db.update(TABLE_FOOD, values, KEY_ID + " = ?",
                new String[] { String.valueOf(hrana.getId()) });

    }

    public Cursor getHranaDescription(int id) {
         db = this.dbManager.getReadableDatabase();
        String[] selections = {String.valueOf(id)};
        String columns[] = {KEY_NAME, KEY_CALORIES};
        Cursor cursor = db.query(TABLE_FOOD, columns, KEY_ID + "=?",
                selections, null, null, null);
        //db.close();
        return cursor;
    }

    public Uporabnik getUporabnik(String email, String password) {
        Uporabnik u = new Uporabnik();

        Cursor c = null;
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + TABELA_STOLPEC_EMAIL  + " = '" + email + "' AND " + TABELA_STOLPEC_GESLO + " = '" + password + "'";
        c = db.rawQuery(query, null);
        if (c != null) {
            if (c.moveToFirst()) {
                u = new Uporabnik(c.getString(c.getColumnIndex("email")), c.getString(c.getColumnIndex("geslo")));
                u.setId(c.getInt(c.getColumnIndex("id")));
            }
        }
        c.close();
        db.close();
        return u;
    }



}
