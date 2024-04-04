package com.example.elencoimmagini;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private Bitmap bmap;
    private ProgressBar progressBar;


    public ListView listView;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageView);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        String[] nomi = {"Montagna","Uccelli","Baia"};


        listView = (ListView)findViewById(R.id.mylistview);

        customAdapter = new CustomAdapter(this, R.layout.list_element, new ArrayList<Elemento>());

        listView.setAdapter(customAdapter);

        Elemento uno = new Elemento(nomi[0], getResources().getDrawable(R.drawable.image1));
        Elemento due = new Elemento(nomi[1], getResources().getDrawable(R.drawable.image2));
        Elemento tre = new Elemento(nomi[2], getResources().getDrawable(R.drawable.image3));
        customAdapter.add(uno);
        customAdapter.add(due);
        customAdapter.add(tre);

    }

    public void onPictureClick(View v) {
        int position = Integer.parseInt(v.getTag().toString());

        Integer img_id = 0;
        switch(position) {
            case 0:
                img_id = R.drawable.image1;
                break;
            case 1:
                img_id = R.drawable.image2;
                break;
            case 2:
                img_id = R.drawable.image3;
                break;
        }
        new LoadImageTask().execute(img_id);

    }

    public void onNameClick(View v) {
        int position = Integer.parseInt(v.getTag().toString());

        Integer img_id = 0;
        switch(position) {
            case 0:
                img_id = R.drawable.image1;
                break;
            case 1:
                img_id = R.drawable.image2;
                break;
            case 2:
                img_id = R.drawable.image3;
                break;
        }
        new LoadImageTask().execute(img_id);
    }

    class LoadImageTask extends AsyncTask<Integer, Integer, Bitmap> {

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(ProgressBar.VISIBLE);
        }

        @Override
        protected Bitmap doInBackground(Integer... img_ids) {
            // Load bitmap
            Log.d("DEBUG","index="+img_ids[0]);
            Bitmap tmp = BitmapFactory.decodeResource(getResources(), img_ids[0]);

            /* Simuliamo il ritardo */
            for (int i = 1; i < 11; i++) {
                sleep();
                publishProgress(i * 10);
            }

            return tmp;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressBar.setProgress(values[0]);
            if (values[0]>75) {
                Toast.makeText(getApplicationContext(),"Stiamo per terminare", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            progressBar.setVisibility(ProgressBar.INVISIBLE);
            progressBar.setProgress(0);
            imageView.setImageBitmap(result);
        }

        private void sleep() {
            /* Ritardo di 0,5 secondi */
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
