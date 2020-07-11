package com.example.main.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.animal.dao.AnimalContract;

public class BancoFazendaHelper extends SQLiteOpenHelper  {

    //dados simples com variáveis constantes para criar a tabela
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "BancoAnimais.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + AnimalContract.AnimalEntry.TABLE_NOME+ " (" +
                    AnimalContract.AnimalEntry._ID + " INTEGER PRIMARY KEY," +
                    AnimalContract.AnimalEntry.COLUMN_NOME + " TEXT,"+
                    AnimalContract.AnimalEntry.COLUMN_QUANTIDADE+" INTEGER)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + AnimalContract.AnimalEntry.TABLE_NOME;

    //construtor da classe
    public BancoFazendaHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    //comando para chamar a criação do banco
    // ESTA CLASSE NAO ESTAVA CONSEGUINDO VER O COMANDO SQL_CREATE DO CRIARBANCO POR ESTAR PRIVATE, MUDEI E DEU!?
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //tive que deixar publico esta funçao tb p conseguir importar
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    // método para reverte3r a base de dados para uma versão antiga
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}



