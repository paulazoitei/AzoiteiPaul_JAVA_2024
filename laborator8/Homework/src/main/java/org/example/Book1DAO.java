package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data access object for books.

 */
public class Book1DAO {
    /**
     * Adds a book to the database with the given data.
     */

    public void create(String title, String authors, double averageRating, String isbn, String isbn13,
                       String languageCode, int numPages, int ratingsCount, int textReviewsCount,
                       Date publicationDate, String publisher) throws SQLException {
        Connection con = Database.getConnection();

            try (PreparedStatement pstmt = con.prepareStatement(
                    "INSERT INTO books1 (title, authors, average_rating, isbn, isbn13, language_code, num_pages, ratings_count, text_reviews_count, publication_date, publisher) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
                pstmt.setString(1, title);
                pstmt.setString(2, authors);
                pstmt.setDouble(3, averageRating);
                pstmt.setString(4, isbn);
                pstmt.setString(5, isbn13);
                pstmt.setString(6, languageCode);
                pstmt.setInt(7, numPages);
                pstmt.setInt(8, ratingsCount);
                pstmt.setInt(9, textReviewsCount);
                pstmt.setDate(10, publicationDate);
                pstmt.setString(11, publisher);
                pstmt.executeUpdate();
            }

    }

    /**
     * Returns a list of all books in the database.
     * @return
     * @throws SQLException
     */

    public List<Book1> findAll() throws SQLException {
        List<Book1> books = new ArrayList<>();
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement("SELECT * FROM books1")) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                books.add(new Book1(
                        rs.getInt("book_id"),
                        rs.getString("title"),
                        rs.getString("authors"),
                        rs.getString("language_code"),
                        rs.getDate("publication_date"),
                        rs.getInt("num_pages"),
                        rs.getString("isbn"),
                        rs.getString("isbn13"),
                        rs.getDouble("average_rating"),
                        rs.getInt("ratings_count"),
                        rs.getInt("text_reviews_count"),
                        rs.getString("publisher")
                ));
            }
        }
        return books;
    }




}
