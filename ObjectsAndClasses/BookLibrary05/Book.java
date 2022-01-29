package Jan25.BookLibrary05;

import java.time.LocalDateTime;

public class Book {
    private String title;
    private String author;
    private String publisher;
    private LocalDateTime releaseDate;
    private int ISBNnumber;
    private double price;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getISBNnumber() {
        return ISBNnumber;
    }

    public void setISBNnumber(int ISBNnumber) {
        this.ISBNnumber = ISBNnumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public Book(String title, String author, String publisher, LocalDateTime releaseDate, int ISBNnumber, double price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.ISBNnumber = ISBNnumber;
        this.price = price;
    }
}
