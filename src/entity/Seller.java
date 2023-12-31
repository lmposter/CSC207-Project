package entity;

import java.util.UUID;
import java.util.ArrayList;

/**
 * The seller class represents a seller user in the system.
 * sellers are users with login credentials.
 */

public class Seller implements LoginUser {


    /**
     * Unique identifier for the seller.
     */
    private final String id;
    private ArrayList<Product> products;

    /**
     * Name of the seller.
     */
    private String name;

    /**
     * Password of the seller.
     */
    private String password;

    /**
     * Default constructor for creating a seller.
     * Generates a unique ID for the seller and sets a default name.
     */
    public Seller(String name, String password) {
        this.id = "S" + UUID.randomUUID().toString();
        this.name = name;
        this.password = password;
        this.products = new ArrayList<>();
    }

    public Seller(String name, String password, String id) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.products = new ArrayList<>();
    }
    /**
     * Set the name for the seller.
     * The implementation of this method allows sellers to change their name.
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the password for the seller.
     * The implementation of this method allows sellers to set or change their password.
     */
    @Override
    public void setPassword(String password) {
        this.password = password;
    }
  
    /**
     * Get the unique identifier of the seller.
     *
     * @return The seller's ID.
     */
    @Override
    public String getId() {
        return id;
    }
  
    /**
     * Get the name of the seller.
     *
     * @return The seller's name.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Get the password of the seller.
     *
     * @return The seller's password.
     */
    @Override
    public String getPassword() {
        return password;
    }

    public void addProduct(Product pd){products.add(pd);}

    public ArrayList<Product> getProducts(){return products;}

    public void deletePd(Product pd){products.remove(pd);}
}
