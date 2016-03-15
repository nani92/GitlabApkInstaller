package com.desmart.gitlabapkinstaller.model.file;

import com.desmart.gitlabapkinstaller.model.Entity;
import com.desmart.gitlabapkinstaller.model.EntityFactory;
import com.desmart.gitlabapkinstaller.model.FileType;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by nataliajastrzebska on 12/03/16.
 */
public class FileEntityFactory implements EntityFactory{

    @Override
    public Entity createEntity(JsonObject jsonObject) throws JSONException {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setId(jsonObject.get("id").toString());
        fileEntity.setName(jsonObject.get("name").toString());
        fileEntity.setType(FileType.typeFromString(jsonObject.get("type").toString()));

        return fileEntity;
    }
}
