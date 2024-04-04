package com.example.listacustom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ListView listView;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String[] nomi = {"Pasquale","Maria","Michele","Antonella", "Vincenzo",
                "Teresa", "Roberto", "Rossella", "Antonio", "Luca", "Liliana", "Stefania",
                "Francesca", "Andrea", "Marco", "Elisa", "Anna", "Lorenzo"};


        listView = (ListView)findViewById(R.id.mylistview);

        customAdapter = new CustomAdapter(this, R.layout.list_element, new ArrayList<Contatto>());

        listView.setAdapter(customAdapter);


        for (int i=0; i<nomi.length; i++) {
            Contatto c = new Contatto(
                    nomi[i],
                    "111-2222-333",
                    getResources().getDrawable(R.drawable.faceplaceholder));
            customAdapter.add(c);
        }

    }

    public void onPictureClick(View v) {

        int position = Integer.parseInt(v.getTag().toString());
        Contatto c = customAdapter.getItem(position);
        Toast.makeText(getApplicationContext(), "Click su Foto - posizione n."+position+": " +c.getName(), Toast.LENGTH_LONG).show();
    }

    public void onNameClick(View v) {
        int position = Integer.parseInt(v.getTag().toString());
        Contatto c = customAdapter.getItem(position);
        Toast.makeText(getApplicationContext(), "Click su Nome - posizione n."+position+": " +c.getName(), Toast.LENGTH_LONG).show();
    }

    public void onTelClick(View v) {
        int position = Integer.parseInt(v.getTag().toString());
        Contatto c = customAdapter.getItem(position);
        Toast.makeText(getApplicationContext(), "Click su Tel - posizione n."+position+": " +c.getName(), Toast.LENGTH_LONG).show();
    }

}
