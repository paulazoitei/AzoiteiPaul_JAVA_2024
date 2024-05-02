package org.example;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        String csvFilePath = "C:\\Users\\paul\\IdeaProjects\\Java\\laborator8\\Homework\\books.csv";
//SET client_encoding TO 'UTF8';

        CSVDataImporter importer = new CSVDataImporter();


        importer.importData(csvFilePath);

        AuthorDAO authorDAO = new AuthorDAO();
        BookDAO bookDAO = new BookDAO();
        GenreDAO genreDAO = new GenreDAO();
        Book1DAO book1DAO=new Book1DAO();

        try {





            bookDAO.create("A Tale of Two Cities", authorDAO.findById(4), "English", Date.valueOf("1859-04-30"), 544,genreDAO.findById(5));
            bookDAO.create("Morometii", authorDAO.findById(5), "Romanian", Date.valueOf("1955-05-25"), 900, genreDAO.findById(6));
            bookDAO.create("The Lord of the Rings", authorDAO.findById(6), "English", Date.valueOf("1954-07-29"), 1178, genreDAO.findById(8));
            displayAllBooks(bookDAO);
            displayAllBooks1(book1DAO);

            Database.getConnection().commit();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            Database.rollback();
        } finally {
            try {
                Database.closeConnectionPool();
            } catch (Exception e) {
                System.err.println("Failed to close the database connection: " + e.getMessage());
            }
        }


    }

    public static void displayAllBooks(BookDAO bookDAO) throws SQLException {
        List<Book> books = bookDAO.findAll();
        for (Book book : books) {
            System.out.println("Book ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author : " + book.getAuthor() + ", Language: " + book.getLanguage() + ", Genre: " + book.getGenre() + ", Publication Date: " + book.getPublicationDate() + ", Number of Pages: " + book.getNumberOfPages());
        }



    }
    public static void displayAllBooks1(Book1DAO book1DAO) throws SQLException {
        List<Book1> books = book1DAO.findAll();
        for (Book1 book : books) {
            System.out.println("Book ID: " + book.getId() +
                    ", Title: " + book.getTitle() +
                    ", Authors: " + book.getAuthors() +
                    ", Language: " + book.getLanguage() +
                    ", Publication Date: " + book.getPublicationDate() +
                    ", Number of Pages: " + book.getNumberOfPages() +
                    ", ISBN: " + book.getIsbn() +
                    ", ISBN13: " + book.getIsbn13() +
                    ", Average Rating: " + book.getAverageRating() +
                    ", Ratings Count: " + book.getRatingsCount() +
                    ", Text Reviews Count: " + book.getTextReviewsCount() +
                    ", Publisher: " + book.getPublisher());
        }
    }


}
