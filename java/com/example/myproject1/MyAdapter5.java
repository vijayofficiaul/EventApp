package com.example.myproject1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter5 extends RecyclerView.Adapter<MyAdapter5.MyViewHolder> {

    List<NotifModel> notification;
    Context context;
    dbhelper3 db;

    public MyAdapter5(List<NotifModel> notification, Context context) {
        this.notification = notification;
        this.context = context;
        db = new dbhelper3(context);

    }


    @NonNull
    @Override
    public MyAdapter5.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.notif_view_list,parent,false);
        MyAdapter5.MyViewHolder viewHolder = new MyAdapter5.MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter5.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final NotifModel ModelClass = notification.get(position);
        holder.notifid.setText(Integer.toString(ModelClass.getId()));
        holder.title.setText(ModelClass.getTitleS());
        holder.content.setText(ModelClass.getContentS());
    }
    @Override
    public int getItemCount() {
        return notification.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        EditText title,content,notifid;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            notifid=itemView.findViewById(R.id.notifid1);
            title=itemView.findViewById(R.id.notiftitle1);
            content=itemView.findViewById(R.id.notifcontent1);
        }
    }
}

