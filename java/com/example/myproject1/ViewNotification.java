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

public class ViewNotification extends AppCompatActivity {

    RecyclerView recyclerView;
    DrawerLayout drawerlayout;
    ImageView menu11;
    CardView card1,card2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_notification);
        recyclerView=findViewById(R.id.recyclerview5);
        drawerlayout=findViewById(R.id.drawer11);
        menu11=findViewById(R.id.menu11);
        card1=findViewById(R.id.card1);
        card2=findViewById(R.id.card2);
        menu11.setOnClickListener(new View.OnClickListener()
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
                Intent in=new Intent(ViewNotification.this,UserHome.class);
                startActivity(in);
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(ViewNotification.this,MainActivity.class);
                startActivity(in);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        dbhelper3 db = new dbhelper3(this);
        List<NotifModel> ModelClasses =db.getNotifList();

        if (ModelClasses.size() > 0){
            MyAdapter5 myAdapter = new MyAdapter5(ModelClasses,ViewNotification.this);
            recyclerView.setAdapter(myAdapter);
        }else {
            Toast.makeText(this, "There is no event in the database", Toast.LENGTH_SHORT).show();
        }


    }
}