import java.util.Random;

public abstract class Book implements Comparable<Book> {

    protected String title;
    protected String author;
    protected String language;
    protected int publishing;
    protected int ISBN;
    protected double price;
    protected boolean availability;
    protected String genre;

    public Book(String t, String auth, String l, int pub, double p, boolean a, String g) {
        title = t;
        author = auth;
        language = l;
        publishing = pub;
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
        author = b.author;
        language = b.language;
        publishing = b.publishing;
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

    public String getAuthor() {
        return author;
    }

    public int getPublishing() {
        return publishing;
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

    public abstract void setBestseller(boolean bestseller);

    @Override
    public String toString() {
        String s = "";
        s += "Title: " + title + "\n";
        s += "Author: " + author + "\n";
        s += "Language: " + language + "\n";
        s += "Published: " + publishing + "\n";
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
        return (this.title.equals(b.title) 
        && this.author.equals(b.author) &&
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
