public class Nonfiction extends Book {

    protected String genre; // "history," "science," "biography," etc.
    protected int edition; // edition of the book
    protected boolean isPeerReviewed; // whether the book is peer-reviewed

    public Nonfiction(String t, String auth, String l, int pub, double p, boolean a, int s, String genre, int edition, boolean isPeerReviewed) {
        super(t, auth, l, pub, p, a, s, "Nonfiction");
        this.genre = genre;
        this.edition = edition;
        this.isPeerReviewed = isPeerReviewed;
    }

    //genre getter/setters
    public String getGenre() {
        return genre;
    }


    public void setGenre(String genre) {
        this.genre = genre;
    }

    // edition getter/setter
    public int getEdition() {
        return edition;
    }

   
    public void setEdition(int edition) {
        if (edition > 0) { 
            this.edition = edition;
        } else {
            throw new IllegalArgumentException("Edition must be a positive number.");
        }
    }

    //isPeerReviewed getter/setter
    public boolean isPeerReviewed() {
        return isPeerReviewed;
    }

  
    public void setPeerReviewed(boolean isPeerReviewed) {
        this.isPeerReviewed = isPeerReviewed;
    }

    
    @Override
    public String toString() { //Does anyone know how to do the tab notation rather than me just putting whitespace
        return super.toString() 
                + "      Genre: " + genre + "\n" 
                + "      Edition: " + edition + "\n"
                + "      Peer Reviewed: " + (isPeerReviewed ? "Yes" : "No") + "\n"; 
    }
}
