package hh.sof003.bookstore.domain;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private double price;
    private int publicationYear;

    public Book() {
        title = "";
        author = "";
        isbn = "";
        price = 0.0;
        publicationYear = 0;
    }

    public Book(String title, String author, String isbn, double price, int publicationYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.publicationYear = publicationYear;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public double getPrice() {
        return price;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", isbn=" + isbn + ", price=" + price
                + ", publicationYear=" + publicationYear + "]";
    }
}
