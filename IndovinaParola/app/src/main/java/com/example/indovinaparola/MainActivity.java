package com.example.indovinaparola;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    EditText ed_text;
    TextView da_indovinare;
    TextView n_tentativo;


    String[] daindovinare = {"A", "U", "T", "O", "S", "T", "R", "A", "D", "A"};
    String[] indovinata = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "};
    ArrayList<String> provati = new ArrayList<>();
    String intera = "";
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        da_indovinare = (TextView) findViewById(R.id.daindovinare);

        ed_text = (EditText) findViewById(R.id.ed_car);
        n_tentativo = (TextView) findViewById(R.id.tentativi);



    }

    public void provalettera(View v){

        String carattere = ed_text.getText().toString();

        for(int i = 0; i < daindovinare.length; i++){

            if (daindovinare[i].equals(carattere) && indovinata[i].equals(" ")){
                Log.d("cribio", "A");
                indovinata[i] = carattere;
            }

            if(!provati.contains(carattere)){
                provati.add(carattere);
                counter ++;
            }


        }

        for(int j = 0; j < daindovinare.length; j++){
            intera = intera + indovinata[j];
        }
        da_indovinare.setText(intera);

        intera = "";

        n_tentativo.setText("Tentativi: " + counter);

    }

    public void resetpartita(View v){
        for(int i = 0; i < daindovinare.length; i++){
            indovinata[i] = " ";
        }
        counter = 0;
        intera = "";

        for(int j = 0; j < provati.size(); j++){
            provati.remove(j);
        }
        da_indovinare.setText("");
        ed_text.setText("");
        n_tentativo.setText("Tentativi: " + counter);

    }




}