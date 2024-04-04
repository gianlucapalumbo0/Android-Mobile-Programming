package com.example.listenomi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView1;
    ListView listView2;
    Switch selettore;
    EditText nomelista1;
    EditText nomelista2;

    //li dichiaro come variabili globali altrimenti non sono visibili al di fuori di onCreate
    ArrayList<String> array1;
    ArrayList<String> array2;
    ArrayAdapter<String> arrayAdapter1;
    ArrayAdapter<String> arrayAdapter2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selettore = (Switch) findViewById(R.id.selettore);
        nomelista1 = (EditText) findViewById(R.id.insnome1);
        nomelista2 = (EditText) findViewById(R.id.insnome2);

        // uso arraylist invece di array così da poter inserire e togliere elementi facilmente
        array1 = new ArrayList<>();
        array1.add("Pasquale");
        array1.add("Maria");
        array1.add("Michele");
        array1.add("Antonella");
        array1.add("Vincenzo");

        array2 = new ArrayList<>();
        array2.add("Stefania");
        array2.add("Francesca");
        array2.add("Andrea");
        array2.add("Marco");
        array2.add("Elisa");
        array2.add("Anna");
        array2.add("Lorenzo");


        listView1 = findViewById(R.id.lista1);
        listView2 = findViewById(R.id.lista2);


        arrayAdapter1 = new ArrayAdapter<String>(this, R.layout.list_element, R.id.textViewList,  array1);
        arrayAdapter2 = new ArrayAdapter<String>(this, R.layout.list_element, R.id.textViewList,  array2);

        listView1.setAdapter(arrayAdapter1);
        listView2.setAdapter(arrayAdapter2);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String  str  = listView1.getItemAtPosition(position).toString();

                if(selettore.isChecked()){// se il selettore è selezionato rimuovo e aggiungo
                    //al click tolgo l'elemento in posizione position e lo aggiungo all'array2
                    array1.remove(position);
                    array2.add(str);
                }
                else{
                    array1.remove(position);
                }

                //notifico l'arrayadapter del cambiamento
                arrayAdapter1.notifyDataSetChanged();
                arrayAdapter2.notifyDataSetChanged();
            }
        });

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String  str  = listView2.getItemAtPosition(position).toString();

                if(selettore.isChecked()){// se il selettore è selezionato rimuovo e aggiungo
                    //al click tolgo l'elemento in posizione position e lo aggiungo all'array2
                    array2.remove(position);
                    array1.add(str);
                }
                else{
                    array2.remove(position);
                }

                //notifico l'arrayadapter del cambiamento
                arrayAdapter1.notifyDataSetChanged();
                arrayAdapter2.notifyDataSetChanged();

            }
        });

    }

    public void inseriscinome1(View v){
        String nome_da_inserire = nomelista1.getText().toString();

        if(nome_da_inserire.length() > 0){
            array1.add(nome_da_inserire);

            arrayAdapter1.notifyDataSetChanged();
        }

        nomelista1.setText("");
    }

    public void inseriscinome2(View v){
        String nome_da_inserire = nomelista2.getText().toString();

        if(nome_da_inserire.length() > 0){
            array2.add(nome_da_inserire);

            arrayAdapter2.notifyDataSetChanged();
        }

        nomelista2.setText("");
    }
}