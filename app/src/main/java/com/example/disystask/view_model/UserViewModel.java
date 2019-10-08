package com.example.disystask.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.disystask.repository.ArticleRepository;
import com.example.disystask.response.ArticleResponse;


public class UserViewModel extends AndroidViewModel {

    private ArticleRepository articleRepository;
    private LiveData<ArticleResponse> articleResponseLiveData;

    public UserViewModel(@NonNull Application application) {
        super(application);

        articleRepository = new ArticleRepository();
        this.articleResponseLiveData = articleRepository.getMovieArticles("en");
    }

    public LiveData<ArticleResponse> getUserRegisterResponseLiveData() {
        return articleResponseLiveData;
    }
}
