package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data access object for books.

 */
public class BookDAO {
    /**
     * Adds a book to the database if it does not already exist. If it exists, prints a message.
     */
    public void create(String title, String author, String language, Date publicationDate, int numberOfPages,String genre) throws SQLException {
        Connection con = Database.getConnection();
        if (!bookExists(title, author, con)) {  // Modifică bookExists pentru a verifica după author
            try (PreparedStatement pstmt = con.prepareStatement(
                    "INSERT INTO books (title, author, language, publication_date, number_of_pages, genre) VALUES (?, ?, ?, ?, ?, ?)")) {
                pstmt.setString(1, title);
                pstmt.setString(2, author);  // Modificat pentru a insera autorul
                pstmt.setString(3, language);// Presupunând că genul este gestionat ca înainte
                pstmt.setDate(4, publicationDate);
                pstmt.setInt(5, numberOfPages);
                pstmt.setString(6, genre);
                pstmt.executeUpdate();
            }
        } else {
            System.out.println("Book already exists: " + title);
        }
    }

    /**
     * Retrieves all details for a book by title.
     */
    public Book findDetailsByTitle(String title) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "SELECT * FROM books WHERE title = ?")) {
            pstmt.setString(1, title);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
                        rs.getString("language"), rs.getDate("publication_date"), rs.getInt("number_of_pages"), rs.getString("genre"));
            }
            return null;
        }
    }

    /**
     * Returns a list of all books in the database.
     * @return
     * @throws SQLException
     */
    public List<Book> findAll() throws SQLException {
        List<Book> books = new ArrayList<>();
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement("SELECT * FROM books")) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                books.add(new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
                        rs.getString("language"), rs.getDate("publication_date"), rs.getInt("number_of_pages"), rs.getString("genre")));
            }
        }
        return books;
    }
    /**
     * Checks if a book already exists in the database.
     */
    private boolean bookExists(String title, String author, Connection con) throws SQLException {
        try (PreparedStatement pstmt = con.prepareStatement(
                "SELECT COUNT(*) FROM books WHERE title = ? AND author = ?")) {
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
            return false;
        }
    }

}
