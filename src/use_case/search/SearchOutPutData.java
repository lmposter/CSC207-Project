package use_case.search;

import entity.Product;

import java.util.ArrayList;

public class SearchOutPutData {


    private final ArrayList<Product> productsList;
    private final boolean useCaseFailed;

    public SearchOutPutData(ArrayList<Product> productsList, boolean useCaseFailed) {
        this.productsList = productsList;
        this.useCaseFailed = useCaseFailed;

    }
    public ArrayList<Product> getProducts(){return productsList;}

}
