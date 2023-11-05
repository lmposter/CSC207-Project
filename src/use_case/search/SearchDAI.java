package use_case.search;

import entity.Product;

import java.util.ArrayList;

public interface SearchDAI {
    int numItemsFound(String content);

    ArrayList<Product> getItems(String content);

    void save(Product product);
}
