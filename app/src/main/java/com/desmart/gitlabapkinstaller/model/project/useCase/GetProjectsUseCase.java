package com.desmart.gitlabapkinstaller.model.project.useCase;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.desmart.gitlabapkinstaller.api.GitlabService;
import com.desmart.gitlabapkinstaller.api.ServiceGenerator;
import com.desmart.gitlabapkinstaller.model.UseCase;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit.Call;

/**
 * Created by nataliajastrzebska on 10/04/16.
 */
public class GetProjectsUseCase implements UseCase {
    private Context context;
    private List<JsonElement> projectElements;

    public GetProjectsUseCase(Context context) {
        this.context = context;
    }

    @Override
    public void execute() throws Exception {
        GitlabService.GitlabServiceInterface client = ServiceGenerator.createService(GitlabService.GitlabServiceInterface.class, this.context);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this.context);
        String privateToken = prefs.getString(GitlabService.KEY_TOKEN, "");
        Call<List<JsonElement>> getProjects = client.getProjects(privateToken);
        this.projectElements = getProjects.execute().body();
    }

    public List<JsonElement> getProjectElements() {
        return projectElements;
    }
}
