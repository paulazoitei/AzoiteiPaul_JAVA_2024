package org.example;

import java.io.IOException;

/**
 * Comanda folosita pentru vizualizarea unui document din repository
 */
public class View  extends Command{

    @Override
/**
 * Metoda care executa comanda de vizualizare a unui document
 */
    void execute(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Usage: view <filename>");

        }
        String filename = args[0];
        openDocument(filename);
    }

    /**
     * Metoda care deschide un document folosind aplicația implicită a sistemului de operare
     * @param filename
     */
    private void openDocument(String filename) {
        try {
            // Use system command to open the document
            String os = System.getProperty("os.name").toLowerCase();
            ProcessBuilder pb;
            if (os.contains("win")) {
                pb = new ProcessBuilder("cmd", "/c", "start", filename);
            } else {
                pb = new ProcessBuilder("xdg-open", filename); // Linux
            }
            pb.inheritIO().start().waitFor(); // Wait for the process to finish
        } catch (IOException | InterruptedException e) {
            System.err.println("Error opening document: " + e.getMessage());
        }
    }
}


