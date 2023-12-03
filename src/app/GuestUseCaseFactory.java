package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.guestPage.GuestController;
import interface_adapter.guestPage.GuestPresenter;
import interface_adapter.guestPage.GuestViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.orders.Orders;
import interface_adapter.search.SearchViewModel;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.store_page.StorePageViewModel;
import use_case.guestPage.GuestInputBoundary;
import use_case.guestPage.GuestInteractor;
import use_case.guestPage.GuestOutputBoundary;
import use_case.guestPage.GuestUserDataAccessInterface;
import view.GuestView;

import javax.swing.*;
import java.io.IOException;

public class GuestUseCaseFactory {

    /** Prevent instantiation. */
    private GuestUseCaseFactory() {}

    public static GuestView create(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            SignupViewModel signupViewModel,
            GuestViewModel guestViewModel,
            SearchViewModel searchViewModel,
            Orders orderViewModel,
            ShoppingCartViewModel shoppingCartViewModel,
            StorePageViewModel storePageViewModel,
            GuestUserDataAccessInterface userDataAccessObject) {

        try {
            GuestController guestController = createLoginUseCase(viewManagerModel, loginViewModel, signupViewModel, guestViewModel, userDataAccessObject, searchViewModel);
            return new GuestView(guestViewModel, guestController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static GuestController createLoginUseCase(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            SignupViewModel signupViewModel,
            GuestViewModel guestViewModel,
            GuestUserDataAccessInterface userDataAccessObject,
            SearchViewModel searchViewModel) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        GuestOutputBoundary guestOutputBoundary = new GuestPresenter(signupViewModel, viewManagerModel, guestViewModel, loginViewModel, searchViewModel);


        GuestInputBoundary guestInteractor = new GuestInteractor(
                userDataAccessObject, guestOutputBoundary);

        return new GuestController(guestInteractor);
    }
}
