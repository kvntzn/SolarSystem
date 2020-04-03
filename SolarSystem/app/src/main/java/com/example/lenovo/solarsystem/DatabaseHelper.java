package com.example.lenovo.solarsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lenovo on 11/11/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "planets.db";
    public static final String TABLE_NAME = "planets_table";
    public static final String COL_1 = "planets_id";
    public static final String COL_2 = "planets_name";
    public static final String COL_3 = "planets_desc";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null , 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create db
        db.execSQL(" create table " + TABLE_NAME +  " (planets_id INTEGER PRIMARY KEY AUTOINCREMENT,planets_name TEXT,planets_desc TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //insertion of date
    public boolean insertData(String name,String description){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, description);

        long result =   db.insert(TABLE_NAME, null,contentValues);
        if(result == -1){
            return false;
        }else
            {
                return true;
            }

    }

    //viewing all data
    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ TABLE_NAME,null);
        return res;
    }

    //updatedata
    public boolean updateData(String id,String name,String description)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, description);
        db.update(TABLE_NAME,contentValues, "planets_id = ?",new String[] { id });
        return true;
    }

    //delete data
    public Integer deleteData(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"planets_id = ?",new String[] {id});
    }
}
