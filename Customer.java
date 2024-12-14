import java.util.LinkedList;
import java.util.Scanner;

public class Customer extends User {
    protected LinkedList<Book> cart;
    protected LinkedList<Order> orders;

    public Customer(String e, String u, String p, String f, String l){
        super(e, u, p, f, l);
        cart = new LinkedList<>();
        orders = new LinkedList<>();
    }

    public void addToCart(Book book){
        if (book.getStock() > 0){
            cart.add(book);
            System.out.println(book.getTitle() + " has been added to your cart!");
            book.setStock(book.getStock() - 1);
        }
        else {
            System.out.println("Sorry, " + book.getTitle() + " is not available to add to cart");
        }
    }

    public void removeFromCart(Book book){
        if (cart.contains(book)){
            cart.remove(book);
            System.out.println(book.getTitle() + " has been removed from your cart");
            book.setStock(book.getStock() + 1);
        }
        else {
            System.out.println(book.getTitle() + " was not in your cart so it was not removed");
        }
    }

    public void placeOrder(){
        if (cart.size() < 0){
            System.out.println("Your cart is currently empty. Please add books to your cart before placing an order");
            return;
        }

        Order orderPlaced = new Order(this); //will initialize an Order object with the current customer 

        for (Book book : cart){
            orderPlaced.addToOrder(book); //calls the addToOrder method from the Order class 
        }

        orders.add(orderPlaced);
        System.out.println("Order successfully placed! Your order ID is " + orderPlaced.getOrderID());

        cart.clear(); 
    }

    public void clearCart(){
        cart.clear();
        System.out.println("Your cart has been emptied");
    }

    //accessors
    public LinkedList<Book> getCart(){
        return cart;
    }

    public LinkedList<Order> getOrders(){
        return orders;
    }

    public void addCart(LinkedList<Book> ll) {
        Scanner s = new Scanner(System.in);
        System.out.println("What book would you like to add?");
        System.out.print("Enter the number of the book you want here: ");
        int bookNum = s.nextInt();
        bookNum -= 1;
        addToCart(ll.get(bookNum));
        s.close();
    }

    public void removeCart(LinkedList<Book> ll) {
        Scanner s = new Scanner(System.in);
        System.out.println("Ok. Type the number of the book you'd like to remove here: ");
        int removedBook = s.nextInt();
        removedBook -= 1;
        removeFromCart(ll.get(removedBook));
        s.close();
    }

    public void moreOptions(LinkedList<Book> ll) {
        Scanner s = new Scanner (System.in);
        System.out.println("Now that your cart has books, there are several options you can choose from...");
        System.out.println("\t1) Adding Books");
        System.out.println("\t2) Removing Books");
        System.out.println("\t3) Clearing Your Cart");
        System.out.println("What would you like to do?");
        System.out.print("Type in your number option here: ");
        int option = s.nextInt();
        switch (option) {
            case 1:
                System.out.println("Let's add to your cart!");
                String add = "add";
                while (add.equals("add")) {
                    addCart(ll);
                    System.out.println();
                    System.out.println("Book added!");
                    System.out.println("Any other books you'd like to add?");
                    System.out.print("Type 'add' if yes, anything else if no: ");
                    add = s.nextLine();    
                }
                break;
            case 2:
                System.out.println("Let's remove books from your cart!");
                String remove = "remove";
                while (remove.equals("remove") && cart.size() > 0) {
                    removeCart(cart);
                    System.out.println();
                    System.out.println("Book removed!");
                    System.out.println("Other books you'd like to remove?");
                    System.out.println("Type 'remove' if yes, anything else if no: ");
                    remove = s.nextLine();
                }
                break;
            case 3:
                System.out.println("Let's clear your cart!");
                clearCart();
                break;
            default:
                System.out.println("Invalid Input :(");
        }
        s.close();   
    }


    @Override
    public String toString() {
        String s = "";
        s += "\n";
        s += "CUSTOMER ACCOUNT DETAILS \n";
        s += "------------------------\n";
        s += super.toString();
        s += "\n";
        s += "Cart Items: \n";
        if (!(cart.isEmpty()) && cart != null){
            for (Book book : cart){
                s += "- " + book.toString() + "\n";
            }
        }
        else {
            s += "Cart is currently empty \n";
        }
        s += "Order History: \n";
        if (!(orders.isEmpty())){
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
        this.orders.equals(c.orders);
    }
}
