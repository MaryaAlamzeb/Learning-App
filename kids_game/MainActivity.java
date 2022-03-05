package com.example.kids_game;


import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    VideoView videoview;
    String name,email,pass,id;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent data=getIntent();
        name=data.getStringExtra("name");
        email=data.getStringExtra("email");
        pass=data.getStringExtra("pass");
        id=data.getStringExtra("id");
        videoview=findViewById(R.id.videoview);
        Uri uri=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video);
        videoview.setVideoURI(uri);
        videoview.start();
        videoview.setOnPreparedListener(mp -> mp.setLooping(true));
this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
     //   getSupportActionBar().hide();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.item1:
                Intent intent=new Intent(MainActivity.this,MainActivitylearn.class);
                startActivity(intent);
                return true;
            case R.id.item2:
                Intent intent1=new Intent(MainActivity.this,profile.class);
                intent1.putExtra("name",name);
                intent1.putExtra("email",email);
                intent1.putExtra("pass",pass);
                intent1.putExtra("id",id);
                startActivity(intent1);
                return true;
            case R.id.item3:
                Intent intent2=new Intent(MainActivity.this,song.class);
                startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    protected void onResume()
    {
        videoview.start();
        super.onResume();
    }
    protected void onRestart()
    {
        videoview.start();
        super.onRestart();
    }
    protected void onPause()
    {
        videoview.suspend();
        super.onPause();
    }
    protected void onDestroy()
    {
        videoview.stopPlayback();
        super.onDestroy();
    }







    public void quiz(View view)
    {
        Intent intent = new Intent(MainActivity.this, mainquiz.class);
        startActivity(intent);
    }


}