package com.example.rubricacontatti;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ListView listView;
    CustomAdapter customAdapter;
    EditText tex_nome;
    EditText tex_cognome;
    EditText tex_telefono;
    private int count = 0;

    String valoredarecuperare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tex_nome = (EditText) findViewById(R.id.edittextnome);
        tex_cognome = (EditText) findViewById(R.id.edittextcognome);
        tex_telefono = (EditText) findViewById(R.id.edittexttelefono);

        listView = (ListView)findViewById(R.id.mylistview);

        customAdapter = new CustomAdapter(this, R.layout.list_element, new ArrayList<Contatto>());

        listView.setAdapter(customAdapter);

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("COUNT");

            String[] arrayNomi = new String[count];
            String[] arrayTelefono = new String[count];

            arrayNomi = savedInstanceState.getStringArray("ARRAY_NOMI");
            arrayTelefono = savedInstanceState.getStringArray("ARRAY_TELEFONO");

            for(int i = 0; i < count; i++){
                Contatto c = new Contatto(arrayNomi[i], arrayTelefono[i], getResources().getDrawable(R.drawable.faceplaceholder));
                customAdapter.add(c);
            }
        }


    }

    public void onPictureClick(View v) {
        Log.d("DEBUG","Picture has been clicked: position="+v.getTag());
        int position = Integer.parseInt(v.getTag().toString());
        Contatto c = customAdapter.getItem(position);

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        customAdapter.remove(c);
                        count--;
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            }
        };


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Stai per eliminare il contatto. Sei sicuro?");
        builder.setPositiveButton("Si", dialogClickListener);
        builder.setNegativeButton("No", dialogClickListener);
        builder.show();

        return;


    }

    public void onNameClick(View v) {
        Log.d("DEBUG","Name has been clicked position="+v.getTag());
        int position = Integer.parseInt(v.getTag().toString());
        Contatto c = customAdapter.getItem(position);

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        customAdapter.remove(c);
                        count--;
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            }
        };


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Stai per eliminare il contatto. Sei sicuro?");
        builder.setPositiveButton("Si", dialogClickListener);
        builder.setNegativeButton("No", dialogClickListener);
        builder.show();

        return;
    }

    public void onTelClick(View v) {
        Log.d("DEBUG", "Tel has been clicked position=" + v.getTag());
        int position = Integer.parseInt(v.getTag().toString());
        Contatto c = customAdapter.getItem(position);

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        customAdapter.remove(c);
                        count--;
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            }
        };


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Stai per eliminare il contatto. Sei sicuro?");
        builder.setPositiveButton("Si", dialogClickListener);
        builder.setNegativeButton("No", dialogClickListener);
        builder.show();

        return;
    }

    private void addToCustom(){
        String nome;
        String cognome;
        String telefono;
        nome = tex_nome.getText().toString();
        cognome = tex_cognome.getText().toString();

        telefono = tex_telefono.getText().toString();


        if(nome.length() != 0 && cognome.length() !=0 && telefono.length() != 0 ){
            nome = nome + " " + cognome;
            Contatto c = new Contatto(nome, telefono, getResources().getDrawable(R.drawable.faceplaceholder));
            customAdapter.add(c);
            count++;
        }


    }

    public void inseriscielem(View v){
        addToCustom();
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        Contatto c;
        String nome;
        String telefono;
        String[] arrayNomi = new String[count];
        String[] arrayTelefono = new String[count];


        for (int i = 0; i < count; i++) {
            c = customAdapter.getItem(i);
            nome = c.getName();
            telefono = c.getTel();
            arrayNomi[i] = nome;
            arrayTelefono[i] = telefono;

        }
        savedInstanceState.putStringArray("ARRAY_NOMI", arrayNomi);
        savedInstanceState.putStringArray("ARRAY_TELEFONO", arrayTelefono);
        savedInstanceState.putInt("COUNT", count);
        super.onSaveInstanceState(savedInstanceState);
    }





}
