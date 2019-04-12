package com.example.didyoulite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    //creating variables for database
    private static final String dbName = "didyoulite";
    private static final String Table_name = "users";
    private static final String COL0 = "id"; //All these columns are accessed by index numbers
    private static final String COL1 = "name";
    private static final String COL2 = "role";
    private static final String COL3 = "profilePic";


    public DBHelper(Context context){
        super(context, Table_name, null, 1); //factory generates dummy data, if needed

    }

    @Override
    public void onCreate(SQLiteDatabase db){
        //String create = "create table " + Table_name + " (id integer primary key autoincrement , " + COL1/* + COL2*/ + " TEXT)";
        String create = "create table users (id integer primary key autoincrement, name TEXT, role TEXT, profilePic TEXT)";
        //execute database query
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){


    }

    public boolean addUser(String names, String roles, String profilePic){
        //will return true or false if the user is added

        SQLiteDatabase db = this.getWritableDatabase();
        //use content value class to fill table content instead of writing raw sql queries
        ContentValues cv = new ContentValues();

        cv.put(COL1, names);
        cv.put(COL2, roles);
        cv.put(COL3, profilePic);

        long result = db.insert(Table_name, null, cv); //incase of error a long integer -1 will be generated

        if (result == -1)
            return false;
        else
            return true;


    }

    //Cursor class stores results of queries in Cursor class
    public Cursor getData(){

        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "select * from " + Table_name;

        Cursor data = db.rawQuery(sql, null); //this is where selection arguments are defined "where clauses"

        return data;
    }
}

