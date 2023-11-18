package entity;

import java.util.ArrayList;

public class ProductFactory {
    public ProductFactory(){}
    public Product create(String title, String url, double price, int inventory, ArrayList<Tag> tags) {

        return new Product(title, url, price, inventory, tags);
    }
}