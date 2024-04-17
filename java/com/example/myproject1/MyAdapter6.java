package com.example.myproject1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter6 extends RecyclerView.Adapter<MyAdapter6.MyViewHolder> {

    List<EventModelClass> event;
    Context context;
    dbhelper1 db;

    public MyAdapter6(List<EventModelClass> event, Context context) {
        this.event = event;
        this.context = context;
        db = new dbhelper1(context);

    }


    @NonNull
    @Override
    public MyAdapter6.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.edit_event_list,parent,false);
        MyAdapter6.MyViewHolder viewHolder = new MyAdapter6.MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter6.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final EventModelClass eventModelClass = event.get(position);
        holder.eventid1.setText(Integer.toString(eventModelClass.getId()));
        holder.title.setText(eventModelClass.getTitle());
    }




    @Override
    public int getItemCount() {
        return event.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        EditText title,eventid1;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            eventid1=itemView.findViewById(R.id.eventid1);
            title=itemView.findViewById(R.id.eventitle);
        }
    }
}

