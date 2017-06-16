package com.rvir.projekt;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

                EditText emailValidate = (EditText)findViewById(R.id.mail);

                TextView textView = (TextView)findViewById(R.id.text);



                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                String email2 = emailValidate.getText().toString().trim();

                if(ime.getText().toString().trim().equals("")){
                    ime.setError("Vnesite ime!");
                }
                else if (geslo.getText().toString().trim().equals("")){
                    geslo.setError("Vnesite geslo.");
                }

               else if (email2.matches(emailPattern))
                {
                    Toast.makeText(getApplicationContext(),"valid email address",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(RegisterActivity.this, Osnov_podatkiActivity.class);
                    String name=ime.getText().toString();
                    String mail = email.getText().toString();
                    String pass = geslo.getText().toString();

                    intent.putExtra("ime", name);
                    intent.putExtra("email", mail);
                    intent.putExtra("geslo", pass);

                    startActivity(intent);

                }
                else
                {
                    emailValidate.setError("Vnesite pravilno obliko maila");
                    Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
                }



            }
        });




    }
}
