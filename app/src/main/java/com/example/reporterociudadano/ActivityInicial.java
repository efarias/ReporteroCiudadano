package com.example.reporterociudadano;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class ActivityInicial extends AppCompatActivity {

    private ArrayList<Noticia> noticias;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Vitacora> vitacoras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);

        noticias = new ArrayList<Noticia>();
        usuarios = new ArrayList<Usuario>();
        Usuario usuario = new Usuario("test","test");
        usuarios.add(usuario);
        vitacoras = new ArrayList<Vitacora>();

    }

    public void EntrarPro(View view){
        Intent intento = new Intent(this, ActivityPrincipal.class);
        intento.putExtra("noticias", noticias);
        intento.putExtra("usuarios", usuarios);
        intento.putExtra("vitacoras", vitacoras);
        startActivity(intento);

    }
}