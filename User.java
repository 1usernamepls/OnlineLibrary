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
            return true; // they are the same
        }
        if (!(o instanceof User)) { // if one object is not a User object
            return false; // they are not the same
        }
        User u = (User) o; // typecast
        return (this.email.equals(u.email) && 
        this.firstName.equals(u.firstName) &&
        this.lastName.equals(u.lastName));
        // two User accounts are the same person when they share the same email and name
        // in reality, people can have multiple accounts on a website, but with different usernames and passwords
    }

}
