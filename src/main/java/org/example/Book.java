package org.example;

import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private int pages;
    private String category;
    private boolean isOnLoan;
    private LocalDate loanDate;


    //Constructor
    public Book(String title, String author, int publicationYear, int pages, String category) {
    this.title = title;
    this.author = author;
    this.publicationYear = publicationYear;
    this.pages = pages;
    this.category = category;
    this.isOnLoan = false;

}
//Getters
    public String getTitle() {
            return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getPublicationYear() {
        return publicationYear;
    }
    public int getPages() {
        return pages;
    }

    public boolean isOnLoan() {
        return isOnLoan;
    }

    public String getCategory() {
        return category;
    }
    public LocalDate getLoanDate() {
        return loanDate;
    }
//Setters

    public void setOnLoan(boolean onLoan, LocalDate now) {
        isOnLoan = onLoan;
    }
}

