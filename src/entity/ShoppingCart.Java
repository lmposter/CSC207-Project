package entity;

import java.util.*;

public class ShoppingCart {

    private ArrayList<Product> cartList;
    private double price;

    public ShoppingCart(ArrayList<Product> cartList, double price) {
        // need to shadow copy the object
        this.cartList = new ArrayList<>(cartList);

        // iterate through cartList to calculate total price
        double temp = 0.0;
        for (int i = 0; i < cartList.size(); i++) {
            temp += cartList.get(i).getPrice();
        }
        this.price = temp;
    }

    public double getTotalPrice() {
        return this.price;
    }
}
