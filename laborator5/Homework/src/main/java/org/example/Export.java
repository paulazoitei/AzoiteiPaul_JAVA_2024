package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Comanda folosit pentru exportul documentelor din repository in format JSON
 */
public class Export extends Command {

    private final Repository repository;

    /**
     * Constructorul clasei Export
     * @param repository
     */
    public Export(Repository repository) {
        this.repository = repository;
    }

    /**
     * Metoda care executa comanda de export a documentelor
     * @param args
     */
    @Override
    void execute(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: export <output_file_path>");
            return;
        }

        String outputPath = args[0];
        File outputFile = new File(outputPath);

        try {
            // Convert repository data to JSON
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(outputFile, repository.getDocuments());

            System.out.println("Repository exported successfully to: " + outputPath);
        } catch (IOException e) {
            System.out.println("Error exporting repository: " + e.getMessage());
        }
    }
}
