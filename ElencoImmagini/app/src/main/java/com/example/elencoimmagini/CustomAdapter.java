package com.example.elencoimmagini;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Elemento> {
    private LayoutInflater inflater;

    public CustomAdapter(Context context, int resourceId, List<Elemento> objects) {
        super(context, resourceId, objects);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        if (v == null) {
            v = inflater.inflate(R.layout.list_element, null);
        }

        Elemento e = getItem(position);


        Button nameButton;
        ImageButton fotoButton;

        nameButton = (Button) v.findViewById(R.id.elem_lista_nome);
        fotoButton = (ImageButton) v.findViewById(R.id.elem_lista_foto);

        nameButton.setText(e.getNome());
        fotoButton.setImageDrawable(e.getImmagine());

        nameButton.setTag(position);
        fotoButton.setTag(position);


        return v;
    }
}
