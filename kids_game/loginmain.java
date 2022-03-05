package com.example.kids_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ResourceBundle;

public class loginmain extends AppCompatActivity {
    private String uname;
    private String uemail;
    private String upass;
    long id;
    private DatabaseHelper dbHelper;
    TabLayout tabLayout;
    ViewPager2 viewPager;
    private String[] titles=new String[]{"LOGIN","SIGNUP"};
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginmain);
        tabLayout =findViewById(R.id.tab_Layout);
        viewPager =findViewById(R.id.view_pager);
        //getSupportActionBar().hide();
       // this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        loginadapter adapter = new loginadapter(this);
        viewPager.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        new TabLayoutMediator(tabLayout,viewPager,((tab, position)->tab.setText(titles[position]))).attach();

    }
    public void adduser(String name,String email,String pass)
    {
        dbHelper=new DatabaseHelper(getApplicationContext());
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(DatabaseContract.Users.COL_FULLNAME,name);
        values.put(DatabaseContract.Users.COL_EMAIL,email);
        values.put(DatabaseContract.Users.COL_PASSWORD,pass);
        long id=db.insert(DatabaseContract.Users.TABLE_NAME,null,values);
        if (id>0)
        {
            Toast.makeText(this,"user inserted with id"+id,Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"error",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }
    public void login(String email,String pass)
    {
        int count=0;
        DatabaseHelper dbhelper = new DatabaseHelper(this);

        SQLiteDatabase db=dbhelper.getReadableDatabase();
        Cursor c=db.query(DatabaseContract.Users.TABLE_NAME,null,null,null,null,null,null);
        while (c.moveToNext())
        {
            if(c.getString(2).equals(email) && c.getString(3).equals(pass))
            {
                id=c.getLong(0);
                uname=c.getString(1);
                uemail=c.getString(2);
                upass=c.getString(3);
                Intent intent = new Intent(loginmain.this, MainActivity.class);
                intent.putExtra("name",uname);
                intent.putExtra("email",uemail);
                intent.putExtra("pass",upass);
                intent.putExtra("id",String.valueOf(id));
                startActivity(intent);
                count=1;


            }
          else
            {

            }
        }
        if(count==0)
        {
            Toast.makeText(this,"wrong email or pass",Toast.LENGTH_SHORT).show();
        }

    }

}