package com.rvir.projekt;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.app.Fragment;

public class Domov extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_domov:
                    DomovFragment d = new DomovFragment();
                    getFragmentManager().beginTransaction().replace(R.id.frame, d).commit();
                    //mTextMessage.setText(R.string.title_domov);
                    return true;
                case R.id.navigation_jedilnik:
                    JedilnikFragment j = new JedilnikFragment();
                    getFragmentManager().beginTransaction().replace(R.id.frame, j).commit();
                    //mTextMessage.setText(R.string.title_jedilnik);
                    return true;
                case R.id.navigation_hrana:
                    HranaFragment h = new HranaFragment();
                    getFragmentManager().beginTransaction().replace(R.id.frame, h).commit();
                    //mTextMessage.setText(R.string.title_hrana);
                    return true;
                case R.id.navigation_iskanje:
                    IskanjeFragment i = new IskanjeFragment();
                    getFragmentManager().beginTransaction().replace(R.id.frame, i).commit();
                    //mTextMessage.setText(R.string.title_search);
                    return true;
                case R.id.navigation_priljub:
                    PriljubljeniFragment p = new PriljubljeniFragment();
                    getFragmentManager().beginTransaction().replace(R.id.frame, p).commit();
                    //mTextMessage.setText(R.string.title_favourite);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domov);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
