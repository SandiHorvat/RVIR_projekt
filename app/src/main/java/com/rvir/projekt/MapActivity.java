package com.rvir.projekt;

import android.app.Dialog;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

/**
 * Created by Marko on 6/14/2017.
 */

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap mGoogleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        if(googleServicesAvailable()){
            Toast.makeText(this,"perfect",Toast.LENGTH_LONG).show();

            initMap();
        }else{

        }
    }

    private void initMap(){
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);

    }




    public boolean googleServicesAvailable(){
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int isAvailable = api.isGooglePlayServicesAvailable(this);
        if(isAvailable== ConnectionResult.SUCCESS){
            return true;
        }else if(api.isUserResolvableError(isAvailable)){
            Dialog dialog = api.getErrorDialog(this, isAvailable,0);
            dialog.show();
        }else{
            Toast.makeText(this,"cant connect", Toast.LENGTH_LONG).show();
        }
        return false;
    }



    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        goToLocation(46.553298, 15.646266,16);

        double latitude = 46.553968;
        double longitude = 15.653638;

        double latitude1 = 46.558293;
        double longitude1 = 15.647714;

        double latitude2 = 46.562141;
        double longitude2 = 15.635730;

        double latitude3 = 46.556877;
        double longitude3 = 15.645385;

        double latitude4 = 46.557836;
        double longitude4 = 15.642598;

        double latitude5 = 46.557829;
        double longitude5 = 15.644360;

        double latitude6 = 46.558052;
        double longitude6 = 15.640989;

// create marker
        MarkerOptions marker = new MarkerOptions().position(new LatLng(latitude, longitude)).title("Trgovina");
        MarkerOptions marker1 = new MarkerOptions().position(new LatLng(latitude1, longitude1)).title("Trgovina");
        MarkerOptions marker2 = new MarkerOptions().position(new LatLng(latitude2, longitude2)).title("Trgovina");
        MarkerOptions marker3 = new MarkerOptions().position(new LatLng(latitude3, longitude3)).title("Restavracija");
        MarkerOptions marker4 = new MarkerOptions().position(new LatLng(latitude4, longitude4)).title("Restavracija");
        MarkerOptions marker5 = new MarkerOptions().position(new LatLng(latitude5, longitude5)).title("Gostilna");
        MarkerOptions marker6 = new MarkerOptions().position(new LatLng(latitude6, longitude6)).title("Gostilna");

// Changing marker icon
        marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon));
        marker1.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon));
        marker2.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon));
        marker3.icon(BitmapDescriptorFactory.fromResource(R.drawable.restavracija));
        marker4.icon(BitmapDescriptorFactory.fromResource(R.drawable.restavracija));
        marker5.icon(BitmapDescriptorFactory.fromResource(R.drawable.restavracija));
        marker6.icon(BitmapDescriptorFactory.fromResource(R.drawable.restavracija));

// adding marker
        googleMap.addMarker(marker);
        googleMap.addMarker(marker1);
        googleMap.addMarker(marker2);
        googleMap.addMarker(marker3);
        googleMap.addMarker(marker4);
        googleMap.addMarker(marker5);
        googleMap.addMarker(marker6);

    }

    private void goToLocation(double lat, double lng, float zoom) {
        LatLng ll = new LatLng(lat,lng);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(ll,zoom);
        mGoogleMap.moveCamera(update);
    }

    public void geoLocate(View view) throws IOException {
        EditText et = (EditText) findViewById(R.id.editText7);
        String location = et.getText().toString();
        Geocoder gc = new Geocoder(this);
        List<Address> list = gc.getFromLocationName(location,1);
        Address address = list.get(0);
        String locality = address.getLocality();

        Toast.makeText(this,locality,Toast.LENGTH_LONG).show();

        double lat = address.getLatitude();
        double lng = address.getLongitude();
        goToLocation(lat,lng,15);

        MarkerOptions options = new MarkerOptions().position(new LatLng(lat,lng));
        mGoogleMap.addMarker(options);
    }

}
