package org.example;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String libraryCardNumber;
    private List<Book> borrowedBooks;

    public User(String name, String libraryCardNumber) {
        this.name = name;
        this.libraryCardNumber = libraryCardNumber;
        this.borrowedBooks = new ArrayList<>();
    }
    //getter
    public String getName() {
        return name;

    }
    public String getLibraryCardNumber() {
        return libraryCardNumber;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;

    }
    public void borrowBook(Book book) {
        borrowedBooks.add(book);

    }
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
}
