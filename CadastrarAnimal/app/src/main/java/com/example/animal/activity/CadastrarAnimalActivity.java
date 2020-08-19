package com.example.animal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.animal.dao.Animal;
import com.example.fazenda.dao.Fazenda;
import com.example.main.R;
import com.example.main.dao.ObjectBox;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class CadastrarAnimalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //inicializar a tela
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar_animal);
        String nome="";
        int quantidade=0;


        BoxStore  boxStore = ObjectBox.get();

        long  id=  getIntent().getExtras().getLong("id");
        Box<Fazenda> fazendaBox = boxStore.boxFor(Fazenda.class);
        Fazenda fazenda = fazendaBox.get(id);

        Button salvar= (Button) findViewById(R.id.btSalvar);
        salvar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText nomeedt = (EditText) findViewById(R.id.edtAnimal);
                EditText quantidadeedt = (EditText) findViewById(R.id.edtRaio);

                Animal animal = new Animal(nomeedt.getText().toString(), Integer.parseInt(quantidadeedt.getText().toString()));
                fazendaBox.attach(fazenda);
                fazenda.animais.add(animal);
                fazendaBox.put(fazenda);


            }
        });

        Intent intent = new Intent(this, ListarAnimaisActivity.class);
        intent.putExtra("id",id);
        Button voltar= (Button) findViewById(R.id.btVoltar);
        voltar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intent);
            }
        });






    }


}
