public class BookShop {

    public static void main(String[] args) {

        String email = "gmop@chapman.edu";
        String username = "THE14u";
        String password = "hello123!";
        String firstName = "Paul";
        String lastName = "Sanderson";

        User a = new User(email, username, password, firstName, lastName);
        System.out.println(a);

        String title = "Harry Potter And The Sourcerer's Stone";
        String author = "J.K. Rowling";
        String language = "English";
        int publishing = 1997;
        double price = 6.99;
        boolean availability = true;
        int stock = 5;
        String category = "FANTASY";
        boolean bestseller = true;   
        
        Fiction b = new Fiction(title, author, language, publishing, price, availability, stock, category, bestseller);
        System.out.println(b);

    }
    
}
