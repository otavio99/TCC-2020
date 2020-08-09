package com.example.animal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.animal.dao.Animal;
import com.example.animal.dao.AnimalDao;
import com.example.animal.dao.DaoMaster;
import com.example.animal.dao.DaoSession;
import com.example.bebedouro.activity.CadastrarBebedouroActivity;
import com.example.main.R;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ListarAnimaisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_animal);
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "fazenda-db", null);

        Database db = helper.getWritableDb();

        DaoSession daoSession = new DaoMaster(db).newSession();

        AnimalDao animalDao = daoSession.getAnimalDao();


        Query <Animal> animaisQuery = animalDao.queryBuilder().build();
        List<Animal> animais = animaisQuery.list();


        //Condição para mudar a tela, caso não haja conteúdo cadastrado na lista
        //vai abrir o cadastrar se não vai para a tela do listar.
        Intent intent = new Intent(this, CadastrarAnimalActivity.class);
        if (animais.size() <= 0) {

            startActivity(intent);

        }


        List<String> resultados = new ArrayList();





        ListView listaView = (ListView) findViewById(R.id.lista);
        listaView.setOnItemClickListener(this::onItemClick);


        ArrayAdapter<Animal> adapter = new ArrayAdapter<Animal>(this, android.R.layout.simple_list_item_1, animais );

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





