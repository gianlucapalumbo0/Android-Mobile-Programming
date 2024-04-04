package com.example.elencoimmagini;

import android.graphics.drawable.Drawable;

public class Elemento {
    private String nome;
    private Drawable immagine;

    public Elemento (String nome, Drawable immagine){
        this.nome = nome;
        this.immagine = immagine;
    }

    public String getNome() {
        return nome;
    }

    public Drawable getImmagine() {
        return immagine;
    }
}
