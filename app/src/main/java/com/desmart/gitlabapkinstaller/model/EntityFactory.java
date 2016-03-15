package com.desmart.gitlabapkinstaller.model;

import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by nataliajastrzebska on 12/03/16.
 */
public interface EntityFactory {
    Entity createEntity(JsonObject jsonObject) throws JSONException;
}
