package com.example.main;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.animal.activity.ListarAnimaisActivity;
import com.example.fazenda.activity.CadastrarFazendaActivity;
import com.example.fazenda.activity.MostrarFazendaActivity;
import com.example.fazenda.dao.ListarFazendas;

import java.util.ArrayList;
import java.util.List;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Condição para mudar a tela, caso não haja conteúdo cadastrado na lista
        //vai abrir o cadastrar se não vai para a tela do listar.
        Intent intent = new Intent(this, CadastrarFazendaActivity.class);
        if (new ListarFazendas().listar(this).getCount() <= 0) {

            startActivity(intent);

        }

        //criando uma lista para ser utilizada mais pra frente para adicionar os objetos do tipo animal
        List<String> resultados = new ArrayList();

        //cursor sendo criado para auxiliar ao percorrer a lista de animais
        Cursor cursor =  new ListarFazendas().listar(this);

        //aqui percorremos o conteúdo de cursor, que no caso possui a consulta retornada pelo listar
        while (cursor.moveToNext()) {
            // atribuindo para as variáveis os parametros correpondentes para serem adicionados na lista resultad
            String nome = cursor.getString(cursor.getColumnIndex("nome"));
            resultados.add( "Nome: "+ nome);
        }

        //instanciando uma listView para ser conectada a lista da activity main
        ListView listaView = (ListView) findViewById(R.id.lista);
        listaView.setOnItemClickListener(this::onItemClick);

        //adapter necessário para passar a forma de que será adionado o conteúdo como a seguir, em simple_list_item_1
        //possui dados de um  text view e também é passado a lista de resultados que possui os objetos cadastrados
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, resultados );
        // listView setando o adapter que será demonstrado na tela
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
        intent.setClass(this, MostrarFazendaActivity.class);
        intent.putExtra("position", position);
        // Or / And
        intent.putExtra("id", id);
        startActivity(intent);
    }




    // TODO: ARRUMAR O MOSTRAR FAZENDA ACTIVITY FAZER FUNCIONAR O CADASTRAR DO BEBEDOURO E LISTAR
    //TODO: RELACIONAMENTO DOS ANIMAIS E DOS BEBEDOUROS COM A FAZENDA
        //TODO: Mandar um dado para a proxima janela

    //TODO: CALCULAR A DISPONIBILIDADE DE ÁGUA DOS BEBEDOUROS
    //TODO: BEBEDOURO NÃO ESTÁ LISTANDO, CONFERIR!
    //TODO: PLANÍCIE E PLANALTO ACTIVITY MAIN
    //TODO: CALCULAR A NECESSIDADE TOTAL DE ÁGUA PARA OS ANIMAIS

}





