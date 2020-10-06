package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class FutebolJogoActivity extends AppCompatActivity {

    private TextView recebeTempo;

    private TextView nomeTime1;
    private TextView nomeTime2;

    private TextView txtGolTime1;
    private TextView txtGolTime2;
    private TextView txtFaltaTime1;
    private TextView txtFaltaTime2;

    private Button buttonGolTime1;
    private Button buttonGolTime2;
    private Button buttonFaltaTime1;
    private Button buttonFaltaTime2;

    private int contaGol1 = 0;
    private int contaGol2 = 0;
    private int contaFalta1 = 0;
    private int contaFalta2 = 0;

    private long mComecaTempo;

    private CountDownTimer tempoRecebido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_futebol_jogo);

        recebeTempo = findViewById(R.id.textViewTempo);

        nomeTime1 = findViewById(R.id.textViewTime1);
        nomeTime2 = findViewById(R.id.textViewTime2);

        txtGolTime1 = findViewById(R.id.textViewGolTime1);
        txtGolTime2 = findViewById(R.id.textViewGolTime2);
        txtFaltaTime1 = findViewById(R.id.textViewFaltaTime1);
        txtFaltaTime2 = findViewById(R.id.textViewFaltaTime2);

        buttonGolTime1 = findViewById(R.id.buttonGolTime1);
        buttonGolTime2 = findViewById(R.id.buttonGolTime2);
        buttonFaltaTime1 = findViewById(R.id.buttonFaltaTime1);
        buttonFaltaTime2 = findViewById(R.id.buttonFaltaTime2);


        buttonGolTime1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementaGol1();
            }
        });

        buttonGolTime2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementaGol2();
            }
        });

        buttonFaltaTime1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementaFalta1();
            }
        });

        buttonFaltaTime2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementFalta2();
            }
        });

        final int tempoDefinido = 60000;
        tempoRecebido = new CountDownTimer(tempoDefinido,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int minutos = (tempoDefinido/1000)/60;
                int segundos = (tempoDefinido/1000)%60;
                String recebeTempoFormatado = String.format(Locale.getDefault(), "%02d:%02d", minutos, segundos);
                recebeTempo.setText(recebeTempoFormatado);
            }

            @Override
            public void onFinish() {
            return;
            }
        }.start();

        //recebe a intent
        Intent intent = getIntent();

        //recupera o texto da intent
        String time1 = intent.getStringExtra("nomeTime1");
        String time2 = intent.getStringExtra("nomeTime2");
        String tempo = intent.getStringExtra("comecaJogo");

        //altera o TextView
        nomeTime1.setText(time1);
        nomeTime2.setText(time2);
        recebeTempo.setText(tempo);
    }
    private void incrementaTempo(){

    }
    private void incrementaGol1(){
        contaGol1++;
        txtGolTime1.setText(" "+contaGol1+" ");
    }
    private void incrementaGol2(){
        contaGol2++;
        txtGolTime2.setText(" "+contaGol2+" ");
    }private void incrementaFalta1(){
        contaFalta1++;
        txtFaltaTime1.setText(" "+contaFalta1+" ");
    }private void incrementFalta2(){
        contaFalta2++;
        txtFaltaTime2.setText(" "+contaFalta2+" ");
    }
}
