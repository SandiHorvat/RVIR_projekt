package com.rvir.projekt;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Osnov_podatkiActivity extends AppCompatActivity {
    Spinner spol = null;
    //String spol_selected;
    EditText starost = null;
    int starost_parse = 0;
    EditText visina = null;
    int visina_parse = 0;
    EditText teza = null;
    double teza_parse = 0;
    String[] izbSpol;
    /*String starost_str;
    String visina_str;
    String teza_str;*/
   /* double male_calories = 0;
    double female_calories = 0;*/

    DatabaseHelper mydb;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_osnov_podatki);

        mydb = new DatabaseHelper(this);
        mydb.open();

        spol= (Spinner) findViewById(R.id.spinner);



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spol, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spol.setAdapter(adapter);



        Button btn_naprej = (Button) findViewById(R.id.button4);
        btn_naprej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                //izbran spol shranimo v string da ga potem uporabimo za izbiro za formulo izračuna kalorij
                String spol_selected = spol.getSelectedItem().toString();
                Log.d("KALORIJE====spol=", spol_selected.toString());

                //shranimo v spremenljivke vrednosti iz edittexta
                starost = (EditText)findViewById(R.id.etStarost);
                visina = (EditText)findViewById(R.id.etVisina);
                teza = (EditText)findViewById(R.id.etTeza);

                if(starost.getText().toString().trim().equals("")){
                    starost.setError("Morate vnesti starost.");
                }
                else if (visina.getText().toString().trim().equals("")){
                    visina.setError("Morate vnesti višino.");
                }
                else if (teza.getText().toString().trim().equals("")){
                    teza.setError("Morate vnesti težo.");
                }
                else{




                    //shranimo vrednosti v String iz doblkjenih vrednosti
                    String starost_str = starost.getText().toString();
                    String visina_str = visina.getText().toString();
                    String teza_str = teza.getText().toString();

                    //parsamo string vrednosti v int/double
                    starost_parse = Integer.parseInt(starost_str);
                    visina_parse = Integer.parseInt(visina_str);
                    teza_parse = Integer.parseInt(teza_str);


                    //izračun kalorij za moškega
                    double male_calories = 10*teza_parse + 6.25*visina_parse - 5*starost_parse - 161;

                    //izračun kalorij za žensko
                    double female_calories = 10*teza_parse + 6.25*visina_parse - 5*starost_parse + 5;






                    Intent k = new Intent(Osnov_podatkiActivity.this, Izracun.class);
                    final String ime = getIntent().getStringExtra("ime");
                    final String email = getIntent().getStringExtra("email");
                    final String geslo = getIntent().getStringExtra("geslo");
                    Log.d("KALORIJE========", starost_str.toString());
                    Log.d("KALORIJE========", visina_str.toString());
                    Log.d("KALORIJE========", teza_str.toString());
                    Log.d("KALORIJE========teza", String.valueOf(teza_parse));
                    Log.d("KALORIJE========visina", String.valueOf(visina_parse));
                    Log.d("KALORIJE========starost", String.valueOf(starost_parse));
                    if(spol_selected=="moški"){
                        k.putExtra("kalorije", String.valueOf(male_calories));
                        Log.d("kalorije_moski", String.valueOf(male_calories));
                        Insert(ime,email,geslo,spol_selected,starost_str,visina_str,teza_str,male_calories);
                    }
                    else{
                        k.putExtra("kalorije", String.valueOf(female_calories));
                        Log.d("kalorijezenska", String.valueOf(female_calories));
                        Insert(ime,email,geslo,spol_selected,starost_str,visina_str,teza_str,female_calories);
                    }

                    startActivity(k);
                }
            }});


    }

    public void Insert(String ime, String email, String geslo, String spol, String starost, String visina, String teza, double kalorije) {
        Boolean insert = mydb.addRow(ime, email, geslo, spol, starost, visina, teza, kalorije);

        if(insert){
            Toast.makeText(this,"success", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"failure", Toast.LENGTH_SHORT).show();
        }



    }
}
