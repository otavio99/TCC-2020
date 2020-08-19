package com.example.fazenda.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.animal.activity.ListarAnimaisActivity;
import com.example.bebedouro.activity.ListarBebedouroActivity;
import com.example.main.R;

public class MostrarFazendaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar_fazenda);


        String nome="";

        long id=  getIntent().getExtras().getLong("id");
        Button btcaminho= (Button) findViewById(R.id.btAnimal);
        Context contexto = getApplicationContext();
        btcaminho.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(contexto, ListarAnimaisActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

        Button btcaminhoBebedouro= (Button) findViewById(R.id.btBebedouro);
        btcaminhoBebedouro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(contexto, ListarBebedouroActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });








    }


}
