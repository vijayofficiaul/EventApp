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

public class NotificationDetail extends AppCompatActivity {

    RecyclerView recyclerview4;
    DrawerLayout drawerlayout;
    ImageView menu10;
    CardView card1,card2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_detail);
            recyclerview4 = findViewById(R.id.recyclerview4);
            drawerlayout=findViewById(R.id.drawer10);
            menu10=findViewById(R.id.menu10);
            card1=findViewById(R.id.card1);
            card2=findViewById(R.id.card2);
            menu10.setOnClickListener(new View.OnClickListener()
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
                    Intent in=new Intent(NotificationDetail.this,Home.class);
                    startActivity(in);
                }
            });
            card2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in=new Intent(NotificationDetail.this,MainActivity.class);
                    startActivity(in);
                }
            });
            recyclerview4.setLayoutManager(new LinearLayoutManager(this));
            recyclerview4.setHasFixedSize(true);

            dbhelper3 db = new dbhelper3(this);
            List<NotifModel> ModelClasses =db.getNotifList();

            if (ModelClasses.size() > 0){
                MyAdapter4 adapterclass = new MyAdapter4(ModelClasses,NotificationDetail.this);
                recyclerview4.setAdapter(adapterclass);
            }else {
                Toast.makeText(this, "There is no employee in the database", Toast.LENGTH_SHORT).show();
            }



        }
    }