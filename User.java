public class User {
    
    private String email;
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public User(String e, String u, String p, String f, String l) {
        email = e;
        username = u;
        password = p;
        firstName = f;
        lastName = l;
    }

    public User(User u) {
        email = u.email;
        username = u.username;
        password = u.password;
        firstName = u.firstName;
        lastName = u.lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return lastName + ", " + firstName;
    }

    @Override
    public String toString() {
        String s = "";
        s += "USER ACCOUNT DETAILS" + "\n";
        s += "--------------------" + "\n";
        s += "  Email: " + email + "\n";
        s += "  Username: " + username + "\n";
        s += "  Password: " + password + "\n";
        s += "  Name: " + lastName + ", " + firstName + "\n";
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User u = (User) o;
        return (this.email.equals(u.email));
    }

}
