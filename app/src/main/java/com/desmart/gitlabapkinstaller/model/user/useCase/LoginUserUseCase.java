package com.desmart.gitlabapkinstaller.model.user.useCase;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.desmart.gitlabapkinstaller.api.GitlabService;
import com.desmart.gitlabapkinstaller.api.ServiceGenerator;
import com.desmart.gitlabapkinstaller.model.UseCase;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


import org.json.JSONObject;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


/**
 * Created by nataliajastrzebska on 12/03/16.
 */
public class LoginUserUseCase implements UseCase {
    public String login;
    public String password;
    public Context context;

    public LoginUserUseCase(Context context, String login, String password) {
        this.login = login;
        this.password = password;
        this.context = context;
    }

    @Override
    public void execute() throws Exception {
        GitlabService.GitlabServiceInterface client = ServiceGenerator.createService(GitlabService.GitlabServiceInterface.class, this.context);
        Call<JsonElement> auth = client.authenticate(this.login, this.password);
        auth.enqueue(new Callback<JsonElement>() {

            @Override
            public void onResponse(Response<JsonElement> response, Retrofit retrofit) {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
                JsonObject jsonObject = response.body().getAsJsonObject();
                String privateToken = jsonObject.get("private_token").toString();
                prefs.edit().putString(GitlabService.KEY_TOKEN, privateToken).apply();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}
