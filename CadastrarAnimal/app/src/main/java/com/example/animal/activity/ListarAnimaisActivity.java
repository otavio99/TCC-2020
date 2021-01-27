package com.example.animal.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.animal.dao.Animal;
import com.example.bebedouro.activity.CadastrarBebedouroActivity;
import com.example.fazenda.dao.Fazenda;
import com.example.main.MainActivity;
import com.example.main.ObjectBox;
import com.example.main.R;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class ListarAnimaisActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_animal);

        BoxStore  boxStore = ObjectBox.get();

        Box<Animal> animalBox = boxStore.boxFor(Animal.class);

        long  id=  getIntent().getExtras().getLong("id");
        int duracao = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(getApplicationContext(),"id: "+ id,duracao);
        toast.show();

        List<Animal> animais = animalBox.getAll();
        //animais.removeIf( obj -> obj.fazendaToOne.getTargetId() != Fazenda.getId_temp());

        //Condição para mudar a tela, caso não haja conteúdo cadastrado na lista
        //vai abrir o cadastrar se não vai para a tela do listar.
        Intent intent = new Intent(this, CadastrarAnimalActivity.class);
        intent.putExtra("id", id);
        if (animais.size() <= 0) {
            startActivity(intent);

        }

        //instanciando uma listView para ser conectada a lista da activity main
        ListView listaView = (ListView) findViewById(R.id.lista);
        listaView.setOnItemClickListener(this::onItemClick);

        //adapter necessário para passar a forma de que será adionado o conteúdo como a seguir, em simple_list_item_1
        //possui dados de um  text view e também é passado a lista de resultados que possui os objetos cadastrados
        ArrayAdapter<Animal> adapter = new ArrayAdapter<Animal>(this, android.R.layout.simple_list_item_1, animais );
        // listView setando o adapter que será demonstrado na tela
        listaView.setAdapter(adapter);


        FloatingActionButton cadastrar= (FloatingActionButton) findViewById(R.id.btCadastrar);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        Intent intent2 = new Intent(this, MainActivity.class);
        intent.putExtra("id",id);
        Button voltar= (Button) findViewById(R.id.btVoltar);
        voltar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intent2);
            }
        });


    }

    //Mudar para mostrar
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





