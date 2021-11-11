package com.example.reporterociudadano;

import android.widget.ImageView;

import java.io.Serializable;
import java.util.ArrayList;

public class Noticia implements Serializable {

    private String titulo;
    private String nota;
    private String foto;
   //private ArrayList<Noticia> noticias;



    public Noticia(String titulo, String nota, String foto) {
        this.titulo = titulo;
        this.nota = nota;
        this.foto = foto;
        //noticias = new ArrayList<Noticia>();

    }
    public Noticia() {
        this.titulo = titulo;
        this.nota = nota;
        this.foto = foto;
        //noticias = new ArrayList<Noticia>();
    }


    public String getTitulo() {
        return titulo;
    }

    public String getNota() {
       return nota;
   }

    public String getFoto() {
        return foto;
    }

    // public ArrayList<Noticia> getNoticias() {
    //    return noticias;
   // }
}
