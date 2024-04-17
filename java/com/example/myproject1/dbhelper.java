package com.example.myproject1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

public class dbhelper extends SQLiteOpenHelper    //  oncreate , onupgrade
{
    //Database version
    private static final int DATABASE_VERSION = 1;
    //Database Name
    private static final String DATABASE_NAME = "login";
    //Database Table name
    static final String TABLE_NAME = "users";
    //Table columns
    public static final String username = "username";
    public static final String password = "password";
    //public static final String queries = "queries";
    public static final String feedback= "feedback";

    static final String TABLE_NAME1 = "userquery";

    public static final String queries = "queries";
    private SQLiteDatabase sqLiteDatabase;
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "( " + username + " TEXT NOT NULL," + password + " TEXT NOT NULL,"+ queries + " TEXT NOT NULL,"+ feedback + " TEXT NOT NULL)";
   // private static final String CREATE_TABLE1 = "create table " + TABLE_NAME1 + "( " + queries + " TEXT NOT NULL)";
    public dbhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
       // sqLiteDatabase.execSQL(CREATE_TABLE1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
       // sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(sqLiteDatabase);
    }

    /* public Boolean insertdata(usermodel usermodel)
      {
          SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
          ContentValues contentValues = new ContentValues();
          contentValues.put(dbhelper.username, usermodel.getusername());
          contentValues.put(dbhelper.password, usermodel.getpassword());
          sqLiteDatabase = this.getWritableDatabase();
          long result=sqLiteDatabase.insert(dbhelper.TABLE_NAME, null,contentValues);

          return result != -1;
      }*/
    public Boolean insertdata(String username, String password) {

       sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(username, "usernameS");
        contentValues.put(password, "passwordS");
        long result = sqLiteDatabase.insert("login", null, contentValues);
        return result != -1;
    }

    public boolean checkusername(String username) {
        sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from users where username = ?  ", new String[]{username});
        int count = cursor.getCount();
        cursor.close();
        return count > 0;
    }

    public boolean chechuserpass(String username, String password) {
       sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from users where username= ? and password =?  ", new String[]{username, password});
        int count = cursor.getCount();
        cursor.close();
        return count > 0;
    }


    public Boolean insertquery(String querys){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("querys", querys);
        long result = MyDB.insert("Queries", null, contentValues);
        if(result==-1) return false;
        else
            return true;
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
    public Cursor getquery()
    {
        SQLiteDatabase MyDB =  this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("select * from userquery ", null);
        return cursor;
    }
}


