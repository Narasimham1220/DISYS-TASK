package com.example.disystask.retrofit;


import com.example.disystask.response.ArticleResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiRequest {

    @Headers({"Accept: application/json", "consumer-key: mobile_dev", "consumer-secret: 20891a1b4504ddc33d42501f9c8d2215fbe85008"})
    @GET("mrhecloud/v1.4/api/public/v1/news")
    Call<ArticleResponse> getMovieArticles(@Query("local") String local);

}
