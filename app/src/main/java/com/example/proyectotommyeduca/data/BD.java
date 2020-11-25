package com.example.proyectotommyeduca.data;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BD extends SQLiteOpenHelper{
    private static String NAME = "bd_Videos";
    private static int VERSION = 1;
    private final String tabla_colegio = "create table colegio(colegio_id integer primary key autoincrement, " +
                                         "colegio_nombre text, latitud float, longitud float)";
    /*      Colegio
     *private int colegio_id;
     *private  String colegio_nombre;
     *private float latitud, longitud;
     */
    private final String tabla_video = "CREATE TABLE video(" +
            "video_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "video_titulo TEXT," +
            "colegio_id_fk INT ," +
            "codigo TEXT ," +
            "descripcion TEXT)";

    public BD(Context context) {
        super(context, NAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla_colegio);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



}
