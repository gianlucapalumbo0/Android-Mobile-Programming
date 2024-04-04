package com.example.graficasimpleimage;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    //gestione della seconda immagine in maniera programmatica

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //trovo il riferimento al RelativeLayout del file XML
        RelativeLayout mainframe = findViewById(R.id.mainframe);

        /*creo un nuovo oggetto ImageView in maniera programmatica. Inserisco questa immagine all'interno del
        RelativeLayout dinamicamente. Staticamente lo faccio attraverso il file XML, dinamicamente all'interno
        del file Java.
         */

        ImageView globoImageView = new ImageView(getApplicationContext());
        //setto l'immagine
        globoImageView.setImageDrawable(getResources().getDrawable(R.drawable.earth));

        int width = 300;
        int height = 300;

        //specifico come deve essere il layout
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(width,height);
        lp.addRule(RelativeLayout.CENTER_VERTICAL);
        lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        //associo questi parametri all'ImageView
        globoImageView.setLayoutParams(lp);

        /*
           Il corrispondente codice in XML è questo
           android:layout_width="400dp"
           android:layout_height="400dp"
           android:layout_alignParentLeft="true"
           android:layout_centerVertical="true"
        */

        //setto il colore si sfondo
        globoImageView.setBackgroundColor(Color.GRAY);

        //aggiungo al relatice layout XML, quest'altra View
        mainframe.addView(globoImageView);


    }


}