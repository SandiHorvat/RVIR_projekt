package com.rvir.projekt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marko on 6/16/2017.
 */

public class JedilnikActivity extends AppCompatActivity {


    ArrayList<Hrana> imageArry = new ArrayList<Hrana>();
    ArrayList<Hrana> imageArry1 = new ArrayList<Hrana>();
    ArrayList<Hrana> imageArry2 = new ArrayList<Hrana>();
    ContactImageAdapter adapter;
    DatabaseHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jedilnik);

        dbhelper = new DatabaseHelper(this);
        dbhelper.open();



        List<Hrana> hrana = dbhelper.generate();
        for (Hrana hr : hrana) {
            String log = "ID:" + hr.getId() + " Name: " + hr.getName()
                    + " ,Image: " + hr.getImage() + " Calories:" + hr.getCalories() ;

// Writing Contacts to log
            Log.d("Result: ", log);
//add contacts data in arrayList
            imageArry.add(hr);

        }
                //startActivity(j);


        adapter = new ContactImageAdapter(this, R.layout.screen_list,
                imageArry);
        ListView dataList = (ListView) findViewById(R.id.list2);
        dataList.setAdapter(adapter);


        List<Hrana> hrana1 = dbhelper.generate1();
        for (Hrana hr : hrana1) {
            String log = "ID:" + hr.getId() + " Name: " + hr.getName()
                    + " ,Image: " + hr.getImage() + " Calories:" + hr.getCalories() ;

// Writing Contacts to log
            Log.d("Result: ", log);
//add contacts data in arrayList
            imageArry1.add(hr);

        }
        //startActivity(j);


        adapter = new ContactImageAdapter(this, R.layout.screen_list,
                imageArry1);
        ListView dataList1 = (ListView) findViewById(R.id.list3);
        dataList1.setAdapter(adapter);


        List<Hrana> hrana2 = dbhelper.generate2();
        for (Hrana hr : hrana2) {
            String log = "ID:" + hr.getId() + " Name: " + hr.getName()
                    + " ,Image: " + hr.getImage() + " Calories:" + hr.getCalories() ;

// Writing Contacts to log
            Log.d("Result: ", log);
//add contacts data in arrayList
            imageArry2.add(hr);

        }
        //startActivity(j);


        adapter = new ContactImageAdapter(this, R.layout.screen_list,
                imageArry2);
        ListView dataList2 = (ListView) findViewById(R.id.list4);
        dataList2.setAdapter(adapter);


    }
}
