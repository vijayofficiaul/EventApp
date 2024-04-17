package com.example.myproject1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Queries extends AppCompatActivity {

    DrawerLayout drawerlayout;
    RecyclerView recyclerView;
    ArrayList<String> query;
    dbhelper db;
    ImageView menu13;
    CardView card1,card2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queries);
        drawerlayout=findViewById(R.id.drawer13);
        menu13=findViewById(R.id.menu13);
        card1=findViewById(R.id.card1);
        card2=findViewById(R.id.card2);
        recyclerView=findViewById(R.id.recyclerview6);
        db=new dbhelper(this);
        query=new ArrayList<>();
        //email=new ArrayList<>();
        menu13.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                drawerlayout.openDrawer(GravityCompat.START);
            }
        });
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Queries.this,UserHome.class);
                startActivity(in);
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Queries.this,MainActivity.class);
                startActivity(in);
            }
        });
        /*recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        dbhelper1 db = new dbhelper1(this);
        List<EventModelClass> eventModelClasses =db.getEvent();

        if (eventModelClasses.size() > 0){
            MyAdapter myAdapter = new MyAdapter(eventModelClasses,Queries.this);
            recyclerView.setAdapter(myAdapter);
        }else {
            Toast.makeText(this, "There is no event in the database", Toast.LENGTH_SHORT).show();
        }
        MyAdapter7 myAdapter7= new MyAdapter7(this,query);
        recyclerView.setAdapter(myAdapter7);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));*/
        displaydata();
    }
    private void displaydata()
    {
        Cursor cursor=db.getquery();
        if(cursor.getCount()==0)
        {
            Toast.makeText(this, "no exixting user", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while(cursor.moveToNext())
            {
                //email.add(cursor.getString(0));
                query.add(cursor.getString(0));
            }

        }
    }
}