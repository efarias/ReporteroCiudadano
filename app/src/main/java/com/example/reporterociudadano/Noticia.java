package com.example.reporterociudadano;

import android.location.Location;
import android.widget.ImageView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Noticia implements Serializable {

    private String titulo;
    private String nota;
    private String foto;
    private String fecha;
    private String ubicacion;
    private Usuario usuario;

    public Noticia(String titulo, String nota, String foto, String fecha, String ubicacion, Usuario usuario) {
        this.titulo = titulo;
        this.nota = nota;
        this.foto = foto;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.usuario = usuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "titulo='" + titulo + '\'' +
                ", fecha=" + fecha +
                ", usuario=" + usuario +
                '}';
    }

    /*
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
   // }*/
}
