/* Si consideri il LinearLayout indicato in figura. Si costruisca tale layout utilizzando un file statico che specifica i primi 2 pulsanti
ed inserendoo dinamicamente il terzo pulsante.
 */

package com.example.buttonprogrammatico;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout container = findViewById(R.id.container);

        Button pulsante3 = new Button(getApplicationContext());
        pulsante3.setText("Pulsante3");
        pulsante3.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        container.addView(pulsante3);
    }
}