package com.example.ricetteculinarie;

import android.graphics.drawable.Drawable;

public class Ricetta {
    private String nome;
    private String id;
    private Drawable picture;

    public Ricetta(String nome, String id, Drawable picture){
        this.nome = nome;
        this.id = id;
        this.picture = picture;
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    public Drawable getPicture() {
        return picture;
    }
}


