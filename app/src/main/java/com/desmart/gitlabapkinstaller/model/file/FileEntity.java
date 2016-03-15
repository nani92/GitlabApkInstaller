package com.desmart.gitlabapkinstaller.model.file;

import com.desmart.gitlabapkinstaller.model.Entity;
import com.desmart.gitlabapkinstaller.model.FileType;
import java.util.List;

/**
 * Created by nataliajastrzebska on 12/03/16.
 */
public class FileEntity implements Entity {
    public String name;
    public FileType type;
    public String id;
    public List<FileEntity> files;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FileType getType() {
        return type;
    }

    public void setType(FileType type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<FileEntity> getFiles() {
        return files;
    }

    public void setFiles(List<FileEntity> files) {
        this.files = files;
    }
}
