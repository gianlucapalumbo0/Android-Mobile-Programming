package com.example.listalibri;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ListView listView;
    CustomAdapter customAdapter;

    EditText testo_titolo;
    EditText testo_autore;
    private  int count = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testo_titolo = (EditText) findViewById (R.id.ed_titolo);
        testo_autore = (EditText) findViewById (R.id.ed_autore);

        listView = (ListView)findViewById(R.id.mylistview);

        customAdapter = new CustomAdapter(this, R.layout.list_element, new ArrayList<Libro>());

        listView.setAdapter(customAdapter);

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("COUNT");

            String[] arrayAutori = new String[count];
            String[] arrayTitoli = new String[count];

            arrayAutori = savedInstanceState.getStringArray("ARRAY_AUTORI");
            arrayTitoli = savedInstanceState.getStringArray("ARRAY_TITOLI");

            for(int i = 0; i < count; i++){
                Libro l = new Libro(arrayAutori[i], arrayTitoli[i], getResources().getDrawable(R.drawable.libro));
                customAdapter.add(l);
            }
        }

    }

    public void inseriscilibri(View v){
        String titolo;
        String autore;

        titolo = testo_titolo.getText().toString();
        autore = testo_autore.getText().toString();

        Libro l = new Libro (titolo, autore, getResources().getDrawable(R.drawable.libro));
        customAdapter.add(l);
        count ++;
    }

    public void onPictureClick(View v) {
        int position = Integer.parseInt(v.getTag().toString());
        Libro l = customAdapter.getItem(position);

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        customAdapter.remove(l);
                        count--;
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            }
        };


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Stai per eliminare il libro. Sei sicuro?");
        builder.setPositiveButton("Si", dialogClickListener);
        builder.setNegativeButton("No", dialogClickListener);
        builder.show();

        return;
    }

    public void onTitoloClick(View v) {
        int position = Integer.parseInt(v.getTag().toString());
        Libro l = customAdapter.getItem(position);

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        customAdapter.remove(l);
                        count--;
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            }
        };


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Stai per eliminare il libro. Sei sicuro?");
        builder.setPositiveButton("Si", dialogClickListener);
        builder.setNegativeButton("No", dialogClickListener);
        builder.show();

        return;
    }

    public void onAutoreClick(View v) {
        int position = Integer.parseInt(v.getTag().toString());
        Libro l = customAdapter.getItem(position);

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        customAdapter.remove(l);
                        count--;
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            }
        };


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Stai per eliminare il libro. Sei sicuro?");
        builder.setPositiveButton("Si", dialogClickListener);
        builder.setNegativeButton("No", dialogClickListener);
        builder.show();

        return;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        Libro l;
        String autore;
        String titolo;
        String[] arrayAutore = new String[count];
        String[] arrayTitolo = new String[count];


        for (int i = 0; i < count; i++) {
            l = customAdapter.getItem(i);
            autore = l.getAutore();
            titolo = l.getTitolo();
            arrayAutore[i] = autore;
            arrayTitolo[i] = titolo;

        }
        savedInstanceState.putStringArray("ARRAY_AUTORI", arrayAutore);
        savedInstanceState.putStringArray("ARRAY_TITOLI", arrayTitolo);
        savedInstanceState.putInt("COUNT", count);
        super.onSaveInstanceState(savedInstanceState);
    }
}