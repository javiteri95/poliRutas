package com.example.joset.polirutas20;



import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import utils.Regex;

public class Login extends AppCompatActivity {

    Button inicio;
    EditText usuario;
    EditText password;
    TextView olvido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inicio = (Button) findViewById(R.id.boton_iniciar_sesion);
        usuario= (EditText) findViewById(R.id.input_usuario);
        password =(EditText) findViewById(R.id.input_contrasena);
        olvido = (TextView) findViewById(R.id.texto_olvidaste_contrasena);

        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, MainActivity.class);

                if(Regex.testUser(usuario.getText().toString()) && Regex.testPassword(password.getText().toString())){ //condicionRegex
                   startActivity(intent);
                }else{
                    int duration = Toast.LENGTH_SHORT;
                    Context context = getApplicationContext();
                    CharSequence text = "algo salio mal :(";
                    Toast toast = Toast.makeText(context,text,duration);
                    toast.show();

                }



            }
        });

        olvido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int duration = Toast.LENGTH_SHORT;
                Context context = getApplicationContext();
                CharSequence text = "lo sentimos mucho :(";
                Toast toast = Toast.makeText(context,text,duration);
                toast.show();
            }
        });

    }
}
