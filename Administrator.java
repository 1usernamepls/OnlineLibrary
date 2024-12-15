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
            System.out.println(book.getTitle() + " removed from the shop.");
        } else {
            System.out.println(book.getTitle() + " not found in the shop's system.");
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
            System.out.println(book.getTitle() + " price updated to $" + newPrice);
        } else {
            System.out.println(book.getTitle() + " not found in the shop.");
        }
    }

    // Find books in the store based on their title
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) { 
                return book;
            }
        }
        return null; 
    }    

    // View all of the store's Orders (both ongoing and completed)
    public void viewOrders(){
        if (allOrders.isEmpty()) {
            System.out.println("No orders to display.");
            return;
        }
        for (Order order : allOrders) {
            System.out.println(order);
            System.out.println("--------------------");
        }
    }
    
    // Updates the completedOrder list
    public void addFinishedOrder(){
        for (Order order : allOrders){
            if (order.getOrderStatus().equalsIgnoreCase("Delivered")) {
                if (!completedOrders.contains(order)) {
                    completedOrders.add(order);
                }
            }
        }
    }

    // Adds new orders to list to track all orders
    public void addOrder(Order order) {
        allOrders.add(order);
    }

    // Accessors 
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

//Start of ChatGPT Error Checked Code

    public void createBooksToAdd(Scanner scnr){ // Passing scanner as an argument
        System.out.println("Enter the information of the book to add: ");
        
        System.out.print("Title: ");
        String title = scnr.nextLine().trim();
        
        System.out.print("Author: ");
        String author = scnr.nextLine().trim();
        
        System.out.print("Language: ");
        String language = scnr.nextLine().trim();
        
        int year = 0;
        while (true) {
            System.out.print("Year Published: ");
            String yearInput = scnr.nextLine().trim();
            try {
                year = Integer.parseInt(yearInput);
                if (year > 0) break;
                else System.out.println("Year must be a positive integer.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid year (e.g., 2021).");
            }
        }
        
        double price = 0.0;
        while (true) {
            System.out.print("Price (e.g., 19.99): ");
            String priceInput = scnr.nextLine().trim();
            if (priceInput.startsWith("$")) {
                priceInput = priceInput.substring(1).trim();
            }
            try {
                price = Double.parseDouble(priceInput);
                if (price >= 0) break;
                else System.out.println("Price cannot be negative.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid price format. Please enter a valid number (e.g., 19.99).");
            }
        }

        boolean availability = false;
        while (true) {
            System.out.print("Availability (enter 'true' or 'false'): ");
            String availInput = scnr.nextLine().trim().toLowerCase();
            if (availInput.equals("true") || availInput.equals("false")) {
                availability = Boolean.parseBoolean(availInput);
                break;
            } else {
                System.out.println("Invalid input. Please enter 'true' or 'false'.");
            }
        }

        int stock = 0;
        while (true) {
            System.out.print("Stock: ");
            String stockInput = scnr.nextLine().trim();
            try {
                stock = Integer.parseInt(stockInput);
                if (stock >= 0) break;
                else System.out.println("Stock cannot be negative.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number for stock (e.g., 10).");
            }
        }

        String bookType = "";
        while (true) {
            System.out.print("Is the book Fiction or Nonfiction? ");
            bookType = scnr.nextLine().trim();
            if (bookType.equalsIgnoreCase("Fiction") || bookType.equalsIgnoreCase("Nonfiction")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter 'Fiction' or 'Nonfiction'.");
            }
        }

        if (bookType.equalsIgnoreCase("Fiction")){
            boolean bSeller = false;
            while (true) {
                System.out.print("Is it a bestseller (enter 'true' or 'false'): ");
                String bSellerInput = scnr.nextLine().trim().toLowerCase();
                if (bSellerInput.equals("true") || bSellerInput.equals("false")) {
                    bSeller = Boolean.parseBoolean(bSellerInput);
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'true' or 'false'.");
                }
            }

            System.out.print("Book Genre: ");
            String genre = scnr.nextLine().trim();
            
            System.out.print("Target age of readers (e.g., 8+, 12+): ");
            String age = scnr.nextLine().trim();

            Fiction newBook = new Fiction(title, author, language, year, price, availability, stock, genre, bSeller, age);
            addBook(newBook);
        }
        else if (bookType.equalsIgnoreCase("Nonfiction")){
            System.out.print("Book Genre: ");
            String genre = scnr.nextLine().trim();
            
            int edition = 0;
            while (true) {
                System.out.print("Edition: ");
                String editionInput = scnr.nextLine().trim();
                try {
                    edition = Integer.parseInt(editionInput);
                    if (edition > 0) break;
                    else System.out.println("Edition must be a positive number.");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid edition number (e.g., 1).");
                }
            }
            
            boolean reviewed = false;
            while (true) {
                System.out.print("Peer Reviewed (enter 'true' or 'false'): ");
                String reviewedInput = scnr.nextLine().trim().toLowerCase();
                if (reviewedInput.equals("true") || reviewedInput.equals("false")) {
                    reviewed = Boolean.parseBoolean(reviewedInput);
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'true' or 'false'.");
                }
            }

            System.out.print("Book Topic: ");
            String topic = scnr.nextLine().trim();

            Nonfiction newBook = new Nonfiction(title, author, language, year, price, availability, stock, genre, edition, reviewed, topic);
            addBook(newBook);
        }
    }
