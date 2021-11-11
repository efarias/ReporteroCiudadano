package com.example.reporterociudadano;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ActivityListaDeNoticias extends AppCompatActivity {

    private ArrayList<Noticia> noticias;
    private RecyclerView recycler;
    private AdaptadorNoticia adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_noticias);

        noticias = (ArrayList<Noticia>) getIntent().getSerializableExtra("noticias");
        recycler = findViewById(R.id.recyclerListaNoticias);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        adaptador = new AdaptadorNoticia(noticias);

        recycler.setAdapter(adaptador);

    }
}