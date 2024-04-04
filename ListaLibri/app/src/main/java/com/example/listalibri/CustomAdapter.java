package com.example.listalibri;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Libro> {
    private LayoutInflater inflater;

    public CustomAdapter(Context context, int resourceId, List<Libro> objects) {
        super(context, resourceId, objects);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        if (v == null) {
            v = inflater.inflate(R.layout.list_element, null);
        }

        Libro l = getItem(position);


        Button titoloButton;
        Button autoreButton;
        ImageButton copertinaButton;

        titoloButton = (Button) v.findViewById(R.id.elem_lista_titolo);
        autoreButton = (Button) v.findViewById(R.id.elem_lista_autore);
        copertinaButton = (ImageButton) v.findViewById(R.id.elem_lista_copertina);

        titoloButton.setText(l.getTitolo());
        autoreButton.setText(l.getAutore());
        copertinaButton.setImageDrawable(l.getCopertina());


        titoloButton.setTag(position);
        autoreButton.setTag(position);
        copertinaButton.setTag(position);

        return v;
    }
}


