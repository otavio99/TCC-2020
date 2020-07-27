package com.example.fazenda.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;

import com.example.main.dao.BancoFazendaHelper;

public class CadastrarFazenda {



    public void cadastrarFazendas(Context contexto, EditText nomeedt) {
        BancoFazendaHelper dbHelper = new BancoFazendaHelper(contexto.getApplicationContext());

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FazendaContract.FazendaEntry.COLUMN_NOME, nomeedt.getText().toString());



        long newRowId = db.insert(FazendaContract.FazendaEntry.TABLE_NOME, null, values);
    }

}

