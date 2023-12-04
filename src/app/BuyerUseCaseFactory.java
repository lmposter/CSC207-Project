package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.AllUserPage.buyerPage.BuyerController;
import interface_adapter.AllUserPage.buyerPage.BuyerPresenter;
import interface_adapter.AllUserPage.buyerPage.BuyerViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.orders.Orders;
import interface_adapter.search.SearchViewModel;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.store_page.StorePageViewModel;
import use_case.allUser.buyerPage.BuyerDataAccessInterface;
import use_case.allUser.buyerPage.BuyerInputBoundary;
import use_case.allUser.buyerPage.BuyerInteractor;
import use_case.allUser.buyerPage.BuyerOutputBoundary;
import view.BuyerView;

import javax.swing.*;
import java.io.IOException;

/**
 * The BuyerUseCaseFactory class is responsible for creating and setting up the components required for the buyer user case.
 */
public class BuyerUseCaseFactory {

    /**
     * Prevent instantiation.
     */
    private BuyerUseCaseFactory() {
    }

    /**
     * Creates a BuyerView for the buyer user case with the provided components and configurations.
     *
     * @param viewManagerModel      The ViewManagerModel to manage views.
     * @param loginViewModel        The LoginViewModel for the login functionality.
     * @param signupViewModel       The SignupViewModel for the signup functionality.
     * @param buyerViewModel        The BuyerViewModel for the buyer functionality.
     * @param searchViewModel       The SearchViewModel for searching items.
     * @param orderViewModel        The Orders for managing orders.
     * @param shoppingCartViewModel The ShoppingCartViewModel for managing the shopping cart.
     * @param storePageViewModel    The StorePageViewModel for store page.
     * @param userDataAccessObject  The data access object for user data.
     * @return A BuyerView instance for the buyer user case.
     */
    public static BuyerView create(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            SignupViewModel signupViewModel,
            BuyerViewModel buyerViewModel,
            SearchViewModel searchViewModel,
            Orders orderViewModel,
            ShoppingCartViewModel shoppingCartViewModel,
            StorePageViewModel storePageViewModel,
            BuyerDataAccessInterface userDataAccessObject) {

        try {
            // Create the BuyerController and pass it to the BuyerView
            BuyerController buyerController = createBuyerUseCase(
                    viewManagerModel, loginViewModel, signupViewModel, buyerViewModel,
                    searchViewModel, orderViewModel, shoppingCartViewModel, storePageViewModel,
                    userDataAccessObject);

            return new BuyerView(buyerViewModel, buyerController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    /**
     * Creates the BuyerController and sets up the necessary interactions.
     *
     * @param viewManagerModel      The ViewManagerModel to manage views.
     * @param loginViewModel        The LoginViewModel for the login functionality.
     * @param signupViewModel       The SignupViewModel for the signup functionality.
     * @param buyerViewModel        The BuyerViewModel for the buyer functionality.
     * @param searchViewModel       The SearchViewModel for searching items.
     * @param orderViewModel        The Orders for managing orders.
     * @param shoppingCartViewModel The ShoppingCartViewModel for managing the shopping cart.
     * @param storePageViewModel    The StorePageViewModel for store page.
     * @param userDataAccessObject  The data access object for user data.
     * @return A BuyerController instance for the buyer user case.
     * @throws IOException If there is an issue with the data access object.
     */
    private static BuyerController createBuyerUseCase(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            SignupViewModel signupViewModel,
            BuyerViewModel buyerViewModel,
            SearchViewModel searchViewModel,
            Orders orderViewModel,
            ShoppingCartViewModel shoppingCartViewModel,
            StorePageViewModel storePageViewModel,
            BuyerDataAccessInterface userDataAccessObject) throws IOException {

        // Create the BuyerPresenter and pass it to the BuyerController
        BuyerOutputBoundary buyerOutputBoundary = new BuyerPresenter(
                signupViewModel, viewManagerModel, buyerViewModel, loginViewModel,
                searchViewModel, orderViewModel, shoppingCartViewModel, storePageViewModel);

        // Create the BuyerInteractor and pass it to the BuyerController
        BuyerInputBoundary buyerInteractor = new BuyerInteractor(
                userDataAccessObject, buyerOutputBoundary);

        return new BuyerController(buyerInteractor);
    }
}