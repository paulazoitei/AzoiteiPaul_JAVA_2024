package org.example;

import java.sql.Date;

/**
 *  Book1 class with all the attributes of an imported book
 */
public class Book1 {
    private int id;
    private String title;
    private String authors;
    private String language;
    private Date publicationDate;
    private int numberOfPages;

    private String isbn;
    private String isbn13;
    private double averageRating;
    private int ratingsCount;
    private int textReviewsCount;
    private String publisher;

    /**
     * Constructor for the Book1 class
     * @param id
     * @param title
     * @param authors
     * @param language
     * @param publicationDate
     * @param numberOfPages
     * @param isbn
     * @param isbn13
     * @param averageRating
     * @param ratingsCount
     * @param textReviewsCount
     * @param publisher
     */
    public Book1(int id, String title, String authors, String language, Date publicationDate, int numberOfPages,  String isbn, String isbn13, double averageRating, int ratingsCount, int textReviewsCount, String publisher) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.language = language;
        this.publicationDate = publicationDate;
        this.numberOfPages = numberOfPages;
        this.isbn = isbn;
        this.isbn13 = isbn13;
        this.averageRating = averageRating;
        this.ratingsCount = ratingsCount;
        this.textReviewsCount = textReviewsCount;
        this.publisher = publisher;
    }

    /**
     * Getter for the id attribute
     * @return
     */
    public int getId() { return id; }

    /**
     * Getter for the title attribute
     * @return
     */
    public String getTitle() { return title; }

    /**
     * Getter for the authors attribute
     * @return
     */
    public String getAuthors() { return authors; }

    /**
     * Getter for the language attribute
     * @return
     */
    public String getLanguage() { return language; }

    /**
     * Getter for the publicationDate attribute
     * @return
     */
    public Date getPublicationDate() { return publicationDate; }

    /**
     * Getter for the numberOfPages attribute
     * @return
     */
    public int getNumberOfPages() { return numberOfPages; }

    /**
     * Getter for the isbn attribute
     * @return
     */

    public String getIsbn() { return isbn; }

    /**
     * Getter for the isbn13 attribute
     * @return
     */
    public String getIsbn13() { return isbn13; }

    /**
     *  Getter for the averageRating attribute
     * @return
     */
    public double getAverageRating() { return averageRating; }

    /**
     * Getter for the ratingsCount attribute
     * @return
     */
    public int getRatingsCount() { return ratingsCount; }

    /**
     * Getter for the textReviewsCount attribute
     * @return
     */
    public int getTextReviewsCount() { return textReviewsCount; }

    /**
     * Getter for the publisher attribute
     * @return
     */
    public String getPublisher() { return publisher; }

    /**
     * Setter for the id attribute
     * @param id
     */
    public void setId(int id) { this.id = id; }

    /**
     * Setter for the title attribute
     * @param title
     */
    public void setTitle(String title) { this.title = title; }

    /**
     * Setter for the authors attribute
     * @param authors
     */
    public void setAuthors(String authors) { this.authors = authors; }

    /**
     * Setter for the language attribute
     * @param language
     */
    public void setLanguage(String language) { this.language = language; }

    /**
     * Setter for the publicationDate attribute
     * @param publicationDate
     */
    public void setPublicationDate(Date publicationDate) { this.publicationDate = publicationDate; }

    /**
     * Setter for the numberOfPages attribute
     * @param numberOfPages
     */
    public void setNumberOfPages(int numberOfPages) { this.numberOfPages = numberOfPages; }

    /**
     * Setter for the isbn attribute
     * @param isbn
     */

    public void setIsbn(String isbn) { this.isbn = isbn; }

    /**
     * Setter for the isbn13 attribute
     * @param isbn13
     */
    public void setIsbn13(String isbn13) { this.isbn13 = isbn13; }

    /**
     * Setter for the averageRating attribute
     * @param averageRating
     */
    public void setAverageRating(double averageRating) { this.averageRating = averageRating; }

    /**
     * Setter for the ratingsCount attribute
     * @param ratingsCount
     */
    public void setRatingsCount(int ratingsCount) { this.ratingsCount = ratingsCount; }

    /**
     * Setter for the textReviewsCount attribute
     * @param textReviewsCount
     */
    public void setTextReviewsCount(int textReviewsCount) { this.textReviewsCount = textReviewsCount; }

    /**
     * Setter for the publisher attribute
     * @param publisher
     */
    public void setPublisher(String publisher) { this.publisher = publisher; }

    /**
     * toString method for the Book1 class
     * @return
     */
    @Override
    public String toString() {
        return "Book1{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors='" + authors + '\'' +
                ", language='" + language + '\'' +
                ", publicationDate=" + publicationDate +
                ", numberOfPages=" + numberOfPages +
                ", isbn='" + isbn + '\'' +
                ", isbn13='" + isbn13 + '\'' +
                ", averageRating=" + averageRating +
                ", ratingsCount=" + ratingsCount +
                ", textReviewsCount=" + textReviewsCount +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
