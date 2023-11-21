package interface_adapter.product;

import entity.Review;

import java.util.ArrayList;

public class ProductState {
    private String pdID = "";
    private String pdIDError = null;
    private String photoURL;
    private String title;
    private double price;
    private int inventory;
    private ArrayList<Review> reviews;

    public ProductState(String id, String url, String title, double price, int inventory, ArrayList<Review> reviews){
        this.pdID = id;
        this.pdIDError = null;
        this.photoURL = url;
        this.title = title;
        this.price = price;
        this.inventory = inventory;
        this.reviews = reviews;
    }

    public ProductState(){}
    public String getID() {return pdID;}
    public void setID(String ID) {this.pdID = ID;}
    public void setIDError(String IDError) {
        this.pdIDError = IDError;
    }
    public String getPdIDError(){
        return pdIDError;
    }
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public String getURL() {return photoURL;}
    public void setURL(String url) {this.photoURL = url;}
    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}
    public int getInventory(){return inventory;}
    public void setInventory(int inv) {this.inventory = inv;}
    public ArrayList<Review> getReviews(){
        return reviews;
    }
    public void setReviews(ArrayList<Review> reviews) {this.reviews = reviews;}

}
