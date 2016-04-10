package com.desmart.gitlabapkinstaller.api;

import com.google.gson.JsonElement;

import org.json.JSONObject;

import java.util.List;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;


/**
 * Created by nataliajastrzebska on 12/03/16.
 */
public final class GitlabService {


    public static final String KEY_TOKEN = "TOKEN";

    public interface GitlabTokenInterface {
        @FormUrlEncoded
        @POST("session")
        Call<JsonElement> authenticate(@Field("login") String username, @Field("password") String password);

    }

    public interface GitlabServiceInterface {
        @GET("user/?private_token")
        Call<JsonElement> getUser(@Query("private_token") String token);

        @GET("projects/?private_token")
        Call<List<JsonElement>> getProjects(@Query("private_token") String token);

    }
}