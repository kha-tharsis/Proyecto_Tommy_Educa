package cl.santotomas.tomyeduca;

import android.os.Bundle;
import android.widget.Toast;

import com.example.proyectotommyeduca.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YouTube extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    private YouTubePlayerView Reproducir;
    private  String claveApi = "AIzaSyCI_sG67KqP39Js1jPo3OVAWRft9L-1Pns";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_tube);

        Reproducir = findViewById(R.id.youtubePlayerView_View);
        Reproducir.initialize(claveApi,this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean res) {
        if(!res){
            youTubePlayer.cueVideo(Seleccion_de_Videos.videoSeleccionado.getCodigo());
        }else{
            System.out.println("----Restaurado----");
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if(youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(this,1).show();
        }else{
            String error = "Error Desconocido" + youTubeInitializationResult.toString();
            System.out.println(error);
            Toast.makeText(getApplicationContext(),error,Toast.LENGTH_LONG).show();
        }
    }
}