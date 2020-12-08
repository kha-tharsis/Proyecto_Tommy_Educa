package cl.santotomas.tomyeduca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import cl.santotomas.tomyeduca.R;

import cl.santotomas.tomyeduca.data.BD;
import cl.santotomas.tomyeduca.modelo.Video;

import java.util.List;

public class Seleccion_de_Videos extends AppCompatActivity {
    private TextView text_titulo,text_descripcion;
    private ImageButton btn_reproducir,btn_retroceder,btn_avanzar;
    private ImageView imagenVideo;
    private int num;
    public static List<Video> listaVideos;
    public static Video videoSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_de__videos);
        text_titulo = findViewById(R.id.tv_titulo);
        text_descripcion = findViewById(R.id.tv_Descripcion_Video);

        btn_reproducir = findViewById(R.id.imageButtonReproducir);
        btn_retroceder = findViewById(R.id.imageButtonRetroceder);
        btn_avanzar = findViewById(R.id.imageButtonAvanzar);
        BD bd = new BD(getApplicationContext());
        listaVideos = bd.getAllVideos();


        llenarDatos(listaVideos.get(0));
        num = 1;
        btn_retroceder.setImageAlpha(75);
        btn_retroceder.setEnabled(false);
        init();


    }
    public void init(){
        btn_reproducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),YouTube.class);
                startActivity(i);
            }
        });
        btn_retroceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num>1) {
                    num--;
                    llenarDatos(listaVideos.get(num-1));
                    btn_retroceder.setImageAlpha(255);
                    btn_retroceder.setEnabled(true);
                    btn_avanzar.setImageAlpha(255);
                    btn_avanzar.setEnabled(true);
                }
                if(num==1){
                    btn_retroceder.setImageAlpha(75);
                    btn_retroceder.setEnabled(false);
                    btn_avanzar.setImageAlpha(255);
                    btn_avanzar.setEnabled(true);
                }
            }
        });
        btn_avanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num<listaVideos.size()){
                    llenarDatos(listaVideos.get(num));
                    num++;
                    btn_avanzar.setImageAlpha(255);
                    btn_avanzar.setEnabled(true);
                    btn_retroceder.setImageAlpha(255);
                    btn_retroceder.setEnabled(true);
                }
                if(num == listaVideos.size()){
                    btn_avanzar.setImageAlpha(75);
                    btn_avanzar.setEnabled(false);
                    btn_retroceder.setImageAlpha(255);
                    btn_retroceder.setEnabled(true);
                }
            }
        });

    }
    private void llenarDatos(Video video){
        text_titulo.setText(video.getTitulo());
        text_descripcion.setText(video.getDescripcion());
        videoSeleccionado = video;
        enviarImagenporId(video.getVideo_id());

    }
    private void enviarImagenporId(int id){
        imagenVideo = (ImageView) findViewById(R.id.imageView); imagenVideo.setImageResource(R.drawable.video1);
        switch(id) {
            case 1:
                imagenVideo = (ImageView) findViewById(R.id.imageView); imagenVideo.setImageResource(R.drawable.video1);
                break;
            case 2:
                imagenVideo = (ImageView) findViewById(R.id.imageView); imagenVideo.setImageResource(R.drawable.video2);
                break;
            case 3:
                imagenVideo = (ImageView) findViewById(R.id.imageView); imagenVideo.setImageResource(R.drawable.video3);
                break;
            default:
                break;
        }
    }
}