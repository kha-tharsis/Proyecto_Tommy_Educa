package cl.santotomas.proyectotommyeduca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.proyectotommyeduca.R;

public class MainActivity extends AppCompatActivity {
    private ImageButton btn_Video,btn_Mapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Video = findViewById(R.id.button_Video);
        btn_Mapa = findViewById(R.id.button_Mapa);





        init();

    }
    private void init(){
        btn_Video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(getApplicationContext(), Seleccion_de_Videos.class);
                startActivity(i);
            }
        });
        btn_Mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(i);

            }
        });
    }
}