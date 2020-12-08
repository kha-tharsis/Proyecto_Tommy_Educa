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
            "codigo TEXT ," +
            "descripcion TEXT)";





    private static final String insertTabla_Video = "INSERT INTO video VALUES(NULL,'Categorías Semánticas','ZgWD9ST7js8','Este video trata buscar el elemento que no corresponde a la familia de palabras o categorías semánticas.');";
    private static final String insertTabla_Video2 = "INSERT INTO video VALUES(NULL,'Estaciones del año','8WJJf6WpfnY','Reconocer las estaciones del año y sus características, y asimilar los objetos correspondientes a cada estación que se le indique.  (Lenguaje expresivo).');";
    private static final String insertTabla_Video3 = "INSERT INTO video VALUES(NULL,'Fonema R fuerte','GQ0xIEJjj58','Actividades de articulación del fonema R fuerte o /rr/.');";
    private static final String insertTabla_Video4 = "INSERT INTO video VALUES(NULL,'¡Juguemos con las rimas!','377lcXJLS6Q','Este video trata de las rimas, las que se ven reflejadas en seis ejercicios con tres respuestas cada uno, en donde se deben elegir dos palabras que suenen parecido al final.');";
    private static final String insertTabla_Video5 = "INSERT INTO video VALUES(NULL,'Letra M ','d5zGGuOWgaY','Este video fue diseñado para reforzar el nivel de lenguaje fonético fonológico, centrado específicamente en la pronunciación de la letra M, junto a las vocales con el fin de crear silabas para que el infante las repita y luego las pueda asociar a objetos que están a su alrededor.');";
    private static final String insertTabla_Video6 = "INSERT INTO video VALUES(NULL,'Conociendo las onomatopeyas de los animales','NYKm7IdbhYE','Este material visual está relacionado con el aprendizaje de los niños y niñas sobre las onomatopeyas, principalmente de los sonidos de los animales.');";
    private static final String insertTabla_Video7 = "INSERT INTO video VALUES(NULL,'Los animales de la granja : Onomatopeyas II','6eXSPWK5QME','Este video se desarrollará o trabajara 1 de los  niveles del lenguaje, se colocó énfasis en el nivel fonológico .En el que se reforzara las onomatopeyas a través de los sonidos de los animales .Esta dirigido para niños y niñas con trastorno específico del lenguaje.');";
    private static final String insertTabla_Video8 = "INSERT INTO video VALUES(NULL,'Patito feo ','EFzdpX6d7EA','Este cuento enseña que, no se debe juzgar a alguien por su apariencia, pues la belleza reside en el interior.');";
    private static final String insertTabla_Video9 = "INSERT INTO video VALUES(NULL,'Audio cuento la caperucita roja','j9Bx0Zb4sug','En el siguiente video encontraran el audio cuento de la caperucita roja, cuento destinado para niñas y niños de 5 años en adelante. Al finalizar el cuento se encontraran con una actividad con el objetivo de retroalimentar el cuento escuchado.');";
    private static final String insertTabla_Video10 = "INSERT INTO video VALUES(NULL,'Conociendo “la señora M” ','KPAsOIjm5zA','Video para que los pequeños descubran y conozcan de manera dinámica la consonante M. Conocerán su sonido, grafema y palabras que comienzan con la consonante M. Incluye ejercicios para practicar a medida que transcurre el video y para trabajar en casa con ayuda de un adulto.');";
    private static final String insertTabla_Video11 = "INSERT INTO video VALUES(NULL,'Letra P ','mkb_CsepflE','Video para que los pequeños descubran y conozcan de manera dinámica la consonante P. Incluye ejercicios para practicar a medida que transcurre el video y para trabajar en casa con ayuda de un adulto.');";
    private static final String insertTabla_Video12 = "INSERT INTO video VALUES(NULL,'El Conejito Rabi ','XHRywSX9oTE','Conocerán la historia de Rabi, un pequeño conejito que vive una gran aventura junto a su amigo Toby para aprender a aceptarse así mismo.');";
    private static final String insertTabla_Video13 = "INSERT INTO video VALUES(NULL,'Las sílabas','mrflP99ujLw','Aprenderan sobre las sílabas (conjunto de sonidos que se pronuncia en un solo golpe de voz)');";
    private static final String insertTabla_Video14 = "INSERT INTO video VALUES(NULL,'El zorro arrepentido','CnTno1ZyLTM','Obra en un teatrillo de Sombras llamada El zorron arrepentido ');";
    private static final String insertTabla_Video15 = "INSERT INTO video VALUES(NULL,'Las vocales ','xzxUI9pmCEE','Video que trata sobre las vocales, estas son letras que pertenecen a nuestro abecedario, son 5 y éstas en compañía de las consonantes forman las sílabas');";








    public BD(Context context) {
        super(context, NAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(tabla_video);
        db.execSQL(insertTabla_Video);
        db.execSQL(insertTabla_Video2);
        db.execSQL(insertTabla_Video3);
        db.execSQL(insertTabla_Video4);
        db.execSQL(insertTabla_Video5);
        db.execSQL(insertTabla_Video6);
        db.execSQL(insertTabla_Video7);
        db.execSQL(insertTabla_Video8);
        db.execSQL(insertTabla_Video9);
        db.execSQL(insertTabla_Video10);
        db.execSQL(insertTabla_Video11);
        db.execSQL(insertTabla_Video12);
        db.execSQL(insertTabla_Video13);
        db.execSQL(insertTabla_Video14);
        db.execSQL(insertTabla_Video15);



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
                vid.setCodigo(cursor.getString(2));
                vid.setDescripcion(cursor.getString(3));
                listaVideos.add(vid);
            }while (cursor.moveToNext());
        }
        return listaVideos;
    }


}
