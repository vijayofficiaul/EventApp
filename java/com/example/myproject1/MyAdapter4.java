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

public class MyAdapter4 extends RecyclerView.Adapter<MyAdapter4.MyViewHolder4> {

    List<NotifModel> notification;
    Context context;
    dbhelper3 db;

    public MyAdapter4(List<NotifModel> notification, Context context) {
        this.notification = notification;
        this.context = context;
        db = new dbhelper3(context);

    }

    @NonNull
    @Override
    public MyAdapter4.MyViewHolder4 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_notif_list,parent,false);
        MyAdapter4.MyViewHolder4 viewHolder = new MyAdapter4.MyViewHolder4(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter4.MyViewHolder4 holder, @SuppressLint("RecyclerView") int position) {
        final NotifModel notifModel = notification.get(position);
        holder.notifid.setText(Integer.toString(notifModel.getId()));
        holder.title.setText(notifModel.getTitleS());
        holder.content.setText(notifModel.getContentS());

        holder.edit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String stringtitle = holder.title.getText().toString();
                String stringcontent = holder.content.getText().toString();
                db.updateNotif(new NotifModel(notifModel.getId(),stringtitle,stringcontent));
                notifyDataSetChanged();
                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());
            }
        });

        holder.delete2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteNotif((notifModel.getId()));
                notification.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return notification.size();
    }
    public class MyViewHolder4 extends RecyclerView.ViewHolder
    {
        EditText title,content,notifid;
        Button edit2,delete2;
        public MyViewHolder4(@NonNull View itemView) {
            super(itemView);
            notifid=itemView.findViewById(R.id.notifid);
            title=itemView.findViewById(R.id.notiftitle);
            content=itemView.findViewById(R.id.notifcontent);
            delete2=itemView.findViewById(R.id.delete2);
            edit2=itemView.findViewById(R.id.edit2);
        }
    }
}

