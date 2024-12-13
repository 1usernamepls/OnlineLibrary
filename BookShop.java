import java.util.*;
import java.io.*;

public class BookShop {

    public static void userNameGuidelines() {
        System.out.println("Please provide a username that follows these guidelines: ");
        System.out.println("\t 1) Has at least 5 characters");
        System.out.println("\t 2) Starts with a letter");
        System.out.println("\t 3) Is less than 16 characters");
    }

    public static void passWordGuidelines() {
        System.out.println("Make sure your password follows these rules: ");
        System.out.println("\t 1) Has at least 8 characters");
        System.out.println("\t 2) Starts with a lettter");
        System.out.println("\t 3) Has at least one number");
        System.out.println("\t 4) Is less than 13 characters");
    }

    public static void accountDetails() {
        System.out.println("\t1) Email");
        System.out.println("\t2) Username");
        System.out.println("\t3) Password");
    }

    public static void checkAccount(User u) {
        Scanner s = new Scanner(System.in);
        System.out.println("What part of your account would you like to check?");
        accountDetails();
        System.out.println("\t4) Name");
        System.out.print("Type the number of the option you'd like to see: ");
        int option = s.nextInt();
        switch (option) {
            case 1:
                System.out.println("Your Email Is: " + u.getEmail());
                break;
            case 2:
                System.out.println("Your Username Is: " + u.getUsername());
                break;
            case 3:
                System.out.println("Your Password Is: " + u.getPassword());
                break;
            case 4:
                System.out.println("Your Name Is: " + u.getName());
                break;
            default:
                System.out.println("Invalid Input :(");
        }
        s.close();
    }

    public static void changeAccount(User u) {
        Scanner s = new Scanner(System.in);
        System.out.println("What part of your account would you like to change?");
        accountDetails();
        System.out.print("Type the number of the option you'd like to change: ");
        int option = s.nextInt();
        s.nextLine(); // added to consume newline after user integer input 

        switch (option) {
            case 1:
                String e = "e";
                while (e.contains("@") == false || e.contains(".") == false || Character.isLetter(e.charAt(0)) == false) {
                    System.out.println("What will your new email be? : ");
                    e = s.nextLine();
                }
                u.setEmail(e);
                System.out.println("Change success!");
                break;
            case 2:
                userNameGuidelines();
                String user = "user";
                while (user.length() < 5 || user.length() > 15 || Character.isLetter(user.charAt(0)) == false) {
                    System.out.println("Type your new username here: ");
                    user = s.nextLine();
                } 
                u.setUsername(user); 
                System.out.println("Change success!");              
                break;
            case 3:
                passWordGuidelines();
                String p = "p";
                while (p.length() < 8 || p.length() > 12 || p.matches(".*\\d.*") == false || Character.isLetter(p.charAt(0)) == false) {
                    System.out.println("Type your new password here: ");
                    p = s.nextLine();
                }
                u.setPassword(p);
                System.out.println("Change success!");              
                break;
            default:
                System.out.println("Invalid Input :(");
        }
        System.out.println(u);
        s.close();
    }

