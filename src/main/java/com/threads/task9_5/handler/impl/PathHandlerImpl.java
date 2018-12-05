package com.threads.task9_5.handler.impl;

import com.threads.task9_5.handler.PathHandler;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PathHandlerImpl implements PathHandler {

    private List<String> paths;
    private String directoryPath;

    public PathHandlerImpl(List<String> paths, String directoryPath) {
        this.paths = paths;
        this.directoryPath = directoryPath;
    }

    public List<String> findAllPaths() {
        try {
            getAllPaths(paths, directoryPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return paths;
    }

    private void getAllPaths(List<String> pathsList, String path) throws IOException {
        File dir = new File(path);
        File[] list = dir.listFiles();
        if (list != null) {
            for (File file : list) {
                if (file.isFile()) {
                    pathsList.add(file.getCanonicalPath());
                } else {
                    getAllPaths(pathsList, file.getCanonicalPath());
                }
            }
        }
    }
}
