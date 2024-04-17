package com.example.myproject1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CreateNotification extends AppCompatActivity {

    EditText titleN,contentN;
    Button post;
    String titleSN,contentSN;
    dbhelper3 db;
    DrawerLayout drawerlayout;
    ImageView menu9;
    CardView card1,card2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_notification);
        titleN=findViewById(R.id.titleN);
        contentN=findViewById(R.id.contentN);
        post=findViewById(R.id.post);
        drawerlayout=findViewById(R.id.drawer10);
        menu9=findViewById(R.id.menu9);
        card1=findViewById(R.id.card1);
        card2=findViewById(R.id.card2);
        menu9.setOnClickListener(new View.OnClickListener()
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
                Intent in=new Intent(CreateNotification.this,Home.class);
                startActivity(in);
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(CreateNotification.this,MainActivity.class);
                startActivity(in);
            }
        });
        db=new dbhelper3(this);
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                titleSN=titleN.getText().toString();
                contentSN=contentN.getText().toString();

                if (titleSN.length() <=0 || contentSN.length() <=0 ){
                    Toast.makeText(CreateNotification.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                }else {

                    NotifModel notifModel = new NotifModel(titleSN,contentSN);
                    db.addnotif(notifModel);
                    Toast.makeText(CreateNotification.this, "Added  Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }

            }

        });
    }
}