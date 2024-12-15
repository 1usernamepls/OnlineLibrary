import java.io.*; // imports all io exceptions and processes from java libraries
import java.util.*; // imports all java utilities and built in processes from java libraries

public class BookShop { // 
    private User currentUser; // creates a user object
    private HashMap<String, User> savedUsers = new HashMap<>(); // stores new user objects that are created

    // STATIC HELPER METHODS

    public static void userNameGuidelines() { // guidelines for usernames are repeated several times throughout our program
        // to condense the amount of lines for this, we created this static method to print these guidelines
        System.out.println("Please create a username that follows these guidelines: "); 
        System.out.println("\t 1) Has at least 5 characters");
        System.out.println("\t 2) Starts with a letter");
        System.out.println("\t 3) Is less than 16 characters");
    }

    public static void passWordGuidelines() { // guidelines for passwords are repeated several times throughout our program
        // to condense the amount of lines for this, we created this static method to print these guidelines
        System.out.println("Make sure your password follows these rules: ");
        System.out.println("\t 1) Has at least 8 characters");
        System.out.println("\t 2) Starts with a lettter");
        System.out.println("\t 3) Has at least one number");
        System.out.println("\t 4) Is less than 13 characters");
    }

    public static LinkedList<Book> defaultBooks(LinkedList<Book> ll) { // a static helper method for generating books in our BookShop
        // takes in a LinkedList of books and fills it
        // 8 assigned books, 4 Fiction and 4 Nonfiction types are created and made for customers and administrators to interact with
        // initially, we thought about continuously updating this and saving, but then realized that would've resulted in more complex code we didn't understand
        // whether you are a customer or an administrator, you are always going to start with these same books
        Fiction f1 = new Fiction("Harry Potter And The Sourcerer's Stone", "J.K. Rowling", "English",
        1997, 6.99, true, 5, "FANTASY", true, "8+");
        ll.add(f1);
        Fiction f2 = new Fiction("IT", "Stephen King", "English", 
        1986, 14.17, true, 3, "HORROR", true, "12+");
        ll.add(f2);
        Fiction f3 = new Fiction("The Great Gatsby", "F. Scott Fitzgerald", "English",
        1925, 8.31, true, 7, "DRAMA", true, "14+");
        ll.add(f3);
        Fiction f4 = new Fiction("The Pricess And The Unicorn", "A.M. Luzzader", "English", 
        2021, 7.24, true, 4, "FAIRYTALES", true, "5+");
        ll.add(f4);
        Nonfiction nf1 = new Nonfiction("What We Carry", "Maya Shanbhag Lang", "English", 
        2020, 14.81, true, 8, "MEMOIR", 1, false, "DISABILITY");
        ll.add(nf1);
        Nonfiction nf2 = new Nonfiction("Guiness World Records 2025", "GUINESS WORLD RECORDS", "English",
        2024, 13.98, true, 2, "ALMANAC", 1, false, "WORLD RECORDS");
        ll.add(nf2);
        Nonfiction nf3 = new Nonfiction("USA National Parks: Lands of Wonder", "Dk Travel", "English",
        2024, 18.57, true, 3, "TRAVEL BOOKS", 2, true, "NATIONAL PARKS");
        ll.add(nf3);
        Nonfiction nf4 = new Nonfiction("BLACK SHEEP: Unleash The Extraordinary, Awe-Inspiring, Undiscovered You", "Brant MensWar", "English",
        2020, 22.36, true, 4, "INSPIRATIONAL BOOKS", 1, false, "SELF POTENTIAL");
        ll.add(nf4);
        Collections.sort(ll);
        // pulls in compareTo() interface from Book.java
        // organizes books in terms of price
        return ll; // the organized linkedList is returned
    }

    public static void printBooks(LinkedList<Book> ll) { // a static helper method for printing books
        // may be used for full Book lists, customer carts, customer orders, or administrator output
        int line = 0; // an integer is assigned to 0
        for (Book b : ll) { // for each book in the linkedlist of books
            System.out.println();
            System.out.println(++line);
            System.out.println();
            System.out.println(b);
            // print a newline, the book number, and its details
        }
    }

    public static void listBooks(LinkedList<Book> ll) { // a static helper method for writing books into a file list
        // used for updating the BookShop's entire book list in write mode when changes are made
        // some of these changes will include stock, book availability, and addition / removal of books
        try { // try this code for writing the file
            int ln = 0;
            PrintWriter pw = new PrintWriter(new FileWriter("Books.txt"));
            // a Books.txt file is created to write books in
            pw.println("ALL BOOKS IN BOOKSHOP"); // title
            pw.println("---------------------");
            pw.println(); // write newline
            for (Book b : ll) { // for each book in the linkedlist
                pw.println(++ln); // write the book number
                pw.println(); // newline
                pw.println(b); // book contents
                pw.println(); // newline
            }
            pw.close(); // close printwriter after finished
        }
        catch (IOException ioe) { // if something goes wrong writing the file
            System.err.println("Something went wrong when writing to the file!");
            ioe.printStackTrace(); // output error and message
        }
    }

