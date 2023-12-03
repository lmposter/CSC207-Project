package use_case.productDetails;

import entity.Product;

public interface ProductDetailsDAI {

    boolean productExists(String PdID);

    Product getPd(String PdID);

    void buyProduct(String name, String id, String title, Double price);
}
