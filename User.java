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

}
