package com.example.kids_game;

import android.provider.BaseColumns;

public final class DatabaseContract {
    public static abstract class Users implements BaseColumns{
        public static final String TABLE_NAME = "users";
        public static final String COL_FULLNAME = "fullname";
        public static final String COL_EMAIL = "email";
        public static final String COL_PASSWORD = "password";
    }

}
