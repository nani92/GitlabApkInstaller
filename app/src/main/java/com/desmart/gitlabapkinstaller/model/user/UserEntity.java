package com.desmart.gitlabapkinstaller.model.user;


import com.desmart.gitlabapkinstaller.model.Entity;
import com.desmart.gitlabapkinstaller.model.project.ProjectEntity;

import java.util.List;

/**
 * Created by nataliajastrzebska on 12/03/16.
 */
public class UserEntity implements Entity {
    public String email;
    public String name;
    public String id;
    public List<ProjectEntity> projectEntities;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ProjectEntity> getProjectEntities() {
        return projectEntities;
    }

    public void setProjectEntities(List<ProjectEntity> projectEntities) {
        this.projectEntities = projectEntities;
    }
}
