package com.example.disystask.response;

import com.example.disystask.model.Article;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ArticleResponse implements Serializable {

    @SerializedName("payload")
    @Expose
    private List<Article> articles = null;

    public List<Article> getArticles() {
        return articles;
    }

}
