package use_case.storePage;

import data_access.ProductDAO;
import entity.LoginUser;
import entity.Product;
import entity.Seller;
import use_case.login.LoginUserDataAccessInterface;

import java.util.List;


public class StorePageInteractor implements StorePageInputBoundary {

    private ProductDAO productDAO;
    private LoginUserDataAccessInterface loginUserDataAccessInterface;



    public StorePageInteractor(ProductDAO productDAO,
                               LoginUserDataAccessInterface loginUserDataAccessInterface) {
        this.productDAO = productDAO;
        this.loginUserDataAccessInterface = loginUserDataAccessInterface;
    }
    @Override
    public LoginUser get(String username) {
        return loginUserDataAccessInterface.get(username);
    }

    public List<Product> findProducts(String username){
        return productDAO.findProducts(username);
    }

    public ProductDAO getDAO(){
        return this.productDAO;
    }
}
