public class Nonfiction extends Book {
    
    protected String genre; // "History," "Science," "Biography," etc.

    public Nonfiction(String t, String auth, String l, int pub, double p, boolean a, int s, String c, String genre) {
        super(t, auth, l, pub, p, a, s, c); 
        this.genre = genre; 
    }

    public String getGenre() {
        return genre;
    }
  
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String toString() {
        return super.toString() + "      Genre: " + genre + "\n";
    }

}
