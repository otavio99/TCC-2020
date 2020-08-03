package com.example.bebedouro.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;

import com.example.animal.dao.AnimalContract;
import com.example.main.dao.BancoFazendaHelper;

public class CadastrarBebedouroRetangular {


    public void cadastrarBebedouro(Context contexto, EditText comprimentoedt, EditText larguraedt) {
        BancoFazendaHelper dbHelper = new BancoFazendaHelper(contexto.getApplicationContext());

        SQLiteDatabase db = dbHelper.getWritableDatabase();


        ContentValues values = new ContentValues();

        int comprimento = Integer.parseInt(comprimentoedt.getText().toString());
        values.put(BebedouroRetangularContract.BebedouroEstruturaRetangular.COLUMN_COMPRIMENTO, comprimento);

        int largura = Integer.parseInt(larguraedt.getText().toString());
        values.put(BebedouroRetangularContract.BebedouroEstruturaRetangular.COLUMN_LARGURA, largura);


        long newRowId = db.insert(BebedouroRetangularContract.BebedouroEstruturaRetangular.TABLE_NOME, null, values);
    }
}
/*
*       public static final String TABLE_NOME = "bebedouro";
        public static final String COLUMN_ALTURA = "altura";
        public static final String COLUMN_LIMPEZA = "limpeza";
        public static final String COLUMN_CONDICAOACESSO= "condincaoAcesso";
*
* */
