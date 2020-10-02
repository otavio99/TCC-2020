package com.example.animal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.animal.dao.Animal;
import com.example.fazenda.dao.Fazenda;
import com.example.main.R;
import com.example.main.ObjectBox;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class CadastrarAnimalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = new Intent(this, ListarAnimaisActivity.class);

            //inicializar a tela
            super.onCreate(savedInstanceState);
            setContentView(R.layout.cadastrar_animal);
            String nome = "";
            int quantidade = 0;


            BoxStore boxStore = ObjectBox.get();

            long id = getIntent().getExtras().getLong("id");
            Box<Fazenda> fazendaBox = boxStore.boxFor(Fazenda.class);
            Box<Animal> animalBox = boxStore.boxFor(Animal.class);
            int duracao = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(getApplicationContext(), "id: " + id, duracao);
            toast.show();
            Button salvar = (Button) findViewById(R.id.btSalvar);
            salvar.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    try {
                            EditText nomeedt = (EditText) findViewById(R.id.edtAnimal);
                            EditText quantidadeedt = (EditText) findViewById(R.id.edtRaio);

                            Fazenda fazenda = fazendaBox.get(Fazenda.getId_temp());
                            Animal animal = new Animal(nomeedt.getText().toString(), Integer.parseInt(quantidadeedt.getText().toString()));
                            animal.fazendaToOne.setTarget(fazenda);
                            animalBox.put(animal);


                            fazenda.animais.reset();
                            fazenda.animais.add(animal);
                            fazendaBox.put(fazenda);
                            startActivity(intent);
                    }
                    catch (Exception e){
                        startActivity(intent);
                    }
                }
            });




        // my_child_toolbar is defined in the layout file
        Toolbar myChildToolbar =
                (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myChildToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

    }


}
