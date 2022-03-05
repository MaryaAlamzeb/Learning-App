package com.example.kids_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivitylearn extends AppCompatActivity {
String[] tabTitle ={"Alphabets", "Fruits" , "Animals"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainlearn);
      //  this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        TabLayout tl=findViewById(R.id.tabLayout);
        ViewPager2 pager=findViewById(R.id.viewPager);
        pager.setAdapter(new MyAdapter(getSupportFragmentManager(), getLifecycle()));
        TabLayoutMediator tm= new TabLayoutMediator(tl, pager, true,
                (tab, position) ->
        {
         tab.setText(tabTitle[ position]);
        });
tm.attach();
    }
}