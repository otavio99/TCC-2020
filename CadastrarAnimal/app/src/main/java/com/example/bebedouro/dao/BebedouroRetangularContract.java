package com.example.bebedouro.dao;

import android.provider.BaseColumns;

public final class BebedouroRetangularContract {
    private BebedouroRetangularContract() {}

    public static class BebedouroEstruturaRetangular implements BaseColumns {
        public static final String TABLE_NOME = "bebedouro_retangular";
        public static final String COLUMN_COMPRIMENTO = "comprimento";
        public static final String COLUMN_LARGURA = "largura";
        public static final String COLUMN_ID_BEBEDOURO = "id_bebedouro";

        /* public static final String COLUMN_NAME_SUBTITLE = "subtitle";*/
    }


}
