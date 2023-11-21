package entity;

import java.util.ArrayList;

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

    public static String printReviews(ArrayList<Review> reviewList){
        String r = "";
        for (Review review: reviewList){
            r = r.concat(String.valueOf(review.stars)).concat(":\n").concat(review.comment).concat("\n");
        }
        return r;
    }
}
