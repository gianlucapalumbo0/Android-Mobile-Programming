package com.example.campominato;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    Campo campo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recupero i frammenti per inserirli all'interno dei due frame
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction(); //iniziamo una transaction

        campo = new Campo(getApplication());



        ft.add(R.id.frame, campo, ""); //il frammento campo viene inserito all'interno del frame
        ft.commit();
    }

    public void resetCampo(View v){
        campo.reset();
    }

    public void mostraCampo(View v){
        campo.mostra();
    }
}