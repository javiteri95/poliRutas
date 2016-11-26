package com.example.joset.polirutas20;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button mostrarLugares;
    Button mostrarRutas;
    Button cerrarSesion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mostrarLugares = (Button)findViewById(R.id.botonMostrarLugares);
        mostrarRutas = (Button)findViewById(R.id.botonMostrarRutas);
        cerrarSesion = (Button)findViewById(R.id.cerrarSesion);

        mostrarLugares.setOnClickListener(this);
        mostrarRutas.setOnClickListener(this);
        cerrarSesion.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.botonMostrarLugares):
                Intent intend1 = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intend1);
                break;
            case (R.id.botonMostrarRutas):
                Intent intend2 = new Intent(MainActivity.this, RoutesActivity.class);
                startActivity(intend2);
                break;
            case (R.id.cerrarSesion):
                AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
                a_builder.setMessage("Quiere cerrar sesion?")
                        .setCancelable(false)
                        .setPositiveButton("Si",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intend3 = new Intent(MainActivity.this, Login.class);
                                startActivity(intend3);
                            }
                        })
                        .setNegativeButton("No",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();

                            }
                        }) ;
                AlertDialog alert = a_builder.create();
                alert.setTitle("Alerta!");
                alert.show();
                break;




        }
    }
}
