package com.example.reporterociudadano;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ActivityPrincipal extends AppCompatActivity {

    private ArrayList<Usuario> usuarios;
    private EditText NombreUsuario;
    private EditText contrasennaUsuario;
    private ArrayList<Noticia> noticias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        usuarios = (ArrayList<Usuario>) getIntent().getSerializableExtra("usuarios");
        noticias = (ArrayList<Noticia>) getIntent().getSerializableExtra("noticias");
        NombreUsuario = findViewById(R.id.nombreUsuario);
        contrasennaUsuario = findViewById(R.id.contraseñaUsuario);
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println(usuarios.get(i).getNombreUsuario());
        }

    }


    public void IniciarSesion(View view) {

        for (int i=0;i<usuarios.size();i++){
            if (usuarios.get(i).getNombreUsuario().equals(NombreUsuario.getText().toString())){
                if (usuarios.get(i).getContrasenna().equals(contrasennaUsuario.getText().toString())){
                    Intent intento = new Intent(this, MainActivity.class);
                    intento.putExtra("noticias", noticias);
                    intento.putExtra("usuarios", usuarios);
                    startActivity(intento);
                }else {
                    Toast.makeText(this, "Usuario o contraseña es incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        }


    }
        public void Registrarse (View view){

        Intent intento = new Intent(this, ActivityRegistrarse.class);
        intento.putExtra("usuarios",usuarios);
        startActivity(intento);

        }
    }