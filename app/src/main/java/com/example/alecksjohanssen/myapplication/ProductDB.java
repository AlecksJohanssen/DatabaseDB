package com.example.alecksjohanssen.myapplication;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by AlecksJohanssen on 4/9/2016.
 */
public class ProductDB {
    public void onCreate(SQLiteDatabase database) {
        String query;
        query = "CREATE TABLE IF NOT EXISTS proinfo ( Id INTEGER PRIMARY KEY, Company TEXT,Name TEXT,Price TEXT)";
        database.execSQL(query);
    }
}

