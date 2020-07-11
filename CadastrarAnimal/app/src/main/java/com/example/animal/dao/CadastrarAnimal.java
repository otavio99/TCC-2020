package com.example.animal.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import android.widget.EditText;
import android.content.Context;
import com.example.main.dao.BancoFazendaHelper;

public class CadastrarAnimal {

    // nessa parte estamos seguindo a documentação e passando  contexto adquirido lá na main q está invocando o
    //método cadastrar.
    public void cadastrarAnimais(Context contexto, EditText nomeedt, EditText quantidadeedt) {
        BancoFazendaHelper dbHelper = new BancoFazendaHelper(contexto.getApplicationContext());
        //o objeto helper retorna um objeto de acesso ao banco sqlite
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        //um objeto que serve para armazenar um nome de um campo e o valor a ser inserido nele
        ContentValues values = new ContentValues();
        values.put(AnimalContract.AnimalEntry.COLUMN_NOME, nomeedt.getText().toString());
        int qtd = Integer.parseInt(quantidadeedt.getText().toString());

        //o put funcionando como um set armazenando em um objeto até agora
        values.put(AnimalContract.AnimalEntry.COLUMN_QUANTIDADE, qtd);

        // values.put(AnimalEntry.COLUMN_NAME_SUBTITLE, subtitle);


        // e nesta linha aqui em baixo eu adiciono uma linha de dados no banco
        long newRowId = db.insert(AnimalContract.AnimalEntry.TABLE_NOME, null, values);
    }

}

