package com.desmart.gitlabapkinstaller.model.project;

import android.content.Context;

import com.desmart.gitlabapkinstaller.model.EntityFactory;
import com.desmart.gitlabapkinstaller.model.Repository;
import com.desmart.gitlabapkinstaller.model.project.useCase.GetProjectsUseCase;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nataliajastrzebska on 10/04/16.
 */
public class ProjectsRepository extends Repository {
    private ProjectEntityFactory projectEntityFactory;
    private Context context;
    private List<ProjectEntity> projectEntities;

    public ProjectsRepository(EntityFactory factory, Context context) {
        super(factory);

        this.projectEntityFactory = (ProjectEntityFactory) factory;
        this.context = context;
        this.projectEntities = new ArrayList<>();
    }

    public List<ProjectEntity> getAllProjects() throws Exception {
        GetProjectsUseCase getProjectsUseCase = new GetProjectsUseCase(context);

        try {
            getProjectsUseCase.execute();

            for (JsonElement jsonElement: getProjectsUseCase.getProjectElements()) {
                this.projectEntities.add(this.projectEntityFactory.createEntity(jsonElement.getAsJsonObject()));
            }
        }
        finally {
            return this.projectEntities;
        }
    }
}
