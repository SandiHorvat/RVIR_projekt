package com.rvir.projekt;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Marko on 6/16/2017.
 */

public class HranaSearch extends AppCompatActivity{

    TextView textName, textAge;
    DatabaseHelper myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_food);

        textName = (TextView) findViewById(R.id.textName);
        textAge = (TextView) findViewById(R.id.textAge);

        int id = getIntent().getExtras().getInt("id");
        myDatabase = new DatabaseHelper(this);
        myDatabase.open();

        showEmployeesDescription(id);

    }

    private void showEmployeesDescription(int id) {

        int kalorije=0;
        String name = "";

        Cursor cursor = myDatabase.getHranaDescription(id + 1);
        if (cursor.getCount() < 1) {
            kalorije += 0;
            name += "No Data Available";

        } else {
            cursor.moveToFirst();
            do {
                kalorije = cursor.getInt(cursor.getColumnIndex(myDatabase.KEY_CALORIES));
                name = cursor.getString(cursor.getColumnIndex(myDatabase.KEY_NAME));
            }
            while (cursor.moveToNext());
        }
        // set Name
        textName.setText(name);
        //set Age
        textAge.setText(kalorije);
    }

}
