package com.open.projects.services;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.open.projects.components.FileType;
import com.open.projects.dtos.Resource;

import reactor.core.publisher.Flux;

@Service
public class ResourceServices {

    @Value("${base.directory}")
    private String baseDirectory;

    /**
     * 
     * @param dir. Relative path to the base directory, Example /dir1/dir2. If base
     *             directory is /home/steffy, complete path will be
     *             /home/steffy/dir1/dir2
     * @return List of files in the directory
     */
    public Flux<Resource> listResources(String dir) {
        validateDirectoryPath(dir);
        String completePath = baseDirectory + dir;
        File requestDir = new File(completePath);
        if (requestDir.exists()) {
            if (requestDir.isDirectory()) {
                File[] files = requestDir.listFiles();
                return Flux.fromArray(files)
                        .map(file -> new Resource(file.getName(), file.isDirectory() ? FileType.DIR : FileType.FILE,
                                file.getAbsolutePath().replace(baseDirectory, "")));
            } else {
                throw new RuntimeException("Invalid resource path");
            }
        }
        return Flux.empty();
    }

    /**
     * Validates directory path. Only allow numbers, alphabets , underscore , hypen, space
     * and foward slash
     * 
     * @param dir
     */
    private void validateDirectoryPath(String dir) {

    }

}
