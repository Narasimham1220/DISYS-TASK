package com.example.disystask.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Article implements Serializable {

    @SerializedName("title")
    private String title;
    @SerializedName("image")
    private String urlToImage;
    @SerializedName("date")
    private String publishedAt;
    @SerializedName("description")
    private String description;


    public String getTitle() {
        return title;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getDescription() {
        return description;
    }

}
