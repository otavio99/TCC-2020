package com.example.fazenda.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.animal.dao.CadastrarAnimal;
import com.example.fazenda.dao.CadastrarFazenda;
import com.example.main.MainActivity;
import com.example.main.R;

public class CadastrarFazendaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar_fazenda);


        String nome="";


        Button salvar= (Button) findViewById(R.id.btSalvar);
        salvar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText nomeedt = (EditText) findViewById(R.id.edtFazenda);
                new CadastrarFazenda().cadastrarFazendas(getApplicationContext(), nomeedt);

            }
        });







    }


}
