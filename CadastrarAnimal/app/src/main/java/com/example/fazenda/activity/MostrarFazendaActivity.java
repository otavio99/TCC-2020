package com.example.fazenda.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.animal.activity.ListarAnimaisActivity;
import com.example.bebedouro.activity.ListarBebedouroActivity;
import com.example.fazenda.dao.Fazenda;
import com.example.main.MainActivity;
import com.example.main.R;

public class MostrarFazendaActivity extends AppCompatActivity {
    private long id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = new Intent(this, MainActivity.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar_fazenda);


        String nome="";
        id= Fazenda.getId_temp();
        Button btcaminho= (Button) findViewById(R.id.btAnimal);
        btcaminho.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(v.getContext(), ListarAnimaisActivity.class);
                startActivity(intent);
            }
        });

        Button btcaminhoBebedouro= (Button) findViewById(R.id.btBebedouro);
        btcaminhoBebedouro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(v.getContext(), ListarBebedouroActivity.class);
                startActivity(intent);
            }
        });



        // my_child_toolbar is defined in the layout file
        Toolbar myChildToolbar =
                (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myChildToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);






    }


}
