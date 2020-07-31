package com.example.bebedouro.dao;

import android.provider.BaseColumns;

public final class BebedouroContract {
    private BebedouroContract() {}

    public static class BebedouroEstrutura implements BaseColumns {
        public static final String TABLE_NOME = "bebedouro";
        public static final String COLUMN_ALTURA = "altura";
        public static final String COLUMN_LIMPEZA = "limpeza";
        public static final String COLUMN_CONDICAOACESSO= "condincaoAcesso";

        /* public static final String COLUMN_NAME_SUBTITLE = "subtitle";*/
    }


}
