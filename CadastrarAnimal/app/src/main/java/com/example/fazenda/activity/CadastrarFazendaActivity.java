package com.example.fazenda.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fazenda.dao.Fazenda;
import com.example.main.MainActivity;
import com.example.main.R;
import com.example.main.dao.ObjectBox;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class CadastrarFazendaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar_fazenda);

        String nome="";

        BoxStore boxStore = ObjectBox.get();

        Box<Fazenda> fazendaBox = boxStore.boxFor(Fazenda.class);

        Button salvar= (Button) findViewById(R.id.btSalvar);
        salvar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText nomeedt = (EditText) findViewById(R.id.edtFazenda);

                Fazenda fazenda = new Fazenda(nomeedt.getText().toString());
                fazendaBox.put(fazenda);

            }
        });

        Intent intent = new Intent(this, MainActivity.class);
        Button voltar= (Button) findViewById(R.id.btVoltar);
        voltar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intent);
            }
        });

    }

    }



