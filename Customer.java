import java.util.LinkedList;

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
            System.out.println(book.getTitle() + " has been added to your cart");
        }
        else {
            System.out.println("Sorry, " + book.getTitle() + " is not available to add to cart");
        }
    }

    public void removeFromCart(Book book){
        if (cart.contains(book)){
            cart.remove(book);
            System.out.println(book.getTitle() + " has been removed from your cart");
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

    @Override
    public String toString() {
        String s = "";
        s += "\n";
        s += "CUSTOMER ACCOUNT DETAILS \n";
        s += "-----------------------------\n";
        s += super.toString();
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
            s += "No orders placed";
        }

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
