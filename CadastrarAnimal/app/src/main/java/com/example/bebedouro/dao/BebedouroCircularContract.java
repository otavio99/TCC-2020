package com.example.bebedouro.dao;

import android.provider.BaseColumns;

public final class BebedouroCircularContract {
    private BebedouroCircularContract() {}

    public static class BebedouroEstruturaCircular implements BaseColumns {
        public static final String TABLE_NOME = "bebedouro_circular";
        public static final String COLUMN_RAIO = "raio";
        public static final String COLUMN_VAZAO = "vazao";

        /* public static final String COLUMN_NAME_SUBTITLE = "subtitle";*/
    }


}
