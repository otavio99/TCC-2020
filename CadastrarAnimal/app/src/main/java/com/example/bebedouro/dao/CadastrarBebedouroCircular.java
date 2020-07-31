package com.example.bebedouro.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;

import com.example.animal.dao.AnimalContract;
import com.example.main.dao.BancoFazendaHelper;

public class CadastrarBebedouroCircular {


    public void cadastrarBebedouro(Context contexto, EditText raioedt, EditText vazaoedt) {
        BancoFazendaHelper dbHelper = new BancoFazendaHelper(contexto.getApplicationContext());

        SQLiteDatabase db = dbHelper.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(BebedouroCircularContract.BebedouroEstruturaCircular.COLUMN_RAIO, raioedt.getText().toString());

        int qtd = Integer.parseInt(vazaoedt.getText().toString());
        values.put(BebedouroCircularContract.BebedouroEstruturaCircular.COLUMN_VAZAO, qtd);


        long newRowId = db.insert(BebedouroCircularContract.BebedouroEstruturaCircular.TABLE_NOME, null, values);
    }

}

