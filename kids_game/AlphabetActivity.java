package com.example.kids_game;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Locale;

public class AlphabetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);
        String name= getIntent().getStringExtra("name").toLowerCase();
        ImageView iv= findViewById(R.id.imageView);
        int image_id= getResources().getIdentifier(name, "drawable", getPackageName());
        iv.setImageResource(image_id);

        int audio_id= getResources().getIdentifier(name, "raw", getPackageName());
        MediaPlayer mp= MediaPlayer.create(getApplicationContext(), audio_id);
        mp.start();

    }
}