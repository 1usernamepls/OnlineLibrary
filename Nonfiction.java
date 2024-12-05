public class Nonfiction extends Book {

    protected String genre; // "History," "Science," "Biography," etc.
    protected int edition; // Edition of the book

    public Nonfiction(String t, String auth, String l, int pub, double p, boolean a, int s, String genre, int edition) {
        super(t, auth, l, pub, p, a, s, "Nonfiction");
        this.genre = genre;
        this.edition = edition;
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
        if (edition > 0) { // Ensure the edition is valid
            this.edition = edition;
        } else {
            throw new IllegalArgumentException("Edition must be a positive number.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "      Genre: " + genre + "\n      Edition: " + edition + "\n";
    }
}
