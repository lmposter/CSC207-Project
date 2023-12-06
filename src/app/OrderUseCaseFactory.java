package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.AllUserPage.buyerPage.BuyerController;
import interface_adapter.AllUserPage.buyerPage.BuyerPresenter;
import interface_adapter.AllUserPage.buyerPage.BuyerViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.orders.OrderController;
import interface_adapter.orders.OrderPresenter;
import interface_adapter.orders.OrderViewModel;
import interface_adapter.search.SearchViewModel;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.store_page.StorePageViewModel;
import use_case.allUser.buyerPage.BuyerDataAccessInterface;
import use_case.allUser.buyerPage.BuyerInputBoundary;
import use_case.allUser.buyerPage.BuyerInteractor;
import use_case.allUser.buyerPage.BuyerOutputBoundary;
import use_case.orders.OrderDAO;
import use_case.orders.OrderInputBoundary;
import use_case.orders.OrderInteractor;
import use_case.orders.OrderOutputBoundary;
import view.BuyerView;
import view.OrderView;

import javax.swing.*;
import java.io.IOException;

/**
 * The BuyerUseCaseFactory class is responsible for creating and setting up the components required for the buyer user case.
 */
public class OrderUseCaseFactory {

    /**
     * Prevent instantiation.
     */
    private OrderUseCaseFactory() {
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
    public static OrderView create(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            SignupViewModel signupViewModel,
            BuyerViewModel buyerViewModel,
            SearchViewModel searchViewModel,
            OrderViewModel orderViewModel,
            ShoppingCartViewModel shoppingCartViewModel,
            StorePageViewModel storePageViewModel,
            OrderDAO userDataAccessObject) {

        try {
            // Create the BuyerController and pass it to the BuyerView
            OrderController orderController = createOrderByUseCase(
                    viewManagerModel, loginViewModel, signupViewModel, buyerViewModel,
                    searchViewModel, orderViewModel, shoppingCartViewModel, storePageViewModel,
                    userDataAccessObject);

            return new OrderView(orderController, orderViewModel, false, searchViewModel);
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
    private static OrderController createOrderByUseCase(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            SignupViewModel signupViewModel,
            BuyerViewModel buyerViewModel,
            SearchViewModel searchViewModel,
            OrderViewModel orderViewModel,
            ShoppingCartViewModel shoppingCartViewModel,
            StorePageViewModel storePageViewModel,
            OrderDAO userDataAccessObject) throws IOException {

        // Create the BuyerPresenter and pass it to the BuyerController
        OrderOutputBoundary orderOutputBoundary = new OrderPresenter(
                viewManagerModel, buyerViewModel);

        // Create the BuyerInteractor and pass it to the BuyerController
        OrderInputBoundary orderinteractor = new OrderInteractor(
                userDataAccessObject, orderOutputBoundary);

        return new OrderController(orderinteractor);
    }
}