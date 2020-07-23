package com.example.fazenda.dao;

import android.provider.BaseColumns;

public final class FazendaContract {
    private FazendaContract() {}

    // classe que contém dados fixos da tabela (nome, coluna e etc)
    public static class AnimalEntry implements BaseColumns {
        public static final String TABLE_NOME = "animal";
        public static final String COLUMN_NOME = "nome";
        public static final String COLUMN_QUANTIDADE = "quantidade";
        /* public static final String COLUMN_NAME_SUBTITLE = "subtitle";*/
    }


}
