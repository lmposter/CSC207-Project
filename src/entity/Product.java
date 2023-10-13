package entity;

import java.util.ArrayList;

class Product {
    private final String id;
    private String title;
    private String photoURL;
    private double price;
    private int inventory;
    private ArrayList<Tag> tags;
    private ArrayList<Review> reviews;

    Product(String title, String photoURL, double price, int inventory, ArrayList<Tag> tags){
        this.id = new ID(15).getID();
        this.title = title;
        this.photoURL = photoURL;
        this.price = price;
        this.inventory = inventory;
        this.tags = tags;
        this.reviews = new ArrayList<>();

    }
    public String getTitle(){
        return title
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

    public int setInventory(int newNum){
        inventory = newNum;
    }
    public void updateInventory(int numBought){
        inventory -= numBought;
        if (inventory <= 0){
            throw InventoryError; // TODO: handle inventory error and create exception class
        }
    }

    protected ArrayList<Tag> getTags(){
        return tags;
    }

    protected void updateTags(ArrayList<Tag> newTags){
        this.tags = newTags;
    }
    protected void addReview(Review review){
        this.reviews.add(review);
    }

    public ArrayList<Review> getReview(){
        return reviews;
    }







}