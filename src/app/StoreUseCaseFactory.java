package app;

import data_access.ProductDAO;
import interface_adapter.AllUserPage.guestPage.GuestViewModel;
import interface_adapter.AllUserPage.sellerPage.SellerViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.store_page.StorePageController;
import interface_adapter.store_page.StorePageViewModel;
import use_case.login.LoginUserDataAccessInterface;
import use_case.signup.SignUpUserDataAccessInterface;
import use_case.storePage.StorePageInteractor;
import view.OrderView;
import view.SignupView;
import view.StorePageView;

import javax.swing.*;
import java.io.IOException;

public class StoreUseCaseFactory {

    private StoreUseCaseFactory(){};

    public static StorePageView create(
            StorePageViewModel storePageViewModel, SellerViewModel sellerViewModel, ProductDAO productDAO, LoginUserDataAccessInterface userDataAccessObject) {
        StorePageController storePageController = new StorePageController(new StorePageInteractor(productDAO, userDataAccessObject));
        return new StorePageView(storePageViewModel, sellerViewModel, storePageController);

    }
}
