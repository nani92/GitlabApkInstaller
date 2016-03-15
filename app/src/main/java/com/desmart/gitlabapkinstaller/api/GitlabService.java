package com.desmart.gitlabapkinstaller.api;

import com.google.gson.JsonElement;

import org.json.JSONObject;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;


/**
 * Created by nataliajastrzebska on 12/03/16.
 */
public final class GitlabService {


    public static final String KEY_TOKEN = "TOKEN";

    public interface GitlabServiceInterface {

        @FormUrlEncoded
        @POST("session")
        Call<JsonElement> authenticate(@Field("login") String username, @Field("password") String password);

        @GET("user")
        Call<JsonElement> getUser(@Path("private_token") String privateToken);

    }
}