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

import java.util.List;

import io.objectbox.Box;

public class MainActivity extends AppCompatActivity {
    private   List<Fazenda> fazendasLista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    }


    public void onItemClick(AdapterView<?> l, View v, int position, long id) {
        Intent intent = new Intent();
        intent.setClass(this, MostrarFazendaActivity.class);
        intent.putExtra("id", id);
        // Or / And
        //sem essas tres linhas esta dando o erro do id
        //int idInt= Integer.parseInt(Long.toString(id));

       // Fazenda fazenda= fazendasLista.get(idInt);
        startActivity(intent);
    }



    // TODO: FAZER FUNCIONAR O CADASTRAR DO BEBEDOURO E LISTAR
    //TODO: RELACIONAMENTO DOS ANIMAIS E DOS BEBEDOUROS COM A FAZENDA
        //TODO: Mandar um dado para a proxima janela

    //TODO: CALCULAR A DISPONIBILIDADE DE ÁGUA DOS BEBEDOUROS
    //TODO: BEBEDOURO NÃO ESTÁ LISTANDO, CONFERIR!
    //TODO: PLANÍCIE E PLANALTO ACTIVITY MAIN
    //TODO: CALCULAR A NECESSIDADE TOTAL DE ÁGUA PARA OS ANIMAIS

}





