

package org.example;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/**
 * Clasa Main este responsabilă de citirea comenzilor de la tastatură și de executarea acestora.

 */


public class Main {
    public static void main(String[] args) throws IOException {
        Repository repository = new Repository("C:\\Users\\paul\\IdeaProjects\\Java\\laborator5\\Homework\\fisier");
        Command viewCommand = new View();
        Scanner scanner = new Scanner(System.in);

        Command exportCommand = new Export(repository);



        while (true) {

            System.out.print("Enter command: ");
            String input = scanner.nextLine();

            String[] parts = input.split("\\s+", 2);
            String commandName = parts[0];
            String[] commandArgs = parts.length > 1 ? parts[1].split("\\s+") : new String[0];

            switch (commandName) {
                case "view":
                    if (commandArgs.length != 0) {
                        System.out.println("Usage: view");
                        break;
                    }


                    System.out.println("Available persons:");
                    for (Person person : repository.getDocuments().keySet()) {
                        System.out.println("- " + person.getName() + " (ID: " + person.getId() + ")");
                    }


                    System.out.print("Enter person's name (case-sensitive): ");
                    String personName = scanner.nextLine();


                    Person selectedPerson = null;
                    for (Person person : repository.getDocuments().keySet()) {
                        if (person.getName().equals(personName)) {
                            selectedPerson = person;
                            break;
                        }
                    }

                    if (selectedPerson != null) {
                        List<Document> personDocuments = repository.getDocumentsForPerson(selectedPerson);


                        System.out.println("Documents for " + selectedPerson.getName() + ":");
                        for (Document document : personDocuments) {
                            System.out.println("- " + document.getName());
                        }


                        System.out.print("Enter document name: ");
                        String documentName = scanner.nextLine().trim();


                        String filePath = repository.getDirectory() + "\\" + selectedPerson.getName() + "-" + selectedPerson.getId() + "\\" + documentName;

                        // Deschide documentul cu calea specificată
                        viewCommand.execute(new String[]{filePath});
                    } else {
                        System.out.println("Person not found.");
                    }
                    break;

                case "report":
                    Command reportCommand = new Report(repository);
                    reportCommand.execute(commandArgs); // report  report.html
                    break;
                case "export":
                    exportCommand.execute(commandArgs);  // calea pentru fisierul .json C:\Users\paul\IdeaProjects\Java\laborator5\Homework\exported_repository.json
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Command not recognized");
            }
        }
    }
    // pentru a execut jar-ul trebuie sa fim in C:\Users\paul\IdeaProjects\Java\laborator5\Homework\out\artifacts\Compulsory_jar si sa rulez comanda java -jar Compulsory.jar
}









