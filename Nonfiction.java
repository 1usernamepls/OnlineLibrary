public class Nonfiction extends Book {
    protected String genre; //bibliography, literature review, historical, etc
    protected int edition;
    protected boolean isPeerReviewed; // true/false
    protected String topic;

    public Nonfiction(String t, String auth, String l, int pub, double p, boolean a, int s, String genre, int edition, boolean isPeerReviewed, String topic) {
        super(t, auth, l, pub, p, a, s, "Nonfiction");
        this.genre = genre;
        this.edition = edition;
        this.isPeerReviewed = isPeerReviewed;
        this.topic = topic;
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

    public String getTopic() {
        return topic;
    }

    public void setTopic(String t) {
        this.topic = t;
    }
    
    //Nonfiction specific target audience 
    @Override
    public String getTargetAudience() {
        return "Target Audience: Readers interested in " + topic + " (Peer Reviewed: " + (isPeerReviewed ? "Yes" : "No") + ").";
    }

    @Override
    public String toString() {
        return super.toString() + "\nGenre: " + genre + "\nEdition: " + edition + "\n" + getTargetAudience() + "\n";
    }
}
