package com.example.animal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.animal.dao.Animal;
import com.example.animal.dao.AnimalDao;
import com.example.animal.dao.DaoMaster;
import com.example.animal.dao.DaoSession;
import com.example.main.MainActivity;
import com.example.main.R;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.Query;

public class CadastrarAnimalActivity extends AppCompatActivity {

    private Query<Animal> animaisQuery;
    private Animal animal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar_animal);

        String nome="";
        int quantidade=0;

        Button salvar= (Button) findViewById(R.id.btSalvar);

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "fazenda-db", null);

        Database db = helper.getWritableDb();

        DaoSession daoSession = new DaoMaster(db).newSession();

        salvar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText nomeedt = (EditText) findViewById(R.id.edtAnimal);
                EditText quantidadeedt = (EditText) findViewById(R.id.edtRaio);


                animal = new Animal( nomeedt.getText().toString(),  Integer.parseInt(quantidadeedt.getText().toString()));


                AnimalDao animalDao = daoSession.getAnimalDao();

                animalDao.insert(animal);

                Log.d("DaoExample", "Inserted animal: " + animal.getNome());
                // query all notes, sorted a-z by their text
                animaisQuery = animalDao.queryBuilder().build();

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
