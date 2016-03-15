package com.desmart.gitlabapkinstaller.model;

/**
 * Created by nataliajastrzebska on 12/03/16.
 */
public abstract class Repository {
    EntityFactory factory;

    public Repository(EntityFactory factory) {
        this.factory = factory;
    }

    public EntityFactory getFactory() {
        return factory;
    }
}
