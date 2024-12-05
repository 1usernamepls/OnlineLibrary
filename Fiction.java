public class Fiction extends Book {

    protected String genre; 
    protected boolean bestseller; 

    public Fiction(String t, String auth, String l, int pub, double p, boolean a, int s, String genre, boolean bestseller) {
        super(t, auth, l, pub, p, a, s, "FICTION"); 
        this.genre = genre; 
        this.bestseller = bestseller; 
    }

 
    public boolean isBestseller() {
        return bestseller;
    }

    public void setBestseller(boolean bestseller) {
        this.bestseller = bestseller;
    }

   
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return super.toString() + "      Genre: " + genre + "\n      Bestseller: " + (bestseller ? "Yes" : "No") + "\n";
    }
}
