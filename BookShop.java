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
                while (user.length() < 5 || user.length() > 15) {
                    System.out.println("Type your new username here: ");
                    user = s.nextLine();
                } 
                u.setUsername(user); 
                System.out.println("Change success!");              
                break;
            case 3:
                passWordGuidelines();
                String p = "p";
                while (p.length() < 8 || p.length() > 12 || p.matches(".*\\d.*") == false) {
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

    public static void defaultBooks() {
        LinkedList<Book> books = new LinkedList<>();
        Fiction f1 = new Fiction("Harry Potter And The Sourcerer's Stone", "J.K. Rowling", "English",
        1997, 6.99, true, 5, "FANTASY", true, "8+");
        books.add(f1);
        Fiction f2 = new Fiction("IT", "Stephen King", "English", 
        1986, 14.17, true, 3, "HORROR", true, "12+");
        books.add(f2);
        Fiction f3 = new Fiction("The Great Gatsby", "F. Scott Fitzgerald", "English",
        1925, 8.31, true, 7, "DRAMA", true, "14+");
        books.add(f3);
        Nonfiction nf1 = new Nonfiction("What We Carry", "Maya Shanbhag Lang", "English", 
        2020, 14.81, true, 8, "MEMOIR", 1, false, "DISABILITY");
        books.add(nf1);
        Nonfiction nf2 = new Nonfiction("Guiness World Records 2025", "GUINESS WORLD RECORDS", "English",
        2024, 13.98, true, 2, "ALMANAC", 1, false, "WORLD RECORDS");
        books.add(nf2);
        Nonfiction nf3 = new Nonfiction("USA National Parks: Lands of Wonder", "Dk Travel", "English",
        2024, 18.57, true, 3, "TRAVEL BOOKS", 2, true, "NATIONAL PARKS");
        books.add(nf3);
        Collections.sort(books);
        int line = 0;
        for (Book b : books) {
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
            for (Book b : books) {
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
            System.out.println();
            System.out.println("Let's continue!");
            System.out.println();
            System.out.println("Here's the list of books we have at the current moment!");
            System.out.println();
            defaultBooks();
            System.out.println("To see list in full, view the file we've deposited to your account on the side.");
        }
        if (user.equals("administrator")) {
            Administrator a = new Administrator(email, username, password, firstName, lastName);
            System.out.println(a);
            System.out.println("Congrats! Your account has been successfully created. Anything you'd like to 'check' or 'change' before we move on?");
        }

        scnr.close();

    }
    
}
