package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEditTextTempo;
    private Button mButtonComecar;

    private EditText mEditTextTime1;
    private EditText mEditTextTime2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextTempo = findViewById(R.id.editTextTempo);
        mButtonComecar = findViewById(R.id.buttonComecar);

        mEditTextTime1 = findViewById(R.id.editTextTime1);
        mEditTextTime2 = findViewById(R.id.editTextTime2);



        mButtonComecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Começou a Partida!", Toast.LENGTH_LONG).show();

                String time1 = mEditTextTime1.getText().toString();
                String time2 = mEditTextTime2.getText().toString();
                double cEditTextTempo = Double.parseDouble(mEditTextTempo.getText().toString());
                double calculoTempo = cEditTextTempo * 60000;

                Intent intent = new Intent(getApplicationContext(), FutebolJogoActivity.class);
//                Intent intent = new Intent(MainActivity.this,MensagemActivity.class); >> funciona da mesma forma

                intent.putExtra("nomeTime1", time1);
                intent.putExtra("nomeTime2", time2);
                intent.putExtra("comecaJogo", calculoTempo);

                startActivity(intent);

            }
        });
    }
}
