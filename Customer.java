import java.util.LinkedList;
import java.util.Scanner;

public class Customer extends User {
    protected LinkedList<Book> cart; //member variable to hold the Book objects in a shopping cart
    protected LinkedList<Order> orders; //member variable to hold all the Order objects associated with the Customer

    //overloaded constructor to create a Customer object with all relevant User information  
    //also initializes the cart and orders member variables, unique to a Customer object
    public Customer(String e, String u, String p, String f, String l){
        super(e, u, p, f, l);
        cart = new LinkedList<>();
        orders = new LinkedList<>();
    }

    //method to add a specific Book object a Customer's cart variable 
    public void addToCart(Book book){
        if (book.getStock() > 0){ //utilizes the getStock() method from the Book class to check the store's stock
            cart.add(book); //if there are available copies of the book, it gets added to the cart
            System.out.println(book.getTitle() + " has been added to your cart!");
        }
        else {
            System.out.println("Sorry, " + book.getTitle() + " is not available to add to cart");
        }
    }

    //method to remove a specific Book object from a Customer's cart
    public void removeFromCart(Book book){
        if (cart.contains(book)){ //checks if the cart has the Book object to be removed 
            cart.remove(book); //if the Book object is in the cart, it gets removed from cart
            System.out.println(book.getTitle() + " has been removed from your cart");
        }
        else { 
            System.out.println(book.getTitle() + " was not in your cart so it was not removed");
        }
    }

    //method to clear the Book objects from the cart variable 
    public void clearCart(){
        cart.clear(); //removes all Book objects from the Customer's cart
        System.out.println("Your cart has been emptied"); 
    }

    //method to make an order 
    public void placeOrder(){
        if (cart.size() < 0){ //checks if there are any Book objects in the Customer's cart
            System.out.println("Your cart is currently empty. Please add books to your cart before placing an order");
            return; //leaves method if nothing is found in the Customer's cart
        }

        Order orderPlaced = new Order(this); //will initialize an Order object with the current customer 
        for (Book book : cart){
            orderPlaced.addToOrder(book); //calls the addToOrder method from the Order class 
        }

        orders.add(orderPlaced); //add Order object to the Customer's order variable
        System.out.println("Order successfully placed! Your order ID is " + orderPlaced.getOrderID());

        clearCart(); //clear the Customer's cart once an Order obejct is made for the Customer
    }

    //accessors
    public LinkedList<Book> getCart(){
        return cart; 
    }

    public LinkedList<Order> getOrders(){
        return orders;
    }

    /* no mutator methods because....
     * 1. addToCart() and removeFromCart() methods already exist to change the Book objects in the cart variable
     * 2. placeOrder() method already adds Order objects to the orders variable and the cart should have objects
     *    in it before an order gets placed, so simply taking in an Order object to add to the orders variable 
     *    would not be the correct order of operations 
     */


    public void firstAdd(LinkedList<Book> ll) { // a method for customers to continue adding books to their cart
        // parameter is the books full list
        Scanner s = new Scanner(System.in); // scanner is created
        String addBook = "add"; // default variable value
        while (addBook.equalsIgnoreCase("add")) {
            System.out.println("Agreed :> What books would you like to add to your cart?");
            System.out.print("Type the number of the book you want here: "); // input for book position
            if (s.hasNextInt()) {
                int bNum = s.nextInt();
                s.nextLine(); // Consume the leftover newline
                bNum -= 1; // book position
                if(bNum >= 0 && bNum < ll.size()){ // if book position is valid
                    addToCart(ll.get(bNum)); // add the book to the cart
                }
                else{
                    System.out.println("Invalid book number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                s.nextLine(); // Consume the invalid input
                continue;
            }
            System.out.println();
            System.out.println("Here's what your cart looks like so far...");
            System.out.println();
            System.out.println(cart); // print out the updated cart
            System.out.println();
            System.out.println("Would you like to add another book or purchase?");
            System.out.print("Type 'add' or 'purchase' here : "); // asks the user if they still want to continue
            addBook = s.nextLine();
        }
        s.close();
    }

    public void firstRemove(LinkedList<Book> ll) { // a method for customers to continue removing books from their cart
        Scanner s = new Scanner(System.in);
        System.out.print("Any thoughts about removing books before purchase? (yes/no) : "); // asks the user if they want to remove books 
        String removeBook = s.nextLine();
        while (removeBook.equalsIgnoreCase("yes") && cart.size() > 0) {
            // while a user wants to remove books and their cart size is greater than 0
            System.out.println("Any books you would you like to remove from your order?");
            int item = 0; // line numbering
            for (Book b : ll) { // for each book in the cart
                System.out.println();
                System.out.println(++item); // list the item number and then the item in the customer's cart
                System.out.println();
                System.out.println(b); // print each book
                System.out.println();
            }
            System.out.print("Type the number of the book you'd like to remove here (type 0 if no books): "); // reads book position
            if (s.hasNextInt()) {
                int itemNum = s.nextInt();
                s.nextLine(); // Consume the leftover newline
                itemNum -= 1; // book position calculation
                if(itemNum >= 0 && itemNum < cart.size()){ // if the position is valid
                    removeFromCart(cart.get(itemNum)); // remove the book
                    System.out.println("Below is a simulated order of the books you'd like to pay for now...");
                    System.out.println();
                    System.out.println(cart); // prints the updated cart
                    System.out.println();
                }
                else{ // otherwise print invalid number
                    System.out.println("Invalid book number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                s.nextLine(); // Consume the invalid input
                continue;
            }
            System.out.print("Would you like to remove another book? (yes/no) : ");
            removeBook = s.nextLine();
        }
        s.close();
    }

    public void clearMyCart() { // method for asking the customer to clear their cart
        Scanner s = new Scanner (System.in);
        String clear;
        System.out.println("Would you like to clear your cart before purchase?");
        System.out.print("Type 'clear' or 'purchase' here : "); // asks the user if they still want to continue
        clear = s.nextLine();
        if (clear.equalsIgnoreCase("clear") && cart.size() > 0) { // if a customer wants to clear their cart and size is positive
            clearCart(); // clear their cart
        }
        s.close();
    }

    //toString method to display a Customer's cart and order history
    @Override
    public String toString() {
        String s = "";
        s += "\n";
        s += "CUSTOMER ACCOUNT DETAILS \n";
        s += "------------------------\n";
        s += super.toString();
        s += "\n";
        s += "Cart Items: \n";
        if (!(cart.isEmpty()) && cart != null){ //carts with Book objects that are not null values will be displayed
            for (Book book : cart){
                s += "- " + book.toString() + "\n";
            }
        }
        else {
            s += "Cart is currently empty \n";
        }
        s += "Order History: \n";
        if (!(orders.isEmpty())){ //if orders variable has Order objects, it will be displayed
            for (Order o : orders){
                s += o.toString() + "\n";
            }
        }
        else {
            s += "No orders placed\n";
        }
        s += "------------------------\n";

        return s;
    }

    //equals method to determine if 2 Customer objects are equal
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Customer)) {
            return false;
        }
        Customer c = (Customer) o;
        return this.cart.equals(c.cart) &&
        this.orders.equals(c.orders); //Customer objects that have the same cart and order history are equal
    }
}