    public static void defaultBooks(LinkedList<Book> ll) {
        Fiction f1 = new Fiction("Harry Potter And The Sourcerer's Stone", "J.K. Rowling", "English",
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
    
    public static void addCart(LinkedList<Book> ll, Customer c) {
        Scanner s = new Scanner(System.in);
        System.out.println("What book would you like to add?");
        System.out.print("Enter the number of the book you want here: ");
        int bookNum = s.nextInt();
        bookNum -= 1;
        c.addToCart(ll.get(bookNum));
        s.close();
    }

    public static void removeCart(LinkedList<Book> ll, Customer c) {
        Scanner s = new Scanner(System.in);
        System.out.println("Ok. Type the number of the book you'd like to remove here: ");
        int removedBook = s.nextInt();
        removedBook -= 1;
        c.removeFromCart(ll.get(removedBook));
        s.close();
    }
    
    public static void moreOptions(LinkedList<Book> ll, Customer c) {
        Scanner s = new Scanner (System.in);
        System.out.println("Now that your cart has books, there are several options you can choose from...");
        System.out.println("\t1) Adding Books");
        System.out.println("\t2) Removing Books");
        System.out.println("\t3) Clearing Your Cart");
        System.out.println("What would you like to do?");
        System.out.print("Type in your number option here: ");
        int option = s.nextInt();
        switch (option) {
            case 1:
                System.out.println("Let's add to your cart!");
                String add = "add";
                while (add.equals("add")) {
                    addCart(ll, c);
                    System.out.println();
                    System.out.println("Book added!");
                    System.out.println("Any other books you'd like to add?");
                    System.out.print("Type 'add' if yes, anything else if no: ");
                    add = s.nextLine();    
                }
                break;
            case 2:
                System.out.println("Let's remove books from your cart!");
                String remove = "remove";
                while (remove.equals("remove") && c.getCart().size() > 0) {
                    removeCart(c.getCart(), c);
                    System.out.println();
                    System.out.println("Book removed!");
                    System.out.println("Other books you'd like to remove?");
                    System.out.println("Type 'remove' if yes, anything else if no: ");
                    remove = s.nextLine();
                }
                break;
            case 3:
                System.out.println("Let's clear your cart!");
                c.clearCart();
                break;
            default:
                System.out.println("Invalid Input :(");
        }
        s.close();   
    }
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        System.out.println("Hello There First Time User! It's my pleasure to welcome you to our ONLINE BOOKSHOP!");
        System.out.println("My name is Doti! I'm the system's bot who will help you on this exciting journey! :>");
        System.out.println("First let's get you set up with an account...");

        System.out.println("Some personal information we need to know: ");
        System.out.println("What is your email? : ");
        String email = scnr.nextLine();
        while (email.contains("@") == false || email.contains(".") == false || Character.isLetter(email.charAt(0)) == false) {
            System.out.println("That is not an email!");
            System.out.println("What is your email? : ");
            email = scnr.nextLine();
        }

        System.out.println("Perfect!");
        System.out.println("Now what is your first name? : ");
        String firstName = scnr.nextLine();

        System.out.println("Last name? : ");
        String lastName = scnr.nextLine();

        System.out.println("Nice! Moving on, what username would you like to have with us?");
        userNameGuidelines();
        System.out.println("Type your username here: ");
        String username = scnr.nextLine();
        while (Character.isLetter(username.charAt(0)) == false || username.length() < 5 || username.length() > 15) {
            System.out.println("That is not a valid username!");
            userNameGuidelines();
            System.out.println("Type your username here: ");
            username = scnr.nextLine();
        }

        System.out.println("Now let's type in a password!");
        passWordGuidelines();
        System.out.println("Type your password here: ");
        String password = scnr.nextLine();
        while (Character.isLetter(password.charAt(0)) == false || password.length() < 8 || password.length() > 12 || password.matches(".*\\d.*") == false) {
            System.out.println("That is not a valid password!");
            passWordGuidelines();
            System.out.println("Type your password here: ");
            password = scnr.nextLine();
        }

        System.out.println("Finally, most important, do you identify as a 'customer' or an 'administrator'? : ");
        String user = scnr.nextLine();
        while (user.equals("customer") == false && user.equals("administrator") == false) {
            System.out.println("That is not a valid user type!");
            System.out.println("Try again.");
            System.out.println("do you identify as a 'customer' or an 'administrator'? : ");
            user = scnr.nextLine();
        }

        if (user.equals("customer")) {
            Customer c = new Customer(email, username, password, firstName, lastName);
            System.out.println(c);
            System.out.println("Congrats! Your account has been successfully created. Anything you'd like to check or change before we move on?");
            System.out.print("Type 'yes' or 'no' : ");
            String decision = scnr.nextLine();
            if (decision.equals("yes")) {
                System.out.println("Alrighty! Would you like to 'check' or 'change' something in your account? : ");
                String action = scnr.nextLine();
                if (action.equals("check")) {
                    checkAccount(c);
                }
                if (action.equals("change")) {
                    changeAccount(c);
                }
            }
            LinkedList<Book> books = new LinkedList<>();
            System.out.println("ALL BOOKS IN BOOKSHOP");
            System.out.println("---------------------");
            System.out.println();
            defaultBooks(books);
            System.out.println("Let's continue!");
            System.out.println("Above is a list of books we have at the current moment!");
            System.out.println();
            System.out.println("To view the list in full, see the file we've deposited to your account on the side of this interface.");
            
            System.out.println("Would you like to do anything else today?");
            System.out.print("Type 'yes' or 'no' : ");
            String decision2 = scnr.nextLine();
            if (decision2.equals("yes")) {
                System.out.println("Alright then :)");
                System.out.println("On our website, you can interact with books in 2 ways: ");
                System.out.println("\t1) Adding Books To Your Cart");
                System.out.println("\t2) Purchasing And Ordering Books Directly");
                System.out.println("Which one would you like to do?");
                System.out.println("Type 'add' or 'purchase' here : ");
                String action2 = scnr.nextLine();
                if (action2.equals("add")) {
                    System.out.println("Would you like to continue in 'add' mode?");
                    System.out.println("Type 'yes' or 'no' : ");
                    String addMode = scnr.nextLine();
                    while (addMode.equals("yes")) {
                        if (c.getCart().size() == 0) {
                            System.out.println("Let's add to your cart!");
                            String add = "add";
                            while (add.equals("add")) {
                                addCart(books, c);
                                System.out.println();
                                System.out.println("Book added!");
                                System.out.println("Any other books you'd like to add?");
                                System.out.print("Type 'add' if yes, anything else if no: ");
                                add = scnr.nextLine();
                            }        
                        }
                        else if (c.getCart().size() > 0) {
                            moreOptions(books, c);
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
                        System.out.println("Any second thoughts about editing your cart before purchase?");
                        System.out.println("Type 'yes' or 'no' : ");
                        addMode = scnr.nextLine();
                    }
                }
                System.out.println("Would you like to continue purchasing?");
                System.out.print("Type 'yes' or 'no' : ");
                String action3 = scnr.nextLine();
                if (action3.equals("yes")) {
                    if (c.getCart().size() > 0) {
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
                        if (finalDecision.equals("pay")) {
                            System.out.println("CONGRADULATIONS!!!! Your Order has been placed!");
                        }
                    }
                    else {
                        Order o2 = new Order(c);
                        String addBook = "add";
                        while (addBook.equals("add")) {
                            System.out.println("Agreed :> What book would you like to purchase in your order?");
                            System.out.print("Type the number of the book you want here: ");
                            int bNum = scnr.nextInt();
                            bNum -= 1;
                            o2.addToOrder(books.get(bNum));
                            System.out.println();
                            System.out.println("Below is a simulated order of the books you'd like to pay for...");
                            System.out.println();
                            System.out.println(o2);
                            System.out.println();
                            System.out.println("Would you like to add another book or purchase?");
                            System.out.println("Type 'add' or 'purchase' here : ");
                            addBook = scnr.nextLine();
                        }
                        System.out.println("Would you like to PAY for this order or CANCEL?");
                        System.out.print("Type 'pay' or 'cancel' here: ");
                        String finalDecision2 = scnr.nextLine();
                        if (finalDecision2.equals("pay")) {
                            System.out.println("CONGRADULATIONS!!!! Your Order has been placed!");
                            System.out.println("Have a great day!");
                        }
                    }
                }
            }
        }
        if (user.equals("administrator")) {
            Administrator a = new Administrator(email, username, password, firstName, lastName);
            System.out.println(a);
            System.out.println("Congrats! Your account has been successfully created. Anything you'd like to 'check' or 'change' before we move on?");
        }

        System.out.println("Thank you! Goodbye! :>");

        scnr.close();

    }
    
}
