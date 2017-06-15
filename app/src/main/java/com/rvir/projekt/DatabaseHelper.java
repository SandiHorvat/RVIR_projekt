package com.rvir.projekt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Lupusus on 23. 05. 2017.
 */

/**
 * Created by Lupusus on 23. 05. 2017.
 */

public class DatabaseHelper{

    private SQLiteDatabase db;
    public static final String DB_NAME = "Prehrana.db";
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
                /*String table2 = "create table " + TABELA_IME2 + " ("
                        + TABELA_STOLPEC_IDH + " integer primary key autoincrement,"
                        + TABELA_STOLPEC_IMEH + " text," + TABELA_STOLPEC_SLIKA + " blob," + TABELA_STOLPEC_KALORIJE
                        + " text," + TABELA_STOLPEC_FAV  + " integer default 0)";
                db.execSQL(table2);*/
            } catch (SQLException e) {
                Log.e("DBHelper onCreate  ","Error creating table "+e.getMessage());
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table " + TABLE_NAME);
            //db.execSQL("drop table " + TABELA_IME2);
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

    /*public Boolean addRow(String stolpec_ena,String stolpec_dva,String stolpec_tri,String stolpec_stiri,String stolpec_pet,String stolpec_sest,String stolpec_sedem, double stolpec_osem){

        ContentValues initialValues = new ContentValues();
        initialValues.put(TABELA_STOLPEC_IME, stolpec_ena);
        initialValues.put(TABELA_STOLPEC_EMAIL,stolpec_dva);
        initialValues.put(TABELA_STOLPEC_GESLO,stolpec_tri);
        initialValues.put(TABELA_STOLPEC_SPOL, stolpec_stiri);
        initialValues.put(TABELA_STOLPEC_STAROST,stolpec_pet);
        initialValues.put(TABELA_STOLPEC_VISINA,stolpec_sest);
        initialValues.put(TABELA_STOLPEC_TEZA, stolpec_sedem);
        initialValues.put(TABELA_STOLPEC_KALORIJE, stolpec_osem);


        return db.insert(TABLE_NAME,null, initialValues)>0;

    }*/

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

   /* public boolean insertImg(String name,  byte[] image, String calories, int fav){

        /*String sql = "INSERT INTO FOOD VALUES (NULL, ?, ?, ?, ?)";

        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, name);
        statement.bindBlob(2, image);
        statement.bindString(3, calories);
        statement.bindDouble(4, fav);

        statement.executeInsert();*/
       /* ContentValues initialValues = new ContentValues();
        initialValues.put(TABELA_STOLPEC_IMEH, name);
        initialValues.put(TABELA_STOLPEC_SLIKA,image);
        initialValues.put(TABELA_STOLPEC_KALORIJE,calories);
        initialValues.put(TABELA_STOLPEC_FAV, fav);


        return db.insert(TABELA_IME2,null, initialValues)>0;

    }*/



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
}
