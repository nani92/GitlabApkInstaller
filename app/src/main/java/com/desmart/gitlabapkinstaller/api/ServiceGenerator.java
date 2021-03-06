package com.desmart.gitlabapkinstaller.api;


import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class ServiceGenerator {



    public static final String API_BASE_URL = AuthInterceptor.KEY_API_URL;

    private static OkHttpClient httpClient = new OkHttpClient();

    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(API_BASE_URL);

    public static <S> S createService(Class<S> serviceClass, Context context) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.interceptors().add(interceptor);
        httpClient.interceptors().add(new AuthInterceptor(context));

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        Retrofit retrofit = builder.addConverterFactory(GsonConverterFactory.create(gson)).client(httpClient).build();
        return retrofit.create(serviceClass);
    }
}
