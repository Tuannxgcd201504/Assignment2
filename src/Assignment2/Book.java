package Assignment2;

public class Book {
    private String name;
    private String genre;
    private String author;
    private double price;
    private int quantity;

    public Book(String name, String genre, String author, double price, int quantity) {
        this.name = name;
        this.genre = genre;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String info() {
        return name + " by " + author + " (" + genre + ") - $" + price + " [" + quantity + " in stock]";
    }
}

