/*
Creare un'app telefonino. L'interfaccia utente sarà un telefonino. L'utente può comporre una stringa di numeri e premere invio.
Premendo invio, la stringa verra mostrata nello schermo del telefonino che è una lista.
 */

package com.example.telefonino;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    TextView textn;

    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textn = (TextView) findViewById(R.id.textnumber);

        lista = findViewById(R.id.mylistview);

        arrayadapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.list_element, R.id.textList, arrayList);
        lista.setAdapter(arrayadapter);


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String riga = lista.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Cliccato sulla stringa: " + riga + " in posizione " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void add(View v){
        String testo_scritto = textn.getText().toString();
        if(testo_scritto != ""){
            arrayList.add(testo_scritto);
            arrayadapter.notifyDataSetChanged();
        }

    }

    public void pulisci(View v){
        textn.setText("");
    }

    public void numero0 (View v){
        String numero = textn.getText().toString() + "0";
        textn.setText(numero);
    }

    public void numero1 (View v){
        String numero = textn.getText().toString() + "1";
        textn.setText(numero);
    }

    public void numero2 (View v){
        String numero = textn.getText().toString() + "2";
        textn.setText(numero);
    }

    public void numero3 (View v){
        String numero = textn.getText().toString() + "3";
        textn.setText(numero);
    }

    public void numero4 (View v){
        String numero = textn.getText().toString() + "4";
        textn.setText(numero);
    }

    public void numero5 (View v){
        String numero = textn.getText().toString() + "5";
        textn.setText(numero);
    }

    public void numero6 (View v){
        String numero = textn.getText().toString() + "6";
        textn.setText(numero);
    }

    public void numero7 (View v){
        String numero = textn.getText().toString() + "7";
        textn.setText(numero);
    }

    public void numero8 (View v){
        String numero = textn.getText().toString() + "8";
        textn.setText(numero);
    }

    public void numero9 (View v){
        String numero = textn.getText().toString() + "9";
        textn.setText(numero);
    }
    public void cancelletto (View v){
        String numero = textn.getText().toString() + "#";
        textn.setText(numero);
    }
    public void asterisco (View v){
        String numero = textn.getText().toString() + "*";
        textn.setText(numero);
    }
}