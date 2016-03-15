package com.desmart.gitlabapkinstaller.model.user.useCase;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.desmart.gitlabapkinstaller.api.GitlabService;
import com.desmart.gitlabapkinstaller.api.ServiceGenerator;
import com.desmart.gitlabapkinstaller.model.UseCase;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by nataliajastrzebska on 13/03/16.
 */
public class GetUserUseCase implements UseCase {
    JsonObject jsonObject;
    Context context;

    public GetUserUseCase(JsonObject jsonObject, Context context) {
        this.jsonObject = jsonObject;
        this.context = context;
    }

    @Override
    public void execute() throws Exception {
        GitlabService.GitlabServiceInterface client = ServiceGenerator.createService(GitlabService.GitlabServiceInterface.class, this.context);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this.context);
        Call<JsonElement> auth = client.getUser(prefs.getString(GitlabService.KEY_TOKEN, ""));
        auth.enqueue(new Callback<JsonElement>() {

            @Override
            public void onResponse(Response<JsonElement> response, Retrofit retrofit) {
                GetUserUseCase.this.jsonObject = response.body().getAsJsonObject();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}
