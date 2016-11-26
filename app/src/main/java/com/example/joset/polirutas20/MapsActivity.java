package com.example.joset.polirutas20;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import utils.Regex;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback  {

    private GoogleMap mMap;
    Button aceptarMapsActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        aceptarMapsActivity = (Button) findViewById(R.id.AceptarMaps);

        aceptarMapsActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.addMarker(new MarkerOptions()
                        //-2.144601, -79.967687
                        .position(new LatLng(-2.144601, -79.967687))
                        .title("fiec nueva"));


            }
        });

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Espol and move the camera
        LatLng espol = new LatLng(-2.1474502, -79.9649583);
        mMap.addMarker(new MarkerOptions().position(espol).title("Marcador ESPOL"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(espol, 16));


        aceptarMapsActivity = (Button) findViewById(R.id.AceptarMaps);

        aceptarMapsActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.addMarker(new MarkerOptions()
                        //-2.144601, -79.967687
                        .position(new LatLng(-2.144601, -79.967687))
                        .title("fiec nueva"));


            }
        });
    }
}
