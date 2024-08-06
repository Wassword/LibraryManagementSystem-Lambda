package org.example;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;
    private List<User> users;

    //constructor
    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }


    //method to add books
    public void addBook(Book book) {
            books.add(book);
    }
    public void removeBookByTitle(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    public List<Book> findBooksByYear(int year) {
        return books.stream()
                .filter(book -> book.getPublicationYear() == year)
                .collect(Collectors.toList());
    }
    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor() == author)
                .collect(Collectors.toList());
    }

    public Book findBookWithMostPages() {
        return books.stream()
                .max(Comparator.comparingInt(Book::getPages))
                .orElse((null));

    }
    public List<Book> findBookWithMoreThanNPages(int n) {
        return books.stream()
                .filter(book -> book.getPages() > n)
                .collect(Collectors.toList());
    }

    public List<String> getAllBooksTitlesSorted(){
        return books.stream()
                .map(Book::getTitle)
                .sorted()
                .collect(Collectors.toList());
    }
    public List<Book> findBooksByCategory(String category) {
        return books.stream()
                .filter(book -> book.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }
    public boolean loanOutBook(String title, User user) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.setOnLoan(true, LocalDate.now());
                user.borrowBook(book);
                return true;
            }
        }
        return false;
    }
     public boolean returnBook(String title, User user) {
        for (Book book : user. getBorrowedBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.setOnLoan(false, null);
                user.returnBook(book);
                return true;
            }
        }
        return false;
     }
     public double calculateLateFees(User user) {
        double lateFee = 0.0;
        LocalDate now = LocalDate.now();
         for (Book book : user.getBorrowedBooks()) {
            if (book.isOnLoan()){
                long daysOnLoan = ChronoUnit.DAYS.between(book.getLoanDate(),now);
                if (daysOnLoan > 14) {
                    lateFee += (daysOnLoan -14) * 0.5;
                }
            }

        }
        return lateFee;
     }

     //register user
    public void registerUser(User user) {
        users.add(user);
    }



}
