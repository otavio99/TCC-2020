package com.example.main.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.animal.dao.AnimalContract;
import com.example.bebedouro.dao.BebedouroCircularContract;
import com.example.bebedouro.dao.BebedouroContract;
import com.example.bebedouro.dao.BebedouroRetangularContract;
import com.example.fazenda.dao.FazendaContract;

public class BancoFazendaHelper extends SQLiteOpenHelper  {

    //dados simples com variáveis constantes para criar a tabela
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "BancoAnimais.db";

    //MUDAR ENTRIES PARA ANIMAL
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + AnimalContract.AnimalEntry.TABLE_NOME+ " (" +
                    AnimalContract.AnimalEntry._ID + " INTEGER PRIMARY KEY," +
                    AnimalContract.AnimalEntry.COLUMN_NOME + " TEXT,"+
                    AnimalContract.AnimalEntry.COLUMN_QUANTIDADE+" INTEGER)";

    private static final String SQL_CREATE_FAZENDA=
            "CREATE TABLE " + FazendaContract.FazendaEntry.TABLE_NOME+ " (" +
                    FazendaContract.FazendaEntry._ID + " INTEGER PRIMARY KEY," +
                    FazendaContract.FazendaEntry.COLUMN_NOME + " TEXT)";

    private static final String SQL_CREATE_BEBEDOURO=
            "CREATE TABLE " + BebedouroContract.BebedouroEstrutura.TABLE_NOME+ " (" +
                    BebedouroContract.BebedouroEstrutura._ID + " INTEGER PRIMARY KEY," +
                    BebedouroContract.BebedouroEstrutura.COLUMN_ALTURA + " TEXT,"+
                    BebedouroContract.BebedouroEstrutura.COLUMN_CONDICAOACESSO+" TEXT,"+
                    BebedouroContract.BebedouroEstrutura.COLUMN_LIMPEZA+" TEXT"+")";


    private static final String SQL_CREATE_BEBEDOUROCIRCULAR= String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s integer references %s(%s))", BebedouroCircularContract.BebedouroEstruturaCircular.TABLE_NOME,
                     BebedouroCircularContract.BebedouroEstruturaCircular._ID,
                     BebedouroCircularContract.BebedouroEstruturaCircular.COLUMN_RAIO,
                     BebedouroCircularContract.BebedouroEstruturaCircular.COLUMN_VAZAO,
                     BebedouroCircularContract.BebedouroEstruturaCircular.COLUMN_ID_BEBEDOURO,
                     BebedouroContract.BebedouroEstrutura.TABLE_NOME,
                     BebedouroContract.BebedouroEstrutura._ID
                     );

    private static final String SQL_CREATE_BEBEDOURORETANGULAR=
            "CREATE TABLE " + BebedouroRetangularContract.BebedouroEstruturaRetangular.TABLE_NOME+ " (" +
                    BebedouroRetangularContract.BebedouroEstruturaRetangular._ID + " INTEGER PRIMARY KEY," +
                    BebedouroRetangularContract.BebedouroEstruturaRetangular.COLUMN_COMPRIMENTO+ " TEXT,"+
                    BebedouroRetangularContract.BebedouroEstruturaRetangular.COLUMN_LARGURA+" TEXT)";


    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FazendaContract.FazendaEntry.TABLE_NOME;

    //construtor da classe
    public BancoFazendaHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    //comando para chamar a criação do banco
    // ESTA CLASSE NAO ESTAVA CONSEGUINDO VER O COMANDO SQL_CREATE DO CRIARBANCO POR ESTAR PRIVATE, MUDEI E DEU!?
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
        db.execSQL(SQL_CREATE_FAZENDA);
        db.execSQL(SQL_CREATE_BEBEDOURO);
        db.execSQL(SQL_CREATE_BEBEDOUROCIRCULAR);
        db.execSQL(SQL_CREATE_BEBEDOURORETANGULAR);

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



