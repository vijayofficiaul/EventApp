package com.example.myproject1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Myquery extends AppCompatActivity {

    DrawerLayout drawerlayout;
    ImageView menu7;
    CardView card1,card2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myquery);
        drawerlayout=findViewById(R.id.drawer7);
        menu7=findViewById(R.id.menu7);
        card1=findViewById(R.id.card1);
        card2=findViewById(R.id.card2);
        menu7.setOnClickListener(new View.OnClickListener()
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
                Intent in=new Intent(Myquery.this,UserHome.class);
                startActivity(in);
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Myquery.this,MainActivity.class);
                startActivity(in);
            }
        });
    }
}