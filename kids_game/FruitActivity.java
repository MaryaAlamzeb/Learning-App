package com.example.kids_game;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class FruitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        String fruit= getIntent().getStringExtra("name").toLowerCase();
        Toast.makeText(getApplicationContext(),fruit, Toast.LENGTH_LONG).show();
        ImageView iv=findViewById(R.id.fruitImage);
        int image_id= getResources().getIdentifier(fruit, "drawable", getPackageName());
        iv.setImageResource(image_id);

        int audio_id=getResources().getIdentifier(fruit, "raw", getPackageName());
        MediaPlayer mp= MediaPlayer.create(getApplicationContext(), audio_id);
        mp.start();
    }
}