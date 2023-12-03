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

/**
 * The GuestUseCaseFactory class is responsible for creating and setting up the components required for the guest user case.
 */
public class GuestUseCaseFactory {

    /** Prevent instantiation. */
    private GuestUseCaseFactory() {}

    /**
     * Creates a GuestView for the guest user case with the provided components and configurations.
     *
     * @param viewManagerModel        The ViewManagerModel to manage views.
     * @param loginViewModel          The LoginViewModel for the login functionality.
     * @param signupViewModel         The SignupViewModel for the signup functionality.
     * @param guestViewModel          The GuestViewModel for the guest functionality.
     * @param searchViewModel         The SearchViewModel for searching items.
     * @param orderViewModel          The Orders for managing orders.
     * @param shoppingCartViewModel   The ShoppingCartViewModel for managing shopping cart.
     * @param storePageViewModel      The StorePageViewModel for store page.
     * @param userDataAccessObject    The data access object for user data.
     * @return                        A GuestView instance for the guest user case.
     */
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
            // Create the GuestController and pass it to the GuestView
            GuestController guestController = createGuestUseCase(
                    viewManagerModel, loginViewModel, signupViewModel, guestViewModel,
                    userDataAccessObject, searchViewModel);

            return new GuestView(guestViewModel, guestController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    /**
     * Creates the GuestController and sets up the necessary interactions.
     *
     * @param viewManagerModel        The ViewManagerModel to manage views.
     * @param loginViewModel          The LoginViewModel for the login functionality.
     * @param signupViewModel         The SignupViewModel for the signup functionality.
     * @param guestViewModel          The GuestViewModel for the guest functionality.
     * @param userDataAccessObject    The data access object for user data.
     * @param searchViewModel         The SearchViewModel for searching items.
     * @return                        A GuestController instance for the guest user case.
     * @throws IOException            If there is an issue with the data access object.
     */
    private static GuestController createGuestUseCase(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            SignupViewModel signupViewModel,
            GuestViewModel guestViewModel,
            GuestUserDataAccessInterface userDataAccessObject,
            SearchViewModel searchViewModel) throws IOException {

        // Create the GuestPresenter and pass it to the GuestController
        GuestOutputBoundary guestOutputBoundary = new GuestPresenter(
                signupViewModel, viewManagerModel, guestViewModel, loginViewModel, searchViewModel);

        // Create the GuestInteractor and pass it to the GuestController
        GuestInputBoundary guestInteractor = new GuestInteractor(
                userDataAccessObject, guestOutputBoundary);

        return new GuestController(guestInteractor);
    }
}