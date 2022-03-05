package com.example.kids_game;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "users.db";
    private static final String CREATE_TBL_USERS = "CREATE TABLE "
            + DatabaseContract.Users.TABLE_NAME + " (" + DatabaseContract.Users._ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + DatabaseContract.Users.COL_FULLNAME
            + " TEXT NOT NULL, " + DatabaseContract.Users.COL_EMAIL+" TEXT NOT NULL, " + DatabaseContract.Users.COL_PASSWORD + " TEXT NOT NULL)";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TBL_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}


