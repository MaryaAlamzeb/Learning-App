package com.example.kids_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class song extends AppCompatActivity {
    VideoView videoview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        videoview = findViewById(R.id.song);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.song);
        videoview.setVideoURI(uri);
        videoview.start();
        videoview.setOnPreparedListener(mp -> mp.setLooping(true));
        getSupportActionBar().hide();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }


    protected void onResume() {
        videoview.start();
        super.onResume();
    }

    protected void onRestart() {
        videoview.start();
        super.onRestart();
    }

    protected void onPause() {
        videoview.suspend();
        super.onPause();
    }

    protected void onDestroy() {
        videoview.stopPlayback();
        super.onDestroy();
    }

}