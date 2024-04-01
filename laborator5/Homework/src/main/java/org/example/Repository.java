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

    public Map<Person, List<Document>> getDocuments() {
        return documents;
    }
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

                                String[] subDirParts = subDirName.split("-");
                                if (subDirParts.length == 2) {
                                    String personName = subDirParts[0];
                                    int personId = Integer.parseInt(subDirParts[1]);
                                    Person person = new Person(personId, personName);

                                    documents.putIfAbsent(person, new ArrayList<>());

                                    // Obținem formatul fișierului
                                    String fileName = file.getFileName().toString();
                                    String[] fileNameParts = fileName.split("\\.");
                                    String format = fileNameParts.length > 1 ? fileNameParts[fileNameParts.length - 1] : ""; // luăm extensia ca format

                                    // Adăugăm documentul cu formatul corespunzător
                                    documents.get(person).add(new Document(fileName, format));
                                } else {
                                    throw new IllegalArgumentException("Invalid subdirectory name: " + subDirName);
                                }
                            } else {
                                throw new IllegalArgumentException("Invalid subdirectory name: " + subDirName);
                            }
                        }
                    });
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Metoda care returneaza documentele pentru o persoana selectata
     * @param selectedPerson
     * @return
     */
    public List<Document> getDocumentsForPerson(Person selectedPerson) {
        return documents.getOrDefault(selectedPerson, new ArrayList<>());
    }

    /**
     * Metoda care returneaza directorul repository-ului
     * @return
     */
    public String getDirectory() {
        return directory;
    }
}


