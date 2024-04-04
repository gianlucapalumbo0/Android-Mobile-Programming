package com.example.graficamultitouch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    FrameLayout contenitore;
    int screenw_px;
    int screenh_px;
    int RAGGIO = 100;

    private Map<Integer, Cerchio> hashMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Display display = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        screenw_px = point.x;
        screenh_px = point.x;

        contenitore = findViewById(R.id.contenitore);

        contenitore.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent e) {
                Cerchio c;
                int index = e.getActionIndex();
                int pointer = e.getPointerId(index);

                switch (e.getActionMasked()){
                    //i primi due li gestisco assieme
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_POINTER_DOWN:

                        if(hashMap.containsKey(pointer)){
                            c = hashMap.get(pointer);
                        }
                        else{
                            int x = (int) e.getX(index);
                            int y = (int) e.getY(index);



                            Log.d("DEBUG", "x = " + x + " y" + y);
                            c = new Cerchio(getApplicationContext(), RAGGIO, pointer);
                            c.setCoordinates(x,y);
                            contenitore.addView(c);
                            hashMap.put(pointer,c);
                        }
                        break;

                    case MotionEvent.ACTION_MOVE:
                        for(int i = 0 ; i < e.getPointerCount(); i++){
                            pointer = e.getPointerId(i);
                            c = hashMap.get(pointer);
                            int x = (int) e.getX(index);
                            int y = (int) e.getY(index);

                            if(x>RAGGIO && x <screenw_px-RAGGIO && y>RAGGIO && y<screenh_px-RAGGIO ){
                                c.setCoordinates(x,y);
                                c.invalidate();
                            }

                        }
                        break;
                    case MotionEvent.ACTION_POINTER_UP:
                        break;
                    case MotionEvent.ACTION_UP:
                        if(hashMap.containsKey(pointer)){
                            c = hashMap.get(pointer);
                            contenitore.removeView(c);
                            hashMap.remove(pointer);
                            c.invalidate();
                        }
                        break;
                }
                return true;
            }
        });
    }
}