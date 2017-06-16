package com.rvir.projekt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Marko on 6/16/2017.
 */

public class JedilnikActivity extends AppCompatActivity {

    DatabaseHelper dbHandler;
    Uporabnik uporabnik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jedilnik);


    }
}
