package com.example.partitarandom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Player> {
    private LayoutInflater inflater;

    public CustomAdapter(Context context, int resourceId, List<Player> objects) {
        super(context, resourceId, objects);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        if (v == null) {
            v = inflater.inflate(R.layout.list_element, null);
        }

        Player p = getItem(position);

        Button nameButton;
        Button punteggioButton;

        nameButton = (Button) v.findViewById(R.id.elem_lista_nome);
        punteggioButton = (Button) v.findViewById(R.id.elem_lista_punteggio);

        nameButton.setText(p.getName());
        punteggioButton.setText(String.valueOf(p.getPunteggio()));

        nameButton.setTag(position);
        punteggioButton.setTag(position);

        return v;
    }
}
