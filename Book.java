import java.util.Random; // imports Random method

public abstract class Book implements Comparable<Book> {
    // a public abstract class for Books
    // Books are Comparable objects so the Comparable interface is implemented here

    protected String title;
    protected String author;
    protected String language;
    protected int publishing;
    protected int ISBN;
    protected double price;
    protected boolean availability;
    protected int stock;
    protected String category; // Replaces genre with category (Fiction, Nonfiction, etc. are categories not genres)
    // all variables are protected when child classes Nonfiction and Fiction inherit them
    // title, author, language, and category are Strings because they contain letters
    // publishing, stock, and ISBNs are ints presenting the year of publication, number of each Book, and Book Ids, respectively
    // price is a double to calculate Book totals
    // availability is a boolean that depends on the stock of the Book (0 or not)

    public Book(String t, String auth, String l, int pub, double p, boolean a, int s, String c) {
        // an overloaded constructor for Book member variables
        // all except ISBN because ISBN is unique for every Book
        title = t;
        author = auth;
        language = l;
        publishing = pub;
        Random rand = new Random(); // random initited
        int min = 1000000000; // Assumes a 10-digit ISBN
        int max = 1999999999; // max and min are the range of most ISBNs
        ISBN = rand.nextInt(max - min + 1) + min; 
        // formula that keeps ISBN within that range
        price = p;
        availability = a;
        stock = s;
        category = c; 
    }

    public Book(Book b) {
        // copy constructor for Books
        // once again, all but ISBN are copied
        title = b.title;
        author = b.author;
        language = b.language;
        publishing = b.publishing;
        Random rand = new Random();
        int min = 1000000000;
        int max = 1999999999;
        ISBN = rand.nextInt(max - min + 1) + min;
        price = b.price;
        availability = b.availability;
        stock = b.stock;
        category = b.category; // Copy category
    }

    // ACCESSOR METHODS
    // ALL VARIABLES
    // not used in the actual interface
    // used in testing and other classes that have Book objects

    public String getTitle() {
        // accessor for title
        return title;
    }

    public String getAuthor() {
        // accessor for author
        return author;
    }

    public String getLanguage() {
        // accessor for language
        return language;
    }

    public int getPublishing() {
        // accessor for publishing
        return publishing;
    }

    public int getISBN() {
        // accessor for ISBN
        return ISBN;
    }

    public double getPrice() {
        // accessor for price
        return price;
    }

    public boolean getAvailability() {
        // accessor for availability
        return availability;
    }

    public int getStock() {
        // accessor for stock
        return stock;
    }

    public String getCategory() {
        // accessor for category
        return category;
    }

    // MUTATORS
    // stock, price, and availability
    // all other Book details remain constant in real life

    public void setStock(int s) {
        // mutator for stock
        // Books when sold and added have different stock numbers
        stock = s;
    }

    public void setPrice(double p) {
        // mutator for price
        // Books are allowed to be set at different prices by their owners
        price = p;
    }

    public void setAvailability(boolean a) {
        // mutator for availability
        // Books can be available or unavailable depending on if sales are open
        availability = a;
    }

    // ABSTRACT METHODS
    // all Fiction and Nonfiction books have these methods

    public abstract String getGenre();
    // an accessor method for the Book's genre
    public abstract void setGenre(String genre);
    // a mutator method for the Book's genre
    // Books can be described differently by different people
    public abstract String getTargetAudience();
    // a method in complement to the main toString() below
    // prints a short synopsis of the Book's reader type

    @Override // for child classes Fiction and Nonfiction
    public String toString() { // toString() prints details shared by all Books
        String s = "";
        s += "\n";
        s += "Title: " + title + "\n";
        s += "Author: " + author + "\n";
        s += "Language: " + language + "\n";
        s += "Published: " + publishing + "\n";
        s += "\tISBN: " + ISBN + "\n";
        s += "\tPrice: $" + price + "\n";
        s += "\tAvailability: " + availability + "\n";
        s += "\tCategory: " + category + "\n";
        s += "\t# IN STOCK: " + stock + "\n";
        return s; // returns a single String s outputted in the terminal
    }

    @Override // for child classes Fiction and Nonfiction
    public boolean equals(Object o) { // compares Book objects and returns if they are equal or not
        if (this == o) { // if both objects have the same memory address
            return true; // they are equal
        }
        if (!(o instanceof Book)) { // if one object is not a Book object
            return false; // they are not equal
        }
        Book b = (Book) o; // typecast
        return (this.title.equals(b.title) 
        && this.author.equals(b.author));
        // a Book is the same as another Book when it has the same title and author
        // no exceptions to this rule
    }

    // COMPARABLE INTERFACE STRUCTURE
    // like many other products, we compared Book values based on their price
    // this is the format we have for our Books.txt
    // pricier books are towards the bottom and more affordable books towards the top
    
    public int compareTo(Book b) { // compares Books from their prices
        if (this.price == b.price) { // if two prices are the same
            return 0; // the Books have the same value
        }
        else if (this.price > b.price) { // if one price is higher than another
            return 1; // that Book has a higher value
        }
        else { // if one price is lower than another
            return -1; // that Book has a lower value
        }
    }
}
