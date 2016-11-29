package com.example.joset.polirutas20;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.realtime.internal.event.ObjectChangedDetails;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

import utils.Edificio;
import utils.Facultad;
import utils.Regex;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Button aceptarMapsActivity;
    EditText direccion;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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
        ;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(espol, 16));


        aceptarMapsActivity = (Button) findViewById(R.id.AceptarMaps);
        direccion = (EditText) findViewById(R.id.direccionID);


        aceptarMapsActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String direccionS = direccion.getText().toString();
                Context context = getApplicationContext();
                Object objeto = null;
                System.out.println("entraAqui1");

                try {
                    objeto = utils.txtParser.getEdificioOrFacultad(direccionS, context);
                } catch (IOException e) {
                    e.printStackTrace();
                }


/**
                LinkedList<String> lista = new LinkedList<String>();
                lista.add("fiec nueva");
                lista.add("vieja fiec");
                Edificio edificio = new Edificio("24A", lista, "#", -2.144601, -79.967687, -2.144784, -79.967230);
*/
                if (objeto == null){
                    AlertDialog.Builder a_builder = new AlertDialog.Builder(MapsActivity.this);
                    a_builder.setMessage("Su lugar no existe")
                            .setCancelable(false)
                            .setNeutralButton("OK",new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();

                                }
                            });

                    AlertDialog alert = a_builder.create();
                    alert.setTitle("Alerta!");
                    alert.show();

                }
                else if (objeto.getClass().toString().contains("Edificio")){
                    Edificio edificio = (Edificio) objeto;

                        mMap.clear();
                        mMap.addMarker(new MarkerOptions()
                                //-2.144601, -79.967687
                                .position(new LatLng(edificio.getRealLocation().getLatitud(), edificio.getRealLocation().getLongitud()))
                                .title(edificio.getName()));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(edificio.getRealLocation().getLatitud(), edificio.getRealLocation().getLongitud()), 18));


                }else {//if (objeto.getClass().toString().contains("Facultad")){
                    Facultad facultad = (Facultad) objeto;
                    LinkedList<LatLng> coordenadas = new LinkedList<>();
                    for (int i = 0 ; i < facultad.getCoordenadas().size(); i++){
                        coordenadas.add(new LatLng(facultad.getCoordenadas().get(i).getLatitud(),facultad.getCoordenadas().get(i).getLongitud()));
                    }
                    mMap.clear();
                    PolygonOptions rectOptions = new PolygonOptions()
                            .addAll(coordenadas)
                            .fillColor(Color.argb(120,181, 204, 242));

                    Polygon polygon = mMap.addPolygon(rectOptions);
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(facultad.getCentral().getLatitud(), facultad.getCentral().getLongitud()), 18));
                }
            }
        });
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Maps Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }



}
