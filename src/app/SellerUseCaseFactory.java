package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.orders.Orders;
import interface_adapter.search.SearchViewModel;
import interface_adapter.sellerPage.SellerController;
import interface_adapter.sellerPage.SellerPresenter;
import interface_adapter.sellerPage.SellerViewModel;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.store_page.StorePageViewModel;
import use_case.sellerPage.SellerDataAccessInterface;
import use_case.sellerPage.SellerInputBoundary;
import use_case.sellerPage.SellerInteractor;
import use_case.sellerPage.SellerOutputBoundary;
import view.SellerView;

import javax.swing.*;
import java.io.IOException;

/**
 * The SellerUseCaseFactory class is responsible for creating and initializing the components related to the seller use case.
 */
public class SellerUseCaseFactory {

    /** Prevent instantiation. */
    private SellerUseCaseFactory() {}

    /**
     * Creates a SellerView with the necessary components.
     *
     * @param viewManagerModel     The view manager model.
     * @param loginViewModel       The login view model.
     * @param signupViewModel      The signup view model.
     * @param sellerViewModel      The seller view model.
     * @param searchViewModel      The search view model.
     * @param orderViewModel       The orders view model.
     * @param shoppingCartViewModel The shopping cart view model.
     * @param storePageViewModel   The store page view model.
     * @param userDataAccessObject The data access object for the seller use case.
     * @return The initialized SellerView or null if there was an error.
     */
    public static SellerView create(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            SignupViewModel signupViewModel,
            SellerViewModel sellerViewModel,
            SearchViewModel searchViewModel,
            Orders orderViewModel,
            ShoppingCartViewModel shoppingCartViewModel,
            StorePageViewModel storePageViewModel,
            SellerDataAccessInterface userDataAccessObject) {

        try {
            SellerController sellerController = createLoginUseCase(viewManagerModel, loginViewModel, signupViewModel, sellerViewModel, searchViewModel, orderViewModel, shoppingCartViewModel, storePageViewModel, userDataAccessObject);
            return new SellerView(sellerViewModel, sellerController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static SellerController createLoginUseCase(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            SignupViewModel signupViewModel,
            SellerViewModel sellerViewModel,
            SearchViewModel searchViewModel,
            Orders orderViewModel,
            ShoppingCartViewModel shoppingCartViewModel,
            StorePageViewModel storePageViewModel,
            SellerDataAccessInterface userDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        SellerOutputBoundary buyerOutputBoundary = new SellerPresenter(signupViewModel, viewManagerModel, sellerViewModel, loginViewModel, searchViewModel, orderViewModel, shoppingCartViewModel, storePageViewModel);


        SellerInputBoundary buyerInteractor = new SellerInteractor(
                userDataAccessObject, buyerOutputBoundary);

        return new SellerController(buyerInteractor);
    }
}