package com.desmart.gitlabapkinstaller.model.project;


import com.desmart.gitlabapkinstaller.model.Entity;

/**
 * Created by nataliajastrzebska on 12/03/16.
 */
public class ProjectEntity implements Entity {
    public String id;
    public String description;
    public String nameWithNamespace;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNameWithNamespace() {
        return nameWithNamespace;
    }

    public void setNameWithNamespace(String nameWithNamespace) {
        this.nameWithNamespace = nameWithNamespace;
    }
}
