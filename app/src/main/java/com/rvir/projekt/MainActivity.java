package com.rvir.projekt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button gumb_prijava = (Button) findViewById(R.id.button1);
        gumb_prijava.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(v.getContext(), LoginActivity.class);
                startActivity(i);
            }
        });

        Button btn_naprej = (Button) findViewById(R.id.button2);
        btn_naprej.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent j = new Intent(v.getContext(), RegisterActivity.class);
                startActivity(j);
            }
        });


    }
}
