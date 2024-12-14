import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Administrator extends User {
    protected LinkedList<Book> books; // list of books in the store to manage
    protected ArrayList<Order> completedOrders = new ArrayList<>();
    protected ArrayList<Order> allOrders = new ArrayList<>();

    public Administrator(String e, String u, String p, String f, String l){
        super(e, u, p, f, l);
        books = new LinkedList<>();
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

    // find books in the store based on their title
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) { 
                return book;
            }
        }
        return null; 
    }    

    // view all past completed orders
    public void viewOrderHistory(){
        for (Order order : completedOrders) {
            System.out.println(order);
        }
    }
    
   //updates the completedOrder list
    public void addFinishedOrder(){
        for (Order order : allOrders){
            if (order.getOrderStatus().equals("Delivered")) {
                if (!completedOrders.contains(order)) {
                    completedOrders.add(order);
                }
            }
        }
    }

    // adds new orders to list to track all orders
    public void addOrder(Order order) {
        allOrders.add(order);
    }

    // accessors 
    public LinkedList<Book> getBooks() {
        return this.books;
    }

    public ArrayList<Order> getCompletedOrders() {
        return completedOrders;
    }

    public ArrayList<Order> getAllOrders() {
        return allOrders;
    }

    public void administratorMenu(){
        System.out.println("1. Review account");
        System.out.println("2. Change account");
        System.out.println("3. Add a book to the shop");
        System.out.println("4. Remove a book from the shop");
        System.out.println("5. Update book stock");
        System.out.println("6. Update book price");
        System.out.println("7. View shop's completed orders");
        System.out.println("8. Update completed orders");
        System.out.println("9. Logout");
    }

        public void createBooksToAdd(){
            Scanner scnr = new Scanner(System.in);
            System.out.println("Enter the information of the book to add: ");
            System.out.print("Title: ");
            String title = scnr.nextLine();
            System.out.print("Author: ");
            String author = scnr.nextLine();
            System.out.print("Language: ");
            String language = scnr.nextLine();
            System.out.print("Year Published: ");
            int year = scnr.nextInt();
            scnr.nextLine();
            System.out.print("Price: ");
            double price = scnr.nextDouble();
            scnr.nextLine();
            System.out.print("Availability (enter 'true' or 'false'): ");
            boolean availability = scnr.nextBoolean();
            scnr.nextLine();
            System.out.print("Stock: ");
            int stock = scnr.nextInt();
            scnr.nextLine();
            System.out.println("Is the book Fiction or Nonfiction?");
            String bookType = scnr.nextLine();
            if (bookType.equalsIgnoreCase("Fiction")){
                System.out.print("Is it a bestseller (enter 'true' or 'false'): ");
                boolean bSeller = scnr.nextBoolean();
                scnr.nextLine();
                System.out.print("Book Genre: ");
                String genre = scnr.nextLine();
                System.out.print("Target age of readers: ");
                String age = scnr.nextLine();
                Fiction newBook = new Fiction(title, author, language, year, price, availability, stock, genre, bSeller, age);
                addBook(newBook);
            }
            else if (bookType.equalsIgnoreCase("Nonfiction")){
                System.out.print("Book Genre: ");
                String genre = scnr.nextLine();
                System.out.print("Edition: ");
                int edition = scnr.nextInt();
                scnr.nextLine();
                System.out.print("Peer Reviewed (enter 'true' or 'false'): ");
                boolean reviewed = scnr.nextBoolean();
                scnr.nextLine();
                System.out.print("Book Topic: ");
                String topic = scnr.nextLine();
                Nonfiction newBook = new Nonfiction(title, author, language, year, price, availability, stock, genre, edition, reviewed, topic);
                addBook(newBook);
            }
            scnr.close();
        }

        public void removeBookFromStore(){
            Scanner scnr = new Scanner(System.in);
            System.out.print("Enter book title to remove: ");
            String bookToRemove = scnr.nextLine();
            Book book = findBookByTitle(bookToRemove); 
            if (book != null) {
                removeBook(book);
            } 
            else {
                System.out.println("Book could not be found.");
            }
            scnr.close();
        } 
        
        public void updateStock(){
            Scanner scnr = new Scanner(System.in);
            System.out.print("Enter book title to update stock: ");
            String stockTitle = scnr.nextLine();
            Book stockBook = findBookByTitle(stockTitle);
            if (stockBook != null) {
                System.out.print("Enter new stock amount: ");
                int newStock = scnr.nextInt();
                scnr.nextLine();
                updateBookStock(stockBook, newStock);
            } 
            else {
                System.out.println("Book could not be found.");
            }
            scnr.close();
        } 
        
        public void updatePrice(){
            Scanner scnr = new Scanner(System.in);
            System.out.print("Enter book title to update price: ");
            String bookToPrice = scnr.nextLine();
            Book priceBook = findBookByTitle(bookToPrice);
            if (priceBook != null) {
                System.out.print("Enter new price: ");
                double newPrice = scnr.nextDouble();
                scnr.nextLine();
                updateBookPrice(priceBook, newPrice);
            } 
            else {
                System.out.println("Book could not be found.");
            }
            scnr.close();
        }

    @Override
    public String toString() {
        String s = "";
        s += "\n";
        s += "ADMINISTRATOR ACCOUNT DETAILS\n";
        s += "-----------------------------\n";
        s += super.toString();
        return s;
    }
}