    public static void defaultOrders(LinkedList<Book> ll, Administrator a) {
        Customer c = new Customer("pattyj@aol.com", "mummy2", "iluvu1987", "Patty", "Johnson");
        Order o1 = new Order(c);
        o1.addToOrder(ll.get(0));
        o1.addToOrder(ll.get(2));
        o1.addToOrder(ll.get(5));
        o1.setOrderStatus("Delivered");
        a.allOrders.add(o1);
        Customer b = new Customer("manimuni@chapman.edu", "The14u", "igilldoit2", "Mark", "Mendoza");
        Order o2 = new Order(b);
        o2.addToOrder(ll.get(4));
        o2.addToOrder(ll.get(6));
        o2.setOrderStatus("Shipped");
        a.allOrders.add(o2);
        Customer d = new Customer("bunnymai@gmail.com", "puppies4ever", "myla46!!", "Kai", "Jackson");
        Order o3 = new Order(d);
        o3.addToOrder(ll.get(1));
        o3.addToOrder(ll.get(7));
        o3.setOrderStatus("Shipped");
        a.allOrders.add(o3);
        Customer e = new Customer("glop@yahoo.com", "username1", "yahooglop0", "Gustavo", "Kumar");
        Order o4 = new Order(e);
        o4.addToOrder(ll.get(3));
        o4.setOrderStatus("Delivered");
        a.allOrders.add(o4);
        Customer f = new Customer("kangminji@gmail.com", "minHoSun!", "ello123h", "Min", "Park");
        Order o5 = new Order(f);
        o5.addToOrder(ll.get(6));
        o5.addToOrder(ll.get(0));
        o5.addToOrder(ll.get(3));
        o5.addToOrder(ll.get(7));
        a.allOrders.add(o5);
    }

