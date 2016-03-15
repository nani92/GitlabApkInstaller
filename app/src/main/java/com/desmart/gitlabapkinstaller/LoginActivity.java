package com.desmart.gitlabapkinstaller;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.desmart.gitlabapkinstaller.model.user.UserEntity;
import com.desmart.gitlabapkinstaller.model.user.UsersRepository;
import com.desmart.gitlabapkinstaller.model.user.useCase.LoginUserUseCase;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.loginEditText)
    EditText loginEditText;

    @Bind(R.id.passwordEditText)
    EditText passwordEditText;

    @Bind(R.id.loginButton)
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        ButterKnife.unbind(this);
    }

    @OnTextChanged(R.id.loginEditText)
    public void loginEditTextChanged() {
        loginButton.setEnabled(areDataValid());
    }

    @OnTextChanged(R.id.passwordEditText)
    public void passwordEditTextChanged() {
        loginButton.setEnabled(areDataValid());
    }

    private Boolean areDataValid() {
        return !TextUtils.isEmpty(loginEditText.getText()) && !TextUtils.isEmpty(passwordEditText.getText());
    }

    @OnClick(R.id.loginButton)
    public void onLoginButtonClicked() {
        new LoginUserAsyncTask(loginEditText.getText().toString(), passwordEditText.getText().toString()).execute();
    }

    private void LoginCompleted() {

    }

    private class LoginUserAsyncTask extends AsyncTask<Void, Void, AsyncTaskResult<UserEntity>> {
        private String email;
        private String password;

        public LoginUserAsyncTask(String email, String password) {
            this.email = email;
            this.password = password;
        }

        @Override
        protected AsyncTaskResult<UserEntity> doInBackground(Void... params) {
            LoginUserUseCase loginUserUseCase = new LoginUserUseCase(LoginActivity.this, this.email, this.password);

            try {
                loginUserUseCase.execute();
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

                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                //LoginPresenter.this.loginCompleted();
            }
        }
    }
}
