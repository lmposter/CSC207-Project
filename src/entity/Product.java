package entity;

import java.util.ArrayList;
import java.util.UUID;

public class Product {
    private String id;
    private String title;
    private String photoURL;
    private double price;
    private int inventory;
    private ArrayList<Tag> tags;
    private ArrayList<Review> reviews;

    Product(String title, String photoURL, double price, int inventory, ArrayList<Tag> tags){
        this.id = "Pd" + UUID.randomUUID().toString();
        this.title = title;
        this.photoURL = photoURL;
        this.price = price;
        this.inventory = inventory;
        this.tags = tags;
        this.reviews = new ArrayList<>();

    }
    public String getId()
    {
        return id;
    }
    public void setID(String newID){id = newID;}
    public String getTitle(){
        return title;
    }
    protected void updateTitle(String newTitle){
        title = newTitle;
    }
    public String getURL(){
        return photoURL;
    }
    protected void updatePhoto(String URL){
        photoURL = URL;
    }
    public double getPrice(){
        return price;
    }
    protected void updatePrice(double newPrice){
        price = newPrice;
    }
    public int getInventory(){
        return inventory;
    }

    public void setInventory(int newNum){
        inventory = newNum;
    };

    public ArrayList<Tag> getTags(){
        return tags;
    }

    protected void updateTags(ArrayList<Tag> newTags){
        this.tags = newTags;
    }
    public void addReview(Review review){
        this.reviews.add(review);
    }

    public ArrayList<Review> getReview(){
        return reviews;
    }


    public String getID() { return id;
    }
}