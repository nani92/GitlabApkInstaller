package com.desmart.gitlabapkinstaller.model;

/**
 * Created by nataliajastrzebska on 12/03/16.
 */
public enum FileType {
    TREE,
    BLOB,
    UNKNOWN;

    public static String STRING_TYPE_TREE = "tree";
    public static String STRING_TYPE_BLOB = "blob";

    public static FileType typeFromString(String type) {

        if (type.equals(STRING_TYPE_TREE)) {
            return TREE;
        }

        if (type.equals(STRING_TYPE_BLOB)) {
            return BLOB;
        }

        return UNKNOWN;
    }
}


