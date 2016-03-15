package com.desmart.gitlabapkinstaller.model.user;

import com.desmart.gitlabapkinstaller.model.Entity;
import com.desmart.gitlabapkinstaller.model.EntityFactory;
import com.google.gson.JsonObject;

import org.gitlab.api.models.GitlabUser;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by nataliajastrzebska on 12/03/16.
 */
public class UserEntityFactory implements EntityFactory {

    @Override
    public Entity createEntity(JsonObject jsonObject) throws JSONException {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(jsonObject.get("id").toString());
        userEntity.setEmail(jsonObject.get("email").toString());
        userEntity.setName(jsonObject.get("username").toString());

        return userEntity;
    }

    public Entity createEntity(GitlabUser gitlabUser) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(gitlabUser.getId().toString());
        userEntity.setEmail(gitlabUser.getEmail());
        userEntity.setName(gitlabUser.getName());

        return userEntity;
    }
}
