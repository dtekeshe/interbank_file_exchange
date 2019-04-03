package com.bsva.dao.v02;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.params.Directory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class DirectoryDAO extends AbstractDao<Directory, Void> {

    private final static String DIRECTORY_SQL =
            "SELECT DIRECTORY_NAME, DIRECTORY_PATH " +
            "  FROM CSF_DIRECTORIES ";

    public Map<String, String> directories() {

        // execute
        List<Directory> entities
                = list(DIRECTORY_SQL, Directory.class);

        // prepare result
        Map<String, String> directories = new HashMap<>();

        for ( Directory directory : entities ) {

            try {

                directories.put(directory.getDirectoryName(), directory.getDirectoryPath());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return directories;
    }

    public String directory(String directoryName) {
        Map<String, String> directories = directories();

        return directories.get(directoryName);
    }
}
