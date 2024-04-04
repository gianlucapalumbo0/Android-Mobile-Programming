package com.example.partitarandom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {
    ImageView img1;
    ImageView img2;
    TextView risultato;
    EditText text_nomegioc;
    Random rand = new Random();
    ArrayList<Player> arrayStudenti = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        img1 = (ImageView) findViewById(R.id.dado1);
        img2 = (ImageView) findViewById(R.id.dado2);
        risultato = (TextView) findViewById(R.id.textresult);
        text_nomegioc = (EditText) findViewById(R.id.nomeplayer);

        /*prefs = getSharedPreferences("File",MODE_PRIVATE);*/





    }


    public void iniziopartita(View v) {
        String file = "animazione1";
        int totale;

        // Avvia l'animazione per le immagini
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), getResources().getIdentifier(file, "anim", getPackageName()));
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // Questo metodo viene chiamato quando l'animazione inizia
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // Questo metodo viene chiamato quando l'animazione finisce

                // Genera numeri casuali tra 1 e 6
                int num1 = rand.nextInt(6) + 1;
                int num2 = rand.nextInt(6) + 1;

                // Calcola il totale
                int totale = num1 + num2;

                // Aggiorna il TextView con il totale
                risultato.setText("" + totale);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // Questo metodo viene chiamato quando l'animazione si ripete (non utilizzato in questo esempio)
            }
        });

        // Avvia l'animazione per le immagini
        img1.startAnimation(animation);
        img2.startAnimation(animation);
    }


    public void finepartita(View v){

        String nome = text_nomegioc.getText().toString();
        int punteggio =  Integer.parseInt(risultato.getText().toString());

        arrayStudenti.add(new Player(nome, punteggio));
        Log.d("mannaggia", nome);
        Log.d("mannaggia", ""+ punteggio);
    }

    public void showresult(View v){

        Intent i = new Intent();
        i.setClass(getApplicationContext(), Risultato.class);
        int size = arrayStudenti.size();

        if(size == 1){
            i.putExtra("dimensione", size);
            i.putExtra("nome0", arrayStudenti.get(0).getName());
            i.putExtra("punteggio0", arrayStudenti.get(0).getPunteggio());
        }

        if(size == 2){
            ordinaArray();
            i.putExtra("dimensione", size);
            i.putExtra("nome0", arrayStudenti.get(0).getName());
            i.putExtra("punteggio0", arrayStudenti.get(0).getPunteggio());
            i.putExtra("nome1", arrayStudenti.get(1).getName());
            i.putExtra("punteggio1", arrayStudenti.get(1).getPunteggio());
        }

        if(size >= 3){
            ordinaArray();
            i.putExtra("dimensione", size);
            i.putExtra("nome0", arrayStudenti.get(0).getName());
            i.putExtra("punteggio0", arrayStudenti.get(0).getPunteggio());
            i.putExtra("nome1", arrayStudenti.get(1).getName());
            i.putExtra("punteggio1", arrayStudenti.get(1).getPunteggio());
            i.putExtra("nome2", arrayStudenti.get(2).getName());
            i.putExtra("punteggio2", arrayStudenti.get(2).getPunteggio());
        }

        startActivity(i);
    }

    private void ordinaArray(){
        Comparator<Player> comparatorePerPunteggio = new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                return p2.getPunteggio() - p1.getPunteggio(); // Inverti l'ordine del confronto
            }
        };

        // Ordinamento dell'ArrayList utilizzando il Comparator per il punteggio
        Collections.sort(arrayStudenti, comparatorePerPunteggio);
    }
}