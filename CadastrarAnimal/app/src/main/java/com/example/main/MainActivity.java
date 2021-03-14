package com.example.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fazenda.activity.CadastrarFazendaActivity;
import com.example.fazenda.activity.MostrarFazendaActivity;
import com.example.fazenda.dao.Fazenda;

import java.util.List;

import io.objectbox.Box;

public class MainActivity extends AppCompatActivity {
    private   List<Fazenda> fazendasLista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Box<Fazenda> fazendaBox = ObjectBox.get().boxFor(Fazenda.class);
        fazendasLista = fazendaBox.getAll();
        Intent intent = new Intent(this, CadastrarFazendaActivity.class);
        if (fazendasLista.size()  <= 0) {
            startActivity(intent);
        }

        ListView listaView = (ListView) findViewById(R.id.lista);
        listaView.setOnItemClickListener(this::onItemClick);
        ArrayAdapter<Fazenda> adapter = new ArrayAdapter<Fazenda>(this, android.R.layout.simple_list_item_1, fazendasLista );
        listaView.setAdapter(adapter);

        FloatingActionButton cadastrar= (FloatingActionButton) findViewById(R.id.btCadastrar);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        // my_child_toolbar is defined in the layout file
        Toolbar myChildToolbar =
                (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myChildToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // oculta a seta da primeira tela
        ab.setDisplayHomeAsUpEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    public void onItemClick(AdapterView<?> l, View v, int position, long id) {
        Intent intent = new Intent();
        intent.setClass(this, MostrarFazendaActivity.class);
        Fazenda.setId_temp( fazendasLista.get(position).getId());
        // Or / And
        //sem essas tres linhas esta dando o erro do id
        //int idInt= Integer.parseInt(Long.toString(id));

       // Fazenda fazenda= fazendasLista.get(idInt);
        startActivity(intent);
    }


    //DIVERSAS ANOTAÇÕES
    // TODO: FAZER FUNCIONAR O CADASTRAR DO BEBEDOURO E LISTAR
    //TODO: RELACIONAMENTO DOS ANIMAIS E DOS BEBEDOUROS COM A FAZENDA
        //TODO: Mandar um dado para a proxima janela

    //TODO: CALCULAR A DISPONIBILIDADE DE ÁGUA DOS BEBEDOUROS
    //TODO: BEBEDOURO NÃO ESTÁ LISTANDO, CONFERIR!

    //TODO: CALCULAR A NECESSIDADE TOTAL DE ÁGUA PARA OS ANIMAIS

    //usabilidade
    //TODO: REVISAR SE ESTÁ INTUITIVO PARA O USUÁRIO
    //TODO: O QUE INCOMODA SÃO OS TIPOS DE VOLTAR QUE SURGEM E NAO SAO INTUITIVOS;
    //TODO: AS CORES TAMBÉM ESTÃO MEIO APAGADAS NAO COMBINAM

    //PRÓXIMO
    //TODO: PLANÍCIE E PLANALTO ACTIVITY MAIN

}





