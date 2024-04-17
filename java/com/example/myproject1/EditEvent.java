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

public class EditEvent extends AppCompatActivity{
    RecyclerView recyclerView;
    DrawerLayout drawerlayout;
    ImageView menu2;
    CardView card1,card2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_event);

        recyclerView=findViewById(R.id.recyclerview);
        drawerlayout=findViewById(R.id.drawerlayout2);
        menu2=findViewById(R.id.menu2);
        card1=findViewById(R.id.card1);
        card2=findViewById(R.id.card2);
        menu2.setOnClickListener(new View.OnClickListener()
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
                Intent in=new Intent(EditEvent.this,Home.class);
                startActivity(in);
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(EditEvent.this,MainActivity.class);
                startActivity(in);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        dbhelper1 db = new dbhelper1(this);
        List<EventModelClass> eventModelClasses =db.getEvent();

        if (eventModelClasses.size() > 0){
            MyAdapter myAdapter = new MyAdapter(eventModelClasses,EditEvent.this);
            recyclerView.setAdapter(myAdapter);
        }else {
            Toast.makeText(this, "There is no event in the database", Toast.LENGTH_SHORT).show();
        }


    }




}