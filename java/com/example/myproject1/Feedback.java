package com.example.myproject1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Feedback extends AppCompatActivity {

    RecyclerView recyclerView;
    DrawerLayout drawerlayout;
    ImageView menu16;
    CardView card1,card2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        recyclerView=findViewById(R.id.recyclerview8);
        drawerlayout=findViewById(R.id.drawer16);
        menu16=findViewById(R.id.menu16);
        card1=findViewById(R.id.card1);
        card2=findViewById(R.id.card2);
        menu16.setOnClickListener(new View.OnClickListener()
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
                Intent in=new Intent(Feedback.this,Home.class);
                startActivity(in);
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Feedback.this,MainActivity.class);
                startActivity(in);
            }
        });
    }
}