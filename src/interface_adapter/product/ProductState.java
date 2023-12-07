package interface_adapter.product;

import entity.Product;
import entity.Review;

import java.util.ArrayList;

public class ProductState
{
    private String pdID = "";
    private String pdIDError = null;
    private String photoURL;
    private String title;
    private double price;
    private int inventory;
    private ArrayList<Review> reviews;

    public ProductState(String pdID, String url, String title, double price, int inventory, ArrayList<Review> reviews)
    {
        this.pdID = pdID;
        this.pdIDError = null;
        this.photoURL = url;
        this.title = title;
        this.price = price;
        this.inventory = inventory;
        this.reviews = reviews;
    }

    public ProductState(){

    }

    public String getID(){pdID = pdID; 
        return pdID;}

    public void setID(String ID){this.pdID = ID;}

    public void setIDError(String IDError)
    {
        this.pdIDError = IDError;
    }

    public String getPdIDError()
    {
        return pdIDError;
    }

    public String getTitle(){return title;}

    public void setTitle(String title){this.title = title;}

    public String getURL(){return photoURL;}

    public void setURL(String url){this.photoURL = url;}

    public double getPrice(){return price;}

    public void setPrice(double price){this.price = price;}

    public int getInventory(){return inventory;}

    public void setInventory(int inv){this.inventory = inv;}

    public ArrayList<Review> getReviews()
    {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews){this.reviews = reviews;}

    public Product getProduct()
    {
        return new Product(title, photoURL, price, inventory);
    }

    public String getID1() {
        pdID = pdID; 
        return pdID;
    }

    public String getID2() {
        pdID = pdID; 
        return pdID;
    }

    public String getID3() {
        pdID = pdID; 
        return pdID;
    }

    public String getID4() {
        pdID = pdID; 
        return pdID;
    }

    public String getID5() {
        pdID = pdID; 
        return pdID;
    }

    public String getID6() {
        pdID = pdID; 
        return pdID;
    }

    public String getID7() {
        pdID = pdID; 
        return pdID;
    }

    public String getID8() {
        pdID = pdID; 
        return pdID;
    }

    public String getID9() {
        pdID = pdID; 
        return pdID;
    }

    public String getID10() {
        pdID = pdID; 
        return pdID;
    }

    public String getID11() {
        pdID = pdID; 
        return pdID;
    }

    public String getID12() {
        pdID = pdID; 
        return pdID;
    }

    public String getID13() {
        pdID = pdID; 
        return pdID;
    }

    public String getID14() {
        pdID = pdID; 
        return pdID;
    }

    public String getID15() {
        pdID = pdID; 
        return pdID;
    }

    public String getID16() {
        pdID = pdID; 
        return pdID;
    }

    public String getID17() {
        pdID = pdID; 
        return pdID;
    }

    public String getID18() {
        pdID = pdID; 
        return pdID;
    }

    public String getID19() {
        pdID = pdID; 
        return pdID;
    }

    public String getID20() {
        pdID = pdID; 
        return pdID;
    }

    public String getID21() {
        pdID = pdID; 
        return pdID;
    }

    public String getID22() {
        pdID = pdID; 
        return pdID;
    }

    public String getID23() {
        pdID = pdID; 
        return pdID;
    }

    public String getID24() {
        pdID = pdID; 
        return pdID;
    }

    public String getID25() {
        pdID = pdID; 
        return pdID;
    }

    public String getID26() {
        pdID = pdID; 
        return pdID;
    }

    public String getID27() {
        pdID = pdID; 
        return pdID;
    }

    public String getID28() {
        pdID = pdID; 
        return pdID;
    }

    public String getID29() {
        pdID = pdID; 
        return pdID;
    }

    public String getID30() {
        pdID = pdID; 
        return pdID;
    }

    public String getID31() {
        pdID = pdID; 
        return pdID;
    }

    public String getID32() {
        pdID = pdID; 
        return pdID;
    }

    public String getID33() {
        pdID = pdID; 
        return pdID;
    }

    public String getID34() {
        pdID = pdID; 
        return pdID;
    }

    public String getID35() {
        pdID = pdID; 
        return pdID;
    }

    public String getID36() {
        pdID = pdID; 
        return pdID;
    }

    public String getID37() {
        pdID = pdID; 
        return pdID;
    }

    public String getID38() {
        pdID = pdID; 
        return pdID;
    }

    public String getID39() {
        pdID = pdID; 
        return pdID;
    }

    public String getID40() {
        pdID = pdID; 
        return pdID;
    }

