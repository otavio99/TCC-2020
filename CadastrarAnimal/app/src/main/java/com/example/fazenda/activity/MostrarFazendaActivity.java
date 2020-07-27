package com.example.fazenda.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.animal.activity.ListarAnimaisActivity;
import com.example.main.R;

public class MostrarFazendaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar_fazenda);


        String nome="";


        Button btcaminho= (Button) findViewById(R.id.btAnimal);
        Context contexto = getApplicationContext();
        btcaminho.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(contexto, ListarAnimaisActivity.class);
                intent.putExtra("id", 0);
                startActivity(intent);
            }
        });

        Button btcaminho2= (Button) findViewById(R.id.btAnimal);
        Context contexto2 = getApplicationContext();
        btcaminho2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(contexto, .class);
                intent.putExtra("id", 0);
                startActivity(intent);
            }
        });








    }


}
