package com.example.ricetteculinarie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Ricetta> {
    private LayoutInflater inflater;

    public CustomAdapter(Context context, int resourceId, List<Ricetta> objects){
        super(context, resourceId, objects);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View v, ViewGroup parent){
        if(v == null){
            v = inflater.inflate(R.layout.list_element, null);
        }

        Ricetta r = getItem(position);

        Button
    }
}
