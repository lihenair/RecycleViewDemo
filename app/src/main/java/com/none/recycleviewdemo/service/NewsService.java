package com.none.recycleviewdemo.service;

import com.none.recycleviewdemo.model.NewsModel;
import com.none.recycleviewdemo.model.NewsResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by lihenair on 16/6/7.
 */
public interface NewsService {
    @GET("{type}/?")
    Call<NewsResult> getNews(
            @Path("type") String type,
            @Query("key") String key,
            @Query("num") int num,
            @Query("rand") int rand,
            @Query("word") String word,
            @Query("page") int page);
}
