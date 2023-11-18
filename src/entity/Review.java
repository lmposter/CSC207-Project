package entity;

public class Review {
    private final String comment;
    private final int stars;
    public Review(int stars, String comment){
        this.stars = stars;
        this.comment = comment;
    }

    public int getStars(){
        return stars;
    }
    public String getComment(){
        return comment;
    }
}
