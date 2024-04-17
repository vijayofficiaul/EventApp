package com.example.myproject1;

public class NotifModel {

    Integer id;
    String titleS;
    String contentS;

    public NotifModel(Integer id, String titleS, String contentS) {
        this.id = id;
        this.titleS = titleS;
        this.contentS = contentS;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitleS() {
        return titleS;
    }
    public void setTitleS(String name) {
        this.titleS = titleS;
    }
    public String getContentS() {
        return contentS;
    }
    public void setContentS(String email) {
        this.contentS = contentS;
    }
    public NotifModel(String title, String content) {
        this.titleS = title;
        this.contentS = content;
    }



}
