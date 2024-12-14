public class Fiction extends Book {
    protected boolean bestseller; //true/false
    protected String genre; //sci-fi, horror
    protected String ageGroup; // target age of readers
    
    //Constructor to initialize a Fiction book with all necessary attributes
    public Fiction(String t, String auth, String l, int pub, double p, boolean a, int s, String genre, boolean bestseller, String ageGroup) {
        super(t, auth, l, pub, p, a, s, "Fiction");
        this.genre = genre;
        this.bestseller = bestseller;
        this.ageGroup = ageGroup;
    }

    //Getter method to retrieve the bestseller status of the Fiction book
    public boolean isBestseller() {
        return bestseller;
    }

    //Setter method to update the bestseller status of the Fiction book
    public void setBestseller(boolean bestseller) {
        this.bestseller = bestseller;
    }

    //Getter method to retrieve the genre of the Fiction book
    public String getGenre() {
        return genre;
    }

    // Setter method to update the genre of the fiction book
    public void setGenre(String genre) {
        this.genre = genre;
    }

    //Getter method to retrieve the target age group for the fiction book's readers
    public String getAgeGroup() {
        return ageGroup;
    }

    //Setter method to update the target age group for the fiction book's readers
    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }
    //Overrides the getTargetAudience method from the Book class to provide fiction-specific audience details
    @Override
    public String getTargetAudience() {
        return "Target Audience: Readers " + ageGroup + " years old who enjoy " + genre + " fiction.";
    }

    //Overrides the toString method to include fiction-specific details along with the common book information
    @Override
    public String toString() {
        return super.toString() + "\nGenre: " + genre + "\nBestseller: " + (bestseller ? "Yes" : "No") + "\n" + getTargetAudience();
    }
}
