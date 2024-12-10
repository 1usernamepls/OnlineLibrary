public abstract class User {
    
    protected String email;
    protected String username;
    protected String password;
    protected String firstName;
    protected String lastName;

    public User(String e, String u, String p, String f, String l) {
        email = e;
        username = u;
        password = p;
        firstName = f;
        lastName = l;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String e) {
        email = e;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String u) {
        username = u;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String p) {
        password = p;
    }

    public String getName() {
        return lastName + ", " + firstName;
    }

    @Override
    public String toString() {
        String s = "";
        s += "\n";
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
        return (this.email.equals(u.email) && 
        this.firstName.equals(u.firstName) &&
        this.lastName.equals(u.lastName));
    }

}
