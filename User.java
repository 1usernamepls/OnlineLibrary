import java.util.Scanner;

public abstract class User { // a public abstract class for BookShop User accounts
    
    protected String email;
    protected String username;
    protected String password;
    protected String firstName;
    protected String lastName;
    // protected variables for all parts of a regular online account
    // email, username, password, firstName, lastName, respectively, are all Strings because they contain letters
    // and a variety of other characters

    public User(String e, String u, String p, String f, String l) {
        // an overloaded constructor that takes in the person's information and assigns it to the proper member attributes
        // this creates a "User's" account to handle our website
        email = e;
        username = u;
        password = p;
        firstName = f;
        lastName = l;
    }

    // ACCESSORS

    public String getEmail() {
        // accessor for email
        // used in User "check" methods
        return email;
    }

    public String getUsername() {
        // accessor for username
        // used in User "check" methods
        return username;
    }


    public String getPassword() {
        // accessor for password
        // used in User "check" methods
        return password;
    }

    public String getName() {
        // accessor for name
        // used in User "check" methods
        return lastName + ", " + firstName;
        // firstName and lastName are combined because it isn't natural for a person to only want their first OR their last name
    }

    // MUTATORS
    // all except name, a person should NOT be able to change their real name (prevents catfishing)

    public void setEmail(String e) {
        // mutator for email
        // used in User "change" methods
        // a User is allowed to change their email in their account
        email = e;
    }

    public void setUsername(String u) {
        // mutator for username
        // used in User "change" methods
        // a User is allowed to change their username in their account
        username = u;
    }

    public void setPassword(String p) {
        // mutator for password
        // used in User "change" methods
        // a User is allowed to change their password in their account
        password = p;
    }

    public void userNameGuidelines() {
        System.out.println("Please create a username that follows these guidelines: "); 
        System.out.println("\t 1) Has at least 5 characters");
        System.out.println("\t 2) Starts with a letter");
        System.out.println("\t 3) Is less than 16 characters");
    }

    public void passWordGuidelines() {
        System.out.println("Make sure your password follows these rules: ");
        System.out.println("\t 1) Has at least 8 characters");
        System.out.println("\t 2) Starts with a lettter");
        System.out.println("\t 3) Has at least one number");
        System.out.println("\t 4) Is less than 13 characters");
    }

    public void accountDetails() {
        System.out.println("\t1) Email");
        System.out.println("\t2) Username");
        System.out.println("\t3) Password");
    }

    public void checkAccount(Scanner s) { // Accept Scanner as a parameter
        System.out.println("What part of your account would you like to check?");
        accountDetails();
        System.out.println("\t4) Name");
        System.out.print("Type the number of the option you'd like to see: ");
        if (s.hasNextInt()) {
            int option = s.nextInt();
            s.nextLine(); // Consume the leftover newline
            switch (option) {
                case 1:
                    System.out.println("Your Email Is: " + email);
                    break;
                case 2:
                    System.out.println("Your Username Is: " + username);
                    break;
                case 3:
                    System.out.println("Your Password Is: " + password);
                    break;
                case 4:
                    System.out.println("Your Name Is: " + lastName + ", " + firstName);
                    break;
                default:
                    System.out.println("Invalid Input :(");
            }
        } else {
            System.out.println("Invalid input. Please enter a valid number.");
            s.nextLine(); // Consume the invalid input
        }
    }

    public void changeAccount(Scanner s) { // Accept Scanner as a parameter
        System.out.println("What part of your account would you like to change?");
        accountDetails();
        System.out.print("Type the number of the option you'd like to change: ");
        if (s.hasNextInt()) {
            int option = s.nextInt();
            s.nextLine(); // Consume the leftover newline

            switch (option) {
                case 1:
                    String e = "";
                    while (!e.contains("@") || !e.contains(".") || !Character.isLetter(e.charAt(0))) {
                        System.out.println("What will your new email be? : ");
                        e = s.nextLine();
                        if (!e.contains("@") || !e.contains(".") || !Character.isLetter(e.charAt(0))) {
                            System.out.println("Invalid email format. Please try again.");
                        }
                    }
                    setEmail(e);
                    System.out.println("Change made successfully!");
                    break;
                case 2:
                    userNameGuidelines();
                    String user = "";
                    while (user.length() < 5 || user.length() > 15 || !Character.isLetter(user.charAt(0))) {
                        System.out.println("Type your new username here: ");
                        user = s.nextLine();
                        if (user.length() < 5 || user.length() > 15 || !Character.isLetter(user.charAt(0))) {
                            System.out.println("Invalid username. Please follow the guidelines.");
                        }
                    } 
                    setUsername(user); 
                    System.out.println("Change made successfully!");              
                    break;
                case 3:
                    passWordGuidelines();
                    String p = "";
                    while (p.length() < 8 || p.length() > 12 || !p.matches(".*\\d.*") || !Character.isLetter(p.charAt(0))) {
                        System.out.println("Type your new password here: ");
                        p = s.nextLine();
                        if (p.length() < 8 || p.length() > 12 || !p.matches(".*\\d.*") || !Character.isLetter(p.charAt(0))) {
                            System.out.println("Invalid password. Please follow the guidelines.");
                        }
                    }
                    setPassword(p);
                    System.out.println("Change made successfully!");             
                    break;
                default:
                    System.out.println("Invalid Input :(");
            }
            // Optionally, display updated account details
            System.out.println("Updated Account Details:");
            System.out.println(this.toString());
        } else {
            System.out.println("Invalid input. Please enter a valid number.");
            s.nextLine(); // Consume the invalid input
        }
    }

    @Override // for child classes Customer and Administrator
    public String toString() { // toString() prints details shared by all Users
        String s = "";
        s += "  Email: " + email + "\n";
        s += "  Username: " + username + "\n";
        s += "  Password: " + password + "\n";
        s += "  Name: " + lastName + ", " + firstName + "\n";
        return s; // returns a single String s outputted in the terminal
    }

    @Override // for child classes Customer and Administrator
    public boolean equals(Object o) { // compares User objects and returns if they are equal or not
        if (this == o) { // if both objects have the same memory address
            return true; // they are equal
        }
        if (!(o instanceof User)) { // if one object is not a User object
            return false; // they are not equal
        }
        User u = (User) o; // typecast
        return (this.email.equals(u.email) && 
        this.firstName.equals(u.firstName) &&
        this.lastName.equals(u.lastName));
        // two User accounts are the same person when they share the same email and name
        // in reality, people can have multiple accounts on a website, but with different usernames and passwords
    }

}
