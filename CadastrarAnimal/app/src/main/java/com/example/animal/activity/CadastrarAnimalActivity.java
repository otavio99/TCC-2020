package com.example.animal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.animal.dao.CadastrarAnimal;
import com.example.main.MainActivity;
import com.example.main.R;

public class CadastrarAnimalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar_animal);


        String nome="";
        int quantidade=0;

        Button salvar= (Button) findViewById(R.id.btSalvar);
        salvar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText nomeedt = (EditText) findViewById(R.id.edtAnimal);
                EditText quantidadeedt = (EditText) findViewById(R.id.edtRaio);
                new CadastrarAnimal().cadastrarAnimais(getApplicationContext(), nomeedt, quantidadeedt);

            }
        });

        Intent intent = new Intent(this, MainActivity.class);
        Button voltar= (Button) findViewById(R.id.btVoltar);
        voltar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intent);
            }
        });






    }


}
