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

public class EmployeeDetails extends AppCompatActivity {

    RecyclerView recyclerview1;
    DrawerLayout drawerlayout;
    ImageView menu4;
    CardView card1,card2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);

        recyclerview1 = findViewById(R.id.recyclerview1);
        drawerlayout=findViewById(R.id.drawer4);
        menu4=findViewById(R.id.menu4);
        card1=findViewById(R.id.card1);
        card2=findViewById(R.id.card2);
        menu4.setOnClickListener(new View.OnClickListener()
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
                Intent in=new Intent(EmployeeDetails.this,Home.class);
                startActivity(in);
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(EmployeeDetails.this,MainActivity.class);
                startActivity(in);
            }
        });
        recyclerview1.setLayoutManager(new LinearLayoutManager(this));
        recyclerview1.setHasFixedSize(true);

        dbhelper2 db = new dbhelper2(this);
        List<EmployeeModel> employeeModelClasses =db.getEmployeeList();

        if (employeeModelClasses.size() > 0){
            MyAdapter1 employeadapterclass = new MyAdapter1(employeeModelClasses,EmployeeDetails.this);
            recyclerview1.setAdapter(employeadapterclass);
        }else {
            Toast.makeText(this, "There is no employee in the database", Toast.LENGTH_SHORT).show();
        }



    }
}