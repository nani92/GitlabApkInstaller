package com.desmart.gitlabapkinstaller;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.desmart.gitlabapkinstaller.model.user.UserEntity;
import com.desmart.gitlabapkinstaller.model.user.UserEntityFactory;
import com.desmart.gitlabapkinstaller.model.user.UsersRepository;
import com.desmart.gitlabapkinstaller.model.user.useCase.GetUserUseCase;
import com.google.gson.JsonObject;

public class MainActivity extends AppCompatActivity {
    private UserEntity userEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUserEntity();

    }

    private void setUserEntity() {
        new GetUserAsyncTask().execute();
    }

    private class GetUserAsyncTask extends AsyncTask<Void, Void, AsyncTaskResult<UserEntity>> {

        @Override
        protected AsyncTaskResult<UserEntity> doInBackground(Void... params) {
            UsersRepository usersRepository = new UsersRepository(new UserEntityFactory(), MainActivity.this);

            try {
                MainActivity.this.userEntity = usersRepository.getUser();
            } catch (Exception e) {
                e.printStackTrace();

                return new AsyncTaskResult<>(e);
            }

            return null;
        }

        @Override
        protected void onPostExecute(AsyncTaskResult<UserEntity> userEntityAsyncTaskResult) {

            if (!isCancelled()) {

                if (userEntityAsyncTaskResult != null) {
                    Log.d("Error", "Error occured " + userEntityAsyncTaskResult.getError().getLocalizedMessage());

                    return;
                }

                Log.d("User", MainActivity.this.userEntity.getName());
                //LoginPresenter.this.loginCompleted();
            }
        }
    }
}
