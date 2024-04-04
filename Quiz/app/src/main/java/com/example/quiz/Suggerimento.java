package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class Suggerimento extends AppCompatActivity {
    private TextView numerodomanda;
    private TextView testodomanda;
    private TextView testorisposta;
    private String numerod;
    private String quesito;
    private Boolean risposta;

    private Boolean risposta_vista = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_suggerimento);

        numerodomanda = findViewById(R.id.numdomandaquiz);
        testodomanda = findViewById(R.id.domandaquiz);
        testorisposta = findViewById(R.id.rispostaquiz);

        Intent i = getIntent();
        numerod = i.getStringExtra("NUMERODOMANDA");
        quesito = i.getStringExtra("DOMANDA");
        risposta = i.getBooleanExtra("RISPOSTA", false);

        numerodomanda.setText(numerod);
        testodomanda.setText(quesito);

        inviaIntent();

    }

    public void suggerimentoclick(View v){
        testorisposta.setText("La risposta e' " + risposta);
        risposta_vista = true;
        Toast.makeText(this, "Imbrogliare è sbagliato", Toast.LENGTH_SHORT).show();

        inviaIntent();
    }

    private void inviaIntent(){
        Intent data = new Intent();
        data.putExtra("RISPOSTA_MOSTRATA", risposta_vista);
        setResult(RESULT_OK,data);
    }

}