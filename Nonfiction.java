public class Nonfiction extends Book {

    protected String genre; // History, science, biography, etc.
    protected int edition; // Edition of the book
    protected boolean isPeerReviewed; // Whether the book is peer-reviewed

    public Nonfiction(String t, String auth, String l, int pub, double p, boolean a, int s, String genre, int edition, boolean isPeerReviewed) {
        super(t, auth, l, pub, p, a, s, "Nonfiction");
        this.genre = genre;
        this.edition = edition;
        this.isPeerReviewed = isPeerReviewed;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

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

    public boolean isPeerReviewed() {
        return isPeerReviewed;
    }

    public void setPeerReviewed(boolean isPeerReviewed) {
        this.isPeerReviewed = isPeerReviewed;
    }

    
    @Override
    public String getDetails() {
        return "Nonfiction Genre: " + genre + ", Edition: " + edition + 
               ", Peer Reviewed: " + (isPeerReviewed ? "Yes" : "No");
    }

    @Override
    public String toString() {
        return super.toString() 
                + "      Genre: " + genre + "\n" 
                + "      Edition: " + edition + "\n"
                + "      Peer Reviewed: " + (isPeerReviewed ? "Yes" : "No") + "\n";
    }
}