    public static void listOrders(ArrayList<Order> o) {
        try { // try this code for writing the file
            int ln = 0;
            PrintWriter pw = new PrintWriter(new FileWriter("Orders.txt"));
            // an Orders.txt file is created to write orders in
            pw.println("ALL ORDERS IN BOOKSHOP"); // title
            pw.println("----------------------");
            pw.println(); // write newline
            for (Order i : o) { // for each order in the linkedlist
                pw.println(++ln); // write the order number
                pw.println(); // newline
                pw.println(i); // order contents
                pw.println(); // newline
            }
            pw.close(); // close printwriter after finished
        }
        catch (IOException ioe) { // if something goes wrong writing the file
            System.err.println("Something went wrong when writing to the file!");
            ioe.printStackTrace(); // output error and message
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
        
        // INTRODUCTION
        // in our program, we assume all users are first time so we can get them set up with an account
        System.out.println("Hello There First Time User! It's my pleasure to welcome you to our ONLINE BOOKSHOP!");
        System.out.println("My name is Doti! I'm the system's bot who will help you on this exciting journey! :>");
        System.out.println(); 
        System.out.println("First let's get you set up with an account...");

        // PERSONAL IDENTIFICATION INFORMATION

        System.out.println("Some personal information we need to know: ");
        System.out.print("What is your email? : "); // input for email as String
        String email = scnr.nextLine();
        while (!email.contains("@") || !email.contains(".") || !Character.isLetter(email.charAt(0))) {
            // while an email doesn't contain an @, ., or start with a letter
            System.out.println("That is not a valid email!"); 
            System.out.print("What is your email? : ");
            email = scnr.nextLine(); // input email again
        }
        System.out.println(); 

        System.out.println("Perfect!");
        System.out.print("Now what is your first name? : "); // input for first name as String
        String firstName = scnr.nextLine(); // here a user has the option to register in guest mode by not typing anything
        System.out.println(); 

        System.out.print("Last name? : "); // input for last name as String
        String lastName = scnr.nextLine(); // once again, a user is not required to enter their name if they are a guest
        System.out.println(); 

        System.out.println("Nice! Moving on, what username would you like to have with us?");
        userNameGuidelines(); // calls static void method for rules of usernames
        System.out.print("Type your username here: "); // input for username as String
        String username = scnr.nextLine();
        while (!Character.isLetter(username.charAt(0)) || username.length() < 5 || username.length() > 15) {
            // while a username does not start with a letter, is less than 5 characters, or greater than 15 characters            
            System.out.println("That is not a valid username!");
            userNameGuidelines(); // print guidelines again
            System.out.print("Type your username here: "); // input username again
            username = scnr.nextLine();
        }
        System.out.println(); 

        System.out.println("Now let's type in a password!");
        passWordGuidelines();  // calls static void method for rules of passwords
        System.out.print("Type your password here: "); // input for password as String
        String password = scnr.nextLine();
        while (!Character.isLetter(password.charAt(0)) || password.length() < 8 || password.length() > 12 || !password.matches(".*\\d.*")) {
            // while a password doesn not start with a letter, is less than 8 characters, is greater than 12 characters, or does not contain a number
            // password.matches(etc) is a method I got from a Computer Science friend, David Sohn
            System.out.println("That is not a valid password!");
            passWordGuidelines(); // print guidelines again
            System.out.print("Type your password here: "); // input password again
            password = scnr.nextLine();
        }
        System.out.println(); 

        System.out.print("Finally, most important, do you identify as a 'customer' or an 'administrator'? : ");
        // identification line that determines whether a user is operating a customer or administrator
        // customers and administrators have different functions so honesty is important here            
        String userType = scnr.nextLine();
        while (!userType.equalsIgnoreCase("customer") && !userType.equalsIgnoreCase("administrator")) {
            // equalsIgnoreCase ignores the casing of the input so the user can type 'customer' or 'Customer' or 'CUSTOMER' and it would still read the same
            // while however a user does not type in customer or administrator, they cannot move on
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
            printBooks(books);
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
            System.out.println("Would you like to continue?");
            System.out.println("Type 'yes' or 'no' : ");
            String admindecision = scnr.nextLine();
            while (admindecision.equalsIgnoreCase("yes")) {
                System.out.println("What would you like to do?");
                a.administratorMenu();
                System.out.print("Type the number of the option you'd like to choose: ");
                if (scnr.hasNextInt()) {
                    int choice = scnr.nextInt();
                    scnr.nextLine(); // Consume the leftover newline

                    switch (choice) {
                        case 1:
                            System.out.println();
                            System.out.println("----------REVIEW ACCOUNT----------");
                            System.out.println();
                            a.checkAccount(scnr); //Notice how im passing a scanner object
                            break;
                        case 2:
                            System.out.println();
                            System.out.println("----------CHANGE ACCOUNT----------");
                            System.out.println();
                            a.changeAccount(scnr);
                            break;
                        case 3:
                            System.out.println();
                            System.out.println("----------ADD A BOOK TO THE SHOP----------");
                            System.out.println();
                            listBooks(a.getBooks());
                            a.createBooksToAdd(scnr);
                            listBooks(a.getBooks());
                            printBooks(a.getBooks());
                            System.out.println("Book Addition Success!");
                            break;
                        case 4:
                            System.out.println();
                            System.out.println("----------REMOVE A BOOK FROM THE SHOP----------");
                            System.out.println();
                            listBooks(a.getBooks());
                            printBooks(a.getBooks());
                            a.removeBookFromStore(scnr);
                            listBooks(a.getBooks());
                            printBooks(a.getBooks());
                            System.out.println("Book Removal Success!");
                            break;
                        case 5:
                            System.out.println();
                            System.out.println("----------UPDATE BOOK STOCK----------");
                            System.out.println();
                            listBooks(a.getBooks());
                            printBooks(a.getBooks());
                            a.updateStock(scnr);
                            listBooks(a.getBooks());
                            printBooks(a.getBooks());
                            System.out.println("Stock Update Success!");
                            break;
                        case 6:
                            System.out.println();
                            System.out.println("----------UPDATE BOOK PRICES----------");
                            System.out.println();
                            listBooks(a.getBooks());
                            printBooks(a.getBooks());
                            a.updatePrice(scnr);
                            listBooks(a.getBooks());
                            printBooks(a.getBooks());
                            System.out.println("Price Update Success!");
                            break;
                        case 7:
                            System.out.println();
                            System.out.println("----------VIEW SHOP'S ORDERS----------");
                            System.out.println();
                            defaultOrders(a.getBooks(), a);
                            listOrders(a.getAllOrders());
                            a.viewOrderHistory();
                            System.out.println();
                            System.out.println("Order History Above ^");
                            break;
                        case 8:
                            System.out.println();
                            System.out.println("----------UPDATE COMPLETED ORDERS----------");
                            System.out.println();
                            defaultOrders(a.getBooks(), a);
                            listOrders(a.getAllOrders());
                            a.addFinishedOrder();
                            for (Order o : a.completedOrders) {
                                System.out.println(o);
                            }
                            System.out.println("All Completed Orders Above ^");
                            break; // Added break to prevent fall-through
                        case 9:
                            shop.logout();
                            break;
                        default:
                            System.out.println("Invalid option! Please try again.");
                            System.out.println();
                            a.administratorMenu();
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
                System.out.println("Would you like to continue with more actions?");
                System.out.println("Type 'yes' or 'no' : ");
                admindecision = scnr.nextLine();
            }
        }
        System.out.println("Thank you! Goodbye! :>");
        scnr.close(); // Close the Scanner at the end of the program
    }
}
