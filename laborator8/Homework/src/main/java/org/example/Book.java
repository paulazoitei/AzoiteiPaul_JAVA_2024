package org.example;

import java.sql.Date;

/**
 *Book class with all the attributes of a normal book

 */
public class Book {
    private int id;
    private String title;
    private String author; // Acesta este acum un String, nu un int
    private String language;
    private String genre;
    private Date publicationDate;
    private int numberOfPages;

    /**
     * Constructor for the Book class
     * @param id
     * @param title
     * @param author
     * @param language
     * @param publicationDate
     * @param numberOfPages
     * @param genre
     */
    public Book(int id, String title, String author, String language,  Date publicationDate, int numberOfPages,String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.language = language;
        this.genre = genre;
        this.publicationDate = publicationDate;
        this.numberOfPages = numberOfPages;
    }

    /**
     * Getter for the id attribute
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for the title attribute
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter for the author attribute
     * @return
     */

    public String getAuthor() {
        return author;
    }

    /**
     * Getter for the language attribute
     * @return
     */

    public String getLanguage() {
        return language;
    }

    /**
     * Getter for the genre attribute
     * @return
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Getter for the publicationDate attribute
     * @return
     */
    public Date getPublicationDate() {
        return publicationDate;
    }

    /**
     * Getter for the numberOfPages attribute
     * @return
     */
    public int getNumberOfPages() {
        return numberOfPages;
    }

    /**
     * Setter for the id attribute
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Setter for the title attribute
     * @param title
     */

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Setter for the author attribute
     * @param author
     */

    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Setter for the language attribute
     * @param language
     */

    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Setter for the genre attribute
     * @param genre
     */

    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Setter for the publicationDate attribute
     * @param publicationDate
     */
    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    /**
     * Setter for the numberOfPages attribute
     * @param numberOfPages
     */
    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    /**
     * toString method for the Book class
     * @return
     */
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", language='" + language + '\'' +
                ", genre='" + genre + '\'' +
                ", publicationDate=" + publicationDate +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}

