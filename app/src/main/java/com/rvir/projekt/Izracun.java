package com.rvir.projekt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Izracun extends AppCompatActivity {

    EditText kalorije;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_izracun);

        String kalo = getIntent().getStringExtra("kalorije");
        Log.d("KALORIJE========", kalo.toString());

        kalorije = (EditText)findViewById(R.id.etKalorije);

        kalorije.setText(kalo);


        Button btn_koncaj = (Button) findViewById(R.id.button8);
        btn_koncaj.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(v.getContext(), Domov.class);
                startActivity(i);
            }
        });

    }
}
