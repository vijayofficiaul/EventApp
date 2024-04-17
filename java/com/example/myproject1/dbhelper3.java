package com.example.myproject1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class dbhelper3 extends SQLiteOpenHelper {

    //Database version
    private static final int DATABASE_VERSION = 1;
    //Database Name
    private static final String DATABASE_NAME = "notification database";
    //Database Table name
    private static final String TABLE_NAME = "NOTIFICATION";
    //Table columns
    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String CONTENT = "content";
    private SQLiteDatabase sqLiteDatabase;


    //creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME +"("+ID+
            " INTEGER PRIMARY KEY AUTOINCREMENT,"+ TITLE + " TEXT NOT NULL,"+CONTENT+" TEXT NOT NULL)";
    //Constructor
    public dbhelper3(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public void addnotif(NotifModel notifModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbhelper3.TITLE, notifModelClass.getTitleS());
        contentValues.put(dbhelper3.CONTENT, notifModelClass.getContentS());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(dbhelper3.TABLE_NAME, null,contentValues);
    }

    public List<NotifModel> getNotifList(){
        String sql = "select * from " + TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<NotifModel> storeNotif = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String title = cursor.getString(1);
                String content = cursor.getString(2);

                storeNotif.add(new NotifModel(id,title,content));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeNotif;
    }

    public void updateNotif(NotifModel notifModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbhelper3.TITLE,notifModelClass.getTitleS());
        contentValues.put(dbhelper3.CONTENT,notifModelClass.getContentS());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update(TABLE_NAME,contentValues,ID + " = ?" , new String[]
                {String.valueOf(notifModelClass.getId())});
    }

    public void deleteNotif(int id)
    {
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, ID + " = ? ", new String[]
                {String.valueOf(id)});
    }

}