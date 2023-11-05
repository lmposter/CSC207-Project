package entity;

import java.util.UUID;

/**
 * The seller class represents a seller user in the system.
 * sellers are users with login credentials.
 */

public class Seller implements User, LoginUser {


    /**
     * Unique identifier for the seller.
     */
    private final String sellerId;

    /**
     * Name of the seller.
     */
    private String sellerName;

    /**
     * Password of the seller.
     */
    private String password;

    /**
     * Default constructor for creating a seller.
     * Generates a unique ID for the seller and sets a default name.
     */
    public Seller(String name, String password) {
        this.sellerId = "S" + UUID.randomUUID().toString();
        this.sellerName = name;
        this.password = password;
    }

    /**
     * Set the name for the seller.
     * The implementation of this method allows sellers to change their name.
     */
    @Override
    public void setName(String name) {
        this.sellerName = name;
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
        return sellerId;
    }
  
    /**
     * Get the name of the seller.
     *
     * @return The seller's name.
     */
    @Override
    public String getName() {
        return sellerName;
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
}
