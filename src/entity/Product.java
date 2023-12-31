package entity;

import java.util.ArrayList;
import java.util.UUID;

public class Product
{
    private String id;
    private String title;
    private String photoURL;
    private double price;
    private int inventory;
    private ArrayList<Review> reviews;

    public Product(String title, String photoURL, double price, int inventory)
    {
        this.id = "Pd" + UUID.randomUUID().toString();
        this.title = title;
        this.photoURL = photoURL;
        this.price = price;
        this.inventory = inventory;
        this.reviews = new ArrayList<>();

    }

    public String getId()
    {
        return id;
    }

    public void setID(String newID){id = newID;}

    public String getTitle()
    {
        return title;
    }

    public void updateTitle(String newTitle)
    {
        title = newTitle;
    }

    public String getURL()
    {
        return photoURL;
    }

    public void updatePhoto(String URL)
    {
        photoURL = URL;
    }

    public double getPrice()
    {
        return price;
    }

    public void updatePrice(double newPrice)
    {
        price = newPrice;
    }

    public int getInventory()
    {
        return inventory;
    }

    public void setInventory(int newNum)
    {
        inventory = newNum;
    }

    ;

    public void addReview(Review review)
    {
        this.reviews.add(review);
    }

    public ArrayList<Review> getReview()
    {
        return reviews;
    }


    public String getID()
    {
        return id;
    }

    public String getPhotoURL() {
        return photoURL;
    }

}