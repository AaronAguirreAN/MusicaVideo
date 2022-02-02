package com.example.musicavideo;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    Button btn_reproduir, btn_bucle;
    MediaPlayer mp;
    VideoView video;
    int repetir = 2, posicion = 0;

    MediaPlayer vectormp [] = new MediaPlayer [4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_reproduir = (Button) findViewById(R.id.btn_reproduir);
        btn_bucle = (Button) findViewById(R.id.btn_bucle);
        video = (VideoView) findViewById(R.id.video);

        //Llista de cancions a reproduir de la carpeta RAW
        vectormp[0] = MediaPlayer.create(this, R.raw.bonjovi);
        vectormp[1] = MediaPlayer.create(this, R.raw.formentera);
        vectormp[2] = MediaPlayer.create(this, R.raw.musicaligera);
        vectormp[3] = MediaPlayer.create(this, R.raw.wonder);

    }

    //Metode per el botó PLAY/PAUSE
    public void PlayPause(View view){
        if(vectormp[posicion].isPlaying()){
            vectormp[posicion].pause();
            video.pause();
            
            btn_reproduir.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this,"Pausa",Toast.LENGTH_SHORT).show();
        }else{
            vectormp[posicion].start();
            video.start();
            btn_reproduir.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this,"Play",Toast.LENGTH_SHORT).show();
        }
    }

    //Metode per el botó stop
    public void Stop(View view){
        if(vectormp[posicion] != null){
            vectormp[posicion].stop();
            video.stopPlayback();

            vectormp[0] = MediaPlayer.create(this, R.raw.bonjovi);
            vectormp[1] = MediaPlayer.create(this, R.raw.formentera);
            vectormp[2] = MediaPlayer.create(this, R.raw.musicaligera);
            vectormp[3] = MediaPlayer.create(this, R.raw.wonder);
            posicion=0;
            btn_reproduir.setBackgroundResource(R.drawable.reproducir);
            video.setVideoURI(Uri.parse("android.resource://"+getPackageName()+ "/"+R.raw.bonjovi1));
            Toast.makeText(this,"Stop",Toast.LENGTH_SHORT).show();
        }
    }

    //Metode per repetir una pista
    public void Repetir(View view){
        if (repetir == 1){
            btn_bucle.setBackgroundResource(R.drawable.repetir);
            Toast.makeText(this,"No repetir",Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(false);
            repetir = 2;
        }else{
            btn_bucle.setBackgroundResource(R.drawable.repetir);
            Toast.makeText(this,"Repetir",Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(true);
            repetir = 1;
        }
    }

    //Metode per saltar a la següent cançó
    public void Seguent(View view){
        if (posicion < vectormp.length - 1){
            if(vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                posicion++;
                vectormp[posicion].start();

                if(posicion==0){
                    video.setVideoURI(Uri.parse("android.resource://"+getPackageName()+ "/"+R.raw.bonjovi1));
                    video.start();
                } else if (posicion == 1){
                    video.setVideoURI(Uri.parse("android.resource://"+getPackageName()+ "/"+R.raw.formentera1));
                    video.start();
                } else if (posicion == 2){
                    video.setVideoURI(Uri.parse("android.resource://"+getPackageName()+ "/"+R.raw.musicaligera1));
                    video.start();
                } else if (posicion == 3){
                    video.setVideoURI(Uri.parse("android.resource://"+getPackageName()+ "/"+R.raw.wonder1));
                    video.start();
                }

            } else {
                posicion++;

                if(posicion==0){
                    video.setVideoURI(Uri.parse("android.resource://"+getPackageName()+ "/"+R.raw.bonjovi1));
                    video.start();
                } else if (posicion == 1){
                    video.setVideoURI(Uri.parse("android.resource://"+getPackageName()+ "/"+R.raw.formentera1));
                    video.start();
                } else if (posicion == 2){
                    video.setVideoURI(Uri.parse("android.resource://"+getPackageName()+ "/"+R.raw.musicaligera1));
                    video.start();
                } else if (posicion == 3){
                    video.setVideoURI(Uri.parse("android.resource://"+getPackageName()+ "/"+R.raw.wonder1));
                    video.start();
                }
            }

        } else {
            Toast.makeText(this, "No hi ha més cançons", Toast.LENGTH_SHORT).show();
        }
    }

    //Metode per tornar a la cançó anterior
    public void Anterior(View view){
        if (posicion >= 1){
            if(vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                video.stopPlayback();
                vectormp[0] = MediaPlayer.create(this, R.raw.bonjovi);
                vectormp[1] = MediaPlayer.create(this, R.raw.formentera);
                vectormp[2] = MediaPlayer.create(this, R.raw.musicaligera);
                vectormp[3] = MediaPlayer.create(this, R.raw.wonder);
                posicion--;

                if(posicion == 0){
                    video.setVideoURI(Uri.parse("android.resource://"+getPackageName()+ "/"+R.raw.bonjovi1));
                    video.start();
                } else if (posicion == 1){
                    video.setVideoURI(Uri.parse("android.resource://"+getPackageName()+ "/"+R.raw.formentera1));
                    video.start();
                } else if (posicion == 2){
                    video.setVideoURI(Uri.parse("android.resource://"+getPackageName()+ "/"+R.raw.musicaligera1));
                    video.start();
                } else if (posicion == 3){
                    video.setVideoURI(Uri.parse("android.resource://"+getPackageName()+ "/"+R.raw.wonder1));
                    video.start();
                }
            }

        } else {
            Toast.makeText(this, "No hi ha més cançons", Toast.LENGTH_SHORT).show();
        }
    }

}