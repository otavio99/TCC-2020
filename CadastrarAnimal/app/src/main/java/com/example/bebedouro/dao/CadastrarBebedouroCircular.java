package com.example.bebedouro.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;

import com.example.animal.dao.AnimalContract;
import com.example.main.dao.BancoFazendaHelper;

public class CadastrarBebedouroCircular {


    public void cadastrarBebedouroCircular(Context contexto, EditText raio, EditText vazao) {
        BancoFazendaHelper dbHelper = new BancoFazendaHelper(contexto.getApplicationContext());
        //o objeto helper retorna um objeto de acesso ao banco sqlite
        SQLiteDatabase db = dbHelper.getWritableDatabase();


    }


}

