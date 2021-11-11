package com.example.reporterociudadano;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class ActivityPrincipal extends AppCompatActivity {

    private ArrayList<Noticia> noticias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        noticias = new ArrayList<Noticia>();

    }

    public void EntrarPro(View view){
        Intent intento = new Intent(this, MainActivity.class);
        intento.putExtra("noticias", noticias);
        startActivity(intento);

    }
}