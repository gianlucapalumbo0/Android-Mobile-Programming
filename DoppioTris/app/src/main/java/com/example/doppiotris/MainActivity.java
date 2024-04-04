package com.example.doppiotris;

import androidx.appcompat.app.AppCompatActivity;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Tris tris1;
    Tris tris2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recupero i frammenti per inserirli all'interno dei due frame
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction(); //iniziamo una transaction

        tris1 = new Tris("X", "O", getApplication());
        tris2 = new Tris("O", "X", getApplication());

        //metodo presente in Tris.java. In questo modo i tris frammenti si conoscono tra loro
        tris1.setAltrosimbolo(tris2);
        tris2.setAltrosimbolo(tris1);

        //inizialmente la scacchiera 1 è attiva, e quella due è disattivata
        tris1.setAttiva(true);
        tris2.setAttiva(false);

        ft.add(R.id.frame1, tris1, ""); //il frammento tris1 viene inserito all'interno del frame1
        ft.add(R.id.frame2, tris2, ""); //il frammento tris2 viene inserito all'interno del frame1

        ft.commit();
    }

    public void resetTris(View v){
        tris1.reset();
        tris2.reset();
        tris1.setAttiva(true);
        tris2.setAttiva(false);
    }
}