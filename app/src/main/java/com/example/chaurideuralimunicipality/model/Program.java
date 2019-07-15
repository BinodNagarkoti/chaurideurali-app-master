package com.example.chaurideuralimunicipality.model;

import java.io.Serializable;

public class Program implements Serializable {
    private String date;
    private String title;
    private String body;
    private String url;

    public Program(String date, String title, String body, String url) {
        this.date = date;
        this.title = title;
        this.body = body;
        this.url = url;
    }

    public Program(){}

    public Program(String date, String title, String body) {
        this.date = date;
        this.title = title;
        this.body = body;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
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
}
