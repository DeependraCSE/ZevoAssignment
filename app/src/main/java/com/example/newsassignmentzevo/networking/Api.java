package com.example.newsassignmentzevo.networking;

import com.example.newsassignmentzevo.newslist.model_classes.Model_NewsList;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface Api {
    @GET(Constant.GetNewsList)
    Call<Model_NewsList> getNewsList(@QueryMap Map<String, String> params);
}
