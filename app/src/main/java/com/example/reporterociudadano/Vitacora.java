package com.example.reporterociudadano;

import java.io.Serializable;

public class Vitacora implements Serializable {
    private Noticia noticia;
    private Usuario usuario;

    public Vitacora(Noticia noticia, Usuario usuario) {
        this.noticia = noticia;
        this.usuario = usuario;
    }

    public Noticia getNoticia() {
        return noticia;
    }

    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}