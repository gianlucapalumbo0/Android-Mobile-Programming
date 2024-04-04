package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView numerodomanda;
    private TextView testodomanda;
    private TextView rispostevalide;
    private TextView rispostenonvalide;
    private TextView totalerisposte;

    private int counter = 0;
    private int valid_correct_answers = 0;
    private int non_valid_correct_answers = 0;
    private int total_answers = 0;

    private Quesito[] arrayQuesito = new Quesito[]{
            new Quesito("Il risultato di 1 + 1 e' 2", true, false, false),
            new Quesito("Il risultato di 1 + 1 e' 3", false, false, false),
            new Quesito("Il risultato di 2 + 2 e' 4", true, false, false),
            new Quesito("Il risultato di 2 + 2 e' 5", false, false, false),
            new Quesito("Il risultato di 3 + 3 e' 6", true, false, false),
            new Quesito("Il risultato di 3 + 3 e' 7", false, false, false),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numerodomanda = findViewById(R.id.numdomandaquiz);
        testodomanda = findViewById(R.id.domandaquiz);
        rispostevalide = findViewById(R.id.rispvalidequiz);
        rispostenonvalide = findViewById(R.id.rispnonvalidequiz);
        totalerisposte = findViewById(R.id.risptotaliquiz);

        aggiornaQuesito();


    }

    public void aggiornaQuesito(){
        numerodomanda.setText("Quesito n." + (counter + 1));

        testodomanda.setText(arrayQuesito[counter].getDomanda());
        rispostevalide.setText("Risposte corrette valide:" + valid_correct_answers);
        rispostenonvalide.setText("Risposte corrette non valide" + non_valid_correct_answers);
        totalerisposte.setText("Risposte totali:" + total_answers);

    }

    public void precedenteclick(View v){
        int lunghezza = arrayQuesito.length;
        if(counter -- < 1){
            counter = lunghezza -1;
        }
        aggiornaQuesito();
    }

    public void successivoclick(View v){
        int lunghezza = arrayQuesito.length;
        if(counter++ >= lunghezza - 1){
            counter = 0;
        }
        aggiornaQuesito();
    }

    public void trueclick(View v){
        if(arrayQuesito[counter].isCounted() == false){
            total_answers++;
            arrayQuesito[counter].setCounted(true);


            if(arrayQuesito[counter].Risposta() == true){
                if(arrayQuesito[counter].isSuggerito() == false){
                    valid_correct_answers ++;
                }
                else {
                    non_valid_correct_answers ++;
                }

            }

        }
        aggiornaQuesito();
    }

    public void falseclick(View v){

        if(arrayQuesito[counter].isCounted() == false){
            total_answers++;
            arrayQuesito[counter].setCounted(true);



            if(arrayQuesito[counter].Risposta() == false){
                if(arrayQuesito[counter].isSuggerito() == false){
                    valid_correct_answers ++;
                }
                else {
                    non_valid_correct_answers ++;
                }
            }
        }
        aggiornaQuesito();
    }

    public void suggerimentoclick(View v){
        Intent i = new Intent();
        i.setClass(getApplicationContext(), Suggerimento.class);
        i.putExtra("NUMERODOMANDA", "Quesito n." + (counter + 1));
        i.putExtra("DOMANDA", arrayQuesito[counter].getDomanda());
        i.putExtra("RISPOSTA", arrayQuesito[counter].Risposta());
        startActivityForResult(i, 879);
    }

    public void resetclick(View v){
        counter = 0;
        valid_correct_answers = 0;
        non_valid_correct_answers = 0;
        total_answers = 0;

        aggiornaQuesito();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != 879) return;
        if (resultCode != Activity.RESULT_OK) return;
        if (data == null) return;

        arrayQuesito[counter].setSuggerito(data.getBooleanExtra("RISPOSTA_MOSTRATA", false));
    }
}