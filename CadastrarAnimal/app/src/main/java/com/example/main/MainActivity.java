package com.example.main;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.animal.activity.CadastrarAnimalActivity;
import com.example.animal.dao.ListarAnimais;

import java.util.ArrayList;
import java.util.List;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (new ListarAnimais().listar(this).getCount() <= 0) {
            Intent intent = new Intent(this, CadastrarAnimalActivity.class);
            startActivity(intent);

        }

        // TODO: IMPLEMENTAR CRIAÇÃO DA TABELA DO BEBEDOURO
        // TODO: IMPLEMENTAR CADASTRO DO BEBEDOURO

        List<String> resultados = new ArrayList();
        Cursor cursor =  new ListarAnimais().listar(this);

        while (cursor.moveToNext()) {
            // caminhando pelo conteúdo e atribuindo
            String nome = cursor.getString(cursor.getColumnIndex("nome"));
            int quantidade = Integer.parseInt(cursor.getString(cursor.getColumnIndex("quantidade")));
            resultados.add( "Nome: "+ nome +" Quantidade: " + quantidade );
        }


        ListView listaView = (ListView) findViewById(R.id.lista);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, resultados );
        listaView.setAdapter(adapter);
        cursor.close();

    }

}






