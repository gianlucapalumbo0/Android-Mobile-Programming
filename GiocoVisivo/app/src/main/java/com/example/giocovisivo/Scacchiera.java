package com.example.giocovisivo;

import static androidx.core.os.TraceCompat.setCounter;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

//classe del singolo fragment

/**
 * A simple {@link Fragment} subclass.
 */
public class Scacchiera extends Fragment implements View.OnClickListener {
    TextView tv;
    View v;
    Context c;
    int array[] = {1,3,2,4,2,1,3,5,5,6,7,8,7,4,8,6};
    ArrayList<Integer> cliccato = new ArrayList<>();
    int counter = 0;

    public Scacchiera(Context c) {
        this.c = c;
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        //assegno dinamicamente onClick ai pulsanti
        v = inflater.inflate(R.layout.scacchiera, container, false);
        ArrayList<View> allButtons;
        allButtons = (v.findViewById(R.id.trisScacchiera)).getTouchables();

        tv = v.findViewById(R.id.tentativi);
        tv.setText("Tentativo n: " + counter);

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
        int id = b.getId();
        cliccato.add(id);


        controllaclick();
        ckeck_completata();
        counter ++;

        tv.setText("Tentativo n: " + counter);

    }

    private void controllaclick(){
        Button b1;
        Button b2;
        Button b3;


        if(cliccato.size() == 1){
            b1 = v.findViewById(cliccato.get(0));
            b1.setText(" "+  array[b1.getId()]);
        }

        if(cliccato.size() == 2){
            b2 = v.findViewById(cliccato.get(0));
            b3 = v.findViewById(cliccato.get(1));

            b2.setText("" + array[b2.getId()]);
            b3.setText("" + array[b3.getId()]);

            if(cliccato.get(0) == cliccato.get(1)){
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Questo codice verrà eseguito dopo un ritardo
                        b2.setText(""); // Imposta il testo del bottone a vuoto
                        b3.setText("");
                    }
                }, 2000); // 2000 millisecondi (2 secondi) di ritardo, puoi modificare questo valore secondo le tue esigenze

                cliccato.remove(1);
                cliccato.remove(0);
            }

            else if(cliccato.get(0) != cliccato.get(1) && array[b2.getId()] == array[b3.getId()]){
                cliccato.remove(1);
                cliccato.remove(0);
            }

            else if(cliccato.get(0) != cliccato.get(1) && array[b2.getId()] != array[b3.getId()]){
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Questo codice verrà eseguito dopo un ritardo
                        b2.setText(""); // Imposta il testo del bottone a vuoto
                        b3.setText("");
                    }
                }, 2000); // 2000 millisecondi (2 secondi) di ritardo, puoi modificare questo valore secondo le tue esigenze

                cliccato.remove(1);
                cliccato.remove(0);
            }


        }
    }


    private void ckeck_completata(){
        Button b1;
        boolean flag = false;

        for(int i = 0; i < array.length; i++){
            b1 = v.findViewById(i);

            if(b1.getText() == ""){
                flag = true;
            }
        }

        if(flag == false){
            Toast.makeText(c.getApplicationContext(), "Partita conclusa", Toast.LENGTH_SHORT).show();
        }
    }


    public void reset() {
        for (int id = 0; id < 16; id++) {
            Button b = v.findViewById(id);
            b.setText("");
            counter = 0;
            tv.setText("Tentativo n: " + counter);
        }
    }





}

