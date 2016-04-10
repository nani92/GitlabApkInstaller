package com.desmart.gitlabapkinstaller;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.desmart.gitlabapkinstaller.model.project.ProjectEntity;
import com.desmart.gitlabapkinstaller.model.project.ProjectEntityFactory;
import com.desmart.gitlabapkinstaller.model.project.ProjectsRepository;
import com.desmart.gitlabapkinstaller.model.project.useCase.GetProjectsUseCase;
import com.desmart.gitlabapkinstaller.model.user.UserEntity;
import com.desmart.gitlabapkinstaller.model.user.UserEntityFactory;
import com.desmart.gitlabapkinstaller.model.user.UsersRepository;
import com.desmart.gitlabapkinstaller.model.user.useCase.GetUserUseCase;
import com.google.gson.JsonObject;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;



public class MainActivity extends AppCompatActivity implements RecyclerView.OnItemTouchListener {
    private UserEntity userEntity;
    private GestureDetector gestureDetector;

    @Bind(R.id.projectsRecyclerView)
    RecyclerView projectsRecyclerView;

    private ProjectsRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setUserEntity();
    }

    private void setupRecyclerView(List<ProjectEntity> projectEntities) {
        setupRecyclerViewLayoutManager();
        setupRecyclerViewAdapter(projectEntities);
    }

    private void setupRecyclerViewLayoutManager() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(GridLayoutManager.VERTICAL);

        this.projectsRecyclerView.setLayoutManager(linearLayoutManager);
    }

    private void setupRecyclerViewAdapter(List<ProjectEntity> projectEntities) {
        this.adapter = new ProjectsRecyclerViewAdapter(this, projectEntities);

        this.projectsRecyclerView.setAdapter(this.adapter);
    }

    private void setupRecyclerViewClickListener() {
        gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });

        this.projectsRecyclerView.addOnItemTouchListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        ButterKnife.unbind(this);
    }

    private void setUserEntity() {
        new GetUserAsyncTask().execute();
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

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
                new GetProjectsAsyncTask().execute();
            }
        }

        private class GetProjectsAsyncTask extends AsyncTask<Void, Void, AsyncTaskResult<UserEntity>> {
            List<ProjectEntity> projectEntities;

            @Override
            protected AsyncTaskResult<UserEntity> doInBackground(Void... params) {
                ProjectsRepository projectsRepository = new ProjectsRepository(new ProjectEntityFactory(), MainActivity.this);

                try {
                    projectEntities = projectsRepository.getAllProjects();
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

                    setupRecyclerView(this.projectEntities);
                }
            }
        }
    }
}

