package br.com.alb.maromba;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Aristeu da Silva Filho on 13/09/2016.
 */
public class BancoDados extends SQLiteOpenHelper {

    private static final String BANCO_DADOS = "Maromba";
    private static int VERSAO = 1;

    private SQLiteDatabase db;

    public BancoDados(Context context)
    {
        super(context, BANCO_DADOS, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE academias (id string PRIMARY KEY, razaosocial TEXT, cnpj TEXT, fone TEXT, endereco TEXT)";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
