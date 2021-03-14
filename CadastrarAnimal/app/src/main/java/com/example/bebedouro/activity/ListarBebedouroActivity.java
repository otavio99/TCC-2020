package com.example.bebedouro.activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.widget.Toast;
import com.example.animal.activity.CadastrarAnimalActivity;
import com.example.animal.dao.Animal;
import com.example.bebedouro.dao.Bebedouro;
import com.example.fazenda.dao.Fazenda;
import com.example.main.ObjectBox;
import com.example.main.R;
import io.objectbox.Box;
import io.objectbox.BoxStore;

import java.util.ArrayList;
import java.util.List;

public class ListarBebedouroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_bebedouro);
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Toolbar myChildToolbar =
                (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myChildToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // oculta a seta da primeira tela
        ab.setDisplayHomeAsUpEnabled(true);

        BoxStore boxStore = ObjectBox.get();
        Box<Bebedouro> bebedouroBox = boxStore.boxFor(Bebedouro.class);

        ArrayList<Bebedouro> bebedouros = (ArrayList<Bebedouro>) bebedouroBox.getAll();
        ArrayList<Bebedouro> newList = new ArrayList<Bebedouro>();
        for (Bebedouro obj : bebedouros) {
            if (obj.fazendaToOne.getTargetId() == Fazenda.getId_temp()){
                newList.add(obj);
            }
        }

        //Condição para mudar a tela, caso não haja conteúdo cadastrado na lista
        //vai abrir o cadastrar se não vai para a tela do listar.
        Intent intent = new Intent(this, CadastrarBebedouroActivity.class);
        if (bebedouros.size() <= 0) {
            startActivity(intent);
        }


        ListView listaView = (ListView) findViewById(R.id.lista);
        listaView.setOnItemClickListener(this::onItemClick);


        ArrayAdapter<Bebedouro> adapter = new ArrayAdapter<Bebedouro>(this, android.R.layout.simple_list_item_1, newList );

        listaView.setAdapter(adapter);

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
        startActivity(intent);
    }



}





