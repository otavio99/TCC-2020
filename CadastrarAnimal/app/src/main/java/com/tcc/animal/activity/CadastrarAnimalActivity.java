package com.tcc.animal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tcc.animal.dao.Animal;
import com.tcc.fazenda.dao.Fazenda;
import com.tcc.invernada.dao.Invernada;
import com.tcc.main.R;
import com.tcc.main.ObjectBox;

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

            long id = Invernada.getId_temp();
            Box<Invernada> invernadaBox = boxStore.boxFor(Invernada.class);
            Box<Animal> animalBox = boxStore.boxFor(Animal.class);
            Button salvar = (Button) findViewById(R.id.btSalvar);
            salvar.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    try {
                            EditText nomeedt = (EditText) findViewById(R.id.edtAnimal);
                            EditText quantidadeedt = (EditText) findViewById(R.id.edtRaio);

                            Invernada invernada = invernadaBox.get(Invernada.getId_temp());
                            Animal animal = new Animal(nomeedt.getText().toString(), Integer.parseInt(quantidadeedt.getText().toString()));
                            animal.invernada.setTarget(invernada);
                            animalBox.put(animal);


                            invernada.animais.reset();
                            invernada.animais.add(animal);
                            invernadaBox.put(invernada);
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
