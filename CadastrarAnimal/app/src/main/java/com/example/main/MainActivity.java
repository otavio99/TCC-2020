package com.example.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import com.example.animal.activity.CadastrarAnimalActivity;
import com.example.animal.dao.ListarAnimais;

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


        // TODO: PARA AMANHÃ IMPLEMENTAR LÓGICA DE LISTAR
        // TODO: IMPLEMENTAR CRIAÇÃO DA TABELA DO BEBEDOURO
        // TODO: IMPLEMENTAR CADASTRO DO BEBEDOURO



    }


}
