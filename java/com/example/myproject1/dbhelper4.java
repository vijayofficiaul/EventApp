package com.example.myproject1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbhelper4 extends SQLiteOpenHelper {
    public static final String QUERIES = "QUERIES.DB";

    public dbhelper4(Context context) {
        super(context, "QUERIES.DB",null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create Table Queries(querys TEXT primary key, feedback TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop Table if exists Queries");

    }
    public Boolean insertData(String querys){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("querys", querys);
        long result = MyDB.insert("Queries", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }
    public Cursor getdata()
    {
        SQLiteDatabase MyDB =  this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("select * from Queries ", null);
        return cursor;
    }
    public Boolean data1(String feedback){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("feedback", feedback);
        long result = MyDB.insert("Queries", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

}
