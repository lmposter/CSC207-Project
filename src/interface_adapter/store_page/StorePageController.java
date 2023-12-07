package interface_adapter.store_page;

import data_access.ProductDAO;
import entity.LoginUser;
import entity.Product;
import entity.Seller;
import use_case.storePage.StorePageInputBoundary;

import java.util.List;

public class StorePageController {
    private final StorePageInputBoundary storePageInteractor;

    public StorePageController(StorePageInputBoundary storePageInteractor)
    {
        this.storePageInteractor = storePageInteractor;
    }

    public LoginUser get(String username)
    {
        return storePageInteractor.get(username);
    }
    public List<Product> findProducts(String username)
    {
        return storePageInteractor.findProducts(username);
    }
    public ProductDAO getDAO(){
        return storePageInteractor.getDAO();
    }
}
