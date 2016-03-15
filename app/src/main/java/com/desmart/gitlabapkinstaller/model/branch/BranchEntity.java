package com.desmart.gitlabapkinstaller.model.branch;


import com.desmart.gitlabapkinstaller.model.Entity;

import java.util.Date;

/**
 * Created by nataliajastrzebska on 12/03/16.
 */
public class BranchEntity implements Entity {
    public String name;
    public String message;
    public String authorName;
    public Date commitedDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getCommitedDate() {
        return commitedDate;
    }

    public void setCommitedDate(Date commitedDate) {
        this.commitedDate = commitedDate;
    }
}
