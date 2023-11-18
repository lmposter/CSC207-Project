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
    private Review[] reviews;

    public ProductState(ProductState copy){
        this.pdID = copy.pdID;
        this.pdIDError = copy.pdIDError;
        this.photoURL = copy.photoURL;
        this.title = copy.title;
        this.price = copy.price;
        this.inventory = copy.inventory;
        this.reviews = copy.reviews;
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
    public String getURL() {return photoURL;}
    public double getPrice() {return price;}
    public int getInventory(){return inventory;}
    public Review[] getReviews(){
        return reviews;
    }

}
