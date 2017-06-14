package com.rvir.projekt;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    private DatabaseHelper mydb;
    private SQLiteDatabase db;

    TextView ime = null;
    TextView email = null;
    TextView geslo = null;
    ArrayList poljeOseb = new ArrayList();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mydb = new DatabaseHelper(this);
        mydb.open();

        ime = (TextView)findViewById(R.id.name);
        email = (TextView)findViewById(R.id.mail);
        geslo = (TextView)findViewById(R.id.pass);

        Button naprej = (Button) findViewById(R.id.button3);
        naprej.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(RegisterActivity.this, Osnov_podatkiActivity.class);
                String name=ime.getText().toString();
                String mail = email.getText().toString();
                String pass = geslo.getText().toString();

                intent.putExtra("ime", name);
                intent.putExtra("email", mail);
                intent.putExtra("geslo", pass);

                startActivity(intent);

            }
        });




    }
}
