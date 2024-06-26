package com.example.graficacanvas;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    FrameLayout fl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fl = findViewById(R.id.contenitore);

        //ottengo la grandezza del display
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        Point size = new Point();
        display.getSize(size);
        int screen_w = size.x;//in pixel
        int screen_h = size.y;//in pixel



        Pentagramma p = new Pentagramma(getApplicationContext(),screen_w, screen_h);

        //vado a prendermi le coordinate dei punti cliccati
        p.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    int hor = (int) event.getX();
                    int ver = (int) event.getY();
                    Log.d("DEBUG", "Click h= " + hor + " w= " + ver);
                    p.inseriscinota(hor, ver);
                    p.invalidate();
                }

                return true;
            }

        });

        fl.addView(p);
    }
}