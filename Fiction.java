public class Fiction extends Book {

    protected boolean bestseller;

    public Fiction(String t, String auth, String l, int pub, double p, boolean a, int s, String g, boolean b) {
        super(t, auth, l, pub, p, a, s, g);
        this.bestseller = b;
    }

    public boolean isBestseller() {
        return bestseller;
    }

    public void setBestseller(boolean bestseller) {
        this.bestseller = bestseller;
    }

    public String toString() {
        return super.toString() + "      Bestseller: " + (bestseller ? "Yes" : "No") + "\n";
    }
}
