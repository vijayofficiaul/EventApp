package com.example.myproject1;

public class EventModelClass {

    Integer id;
    String title;
    String venue;
    String time;
    String date;

    public EventModelClass(Integer id, String title, String venue, String time, String date, String duration, String description) {
        this.id = id;
        this.title = title;
        this.venue = venue;
        this.time = time;
        this.date = date;
        this.duration = duration;
        this.description = description;
    }

    String duration;
    String description;

    public EventModelClass(String title, String venue, String time, String date, String duration, String description) {
        this.title = title;
        this.venue = venue;
        this.time = time;
        this.date = date;
        this.duration = duration;
        this.description= description;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = title;
    }
    public String getVenue() {
        return venue;
    }

    public void setVenue(String name) {
        this.venue = venue;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String name) {
        this.time = time;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String name) {
        this.date = date;
    }
    public String getDuration() {
        return duration;
    }

    public void setDuration(String name) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String email) {
        this.description= description;
    }
}

