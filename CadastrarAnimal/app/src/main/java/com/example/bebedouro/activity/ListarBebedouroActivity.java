package com.example.bebedouro.activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.animal.activity.CadastrarAnimalActivity;
import com.example.animal.dao.ListarAnimais;
import com.example.bebedouro.dao.ListarBebedouros;
import com.example.main.R;

import java.util.ArrayList;
import java.util.List;

public class ListarBebedouroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_bebedouro);


        Intent intent = new Intent(this, CadastrarBebedouroActivity.class);
        if (new ListarBebedouros().listar(this).getCount() <= 0) {

            startActivity(intent);

        }

        List<String> resultados = new ArrayList();


        Cursor cursor =  new ListarBebedouros().listar(this);


        while (cursor.moveToNext()) {
            String nome = cursor.getString(cursor.getColumnIndex("nome"));
            int quantidade = Integer.parseInt(cursor.getString(cursor.getColumnIndex("quantidade")));
            resultados.add( "Nome: "+ nome +" Quantidade: " + quantidade );
        }

        ListView listaView = (ListView) findViewById(R.id.lista);
        listaView.setOnItemClickListener(this::onItemClick);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, resultados );

        listaView.setAdapter(adapter);
        cursor.close();

        FloatingActionButton cadastrar= (FloatingActionButton) findViewById(R.id.btCadastrar);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intent);
            }
        });

    }

    public void onItemClick(AdapterView<?> l, View v, int position, long id) {
        Intent intent = new Intent();
        intent.setClass(this, CadastrarBebedouroActivity.class);
        intent.putExtra("position", position);
        // Or / And
        intent.putExtra("id", id);
        startActivity(intent);
    }

    //TODO: PRIMEIRO LISTAR E CADASTRAR A APARECER DEVE SER O DA FAZENDA
    //TODO: LISTAR OS BEBEDOUROS E NESSA TELA MOSTRAR UM BOTÃO CADASTRO
    //TODO: PLANÍCIE E PLANALTO ACTIVITY MAIN

}





