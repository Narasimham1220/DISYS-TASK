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
    private String phone, email, name, unified, eid, idbarahno;


    public UserViewModel(@NonNull Application application) {
        super(application);
        articleRepository = new ArticleRepository();
    }

    public LiveData<ArticleResponse> getUserRegisterResponseLiveData(String phone, String email, String name, String unified, String eid, String idbarahno) {
        this.phone = phone;
        this.email = email;
        this.name = name;
        this.unified = unified;
        this.idbarahno = idbarahno;
        this.eid = eid;
        this.articleResponseLiveData = articleRepository.userRegisterRequest(phone, email, name, unified, eid, idbarahno);
        return articleResponseLiveData;
    }
}
