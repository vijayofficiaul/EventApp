package com.example.myproject1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter7  extends RecyclerView.Adapter<MyAdapter7.MyViewHolder>
{

    private Context context;
    private ArrayList query;
    dbhelper dbHelper;

    public MyAdapter7 (Context context , ArrayList query)
    {
        this.context = context;
        //this.mail = mail;
        this.query = query;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.query_list,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        dbHelper=new dbhelper(context);
        //holder.qemail.setText(String.valueOf(mail.get(position)));
        holder.que.setText(String.valueOf(query.get(position)));

    }

    @Override
    public int getItemCount() {
        return query.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder {

        EditText que;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //qemail=itemView.findViewById(R.id.qemail);
            que=itemView.findViewById(R.id.que);

        }
    }
}