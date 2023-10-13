package entity;

class Review {
    private final String comment;
    private final int stars;
    Review(int stars, String comment){
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
