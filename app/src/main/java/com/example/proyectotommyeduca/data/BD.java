package com.example.proyectotommyeduca.data;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.proyectotommyeduca.modelo.Colegio;
import com.example.proyectotommyeduca.modelo.Video;

import java.util.ArrayList;
import java.util.List;

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


    private static final String insert_Tabla_Colegio = "INSERT INTO colegio VALUES(NULL,'Santo Tomas','-34.171627863691526','-70.73630511580164');";
    private static final String insert_Tabla_Colegio2 = "INSERT INTO colegio VALUES(NULL,'Colegio 2','-34.171627863691526','-70.73630511580164');";
    private static final String insert_Tabla_Colegio3 = "INSERT INTO colegio VALUES(NULL,'Colegio 3','-34.171627863691526','-70.73630511580164');";

    private static final String insertTabla_Video = "INSERT INTO video VALUES(NULL,'Mac Miller - Wings',1,'_O1qD95xnao','temazo');";
    private static final String insertTabla_Video2 = "INSERT INTO video VALUES(NULL,'Final Fantasy 7 - Cloud omnislash vs Sephiroth',2,'3nNqArFMhek','juegazo');";
    private static final String insertTabla_Video3 = "INSERT INTO video VALUES(NULL,'Penal Alexis Sánchez - FINAL Copa América Chile 2015 (Full HD)',3,'Sm0TeXjvNJg','LE PEGOOOO');";





    public BD(Context context) {
        super(context, NAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla_colegio);
        db.execSQL(tabla_video);

        db.execSQL(insert_Tabla_Colegio);
        db.execSQL(insert_Tabla_Colegio2);
        db.execSQL(insert_Tabla_Colegio3);


        db.execSQL(insertTabla_Video);
        db.execSQL(insertTabla_Video2);
        db.execSQL(insertTabla_Video3);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("======== UPGRADE =========");
    }
    public List<Video> getVideosPorId(int id){
        List<Video> listaVideos = new ArrayList<>();
        String select = "SELECT * FROM video WHERE colegio_id_fk =" +id+";";
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery(select,null);
        if(cursor.moveToFirst()){
            do{
                Video vid = new Video();
                vid.setVideo_id(cursor.getInt(0));
                vid.setTitulo(cursor.getString(1));
                vid.setColegio_id_fk(cursor.getInt(2));
                vid.setCodigo(cursor.getString(3));
                vid.setDescripcion(cursor.getString(4));
                listaVideos.add(vid);
            }while (cursor.moveToNext());
        }
        return listaVideos;
    }

    public List<Colegio> get_AllColegio(){
        List<Colegio> listC = new ArrayList<>();
        String select = "SELECT * FROM colegio;";
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery(select,null);
        if(cursor.moveToFirst()){
            do{
                Colegio c = new Colegio();
                c.setColegio_id(cursor.getInt(0));
                c.setColegio_nombre(cursor.getString(1));
                c.setLatitud(cursor.getFloat(2));
                c.setLongitud(cursor.getFloat(3));
                listC.add(c);
            }while (cursor.moveToNext());
        }
        return listC;
    }

}
