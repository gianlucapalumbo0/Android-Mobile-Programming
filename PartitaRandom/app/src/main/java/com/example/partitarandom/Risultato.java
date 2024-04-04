package com.example.partitarandom;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Risultato extends AppCompatActivity {
    public ListView listView;
    CustomAdapter customAdapter;
    String[] nomi = new String[3]; // Creiamo un array di dimensione 3
    Integer[] punteggio = new Integer[3]; // Creiamo un array di dimensione 3
    int size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.risultatolista);

        listView = (ListView)findViewById(R.id.mylistview);


        customAdapter = new CustomAdapter(getApplicationContext(), R.layout.list_element, new ArrayList<Player>());

        listView.setAdapter(customAdapter);

        Intent i = getIntent();
        size = i.getIntExtra("dimensione", 0);

        if(size == 1){
            nomi[0] = i.getStringExtra("nome0");
            punteggio[0] = i.getIntExtra("punteggio0", 0);
            customAdapter.add(new Player(nomi[0], punteggio[0]));
        }

        if(size == 2){
            nomi[0] = i.getStringExtra("nome0");
            punteggio[0] = i.getIntExtra("punteggio0", 0);
            nomi[1] = i.getStringExtra("nome1");
            punteggio[1] = i.getIntExtra("punteggio1", 0);
            customAdapter.add(new Player(nomi[0], punteggio[0]));
            customAdapter.add(new Player(nomi[1], punteggio[1]));
        }

        if(size >= 3){
            nomi[0] = i.getStringExtra("nome0");
            punteggio[0] = i.getIntExtra("punteggio0", 0);
            nomi[1] = i.getStringExtra("nome1");
            punteggio[1] = i.getIntExtra("punteggio1", 0);
            nomi[2] = i.getStringExtra("nome2");
            punteggio[2] = i.getIntExtra("punteggio2", 0);
            customAdapter.add(new Player(nomi[0], punteggio[0]));
            customAdapter.add(new Player(nomi[1], punteggio[1]));
            customAdapter.add(new Player(nomi[2], punteggio[2]));
        }

    }

    public void onClickTorna(View v) {
        onBackPressed();
    }
}
