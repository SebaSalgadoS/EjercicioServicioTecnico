package com.example.ejercicioserviciotecnico;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConexionBD extends SQLiteOpenHelper {

    public ConexionBD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL("create table revision_tecnica(codigo int primary key, patente text, documento text, fecha text, hora text , direccion text, frenos text , neumaticos text, suspension text, alineacion text, seguridad text, cinturon text, luces text, puerta text, vidrio text, escape text, gases text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
