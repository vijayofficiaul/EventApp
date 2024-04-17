package com.example.myproject1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class dbhelper2 extends SQLiteOpenHelper {

    //Database version
    private static final int DATABASE_VERSION = 1;
    //Database Name
    private static final String DATABASE_NAME = "employee_database";
    //Database Table name
    private static final String TABLE_NAME = "EMPLOYEE";
    //Table columns
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String NUMBER = "number";
    public static final String PASSWORD = "password";
    public static final String ADDRESS = "address";
    public static final String PINCODE = "pincode";
    public static final String GENDER = "gender";
    private SQLiteDatabase sqLiteDatabase;


    //creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME +"("+ID+
            " INTEGER PRIMARY KEY AUTOINCREMENT,"+ NAME + " TEXT NOT NULL,"+EMAIL+" TEXT NOT NULL,"+ NUMBER + " TEXT NOT NULL,"+PASSWORD+" TEXT NOT NULL,"+ ADDRESS + " TEXT NOT NULL,"+PINCODE+" TEXT NOT NULL,"+GENDER+" TEXT NOT NULL)";
    //Constructor
    public dbhelper2(Context context){
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


    public void addEmployee(EmployeeModel employeeModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbhelper2.NAME, employeeModelClass.getNameS());
        contentValues.put(dbhelper2.EMAIL, employeeModelClass.getEmailS());
        contentValues.put(dbhelper2.NUMBER,employeeModelClass.getMobilenemberS());
        contentValues.put(dbhelper2.PASSWORD,employeeModelClass.getPasswordS());
        contentValues.put(dbhelper2.ADDRESS,employeeModelClass.getAddressS());
        contentValues.put(dbhelper2.PINCODE,employeeModelClass.getPincodeS());
        contentValues.put(dbhelper2.GENDER,employeeModelClass.getGenderS());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(dbhelper2.TABLE_NAME, null,contentValues);
    }

    public List<EmployeeModel> getEmployeeList(){
        String sql = "select * from " + TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<EmployeeModel> storeEmployee = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String email = cursor.getString(2);
                String  mobilenumber= cursor.getString(3);
                String  password= cursor.getString(4);
                String  address= cursor.getString(5);
                String  pincode= cursor.getString(6);
                String  gender= cursor.getString(7);

                storeEmployee.add(new EmployeeModel(id,name,email,mobilenumber,password,address,pincode,gender));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeEmployee;
    }

    public void updateEmployee(EmployeeModel employeeModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbhelper2.NAME,employeeModelClass.getNameS());
        contentValues.put(dbhelper2.EMAIL,employeeModelClass.getEmailS());
        contentValues.put(dbhelper2.NUMBER,employeeModelClass.getMobilenemberS());
        contentValues.put(dbhelper2.PASSWORD,employeeModelClass.getPasswordS());
        contentValues.put(dbhelper2.ADDRESS,employeeModelClass.getAddressS());
        contentValues.put(dbhelper2.PINCODE,employeeModelClass.getPincodeS());
        contentValues.put(dbhelper2.GENDER,employeeModelClass.getGenderS());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update(TABLE_NAME,contentValues,ID + " = ?" , new String[]
                {String.valueOf(employeeModelClass.getId())});
    }



    public void deleteEmployee(int id)
    {
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, ID + " = ? ", new String[]
                {String.valueOf(id)});
    }



}
