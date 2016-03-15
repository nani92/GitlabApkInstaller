package com.desmart.gitlabapkinstaller.model.project;

import com.desmart.gitlabapkinstaller.model.Entity;
import com.desmart.gitlabapkinstaller.model.EntityFactory;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by nataliajastrzebska on 12/03/16.
 */
public class ProjectEntityFactory implements EntityFactory {

    @Override
    public Entity createEntity(JsonObject jsonObject) throws JSONException {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId(jsonObject.get("id").toString());
        projectEntity.setDescription(jsonObject.get("description").toString());
        projectEntity.setNameWithNamespace(jsonObject.get("name_with_namespace").toString());

        return projectEntity;
    }
}
