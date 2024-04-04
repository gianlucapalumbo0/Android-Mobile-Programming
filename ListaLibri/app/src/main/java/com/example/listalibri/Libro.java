package com.example.listalibri;

import android.graphics.drawable.Drawable;

public class Libro {
    private String Titolo;
    private String Autore;
    private Drawable Copertina;

    public Libro(String Titolo, String Autore, Drawable Copertina){
        this.Titolo = Titolo;
        this.Autore = Autore;
        this.Copertina = Copertina;
    }

    public String getTitolo() {
        return Titolo;
    }

    public String getAutore() {
        return Autore;
    }

    public Drawable getCopertina() {
        return Copertina;
    }
}
