package com.example.ordinanumeri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView pos11;
    TextView pos12;
    TextView pos13;
    TextView pos21;
    TextView pos22;
    TextView pos23;
    TextView pos31;
    TextView pos32;
    TextView pos33;
    TextView counterClick;

    int counter;
    Boolean risolto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pos11 = (TextView) findViewById(R.id.position11);
        pos12 = (TextView) findViewById(R.id.position12);
        pos13 = (TextView) findViewById(R.id.position13);
        pos21 = (TextView) findViewById(R.id.position21);
        pos22 = (TextView) findViewById(R.id.position22);
        pos23 = (TextView) findViewById(R.id.position23);
        pos31 = (TextView) findViewById(R.id.position31);
        pos32 = (TextView) findViewById(R.id.position32);
        pos33 = (TextView) findViewById(R.id.position33);
        counterClick = (TextView) findViewById(R.id.counterClick);

        if (savedInstanceState != null){
            pos11.setText(savedInstanceState.getString("VALORE11"));
            pos12.setText(savedInstanceState.getString("VALORE12"));
            pos13.setText(savedInstanceState.getString("VALORE13"));
            pos21.setText(savedInstanceState.getString("VALORE21"));
            pos22.setText(savedInstanceState.getString("VALORE22"));
            pos23.setText(savedInstanceState.getString("VALORE23"));
            pos31.setText(savedInstanceState.getString("VALORE31"));
            pos32.setText(savedInstanceState.getString("VALORE32"));
            pos33.setText(savedInstanceState.getString("VALORE33"));

            counter = savedInstanceState.getInt("COUNTER");
            counterClick.setText("" + counter);
            risolto = savedInstanceState.getBoolean("RISOLTO");
        }

        else{
            settavalori();
        }
    }

    public void primasu(View v) {
        numeriordinati();
        if(risolto != true){
            aggiornaCounter();
        }

        String one = pos11.getText().toString();
        String two = pos21.getText().toString();
        String three = pos31.getText().toString();


        pos11.setText(two);
        pos21.setText(three);
        pos31.setText(one);

    }

    public void secondasu(View v) {
        numeriordinati();
        if(risolto != true){
            aggiornaCounter();
        }

        String one = pos12.getText().toString();
        String two = pos22.getText().toString();
        String three = pos32.getText().toString();


        pos12.setText(two);
        pos22.setText(three);
        pos32.setText(one);
    }

    public void terzasu(View v) {
        numeriordinati();
        if(risolto != true){
            aggiornaCounter();
        }

        String one = pos13.getText().toString();
        String two = pos23.getText().toString();
        String three = pos33.getText().toString();


        pos13.setText(two);
        pos23.setText(three);
        pos33.setText(one);

    }

    public void primasin(View v) {
        numeriordinati();
        if(risolto != true){
            aggiornaCounter();
        }

        String one = pos11.getText().toString();
        String two = pos12.getText().toString();
        String three = pos13.getText().toString();


        pos11.setText(two);
        pos12.setText(three);
        pos13.setText(one);
    }

    public void secondasin(View v) {
        numeriordinati();
        if(risolto != true){
            aggiornaCounter();
        }

        String one = pos21.getText().toString();
        String two = pos22.getText().toString();
        String three = pos23.getText().toString();


        pos21.setText(two);
        pos22.setText(three);
        pos23.setText(one);
    }

    public void terzasin(View v) {
        numeriordinati();
        if(risolto != true){
            aggiornaCounter();
        }

        String one = pos31.getText().toString();
        String two = pos32.getText().toString();
        String three = pos33.getText().toString();


        pos31.setText(two);
        pos32.setText(three);
        pos33.setText(one);
    }

    public void primagiu(View v) {
        numeriordinati();
        if(risolto != true){
            aggiornaCounter();
        }

        String one = pos11.getText().toString();
        String two = pos21.getText().toString();
        String three = pos31.getText().toString();


        pos11.setText(three);
        pos21.setText(one);
        pos31.setText(two);
    }

    public void secondagiu(View v) {
        numeriordinati();
        if(risolto != true){
            aggiornaCounter();
        }

        String one = pos12.getText().toString();
        String two = pos22.getText().toString();
        String three = pos32.getText().toString();


        pos12.setText(three);
        pos22.setText(one);
        pos32.setText(two);
    }

    public void terzagiu(View v) {
        numeriordinati();
        if(risolto != true){
            aggiornaCounter();
        }

        String one = pos13.getText().toString();
        String two = pos23.getText().toString();
        String three = pos33.getText().toString();


        pos13.setText(three);
        pos23.setText(one);
        pos33.setText(two);
    }

    public void primades(View v) {
        numeriordinati();
        if(risolto != true){
            aggiornaCounter();
        }

        String one = pos11.getText().toString();
        String two = pos12.getText().toString();
        String three = pos13.getText().toString();


        pos11.setText(three);
        pos12.setText(one);
        pos13.setText(two);
    }

    public void secondades(View v) {
        numeriordinati();
        if(risolto != true){
            aggiornaCounter();
        }

        String one = pos21.getText().toString();
        String two = pos22.getText().toString();
        String three = pos23.getText().toString();


        pos21.setText(three);
        pos22.setText(one);
        pos23.setText(two);
    }

    public void terzades(View v) {
        numeriordinati();
        if(risolto != true){
            aggiornaCounter();
        }

        String one = pos31.getText().toString();
        String two = pos32.getText().toString();
        String three = pos33.getText().toString();


        pos31.setText(three);
        pos32.setText(one);
        pos33.setText(two);
    }

    public void reset(View v) {
        settavalori();
    }


    private void aggiornaCounter() {
        counter++;

        counterClick.setText("" + counter);
    }

    private void settavalori() {
        counter = 0;

        pos11.setText("9");
        pos12.setText("3");
        pos13.setText("2");
        pos21.setText("1");
        pos22.setText("7");
        pos23.setText("4");
        pos31.setText("5");
        pos32.setText("6");
        pos33.setText("8");
        counterClick.setText("0");

        risolto = false;
    }

    private void numeriordinati() {
        String aa = pos11.getText().toString();
        String ab = pos12.getText().toString();
        String ac = pos13.getText().toString();
        String ba = pos21.getText().toString();
        String bb = pos22.getText().toString();
        String bc = pos23.getText().toString();
        String ca = pos31.getText().toString();
        String cb = pos32.getText().toString();
        String cc = pos33.getText().toString();

        Log.d("DEBUG","Stampavalorei:"+aa+ab+ac+ba+bb+bc+ca+cb+cc);

        if (aa.equals("1") && ab.equals("2") && ac.equals("3") && ba.equals("4") && bb.equals("5") && bc.equals("6") && ca.equals("7") && cb.equals("8") && cc.equals("9")) {

            String mes = "Gioco completato in " + counter + " mosse!";
            View customToastView = getLayoutInflater().inflate(R.layout.custom_toast, null);
            TextView customToastText = customToastView.findViewById(R.id.toast);
            customToastText.setText(mes);
            Toast customToast = new Toast(getApplicationContext());
            customToast.setView(customToastView);
            customToast.setDuration(Toast.LENGTH_LONG);
            customToast.setGravity(Gravity.CENTER,0,0);
            customToast.show();


            risolto = true;
        }
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("VALORE11", pos11.getText().toString());
        savedInstanceState.putString("VALORE12", pos12.getText().toString());
        savedInstanceState.putString("VALORE13", pos13.getText().toString());
        savedInstanceState.putString("VALORE21", pos21.getText().toString());
        savedInstanceState.putString("VALORE22", pos22.getText().toString());
        savedInstanceState.putString("VALORE23", pos23.getText().toString());
        savedInstanceState.putString("VALORE31", pos31.getText().toString());
        savedInstanceState.putString("VALORE32", pos32.getText().toString());
        savedInstanceState.putString("VALORE33", pos33.getText().toString());

        savedInstanceState.putInt("COUNTER", counter);
        savedInstanceState.putBoolean("RISOLTO", risolto);

        super.onSaveInstanceState(savedInstanceState);
    }


}