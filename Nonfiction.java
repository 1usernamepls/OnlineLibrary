public class Nonfiction extends Book {
    protected String genre; //bibliography, literature review, historical, etc
    protected int edition;
    protected boolean isPeerReviewed; // true/false
    protected String topic;

    //Constructor to initialize a Nonfiction book with all the necessary attributes
    public Nonfiction(String t, String auth, String l, int pub, double p, boolean a, int s, String genre, int edition, boolean isPeerReviewed, String topic) {
        super(t, auth, l, pub, p, a, s, "Nonfiction");
        this.genre = genre;
        this.edition = edition;
        this.isPeerReviewed = isPeerReviewed;
        this.topic = topic;
    }

    //Getter method to retrieve the genre of the Nonfiction book
    public String getGenre() {
        return genre;
    }

    //Setter method to update the genre of the Nonfiction book
    public void setGenre(String genre) {
        this.genre = genre;
    }

    //Getter method to retrieve the edition of the Nonfiction book
    public int getEdition() {
        return edition;
    }

    //Setter method to update the edition number of the Nonfiction book
    public void setEdition(int edition) {
        if (edition > 0) { //Ensures that the edition is a positive number
            this.edition = edition;
        } else {
            throw new IllegalArgumentException("Edition must be a positive number.");
        }
    }

    //Getter method to retrieve the peer review status of the Nonfiction book
    public boolean isPeerReviewed() {
        return isPeerReviewed;
    }

    //Setter method to update the peer review status of the Nonfiction book
    public void setPeerReviewed(boolean isPeerReviewed) {
        this.isPeerReviewed = isPeerReviewed;
    }

    //Getter method to retrieve the topic of the Nonfiction book
    public String getTopic() {
        return topic;
    }

    //Setter method to update the topic of the Nonfiction book
    public void setTopic(String t) {
        this.topic = t;
    }
    
    //Overrides the getTargetAudience method from the Book class to provide nonfiction-specific audience details
    @Override
    public String getTargetAudience() {
        return "Target Audience: Readers interested in " + topic + " (Peer Reviewed: " + (isPeerReviewed ? "Yes" : "No") + ").";
    }

    //Overrides the toString method to include nonfiction-specific details along with the common book information
    @Override
    public String toString() {
        return super.toString() + "\nGenre: " + genre + "\nEdition: " + edition + "\n" + getTargetAudience() + "\n";
    }
}
