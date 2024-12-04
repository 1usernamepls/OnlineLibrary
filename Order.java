import java.util.LinkedList;
import java.util.Random;

public class Order{
    private int orderID;
    private double total;
    private String status; 
    private Customer customer;
    private LinkedList<Book> items;

    public Order(Customer c){
        customer = c; //get an existing customer on the website for the order
        total = 0.0;
        status = "Pending";

        Random rand = new Random();
        orderID = rand.nextInt(90000) + 100000; //generates a random 5-digit id

        items = new LinkedList<>();
    }

    public void addToOrder(Book book){
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
        if (items.isEmpty()){
            System.out.println("Cannot remove " + book.getTitle() + " as the order is empty");
        }
        else if (items.contains(book)){
            items.remove(book); //NEED TO ACCOUNT FOR BOOK DUPLICATES IN ORDERS
            total -= book.getPrice();
            book.setStock(book.getStock() + 1);
        }
        else {
            System.out.print(book.getTitle() + " not found in order");
        }
    }

    public String updatedStatus(int daysOutFromOrder){
        if (daysOutFromOrder < 6){ //takes 5 days to ship
            status = "Pending";
        }
        else if (daysOutFromOrder < 15){ //max of 2 weeks for delivery 
            status = "Shipped";
        }
        else {
            status = "Delivered";
        }

        return status;
    }

    public String toString(){
        String s = "";
        s += "ORDER DETAILS \n";
        s += "-------------------- \n";
        s += "Customer: " + customer.getName() + " (" + customer.getEmail() +") \n";
        s += "Order ID: " + orderID + "\n";
        s += "\n";
        s += "Books in the Order: \n";
        for (Book book : items) {
            s += book.toString() + "\n";
        }
        s += "Order Total: " + total + "\n";
        s += "Order Status: " + status + "\n";

        return s;
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
