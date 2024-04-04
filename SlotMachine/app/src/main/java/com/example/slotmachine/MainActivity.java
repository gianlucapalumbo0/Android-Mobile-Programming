package com.example.slotmachine;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView pos0;
    TextView pos1;
    TextView pos2;
    TextView pos3;
    TextView pos4;
    TextView pos5;
    TextView pos6;
    TextView pos7;
    TextView pos8;
    TextView pos9;
    TextView pos10;
    TextView pos11;

    TextView tx_totale;
    Boolean giocato = false;

    // Creazione di un oggetto Random
    Random rand = new Random();

    int punteggio = 0;
    Boolean risolto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pos0 = (TextView) findViewById(R.id.position0);
        pos1 = (TextView) findViewById(R.id.position1);
        pos2 = (TextView) findViewById(R.id.position2);
        pos3 = (TextView) findViewById(R.id.position3);
        pos4 = (TextView) findViewById(R.id.position4);
        pos5 = (TextView) findViewById(R.id.position5);
        pos6 = (TextView) findViewById(R.id.position6);
        pos7 = (TextView) findViewById(R.id.position7);
        pos8 = (TextView) findViewById(R.id.position8);
        pos9 = (TextView) findViewById(R.id.position9);
        pos10 = (TextView) findViewById(R.id.position10);
        pos11 = (TextView) findViewById(R.id.position11);
        tx_totale = (TextView) findViewById(R.id.punteggioTotale);




        if (savedInstanceState != null){
            pos0.setText(savedInstanceState.getString("posizione0"));
            pos1.setText(savedInstanceState.getString("posizione1"));
            pos2.setText(savedInstanceState.getString("posizione2"));
            pos3.setText(savedInstanceState.getString("posizione3"));
            pos4.setText(savedInstanceState.getString("posizione4"));
            pos5.setText(savedInstanceState.getString("posizione5"));
            pos6.setText(savedInstanceState.getString("posizione6"));
            pos7.setText(savedInstanceState.getString("posizione7"));
            pos8.setText(savedInstanceState.getString("posizione8"));
            pos9.setText(savedInstanceState.getString("posizione9"));
            pos10.setText(savedInstanceState.getString("posizione10"));
            pos11.setText(savedInstanceState.getString("posizione11"));
            giocato = savedInstanceState.getBoolean("giocato");
            punteggio = savedInstanceState.getInt("punteggio");
        }

        tx_totale.setText("Punteggio totale: " + punteggio);




    }

    public void startpartita(View v){
        int numero1;
        int numero2;
        int numero3;
        int numero4;

        if(giocato == false){
            // Generazione di un numero casuale compreso tra 0 e 9
            numero1 = rand.nextInt(10);
            numero2 = rand.nextInt(10);
            numero3 = rand.nextInt(10);
            numero4 = rand.nextInt(10);

            pos0.setText("" + (numero1-1));
            pos1.setText("" + (numero2-1));
            pos2.setText("" + (numero3-1));
            pos3.setText("" + (numero4-1));
            pos4.setText("" + numero1);
            pos5.setText("" + numero2);
            pos6.setText("" + numero3);
            pos7.setText("" + numero4);
            pos8.setText("" + (numero1+1));
            pos9.setText("" + (numero2+1));
            pos10.setText("" + (numero3+1));
            pos11.setText("" + (numero4+1));
            tx_totale.setText("Punteggio totale:" + punteggio);
            giocato = true;

            calcolaPunteggio();
        }




    }

    public void reset(View v){
        if(giocato == true){
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case DialogInterface.BUTTON_POSITIVE:
                            pos0.setText("");
                            pos1.setText("");
                            pos2.setText("");
                            pos3.setText("");
                            pos4.setText("");
                            pos5.setText("");
                            pos6.setText("");
                            pos7.setText("");
                            pos8.setText("");
                            pos9.setText("");
                            pos10.setText("");
                            pos11.setText("");
                            giocato = false;
                            punteggio = 0;
                            tx_totale.setText("Punteggio totale: " + punteggio);
                            break;
                        case DialogInterface.BUTTON_NEGATIVE:
                            break;
                    }
                }
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Sei sicuro?");
            builder.setPositiveButton("Si", dialogClickListener);
            builder.setNegativeButton("No", dialogClickListener);
            builder.show();

            return;
        }

    }





    private void calcolaPunteggio() {
        int numero1 = Integer.parseInt(pos4.getText().toString());
        int numero2 = Integer.parseInt(pos5.getText().toString());
        int numero3 = Integer.parseInt(pos6.getText().toString());
        int numero4 = Integer.parseInt(pos7.getText().toString());


        if((numero1 == numero2) && (numero2 == numero3) && (numero3 == numero4)){
            punteggio = 50;
        }

        else if ((numero1 == numero2 && numero2 == numero3) || (numero1 == numero2 && numero2 == numero4) || (numero1 == numero3 && numero3 == numero4) || (numero2 == numero3 && numero3 == numero4)){
            punteggio = 25;
        }

        else if ((numero1 == numero2) || (numero1 == numero3) || (numero1 == numero4) || (numero2 == numero3) || (numero2 == numero4) || (numero3 == numero4)){
            punteggio = 10;
        }

        tx_totale.setText("Punteggio totale: " + punteggio);
    }




    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("posizione0", pos0.getText().toString());
        savedInstanceState.putString("posizione1", pos1.getText().toString());
        savedInstanceState.putString("posizione2", pos2.getText().toString());
        savedInstanceState.putString("posizione3", pos3.getText().toString());
        savedInstanceState.putString("posizione4", pos4.getText().toString());
        savedInstanceState.putString("posizione5", pos5.getText().toString());
        savedInstanceState.putString("posizione6", pos6.getText().toString());
        savedInstanceState.putString("posizione7", pos7.getText().toString());
        savedInstanceState.putString("posizione8", pos8.getText().toString());
        savedInstanceState.putString("posizione9", pos9.getText().toString());
        savedInstanceState.putString("posizione10", pos10.getText().toString());
        savedInstanceState.putString("posizione11", pos11.getText().toString());
        savedInstanceState.putBoolean("giocato", giocato);
        savedInstanceState.putInt("punteggio", punteggio);

        super.onSaveInstanceState(savedInstanceState);
    }


}