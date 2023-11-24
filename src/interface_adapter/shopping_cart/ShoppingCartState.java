package interface_adapter.shopping_cart;

import java.util.ArrayList;

public class ShoppingCartState
{
    private ArrayList<String> products;

    public ShoppingCartState(ArrayList<String> productsList)
    {
        this.products = new ArrayList<>();
        this.products.addAll(productsList);
    }
}
