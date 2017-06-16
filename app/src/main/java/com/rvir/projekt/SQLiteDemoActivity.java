package com.rvir.projekt;

/**
 * Created by Marko on 6/15/2017.
 */

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SQLiteDemoActivity extends Activity {
    ArrayList<Hrana> imageArry = new ArrayList<Hrana>();
    ContactImageAdapter adapter;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iskanje);

        DatabaseHelper dbhelper = new DatabaseHelper(this);
        dbhelper.open();




// get image from drawable
       Bitmap image = BitmapFactory.decodeResource(getResources(),
                R.drawable.kanelonicic);

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
        dbhelper.addHrana(new Hrana("Kaneloni", imageInByte, 600));

       // db.addContact(new Contact("monkaS", imageInByte));*/
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
    }
}





