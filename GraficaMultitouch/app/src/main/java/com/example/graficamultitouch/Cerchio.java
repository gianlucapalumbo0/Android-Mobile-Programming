package com.example.graficamultitouch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

public class Cerchio extends View {
    private int x, y;
    private int size;
    private int id;



    Paint pstroke;
    Paint pfill;
    Paint ptext;

    public Cerchio(Context c, int size, int id){
        super(c);
        this.size = size;
        this.id = id;


        //settaggi iniziali paint
        pstroke = new Paint();
        pstroke.setStyle(Paint.Style.STROKE);
        pstroke.setARGB(128,255,0,0);
        pstroke.setStrokeWidth(20);


        pfill = new Paint();
        pfill.setStyle(Paint.Style.FILL);
        pfill.setARGB(128,0,255,0);

        ptext = new Paint();
        ptext.setColor(Color.BLACK);
        ptext.setTextSize(100);

    }

    public void setCoordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    protected void onDraw(Canvas canvas){
        canvas.drawCircle(x,y,size, pstroke);
        canvas.drawCircle(x,y,size, pfill);
        canvas.drawText("" + id, x-25,y+25, ptext);
    }



}
