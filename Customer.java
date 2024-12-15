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

    //method to add a Book object from the store's default book catalog based on user input
    //utilized in the Customer implementation in the BookShop class
    public void addCart(LinkedList<Book> ll) {
        Scanner s = new Scanner(System.in);
        System.out.println("What book would you like to add?");
        System.out.print("Enter the number of the book you want here: ");
        int bookNum = s.nextInt();
        bookNum -= 1; //subtracts 1 to get the correct index number of the Book object in the list
        addToCart(ll.get(bookNum));
        s.close();
    }

    //method to remove a Book object from the store's default book catalog based on user input
    //utilized in the Customer implementation in the BookShop class
    public void removeCart(LinkedList<Book> ll) {
        Scanner s = new Scanner(System.in);
        System.out.println("Ok. Type the number of the book you'd like to remove here: ");
        int removedBook = s.nextInt();
        removedBook -= 1;
        removeFromCart(ll.get(removedBook));
        s.close();
    }

    public void firstAdd(LinkedList<Book> ll, Scanner scnr) {
        System.out.println("Let's add to your cart!"); 
        String add = "add";
        while (add.equalsIgnoreCase("add")) { // while a customer wants to add books
            addCart(ll); // call a customer's addCart() method to add a book to their cart
            System.out.println();
            System.out.println("Book added!"); // confirms the book was added
            System.out.println("Any other books you'd like to add?");
            System.out.print("Type 'add' if yes, anything else if no: "); // asks if the customer still wants to add books 
            add = scnr.nextLine().trim();
        }                        
    }

    //method for Customer interaction with BookShop interface
    //utilized in the Customer implementation in the BookShop class
    public void moreOptions(LinkedList<Book> ll) {
        Scanner s = new Scanner (System.in);
        System.out.println("Now that your cart has books, there are several options you can choose from...");
        System.out.println("\t1) Adding Books");
        System.out.println("\t2) Removing Books");
        System.out.println("\t3) Clearing Your Cart");
        System.out.println("What would you like to do?");
        System.out.print("Type in your number option here: ");
        int option = s.nextInt();
        s.nextLine(); //consumes newline character generated by user
        switch (option) {
            case 1: 
                firstAdd(ll, s);
                break;
            case 2:
                System.out.println("Let's remove books from your cart!"); 
                String remove = "remove";
                while (remove.equals("remove") && cart.size() > 0) {
                    removeCart(ll); //calls the removeCart() method with the default catalog of Book objects in the store
                    System.out.println();
                    System.out.println("Other books you'd like to remove?");
                    System.out.println("Type 'remove' if yes, anything else if no: ");
                    remove = s.nextLine();
                }
                break;
            case 3:
                System.out.println("Let's clear your cart!");
                clearCart(); //calls the clearCart() method 
                break;
            default:
                System.out.println("Invalid Input :(");
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
