package org.example;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        //add books
        library.addBook(new Book("1984", "George Orwell", 1949, 328, "Fiction"));
        library.addBook(new Book("A Brief History of Time", "Stephen Hawking", 1988, 212, "Science"));
        library.addBook(new Book("Sapiens", "Yuval Noah Harari", 2011, 443, "History"));

        //add a user
        User user = new User("John Doe", "777");
        library.registerUser(user);

        //Loan out a book
        library.loanOutBook("1984", user);

        // Find all books published in 1988
        List<Book> booksIn1988 = library.findBooksByYear(1988);
        booksIn1988.forEach(book -> System.out.println(book.getTitle()));

        // print all book titles sorted alphabetically
        List<String> allTitles = library.getAllBooksTitlesSorted();
        allTitles.forEach(System.out::println);

        //return the book
        library.returnBook("1984", user);


        //Calculate late fees
        double lateFees = library.calculateLateFees(user);
        System.out.println( "Late fees : $" + lateFees);

        }
    }
