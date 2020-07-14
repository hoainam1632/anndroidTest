package com.example.webblog;

public class listContent {
    private String img;
    private  String title;
    private String date;
    public listContent(String img, String title, String date) {
        this.img = img;
        this.title = title;
        this.date = date;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
