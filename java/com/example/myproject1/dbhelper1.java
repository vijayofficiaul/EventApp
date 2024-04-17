package com.example.myproject1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class dbhelper1 extends SQLiteOpenHelper {

    //Database version
    private static final int DATABASE_VERSION = 1;
    //Database Name
    private static final String DATABASE_NAME = "user_database";
    //Database Table name
    private static final String TABLE_NAME = "USERS";
    //Table columns
    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String VENUE = "venue";
    public static final String TIME = "time";
    public static final String DATE = "date";
    public static final String DURATION = "duration";
    public static final String DESCRIPTION = "description";
    private SQLiteDatabase sqLiteDatabase;



    //creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME +"(" +ID+
            " INTEGER PRIMARY KEY AUTOINCREMENT,"+ TITLE + " TEXT NOT NULL,"+VENUE+" TEXT NOT NULL,"+ TIME + " TEXT NOT NULL,"+DATE+" TEXT NOT NULL,"+ DURATION + " TEXT NOT NULL,"+DESCRIPTION+" TEXT NOT NULL)";
    //Constructor
    public dbhelper1 (Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addEvent(EventModelClass eventModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbhelper1.TITLE, eventModelClass.getTitle());
        contentValues.put(dbhelper1.VENUE, eventModelClass.getVenue());
        contentValues.put(dbhelper1.TIME, eventModelClass.getTime());
        contentValues.put(dbhelper1.DATE, eventModelClass.getDate());
        contentValues.put(dbhelper1.DURATION, eventModelClass.getDuration());
        contentValues.put(dbhelper1.DESCRIPTION, eventModelClass.getDescription());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(dbhelper1.TABLE_NAME, null,contentValues);
    }

    public List<EventModelClass> getEvent(){
        String sql = "select * from " + TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<EventModelClass> storeEvent = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String title = cursor.getString(1);
                String venue = cursor.getString(2);
                String time = cursor.getString(3);
                String date = cursor.getString(4);
                String duration = cursor.getString(5);
                String description = cursor.getString(6);
                storeEvent.add(new EventModelClass(id,title,venue,time,date,duration,description));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeEvent;
    }

    public void updateEvent(EventModelClass eventModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbhelper1.TITLE, eventModelClass.getTitle());
        contentValues.put(dbhelper1.VENUE, eventModelClass.getVenue());
        contentValues.put(dbhelper1.TIME, eventModelClass.getTime());
        contentValues.put(dbhelper1.DATE, eventModelClass.getDate());
        contentValues.put(dbhelper1.DURATION, eventModelClass.getDuration());
        contentValues.put(dbhelper1.DESCRIPTION, eventModelClass.getDescription());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update(TABLE_NAME,contentValues,ID + " = ?" , new String[]
                {String.valueOf(eventModelClass.getId())});
    }

    public void deleteEvent(int id){
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, ID + " = ? ", new String[]
                {String.valueOf(id)});
    }

}


