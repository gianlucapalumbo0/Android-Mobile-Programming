/*
Creare un'applicazione Android che visualizzi una lista di elementi personalizzati riguardanti ricette culinarie. Ogni elemento della lista dovrebbe
mostrare il nome della ricetta, un'immagine rappresentativa e un breve riassunto degli ingredienti. Gli elementi della lista dovrebbero essere cliccabili e
visualizzare i dettagli completi della ricetta in un'altra schermata.
 */

package com.example.ricetteculinarie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}