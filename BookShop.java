import java.util.Scanner;

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
        while (firstName == null || firstName.matches(".*\\d.*") || Character.isLetter(firstName.charAt(0)) == false) {
            System.out.println("That is not a name! Please try again...");
            System.out.println("Now what is your first name? : ");
            firstName = scnr.nextLine();
        }

        System.out.println("Last name? : ");
        String lastName = scnr.nextLine();
        while (lastName == null || lastName.matches(".*\\d.*") || Character.isLetter(lastName.charAt(0)) == false) {
            System.out.println("That is not a name! Please try again...");
            System.out.println("Last name? : ");
            lastName = scnr.nextLine();
        }

        System.out.println("Nice! Moving on, what username would you like to have with us?");
        userNameGuidelines();
        System.out.println("Type your username here: ");
        String username = scnr.nextLine();
        while (username == null || Character.isLetter(username.charAt(0)) == false || username.length() < 5 || username.length() > 15) {
            System.out.println("That is not a valid username!");
            userNameGuidelines();
            System.out.println("Type your username here: ");
            username = scnr.nextLine();
        }

        System.out.println("Now let's type in a password!");
        passWordGuidelines();
        System.out.println("Type your password here: ");
        String password = scnr.nextLine();
        while (password == null || Character.isLetter(password.charAt(0)) == false || password.length() < 8 || password.length() > 12 || password.matches(".*\\d.*") == false) {
            System.out.println("That is not a valid password!");
            passWordGuidelines();
            System.out.println("Type your password here: ");
            password = scnr.nextLine();
        }

        System.out.println("Finally, most important, do you identify as a customer or an administrator? : ");
        String user = scnr.nextLine();
        while (user.equals("customer") == false && user.equals("administrator") == false) {
            System.out.println("That is not a valid user type!");
            System.out.println("Try again.");
            System.out.println("do you identify as a customer or an administrator? : ");
            user = scnr.nextLine();
        }

        if (user.equals("customer")) {
            Customer a = new Customer(email, username, password, firstName, lastName);
            System.out.println(a);
        }

        System.out.println("Congrats! Your account has been successfully created. Now it's time to begin shopping!");

        String title = "Harry Potter And The Sourcerer's Stone";
        String author = "J.K. Rowling";
        String language = "English";
        int publishing = 1997;
        double price = 6.99;
        boolean availability = true;
        int stock = 5;
        String genre = "FANTASY";
        boolean bestseller = true; 
        String ageGroup = "8+";  
        
        Fiction b = new Fiction(title, author, language, publishing, price, availability, stock, genre, bestseller, ageGroup);
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
        boolean peerReviewed = false;
        String topic = "DISABILITY";

        Nonfiction c = new Nonfiction(title2, author2, language2, publishing2, price2, availability2, stock2, genre2, edition, peerReviewed, topic);
        System.out.println(c);

        scnr.close();

    }
    
}
