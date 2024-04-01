
package org.example;
import java.awt.Desktop;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

/**
 * Clasa Report este responsabilă de generarea și afișarea unui raport cu toate documentele din repository.
 */
public class Report extends Command {

    private final Repository repository;

    /**
     * Metoda care execută comanda de generare a unui raport
     * @param args
     */

    @Override
    void execute(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Usage: report <filename>");
        }
        String filename = args[0];
        generateReport(filename);
        openReport(filename); // Deschide raportul generat
    }
/**
 * Constructorul clasei Report
 */
    public Report(Repository repository) {
        this.repository = repository;
    }

    /**
     * Metoda care generează un raport cu toate documentele din repository
     * @param filename
     */
    private void generateReport(String filename) {
        // Initialize Velocity engine
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init();

        // Create Velocity context
        VelocityContext context = new VelocityContext();

        // Retrieve documents from repository
        List<Document> documents = new ArrayList<>();
        Map<Person, List<Document>> repositoryDocuments = repository.getDocuments();
        for (List<Document> personDocuments : repositoryDocuments.values()) {
            documents.addAll(personDocuments);
        }
        context.put("documents", documents);

        // Get the template as a string
        String templatePath = "/templates/report_template.vm.txt"; // Exemplu de cale relativă
        String templateContent;
        try (InputStream inputStream = getClass().getResourceAsStream(templatePath)) {
            if (inputStream == null) {
                throw new IOException("Template not found: " + templatePath);
            }
            templateContent = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Error loading template: " + e.getMessage());
            return;
        }

        // Merge data into template
        StringWriter stringWriter = new StringWriter();
        velocityEngine.evaluate(context, stringWriter, "reportTemplate", templateContent);

        // Write merged output to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(stringWriter.toString());
            System.out.println("Report generated: " + filename);
        } catch (IOException e) {
            System.err.println("Error writing report: " + e.getMessage());
        }
    }

    /**
     * Metoda care deschide un raport folosind aplicația nativă a sistemului de operare
     * @param filename
     */
    private void openReport(String filename) {
        try {
            File file = new File(filename);
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        } catch (IOException e) {
            System.err.println("Error opening report: " + e.getMessage());
        }
    }
}

