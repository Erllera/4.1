package com.geektech.a41;

import java.io.Serializable;

public class NewsModel implements Serializable {

    private String text;
    private long date;

    public NewsModel(String text, long date) {
        this.text = text;
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
