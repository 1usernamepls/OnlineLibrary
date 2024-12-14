import java.io.*;
import java.util.*;

public class BookShop {
    private User currentUser;
    private HashMap<String, User> savedUsers = new HashMap<>();

    public static void userNameGuidelines() {
        System.out.println("Please create a username that follows these guidelines: "); 
        System.out.println("\t 1) Has at least 5 characters");
        System.out.println("\t 2) Starts with a letter");
        System.out.println("\t 3) Is less than 16 characters");
    }

    public static void passWordGuidelines() {
        System.out.println("Make sure your password follows these rules: ");
        System.out.println("\t 1) Has at least 8 characters");
        System.out.println("\t 2) Starts with a letter");
        System.out.println("\t 3) Has at least one number");
        System.out.println("\t 4) Is less than 13 characters");
    }

    public static LinkedList<Book> defaultBooks(LinkedList<Book> ll) {
        Fiction f1 = new Fiction("Harry Potter And The Sorcerer's Stone", "J.K. Rowling", "English",
        1997, 6.99, true, 5, "FANTASY", true, "8+");
        ll.add(f1);
        Fiction f2 = new Fiction("IT", "Stephen King", "English", 
        1986, 14.17, true, 3, "HORROR", true, "12+");
        ll.add(f2);
        Fiction f3 = new Fiction("The Great Gatsby", "F. Scott Fitzgerald", "English",
        1925, 8.31, true, 7, "DRAMA", true, "14+");
        ll.add(f3);
        Nonfiction nf1 = new Nonfiction("What We Carry", "Maya Shanbhag Lang", "English", 
        2020, 14.81, true, 8, "MEMOIR", 1, false, "DISABILITY");
        ll.add(nf1);
        Nonfiction nf2 = new Nonfiction("Guiness World Records 2025", "GUINESS WORLD RECORDS", "English",
        2024, 13.98, true, 2, "ALMANAC", 1, false, "WORLD RECORDS");
        ll.add(nf2);
        Nonfiction nf3 = new Nonfiction("USA National Parks: Lands of Wonder", "Dk Travel", "English",
        2024, 18.57, true, 3, "TRAVEL BOOKS", 2, true, "NATIONAL PARKS");
        ll.add(nf3);
        Collections.sort(ll);
        return ll;
    }

    public static void listBooks(LinkedList<Book> ll) {
        int line = 0;
        for (Book b : ll) {
            System.out.println(++line);
            System.out.println();
            System.out.println(b);
            System.out.println();
        }
        try {
            int ln = 0;
            PrintWriter pw = new PrintWriter(new FileWriter("Books.txt"));
            pw.println("ALL BOOKS IN BOOKSHOP");
            pw.println("---------------------");
            pw.println();
            for (Book b : ll) {
                pw.println(++ln);
                pw.println(b);
                pw.println();
            }
            pw.close();
        }
        catch (IOException ioe) {
            System.err.println("Something went wrong when writing to the file!");
            ioe.printStackTrace();
        }
    }
      
    public static void administratorMenu(){
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

    public static void createBooksToAdd(Administrator a, Scanner scnr){ //passing scanner as an argument
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
            a.addBook(newBook);
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
            a.addBook(newBook);
        }
    }

    public static void removeBookFromStore(Administrator a, Scanner scnr){ //passing scanner as an argument
        System.out.print("Enter book title to remove: ");
        String bookToRemove = scnr.nextLine();
        Book book = a.findBookByTitle(bookToRemove); 
        if (book != null) {
            a.removeBook(book);
        } 
        else {
            System.out.println("Book could not be found.");
        }
    }

    public static void updateStock(Administrator a, Scanner scnr){//passing scanner as an argument
        System.out.print("Enter book title to update stock: ");
        String stockTitle = scnr.nextLine();
        Book stockBook = a.findBookByTitle(stockTitle);
        if (stockBook != null) {
            System.out.print("Enter new stock amount: ");
            int newStock = scnr.nextInt();
            scnr.nextLine();
            a.updateBookStock(stockBook, newStock);
        } 
        else {
            System.out.println("Book could not be found.");
        }
    }

    public static void updatePrice(Administrator a, Scanner scnr){ //passing scanner as an argument
        System.out.print("Enter book title to update price: ");
        String bookToPrice = scnr.nextLine();
        Book priceBook = a.findBookByTitle(bookToPrice);
        if (priceBook != null) {
            System.out.print("Enter new price: ");
            double newPrice = scnr.nextDouble();
            scnr.nextLine();
            a.updateBookPrice(priceBook, newPrice);
        } 
        else {
            System.out.println("Book could not be found.");
        }
    }

