package com.none.recycleviewdemo.service;

import android.provider.ContactsContract;

import com.none.recycleviewdemo.Constant;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lihenair on 16/6/7.
 */
public class NewsClient {

    private static final int DEFAULT_TIMEOUT = 5;

    private Retrofit retrofit;
    private NewsService service;

    public NewsClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        builder.addInterceptor(logging);

        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constant.API_URL)
                .build();
        service = retrofit.create(NewsService.class);
    }

    public NewsService getService() {
        return service;
    }
}
