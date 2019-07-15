package com.example.chaurideuralimunicipality.model;

import java.io.Serializable;

public class Notice implements Serializable {

    private String date;
    private String title;
    private String body;
    private String url;


    public Notice(){}  //empty constructor for reading data from database

    public Notice(String date, String title, String body, String url) {
        this.date = date;
        this.title = title;
        this.body = body;
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
