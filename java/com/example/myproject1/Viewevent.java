package com.example.myproject1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

public class Viewevent extends AppCompatActivity {

    RecyclerView recyclerView;
    DrawerLayout drawerlayout;
    ImageView menu6;
    CardView card1,card2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewevent);
        recyclerView=findViewById(R.id.recyclerview3);
        drawerlayout=findViewById(R.id.drawer6);
        menu6=findViewById(R.id.menu6);
        card1=findViewById(R.id.card1);
        card2=findViewById(R.id.card2);
        menu6.setOnClickListener(new View.OnClickListener()
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
                Intent in=new Intent(Viewevent.this,UserHome.class);
                startActivity(in);
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Viewevent.this,MainActivity.class);
                startActivity(in);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        dbhelper1 db = new dbhelper1(this);
        List<EventModelClass> eventModelClasses =db.getEvent();

        if (eventModelClasses.size() > 0){
            MyAdapter3 myAdapter = new MyAdapter3(eventModelClasses,Viewevent.this);
            recyclerView.setAdapter(myAdapter);
        }else {
            Toast.makeText(this, "There is no event in the database", Toast.LENGTH_SHORT).show();
        }


    }
}