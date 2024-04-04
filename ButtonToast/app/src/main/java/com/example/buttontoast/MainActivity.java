/*
Creare un'applicazione Android con 4 pulsanti disposti ai vertici e uno al centro.
Quando l'utente preme il pulsante, verrà visualizzato un messaggio che indica la posizione del pulsante premuto (toast).
 */

package com.example.buttontoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void altosinistra(View v){
        Toast.makeText(this, "Premuto altosinistra", Toast.LENGTH_SHORT).show();
    }

    public void altodestra(View v){
        Toast.makeText(this, "Premuto altodestra", Toast.LENGTH_SHORT).show();
    }

    public void centro(View v){
        Toast.makeText(this, "Premuto centro", Toast.LENGTH_SHORT).show();
    }

    public void bassosinistra(View v){
        Toast.makeText(this, "Premuto bassosinistra", Toast.LENGTH_SHORT).show();
    }

    public void bassodestra(View v){
        Toast.makeText(this, "Premuto bassodestra", Toast.LENGTH_SHORT).show();
    }
}