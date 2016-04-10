package com.desmart.gitlabapkinstaller.model.project;

import com.desmart.gitlabapkinstaller.model.EntityFactory;
import com.google.gson.JsonObject;

import org.json.JSONException;

/**
 * Created by nataliajastrzebska on 12/03/16.
 */
public class ProjectEntityFactory implements EntityFactory {

    @Override
    public ProjectEntity createEntity(JsonObject jsonObject) throws JSONException {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId(jsonObject.get("id").getAsString());
        projectEntity.setDescription(jsonObject.get("description").getAsString());
        projectEntity.setNameWithNamespace(jsonObject.get("name_with_namespace").getAsString());

        return projectEntity;
    }
}
