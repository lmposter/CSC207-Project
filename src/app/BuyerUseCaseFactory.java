package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.buyerPage.BuyerController;
import interface_adapter.buyerPage.BuyerPresenter;
import interface_adapter.buyerPage.BuyerViewModel;
import interface_adapter.guestPage.GuestController;
import interface_adapter.guestPage.GuestPresenter;
import interface_adapter.guestPage.GuestViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.orders.Orders;
import interface_adapter.search.SearchViewModel;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.store_page.StorePageViewModel;
import use_case.buyerPage.BuyerDataAccessInterface;
import use_case.buyerPage.BuyerInputBoundary;
import use_case.buyerPage.BuyerInteractor;
import use_case.buyerPage.BuyerOutputBoundary;
import use_case.guestPage.GuestInputBoundary;
import use_case.guestPage.GuestInteractor;
import use_case.guestPage.GuestOutputBoundary;
import use_case.guestPage.GuestUserDataAccessInterface;
import view.BuyerView;
import view.GuestView;

import javax.swing.*;
import java.io.IOException;

public class BuyerUseCaseFactory {

    /** Prevent instantiation. */
    private BuyerUseCaseFactory() {}

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
            BuyerController buyerController = createLoginUseCase(viewManagerModel, loginViewModel, signupViewModel, buyerViewModel, searchViewModel, orderViewModel, shoppingCartViewModel, storePageViewModel, userDataAccessObject);
            return new BuyerView(buyerViewModel, buyerController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static BuyerController createLoginUseCase(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            SignupViewModel signupViewModel,
            BuyerViewModel buyerViewModel,
            SearchViewModel searchViewModel,
            Orders orderViewModel,
            ShoppingCartViewModel shoppingCartViewModel,
            StorePageViewModel storePageViewModel,
            BuyerDataAccessInterface userDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        BuyerOutputBoundary buyerOutputBoundary = new BuyerPresenter(signupViewModel, viewManagerModel, buyerViewModel, loginViewModel, searchViewModel, orderViewModel, shoppingCartViewModel, storePageViewModel);


        BuyerInputBoundary buyerInteractor = new BuyerInteractor(
                userDataAccessObject, buyerOutputBoundary);

        return new BuyerController(buyerInteractor);
    }
}
