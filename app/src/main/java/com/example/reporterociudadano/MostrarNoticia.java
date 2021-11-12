package com.example.reporterociudadano;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class MostrarNoticia extends AppCompatActivity {

    private Noticia noticia;
    private TextView titulo;
    private TextView fecha;
    private TextView nota;
    private ImageView foto;
    private String ubicacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_noticia);

          noticia = (Noticia) getIntent().getSerializableExtra("noticia");
          titulo = findViewById(R.id.MostrarTituloNoticia);
          fecha = findViewById(R.id.tvFechaMostrar);
          nota = findViewById(R.id.MostrarTextoNoticia);
          foto = findViewById(R.id.MostrarFotoNoticia);
          ubicacion = noticia.getUbicacion();

        titulo.setText(noticia.getTitulo());
        fecha.setText(noticia.getFecha());
        nota.setText(noticia.getNota());


        File imagenFile = new File(noticia.getFoto());
        if(imagenFile.exists()){
            Bitmap imgBitmap = BitmapFactory.decodeFile(imagenFile.getAbsolutePath());
            foto.setImageBitmap(imgBitmap);
        }



    }

    public void MostrarMapa(View view) {
        Intent intent = new Intent(this,MapsActivity.class);
        intent.putExtra("ubicacion", ubicacion);
        startActivity(intent);
    }
}