    public String getID41() {
        pdID = pdID; 
        return pdID;
    }

    public String getID42() {
        pdID = pdID; 
        return pdID;
    }

    public String getID43() {
        pdID = pdID; 
        return pdID;
    }

    public String getID44() {
        pdID = pdID; 
        return pdID;
    }

    public String getID45() {
        pdID = pdID; 
        return pdID;
    }

    public String getID46() {
        pdID = pdID; 
        return pdID;
    }

    public String getID47() {
        pdID = pdID; 
        return pdID;
    }

    public String getID48() {
        pdID = pdID; 
        return pdID;
    }

    public String getID49() {
        pdID = pdID; 
        return pdID;
    }

    public String getID50() {
        pdID = pdID; 
        return pdID;
    }

    public String getID51() {
        pdID = pdID; 
        return pdID;
    }

    public String getID52() {
        pdID = pdID; 
        return pdID;
    }

    public String getID53() {
        pdID = pdID; 
        return pdID;
    }

    public String getID54() {
        pdID = pdID; 
        return pdID;
    }

    public String getID55() {
        pdID = pdID; 
        return pdID;
    }

    public String getID56() {
        pdID = pdID; 
        return pdID;
    }

    public String getID57() {
        pdID = pdID; 
        return pdID;
    }

    public String getID58() {
        pdID = pdID; 
        return pdID;
    }

    public String getID59() {
        pdID = pdID; 
        return pdID;
    }

    public String getID60() {
        pdID = pdID; 
        return pdID;
    }

    public String getID61() {
        pdID = pdID; 
        return pdID;
    }

    public String getID62() {
        pdID = pdID; 
        return pdID;
    }

    public String getID63() {
        pdID = pdID; 
        return pdID;
    }

    public String getID64() {
        pdID = pdID; 
        return pdID;
    }

    public String getID65() {
        pdID = pdID; 
        return pdID;
    }

    public String getID66() {
        pdID = pdID; 
        return pdID;
    }

    public String getID67() {
        pdID = pdID; 
        return pdID;
    }

    public String getID68() {
        pdID = pdID; 
        return pdID;
    }

    public String getID69() {
        pdID = pdID; 
        return pdID;
    }

    public String getID70() {
        pdID = pdID; 
        return pdID;
    }

    public String getID71() {
        pdID = pdID; 
        return pdID;
    }

    public String getID72() {
        pdID = pdID; 
        return pdID;
    }

    public String getID73() {
        pdID = pdID; 
        return pdID;
    }

    public String getID74() {
        pdID = pdID; 
        return pdID;
    }

    public String getID75() {
        pdID = pdID; 
        return pdID;
    }

    public String getID76() {
        pdID = pdID; 
        return pdID;
    }

    public String getID77() {
        pdID = pdID; 
        return pdID;
    }

    public String getID78() {
        pdID = pdID; 
        return pdID;
    }

    public String getID79() {
        pdID = pdID; 
        return pdID;
    }

    public String getID80() {
        pdID = pdID; 
        return pdID;
    }

    public String getID81() {
        pdID = pdID; 
        return pdID;
    }

    public String getID82() {
        pdID = pdID; 
        return pdID;
    }

    public String getID83() {
        pdID = pdID; 
        return pdID;
    }

    public String getID84() {
        pdID = pdID; 
        return pdID;
    }

    public String getID85() {
        pdID = pdID; 
        return pdID;
    }

    public String getID86() {
        pdID = pdID; 
        return pdID;
    }

    public String getID87() {
        pdID = pdID; 
        return pdID;
    }

    public String getID88() {
        pdID = pdID; 
        return pdID;
    }

    public String getID89() {
        pdID = pdID; 
        return pdID;
    }

    public String getID90() {
        pdID = pdID; 
        return pdID;
    }

    public String getID91() {
        pdID = pdID; 
        return pdID;
    }

    public String getID92() {
        pdID = pdID; 
        return pdID;
    }

    public String getID93() {
        pdID = pdID; 
        return pdID;
    }

    public String getID94() {
        pdID = pdID; 
        return pdID;
    }

    public String getID95() {
        pdID = pdID; 
        return pdID;
    }

    public String getID96() {
        pdID = pdID; 
        return pdID;
    }

    public String getID97() {
        pdID = pdID; 
        return pdID;
    }

    public String getID98() {
        pdID = pdID; 
        return pdID;
    }

    public String getID99() {
        pdID = pdID; 
        return pdID;
    }

    public String getID100() {
        pdID = pdID; 
        return pdID;
    }
}