    public void logout() {
        if (currentUser != null) { //if someone is currently logged in
            if (!savedUsers.containsKey(currentUser.getEmail())) { //current user is not saved in user database
                savedUsers.put(currentUser.getEmail(), currentUser); //add to current saved user database 
            }
            System.out.println(currentUser.getUsername() + " has been logged out."); 
            currentUser = null; // logout current user
        } 
        else {
            System.out.println("No user is currently logged in.");
        }
    }

    public void saveUser(User user) {
        if (!savedUsers.containsKey(user.getEmail())) {
            savedUsers.put(user.getEmail(), user);
            System.out.println(user.getUsername() + " has been registered in the system.");
        } else {
            System.out.println("A user with this email already exists.");
        }
    }

    public static void main(String[] args) {
        // Create instance of BookShop class so it can interact with non-static fields and methods
        BookShop shop = new BookShop();
        Scanner scnr = new Scanner(System.in); // Single Scanner instance

        System.out.println("Hello There First Time User! It's my pleasure to welcome you to our ONLINE BOOKSHOP!");
        System.out.println("My name is Doti! I'm the system's bot who will help you on this exciting journey! :>");
        System.out.println(); 
        System.out.println("First let's get you set up with an account...");

        System.out.println("Some personal information we need to know: ");
        System.out.print("What is your email? : ");
        String email = scnr.nextLine();
        while (!email.contains("@") || !email.contains(".") || !Character.isLetter(email.charAt(0))) {
            System.out.println("That is not a valid email!"); 
            System.out.print("What is your email? : ");
            email = scnr.nextLine();
        }
        System.out.println(); 

        System.out.println("Perfect!");
        System.out.print("Now what is your first name? : ");
        String firstName = scnr.nextLine();
        System.out.println(); 

        System.out.print("Last name? : ");
        String lastName = scnr.nextLine();
        System.out.println(); 

        System.out.println("Nice! Moving on, what username would you like to have with us?");
        userNameGuidelines();
        System.out.print("Type your username here: ");
        String username = scnr.nextLine();
        while (!Character.isLetter(username.charAt(0)) || username.length() < 5 || username.length() > 15) {
            System.out.println("That is not a valid username!");
            userNameGuidelines();
            System.out.print("Type your username here: ");
            username = scnr.nextLine();
        }
        System.out.println(); 

        System.out.println("Now let's type in a password!");
        passWordGuidelines();
        System.out.print("Type your password here: ");
        String password = scnr.nextLine();
        while (!Character.isLetter(password.charAt(0)) || password.length() < 8 || password.length() > 12 || !password.matches(".*\\d.*")) {
            System.out.println("That is not a valid password!");
            passWordGuidelines();
            System.out.print("Type your password here: ");
            password = scnr.nextLine();
        }
        System.out.println(); 

        System.out.print("Finally, most important, do you identify as a 'customer' or an 'administrator'? : ");
        String userType = scnr.nextLine();
        while (!userType.equalsIgnoreCase("customer") && !userType.equalsIgnoreCase("administrator")) {
            System.out.println("That is not a valid user type!");
            System.out.println("Try again.");
            System.out.print("Do you identify as a 'customer' or an 'administrator'? : ");
            userType = scnr.nextLine();
        }

        if (userType.equalsIgnoreCase("customer")) {
            Customer c = new Customer(email, username, password, firstName, lastName);
            shop.currentUser = c; // Assign currentUser as the customer
            shop.saveUser(c); // Save customer to user database
            System.out.println(c);
            System.out.println(); 
            System.out.println("Congrats! Your account has been successfully created. Anything you'd like to review or change before we move on?");
            System.out.print("Type 'yes' or 'no' : ");
            String decision = scnr.nextLine();
            if (decision.equalsIgnoreCase("yes")) {
                System.out.print("Alrighty! Would you like to 'review' or 'change' something in your account? : ");
                String action = scnr.nextLine();
                if (action.equalsIgnoreCase("review")) {
                    c.checkAccount(scnr);
                }
                if (action.equalsIgnoreCase("change")) {
                    c.changeAccount(scnr);
                }
            }
            LinkedList<Book> books = new LinkedList<>();
            System.out.println();
            System.out.println("ALL BOOKS IN BOOKSHOP");
            System.out.println("---------------------");
            System.out.println();
            books = defaultBooks(books);
            listBooks(books);
            System.out.println("Let's continue!");
            System.out.println("Above is a list of books we have at the current moment!");
            System.out.println("To view the list in full, see the file we've deposited to your account on the side of this interface.");

            System.out.print("Would you like to do anything else today? (yes/no) : ");
            String decision2 = scnr.nextLine();
            if (decision2.equalsIgnoreCase("yes")) {
                System.out.println("Alright then :)");
                System.out.println("On our website, you can interact with books in 2 ways: ");
                System.out.println("\t1) Adding Books To Your Cart");
                System.out.println("\t2) Purchasing And Ordering Books Directly");
                System.out.println("Which one would you like to do?");
                System.out.print("Type 'add' or 'purchase' here : ");
                String action2 = scnr.nextLine();
                if (action2.equalsIgnoreCase("add")) {
                    System.out.print("Would you like to continue in 'add' mode? (yes/no) : ");
                    String addMode = scnr.nextLine();
                    while (addMode.equalsIgnoreCase("yes")) {
                        if (c.getCart().isEmpty()) {
                            System.out.println("Let's add to your cart!");
                            String add = "add";
                            while (add.equalsIgnoreCase("add")) {
                                c.addCart(books, scnr);
                                System.out.println();
                                System.out.println("Book added!");
                                System.out.println("Any other books you'd like to add?");
                                System.out.print("Type 'add' if yes, anything else if no: ");
                                add = scnr.nextLine();
                            }        
                        }
                        else {
                            c.moreOptions(books, scnr);
                        }
                        System.out.println("Edit Success!");
                        System.out.println("Here's what your cart looks like...");
                        System.out.println();
                        int ln = 0;
                        for (Book b : c.getCart()) {
                            System.out.println(++ln);
                            System.out.println();
                            System.out.println(b);
                            System.out.println();
                        }
                        System.out.print("Any second thoughts about editing your cart before purchase? (yes/no) : ");
                        addMode = scnr.nextLine();
                    }
                }
                System.out.print("Would you like to continue purchasing? (yes/no) : ");
                String action3 = scnr.nextLine();
                if (action3.equalsIgnoreCase("yes")) {
                    if (!c.getCart().isEmpty()) {
                        System.out.println("Below is a simulated order of the books you'd like to pay for...");
                        Order o = new Order(c);
                        for (Book b : c.getCart()) {
                            o.addToOrder(b);
                        }
                        System.out.println();
                        System.out.println(o);
                        System.out.println("Would you like to PAY for this order or CANCEL?");
                        System.out.print("Type 'pay' or 'cancel' here: ");
                        String finalDecision = scnr.nextLine();
                        if (finalDecision.equalsIgnoreCase("pay")) {
                            System.out.println("CONGRADULATIONS!!!! Your Order has been placed!");
                            
                            c.getOrders().add(o);
                            // Assuming you have access to Administrator to add to allOrders
                        }
                    }
                    else {
                        Order o2 = new Order(c);
                        String addBook = "add";
                        while (addBook.equalsIgnoreCase("add")) {
                            System.out.println("Agreed :> What book would you like to purchase in your order?");
                            System.out.print("Type the number of the book you want here: ");
                            if (scnr.hasNextInt()) {
                                int bNum = scnr.nextInt();
                                scnr.nextLine(); // Consume the leftover newline
                                bNum -= 1;
                                if(bNum >= 0 && bNum < books.size()){
                                    o2.addToOrder(books.get(bNum));
                                }
                                else{
                                    System.out.println("Invalid book number.");
                                }
                            } else {
                                System.out.println("Invalid input. Please enter a valid number.");
                                scnr.nextLine(); // Consume the invalid input
                                continue;
                            }
                            System.out.println();
                            System.out.println("Below is a simulated order of the books you'd like to pay for...");
                            System.out.println();
                            System.out.println(o2);
                            System.out.println();
                            System.out.println("Would you like to add another book or purchase?");
                            System.out.print("Type 'add' or 'purchase' here : ");
                            addBook = scnr.nextLine();
                        }
                        System.out.print("Any thoughts about removing books before purchase? (yes/no) : ");
                        String removeBook = scnr.nextLine();
                        while (removeBook.equalsIgnoreCase("yes") && o2.getOrderItems().size() > 0) {
                            System.out.println("Ok. What book would you like to remove from your order?");
                            int item = 0;
                            for (Book b : o2.getOrderItems()) {
                                System.out.println();
                                System.out.println(++item);
                                System.out.println();
                                System.out.println(b);
                                System.out.println();
                            }
                            System.out.print("Type the number of the book you'd like to remove here: ");
                            if (scnr.hasNextInt()) {
                                int itemNum = scnr.nextInt();
                                scnr.nextLine(); // Consume the leftover newline
                                itemNum -= 1;
                                if(itemNum >= 0 && itemNum < o2.getOrderItems().size()){
                                    o2.removeBookFromOrder(o2.getOrderItems().get(itemNum));
                                    System.out.println("Below is a simulated order of the books you'd like to pay for now...");
                                    System.out.println();
                                    System.out.println(o2);
                                    System.out.println();
                                }
                                else{
                                    System.out.println("Invalid book number.");
                                }
                            } else {
                                System.out.println("Invalid input. Please enter a valid number.");
                                scnr.nextLine(); // Consume the invalid input
                                continue;
                            }
                            System.out.print("Would you like to remove another book? (yes/no) : ");
                            removeBook = scnr.nextLine();
                        }
                        System.out.print("Would you like to PAY for this order or CANCEL? (pay/cancel) : ");
                        String finalDecision2 = scnr.nextLine();
                        if (finalDecision2.equalsIgnoreCase("pay")) {
                            System.out.println("CONGRADULATIONS!!!! Your Order has been placed!");
                            c.getOrders().add(o2);
                            // Assuming you have access to Administrator to add to allOrders
                        }
                    }
                }
            }
        }

        if (userType.equalsIgnoreCase("administrator")) {
            LinkedList<Book> books2 = new LinkedList<>();
            books2 = defaultBooks(books2);
            Administrator a = new Administrator(email, username, password, firstName, lastName);
            shop.currentUser = a;
            shop.saveUser(a); // save administrator to user database
            a.books = books2;
            System.out.println(a);
            System.out.println("Congrats! Your account has been successfully created.");
            System.out.println("What would you like to do?");
            administratorMenu();
            System.out.print("Type the number of the option you'd like to choose: ");
            if (scnr.hasNextInt()) {
                int choice = scnr.nextInt();
                scnr.nextLine(); // Consume the leftover newline

                switch (choice) {
                    case 1:
                        System.out.println("----------REVIEW ACCOUNT----------");
                        System.out.println();
                        a.checkAccount(scnr); //Notice how im passing a scanner object
                        break;
                    case 2:
                        System.out.println("----------CHANGE ACCOUNT----------");
                        System.out.println();
                        a.changeAccount(scnr);
                        break;
                    case 3:
                        System.out.println("----------ADD A BOOK TO THE SHOP----------");
                        System.out.println();
                        createBooksToAdd(a, scnr);
                        break;
                    case 4:
                        System.out.println("----------REMOVE A BOOK FROM THE SHOP----------");
                        System.out.println();
                        listBooks(a.getBooks());
                        removeBookFromStore(a, scnr);
                        break;
                    case 5:
                        System.out.println("----------UPDATE BOOK STOCK----------");
                        System.out.println();
                        listBooks(a.getBooks());
                        updateStock(a, scnr);
                        break;
                    case 6:
                        System.out.println("----------UPDATE BOOK PRICES----------");
                        System.out.println();
                        listBooks(a.getBooks());
                        updatePrice(a, scnr);
                        break;
                    case 7:
                        System.out.println("----------VIEW SHOP'S COMPLETED ORDERS----------");
                        System.out.println();
                        a.viewOrderHistory();
                        break;
                    case 8:
                        System.out.println("----------UPDATE COMPLETED ORDERS----------");
                        System.out.println();
                        a.addFinishedOrder();
                        break; // Added break to prevent fall-through
                    case 9:
                        shop.logout();
                        break;
                    default:
                        System.out.println("Invalid option! Please try again.");
                        System.out.println();
                        administratorMenu();
                        System.out.print("Type the number of the option you'd like to choose: ");
                        if (scnr.hasNextInt()) {
                            choice = scnr.nextInt();
                            scnr.nextLine(); // Consume the leftover newline
                            
                        } else {
                            System.out.println("Invalid input. Please enter a valid number.");
                            scnr.nextLine(); // Consume the invalid input
                        }
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scnr.nextLine(); // Consume the invalid input
            }
        }
        System.out.println("Thank you! Goodbye! :>");
        scnr.close(); // Close the Scanner at the end of the program
    }
}
