package com.desmart.gitlabapkinstaller.model.user;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.desmart.gitlabapkinstaller.AsyncTaskResult;
import com.desmart.gitlabapkinstaller.model.EntityFactory;
import com.desmart.gitlabapkinstaller.model.Repository;
import com.desmart.gitlabapkinstaller.model.user.useCase.GetUserUseCase;
import com.google.gson.JsonObject;

import org.json.JSONException;

/**
 * Created by nataliajastrzebska on 12/03/16.
 */
public class UsersRepository extends Repository {
    UserEntityFactory userEntityFactory;
    Context context;

    public UsersRepository(EntityFactory factory, Context context) {
        super(factory);

        this.userEntityFactory = (UserEntityFactory) factory;
        this.context = context;
    }

    private UserEntity createUser(JsonObject jsonObject) throws JSONException {
        return (UserEntity) this.userEntityFactory.createEntity(jsonObject);
    }

    public UserEntity getUser() throws Exception {
        GetUserUseCase getUserUseCase = new GetUserUseCase(new JsonObject(), this.context);

        try {
            getUserUseCase.execute();
        }
        catch (Exception exception) {

        }
        finally {
            return createUser(getUserUseCase.getJsonObject());
        }
    }
}
