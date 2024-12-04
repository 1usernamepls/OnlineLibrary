public class Fiction extends Book {

    protected boolean bestseller;

    public Fiction(String title, String author, String language, int publishing, double price, boolean availability, String genre, boolean bestseller) {
        super(title, author, language, publishing, price, availability, "Fiction");
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
