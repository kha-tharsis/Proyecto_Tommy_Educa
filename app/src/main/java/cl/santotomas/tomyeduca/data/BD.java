package cl.santotomas.tomyeduca.data;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import cl.santotomas.tomyeduca.modelo.Video;

import java.util.ArrayList;
import java.util.List;

public class BD extends SQLiteOpenHelper{
    private static String NAME = "bd_Videos";
    private static int VERSION = 1;



    private final String tabla_video = "CREATE TABLE video(" +
            "video_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "video_titulo TEXT," +
            "colegio_id_fk INT ," +
            "codigo TEXT ," +
            "descripcion TEXT)";




    private static final String insertTabla_Video = "INSERT INTO video VALUES(NULL,'Mac Miller - Wings',1,'_O1qD95xnao','temazo');";
    private static final String insertTabla_Video1 = "INSERT INTO video VALUES(NULL,'Opening Santo Tomas Extendido',2,'RJX1UIbT0OM','otro temazo');";
    private static final String insertTabla_Video3 = "INSERT INTO video VALUES(NULL,'Penal Alexis Sánchez - FINAL Copa América Chile 2015 (Full HD)',3,'Sm0TeXjvNJg','LE PEGOOOO');";





    public BD(Context context) {
        super(context, NAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(tabla_video);
        db.execSQL(insertTabla_Video);
        db.execSQL(insertTabla_Video1);
        db.execSQL(insertTabla_Video3);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("======== UPGRADE =========");
    }
    public List<Video> getAllVideos(){
        List<Video> listaVideos = new ArrayList<>();
        String select = "SELECT * FROM video;";
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


}
