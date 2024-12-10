public class Fiction extends Book {
    protected boolean bestseller; //true/false
    protected String genre; //sci-fi, horror
    protected String ageGroup; // target age of readers

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
    //Fiction specific target audience 
    @Override
    public String getTargetAudience() {
        return "Target Audience: Readers " + ageGroup + " years old who enjoy " + genre + " fiction.";
    }

    @Override
    public String toString() {
        return super.toString() + "\nGenre: " + genre + "\nBestseller: " + (bestseller ? "Yes" : "No") + "\n" + getTargetAudience();
    }
}
