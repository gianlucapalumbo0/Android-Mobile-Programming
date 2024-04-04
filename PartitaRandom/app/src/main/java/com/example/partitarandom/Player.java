package com.example.partitarandom;


public class Player {
    private String name;
    private int punteggio;

    public Player(String name, int punteggio) {
        this.name = name;
        this.punteggio = punteggio;
    }

    public String  getName() {
        return name;
    }

    public int getPunteggio() {
        return punteggio;
    }
}
