public class Fiction extends Book {

    private boolean bestseller;

    public Fiction(String title, double price, boolean availability, boolean bestseller) {
        super(title, price, availability, "Fiction");
        this.bestseller = bestseller;
    }

    public boolean isBestseller() {
        return bestseller;
    }

    public void setBestseller(boolean bestseller) {
        this.bestseller = bestseller;
    }

    @Override
    public String toString() {
        return super.toString() + "      Bestseller: " + (bestseller ? "Yes" : "No") + "\n";
    }
}
