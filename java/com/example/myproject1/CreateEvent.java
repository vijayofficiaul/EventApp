package com.example.myproject1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class CreateEvent extends AppCompatActivity {
    DrawerLayout drawerlayout;
    ImageView menu1;
    EditText et1,et2,et3,et4,et5,et6;
    Button submit;
    String st1,st2,st3,st4,st5,st6;
    CardView card1,card2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        drawerlayout=findViewById(R.id.drawerlayout1);
        menu1=findViewById(R.id.menu1);
        card1=findViewById(R.id.card1);
        card2=findViewById(R.id.card2);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        et3=findViewById(R.id.et3);
        et4=findViewById(R.id.et4);
        et5=findViewById(R.id.et5);
        et6=findViewById(R.id.queryID);
        submit=findViewById(R.id.submit);
        menu1.setOnClickListener(new View.OnClickListener()
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
                Intent in=new Intent(CreateEvent.this,Home.class);
                startActivity(in);
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(CreateEvent.this,MainActivity.class);
                startActivity(in);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                st1=et1.getText().toString();
                st2=et2.getText().toString();
                st3=et3.getText().toString();
                st4=et4.getText().toString();
                st5=et5.getText().toString();
                st6=et6.getText().toString();

                if (st1.length() <=0 || st2.length() <=0 || st3.length() <=0 || st4.length() <=0 || st5.length() <=0 || st6.length() <=0){
                    Toast.makeText(CreateEvent.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    dbhelper1 db = new dbhelper1(CreateEvent.this);
                    EventModelClass eventModelClass = new EventModelClass(st1,st2,st3,st4,st5,st6);
                    db.addEvent(eventModelClass);
                    Toast.makeText(CreateEvent.this, "Added  Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());

                }
            }
        });
        et4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });
        et3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar currentTime = Calendar.getInstance();
                int hour = currentTime.get(Calendar.HOUR_OF_DAY);
                int minute = currentTime.get(Calendar.MINUTE);

                // Create a TimePickerDialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(CreateEvent.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
                                // Set the selected time to the EditText
                                et3.setText(selectedHour + ":" + selectedMinute);
                            }
                        },
                        hour, minute, true);
                timePickerDialog.show();
            }
        });
    }

    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                        et4.setText(selectedDate);
                    }
                },
                year, month, dayOfMonth
        );

        datePickerDialog.show();
    }
}