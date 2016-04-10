package com.desmart.gitlabapkinstaller.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class AuthInterceptor implements Interceptor{

    public static final String KEY_API_URL =  "http://gitlab.desmart.com/api/v3/";

    private final Context context;


    public AuthInterceptor(Context context) {

        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Log.d("Natalia", "Intercept");
        Request request = chain.request();
        Request newRequest;

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String token = preferences.getString(GitlabService.KEY_TOKEN, "");

        if(!token.isEmpty()) {
            newRequest = request.newBuilder().addHeader("PRIVATE-TOKEN", token).build();

            return chain.proceed(newRequest);
        }

        return chain.proceed(request);
    }
}
