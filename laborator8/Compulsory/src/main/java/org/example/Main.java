package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        AuthorDAO authorDAO = new AuthorDAO();

        try {

            Integer authorId = authorDAO.findByName("William Shakespeare");
            if (authorId != null) {
                System.out.println("Author ID: " + authorId);
                String authorName = authorDAO.findById(authorId);
                System.out.println("Author Name: " + authorName);
            }
            Database.getConnection().commit();
        } catch (Exception e) {  // Catch general pentru alte excepții
            System.err.println("Error: " + e.getMessage());
            Database.rollback();
        } finally {
            try {
                Database.closeConnection();
            } catch (Exception e) {
                System.err.println("Failed to close the database connection: " + e.getMessage());
            }
        }
    }
}
