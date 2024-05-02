
package org.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

/**
 * CSV data importer class that reads data from a CSV file and imports it into the database.

 */
public class CSVDataImporter {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

    /**
     * Imports data from a CSV file into the database.
     * @param csvFilePath
     */
    public void importData(String csvFilePath) {
        Book1DAO book1DAO = new Book1DAO(); // Inițializează Book1DAO

        try (CSVReader reader = new CSVReaderBuilder(new FileReader(csvFilePath)).withSkipLines(1).build()) {
            List<String[]> records = reader.readAll();
            for (String[] row : records) {
                try {
                    // Verificăm dacă fiecare rând are suficiente coloane
                    if (row.length >= 12) {
                        int bookId = Integer.parseInt(row[0]);
                        String title = row[1];
                        String authors = row[2];
                        double averageRating = row[3].isEmpty() ? 0.0 : Double.parseDouble(row[3]);
                        String isbn = row[4];
                        String isbn13 = row[5];
                        String languageCode = row[6];
                        int numPages = row[7].isEmpty() ? 0 : Integer.parseInt(row[7]);
                        int ratingsCount = row[8].isEmpty() ? 0 : Integer.parseInt(row[8]);
                        int textReviewsCount = row[9].isEmpty() ? 0 : Integer.parseInt(row[9]);
                        Date publicationDate = new Date(dateFormat.parse(row[10]).getTime());
                        String publisher = row[11];

                        // Creăm obiectul Book1 și îl inserăm în baza de date
                        Book1 book1 = new Book1(
                                bookId,
                                title,
                                authors,
                                languageCode,
                                publicationDate,
                                numPages,
                                isbn,
                                isbn13,
                                averageRating,
                                ratingsCount,
                                textReviewsCount,
                                publisher
                        );
                        book1DAO.create(book1.getTitle(), book1.getAuthors(), book1.getAverageRating(), book1.getIsbn(),
                            book1.getIsbn13(), book1.getLanguage(), book1.getNumberOfPages(), book1.getRatingsCount(),
                            book1.getTextReviewsCount(), book1.getPublicationDate(), book1.getPublisher());

                    }
                } catch (NumberFormatException | ParseException e) {
                    System.err.println("Skipping a malformed row: " + Arrays.toString(row));
                    e.printStackTrace();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}

