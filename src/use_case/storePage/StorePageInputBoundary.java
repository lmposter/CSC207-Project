package use_case.storePage;

import data_access.ProductDAO;
import entity.LoginUser;
import entity.Product;
import entity.Seller;
import use_case.signup.SignUpUserInputData;

import java.util.List;

public interface StorePageInputBoundary {

    LoginUser get(String username);

    List<Product> findProducts(String username);

    ProductDAO getDAO();

}
