package com.desmart.gitlabapkinstaller.model.branch;

import com.desmart.gitlabapkinstaller.model.Entity;
import com.desmart.gitlabapkinstaller.model.EntityFactory;
import com.google.gson.JsonObject;

import net.danlew.android.joda.JodaTimeAndroid;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created by nataliajastrzebska on 12/03/16.
 */
public class BranchEntityFactory implements EntityFactory {

    @Override
    public Entity createEntity(JsonObject jsonObject) throws JSONException {
        BranchEntity branchEntity = new BranchEntity();
        branchEntity.setName(jsonObject.get("name").toString());
        branchEntity.setAuthorName(jsonObject.get("author_name").toString());
        branchEntity.setMessage(jsonObject.get("message").toString());
        //branchEntity.setCommitedDate(new JodaTimeAndroid().);

        return branchEntity;
    }
}
