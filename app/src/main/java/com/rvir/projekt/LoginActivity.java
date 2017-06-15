package com.rvir.projekt;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;



/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity  {

    DatabaseHelper dbhelper;
    SQLiteDatabase db;
    Cursor cursor;

    LoginButton loginButton;
    CallbackManager callbackManager;

    EditText et1, et2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login);


        Button btn_prijava = (Button) findViewById(R.id.email_sign_in_button);

        dbhelper = new DatabaseHelper(this);
        dbhelper.open();

        loginButton = (LoginButton) findViewById(R.id.login_button);
        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {


            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });


        btn_prijava.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                et1 = (EditText) findViewById(R.id.email);
                et2 = (EditText) findViewById(R.id.password);

                String username = et1.getText().toString();
                String password = et2.getText().toString();

                String koda = dbhelper.searchPass(username);
                if(password.equals(koda)){
                    Intent j = new Intent(v.getContext(), Domov.class);
                    startActivity(j);
                }else {
                    Toast temp = Toast.makeText(LoginActivity.this, "Napacno uporabnisko ime ali geslo!", Toast.LENGTH_SHORT);
                    temp.show();
                }


            }


        });



    }

    public void onActivityResult (int requestCode, int resultCode, Intent data){
        callbackManager.onActivityResult(requestCode,resultCode,data);
        data = new Intent(LoginActivity.this, Domov.class);
        startActivity(data);
    }
}

