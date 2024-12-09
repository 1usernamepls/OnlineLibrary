public class Fiction extends Book {
    protected boolean bestseller; 
    protected String genre; // Horror, sci-fi, etc.
    protected String ageGroup; // Target audience

    public Fiction(String t, String auth, String l, int pub, double p, boolean a, int s, String genre, boolean bestseller, String ageGroup) {
        super(t, auth, l, pub, p, a, s, "Fiction"); 
        this.genre = genre; 
        this.bestseller = bestseller; 
        this.ageGroup = ageGroup;
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

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    @Override
    public String getDetails() {
        return "Fiction Genre: " + genre + ", Bestseller: " + (bestseller ? "Yes" : "No") + 
               ", Target Age Group: " + ageGroup;
    }

    @Override
    public String toString() {
        return super.toString() 
                + "      Genre: " + genre + "\n" 
                + "      Bestseller: " + (bestseller ? "Yes" : "No") + "\n"
                + "      Age Group: " + ageGroup + "\n";
    }
}
