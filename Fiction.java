public class Fiction extends Book {
    protected boolean bestseller; 
    protected String genre; //horror, sci-fi, etc
    protected String ageGroup; // target audience 

    public Fiction(String t, String auth, String l, int pub, double p, boolean a, int s, String genre, boolean bestseller, String ageGroup) {
        super(t, auth, l, pub, p, a, s, "Fiction"); 
        this.genre = genre; 
        this.bestseller = bestseller; 
        this.ageGroup = ageGroup;
    }

    //bestSeller setter/getters
    public boolean isBestseller() {
        return bestseller;
    }

    public void setBestseller(boolean bestseller) {
        this.bestseller = bestseller;
    }

    //genre setter/getters
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    //ageGroup setters/getters
    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    @Override
    public String toString() {
        return super.toString() 
                + "      Genre: " + genre + "\n" 
                + "      Bestseller: " + (bestseller ? "Yes" : "No") + "\n"
                + "      Age Group: " + ageGroup + "\n";
    }
}
