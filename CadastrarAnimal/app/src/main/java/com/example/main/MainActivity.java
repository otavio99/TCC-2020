package com.example.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.fazenda.activity.CadastrarFazendaActivity;
import com.example.fazenda.activity.MostrarFazendaActivity;
import com.example.fazenda.dao.Fazenda;
import com.example.main.dao.ObjectBox;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class MainActivity extends AppCompatActivity {
    private   List<Fazenda> fazendasLista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BoxStore boxStore = ObjectBox.getApp().get();

        Box<Fazenda> fazendaBox = boxStore.boxFor(Fazenda.class);

        fazendasLista = fazendaBox.getAll();

        Intent intent = new Intent(this, CadastrarFazendaActivity.class);
        if (fazendasLista.size()  <= 0) {

            startActivity(intent);

        }

        List<String> resultados = new ArrayList();

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

    }


    public void onItemClick(AdapterView<?> l, View v, int position, long id) {
        Intent intent = new Intent();
        intent.setClass(this, MostrarFazendaActivity.class);
        intent.putExtra("position", position);
        // Or / And

        int idInt= Integer.parseInt(Long.toString(id));

        Fazenda fazenda= fazendasLista.get(idInt);
        intent.putExtra("id", fazenda.id);
        startActivity(intent);
    }






    //TODO: PESQUISAR ORM VS SQLITE PURO


    //TODO: FAZER O JOIN DE BEBEDOURO COM BEBEDOURO RETANGULAR/CIRCULAR
    //TODO: SITUAÇÃO DE HERANÇA NO CÓDIGO JAVA RELACIONADO A BEBEDOURO E ESPECIALIDADES


    // TODO: FAZER FUNCIONAR O CADASTRAR DO BEBEDOURO E LISTAR
    //TODO: RELACIONAMENTO DOS ANIMAIS E DOS BEBEDOUROS COM A FAZENDA
        //TODO: Mandar um dado para a proxima janela

    //TODO: CALCULAR A DISPONIBILIDADE DE ÁGUA DOS BEBEDOUROS
    //TODO: BEBEDOURO NÃO ESTÁ LISTANDO, CONFERIR!
    //TODO: PLANÍCIE E PLANALTO ACTIVITY MAIN
    //TODO: CALCULAR A NECESSIDADE TOTAL DE ÁGUA PARA OS ANIMAIS

}





