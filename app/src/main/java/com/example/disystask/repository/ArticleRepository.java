package com.example.disystask.repository;


import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.disystask.response.ArticleResponse;
import com.example.disystask.retrofit.ApiRequest;
import com.example.disystask.retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleRepository {
    private static final String TAG = ArticleRepository.class.getSimpleName();
    private ApiRequest apiRequest;

    public ArticleRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData<ArticleResponse> getMovieArticles(String key) {
        final MutableLiveData<ArticleResponse> data = new MutableLiveData<>();
        apiRequest.getMovieArticles(key).enqueue(new Callback<ArticleResponse>() {
            @Override
            public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
                Log.d(TAG, "onResponse response:: " + response);

                if (response.body() != null) {
                    data.setValue(response.body());
                    Log.d(TAG, "articles size:: " + response.body().getArticles().size());
                }
            }

            @Override
            public void onFailure(Call<ArticleResponse> call, Throwable t) {
                data.setValue(null);
                Log.e(TAG, " " + t.toString());
            }
        });
        return data;
    }

    public LiveData<ArticleResponse> userRegisterRequest(String phone,String email,String name,String unified,String eid,String idbarahno) {
        final MutableLiveData<ArticleResponse> data = new MutableLiveData<>();
        apiRequest.registerUser(eid,name,idbarahno,email,unified,phone).enqueue(new Callback<ArticleResponse>() {
            @Override
            public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
                Log.d(TAG, "onResponse response:: " + response);

                if (response.body() != null) {
                    data.setValue(response.body());
                    Log.d(TAG, "articles size:: " + response.body().getArticles().size());
                } else {
                    data.setValue(null);
                    Log.d(TAG, "articles size:: Failed");
                }
            }

            @Override
            public void onFailure(Call<ArticleResponse> call, Throwable t) {
                data.setValue(null);
                Log.e(TAG, " " + t.toString());
            }
        });
        return data;
    }
}
