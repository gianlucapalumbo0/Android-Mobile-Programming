package com.example.campominato;


import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class Campo extends Fragment implements View.OnClickListener {

    int array[] = {1,1,1,0,1,10,1,0,2,3,3,2,10,2,10,10};
    Boolean perso = false;


    View v;

    boolean attiva;
    Context c;

    public Campo(Context c) {
        this.c = c;
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //assegno dinamicamente onClick ai pulsanti
        v = inflater.inflate(R.layout.campo, container, false);
        ArrayList<View> allButtons;
        allButtons = (v.findViewById(R.id.campoTable)).getTouchables();

        int i = 0;

        for (View element : allButtons) {
            Button b = (Button) element;
            b.setOnClickListener(this);
            b.setId(i); //setto gli id per i 9 pulsanti
            i++;
        }
        return v;
    }

    public void onClick(View v) {

            Button b = (Button) v;
            if(perso == false){
                if(array[b.getId()] == 10){
                    b.setBackgroundResource(R.drawable.bomba);

                    Toast.makeText(c.getApplicationContext(), "Partita terminata", Toast.LENGTH_SHORT).show();
                    perso = true;

                }

                else{
                    b.setText(" "+ array[b.getId()]);
                }
            }
    }


    public void reset() {
        for (int id = 0; id < 16; id++) {
            Button b = v.findViewById(id);

            if(array[b.getId()] == 10){
                b.setBackground(null); // Rimuovi l'immagine di sfondo
                b.setBackgroundResource(R.drawable.custom_pulsanti);
            }
            else{
                b.setText("");
            }
        }
        perso = false;
    }

    public void mostra() {
        for (int id = 0; id < 16; id++) {
            Button b = v.findViewById(id);

            if(array[b.getId()] == 10){
                b.setBackgroundResource(R.drawable.bomba);

                Toast.makeText(c.getApplicationContext(), "Partita terminata", Toast.LENGTH_SHORT).show();
            }

            else{
                b.setText(" "+ array[b.getId()]);
            }
        }
        perso = true;
    }


}