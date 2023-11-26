package entity;

import java.util.UUID;

/**
 * The Buyer class represents a buyer user in the system.
 * Buyers are users with login credentials.
 */
public class Buyer implements LoginUser{

    /**
     * Unique identifier for the buyer.
     */
    private final String id;

    /**
     * Name of the buyer.
     */
    private String name;

    /**
     * Password of the buyer.
     */
    private String password;

    /**
     * Shopping Cart of the buyer.
     */
    private ShoppingCart cart;

    /**
     * Default constructor for creating a Buyer.
     * Generates a unique ID for the buyer and sets a default name.
     */
    public Buyer(String name, String password) {
        this.id = "B" + UUID.randomUUID().toString();
        this.name = name;
        this.password = password;
        this.cart = new ShoppingCart();
    }

    public Buyer(String name, String password, String id, ShoppingCart cart) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.cart = cart;
    }

    /**
     * Set the name for the buyer.
     * The implementation of this method allows buyers to change their name.
     */
    @Override
    public void setName(String name) {
        this.name = name;
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
     * Get the name of the buyer.
     *
     * @return The buyer's name.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Get the unique identifier of the buyer.
     *
     * @return The buyer's ID.
     */
    @Override
    public String getId() {
        return id;
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

    /**
     * Add a product to the user's shopping cart
     * @param product
     */
    public void addProduct(Product product)
    {
        this.cart.addProduct(product);
    }

    /**
     * Remove a product from the shopping cart
     * @param product
     */
    public void removeProduct(Product product)
    {
        this.cart.removeProduct(product);
    }

    /**
     *
     * @return the user's shopping cart
     */
    public ShoppingCart getCart()
    {
        return this.cart;
    }
}
