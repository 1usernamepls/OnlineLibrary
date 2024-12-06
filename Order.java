import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.Random;

public class Order {
    private int orderID;
    private double total;
    private String status; 
    private LocalDate date;
    private Customer customer;
    private LinkedList<Book> items;

    private static LinkedList<Order> completedOrders = new LinkedList<>(); 
    private static LinkedList<Order> allOrders = new LinkedList<>();

    public Order(Customer c){
        customer = c; //get an existing customer on the website for the order
        total = 0.0;
        status = "Pending";
        date = LocalDate.now();

        Random rand = new Random();
        orderID = rand.nextInt(900000) + 10000; //generates a random 5-digit id
   
        items = new LinkedList<>();
        allOrders.add(this);
    }

    //copy constructor
    public Order(Order o){
        this.customer = o.customer;
        this.total = o.total;
        this.status = o.status;
        this.date = o.date;
        this.orderID = o.orderID;

        items = new LinkedList<>();
        for (Book book : o.items){
            this.items.add(book);
        }

        allOrders.add(this);
    }

    public Order() {
    }

    public void addToOrder(Book book){
        if (book == null){
            System.out.println("Sorry that book in not available at the shop and cannot be added to the order");
            return;
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

    public void removeBook(Book book){
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

    public String updatedStatus(int daysOutFromOrder){
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
            finishedOrder();
        }
        return status;
    }

    public double calculateTotal(){
        total = 0.0;
        for (Book book : items){
            total += book.getPrice();
        }
        return total;
    }

    public void finishedOrder() {
        if (this.status.equals("Delivered")){
            if (!(completedOrders.contains(this))) {
                completedOrders.add(this);
            }
        }
    }
    
    public static void viewOrderHistory() {
        for (Order order : completedOrders) {
            System.out.println(order);
        }
    }

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

    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (this == null){
            return false;
        }
        if (!(o instanceof Order)){
            return false;
        }
        Order order = (Order) o;
        return this.orderID == order.orderID && this.customer.equals(order.customer) && this.total == order.total;
    }

    //accessors 
    public int getOrderID(){
        return orderID;
    }

    public Customer getCustomer(){
        return customer;
    }

    public LinkedList<Book> getOrderItems(){
        return items;
    }

    public double getOrderTotal(){
        return total;
    }

    public String getOrderStatus(){
        return status;
    }

    public LocalDate getOrderDate(){
        return date;
    }

    public static LinkedList<Order> getAllOrders() {
        return allOrders;
    }

    public static LinkedList<Order> getFinishedOrders(){
        return completedOrders;
    }

    //mutators
    public void setOrderID(int i){
        if (i < 100000 && i > 9999){
            orderID = i;
        }
    }

    public void setOrderTotal(double t){
        total = t;
    }

    public void setOrderStatus(String s){
        status = s;
    }

    public void setCustomer(Customer c){
        customer = c;
    }

    public void setOrderItems(LinkedList<Book> b){
        items = b;
    }
}
