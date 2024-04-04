package com.example.giocovisivo;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Scacchiera s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recupero i frammenti per inserirli all'interno dei due frame
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction(); //iniziamo una transaction

        s = new Scacchiera(getApplication());


        ft.add(R.id.frame, s, ""); //il frammento s viene inserito all'interno del frame
        ft.commit();


    }

    public void resetScacchiera(View v){
        s.reset();
    }

}