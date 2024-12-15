import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Random;

//Order class represents an order placed by a customer on the website

public class Order {
    private int orderID; // member variable that represents a unique identifier for the order
    private double total; // member variable that represents the total cost of the ordder
    private String status; // member variable that represents the current status of the order (e.g., "Pending", "Shipped", "Delivered")
    private LocalDate date; // member variable that represents the date the order was placed.
    private Customer customer; // member variable that represents the customer who placed the order
    private ArrayList<Book> items; // member variable that represents the list  of books in the order.

    // Constructor: 
    // This constructor initializes a new Order for the given customer.
    // Sets the order status to "Pending", generates a random order ID,
    // and initializes the items list.

    public Order(Customer c){
        customer = c; //get an existing customer on the website for the order
        total = 0.0;
        status = "Pending";
        date = LocalDate.now();

        Random rand = new Random();
        orderID = rand.nextInt(900000) + 10000; //generates a random 5-digit id
   
        items = new ArrayList<>();
    }

    //copy constructor: 
    // this copy constructor creates a new order that is a copy of the given order.
    public Order(Order o){
        this.customer = o.customer;
        this.total = o.total;
        this.status = o.status;
        this.date = o.date;
        this.orderID = o.orderID;

        items = new ArrayList<>();
        for (Book book : o.items){
            this.items.add(book);
        }
    }

    //addToOrder method:
    // this method adds a book to the order if its in stock.
    // and updated the order total and decreases the book's stock.
    public void addToOrder(Book book){
        if (book == null){
            throw new IllegalArgumentException("Invalid book: Sorry that book is not available at the shop and cannot be added to the order");
        }
        if (book.getStock() > 0){
            items.add(book);
            total += book.getPrice();
            book.setStock(book.getStock() - 1); //decrease stock total 
        }
        else {
            System.out.println("Sorry " + book.getTitle() + " is currently out of stock");
        }
    }

    // removeBookFromOrder method:
    // this is a method that is built to remove a book from the order if it exists.
    // the method also updates the order total and increases the book's stock.
    public void removeBookFromOrder(Book book){
        if (book == null){
            System.out.println("Sorry that book in not available at the shop and cannot be removed from order");
            return;
        }
        if (items.size() < 1){
            System.out.println("Cannot remove " + book.getTitle() + " as the order is empty");
        }
        else if (items.contains(book)){
            items.remove(book); //removes first occurance of the book
            total -= book.getPrice();
            book.setStock(book.getStock() + 1);
        }
        else {
            System.out.print(book.getTitle() + " not found in order");
        }
    }

    // updatedStatus method:
    // this is a method that has been designed to update the order status based on the number
    // of days since it the order was placed. 
    // this method also returns the updated status.
    public String updatedStatus(){
        LocalDate current = LocalDate.now();
        long daysElapsed = ChronoUnit.DAYS.between(date, current); 

        if (daysElapsed < 6){ //takes 5 days to ship
            status = "Pending";
        }
        else if (daysElapsed < 15){ //max of 2 weeks for delivery 
            status = "Shipped";
        }
        else {
            status = "Delivered";
        }
        return status;
    }

    // calculateTotal method:
    // a method that calculates the total cost of the order by summing the prices of all the 
    // books in the order.
    public double calculateTotal(){
        total = 0.0;
        for (Book book : items){
            total += book.getPrice();
        }
        return total;
    }

    // toString method:
    // this is a toString method that returns a string representation of the order, including 
    // the customer details, order ID, order date, books in the order, order total, and order status
    // as well as the total cost of the order.
    public String toString(){
        String s = "";
        s += "ORDER DETAILS \n";
        s += "-------------------- \n";
        s += "Customer: " + customer.getName() + " (" + customer.getEmail() +") \n";
        s += "Order ID: " + orderID + "\n";
        s += "Order Placed on: " + date + "\n";
        s += "\n";
        s += "Books in the Order: \n";
        for (Book book : items) {
            s += book.toString() + "\n";
        }
        s += "\n";
        s += "Order Total: " + total + "\n";
        s += "Order Status: " + status + "\n";

        return s;
    }

    // equals method:
    // this is a method that checks if two orders are equal based on theri order ID, customer,
    // and total cost.
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (!(o instanceof Order)){
            return false;
        }
        Order order = (Order) o;
        return this.orderID == order.orderID && 
        this.customer.equals(order.customer) && 
        this.total == order.total;
    }

    //The following are Accessors:

    // an accessor for member variable order ID.
    public int getOrderID(){
        return orderID;
    }

    // an accessor for customer.
    public Customer getCustomer(){
        return customer;
    }

    // an accessor for order items.
    public ArrayList<Book> getOrderItems(){
        return items;
    }

    // an accessor for order total.
    public double getOrderTotal(){
        return total;
    }

    // an accessor for order status.
    public String getOrderStatus(){
        return status;
    }

    // an accessor for order date.
    public LocalDate getOrderDate(){
        return date;
    }

    // The following are Mutators:

    // Mutator for order ID. Which validates that the ID is a 5-digit number.
    public void setOrderID(int i){
        if (i < 100000 && i > 9999){
            orderID = i;
        }
    }

    // Mutator for order total.
    public void setOrderTotal(double t){
        total = t;
    }

    // Mutator for order status.
    public void setOrderStatus(String s){
        status = s;
    }

    // Mutator for customer.
    public void setCustomer(Customer c){
        customer = c;
    }

    // Mutator for order items.
    public void setOrderItems(ArrayList<Book> b){
        items = b;
    }
}