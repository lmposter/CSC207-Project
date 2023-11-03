package entity;

import java.util.UUID;

/**
 * The Buyer class represents a buyer user in the system.
 * Buyers are users with login credentials.
 */
public class Seller implements User, LoginUser {

    /**
     * Unique identifier for the buyer.
     */
    private final String buyerId;

    /**
     * Name of the buyer.
     */
    private String buyerName;

    /**
     * Password of the buyer.
     */
    private String password;

    /**
     * Default constructor for creating a Buyer.
     * Generates a unique ID for the buyer and sets a default name.
     */
    public Seller(String name, String password) {
        this.buyerId = "S" + UUID.randomUUID().toString();
        this.buyerName = name;
        this.password = password;
    }

    /**
     * Set the name for the buyer.
     * The implementation of this method allows buyers to change their name.
     */
    @Override
    public void setName(String name) {
        this.buyerName = name;
    }

    /**
     * Set the password for the buyer.
     * The implementation of this method allows buyers to set or change their password.
     */
    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the unique identifier of the buyer.
     *
     * @return The buyer's ID.
     */
    @Override
    public String getId() {
        return buyerId;
    }

    /**
     * Get the name of the buyer.
     *
     * @return The buyer's name.
     */
    @Override
    public String getName() {
        return buyerName;
    }

    /**
     * Get the password of the buyer.
     *
     * @return The buyer's password.
     */
    @Override
    public String getPassword() {
        return password;
    }
}
