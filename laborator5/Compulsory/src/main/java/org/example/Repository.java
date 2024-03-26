package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Clasa Repository este responsabila de operatiile externe privind repository-ul de documente
 */
public class Repository {
    private String directory;
    private Map<Person, List<Document>> documents = new HashMap<>();

    /**
     * Constructorul clasei Repository
     * @param directory
     * @throws IOException
     */

    public Repository(String directory) throws IOException {
        this.directory = directory;
        loadDocuments();
    }

    /**
     * Metoda care verifica daca un subdirector are numele in formatul corect
     * @param name
     * @return
     */
    private boolean isValidSubDirectoryName(String name) {
        // Verifică dacă numele subdirectorului are forma corectă: nume-id
        return name.matches(".+-\\d+");
    }

    /**
     * Metoda care incarca documentele din repository
     * @throws IOException
     */

    private void loadDocuments() throws IOException {
        Path masterDir = Paths.get(directory);
        if (!Files.exists(masterDir) || !Files.isDirectory(masterDir)) {
            throw new IOException("Invalid master directory.");
        }

        System.out.println("Repository content:");

        try {
            Files.walk(masterDir)
                    .filter(Files::isRegularFile)
                    .forEach(file -> {
                        Path parent = file.getParent();
                        if (parent != null) {
                            String subDirName = parent.getFileName().toString();
                            if (isValidSubDirectoryName(subDirName)) {
                                System.out.println("Subdirectory: " + subDirName);
                                System.out.println(" - " + file.getFileName());
                            } else {
                                throw new IllegalArgumentException("Invalid subdirectory name: " + subDirName);
                            }
                        }
                    });
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }


}