//End of ChatGPT error checked code

    
    public void removeBookFromStore(Scanner scnr){ // Passing scanner as an argument
        System.out.print("Enter book title to remove: ");
        String bookToRemove = scnr.nextLine().trim();
        Book book = findBookByTitle(bookToRemove); 
        if (book != null) {
            removeBook(book);
        } 
        else {
            System.out.println("Book could not be found.");
        }
    }

    public void updateStock(Scanner scnr){ // Passing scanner as an argument
        System.out.print("Enter book title to update stock: ");
        String stockTitle = scnr.nextLine().trim();
        Book stockBook = findBookByTitle(stockTitle);
        if (stockBook != null) {
            int newStock = 0;
            while (true) {
                System.out.print("Enter new stock amount: ");
                String stockInput = scnr.nextLine().trim();
                try {
                    newStock = Integer.parseInt(stockInput);
                    if (newStock >= 0) break;
                    else System.out.println("Stock cannot be negative.");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number for stock (e.g., 10).");
                }
            }
            updateBookStock(stockBook, newStock);
        } 
        else {
            System.out.println("Book could not be found.");
        }
    }

    public void updatePrice(Scanner scnr){ // Passing scanner as an argument
        System.out.print("Enter book title to update price: ");
        String bookToPrice = scnr.nextLine().trim();
        Book priceBook = findBookByTitle(bookToPrice);
        if (priceBook != null) {
            double newPrice = 0.0;
            while (true) {
                System.out.print("Enter new price (e.g., 19.99): ");
                String priceInput = scnr.nextLine().trim();
                if (priceInput.startsWith("$")) {
                    priceInput = priceInput.substring(1).trim();
                }
                try {
                    newPrice = Double.parseDouble(priceInput);
                    if (newPrice >= 0) break;
                    else System.out.println("Price cannot be negative.");
                } catch (NumberFormatException e){
                    System.out.println("Invalid price format. Please enter a valid number (e.g., 19.99).");
                }
            }
            updateBookPrice(priceBook, newPrice);
        } 
        else {
            System.out.println("Book could not be found.");
        }
    }


    @Override
    public String toString() {
        String s = "";
        s += "\n";
        s += "ADMINISTRATOR ACCOUNT DETAILS\n";
        s += "-----------------------------\n";
        s += super.toString();
        // Additional administrator-specific details can be added here
        return s;
    }
}
