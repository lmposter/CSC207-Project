package entity;
import java.util.HashMap;

import java.util.*;

public class ShoppingCart {

    private HashMap<Product, Integer> cart;
    private double price;

    public ShoppingCart() {
        // need to shadow copy the object
        this.cart = new HashMap<>();
        this.price = 0;
    }

    private boolean contains(Product product)
    {
        for (Product i : cart.keySet())
        {
            if (i.getId().equals(product.getId()))
                return true;
        }
        return false;
    }

    public double getPrice() {
        return price;
    }

    public void addProduct(Product product)
    {
        price += product.getPrice();
        if (this.contains(product))
            cart.put(product, cart.get(product) + 1);
        else
            cart.put(product, 1);
    }

    public int getProductQuantity(Product product)
    {
        if (!this.contains(product))
            throw new NoSuchElementException();
        else
            return cart.get(product);
    }

    public void removeProduct(Product product)
    {
        if (!this.contains(product))
            throw new NoSuchElementException();
        cart.put(product, cart.get(product) - 1);
        price -= product.getPrice();
        if (cart.get(product) <= 0)
            cart.remove(product);
    }

    public void clearCart()
    {
        cart.clear();
        price = 0;
    }
}


