package com.example.doppiotris;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

//classe del singolo fragment

/**
 * A simple {@link Fragment} subclass.
 */
public class Tris extends Fragment implements View.OnClickListener {
    String simbolo;
    String altrosimbolo;
    Tris altroTris;
    View v;

    boolean attiva;
    Context c;

    public Tris(String s, String as, Context c) {
        simbolo = s;
        altrosimbolo = as;
        attiva = false;
        this.c = c;
    }

    public void setAttiva(boolean mode) {
        attiva = mode;
    }

    public void setAltrosimbolo(Tris at) {
        altroTris = at;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //assegno dinamicamente onClick ai pulsanti
        v = inflater.inflate(R.layout.tris, container, false);
        ArrayList<View> allButtons;
        allButtons = (v.findViewById(R.id.trisTable)).getTouchables();

        int i = 1;

        for (View element : allButtons) {
            Button b = (Button) element;
            b.setOnClickListener(this);
            b.setId(i); //setto gli id per i 9 pulsanti
            i++;
        }
        return v;
    }

    public void onClick(View v) {
        if (attiva) {
            Button b = (Button) v;

            if (b.getText().toString().length() == 0) {
                b.setText(simbolo); //quando clicco se simbolo è X esce X.
                //quando clicco un pulsante in un fragment, il simbolo deve essere aggiunto anche nell'altro fragment
                int id = b.getId();
                altroTris.mossaAltroTris(id);
            }

            attiva = false;
            altroTris.setAttiva(true);
            if (controllaVittoria()){
                Toast.makeText(c, "VITTORIA! " + simbolo + " !!", Toast.LENGTH_SHORT).show();
            }
        }


    }

    public void mossaAltroTris(int id) {
        Button b = v.findViewById(id);
        b.setText(altrosimbolo);
    }

    public void reset() {
        for (int id = 1; id <= 9; id++) {
            Button b = v.findViewById(id);
            b.setText("");
        }
    }

    private boolean controllaVittoria() {

        //utilizzo una matrice bidimensionale
        int [][] indici = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {1,4,7},
                {2,5,8},
                {3,6,9},
                {1,5,9},
                {3,5,7},
        };

        boolean risposta = false;

        for(int j = 0; j < 8; j++){
            boolean flag = true;
            for (int i = 1; i <= 2; i++) {
                Button b = v.findViewById(indici[j][i]);

                if(b.getText().toString().equals(simbolo) == false){
                    flag = false;
                }
            }
            if(flag) return true;
        }
        return false;
    }


}
