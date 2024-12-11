import java.util.ArrayList;
import java.util.List;

public class Administrator extends User {
    protected List<Book> books; // list of books in the store to manage


    public Administrator(String e, String u, String p, String f, String l){
        super(e, u, p, f, l);
        books = new ArrayList<>();
    }

    // ADD NEW BOOK TO THE SHOP
    public void addBook(Book book) {
        this.books.add(book);
        System.out.println(book.getTitle() + " has been added to the shop.");
    }

    // REMOVE A BOOK FROM THE SHOP
    public void removeBook(Book book) {
        if (this.books.remove(book)) {
            System.out.println(book.getTitle() + "removed from the shop.");;
        } else {
            System.out.println(book.getTitle() + "not found in the shops system.");
        }
    }

    // UPDATE THE STOCK OF A BOOK
    public void updateBookStock(Book book, int newStock) {
        if (this.books.contains(book)) {
            book.setStock(newStock);
            System.out.println(book.getTitle() + " stock updated to " + newStock);
        } else {
            System.out.println(book.getTitle() + " not found in the shop.");
        }
    }

    // UPDATE THE PRICE OF A BOOK
    public void updateBookPrice(Book book, double newPrice) {
        if (this.books.contains(book)) {
            book.setPrice(newPrice);
            System.out.println(book.getTitle() + " price updated to " + newPrice);
        } else {
            System.out.println(book.getTitle() + " not found in the shop.");
        }
    }

    // GET A LIST OF ALL BOOKS IN THE SHOP
    public List<Book> getBooks() {
        return this.books;
    }

    @Override
    public String toString() {
        String s = "";
        s += "\n";
        s += "ADMINISTRATOR ACCOUNT DETAILS\n";
        s += "-----------------------------\n";
        s += " Email: " + email + "\n";
        s += " Username: " + username + "\n";
        s += "Password: " + password + "\n";
        s += "First Name: " + firstName + "\n";
        s += "Last Name: " + lastName + "\n";
        return s;
    }
}
