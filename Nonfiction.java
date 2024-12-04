public class Nonfiction extends Book {

    
    private String genre; // "History," "Science," "Biography," etc.


    public Nonfiction(String t, String auth, String l, int pub, double p, boolean a, int s, String genre) {
        super(t, auth, l, pub, p, a, s, "Nonfiction"); 
        this.genre = genre; 
    }


    public String getGenre() {
        return genre;
    }

    
    public void setGenre(String genre) {
        this.genre = genre;
    }

  
    @Override
    public String toString() {
        return super.toString() + "      Genre: " + genre + "\n";
    }

}
