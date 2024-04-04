package com.example.graficaanimazioni;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Animation[] animations = new Animation[5]; //creo un array di animazioni
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.globo);

        ArrayList<View> allButtons;

        //cerco il contenitore dei pulsanti e con getTouchables restituisco tutti i Button presenti all'interno sotto forma di lista
        allButtons = (findViewById(R.id.rigabutton)).getTouchables();


        int i = 1;

        for (View element : allButtons) {
            Button b = (Button) element;
            b.setOnClickListener(this);
            b.setId(i); //setto gli id per i 5 pulsanti
            i++;
        }

        // inserisco le animazioni all'interno dell'array utilizzando il suo nome
        for (int j = 0; j<5; j++) {
            String file = "animazione"+(j+1);
            animations[j]= AnimationUtils.loadAnimation(getApplicationContext(), getResources().getIdentifier(file, "anim",getPackageName()));
        }
    }

    @Override
    public void onClick(View v){
        int id = v.getId();
        Log.d("Prova", ""+id);
        switch (id) {
            case 1:  img.startAnimation(animations[0]);break;
            case 2:  img.startAnimation(animations[1]);break;
            case 3:  img.startAnimation(animations[2]);break;
            case 4:  img.startAnimation(animations[3]);break;
            case 5:  img.startAnimation(animations[4]);break;
        }
    }
}