package com.example.graficacanvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.ArrayList;

public class Pentagramma extends View {
    int WIDTH;
    int HEIGHT;
    int MARGIN_TOP = 50;
    int MARGIN_H = 50;
    int SPACING = 20;
    int RAGGIO_NOTA = SPACING/2;
    int LUNGHEZZA_NOTA = 60;


    ArrayList<Nota> listaNote = new ArrayList<>();


    //costruttore
    public Pentagramma(Context c, int w, int h){
        super(c);
        WIDTH = w;
        HEIGHT = h;
        setMinimumHeight(h);
        setMinimumWidth(h);
    }


    @Override
    public void onDraw(Canvas canvas){
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);

        //disegnamo il pentagramma
        for(int i = 0; i < 5; i ++){
            int y = MARGIN_TOP +(i * SPACING);
            canvas.drawLine(0 + MARGIN_H, y , WIDTH - MARGIN_H ,y, paint);
        }

        //disegnamo le note
        for(int i = 0; i < listaNote.size(); i++){
            Nota n = listaNote.get(i);
            int h = n.getH();
            int v = n.getV();
            canvas.drawCircle(h,v,RAGGIO_NOTA,paint);
            canvas.drawLine(h + RAGGIO_NOTA, v , h + RAGGIO_NOTA, v - LUNGHEZZA_NOTA, paint);
        }
    }

    public void inseriscinota(int w, int h){
        Nota n = new Nota(w,h);
        listaNote.add(n);
    }


}
