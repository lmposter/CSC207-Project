package entity;
import java.util.HashMap;

import java.util.*;
import java.util.function.Consumer;

public class ShoppingCart // implements Iterable<Product>
{

    private HashMap<Product, Integer> cart;
    // Map a product to its number in the cart

    public ShoppingCart()
    {
        // need to shadow copy the object
        this.cart = new HashMap<>();
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
    public double getPrice()
    {
        double price = 0.0;
        for(Product i : cart.keySet())
        {
            price += cart.get(i) * i.getPrice();
        }
        return price;
    }

    /**
     * Add a product to the cart
     * @param product
     */
    public void addProduct(Product product)
    {
        if (this.contains(product))
            cart.put(product, cart.get(product) + 1);
        else
            cart.put(product, 1);
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
        if (cart.get(product) <= 0)
            cart.remove(product);
    }

    public HashMap<Product, Integer> getCart()
    {
        return (HashMap<Product, Integer>) this.cart.clone();
    }

//    @Override
//    public Iterator<Product> iterator()
//    {
//        return new Iter();
//    }
//
//    private class Iter implements Iterator<Product>
//    {
//        int cursor = 0;
//
//        @Override
//        public boolean hasNext()
//        {
//            return cursor != cart.size();
//        }
//
//        @Override
//        public Product next()
//        {
//
//        }
//    }
}


