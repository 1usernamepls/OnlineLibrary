import java.util.Random;

public class Book {

    private String title;
    private int ISBN;
    private double price;
    private boolean availability;
    private String genre;

    public Book() {
        title = null;
        ISBN = 0;
        price = 0.0;
        availability = false;
        genre = null;  
    }

    public Book(String t, double p, boolean a, String g) {
        title = t;
        Random rand = new Random();
        int min = 1000000000; //This assumes we want to do 10 digit ISBN
        int max = 1999999999;
        ISBN = rand.nextInt(max - min + 1) + min; 
        price = p;
        availability = a;
        genre = g;
    }

    public Book(Book b) {
        title = b.title;
        Random rand = new Random();
        int min = 1000000000;
        int max = 1999999999;
        ISBN = rand.nextInt(max-min+1) + min;
        price = b.price;
        availability = b.availability;
        genre = b.genre;
    }

    public String getTitle() {
        return title;
    }

    public int getISBN() {
        return ISBN;
    }

    public double getPrice() {
        return price;
    }

    public boolean getAvailability() {
        return availability;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        String s = "";
        s += "Title: " + title + "\n";
        s += "      ISBN: " + ISBN + "\n";
        s += "      Price: $" + price + "\n";
        s += "      Availability: " + availability + "\n";
        s += "      Genre: " + genre + "\n";
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Book)) {
            return false;
        }
        Book b = (Book) o;
        return (this.title.equals(b.title) && 
                this.genre.equals(b.genre));
    }

    // public int compareTo(Book b) {
    //     if (this.price == b.price) {
    //         return 0;
    //     }
    //     if (this.price > b.price) {
    //         return 1;
    //     }
    //     if (this.price < b.price) {
    //         return -1;
    //     }
    // }
    
}
