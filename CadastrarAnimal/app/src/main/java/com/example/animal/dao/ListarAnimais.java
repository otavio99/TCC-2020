package com.example.animal.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.main.dao.BancoFazendaHelper;

public class ListarAnimais {

    public Cursor listar(Context contexto){


        BancoFazendaHelper dbHelper = new BancoFazendaHelper(contexto.getApplicationContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        //consulta para retornar os dados da tabela
        String sql = "SELECT * from " + AnimalContract.AnimalEntry.TABLE_NOME;
        SQLiteDatabase db2 = dbHelper.getReadableDatabase();
        Cursor cursor = db2.rawQuery(sql, null);


        /*vai ficar andando de linha em linha enquanto houver resultado
        while (cursor.moveToNext()) {
            // caminhando pelo conteúdo e atribuindo
            String texto = cursor.getString(cursor.getColumnIndex("nome"));
            int duracao = Toast.LENGTH_SHORT;

            //passando para o toast
            Toast toast = Toast.makeText(contexto.getApplicationContext(), texto,duracao);
            toast.show();
        }
        cursor.close();*/
        return cursor;

    }

}
