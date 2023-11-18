package use_case.productDetails;

import entity.Product;
import entity.Review;

import java.util.ArrayList;

public class ProductOutputData {
    private String photoURL;
    private String title;
    private double price;
    private int inventory;
    private ArrayList<Review> reviews;
    private String pdID;

    public ProductOutputData(Product pd){
        this.photoURL = pd.getURL();
        this.title = pd.getTitle();
        this.price = pd.getPrice();
        this.inventory = pd.getInventory();
        this.reviews = pd.getReview();
        this.pdID = pd.getId();
    }

    public String getTitle() {return title;}
    public String getPhotoURL() {return photoURL;}
    public double getPrice() {return price;}
    public int getInventory(){return inventory;}
    public String getPdID(){return pdID;}

    public ArrayList<Review> getReviews() {
        return reviews;
    }
}
