package com.example.myproject1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class CreateEmployee extends AppCompatActivity {

    //Spinner spinner;
    EditText net1,net2,net3,net4,net5,net6,net7;
    Button submit1;
    String stn1,stn2,stn3,stn4,stn5,stn6,stn7;
    dbhelper2 db;
    DrawerLayout drawerlayout;
    ImageView menu3;
    CardView card1,card2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_employee);
        //spinner = findViewById(R.id.spinner);
        net1=findViewById(R.id.net1);
        net2=findViewById(R.id.net2);
        net3=findViewById(R.id.net3);
        net4=findViewById(R.id.net4);
        net5=findViewById(R.id.net5);
        net6=findViewById(R.id.net6);
        net7=findViewById(R.id.net7);
        submit1=findViewById(R.id.submit1);
        drawerlayout=findViewById(R.id.drawer3);
        menu3=findViewById(R.id.menu3);
        card1=findViewById(R.id.card1);
        card2=findViewById(R.id.card2);
        menu3.setOnClickListener(new View.OnClickListener()
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
                Intent in=new Intent(CreateEmployee.this,Home.class);
                startActivity(in);
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(CreateEmployee.this,MainActivity.class);
                startActivity(in);
            }
        });
        db=new dbhelper2(this);

        /*ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.gender_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedGender = parentView.getItemAtPosition(position).toString();
                Toast.makeText(CreateEmployee.this, "Selected Gender: " + selectedGender, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });*/
        submit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stn1=net1.getText().toString();
                stn2=net2.getText().toString();
                stn3=net3.getText().toString();
                stn4=net4.getText().toString();
                stn5=net5.getText().toString();
                stn6=net6.getText().toString();
                stn7=net7.getText().toString();

                if (stn1.length() <=0 || stn2.length() <=0 || stn3.length() <=0 || stn4.length() <=0 || stn5.length() <=0 || stn6.length() <=0 || stn7.length() <=0){
                    Toast.makeText(CreateEmployee.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                }else {

                    EmployeeModel employeeModel = new EmployeeModel(stn1,stn2,stn3,stn4,stn5,stn6,stn7);
                    db.addEmployee(employeeModel);
                    Toast.makeText(CreateEmployee.this, "Added  Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }

            }

        });
    }
}