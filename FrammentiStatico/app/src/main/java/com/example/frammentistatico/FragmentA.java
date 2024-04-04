package com.example.frammentistatico;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import kotlin.OverloadResolutionByLambdaReturnType;

public class FragmentA extends Fragment {

    public FragmentA(){
        //richiesto costruttore pubblico
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_a, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle s){
        super.onActivityCreated(s);
    }

    @Override
    public void onStart(){
        super.onStart();
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onPause(){
        super.onPause();
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    @Override
    public void onDetach(){
        super.onDetach();
    }
}
