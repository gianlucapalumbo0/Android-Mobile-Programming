package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView dp;
    private TextView ds;
    private TextView dm;
    private TextView dop;

    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;

    private Button buttonC;
    private Button buttonMC;
    private Button buttonMS;
    private Button buttonMR;
    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonMult;
    private Button buttonDiv;
    private Button buttonEqual;
    private Button buttonDot;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //display
        dp = (TextView) findViewById(R.id.diplay_principale);
        ds = (TextView) findViewById(R.id.display_secondario);
        dm = (TextView) findViewById(R.id.display_memoria);
        dop = (TextView) findViewById(R.id.display_operazione);

        if (savedInstanceState != null) {
            dp.setText(savedInstanceState.getString("DisplayP"));
            ds.setText(savedInstanceState.getString("DisplayS"));
            dm.setText(savedInstanceState.getString("DisplayM"));
            dop.setText(savedInstanceState.getString("DisplayOp"));
        }

        //pulsanti numerici
        button0 = (Button) findViewById(R.id.button_0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                mostra_secondario('0');
            }
        });

        button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostra_secondario('1');
            }
        });

        button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostra_secondario('2');
            }
        });

        button3 = (Button) findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostra_secondario('3');
            }
        });

        button4 = (Button) findViewById(R.id.button_4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostra_secondario('4');
            }
        });

        button5 = (Button) findViewById(R.id.button_5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostra_secondario('5');
            }
        });

        button6 = (Button) findViewById(R.id.button_6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostra_secondario('6');
            }
        });

        button7 = (Button) findViewById(R.id.button_7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostra_secondario('7');
            }
        });

        button8 = (Button) findViewById(R.id.button_8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostra_secondario('8');
            }
        });

        button9 = (Button) findViewById(R.id.button_9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostra_secondario('9');
            }
        });



        buttonPlus = (Button) findViewById(R.id.button_Plus);
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostra_operazione('+');
            }
        });

        buttonMinus = (Button) findViewById(R.id.button_Minus);
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostra_operazione('-');
            }
        });

        buttonMult = (Button) findViewById(R.id.button_Multi);
        buttonMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostra_operazione('*');
            }
        });

        buttonDiv = (Button) findViewById(R.id.button_Div);
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostra_operazione('/');
            }
        });

        buttonEqual = (Button) findViewById(R.id.button_Equal);
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float op1 = Float.parseFloat(dp.getText().toString());
                float op2 = Float.parseFloat(ds.getText().toString());
                char operazione = dop.getText().toString().charAt(0);

                float res = 0;
                switch (operazione){
                    case '+' : res = op1 + op2;
                        break;

                    case '-' : res = op1 - op2;
                        break;

                    case '*' : res = op1 * op2;
                        break;

                    case '/' : res = op1 / op2;
                        break;
                }

                dp.setText("");
                ds.setText(Float.toString(res));
                dop.setText("");

            }
        });

        buttonDot = (Button) findViewById(R.id.button_Dot);
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ds.getText().toString().contains(".") || (ds.getText().toString().length() == 0)){
                    //non fare niente
                }
                else{
                    ds.setText(ds.getText().toString() + ".");
                }
            }
        });

        //pulsanti speciali
        buttonC = (Button) findViewById(R.id.button_C);
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dp.setText("");
                ds.setText("");
                dop.setText("");
            }
        });

        buttonMC = (Button) findViewById(R.id.button_MC);
        buttonMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dm.setText("");
            }
        });

        buttonMS = (Button) findViewById(R.id.button_MS);
        buttonMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dm.setText(ds.getText().toString());
            }
        });

        buttonMR = (Button) findViewById(R.id.button_MR);
        buttonMR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ds.setText(dm.getText().toString());
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putString("DisplayP", dp.getText().toString());
        savedInstanceState.putString("DisplayS", ds.getText().toString());
        savedInstanceState.putString("DisplayM", dm.getText().toString());
        savedInstanceState.putString("DisplayOp", dop.getText().toString());


        super.onSaveInstanceState(savedInstanceState);
    }

    private void mostra_secondario(char digit){
        String str_displaysec = ds.getText().toString();
        String str_da_mostrare = str_displaysec + digit;
        ds.setText(str_da_mostrare);
    }

    private void mostra_operazione(char digit){
        String cifra_digit = ds.getText().toString();
        dp.setText(cifra_digit);
        dop.setText(String.valueOf(digit));
        ds.setText("");
    }
}