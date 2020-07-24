package com.example.fazenda.dao;

import android.provider.BaseColumns;

public final class FazendaContract {
    private FazendaContract() {}

    public static class FazendaEntry implements BaseColumns {
        public static final String TABLE_NOME = "fazenda";
        public static final String COLUMN_NOME = "nome";
        /* public static final String COLUMN_NAME_SUBTITLE = "subtitle";*/
    }


}
