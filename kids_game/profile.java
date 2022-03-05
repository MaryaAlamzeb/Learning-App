 package com.example.kids_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

 public class profile extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
     private EditText uname,uemail,pass;
     Button edit;
     String sname,semail,spass,sid;
     DatabaseHelper dbhelper;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_profile);
         getSupportActionBar().hide();
         this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
         uname = findViewById(R.id.name2);
         uemail = findViewById(R.id.email2);
         pass = findViewById(R.id.pass2);
         edit = findViewById(R.id.editbtn);
         Intent data = getIntent();
         sname = data.getStringExtra("name");
         semail = data.getStringExtra("email");
         spass = data.getStringExtra("pass");
         sid = data.getStringExtra("id");


         DatabaseHelper dbhelper = new DatabaseHelper(this);

         SQLiteDatabase db = dbhelper.getReadableDatabase();
         Cursor c = db.query(DatabaseContract.Users.TABLE_NAME, null, null, null, null, null, null);
         while (c.moveToNext()) {
             if (c.getString(0).equals(sid)) {
                 uname.setText(c.getString(1));
                 uemail.setText(c.getString(2));
                 pass.setText(c.getString(3));
             }
         }






         Toast.makeText(this,"User id is : "+sid,Toast.LENGTH_SHORT).show();
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editprofile();
            }
        });
         Button popupbtn = (Button) findViewById(R.id.btn_popup);
         popupbtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 PopupMenu popup = new PopupMenu(profile.this, v);
                 popup.setOnMenuItemClickListener(profile.this);
                 popup.inflate(R.menu.popupmenu);
                 popup.show();
             }
         });
    }

public void editprofile()
{
    dbhelper=new DatabaseHelper(getApplicationContext());
   // dbhelper = new DatabaseHelper(this);
    SQLiteDatabase db=dbhelper.getWritableDatabase();
    ContentValues values=new ContentValues();
    values.put(DatabaseContract.Users.COL_FULLNAME,uname.getText().toString());
    values.put(DatabaseContract.Users.COL_EMAIL,uemail.getText().toString());
    values.put(DatabaseContract.Users.COL_PASSWORD,pass.getText().toString());
    String whereClause= DatabaseContract.Users._ID+"=?";
    String[] whereArgs={sid};
    int result=db.update(DatabaseContract.Users.TABLE_NAME,values,whereClause,whereArgs);
    if(result>0)
    {
        Toast.makeText(this,"record updated",Toast.LENGTH_SHORT).show();
      //  finish();
    }

}
     public boolean onMenuItemClick(MenuItem item) {
         Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
         switch (item.getItemId()) {
             case R.id.delete_profile:
                 dbhelper=new DatabaseHelper(this);
                 SQLiteDatabase db=dbhelper.getWritableDatabase();
                 String whereClause= DatabaseContract.Users._ID + " = ? ";
                 String[] whereArgs={sid};
                 int result=db.delete(DatabaseContract.Users.TABLE_NAME,whereClause,whereArgs);
                 if(result>0)
                 {
                     Toast.makeText(this, "Account Deleted", Toast.LENGTH_SHORT).show();
                     Intent intent=new Intent(profile.this,loginmain.class);
                     startActivity(intent);

                 }
                 db.close();
                 return true;

             default:
                 return false;
         }
     }


 }