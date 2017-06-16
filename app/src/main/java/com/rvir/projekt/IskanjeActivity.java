package com.rvir.projekt;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marko on 6/16/2017.
 */

public class IskanjeActivity extends AppCompatActivity {
    ArrayList<Hrana> imageArry = new ArrayList<Hrana>();
    ContactImageAdapter adapter;
    SearchView searchView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iskanje);

        DatabaseHelper dbhelper = new DatabaseHelper(this);
        dbhelper.open();





// get image from drawable
        Bitmap image = BitmapFactory.decodeResource(getResources(),
                R.drawable.pizza);

        /*Bitmap image1 = BitmapFactory.decodeResource(getResources(),
                R.drawable.monkas);*/

// convert bitmap to byte
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        //image1.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte imageInByte[] = stream.toByteArray();
/**
 * CRUD Operations
 * */
// Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        //dbhelper.addHrana(new Hrana("Banana", imageInByte, 50));
        if(dbhelper.addHrana(new Hrana("pizza", imageInByte, 520))){
            Toast.makeText(this,"Uspešno", Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this,"Neuspešno", Toast.LENGTH_LONG).show();
        }

// display main List view bcard and contact name

// Reading all contacts from database
        List<Hrana> hrana = dbhelper.getAllHrana();
        for (Hrana hr : hrana) {
            String log = "ID:" + hr.getId() + " Name: " + hr.getName()
                    + " ,Image: " + hr.getImage() + " Calories:" + hr.getCalories() ;

// Writing Contacts to log
            Log.d("Result: ", log);
//add contacts data in arrayList
            imageArry.add(hr);

        }
        adapter = new ContactImageAdapter(this, R.layout.screen_list,
                imageArry);
        ListView dataList = (ListView) findViewById(R.id.list);
        dataList.setAdapter(adapter);


        Button isci = (Button) findViewById(R.id.button11);
       isci.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent j = new Intent(v.getContext(), IskanjeActivity.class);
                startActivity(j);
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        doSearchActivateSearch(menu);

        return true;
    }


    private void doSearchActivateSearch(Menu menu) {
        MenuItem searchItem = menu.findItem(R.id.search);
        searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        final SearchManager searchManager = (SearchManager)
                getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(
                new ComponentName(this, HranaSearch.class)));
        //searchView.setOnSuggestionListener(this);
        searchView.setIconifiedByDefault(false);
    }

}
