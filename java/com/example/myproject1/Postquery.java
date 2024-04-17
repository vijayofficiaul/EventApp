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

public class Postquery extends AppCompatActivity {

    DrawerLayout drawerlayout;
    ImageView menu8;
    CardView card1,card2;
    Button postquery;
    EditText queryID,Queryname,Userid,QueryDes;
    String id,etitle,emailid,IDs,NameS,UserS,Description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postquery);
        drawerlayout=findViewById(R.id.drawer8);
        menu8=findViewById(R.id.menu8);
        card1=findViewById(R.id.card1);
        card2=findViewById(R.id.card2);
        queryID=findViewById(R.id.queryID);
        Queryname=findViewById(R.id.Queryname);
        Userid=findViewById(R.id.Userid);
        QueryDes=findViewById(R.id.QueryDes);
        postquery=findViewById(R.id.postquery);
        Intent in=getIntent();
        id=in.getStringExtra("Id");
        etitle=in.getStringExtra("titleS");
        emailid=in.getStringExtra("email");
        Userid.setText(emailid);
        queryID.setText(id);
        Queryname.setText(etitle);

        menu8.setOnClickListener(new View.OnClickListener()
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
                Intent in=new Intent(Postquery.this,UserHome.class);
                startActivity(in);
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Postquery.this,MainActivity.class);
                startActivity(in);
            }
        });
        postquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IDs=queryID.getText().toString();
                NameS=Queryname.getText().toString();
                UserS=Userid.getText().toString();
                Description=QueryDes.getText().toString();
                if (IDs.length() <=0 || NameS.length() <=0 || UserS.length() <=0 || Description.length() <=0){
                    Toast.makeText(Postquery.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                }else {

                    dbhelper db = new dbhelper(Postquery.this);
                    boolean query=db.insertquery(Description);
                    if (query==true){
                        Toast.makeText(Postquery.this, "Added  Successfully", Toast.LENGTH_SHORT).show();
                    }
                    startActivity(getIntent());
                }
            }
        });
    }
}