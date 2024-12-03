import java.util.Random;

public class Product {

    private String product_name;
    private int productID;
    private double price;
    private boolean availability;
    private String productType;

    public Product() {
        product_name = null;
        productID = 0;
        price = 0.0;
        availability = false;
        productType = null;  
    }

    public Product(String n, double p, boolean a, String t) {
        product_name = n;
        Random rand = new Random();
        int min = 10000;
        int max = 99999;
        productID = rand.nextInt(max-min+1) + min;
        price = p;
        availability = a;
        productType = t;
    }

    public Product(Product p) {
        product_name = p.product_name;
        Random rand = new Random();
        int min = 10000;
        int max = 99999;
        productID = rand.nextInt(max-min+1) + min;
        price = p.price;
        availability = p.availability;
        productType = p.productType;
    }

    public String getProductName() {
        return product_name;
    }

    public int getProductID() {
        return productID;
    }

    public double getPrice() {
        return price;
    }

    public boolean getAvailability() {
        return availability;
    }

    public String getProductType() {
        return productType;
    }

    @Override
    public String toString() {
        String s = "";
        s += "Product Name: " + product_name + "\n";
        s += "      ID: " + productID + "\n";
        s += "      Price: $" + price + "\n";
        s += "      Availability: " + availability + "\n";
        s += "      Product Type: " + productType + "\n";
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product)) {
            return false;
        }
        Product p = (Product) o;
        return (this.product_name.equals(p.product_name) 
        && this.productType.equals(p.productType));
    }

    // public int compareTo(Product p) {
    //     if (this.price == p.price) {
    //         return 0;
    //     }
    //     if (this.price > p.price) {
    //         return 1;
    //     }
    //     if (this.price < p.price) {
    //         return -1;
    //     }
    // }
    
}
