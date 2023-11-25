package interface_adapter.shopping_cart;

import entity.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ShoppingCartState implements Iterable<Product>
{
    private ArrayList<Product> products;

    public ShoppingCartState(ArrayList<Product> productsList)
    {
        this.products = new ArrayList<>();
        this.products.addAll(productsList);
    }

    @Override
    public Iterator<Product> iterator()
    {
        return new Iter();
    }

    private class Iter implements Iterator<Product>
    {
        int cursor = 0;
        @Override
        public boolean hasNext()
        {
            return cursor != products.size();
        }

        @Override
        public Product next()
        {
            if (this.hasNext())
                return products.get(cursor++);
            else
                throw new NoSuchElementException();
        }
    }
}
