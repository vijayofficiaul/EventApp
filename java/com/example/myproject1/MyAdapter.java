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

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<EventModelClass> event;
    Context context;
    dbhelper1 db;

    public MyAdapter(List<EventModelClass> event, Context context) {
        this.event = event;
        this.context = context;
        db = new dbhelper1(context);

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.edit_event_list,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final EventModelClass eventModelClass = event.get(position);
        holder.eventid1.setText(Integer.toString(eventModelClass.getId()));
        holder.title.setText(eventModelClass.getTitle());
        holder.venue.setText(eventModelClass.getVenue());
        holder.time.setText(eventModelClass.getVenue());
        holder.date.setText(eventModelClass.getDate());
        holder.duration.setText(eventModelClass.getDuration());
        holder.description.setText(eventModelClass.getDescription());

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String titleS = holder.title.getText().toString();
                String venueS = holder.venue.getText().toString();
                String timeS = holder.time.getText().toString();
                String dateS = holder.date.getText().toString();
                String durationS = holder.duration.getText().toString();
                String descriptionS = holder.description.getText().toString();

                db. updateEvent(new EventModelClass(eventModelClass.getId(),titleS,venueS,timeS,dateS,durationS,descriptionS));
                notifyDataSetChanged();
                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteEvent((eventModelClass.getId()));
                event.remove(position);
                notifyDataSetChanged();
            }
        });
    }




    @Override
    public int getItemCount() {
        return event.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        EditText title,venue,time,date,duration,description,eventid1;
        Button edit,delete;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            eventid1=itemView.findViewById(R.id.eventid1);
            title=itemView.findViewById(R.id.eventitle);
            venue=itemView.findViewById(R.id.venue);
            time=itemView.findViewById(R.id.time);
            date=itemView.findViewById(R.id.date);
            duration=itemView.findViewById(R.id.duration);
            description=itemView.findViewById(R.id.description);
            edit=itemView.findViewById(R.id.edit);
            delete=itemView.findViewById(R.id.delete);

        }
    }
}
