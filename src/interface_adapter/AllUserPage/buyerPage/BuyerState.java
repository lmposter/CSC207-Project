package interface_adapter.AllUserPage.buyerPage;

import entity.Product;
import entity.ShoppingCart;
import interface_adapter.AllUserPage.AllUserState;

import java.util.ArrayList;

/**
 * The SellerState class represents the state of the logged-in view.
 * It includes information such as the username of the logged-in user.
 */
public class BuyerState extends AllUserState {

    private ArrayList<Product> cart = new ArrayList<>();
    public BuyerState() {}

    public void addProduct(Product product)
    {
        this.cart.add(product);
    }

    public ArrayList<Product> getCart()
    {
        return cart;
    }
}