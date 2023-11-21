package entity;
import java.util.HashMap;

import java.util.*;

public class ShoppingCart {

    private HashMap<Product, Integer> cart;
    // Map a product to its number in the cart
    private double price;
    // keep track of total price

    public ShoppingCart()
    {
        // need to shadow copy the object
        this.cart = new HashMap<>();
        this.price = 0;
    }

    /**
     *
     * @param product
     * @return if there is such product in cart
     */
    private boolean contains(Product product)
    {
        for (Product i : cart.keySet())
        {
            if (i.getId().equals(product.getId()))
                return true;
        }
        return false;
    }

    /**
     *
     * @return the total price of all product in the cart
     */
    public double getPrice() {
        return price;
    }

    /**
     * Add a product to the cart
     * @param product
     */
    public void addProduct(Product product)
    {
        price += product.getPrice();
        if (this.contains(product))
            cart.put(product, cart.get(product) + 1);
        else
            cart.put(product, 1);
    }

    /**
     *
     * @param product
     * @return the number of such product in cart
     */
    public int getProductQuantity(Product product)
    {
        if (!this.contains(product))
            throw new NoSuchElementException();
        else
            return cart.get(product);
    }

    /**
     * Remove a product from the shopping cart
     * Raise an exception if there is no such product
     * @param product
     */
    public void removeProduct(Product product)
    {
        if (!this.contains(product))
            throw new NoSuchElementException();
        cart.put(product, cart.get(product) - 1);
        price -= product.getPrice();
        if (cart.get(product) <= 0)
            cart.remove(product);
    }

    /**
     * Clear the shopping cart
     */
    public void clearCart()
    {
        cart.clear();
        price = 0.0;
    }

    /**
     *
     * @return if there is enough products in stock
     */
    public boolean inStock()
    {
        for (Product i : cart.keySet())
        {
            if(cart.get(i) > i.getInventory())
                return false;
        }
        return true
    }
}


