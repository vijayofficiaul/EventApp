package com.example.myproject1;

import static com.example.myproject1.dbhelper.password;
import static com.example.myproject1.dbhelper.username;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class adminlogin extends AppCompatActivity {

    TextView textView6;
    Button button2;
    EditText adminusername,adminpassword;
    String adminusernameS,adminpasswordS;

    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

        adminusername=findViewById(R.id.adminusername);
        adminpassword=findViewById(R.id.adminpassword);
        dbhelper dbhelper=new dbhelper(this);

        db=dbhelper.getWritableDatabase();
        db=dbhelper.getReadableDatabase();


        button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                adminusernameS=adminusername.getText().toString();
                adminpasswordS=adminpassword.getText().toString();


                /*if(adminpasswordS.isEmpty()|| adminusernameS.isEmpty())
                {
                    Toast.makeText(adminlogin.this, "enter all the fields", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    ContentValues contentValues=new ContentValues();
                    contentValues.put("username", adminusernameS);
                    contentValues.put("password", adminpasswordS);
                    db.insert("users",null,contentValues);
                    Intent intent=new Intent(adminlogin.this,Home.class);
                    startActivity(intent);
                    Toast.makeText(adminlogin.this, "Logged In", Toast.LENGTH_SHORT).show();


                    dbhelper dbhelper=new dbhelper(adminlogin.this);
                    usermodel usermodel=new usermodel(username,password);
                    dbhelper.insertdata(usermodel);
                    Toast.makeText(adminlogin.this, "Added  Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());*/




                   Boolean checkuserpass=dbhelper.chechuserpass(adminusernameS,adminpasswordS);

                    if(checkuserpass==true)
                    {
                        Intent intent=new Intent(adminlogin.this,Home.class);
                        startActivity(intent);
                        Toast.makeText(adminlogin.this, "Logged In successfully", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(adminlogin.this, "user not exist ", Toast.LENGTH_SHORT).show();
                    }
                }

        });
        textView6=findViewById(R.id.textView6);
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(adminlogin.this,Registration.class);
                startActivity(in);
            }
        });
    }
}