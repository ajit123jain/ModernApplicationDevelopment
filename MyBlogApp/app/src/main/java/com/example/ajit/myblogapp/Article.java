package com.example.ajit.myblogapp;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ajit on 16/3/17.
 */
public class Article {
    @SerializedName("id")
     Integer id;
    @SerializedName("title")
    String title;
    @SerializedName("heading")
    String heading;

    public String getHeading() {
        return heading;
    }

    @SerializedName("date")
    String date;
    @SerializedName("content")
    String content;

    public String getContent() {
        return content;
    }

    public String getDate() {

        return date;
    }

    public Integer getId() {

        return id;
    }

    public String getTitle() {

        return title;
    }
}
