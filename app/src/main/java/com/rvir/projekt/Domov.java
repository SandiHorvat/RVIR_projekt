package com.rvir.projekt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Domov extends AppCompatActivity {

    private TextView mTextMessage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domov);

        Button iskanje = (Button) findViewById(R.id.button17);
        iskanje.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent j = new Intent(v.getContext(), IskanjeActivity.class);
                startActivity(j);
            }
        });

        Button priljubljene = (Button) findViewById(R.id.button18);
        priljubljene.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent j = new Intent(v.getContext(), PriljubljeniActivity.class);
                startActivity(j);
            }
        });

        Button jedilnik = (Button) findViewById(R.id.button20);
        jedilnik.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent j = new Intent(v.getContext(), JedilnikActivity.class);
                startActivity(j);
            }
        });

        //Button maps = (Button) findViewById(R.id.button11);
        //maps.setOnClickListener(new View.OnClickListener(){
           // @Override
          //  public void onClick(View v){
         //       Intent j = new Intent(v.getContext(), MapActivity.class);
         //       startActivity(j);
        //    }
       // });



    }

}
