package com.example.frammentidinamico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
    }

    public void pulsanteInserisciApremuto(View v) {
        FrammentoA f = new FrammentoA();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.contenitoreFrammenti,f,"tagFrammentoA");
        ft.commit();
    }

    public void pulsanteInserisciBpremuto(View v) {
        FrammentoB f = new FrammentoB();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.contenitoreFrammenti,f,"tagFrammentoB");
        ft.commit();
    }

    public void pulsanteRimuoviApremuto(View v) {
        Fragment f = fm.findFragmentByTag("tagFrammentoA");
        FragmentTransaction ft = fm.beginTransaction();
        if (f != null) {
            ft.remove(f);
        }
        ft.commit();
    }

    public void pulsanteRimuoviBpremuto(View v) {
        Fragment f = fm.findFragmentByTag("tagFrammentoB");
        FragmentTransaction ft = fm.beginTransaction();
        if (f != null) {
            ft.remove(f);
        }
        ft.commit();
    }

    public void pulsantedaAaBpremuto(View v) {
        FragmentTransaction ft = fm.beginTransaction();
        FrammentoB f = new FrammentoB();
        ft.replace(R.id.contenitoreFrammenti,f,"tagFrammentoB");
        ft.commit();
    }

    public void pulsantedaBaApremuto(View v) {
        FragmentTransaction ft = fm.beginTransaction();
        FrammentoA f = new FrammentoA();
        ft.replace(R.id.contenitoreFrammenti,f,"tagFrammentoA");
        ft.commit();
    }

    public void pulsanteAttachApremuto(View v) {
        Fragment f = fm.findFragmentByTag("tagFrammentoA");
        if (f != null) {
            FragmentTransaction ft = fm.beginTransaction();
            ft.attach(f);
            ft.commit();
        }
    }

    public void pulsanteDetachApremuto(View v) {
        Fragment f = fm.findFragmentByTag("tagFrammentoA");
        if (f != null) {
            FragmentTransaction ft = fm.beginTransaction();
            ft.detach(f);
            ft.commit();
        }
    }

}
