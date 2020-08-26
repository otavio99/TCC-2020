package com.example.animal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bebedouro.activity.CadastrarBebedouroActivity;
import com.example.fazenda.dao.Fazenda;
import com.example.main.R;
import com.example.main.dao.ObjectBox;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class ListarAnimaisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_animal);

        BoxStore  boxStore = ObjectBox.get();

        Box<Fazenda> fazendaBox = boxStore.boxFor(Fazenda.class);

        long  id=  getIntent().getExtras().getLong("id");
        int duracao = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(getApplicationContext(),"id: "+ id,duracao);
        toast.show();

        List<Fazenda> fazendas = fazendaBox.getAll();
        //Fazenda fazenda= fazendaBox.get(id);

        //fazenda.animais.reset();
        //List<Animal>animaisLista= fazenda.animais;

        //Condição para mudar a tela, caso não haja conteúdo cadastrado na lista
        //vai abrir o cadastrar se não vai para a tela do listar.
        Intent intent = new Intent(this, CadastrarAnimalActivity.class);

        if (0 <= 0) {
            intent.putExtra("id", id);
            startActivity(intent);

        }

        //instanciando uma listView para ser conectada a lista da activity main
        ListView listaView = (ListView) findViewById(R.id.lista);
        listaView.setOnItemClickListener(this::onItemClick);

        //adapter necessário para passar a forma de que será adionado o conteúdo como a seguir, em simple_list_item_1
        //possui dados de um  text view e também é passado a lista de resultados que possui os objetos cadastrados
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList() );
        // listView setando o adapter que será demonstrado na tela
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
        intent.putExtra("position", position);
        // Or / And
        intent.putExtra("id", id);
        startActivity(intent);
    }

    //TODO: PRIMEIRO LISTAR E CADASTRAR A APARECER DEVE SER O DA FAZENDA
    //TODO: LISTAR OS BEBEDOUROS E NESSA TELA MOSTRAR UM BOTÃO CADASTRO
    //TODO: PLANÍCIE E PLANALTO ACTIVITY MAIN

}





