//import java.util.Scanner;

public class BookShop {

    public static void main(String[] args) {

        // Scanner scnr = new Scanner(System.in);

        // System.out.println("Hello There First Time User! It's my pleasure to welcome you to our ONLINE BOOKSHOP!");
        // System.out.println("My name is Doti! I'm the system's bot who will help you on this exciting journey! :>");
        // System.out.println("First let's get you set up with an account...");

        // System.out.println("Some personal information we need to know: ");
        // System.out.println("What is your email? : ");
        // String email = scnr.nextLine();
        // System.out.println("Perfect!");
        // System.out.println("Now what is your first name? : ");
        // String firstName = scnr.nextLine();
        // System.out.println("Last name? : ");
        // String lastName = scnr.nextLine();
        // System.out.println("Nice! Moving on, what username would you like to have with us? : ");
        // String username = scnr.nextLine();
        // System.out.println("Finally most important, type in a password here: ");
        // String password = scnr.nextLine();

        // String email = "gmop@chapman.edu";
        // String username = "THE14u";
        // String password = "hello123!";
        // String firstName = "Paul";
        // String lastName = "Sanderson";

        // User a = new User(email, username, password, firstName, lastName);
        // System.out.println(a);

        String title = "Harry Potter And The Sourcerer's Stone";
        String author = "J.K. Rowling";
        String language = "English";
        int publishing = 1997;
        double price = 6.99;
        boolean availability = true;
        int stock = 5;
        String genre = "FANTASY";
        boolean bestseller = true;   
        
        Fiction b = new Fiction(title, author, language, publishing, price, availability, stock, genre, bestseller);
        System.out.println(b);

        String title2 = "What We Carry";
        String author2 = "Maya Shanbhag Lang";
        String language2 = "English";
        int publishing2 = 2020;
        double price2 = 14.81;
        boolean availability2 = true;
        int stock2 = 8;
        String genre2 = "MEMOIR";
        int edition = 1;

        Nonfiction c = new Nonfiction(title2, author2, language2, publishing2, price2, availability2, stock2, genre2, edition);
        System.out.println(c);

    }
    
}
